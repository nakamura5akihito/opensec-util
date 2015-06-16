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

import io.opensec.util.repository.RepositoryConfigurationException;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.dao.DAO;
import com.mongodb.MongoClient;



/**
 * @author  Akihito Nakamura, AIST
 */
public abstract class BaseDAO<T, K>
    extends BasicDAO<T, K>
{

    private DAORegistry  _registry;


    /**
     * Constructor.
     *
     * @param   entityClass the type of the target obejcts.
     * @param   ds  the data store object.
     */
    public BaseDAO(
                    final Class<T> entityClass,
                    final Datastore ds
                    )
    {
        super( entityClass, ds );
    }


    public BaseDAO(
                    final Class<T> entityClass,
                    final MongoClient mongo,
                    final Morphia morphia,
                    final String dbName
                    )
    {
        super( entityClass, mongo, morphia, dbName );
    }



    /**
     * @param   registry
     *  a DAO registry.
     */
    public void setDAORegistry(
                    final DAORegistry registry
                    )
    {
        this._registry = registry;
    }



    /**
     * @param   <S> the type of the unique key for the objects.
     * @param   <J> the type of the objects.
     * @param   entity_type the type of the objects.
     * @return
     *  the DAO object for the specified type.
     */
    protected <S, J> DAO<S, J> _getForwardingDAO(
                    final Class<S> entity_type
                    )
    {
        DAO<S, J>  dao = null;

        if (this._registry != null) {
            dao = this._registry.getDAO( entity_type );
        }

        if (dao == null) {
            throw new RepositoryConfigurationException( "No such DAO: entity class=" + entity_type );
        }

        return dao;
    }

}
//

