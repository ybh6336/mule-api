/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.meta.model.parameter;

import static org.mule.runtime.api.util.Preconditions.checkNotNull;

import org.mule.api.annotation.NoExtend;
import org.mule.api.annotation.NoInstantiate;
import org.mule.runtime.api.value.Value;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Model for {@link ParameterModel} to communicate if one of these are capable to provide {@link Value values}.
 * <p>
 * The element with this model will considered as a one that provides values.
 *
 * @since 1.0
 */
@NoInstantiate
public final class ValueProviderModel {

  private final List<String> actingParameters;
  private final Integer partOrder;
  private final String providerName;
  private final String providerId;
  private final boolean requiresConfiguration;
  private final boolean requiresConnection;
  private final boolean isOpen;

  /**
   * Creates a new instance
   *
   * @param actingParameters      the list of parameters that are required to execute the Value Provider resolution
   * @param requiresConfiguration indicates if the configuration is required to resolve the values
   * @param requiresConnection    indicates if the connection is required to resolve the values
   * @param isOpen                indicates if the calculated values should be considered as an open or closed set
   * @param partOrder             the position in the value
   * @param providerName          the category of the associated value provider for this parameter
   *
   * @deprecated the {@link ValueProviderModel} must specify a providerId, use
   *             {@link ValueProviderModel#ValueProviderModel(java.util.List, boolean, boolean, boolean, java.lang.Integer, java.lang.String, java.lang.String)
   *             instead}.
   */
  @Deprecated
  public ValueProviderModel(List<String> actingParameters, boolean requiresConfiguration, boolean requiresConnection,
                            boolean isOpen,
                            Integer partOrder, String providerName) {
    this(actingParameters, requiresConfiguration, requiresConnection, isOpen, partOrder, providerName, providerName);
  }

  /**
   * Creates a new instance
   *
   * @param actingParameters      the list of parameters that are required to execute the Value Provider resolution
   * @param requiresConfiguration indicates if the configuration is required to resolve the values
   * @param requiresConnection    indicates if the connection is required to resolve the values
   * @param isOpen                indicates if the calculated values should be considered as an open or closed set
   * @param partOrder             the position in the value
   * @param providerName          the category of the associated value provider for this parameter
   * @param providerId            the id of the associated value provider for this parameter
   *
   * @since 1.4.0
   */
  public ValueProviderModel(List<String> actingParameters, boolean requiresConfiguration, boolean requiresConnection,
                            boolean isOpen,
                            Integer partOrder, String providerName, String providerId) {
    checkNotNull(actingParameters, "'actingParameters' can't be null");
    checkNotNull(partOrder, "'valueParts' can't be null");
    checkNotNull(providerName, "'providerName' can't be null");
    checkNotNull(providerId, "'providerId' can't be null");
    this.isOpen = isOpen;
    this.actingParameters = actingParameters;
    this.requiresConfiguration = requiresConfiguration;
    this.requiresConnection = requiresConnection;
    this.partOrder = partOrder;
    this.providerName = providerName;
    this.providerId = providerId;
  }

  /**
   * @return the list of parameters that are required to execute the Value Provider resolution.
   */
  public List<String> getActingParameters() {
    return actingParameters;
  }

  /**
   * @return the order of this part in the value
   */
  public Integer getPartOrder() {
    return partOrder;
  }

  /**
   * @return The name of the element that provides values
   */
  public String getProviderName() {
    return providerName;
  }

  /**
   * @return The id of the element that provides values
   * @since 1.4.0
   */
  public String getProviderId() {
    return providerId;
  }

  /**
   * @return a boolean indicating if the configuration is required to resolve the values
   */
  public boolean requiresConfiguration() {
    return requiresConfiguration;
  }

  /**
   * @return a boolean indicating if the connection is required to resolve the values
   */
  public boolean requiresConnection() {
    return requiresConnection;
  }

  /**
   * @return a boolean indicating if the calculated values should be considered as an open or closed set
   */
  public boolean isOpen() {
    return isOpen;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ValueProviderModel that = (ValueProviderModel) o;

    return new EqualsBuilder()
        .append(actingParameters, that.actingParameters)
        .append(partOrder, that.partOrder)
        .append(providerName, that.providerName)
        .append(providerId, that.providerId)
        .append(requiresConnection, that.requiresConnection)
        .append(requiresConfiguration, that.requiresConfiguration)
        .append(isOpen, that.isOpen)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(actingParameters)
        .append(partOrder)
        .append(providerName)
        .append(providerId)
        .append(requiresConnection)
        .append(requiresConfiguration)
        .append(isOpen)
        .toHashCode();
  }
}
