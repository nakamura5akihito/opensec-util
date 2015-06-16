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
 * A dependent object.
 * The lifetime of a dependent object depends on the master object.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: Dependent.java 473 2013-02-20 08:41:32Z nakamura5akihito@gmail.com $
 */
public interface Dependent<T>
{

    /**
     * Sets the master object of this dependent object.
     *
     * @param   master
     *  the master object.
     */
    public void setMasterObject( T master );



    /**
     * Returns the master object of this dependent object.
     *
     * @return
     *  the master object.
     */
    public T getMasterObject();

}
// Dependent
