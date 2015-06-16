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
package io.opensec.util.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: HttpClient.java 554 2013-04-12 09:00:30Z nakamura5akihito@gmail.com $
 */
public interface HttpClient
{

//    public void setBaseUrl( String url );
//    public String getBaseUrl();

//    public String getObjectMediaType();




    //=====================================================================
    //  HTTP GET
    //=====================================================================

    /**
     * HTTP GET
     *
     * @param   <T>     the type of the response object.
     * @param   url     the URL of the contents.
     * @param   response_type   the type of the result object.
     * @param   uri_variables   the query parameter values bound to the specified URL.
     * @return  the result object.
     * @throws  HttpException
     *  when an exceptional condition occurred during the HTTP method execution.
     */
    public <T> T getObject( String url, Class<T> response_type, Object... uri_variables );



    /**
     * HTTP GET: Receives the contents from the specified URL and writes them to the given stream.
     *
     * @param   url     the URL of the contents.
     * @param   output  the stream which the contents should be written to.
     * @throws  HttpException
     *  when an exceptional condition occurred during the HTTP method execution.
     */
    public void getToWrite( String url, OutputStream output );



    /**
     * HTTP GET: Receives the contents from the specified URL and writes them to the given stream.
     *
     * @param   url     the URL.
     * @param   output  the stream to which  object to write the contents.
     * @param   accept_media_types  the acceptable media types.
     * @throws  HttpException
     *  when an exceptional condition occurred during the HTTP method execution.
     */
    public void getToWrite( String url, OutputStream output, String... accept_media_types );



    /**
     * HTTP GET: Receives the contents from the specified URL and writes them to the given stream.
     *
     * @param   url     the URL.
     * @param   output  the writer object to write the contents.
     * @throws  HttpException
     *  when an exceptional condition occurred during the HTTP method execution.
     */
    public void getToWrite( String url, Writer output );



    /**
     * HTTP GET: Receives the contents from the specified URL and writes them to the given stream.
     *
     * @param   url     the URL.
     * @param   output  the writer object to write the contents.
     * @param   accept_media_types  the acceptable media types.
     * @throws  HttpException
     *  when an exceptional condition occurred during the HTTP method execution.
     */
    public void getToWrite( String url, Writer output, String... accept_media_types );



    //=====================================================================
    //  HTTP POST
    //=====================================================================

    /**
     * HTTP POST
     *
     * @param   <T>         the type of the contents object.
     * @param   url_path    the URL.
     * @param   object      the contents object.
     * @param   type        the type of the contents object.
     * @return
     *  the location, as an URI, where the resource is created.
     * @throws  HttpException
     *  when an exceptional condition occurred during the HTTP method execution.
     */
    public <T> String postObject( String url_path, T object, Class<T> type );



    /**
     * HTTP POST: Reads the contents from the specified stream and sends them to the URL.
     *
     * @param   url     the URL.
     * @param   input   the stream which the contents are read from.
     * @param   media_type  the media type of the contents.
     * @return
     *  the location, as an URI, where the resource is created.
     * @throws  HttpException
     *  when an exceptional condition occurred during the HTTP method execution.
     */
    public String postByRead( String url, InputStream input, String media_type );



    /**
     * HTTP POST: Reads the contents from the specified reader and sends them to the URL.
     *
     * @param   url     the URL.
     * @param   input   the reader object to read the contents.
     * @param   media_type  the media type of the contents.
     * @return
     *  the location, as an URI, where the resource is created.
     * @throws  HttpException
     *  when an exceptional condition occurred during the HTTP method execution.
     */
    public String postByRead( String url, Reader input, String media_type );

}
//
