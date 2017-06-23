/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.master.security;

import java.io.Serializable;
import java.util.Map;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.id.UniqueId;
import com.opengamma.master.AbstractDocument;
import com.opengamma.util.ArgumentChecker;
import com.opengamma.util.PublicSPI;

/**
 * A document used to pass into and out of the security master.
 */
@PublicSPI
@BeanDefinition
public class SecurityDocument extends AbstractDocument implements Serializable {

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * The security object held by the document.
   */
  @PropertyDefinition
  private ManageableSecurity _security;
  /**
   * The security unique identifier.
   * This field is managed by the master but must be set for updates.
   */
  @PropertyDefinition
  private UniqueId _uniqueId;

  /**
   * Creates an instance.
   */
  public SecurityDocument() {
  }

  /**
   * Creates an instance from a security.
   * @param security  the security, not null
   */
  public SecurityDocument(final ManageableSecurity security) {
    ArgumentChecker.notNull(security, "security");
    setUniqueId(security.getUniqueId());
    setSecurity(security);
  }

  //-------------------------------------------------------------------------
  @Override
  public ManageableSecurity getValue() {
    return getSecurity();
  }

  /**
   * Gets the name of the security.
   * <p>
   * This is derived from the security itself.
   * @return the name, null if no name
   */
  public String getName() {
    return (getSecurity() != null ? getSecurity().getName() : null);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code SecurityDocument}.
   * @return the meta-bean, not null
   */
  public static SecurityDocument.Meta meta() {
    return SecurityDocument.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(SecurityDocument.Meta.INSTANCE);
  }

  @Override
  public SecurityDocument.Meta metaBean() {
    return SecurityDocument.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the security object held by the document.
   * @return the value of the property
   */
  public ManageableSecurity getSecurity() {
    return _security;
  }

  /**
   * Sets the security object held by the document.
   * @param security  the new value of the property
   */
  public void setSecurity(ManageableSecurity security) {
    this._security = security;
  }

  /**
   * Gets the the {@code security} property.
   * @return the property, not null
   */
  public final Property<ManageableSecurity> security() {
    return metaBean().security().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the security unique identifier.
   * This field is managed by the master but must be set for updates.
   * @return the value of the property
   */
  public UniqueId getUniqueId() {
    return _uniqueId;
  }

  /**
   * Sets the security unique identifier.
   * This field is managed by the master but must be set for updates.
   * @param uniqueId  the new value of the property
   */
  public void setUniqueId(UniqueId uniqueId) {
    this._uniqueId = uniqueId;
  }

  /**
   * Gets the the {@code uniqueId} property.
   * This field is managed by the master but must be set for updates.
   * @return the property, not null
   */
  public final Property<UniqueId> uniqueId() {
    return metaBean().uniqueId().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public SecurityDocument clone() {
    return JodaBeanUtils.cloneAlways(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      SecurityDocument other = (SecurityDocument) obj;
      return JodaBeanUtils.equal(getSecurity(), other.getSecurity()) &&
          JodaBeanUtils.equal(getUniqueId(), other.getUniqueId()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = hash * 31 + JodaBeanUtils.hashCode(getSecurity());
    hash = hash * 31 + JodaBeanUtils.hashCode(getUniqueId());
    return hash ^ super.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("SecurityDocument{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  @Override
  protected void toString(StringBuilder buf) {
    super.toString(buf);
    buf.append("security").append('=').append(JodaBeanUtils.toString(getSecurity())).append(',').append(' ');
    buf.append("uniqueId").append('=').append(JodaBeanUtils.toString(getUniqueId())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code SecurityDocument}.
   */
  public static class Meta extends AbstractDocument.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code security} property.
     */
    private final MetaProperty<ManageableSecurity> _security = DirectMetaProperty.ofReadWrite(
        this, "security", SecurityDocument.class, ManageableSecurity.class);
    /**
     * The meta-property for the {@code uniqueId} property.
     */
    private final MetaProperty<UniqueId> _uniqueId = DirectMetaProperty.ofReadWrite(
        this, "uniqueId", SecurityDocument.class, UniqueId.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "security",
        "uniqueId");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 949122880:  // security
          return _security;
        case -294460212:  // uniqueId
          return _uniqueId;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends SecurityDocument> builder() {
      return new DirectBeanBuilder<SecurityDocument>(new SecurityDocument());
    }

    @Override
    public Class<? extends SecurityDocument> beanType() {
      return SecurityDocument.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code security} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ManageableSecurity> security() {
      return _security;
    }

    /**
     * The meta-property for the {@code uniqueId} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<UniqueId> uniqueId() {
      return _uniqueId;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 949122880:  // security
          return ((SecurityDocument) bean).getSecurity();
        case -294460212:  // uniqueId
          return ((SecurityDocument) bean).getUniqueId();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 949122880:  // security
          ((SecurityDocument) bean).setSecurity((ManageableSecurity) newValue);
          return;
        case -294460212:  // uniqueId
          ((SecurityDocument) bean).setUniqueId((UniqueId) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}