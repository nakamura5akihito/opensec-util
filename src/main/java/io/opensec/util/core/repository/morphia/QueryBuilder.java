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
package io.opensec.util.core.repository.morphia;

import io.opensec.util.repository.QueryException;
import io.opensec.util.repository.QueryParams;
import org.mongodb.morphia.query.Query;



/**
 * @author  Akihito Nakamura, AIST
 */
public interface QueryBuilder
{

    /**
     * @param   <T>     the type of the target objects.
     * @param   query   the query.
     * @param   params  the query parameters to be bound.
     * @return  the result query.
     * @throws  QueryException
     *  in case of query errors.
     */
    public <T> Query<T> build( Query<T> query, QueryParams params );


//    // paging
//    public Query<T> build(
//                    Query<T> query,
//                    List<? extends Order> orders,
//                    Limit limit
//                    );

}
//

