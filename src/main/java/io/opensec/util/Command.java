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
package io.opensec.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * A platform command.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: Command.java 473 2013-02-20 08:41:32Z nakamura5akihito@gmail.com $
 */
public class Command
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( Command.class );
//    private static Log  _LOG = LogFactory.getLog( Command.class );



    /**
     * A special value for the option that has no value.
     */
    public static final String  NO_OPTION_VALUE = null;



    private String  _executable;
    private final Map<String,String>  _options = new HashMap<String,String>();



    /**
     * Constructor.
     */
    public Command()
    {
    }



    /**
     * Constructor.
     *
     * @param   executable  the path to the executable command.
     */
    public Command(
                    final String executable
                    )
    {
        this( executable, null );
    }



    /**
     * Constructor.
     *
     * @param   executable  the path to the executable command.
     * @param   options     the command options.
     */
    public Command(
                    final String executable,
                    final Map<String,String> options
                    )
    {
        setExecutable( executable );
        setOptions( options );
    }




    /**
     * @param   executable  the path to the executable command.
     */
    public void setExecutable(
                    final String executable
                    )
    {
        _executable = executable;
    }


    public String getExecutable()
    {
        return _executable;
    }



    /**
     * @param   options the command options.
     */
    public void resetOptions(
                    final Map<String,String> options
                    )
    {
        _options.clear();
        setOptions( options );
    }



    /**
     * @param   options the command options.
     */
    public void setOptions(
                    final Map<String,String> options
                    )
    {
        if (options != null) {
            _options.putAll( options );
        }
    }



    /**
     * @param   name    the command option.
     * @param   value   the value of the option.
     */
    public void setOption(
                    final String name,
                    final String value
                    )
    {
        _options.put( name, value );
    }



    /**
     * An option which has no value.
     *
     * @param   name    the command option.
     */
    public void setOption(
                    final String name
                    )
    {
        _options.put( name, NO_OPTION_VALUE );
    }



    /**
     * @return  all the command option names.
     */
    public Set<String> getAllSetOptionNames()
    {
        return _options.keySet();
    }



    /**
     * @param   option  the command option.
     * @return  true if the option is set.
     */
    public boolean isOptionSet(
                    final String option
                    )
    {
        return _options.containsKey( option );
    }



    /**
     * @param   name    the name of the command option.
     * @return  the value of the command option.
     */
    public String getOption(
                    final String name
                    )
    {
        return _options.get( name );
    }


    /**
     * @param   option  the command option.
     */
    public void removeOption(
                    final String option
                    )
    {
        _options.remove( option );
    }



    /**
     * Creates a command line from the current configuration.
     * The command line is represented as a string list.
     *
     * @return
     *  the command line.
     */
    public List<String> createCommandList()
    {
        return createCommandList(
                        new ArrayList<String>( getAllSetOptionNames() ) );

//        List<String>  list = new ArrayList<String>();
//        list.add( getExecutable() );
//
//        Set<String>  options = getAllSetOptionNames();
//        for (String  opt : options) {
//            list.add( opt );
//            final String  value = getOption( opt );
//            if (value != NO_OPTION_VALUE) {
//                list.add( value );
//            }
//        }
//
//        return list;
    }



    /**
     * Creates a command line from the current configuration.
     * The command line is represented as a string list.
     * The options are filtered by the specified list.
     *
     * @param   filterOptions
     *  the options contained in the result if they are set.
     * @return
     *  the command line.
     */
    public List<String> createCommandList(
                    final List<String> filterOptions
                    )
    {
        List<String>  list = new ArrayList<String>();
        list.add( getExecutable() );

        for (String  opt : filterOptions) {
            if (isOptionSet( opt )) {
                list.add( opt );
                final String  value = getOption( opt );
                if (value != NO_OPTION_VALUE) {
                    list.add( value );
                }
            }
        }

        return list;
    }



    /**
     * Executes this command.
     *
     * @return  the process.
     * @throws IOException  if an error occurs during the operation.
     */
    public Process execute()
    throws IOException
    {
        List<String>  list = createCommandList();
        if (_LOG_.isDebugEnabled()) {
            _LOG_.debug( "executing command: " + list );
        }

        Process  proc = Runtime.getRuntime().exec( list.toArray( new String[0] ) );
                                             //@throws IOException
                                             //@throws SecurityException
                                             //@throws IndexOutOfBoundsException, NullPointerException

        return proc;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "executable=" + getExecutable()
                    + ", options=" + String.valueOf( _options );
    }

}
// Command

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

