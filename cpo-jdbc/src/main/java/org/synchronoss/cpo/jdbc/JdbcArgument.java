/**
 * JdbcArgument.java
 * 
 *  Copyright (C) 2006  David E. Berry
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

import org.synchronoss.cpo.meta.domain.CpoArgument;


/**
 * JdbcArgument is a class that maps traditional java classes to tables in a 
 * jdbc database. 
 * 
 * @author david berry
 */

public class JdbcArgument extends CpoArgument implements java.io.Serializable, java.lang.Cloneable {

	/**
     * Version Id for this class.
     */
	private static final long serialVersionUID = 1L;
	

    private static final String IN_PARAMETER = "IN";
    private static final String OUT_PARAMETER = "OUT";
    private static final String INOUT_PARAMETER = "BOTH";
    private String executeType = null;

    public JdbcArgument(JdbcAttribute attribute){
      super(attribute);
    }

    public JdbcArgument(JdbcAttribute attribute, String executeType){
      super(attribute);
      this.executeType=executeType;
    }

  @Override
    public JdbcAttribute getAttribute() {
      return (JdbcAttribute) super.getAttribute();
    }

    public boolean isInParameter(){
        return IN_PARAMETER.equals(getExecuteType()) || INOUT_PARAMETER.equals(getExecuteType());
    }

    public boolean isOutParameter(){
        return OUT_PARAMETER.equals(getExecuteType()) || INOUT_PARAMETER.equals(getExecuteType());
    }
    
  public String getExecuteType() {
    return executeType;
  }

  public void setExecuteType(String executeType) {
    this.executeType = executeType;
  }

}