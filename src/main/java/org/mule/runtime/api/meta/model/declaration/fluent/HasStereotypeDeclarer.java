/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.meta.model.declaration.fluent;

import org.mule.runtime.api.meta.model.stereotype.StereotypeModel;

/**
 * Contract interface for a declarer in which it's possible
 * to add {@link StereotypeModel}
 *
 * @since 1.0
 */
public interface HasStereotypeDeclarer<T> {

  /**
   * Adds the given {@code stereotype}
   *
   * @param stereotype a {@link org.mule.runtime.api.meta.model.stereotype.StereotypeModel}
   * @return {@code this} declarer
   */
  T withStereotype(StereotypeModel stereotype);

}