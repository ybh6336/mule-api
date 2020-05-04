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
   * Executes the {@link Component} present in the given {@link Location} with the provided {@link Event} information.
   * @param location {@link Location} for the {@link Component} to be executed
   * @param event {@link Event} with the input information
   * @return a {@link CompletableFuture<Event>} that when completed,returns the {@link Event} that results of executing the {@link Component} in the given {@link Location} with the provided input {@link Event}
   */
  CompletableFuture<Event> execute(Location location, Event event);

}
