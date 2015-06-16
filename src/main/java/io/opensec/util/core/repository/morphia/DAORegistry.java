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

import io.opensec.util.repository.ObjectTypeException;
import io.opensec.util.repository.RepositoryConfigurationException;
import org.mongodb.morphia.dao.DAO;



/**
 * A DAO registry.
 *
 * @author	Akihito Nakamura, AIST
 */
public interface DAORegistry
{

    /**
     * Returns a DAO for the given entity type.
     *
     * @param   <T> the type of target entities.
     * @param   <K> the type of the unique key for the entities.
     * @param   entity_type the type of the entity.
     * @return  a DAO object.
     * @throws  ObjectTypeException
     *  if the given type is null.
     * @throws  RepositoryConfigurationException
     *  when a DAO for the given entity type was not found.
     */
    public <T, K> DAO<T, K> getDAO( Class<T> entity_type );

}
// DAORegistry
