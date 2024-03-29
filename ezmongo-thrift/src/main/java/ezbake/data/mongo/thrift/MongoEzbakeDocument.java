/*   Copyright (C) 2013-2014 Computer Sciences Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package ezbake.data.mongo.thrift;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoEzbakeDocument implements org.apache.thrift.TBase<MongoEzbakeDocument, MongoEzbakeDocument._Fields>, java.io.Serializable, Cloneable, Comparable<MongoEzbakeDocument> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MongoEzbakeDocument");

  private static final org.apache.thrift.protocol.TField JSON_DOCUMENT_FIELD_DESC = new org.apache.thrift.protocol.TField("jsonDocument", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField VISIBILITY_FIELD_DESC = new org.apache.thrift.protocol.TField("visibility", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MongoEzbakeDocumentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MongoEzbakeDocumentTupleSchemeFactory());
  }

  public String jsonDocument; // required
  public ezbake.base.thrift.Visibility visibility; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    JSON_DOCUMENT((short)1, "jsonDocument"),
    VISIBILITY((short)2, "visibility");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // JSON_DOCUMENT
          return JSON_DOCUMENT;
        case 2: // VISIBILITY
          return VISIBILITY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.JSON_DOCUMENT, new org.apache.thrift.meta_data.FieldMetaData("jsonDocument", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VISIBILITY, new org.apache.thrift.meta_data.FieldMetaData("visibility", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ezbake.base.thrift.Visibility.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MongoEzbakeDocument.class, metaDataMap);
  }

  public MongoEzbakeDocument() {
  }

  public MongoEzbakeDocument(
    String jsonDocument,
    ezbake.base.thrift.Visibility visibility)
  {
    this();
    this.jsonDocument = jsonDocument;
    this.visibility = visibility;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MongoEzbakeDocument(MongoEzbakeDocument other) {
    if (other.isSetJsonDocument()) {
      this.jsonDocument = other.jsonDocument;
    }
    if (other.isSetVisibility()) {
      this.visibility = new ezbake.base.thrift.Visibility(other.visibility);
    }
  }

  public MongoEzbakeDocument deepCopy() {
    return new MongoEzbakeDocument(this);
  }

  @Override
  public void clear() {
    this.jsonDocument = null;
    this.visibility = null;
  }

  public String getJsonDocument() {
    return this.jsonDocument;
  }

  public MongoEzbakeDocument setJsonDocument(String jsonDocument) {
    this.jsonDocument = jsonDocument;
    return this;
  }

  public void unsetJsonDocument() {
    this.jsonDocument = null;
  }

  /** Returns true if field jsonDocument is set (has been assigned a value) and false otherwise */
  public boolean isSetJsonDocument() {
    return this.jsonDocument != null;
  }

  public void setJsonDocumentIsSet(boolean value) {
    if (!value) {
      this.jsonDocument = null;
    }
  }

  public ezbake.base.thrift.Visibility getVisibility() {
    return this.visibility;
  }

  public MongoEzbakeDocument setVisibility(ezbake.base.thrift.Visibility visibility) {
    this.visibility = visibility;
    return this;
  }

  public void unsetVisibility() {
    this.visibility = null;
  }

  /** Returns true if field visibility is set (has been assigned a value) and false otherwise */
  public boolean isSetVisibility() {
    return this.visibility != null;
  }

  public void setVisibilityIsSet(boolean value) {
    if (!value) {
      this.visibility = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case JSON_DOCUMENT:
      if (value == null) {
        unsetJsonDocument();
      } else {
        setJsonDocument((String)value);
      }
      break;

    case VISIBILITY:
      if (value == null) {
        unsetVisibility();
      } else {
        setVisibility((ezbake.base.thrift.Visibility)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case JSON_DOCUMENT:
      return getJsonDocument();

    case VISIBILITY:
      return getVisibility();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case JSON_DOCUMENT:
      return isSetJsonDocument();
    case VISIBILITY:
      return isSetVisibility();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MongoEzbakeDocument)
      return this.equals((MongoEzbakeDocument)that);
    return false;
  }

  public boolean equals(MongoEzbakeDocument that) {
    if (that == null)
      return false;

    boolean this_present_jsonDocument = true && this.isSetJsonDocument();
    boolean that_present_jsonDocument = true && that.isSetJsonDocument();
    if (this_present_jsonDocument || that_present_jsonDocument) {
      if (!(this_present_jsonDocument && that_present_jsonDocument))
        return false;
      if (!this.jsonDocument.equals(that.jsonDocument))
        return false;
    }

    boolean this_present_visibility = true && this.isSetVisibility();
    boolean that_present_visibility = true && that.isSetVisibility();
    if (this_present_visibility || that_present_visibility) {
      if (!(this_present_visibility && that_present_visibility))
        return false;
      if (!this.visibility.equals(that.visibility))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_jsonDocument = true && (isSetJsonDocument());
    builder.append(present_jsonDocument);
    if (present_jsonDocument)
      builder.append(jsonDocument);

    boolean present_visibility = true && (isSetVisibility());
    builder.append(present_visibility);
    if (present_visibility)
      builder.append(visibility);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(MongoEzbakeDocument other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetJsonDocument()).compareTo(other.isSetJsonDocument());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJsonDocument()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jsonDocument, other.jsonDocument);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVisibility()).compareTo(other.isSetVisibility());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVisibility()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.visibility, other.visibility);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MongoEzbakeDocument(");
    boolean first = true;

    sb.append("jsonDocument:");
    if (this.jsonDocument == null) {
      sb.append("null");
    } else {
      sb.append(this.jsonDocument);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("visibility:");
    if (this.visibility == null) {
      sb.append("null");
    } else {
      sb.append(this.visibility);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (jsonDocument == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'jsonDocument' was not present! Struct: " + toString());
    }
    if (visibility == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'visibility' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (visibility != null) {
      visibility.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MongoEzbakeDocumentStandardSchemeFactory implements SchemeFactory {
    public MongoEzbakeDocumentStandardScheme getScheme() {
      return new MongoEzbakeDocumentStandardScheme();
    }
  }

  private static class MongoEzbakeDocumentStandardScheme extends StandardScheme<MongoEzbakeDocument> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MongoEzbakeDocument struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // JSON_DOCUMENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jsonDocument = iprot.readString();
              struct.setJsonDocumentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VISIBILITY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.visibility = new ezbake.base.thrift.Visibility();
              struct.visibility.read(iprot);
              struct.setVisibilityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, MongoEzbakeDocument struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.jsonDocument != null) {
        oprot.writeFieldBegin(JSON_DOCUMENT_FIELD_DESC);
        oprot.writeString(struct.jsonDocument);
        oprot.writeFieldEnd();
      }
      if (struct.visibility != null) {
        oprot.writeFieldBegin(VISIBILITY_FIELD_DESC);
        struct.visibility.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MongoEzbakeDocumentTupleSchemeFactory implements SchemeFactory {
    public MongoEzbakeDocumentTupleScheme getScheme() {
      return new MongoEzbakeDocumentTupleScheme();
    }
  }

  private static class MongoEzbakeDocumentTupleScheme extends TupleScheme<MongoEzbakeDocument> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MongoEzbakeDocument struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.jsonDocument);
      struct.visibility.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MongoEzbakeDocument struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.jsonDocument = iprot.readString();
      struct.setJsonDocumentIsSet(true);
      struct.visibility = new ezbake.base.thrift.Visibility();
      struct.visibility.read(iprot);
      struct.setVisibilityIsSet(true);
    }
  }

}

