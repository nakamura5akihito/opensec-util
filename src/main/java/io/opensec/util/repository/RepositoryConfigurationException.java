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
package io.opensec.util.repository;



/**
 * Thrown to indicate that
 * there is an erroneous configuration with the repository.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: RepositoryConfigurationException.java 567 2013-04-15 08:49:40Z nakamura5akihito@gmail.com $
 */
public class RepositoryConfigurationException
    extends RepositoryException
{

    /**
     * Constructs this exception with no detail message.
     */
    public RepositoryConfigurationException()
    {
        super();
    }



    /**
     * Constructs this exception with the specified detail message.
     *
     * @param  message
     *   the detail message.
     */
    public RepositoryConfigurationException(
                    final String message
                    )
    {
        super( message );
    }



    /**
     * Constructs this exception with the specified cause.
     *
     * @param   cause
     *  the cause.
     */
    public RepositoryConfigurationException(
                    final Throwable cause
                    )
    {
        super( cause );
    }



    /**
     * Constructs this exception with the specified detail message and cause.
     *
     * @param   message
     *  the detail message.
     * @param   cause
     *  the cause.
     */
    public RepositoryConfigurationException(
                    final String message,
                    final Throwable cause
                    )
    {
        super( message, cause );
    }

}
//

