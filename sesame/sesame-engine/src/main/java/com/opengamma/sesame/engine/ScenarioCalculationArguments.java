/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.annotation.Nullable;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableMap;
import com.opengamma.util.ArgumentChecker;

/**
 * Arguments specifying how calculations should be run for a set of scenarios.
 * <p>
 * There is a default set of arguments and a set for the scenarios, keyed by scenario ID. If arguments are requested
 * for a scenario and none are available, the default set is returned. If there are no defaults an
 * {@code IllegalStateException} is thrown.
 */
@BeanDefinition
public final class ScenarioCalculationArguments implements ImmutableBean {

  /** The default arguments for scenarios that don't have any specified. */
  @Nullable
  @PropertyDefinition(get = "private")
  private final CalculationArguments _defaultArguments;

  /** Arguments for specific scenarios, keyed by scenario name. */
  @PropertyDefinition(validate = "notNull", get = "private")
  private final ImmutableMap<String, CalculationArguments> _scenarioArguments;

  /**
   * Creates an instance that uses the same set of arguments for all scenarios.
   *
   * @param arguments the arguments used for all scenarios
   * @return a new instance that returns the same arguments for all scenarios
   */
  public static ScenarioCalculationArguments of(CalculationArguments arguments) {
    ArgumentChecker.notNull(arguments, "arguments");
    return new ScenarioCalculationArguments(arguments, ImmutableMap.<String, CalculationArguments>of());
  }

  /**
   * Creates a new instance with default arguments plus arguments for specific scenarios.
   *
   * @param defaultArguments the default arguments to use for scenarios where no specific arguments are available
   * @param scenarioArguments the arguments for specific scenarios, keyed by scenario name
   * @return a new instance with default and scenario-specific arguments
   */
  public static ScenarioCalculationArguments of(CalculationArguments defaultArguments,
                                                Map<String, CalculationArguments> scenarioArguments) {
    ArgumentChecker.notNull(defaultArguments, "defaultArguments");
    return new ScenarioCalculationArguments(defaultArguments, scenarioArguments);
  }

  /**
   * Creates a new instance with arguments for specific scenarios.
   * <p>
   * If no arguments are available for a scenario an {@code IllegalStateException} will be thrown when
   * {@link #argumentsForScenario(String)} is called.
   *
   * @param scenarioArguments the arguments for specific scenarios, keyed by scenario name
   * @return a new instance with default and scenario-specific arguments
   */
  public static ScenarioCalculationArguments of(Map<String, CalculationArguments> scenarioArguments) {
    return new ScenarioCalculationArguments(null, scenarioArguments);
  }

