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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;



/**
 * A element container.
 *
 * @author	Akihito Nakamura, AIST
 */
public class QueryResultsElements<T>
    implements Iterable<T>, Serializable
{

    private final List<T>  _elements = new ArrayList<T>();
    //{0..*}



    /**
     * Constructor.
     */
    public QueryResultsElements()
    {
    }


    public QueryResultsElements(
                    final Collection<? extends T> elements
                    )
    {
        setElements( elements );
    }


    public QueryResultsElements(
                    final T[] elements
                    )
    {
        if (elements != null) {
            setElements( Arrays.asList( elements ) );
        }
    }



    /**
     * @param   elements    the result elements.
     */
    public void setElements(
                    final Collection<? extends T> elements
                    )
    {
        if (elements != this._elements) {
            this._elements.clear();
            if (elements != null  &&  elements.size() > 0) {
                for (T  e : elements) {
                    addElement( e );
                }
            }
        }
    }


    public void setElements(
                    final T[] elements
                    )
    {
        this._elements.clear();
        if (elements != null  &&  elements.length > 0) {
            for (T  e : elements) {
                addElement( e );
            }
        }
    }


    public boolean addElement(
                    final T element
                    )
    {
        return this._elements.add( element );
    }


    public List<T> getElements()
    {
        return this._elements;
    }



//    public Iterator<T> iterateElements()
//    {
//        return this._elements.iterator();
//    }



    public int size()
    {
        return getElements().size();
    }


    //*********************************************************************
    //  java.lang.Iterable
    //*********************************************************************

    @Override
    public Iterator<T> iterator()
    {
        return this._elements.iterator();
    }



    //*********************************************************************
    //  java.lang.Object
    //*********************************************************************

    @Override
    public String toString()
    {
        return String.valueOf( getElements() );
    }

}
//
