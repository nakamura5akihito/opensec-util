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

import io.opensec.util.search.Binding;
import io.opensec.util.search.Limit;
import io.opensec.util.search.Order;
import io.opensec.util.search.SearchCriteria;
import java.util.Collection;
import java.util.List;



/**
 * A data store facade that supports multiple types of objects.
 *
 * @author  Akihito Nakamura, AIST
 */
public interface Datastore
{

    public <K, T extends Persistable<K>>
    K create( Class<T> type, T object );


    public <K, T extends Persistable<K>>
    void update( Class<T> type, T object );


    public <K, T extends Persistable<K>>
    void remove( Class<T> type, T object );


    public <K, T extends Persistable<K>>
    T sync( Class<T> type, T object );


    public <K, T extends Persistable<K>>
    List<T> syncAll( Class<T> type, List<? extends T> objects );


    public <K, T extends Persistable<K>>
    int count( Class<T> type );


    public <K, T extends Persistable<K>>
    int count( Class<T> type, Binding filter );


    public <K, T extends Persistable<K>>
    T load( Class<T> type, K id );


    public <K, T extends Persistable<K>>
    List<T> loadAll( Class<T> type, List<? extends K> ids );


    public <K, T extends Persistable<K>>
    Collection<T> find( Class<T> type );


    public <K, T extends Persistable<K>>
    Collection<T> find( Class<T> type, Binding filter );


    public <K, T extends Persistable<K>>
    Collection<T> find( Class<T> type, Binding filter, List<? extends Order> ordering, Limit limit );


    public <K, T extends Persistable<K>>
    Collection<K> findIdentity( Class<T> type );


    public <K, T extends Persistable<K>>
    Collection<K> findIdentity( Class<T> type, Binding filter );


    public <K, T extends Persistable<K>>
    Collection<K> findIdentity( Class<T> type, Binding filter, List<? extends Order> ordering, Limit limit );


    public <K, T extends Persistable<K>>
    List<Object> search( Class<T> type, SearchCriteria criteria );

}
//
