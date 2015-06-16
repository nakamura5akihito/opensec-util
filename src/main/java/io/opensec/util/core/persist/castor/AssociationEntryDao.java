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

import io.opensec.util.persist.AssociationEntry;



/**
 * @author  Akihito Nakamura, AIST
 */
public class AssociationEntryDao<K, T extends AssociationEntry<K,?,?>>
    extends CastorDao<K, T>
{

    public AssociationEntryDao()
    {
    }


    public AssociationEntryDao(
                    final Class<? extends T> type
                    )
    {
        super( type, new AssociationEntryHelper<T>() );
    }


    public AssociationEntryDao(
                    final Class<? extends T> type,
                    final AssociationEntryHelper<? super T> helper
                    )
    {
        super( type, helper );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _syncProperties(
                    final T p_object,
                    final T object
                    )
    {
        if (p_object == null) {
            return;
        }

        // nothing to copy
    }

}
// AssociationEntryDao
