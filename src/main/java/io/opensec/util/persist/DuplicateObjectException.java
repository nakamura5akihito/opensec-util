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
package io.opensec.util.persist;



/**
 * Thrown to indicate that an object which is correspondent to the object
 * to be created already exists in the data store.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: DuplicateObjectException.java 473 2013-02-20 08:41:32Z nakamura5akihito@gmail.com $
 */
public class DuplicateObjectException
    extends PersistenceException
{

    /**
     * Constructs a DuplicateObjectException with no detail message.
     */
    public DuplicateObjectException()
    {
        super();
    }



    /**
     * Constructs a DuplicateObjectException with the specified detail message.
     *
     * @param  message
     *   the detail message.
     */
    public DuplicateObjectException(
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
    public DuplicateObjectException(
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
    public DuplicateObjectException(
                    final String message,
                    final Throwable cause
                    )
    {
        super( message, cause );
    }

}
// DuplicateObjectException