  /**
   * Returns the arguments for a named scenario, or the default arguments if there isn't a set for the scenario.
   * <p>
   * If there are no arguments for the scenario and no defaults an {@code IllegalStateException} is thrown.
   *
   * @param scenarioName the name of the scenario
   * @return arguments for performing calculations for the scenario
   * @throws IllegalStateException if there are no arguments for the scenario and no default arguments
   */
  public CalculationArguments argumentsForScenario(String scenarioName) {
    CalculationArguments scenarioArguments = _scenarioArguments.get(scenarioName);

    if (scenarioArguments != null) {
      return scenarioArguments;
    }
    if (_defaultArguments == null) {
      throw new IllegalStateException("No arguments available for scenario " + scenarioName + ", no defaults available");
    }
    return _defaultArguments;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ScenarioCalculationArguments}.
   * @return the meta-bean, not null
   */
  public static ScenarioCalculationArguments.Meta meta() {
    return ScenarioCalculationArguments.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ScenarioCalculationArguments.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ScenarioCalculationArguments.Builder builder() {
    return new ScenarioCalculationArguments.Builder();
  }

  private ScenarioCalculationArguments(
      CalculationArguments defaultArguments,
      Map<String, CalculationArguments> scenarioArguments) {
    JodaBeanUtils.notNull(scenarioArguments, "scenarioArguments");
    this._defaultArguments = defaultArguments;
    this._scenarioArguments = ImmutableMap.copyOf(scenarioArguments);
  }

  @Override
  public ScenarioCalculationArguments.Meta metaBean() {
    return ScenarioCalculationArguments.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the default arguments for scenarios that don't have any specified.
   * @return the value of the property
   */
  private CalculationArguments getDefaultArguments() {
    return _defaultArguments;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets arguments for specific scenarios, keyed by scenario name.
   * @return the value of the property, not null
   */
  private ImmutableMap<String, CalculationArguments> getScenarioArguments() {
    return _scenarioArguments;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ScenarioCalculationArguments other = (ScenarioCalculationArguments) obj;
      return JodaBeanUtils.equal(getDefaultArguments(), other.getDefaultArguments()) &&
          JodaBeanUtils.equal(getScenarioArguments(), other.getScenarioArguments());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getDefaultArguments());
    hash = hash * 31 + JodaBeanUtils.hashCode(getScenarioArguments());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("ScenarioCalculationArguments{");
    buf.append("defaultArguments").append('=').append(getDefaultArguments()).append(',').append(' ');
    buf.append("scenarioArguments").append('=').append(JodaBeanUtils.toString(getScenarioArguments()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ScenarioCalculationArguments}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code defaultArguments} property.
     */
    private final MetaProperty<CalculationArguments> _defaultArguments = DirectMetaProperty.ofImmutable(
        this, "defaultArguments", ScenarioCalculationArguments.class, CalculationArguments.class);
    /**
     * The meta-property for the {@code scenarioArguments} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<ImmutableMap<String, CalculationArguments>> _scenarioArguments = DirectMetaProperty.ofImmutable(
        this, "scenarioArguments", ScenarioCalculationArguments.class, (Class) ImmutableMap.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "defaultArguments",
        "scenarioArguments");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -224314347:  // defaultArguments
          return _defaultArguments;
        case -1055250522:  // scenarioArguments
          return _scenarioArguments;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ScenarioCalculationArguments.Builder builder() {
      return new ScenarioCalculationArguments.Builder();
    }

    @Override
    public Class<? extends ScenarioCalculationArguments> beanType() {
      return ScenarioCalculationArguments.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code defaultArguments} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CalculationArguments> defaultArguments() {
      return _defaultArguments;
    }

    /**
     * The meta-property for the {@code scenarioArguments} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ImmutableMap<String, CalculationArguments>> scenarioArguments() {
      return _scenarioArguments;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -224314347:  // defaultArguments
          return ((ScenarioCalculationArguments) bean).getDefaultArguments();
        case -1055250522:  // scenarioArguments
          return ((ScenarioCalculationArguments) bean).getScenarioArguments();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code ScenarioCalculationArguments}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<ScenarioCalculationArguments> {

    private CalculationArguments _defaultArguments;
    private Map<String, CalculationArguments> _scenarioArguments = new HashMap<String, CalculationArguments>();

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(ScenarioCalculationArguments beanToCopy) {
      this._defaultArguments = beanToCopy.getDefaultArguments();
      this._scenarioArguments = new HashMap<String, CalculationArguments>(beanToCopy.getScenarioArguments());
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -224314347:  // defaultArguments
          return _defaultArguments;
        case -1055250522:  // scenarioArguments
          return _scenarioArguments;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -224314347:  // defaultArguments
          this._defaultArguments = (CalculationArguments) newValue;
          break;
        case -1055250522:  // scenarioArguments
          this._scenarioArguments = (Map<String, CalculationArguments>) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public ScenarioCalculationArguments build() {
      return new ScenarioCalculationArguments(
          _defaultArguments,
          _scenarioArguments);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code defaultArguments} property in the builder.
     * @param defaultArguments  the new value
     * @return this, for chaining, not null
     */
    public Builder defaultArguments(CalculationArguments defaultArguments) {
      this._defaultArguments = defaultArguments;
      return this;
    }

    /**
     * Sets the {@code scenarioArguments} property in the builder.
     * @param scenarioArguments  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder scenarioArguments(Map<String, CalculationArguments> scenarioArguments) {
      JodaBeanUtils.notNull(scenarioArguments, "scenarioArguments");
      this._scenarioArguments = scenarioArguments;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("ScenarioCalculationArguments.Builder{");
      buf.append("defaultArguments").append('=').append(JodaBeanUtils.toString(_defaultArguments)).append(',').append(' ');
      buf.append("scenarioArguments").append('=').append(JodaBeanUtils.toString(_scenarioArguments));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}