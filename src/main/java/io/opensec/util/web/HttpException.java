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

import io.opensec.util.NestedRuntimeException;



/**
 * An exceptional condition that occurred during HTTP communication.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: HttpException.java 553 2013-04-12 08:45:25Z nakamura5akihito@gmail.com $
 */
public class HttpException
    extends NestedRuntimeException
{

    /**
     * Constructs an HttpException with no detail message.
     */
    public HttpException()
    {
        super();
    }



    /**
     * Constructs an HttpException with the specified detail message.
     *
     * @param  message
     *   the detail message.
     */
    public HttpException(
                    final String message
                    )
    {
        super( message );
    }



    /**
     * Constructs an HttpException with the specified cause.
     *
     * @param   cause
     *  the cause.
     */
    public HttpException(
                    final Throwable cause
                    )
    {
        super( cause );
    }



    /**
     * Constructs an HttpException with the specified
     * detail message and cause.
     *
     * @param   message
     *  the detail message.
     * @param   cause
     *  the cause.
     */
    public HttpException(
                    final String message,
                    final Throwable cause
                    )
    {
        super( message, cause );
    }

}
// HttpException

