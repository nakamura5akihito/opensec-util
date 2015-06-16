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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



/**
 * A set of query parameters to be interpreted as a filter for collections of objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: QueryParams.java 500 2013-03-07 09:23:00Z nakamura5akihito@gmail.com $
 */
public class QueryParams
    implements Cloneable, Serializable
{

    public static final String  LIST_DELIMITER = ",";


    private final Map<String, String>  _params = new HashMap<String, String>();



    /**
     * Constructor.
     */
    public QueryParams()
    {
    }


    public QueryParams(
                    final Map<String, String> params
                    )
    {
        _params.putAll( params );
    }



    /**
     * @return  all the keys as a set.
     */
    public Set<String> keys()
    {
        return _params.keySet();
    }



    /**
     *  @return true if this set is empty; no parameter.
     */
    public boolean isEmpty()
    {
        return _params.isEmpty();
    }



    /**
     * @param   key     the key of the parameter.
     * @param   value   the value of the parameter.
     * @return  this object.
     */
    public QueryParams set(
                    final String key,
                    final String value
                    )
    {
        _params.put( key, value );

        return this;
    }


    public QueryParams set(
                    final String key,
                    final String[] values
                    )
    {
        StringBuilder  s = new StringBuilder();
        boolean  first = true;
        for (String  v : values) {
            if (first) {
                first = false;
            } else {
                s.append( "," );
            }
            s.append( v );
        }
        _params.put( key, s.toString() );

        return this;
    }


    public QueryParams set(
                    final String key,
                    final Enum<?>[] values
                    )
    {
        StringBuilder  s = new StringBuilder();
        boolean  first = true;
        for (Enum<?>  e : values) {
            if (first) {
                first = false;
            } else {
                s.append( "," );
            }
            s.append( e.name() );
        }
        _params.put( key, s.toString() );

        return this;
    }



    /**
     * @param   key     the key of the parameter.
     * @return  the value of the parameter, or null if there was no parameter for the key.
     */
    public String get(
                    final String key
                    )
    {
        return _params.get( key );
    }


    public String get(
                    final String key,
                    final String defaultValue
                    )
    {
        String  value = get( key );
        return (value == null ? defaultValue : value);
    }


    public int getAsInt(
                    final String key
                    )
    {
        String  v = _params.get( key );
        if (v == null) {
            throw new IllegalArgumentException( "no such key: " + key );
        }

        return Integer.valueOf( v ).intValue();
    }



    /**
     * @param   key     the key of the parameter.
     * @return  true if a parameter associated with the specified key.
     */
    public boolean containsKey(
                    final String key
                    )
    {
        return _params.containsKey( key );
    }



    /**
     * @param   key     the key of the parameter.
     * @return  the previous parameter value associated with key, or null if there was no parameter for key.
     */
    public String remove(
                    final String key
                    )
    {
        return _params.remove( key );
    }



    /**
     * @return  the number of the parameters.
     */
    public int size()
    {
        return _params.size();
    }



    //**************************************************************
    //  java.lang.Cloneable
    //**************************************************************

    @Override
    public Object clone()
    throws CloneNotSupportedException
    {
        return (new QueryParams( _params ));
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return String.valueOf( _params );
    }

}
//

