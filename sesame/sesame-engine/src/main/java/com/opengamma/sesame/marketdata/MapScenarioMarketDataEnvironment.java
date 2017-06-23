/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame.marketdata;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

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

/**
 * Contains market data for scenarios, keyed by scenario ID.
 * <p>
 * The data is stored in the map in the order the scenarios were added
 */
@BeanDefinition
public class MapScenarioMarketDataEnvironment implements ScenarioMarketDataEnvironment, ImmutableBean, Serializable {

  /** The market data for each scenario, keyed by scenario ID */
  @PropertyDefinition(validate = "notNull")
  private final ImmutableMap<String, MarketDataEnvironment> _data;

  /**
   * Creates a new environment backed by a map.
   *
   * @param scenarioData a map of market data keyed by scenario ID. This is an {@code ImmutableMap} because it
   *   stores and returns entries in insertion order.
   */
  public MapScenarioMarketDataEnvironment(ImmutableMap<String, MarketDataEnvironment> scenarioData) {
    _data = ImmutableMap.copyOf(scenarioData);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code MapScenarioMarketDataEnvironment}.
   * @return the meta-bean, not null
   */
  public static MapScenarioMarketDataEnvironment.Meta meta() {
    return MapScenarioMarketDataEnvironment.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(MapScenarioMarketDataEnvironment.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static MapScenarioMarketDataEnvironment.Builder builder() {
    return new MapScenarioMarketDataEnvironment.Builder();
  }

  /**
   * Restricted constructor.
   * @param builder  the builder to copy from, not null
   */
  protected MapScenarioMarketDataEnvironment(MapScenarioMarketDataEnvironment.Builder builder) {
    JodaBeanUtils.notNull(builder._data, "data");
    this._data = ImmutableMap.copyOf(builder._data);
  }

  @Override
  public MapScenarioMarketDataEnvironment.Meta metaBean() {
    return MapScenarioMarketDataEnvironment.Meta.INSTANCE;
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
   * Gets the market data for each scenario, keyed by scenario ID
   * @return the value of the property, not null
   */
  public ImmutableMap<String, MarketDataEnvironment> getData() {
    return _data;
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
      MapScenarioMarketDataEnvironment other = (MapScenarioMarketDataEnvironment) obj;
      return JodaBeanUtils.equal(getData(), other.getData());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getData());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("MapScenarioMarketDataEnvironment{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("data").append('=').append(JodaBeanUtils.toString(getData())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code MapScenarioMarketDataEnvironment}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code data} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<ImmutableMap<String, MarketDataEnvironment>> _data = DirectMetaProperty.ofImmutable(
        this, "data", MapScenarioMarketDataEnvironment.class, (Class) ImmutableMap.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "data");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3076010:  // data
          return _data;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public MapScenarioMarketDataEnvironment.Builder builder() {
      return new MapScenarioMarketDataEnvironment.Builder();
    }

    @Override
    public Class<? extends MapScenarioMarketDataEnvironment> beanType() {
      return MapScenarioMarketDataEnvironment.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code data} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ImmutableMap<String, MarketDataEnvironment>> data() {
      return _data;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 3076010:  // data
          return ((MapScenarioMarketDataEnvironment) bean).getData();
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
   * The bean-builder for {@code MapScenarioMarketDataEnvironment}.
   */
  public static class Builder extends DirectFieldsBeanBuilder<MapScenarioMarketDataEnvironment> {

    private Map<String, MarketDataEnvironment> _data = new HashMap<String, MarketDataEnvironment>();

    /**
     * Restricted constructor.
     */
    protected Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    protected Builder(MapScenarioMarketDataEnvironment beanToCopy) {
      this._data = new HashMap<String, MarketDataEnvironment>(beanToCopy.getData());
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3076010:  // data
          return _data;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 3076010:  // data
          this._data = (Map<String, MarketDataEnvironment>) newValue;
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
    public MapScenarioMarketDataEnvironment build() {
      return new MapScenarioMarketDataEnvironment(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code data} property in the builder.
     * @param data  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder data(Map<String, MarketDataEnvironment> data) {
      JodaBeanUtils.notNull(data, "data");
      this._data = data;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("MapScenarioMarketDataEnvironment.Builder{");
      int len = buf.length();
      toString(buf);
      if (buf.length() > len) {
        buf.setLength(buf.length() - 2);
      }
      buf.append('}');
      return buf.toString();
    }

    protected void toString(StringBuilder buf) {
      buf.append("data").append('=').append(JodaBeanUtils.toString(_data)).append(',').append(' ');
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}