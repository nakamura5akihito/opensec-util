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
 * a type of object, in the data store operation, is inappropriate, unknown, or unavailable.
 *
 * @author  Akihito Nakamura, AIST
 */
public class ObjectTypeException
    extends RepositoryException
{

    private String  _typeName;



    /**
     * Constructs this exception with no detail message.
     */
    public ObjectTypeException()
    {
        super();
    }



    /**
     * Constructs this exception with the specified detail message.
     *
     * @param  message
     *   the detail message.
     */
    public ObjectTypeException(
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
    public ObjectTypeException(
                    final Throwable cause
                    )
    {
        super( cause );
    }



    /**
     * Constructs this exception with the specified
     * detail message and cause.
     *
     * @param   message
     *  the detail message.
     * @param   cause
     *  the cause.
     */
    public ObjectTypeException(
                    final String message,
                    final Throwable cause
                    )
    {
        super( message, cause );
    }



    /**
     * @param type
     *  the type of object.
     */
    public void setType(
                    final Class<?> type
                    )
    {
        setTypeName( (type == null ? "unknown" : type.getName()) );
    }


    /**
     * @param type_name
     *  the type name of object.
     */
    public void setTypeName(
                    final String type_name
                    )
    {
        _typeName = (type_name == null ? "unknown" : type_name);
    }


    /**
     * @return
     *  the type name of object.
     */
    public String getTypeName()
    {
        return _typeName;
    }

}
//

