/**
 * Opensec UTIL - https://nakamura5akihito.github.io/
 * Copyright (C) 2015 Akihito Nakamura
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opensec.util.core.web.spring;

import io.opensec.util.IoUtil;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;



/**
 *
 * @author  Akihito Nakamura, AIST
 */
public class ReaderRequestCallback
    implements RequestCallback
{

    /**
     * The file from which the HTTP request body is read.
     */
    private Reader  _input;


    private MediaType  _mediaType;



    /**
     * Constructor.
     */
    protected ReaderRequestCallback()
    {
    }


    public ReaderRequestCallback(
                    final Reader file,
                    final MediaType  mediaType
                    )
    {
        _input = file;
        _mediaType = mediaType;
    }



    //**************************************************************
    //  RequestCallback
    //**************************************************************

    @Override
    public void doWithRequest(
                    final ClientHttpRequest request
                    )
    throws IOException
    {
        HttpHeaders  headers = request.getHeaders();
        headers.setContentType( _mediaType );

        long  size = IoUtil.copy( _input, new OutputStreamWriter( request.getBody() ) );
        headers.setContentLength( size );
    }

}
//

