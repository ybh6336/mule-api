/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.component.execution;

import org.mule.api.annotation.NoImplement;
import org.mule.runtime.api.component.Component;
import org.mule.runtime.api.component.location.Location;
import org.mule.runtime.api.event.Event;

import java.util.concurrent.CompletableFuture;

/**
 * Service capable of executing a component from a deployed application.
 *
 * @since 1.4.0
 */
@NoImplement
public interface ExecutionService {

  /**
   * Key under which the {@link ExecutionService} can be found in the {@link org.mule.runtime.api.artifact.Registry}
   */
  String EXECUTION_SERVICE_KEY = "_muleExecutionService";

  /**
   * Key under which the non lazy {@link ExecutionService} can be found in the {@link org.mule.runtime.api.artifact.Registry}
   */
  String NON_LAZY_EXECUTION_SERVICE_KEY = "_muleNonLazyExecutionService";

  /**
   * Executes the {@link Component} present in the given {@link Location} with the provided {@link Event} information.
   * @param location {@link Location} for the {@link Component} to be executed
   * @param event {@link Event} with the input information
   * @return a {@link CompletableFuture<Event>} that when completed,returns the {@link Event} that results of executing the {@link Component} in the given {@link Location} with the provided input {@link Event}
   */
  CompletableFuture<Event> execute(Location location, Event event);

}
