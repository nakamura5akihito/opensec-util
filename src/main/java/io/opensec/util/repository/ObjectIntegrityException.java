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
 * some property of the object prevents it from being saved in the repository.
 *
 * @author  Akihito Nakamura, AIST
 */
public class ObjectIntegrityException
    extends RepositoryException
{

    /**
     * Constructs a DuplicateObjectException with no detail message.
     */
    public ObjectIntegrityException()
    {
        super();
    }



    /**
     * Constructs a DuplicateObjectException with the specified detail message.
     *
     * @param  message
     *   the detail message.
     */
    public ObjectIntegrityException(
                    final String message
                    )
    {
        super( message );
    }



    /**
     * Constructs a DuplicateObjectException with the specified cause.
     *
     * @param   cause
     *  the cause.
     */
    public ObjectIntegrityException(
                    final Throwable cause
                    )
    {
        super( cause );
    }



    /**
     * Constructs a DuplicateObjectException with the specified
     * detail message and cause.
     *
     * @param   message
     *  the detail message.
     * @param   cause
     *  the cause.
     */
    public ObjectIntegrityException(
                    final String message,
                    final Throwable cause
                    )
    {
        super( message, cause );
    }

}
// DuplicateObjectException

