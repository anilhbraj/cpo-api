/*
 *  Copyright (C) 2003-2012 David E. Berry
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *  A copy of the GNU Lesser General Public License may also be found at 
 *  http://www.gnu.org/licenses/lgpl.txt
 *
 */
package org.synchronoss.cpo.jdbc;

import java.util.Collection;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.synchronoss.cpo.CpoAdapter;
import org.synchronoss.cpo.CpoAdapterFactory;
import org.synchronoss.cpo.CpoException;
import org.synchronoss.cpo.helper.ExceptionHelper;

public class InvalidParameterTest extends TestCase {

  private static Logger logger = LoggerFactory.getLogger(InvalidParameterTest.class.getName());
  private CpoAdapter cpoAdapter = null;

  public InvalidParameterTest(String name) {
    super(name);
  }

  /**
   * <code>setUp</code> Load the datasource from the properties in the property file jdbc_en_US.properties
   *
   * @author david berry
   */
  @Override
  public void setUp() {
    String method = "setUp:";

    try {
      cpoAdapter = CpoAdapterFactory.getCpoAdapter(JdbcStatics.ADAPTER_CONTEXT_JDBC);
      assertNotNull(method + "IdoAdapter is null", cpoAdapter);
    } catch (Exception e) {
      fail(method + e.getMessage());
    }
  }

  public void testRetrieveBeanBadContext() {
    String method = "testRetrieveBeanBadContext:";
    Collection<ValueObject> col = null;


    try {
      ValueObject valObj = new ValueObject();
      col = cpoAdapter.retrieveBeans("BadContext", valObj);
      fail(method + "Test got to unreachable code");
    } catch (CpoException ce) {
      //This is what I am expecting so let it go
      logger.debug("Got a cpo exception");
    } catch (Exception e) {
      fail(method + "Unexpected Exception" + ExceptionHelper.getLocalizedMessage(e));
    }
  }

  public void testRetrieveBeansNullBean() {
    String method = "testRetrieveBeansNullBean:";
    Collection<ValueObject> col = null;


    try {
      ValueObject valObj = null;
      col = cpoAdapter.retrieveBeans(null, valObj);
      fail(method + "Test got to unreachable code");
    } catch (CpoException ce) {
      //This is what I am expecting so let it go
      logger.debug("Got a cpo exception");
    } catch (Exception e) {
      fail(method + "Unexpected Exception" + ExceptionHelper.getLocalizedMessage(e));
    }
  }

  public void testRetrieveBeanNullBean() {
    String method = "testRetrieveBeanNullBean:";
    Collection<ValueObject> col = null;


    try {
      ValueObject valObj = cpoAdapter.retrieveBean(null, null);
      fail(method + "Test got to unreachable code");
    } catch (CpoException ce) {
      //This is what I am expecting so let it go
      logger.debug("Got a cpo exception");
    } catch (Exception e) {
      fail(method + "Unexpected Exception" + ExceptionHelper.getLocalizedMessage(e));
    }
  }

  public void testInsertObjectNullBean() {
    String method = "testInsertObjectNullBean:";
    Collection<ValueObject> col = null;


    try {
      ValueObject valObj = null;
      cpoAdapter.insertObject(null, valObj);
      fail(method + "Test got to unreachable code");
    } catch (CpoException ce) {
      //This is what I am expecting so let it go
      logger.debug("Got a cpo exception");
    } catch (Exception e) {
      fail(method + "Unexpected Exception" + ExceptionHelper.getLocalizedMessage(e));
    }
  }

  public void testRetrieveBeanNullContext() {
    String method = "testRetrieveBeanNullContext:";
    Collection<LobValueObject> lvos = null;


    try {
      LobValueObject lvo = new LobValueObject();
      logger.debug("Calling the NULL List");
      lvos = cpoAdapter.retrieveBeans(null, lvo);
      logger.debug("Called the NULL List");
      fail(method + "Test got to unreachable code");
    } catch (CpoException ce) {
      //This is what I am expecting so let it go
      //This is what I am expecting so let it go
      logger.debug("Got a cpo exception");
    } catch (Exception e) {
      fail(method + "Unexpected Exception" + ExceptionHelper.getLocalizedMessage(e));
    }
  }
}
