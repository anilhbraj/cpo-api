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
package org.synchronoss.cpo.transform.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.synchronoss.cpo.CpoException;
import org.synchronoss.cpo.jdbc.JdbcCallableStatementFactory;
import org.synchronoss.cpo.jdbc.JdbcPreparedStatementFactory;

/**
 * This is an example of a transform that does nothing. It is used to test the mechanics of the transform logic within
 * CPO.
 *
 * @author david berry
 */
public class TransformNoOp implements JdbcTransform<Integer, Integer> {

  private static Logger logger = LoggerFactory.getLogger(TransformNoOp.class.getName());

  public TransformNoOp() {
  }

  /**
   * Transforms the datasource object into an object required by the class. The type of the dbIn parameter and the type
   * of the return value must change to match the types being converted. Reflection is used to true everything up at
   * runtime.
   *
   * e.g public byte[] transformIn(Blob dbIn) would be the signature for converting a Blob to a byte[] to be stored in
   * the pojo.
   *
   * @param dbIn The value from the datasource that will be transformed into the format that is required by the pojo.
   * @return The object to be stored in the attribute
   * @throws CpoException
   */
  public Integer transformIn(Integer dbIn)
          throws CpoException {
    logger.debug("Inside TransformNoOp::transformIn(" + dbIn + ");");
    return dbIn;
  }

  /**
   * Transforms the data from the class attribute to the object required by the datasource. The type of the attrOut
   * parameter and the type of the return value must change to match the types being converted. Reflection is used to
   * true everything up at runtime.
   *
   * e.g public Blob transformOut(JdbcCallableStatementFactory jcsf, byte[] attrOut) would be the signature for
   * converting a byte[] stored in the pojo into a Blob object for the datasource.
   *
   *
   * @param jcsf a reference to the JdbcCallableStatementFactory. This is necessary as some DBMSs (ORACLE !#$%^&!) that
   * require access to the connection to deal with certain datatypes.
   * @param attrOut The attribute object that needs to get transformed into the db representation
   * @return The object to be stored in the datasource
   * @throws CpoException
   */
  public Integer transformOut(JdbcCallableStatementFactory jcsf, Integer attrOut)
          throws CpoException {
    logger.debug("Inside TransformNoOp::transformOut(JdbcCallableStatementFactory, " + attrOut + ");");
    return attrOut;
  }

  /**
   * Transforms the data from the class attribute to the object required by the datasource. The type of the attrOut
   * parameter and the type of the return value must change to match the types being converted. Reflection is used to
   * true everything up at runtime.
   *
   * e.g public Blob transformOut(JdbcPreparedStatementFactory jpsf, byte[] attrOut) would be the signature for
   * converting a byte[] stored in the pojo into a Blob object for the datasource.
   *
   *
   * @param jpsf a reference to the JdbcPreparedStatementFactory. This is necessary as some DBMSs (ORACLE !#$%^&!) that
   * require access to the connection to deal with certain datatypes.
   * @param attrOut The attribute object that needs to get transformed into the db representation
   * @return The object to be stored in the datasource
   * @throws CpoException
   */
  public Integer transformOut(JdbcPreparedStatementFactory jpsf, Integer attrOut)
          throws CpoException {
    logger.debug("Inside TransformNoOp::transformOut(JdbcPreparedStatementFactory, " + attrOut + ");");
    return attrOut;
  }

  @Override
  public Integer transformOut(Integer j) throws CpoException, UnsupportedOperationException {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
