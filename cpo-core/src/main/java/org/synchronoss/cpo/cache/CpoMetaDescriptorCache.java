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
package org.synchronoss.cpo.cache;

import org.synchronoss.cpo.meta.CpoMetaDescriptor;

import java.util.*;

/**
 * @author dberry
 */
public class CpoMetaDescriptorCache {

  private static final Map<String, CpoMetaDescriptor> metaDescriptorMap = new HashMap<String, CpoMetaDescriptor>();

  protected static CpoMetaDescriptor findCpoMetaDescriptor(String adapterKey) {
    CpoMetaDescriptor metaDescriptor = null;
    if (adapterKey != null) {
      metaDescriptor = metaDescriptorMap.get(adapterKey);
    }

    return metaDescriptor;
  }

  protected static CpoMetaDescriptor addCpoMetaDescriptor(CpoMetaDescriptor metaDescriptor) {
    CpoMetaDescriptor oldMetaDescriptor = null;
    if (metaDescriptor != null && metaDescriptor.getName() != null) {
      oldMetaDescriptor = metaDescriptorMap.put(metaDescriptor.getName(), metaDescriptor);
    }
    return oldMetaDescriptor;
  }

  /**
   * @return A collection of names of all meta descriptors currently loaded
   */
  protected static Collection<String> getCpoMetaDescriptorNames() {
    return metaDescriptorMap.keySet();
  }

  protected static void removeCpoMetaDescriptor(String adapterKey) {
    metaDescriptorMap.remove(adapterKey);
  }

  protected static void clearCpoMetaDescriptorCache() {
    metaDescriptorMap.clear();
  }
}
