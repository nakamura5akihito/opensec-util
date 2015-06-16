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
package io.opensec.util.config;

import java.util.Set;



/**
 * Application Context.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: Context.java 521 2013-03-08 06:16:35Z nakamura5akihito@gmail.com $
 */
public interface Context
{

    ///////////////////////////////////////////////////////////////////////
    //  properties
    ///////////////////////////////////////////////////////////////////////

    /**
     * Searches for the property with the specified key in this context.
     *
     * @param   key
     *  the property key.
     * @return
     *  the value with the specified key value.
     */
    public String getProperty( String key );



    /**
     * Searches for the property with the specified key in this context.
     *
     * @param   key
     *  the property key.
     * @param   defaultValue
     *  a default value.
     * @return
     *  the value with the specified key value.
     */
    public String getProperty( String key, String defaultValue );



    /**
     * Returns an iterator over the keys of the properties in this context.
     *
     * @return  the property keys.
     */
    public Set<String> getPropertyKeys();



    ///////////////////////////////////////////////////////////////////////
    //  BeanFactory
    ///////////////////////////////////////////////////////////////////////

    /**
     * Return the bean instance that uniquely matches the given object type.
     *
     * @param   <T>     the type of the bean.
     * @param   requiredType
     *  the type the bean must match. null is disallowed.
     * @return
     *  an instance of the bean matching the required type.
     * @throws  ConfigurationException
     *  if an error occurs during the configuration operation.
     */
    public <T> T getBean( Class<T> requiredType );



    /**
     * Return the bean instance that uniquely matches the given name and object type.
     *
     * @param   <T>     the type of the bean.
     * @param   name
     *  the name of the bean to retrieve.
     * @param   requiredType
     *  the type the bean must match. null is disallowed.
     * @return
     *  an instance of the bean matching the required type.
     * @throws  ConfigurationException
     *  if an error occurs during the configuration operation.
     */
    public <T> T getBean( String name, Class<T> requiredType );



    /**
     * Tests if this context contains a bean with the given name.
     *
     * @param   name    the name of the bean.
     * @return
     *  true if a bean with the given name is defined, false otherwise.
     * @throws  ConfigurationException
     *  if an error occurs during the configuration operation.
     */
    public boolean containsBean( String name );

}
//

