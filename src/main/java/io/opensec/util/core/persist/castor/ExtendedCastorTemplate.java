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
package io.opensec.util.core.persist.castor;

import java.util.ArrayList;
import java.util.List;
import org.castor.spring.orm.CastorCallback;
import org.castor.spring.orm.CastorTemplate;
import org.exolab.castor.jdo.Database;
import org.exolab.castor.jdo.JDOManager;
import org.exolab.castor.jdo.OQLQuery;
import org.exolab.castor.jdo.PersistenceException;
import org.exolab.castor.jdo.QueryResults;
import org.springframework.dao.DataAccessException;



/**
 * This class extends the CastorTemplate by adding count function.
 *
 * @author  Akihito Nakamura, AIST
 */
public class ExtendedCastorTemplate
extends CastorTemplate
{

    /**
     * Constructor.
     */
    public ExtendedCastorTemplate()
    {
    }


    /**
     * Constructor.
     *
     * @param   jdoManager  a Castor JDO manager.
     */
    public ExtendedCastorTemplate(
                    final JDOManager jdoManager
                    )
    {
        super( jdoManager );
    }


    /**
     * Constructor.
     *
     * @param   jdoManager  a Castor JDO manager.
     * @param   allowCreate true if the related instances should be automatically created.
     */
    public ExtendedCastorTemplate(
                    final JDOManager jdoManager,
                    final boolean allowCreate
                    )
    {
        super( jdoManager, allowCreate );
    }



    /**
     * @param   entity  the entity to be tested.
     * @return  true if the entity is already persistent.
     */
    public boolean isPersistent(
                    final Object entity
                    )
    throws DataAccessException
    {
        Boolean isPersistent = (Boolean)execute(new CastorCallback() {
            @Override
            public Object doInCastor(final Database database) throws PersistenceException {
                boolean  result = database.isPersistent( entity );
                return Boolean.valueOf( result );
            }
        });

        return isPersistent.booleanValue();
    }



    /**
     * @param   oql     an OQL query.
     * @param   params  the parameters to be bound.
     * @return
     *  the matched objects in the data store.
     */
    public List<Object> findByQuery(
                    final String oql,
                    final Object[] params
                    )
    throws DataAccessException
    {
        @SuppressWarnings( "unchecked" )
        List<Object>  results = (List<Object>)executeFind(new CastorCallback() {
            @Override
            public Object doInCastor(final Database database) throws PersistenceException {
                OQLQuery  query = database.getOQLQuery( oql );
                if (params != null) {
                    for (int  i = 0; i < params.length; i++) {
                        query.bind( params[i] );
                    }
                }
                prepareQuery( query );
                QueryResults  queryResults = query.execute();
                List<Object>  objects = new ArrayList<Object>();
                while (queryResults.hasMore()) {
                    objects.add( queryResults.next() );
                }
                return objects;
            }
        });

        return results;
    }

}
// ExtendedCastorTemplate
