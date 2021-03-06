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

import io.opensec.util.persist.AbstractPersistable;
import org.exolab.castor.jdo.TimeStampable;



/**
 * A persistent entity for Castor DAO.
 *
 * @author  Akihito Nakamura, AIST
 */
public abstract class CastorPersistable<K>
    extends AbstractPersistable<K>
    implements TimeStampable
{

    private long  _timestamp;



    /**
     * Constructor.
     */
    public CastorPersistable()
    {
    }


    /**
     * Constructor.
     *
     * @param   pid
     *  the persistent ID of the object.
     */
    public CastorPersistable(
                    final K pid
                    )
    {
        super( pid );
    }



    //**************************************************************
    //  TimeStampable
    //**************************************************************

    @Override
    public void jdoSetTimeStamp(
                    final long timestamp
                    )
    {
        _timestamp = timestamp;
    }


    @Override
    public long jdoGetTimeStamp()
    {
        return _timestamp;
    }

}
// CastorPersistable
