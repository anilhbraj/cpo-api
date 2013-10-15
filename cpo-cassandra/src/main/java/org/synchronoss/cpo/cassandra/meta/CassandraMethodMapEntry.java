/*
 * Copyright (C) 2003-2012 David E. Berry
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * A copy of the GNU Lesser General Public License may also be found at
 * http://www.gnu.org/licenses/lgpl.txt
 */
package org.synchronoss.cpo.cassandra.meta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.synchronoss.cpo.meta.MethodMapEntry;

import java.lang.reflect.Method;

/**
 * MethodMapEntry is a class defines the getters and setters for JDBC specific data classes
 *
 * @author david berry
 */
public class CassandraMethodMapEntry<J,D> extends MethodMapEntry<J,D> implements java.io.Serializable, Cloneable {

  private static final Logger logger = LoggerFactory.getLogger(CassandraMethodMapEntry.class);
  /**
   * Version Id for this class.
   */
  private static final long serialVersionUID = 1L;
  public static final int METHOD_TYPE_ONE = 1;
  public static final int METHOD_TYPE_TWO = 2;

  public CassandraMethodMapEntry(int methodType, Class<J> javaClass, Class<D> datasourceMethodClass, Method rsGetter, Method bsSetter) {
    super(methodType, javaClass, datasourceMethodClass, rsGetter, bsSetter);
  }
}