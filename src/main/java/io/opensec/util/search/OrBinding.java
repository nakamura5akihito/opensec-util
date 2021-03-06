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
package io.opensec.util.search;

import java.util.List;



/**
 * A logical binding that connects element bindings by the "OR" operator.
 *
 * @author  Akihito Nakamura, AIST
 */
public class OrBinding
    extends LogicalBinding
{
    private static final long  serialVersionUID = 2462722329582817270L;



    /**
     * Default constructor.
     */
    public OrBinding()
    {
    }


    /**
     * Constructs an OrBinding with the specified augend
     * and addend bindings.
     *
     * @param   augend
     *  the left side.
     * @param   addend
     *  the right side.
     */
    public OrBinding(
                    final Binding augend,
                    final Binding addend
                    )
    {
        super( augend, addend );
    }


    /**
     * Constructs an OrBinding with the specified bindings.
     *
     * @param   elements
     *  the element bindings.
     */
    public OrBinding(
                    final List<? extends Binding> elements
                    )
    {
        super( elements );
    }


    /**
     * Constructs an OrBinding with the specified bindings.
     *
     * @param   elements
     *  the element bindings.
     */
    public OrBinding(
                    final Binding[] elements
                    )
    {
        super( elements );
    }




    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * Determines whether another object is equal to this OrBinding.
     * The result is true if and only if the argument is not null
     * and is an OrBinding object that has the same property,
     * relation type, and value.
     *
     * @param   obj
     *  the object to test for equality with this OrBinding.
     * @return
     *  true if the given object equals this one;
     *  false otherwise.
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof OrBinding)) {
            return false;
        }

        return super.equals( obj );
    }



    /**
     * Computes the hash code for this OrBinding.
     *
     * @return
     *  a hash code value for this object.
     */
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    /**
     * Returns a string representation of this OrBinding.
     * This method is intended to be used only for debugging purposes.
     * The content and format of the returned string might not
     * conform to any query language syntax.
     *
     * @return
     *  a string representation of this OrBinding.
     */
    @Override
    public String toString()
    {
        return "OR" + super.toString();
    }

}
// OrBinding
