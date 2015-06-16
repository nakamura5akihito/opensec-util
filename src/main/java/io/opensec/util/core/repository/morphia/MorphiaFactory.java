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

import java.util.Arrays;
import java.util.Set;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.converters.Converters;
import org.mongodb.morphia.converters.TypeConverter;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;



/**
 * A factory for Morphia main object.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: MorphiaFactory.java 523 2013-03-08 06:26:46Z nakamura5akihito@gmail.com $
 */
public class MorphiaFactory
{

    private ServerAddress  _server_addr;
    private Morphia  _morphia;
	private MongoClient  _client;



	public MorphiaFactory()
	{
		this( null );
	}


	public MorphiaFactory(
            @SuppressWarnings("rawtypes") final Set<Class> classesToMap
			)
	{
		this( classesToMap, null );
	}


	public MorphiaFactory(
            @SuppressWarnings("rawtypes") final Set<Class> classesToMap,
            final Set<Class<? extends TypeConverter>> converters
			)
	{
	    _morphia = create( classesToMap, converters );
//        _morphia = (classesToMap == null
//                	? (new Morphia()) : (new Morphia( classesToMap )));
//
//        if (converters != null  &&  converters.size() > 0) {
//        	Converters  defaultConverters = _morphia.getMapper().getConverters();
//        	for (Class<? extends TypeConverter>  converter : converters) {
//        		defaultConverters.addConverter( converter );
//        	}
//        }
	}



	/**
	 * @param  addr    the MongoDB server address.
	 */
	public void setServerAddress(
	                final ServerAddress addr
	                )
	{
	    _server_addr = addr;
	}


	protected ServerAddress _getServerAddress()
	{
	    if (_server_addr == null) {
	        _server_addr = new ServerAddress();
	    }

	    return _server_addr;
	}



	public void setMongoClient(
			final MongoClient client
			)
	{
		_client = client;
	}



	public Datastore createDatastore(
			final String dbName
			)
	{
		Datastore  ds = _morphia.createDatastore( _client, dbName );
		return ds;
	}



	/**
	 * @param  dbname      the name of the database.
	 * @param  username    the name of the user to access the database.
	 * @param  password    the password of the user.
	 * @return
	 *     a data store object.
	 */
    public Datastore createDatastore(
                    final String dbname,
                    final String username,
                    final String password
                    )
    {
        MongoClient  client = null;

        if (username != null && username.length() > 0
                        && password != null && password.length() > 0) {
            MongoCredential  credential = MongoCredential.createScramSha1Credential(
                            dbname, username, password.toCharArray() );
            client = new MongoClient( _getServerAddress(), Arrays.asList( credential ) );
        } else {
            client = new MongoClient();
        }

        return _morphia.createDatastore( client, dbname );
    }



//MongoDB Java driver 2.6 impl.//
//	public Datastore createDatastore(
//			final String dbName,
//			final String username,
//			final String password
//			)
//	{
//		DB  db = _client.getDB( dbName );
//
//		if (username != null  &&  username.length() > 0
//				&&  password != null  &&  password.length() > 0) {
//			@SuppressWarnings("deprecation")
//			boolean  auth = db.authenticate( username, password.toCharArray() );
//			if (!auth) {
//				throw new RepositoryException( "authentication failed" );
//			}
//		}
//
//		return createDatastore( dbName );
//	}




    /**
     * Construct a new instance.
     *
     * @return
     *  Morphia main object.
     */
    public static Morphia create()
    {
        return create( null );
    }



    /**
     * Construct a new instance with the classes to map.
     *
     * @param   classesToMap
     *  the classes to map
     * @return
     *  Morphia main object.
     */
    public static Morphia create(
                    @SuppressWarnings( "rawtypes" ) final Set<Class> classesToMap
                    )
    {
        return create( classesToMap, null );
    }



    /**
     * Construct a new instance with the classes to map and converters.
     *
     * @param   classesToMap
     *  the classes to map
     * @param   converters
     *  the converters.
     * @return
     *  Morphia main object.
     */
    public static Morphia create(
                    @SuppressWarnings( "rawtypes" ) final Set<Class> classesToMap,
	                final Set<Class<? extends TypeConverter>> converters
	                )
	{
        Morphia  morphia = (classesToMap == null
                        ? (new Morphia()) : (new Morphia( classesToMap )));

        if (converters != null  &&  converters.size() > 0) {
            Converters  defaultConverters = morphia.getMapper().getConverters();
            for (Class<? extends TypeConverter>  converter : converters) {
                defaultConverters.addConverter( converter );
            }
        }

        return morphia;
	}

}
// MorphiaFactory
