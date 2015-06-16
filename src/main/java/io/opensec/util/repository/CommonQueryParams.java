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



/**
 * A set of common query parameters.
 *
 * @author  Akihito Nakamura, AIST
 */
public class CommonQueryParams
    extends QueryParams
{

    public static class Key
    {
        // OpenSearch
        public static final String  SEARCH_TERMS    = "searchTerms";
        public static final String  COUNT           = "count";
        public static final String  START_INDEX     = "startIndex";
        public static final String  START_PAGE      = "startPage";

        // OpenSearch Time
        public static final String  DTSTART         = "dtstart";
        public static final String  DTEND           = "dtend";

        //sorting
        public static final String  ORDER           = "order";

        //predefined projection
        public static final String  VIEW            = "view";
    }
    //


//    public static enum View
//    {
//        id,
//        summary,
//        complete,
//        count
//    }
//    //View



    /**
     * Constructor.
     */
    public CommonQueryParams()
    {
    }



    /**
     * @param   searchTerms     the key words for search.
     */
    public void setSearchTerms(
                    final String searchTerms
                    )
    {
        set( Key.SEARCH_TERMS, searchTerms );
    }


    public String getSearchTerms()
    {
        return get( Key.SEARCH_TERMS );
    }



    /**
     * @param   count   the number of result elements to be return if the paging is enabled.
     */
    public void setCount(
                    final String count
                    )
    {
        set( Key.COUNT, count );
    }


    public String getCount()
    {
        return get( Key.COUNT );
    }



    /**
     * @param   start_index
     *  at which object the service should begin returning results.
     */
    public void setStartIndex(
                    final String start_index
                    )
    {
        set( Key.START_INDEX, start_index );
    }


    public String getStartIndex()
    {
        return get( Key.START_INDEX );
    }



    /**
     * @param   start_page  the start page.
     */
    public void setStartPage(
                    final String start_page
                    )
    {
        set( Key.START_PAGE, start_page );
    }


    public String getStartPage()
    {
        return get( Key.START_PAGE );
    }



    /**
     * @param   dtstart     the start date.
     */
    public void setDtstart(
                    final String dtstart
    )
    {
        set( Key.DTSTART, dtstart );
    }


    public String getDtstart()
    {
        return get( Key.DTSTART );
    }



    /**
     * @param   dtend   the end date.
     */
    public void setDtend(
                    final String dtend
    )
    {
        set( Key.DTEND, dtend );
    }


    public String getDtend()
    {
        return get( Key.DTEND );
    }



    /**
     * @param   order
     *  items be returned in a particular order.
     *  The content must be comma-separated, e.g. "age,-date"
     */
    public void setOrder(
                    final String order
    )
    {
        set( Key.ORDER, order );
    }


    public String getOrder()
    {
        return get( Key.ORDER );
    }



    /**
     * @param   view    the view of the query results.
     */
    public void setView(
                    final String view
    )
    {
        if (view != null) {
            // validation
            View.valueOf( view );
        }

        set( Key.VIEW, view );
    }


    public String getView()
    {
        return get( Key.VIEW );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
//

