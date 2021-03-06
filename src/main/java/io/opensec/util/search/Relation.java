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



/**
 * The Relation represents a type of property-value relation
 * in search queries.
 *
 * <p>Each relation has an <em>operator</em> representation.
 * The symbol, say "=",  is the operator of the EQUAL relation.
 * </p>
 *
 * @author  Akihito Nakamura, AIST
 */
public enum Relation
{

    /**
     * EQUAL relation: "=".
     */
    EQUAL( "="  ),

    /**
     * NOT_EQUAL relation: "!=".
     */
    NOT_EQUAL( "!=" ),

    /**
     * LESS_THAN relation: "&lt;".
     */
    LESS_THAN( "<"  ),

    /**
     * LESS_EQUAL relation: "&lt;=".
     */
    LESS_EQUAL( "<=" ),

    /**
     * GREATER_THAN relation: "&gt;".
     */
    GREATER_THAN( ">"  ),

     /**
      * GREATER_EQUAL relation: "&gt;=".
      */
     GREATER_EQUAL( ">=" );



    /**
     * Returns a Relation with the specified name.
     *
     * @param   name
     *  the relation name.
     * @return
     *  the Relation object.
     * @throws  IllegalArgumentException
     *  if the specified name is not defined.
     */
     public static Relation fromValue(
                     final String name
                     )
     {
         for (Relation  r : Relation.values()) {
             if (r.name().equals( name )) {
                 return r;
             }
         }

         throw new IllegalArgumentException( "invalid relation: " + name );
    }



    /**
     */
    private final String  _operator;



    /**
     * Constructs a relation type of the specified name.
     *
     * @param   name
     *  the name of this relation type.
     * @throws  IllegalArgumetnException
     *  if the specified name is not defined.
     */
    Relation(
                    final String operator
                    )
    {
        _operator = operator;
    }



    /**
     * Returns the operator of this relation type.
     *
     * @return
     *  the operator of this relation type.
     */
    public String operator()
    {
        return _operator;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    /**
//     * Returns a string representation of this Relation.
//     *
//     * @return
//     *  a string representation of this Relation.
//     */
//    @Override
//    public String toString()
//    {
//        return name();
//    }

}
// Relation
