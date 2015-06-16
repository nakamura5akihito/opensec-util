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
import java.io.InputStreamReader;
import java.io.Writer;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;



/**
 *
 * @author  Akihito Nakamura, AIST
 */
public class WriterResponseExtractor
    implements ResponseExtractor<Writer>
{

    /**
     * The stream to which the HTTP response body is written.
     */
    private Writer  _writer;



    /**
     * Constructor.
     */
    protected WriterResponseExtractor()
    {
    }


    public WriterResponseExtractor(
                    final Writer writer
                    )
    {
        _writer = writer;
    }



    //**************************************************************
    //  ResponseExtractor<T>
    //**************************************************************

    @Override
    public Writer extractData(
                    final ClientHttpResponse response
                    )
    throws IOException
    {
        IoUtil.copy( new InputStreamReader( response.getBody() ), _writer );

        return _writer;
    }

}
//

