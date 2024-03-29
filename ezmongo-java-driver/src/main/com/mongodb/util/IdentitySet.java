/*   Copyright (C) 2013-2014 Computer Sciences Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// IdentitySet.java

package com.mongodb.util;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;

/**
 * @deprecated This class is NOT a part of public API and will be dropped in 3.x versions.
 */
@Deprecated
public class IdentitySet<T> implements Iterable<T> {

    public IdentitySet(){
    }

    public IdentitySet( Iterable<T> copy ){
        for ( T t : copy )
            add( t );
    }

    public boolean add( T t ){
        return _map.put( t , "a" ) == null;
    }

    public boolean contains( T t ){
        return _map.containsKey( t );
    }

    public void remove( T t ){
        _map.remove( t );
    }

    public void removeall( Iterable<T> coll ){
        for ( T t : coll )
            _map.remove( t );
    }

    public void clear(){
	_map.clear();
    }

    public int size(){
	return _map.size();
    }

    public Iterator<T> iterator(){
        return _map.keySet().iterator();
    }

    public void addAll( Collection<T> c ){
        for ( T t : c ){
            add( t );
        }
    }

    public void addAll( IdentitySet<T> c ){
        for ( T t : c )
            add( t );
    }

    public void removeAll( Iterable<T> prev ){
        for ( T t : prev )
            remove( t );
    }

    final IdentityHashMap<T,String> _map = new IdentityHashMap<T,String>();
}
