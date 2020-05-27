/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.metadata;


import org.mule.api.annotation.NoImplement;
import org.mule.runtime.app.declaration.api.ConnectionElementDeclaration;

import java.util.List;
import java.util.Map;

//TODO: Validate name
@NoImplement
public interface DataProviderService {

  Map<String, List<String>> getValues(ConnectionElementDeclaration connectionDeclaration);

}
