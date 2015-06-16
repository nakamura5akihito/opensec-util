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
package io.opensec.util.search;

import java.io.Serializable;



/**
 * A Projection represents what portion of the objects to be included in the query result.
 * This interface is a marker for every type of projection.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: Projection.java 473 2013-02-20 08:41:32Z nakamura5akihito@gmail.com $
 */
public interface Projection
    extends Serializable
{

}
// Projection