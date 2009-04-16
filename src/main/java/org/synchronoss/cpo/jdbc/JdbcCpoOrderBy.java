/**
 * JdbcCpoOrderBy.java
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

import java.util.HashMap;

import org.synchronoss.cpo.CpoException;
import org.synchronoss.cpo.CpoOrderBy;


/**
 * JdbcCpoOrderBy is an interface for specifying the sort order in which 
 * objects are returned from the Datasource.
 * 
 * @author david berry
 */

public class JdbcCpoOrderBy implements CpoOrderBy {


    private boolean ascending;
    private String attribute;
    private String function;
    private String name = "__CPO_ORDERBY__";

    @SuppressWarnings("unused")
    private JdbcCpoOrderBy(){
    }

    public JdbcCpoOrderBy(String attr, boolean asc){
        setAscending(asc);
        setAttribute(attr);
        setFunction(null);
    }

    public JdbcCpoOrderBy(String attr, boolean asc, String func){
        setAscending(asc);
        setAttribute(attr);
        setFunction(func);
    }

    /**
     * Gets the boolean that determines if the objects will be returned from
     * from the CpoAdapter in Ascending order or Descending order
     * 
     * @return boolean true if it is to sort in Ascensing Order
     *                 false if it is to be sorted in Descending Order
     */
    public boolean getAscending(){
        return this.ascending;
    }

    /**
     * Sets the boolean that determines if the objects will be returned from
     * from the CpoAdapter in Ascending order or Descending order
     * 
     * @param b true if it is to sort in Ascensing Order
     *          false if it is to be sorted in Descending Order
     */
    public void setAscending(boolean b){
        this.ascending = b;
    }

    /**
     * Gets the name of the attribute that is to be used to sort the results 
     * from the CpoAdapter.
     * 
     * @return String The name of the attribute
     */
    public String getAttribute(){
        return this.attribute;
    }

    /**
     * Sets the name of the attribute that is to be used to sort the results 
     * from the CpoAdapter.
     * 
     * @param s The name of the attribute
     */
    public void setAttribute(String s){
        this.attribute = s;
    }

    /**
     * Gets a string representing a datasource specific function call that 
     * must be applied to the attribute that will be used for sorting.
     * 
     * i.e. - "upper(attribute_name)"
     * 
     * @return String The name of the function
     */
    public String getFunction(){
        return this.function;
    }

    /**
     * Sets a string representing a datasource specific function call that 
     * must be applied to the attribute that will be used for sorting.
     * 
     * i.e. - "upper(attribute_name)"
     * 
     * @param s The name of the function
     */
    public void setFunction(String s){
        this.function = s;
    }

    public String toString(JdbcMetaClass<?> jmc) throws CpoException {
        StringBuffer sb = new StringBuffer();
        String function = null;
        String attribute = null;
        String column = null;
        int attrOffset = 0;
        int fromIndex = 0;
        HashMap<String,JdbcAttribute> columnMap = jmc.getColumnMap();
        JdbcAttribute jdbcAttribute=null;

        attribute = this.getAttribute();
        function = this.getFunction();
        if(attribute != null && attribute.length()>0) {
            jdbcAttribute = (JdbcAttribute) columnMap.get(attribute);
            if (jdbcAttribute == null) {
            	throw new CpoException(attribute);
            }
            sb.append(" ");

            column = jdbcAttribute.getDbName();
            if(column != null && column.length()>0) {
                if(function!=null && function.length()>0) {
                    while((attrOffset=function.indexOf(attribute, fromIndex))!=-1){
                             sb.append(function.substring(0,attrOffset));
                             sb.append(column);
                             fromIndex+=attrOffset+attribute.length();
                    }
                    sb.append(function.substring(fromIndex));
                } else {
                    sb.append(column);
                }
            }

            if(this.getAscending()==true) {
                sb.append(" ASC");
            } else {
                sb.append(" DESC");
            }
        }

        return sb.toString();
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

}
