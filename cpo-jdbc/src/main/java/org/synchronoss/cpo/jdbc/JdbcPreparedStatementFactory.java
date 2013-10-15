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
package org.synchronoss.cpo.jdbc;

import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.synchronoss.cpo.*;
import org.synchronoss.cpo.helper.ExceptionHelper;
import org.synchronoss.cpo.jdbc.meta.JdbcMethodMapEntry;
import org.synchronoss.cpo.jdbc.meta.JdbcMethodMapper;
import org.synchronoss.cpo.meta.MethodMapper;
import org.synchronoss.cpo.meta.domain.CpoArgument;
import org.synchronoss.cpo.meta.domain.CpoAttribute;
import org.synchronoss.cpo.meta.domain.CpoClass;
import org.synchronoss.cpo.meta.domain.CpoFunction;

/**
 * JdbcPreparedStatementFactory is the object that encapsulates the creation of the actual PreparedStatement for the
 * JDBC driver.
 *
 * @author david berry
 */
public class JdbcPreparedStatementFactory extends CpoStatementFactory implements CpoReleasible {

  /**
   * Version Id for this class.
   */
  private static final long serialVersionUID = 1L;
  /**
   * DOCUMENT ME!
   */
  private static final Logger logger = LoggerFactory.getLogger(JdbcPreparedStatementFactory.class);
  private PreparedStatement ps_ = null;

  private List<CpoReleasible> releasibles = new ArrayList<CpoReleasible>();
  private static final String WHERE_MARKER = "__CPO_WHERE__";
  private static final String ORDERBY_MARKER = "__CPO_ORDERBY__";

  /**
   * Used to build the PreparedStatement that is used by CPO to create the actual JDBC PreparedStatement.
   *
   * The constructor is called by the internal CPO framework. This is not to be used by users of CPO. Programmers that
   * build Transforms may need to use this object to get access to the actual connection.
   *
   * @param conn The actual jdbc connection that will be used to create the callable statement.
   * @param jca The JdbcCpoAdapter that is controlling this transaction
   * @param criteria The object that will be used to look up the cpo meta data
   * @param function The CpoFunction that is being executed
   * @param obj The pojo that is being acted upon
   * @param wheres DOCUMENT ME!
   * @param orderBy DOCUMENT ME!
   * @param nativeQueries Additional sql to be embedded into the CpoFunction sql that is used to create the actual JDBC
   * PreparedStatement
   *
   * @throws CpoException if a CPO error occurs
   * @throws SQLException if a JDBC error occurs
   */
  public <T> JdbcPreparedStatementFactory(Connection conn, JdbcCpoAdapter jca, CpoClass criteria,
          CpoFunction function, T obj, Collection<CpoWhere> wheres, Collection<CpoOrderBy> orderBy,
          Collection<CpoNativeFunction> nativeQueries) throws CpoException {
    super(obj == null ? logger : LoggerFactory.getLogger(obj.getClass()));
    // get the list of bindValues from the function parameters
    List<BindAttribute> bindValues = getBindValues(function, obj);

    String sql = buildSql(criteria, function.getExpression(), wheres, orderBy, nativeQueries, bindValues);

    getLocalLogger().debug("CpoFunction SQL = <" + sql + ">");

    PreparedStatement pstmt = null;

    try {
      pstmt = conn.prepareStatement(sql);
    } catch (SQLException se) {
      getLocalLogger().error("Error Instantiating JdbcPreparedStatementFactory SQL=<" + sql + ">" + ExceptionHelper.getLocalizedMessage(se));
      throw new CpoException(se);
    }
    setPreparedStatement(pstmt);

    setBindValues(bindValues);

  }

  @Override
  protected MethodMapper getMethodMapper() {
    return JdbcMethodMapper.getMethodMapper();  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  protected CpoData getCpoData(CpoAttribute cpoAttribute, int index) {
    return new JdbcPreparedStatementCpoData(this, cpoAttribute, index);  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  protected Object getBindableStatement() {
    return getPreparedStatement();
  }

  @Override
  protected int getStartingIndex() {
    return 1;
  }

  /**
    * Returns the jdbc prepared statment associated with this object
    */
   public PreparedStatement getPreparedStatement() {
     return ps_;
   }

   protected void setPreparedStatement(PreparedStatement ps) {
     ps_ = ps;
   }

}
