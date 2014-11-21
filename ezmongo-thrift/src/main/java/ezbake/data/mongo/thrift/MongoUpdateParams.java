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

public class MongoUpdateParams implements org.apache.thrift.TBase<MongoUpdateParams, MongoUpdateParams._Fields>, java.io.Serializable, Cloneable, Comparable<MongoUpdateParams> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MongoUpdateParams");

  private static final org.apache.thrift.protocol.TField JSON_QUERY_FIELD_DESC = new org.apache.thrift.protocol.TField("jsonQuery", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField MONGO_DOCUMENT_FIELD_DESC = new org.apache.thrift.protocol.TField("mongoDocument", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField UPDATE_WITH_OPERATORS_FIELD_DESC = new org.apache.thrift.protocol.TField("updateWithOperators", org.apache.thrift.protocol.TType.BOOL, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MongoUpdateParamsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MongoUpdateParamsTupleSchemeFactory());
  }

  public String jsonQuery; // optional
  public MongoEzbakeDocument mongoDocument; // required
  public boolean updateWithOperators; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    JSON_QUERY((short)1, "jsonQuery"),
    MONGO_DOCUMENT((short)2, "mongoDocument"),
    UPDATE_WITH_OPERATORS((short)3, "updateWithOperators");

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
        case 1: // JSON_QUERY
          return JSON_QUERY;
        case 2: // MONGO_DOCUMENT
          return MONGO_DOCUMENT;
        case 3: // UPDATE_WITH_OPERATORS
          return UPDATE_WITH_OPERATORS;
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
  private static final int __UPDATEWITHOPERATORS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.JSON_QUERY,_Fields.UPDATE_WITH_OPERATORS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.JSON_QUERY, new org.apache.thrift.meta_data.FieldMetaData("jsonQuery", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MONGO_DOCUMENT, new org.apache.thrift.meta_data.FieldMetaData("mongoDocument", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MongoEzbakeDocument.class)));
    tmpMap.put(_Fields.UPDATE_WITH_OPERATORS, new org.apache.thrift.meta_data.FieldMetaData("updateWithOperators", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MongoUpdateParams.class, metaDataMap);
  }

  public MongoUpdateParams() {
  }

  public MongoUpdateParams(
    MongoEzbakeDocument mongoDocument)
  {
    this();
    this.mongoDocument = mongoDocument;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MongoUpdateParams(MongoUpdateParams other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetJsonQuery()) {
      this.jsonQuery = other.jsonQuery;
    }
    if (other.isSetMongoDocument()) {
      this.mongoDocument = new MongoEzbakeDocument(other.mongoDocument);
    }
    this.updateWithOperators = other.updateWithOperators;
  }

  public MongoUpdateParams deepCopy() {
    return new MongoUpdateParams(this);
  }

  @Override
  public void clear() {
    this.jsonQuery = null;
    this.mongoDocument = null;
    setUpdateWithOperatorsIsSet(false);
    this.updateWithOperators = false;
  }

  public String getJsonQuery() {
    return this.jsonQuery;
  }

  public MongoUpdateParams setJsonQuery(String jsonQuery) {
    this.jsonQuery = jsonQuery;
    return this;
  }

  public void unsetJsonQuery() {
    this.jsonQuery = null;
  }

  /** Returns true if field jsonQuery is set (has been assigned a value) and false otherwise */
  public boolean isSetJsonQuery() {
    return this.jsonQuery != null;
  }

  public void setJsonQueryIsSet(boolean value) {
    if (!value) {
      this.jsonQuery = null;
    }
  }

  public MongoEzbakeDocument getMongoDocument() {
    return this.mongoDocument;
  }

  public MongoUpdateParams setMongoDocument(MongoEzbakeDocument mongoDocument) {
    this.mongoDocument = mongoDocument;
    return this;
  }

  public void unsetMongoDocument() {
    this.mongoDocument = null;
  }

  /** Returns true if field mongoDocument is set (has been assigned a value) and false otherwise */
  public boolean isSetMongoDocument() {
    return this.mongoDocument != null;
  }

  public void setMongoDocumentIsSet(boolean value) {
    if (!value) {
      this.mongoDocument = null;
    }
  }

  public boolean isUpdateWithOperators() {
    return this.updateWithOperators;
  }

  public MongoUpdateParams setUpdateWithOperators(boolean updateWithOperators) {
    this.updateWithOperators = updateWithOperators;
    setUpdateWithOperatorsIsSet(true);
    return this;
  }

  public void unsetUpdateWithOperators() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __UPDATEWITHOPERATORS_ISSET_ID);
  }

  /** Returns true if field updateWithOperators is set (has been assigned a value) and false otherwise */
  public boolean isSetUpdateWithOperators() {
    return EncodingUtils.testBit(__isset_bitfield, __UPDATEWITHOPERATORS_ISSET_ID);
  }

  public void setUpdateWithOperatorsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __UPDATEWITHOPERATORS_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case JSON_QUERY:
      if (value == null) {
        unsetJsonQuery();
      } else {
        setJsonQuery((String)value);
      }
      break;

    case MONGO_DOCUMENT:
      if (value == null) {
        unsetMongoDocument();
      } else {
        setMongoDocument((MongoEzbakeDocument)value);
      }
      break;

    case UPDATE_WITH_OPERATORS:
      if (value == null) {
        unsetUpdateWithOperators();
      } else {
        setUpdateWithOperators((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case JSON_QUERY:
      return getJsonQuery();

    case MONGO_DOCUMENT:
      return getMongoDocument();

    case UPDATE_WITH_OPERATORS:
      return Boolean.valueOf(isUpdateWithOperators());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case JSON_QUERY:
      return isSetJsonQuery();
    case MONGO_DOCUMENT:
      return isSetMongoDocument();
    case UPDATE_WITH_OPERATORS:
      return isSetUpdateWithOperators();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MongoUpdateParams)
      return this.equals((MongoUpdateParams)that);
    return false;
  }

  public boolean equals(MongoUpdateParams that) {
    if (that == null)
      return false;

    boolean this_present_jsonQuery = true && this.isSetJsonQuery();
    boolean that_present_jsonQuery = true && that.isSetJsonQuery();
    if (this_present_jsonQuery || that_present_jsonQuery) {
      if (!(this_present_jsonQuery && that_present_jsonQuery))
        return false;
      if (!this.jsonQuery.equals(that.jsonQuery))
        return false;
    }

    boolean this_present_mongoDocument = true && this.isSetMongoDocument();
    boolean that_present_mongoDocument = true && that.isSetMongoDocument();
    if (this_present_mongoDocument || that_present_mongoDocument) {
      if (!(this_present_mongoDocument && that_present_mongoDocument))
        return false;
      if (!this.mongoDocument.equals(that.mongoDocument))
        return false;
    }

    boolean this_present_updateWithOperators = true && this.isSetUpdateWithOperators();
    boolean that_present_updateWithOperators = true && that.isSetUpdateWithOperators();
    if (this_present_updateWithOperators || that_present_updateWithOperators) {
      if (!(this_present_updateWithOperators && that_present_updateWithOperators))
        return false;
      if (this.updateWithOperators != that.updateWithOperators)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_jsonQuery = true && (isSetJsonQuery());
    builder.append(present_jsonQuery);
    if (present_jsonQuery)
      builder.append(jsonQuery);

    boolean present_mongoDocument = true && (isSetMongoDocument());
    builder.append(present_mongoDocument);
    if (present_mongoDocument)
      builder.append(mongoDocument);

    boolean present_updateWithOperators = true && (isSetUpdateWithOperators());
    builder.append(present_updateWithOperators);
    if (present_updateWithOperators)
      builder.append(updateWithOperators);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(MongoUpdateParams other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetJsonQuery()).compareTo(other.isSetJsonQuery());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJsonQuery()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jsonQuery, other.jsonQuery);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMongoDocument()).compareTo(other.isSetMongoDocument());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMongoDocument()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mongoDocument, other.mongoDocument);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUpdateWithOperators()).compareTo(other.isSetUpdateWithOperators());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUpdateWithOperators()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.updateWithOperators, other.updateWithOperators);
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
    StringBuilder sb = new StringBuilder("MongoUpdateParams(");
    boolean first = true;

    if (isSetJsonQuery()) {
      sb.append("jsonQuery:");
      if (this.jsonQuery == null) {
        sb.append("null");
      } else {
        sb.append(this.jsonQuery);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("mongoDocument:");
    if (this.mongoDocument == null) {
      sb.append("null");
    } else {
      sb.append(this.mongoDocument);
    }
    first = false;
    if (isSetUpdateWithOperators()) {
      if (!first) sb.append(", ");
      sb.append("updateWithOperators:");
      sb.append(this.updateWithOperators);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (mongoDocument == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'mongoDocument' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (mongoDocument != null) {
      mongoDocument.validate();
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MongoUpdateParamsStandardSchemeFactory implements SchemeFactory {
    public MongoUpdateParamsStandardScheme getScheme() {
      return new MongoUpdateParamsStandardScheme();
    }
  }

  private static class MongoUpdateParamsStandardScheme extends StandardScheme<MongoUpdateParams> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MongoUpdateParams struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // JSON_QUERY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.jsonQuery = iprot.readString();
              struct.setJsonQueryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MONGO_DOCUMENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.mongoDocument = new MongoEzbakeDocument();
              struct.mongoDocument.read(iprot);
              struct.setMongoDocumentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // UPDATE_WITH_OPERATORS
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.updateWithOperators = iprot.readBool();
              struct.setUpdateWithOperatorsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MongoUpdateParams struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.jsonQuery != null) {
        if (struct.isSetJsonQuery()) {
          oprot.writeFieldBegin(JSON_QUERY_FIELD_DESC);
          oprot.writeString(struct.jsonQuery);
          oprot.writeFieldEnd();
        }
      }
      if (struct.mongoDocument != null) {
        oprot.writeFieldBegin(MONGO_DOCUMENT_FIELD_DESC);
        struct.mongoDocument.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.isSetUpdateWithOperators()) {
        oprot.writeFieldBegin(UPDATE_WITH_OPERATORS_FIELD_DESC);
        oprot.writeBool(struct.updateWithOperators);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MongoUpdateParamsTupleSchemeFactory implements SchemeFactory {
    public MongoUpdateParamsTupleScheme getScheme() {
      return new MongoUpdateParamsTupleScheme();
    }
  }

  private static class MongoUpdateParamsTupleScheme extends TupleScheme<MongoUpdateParams> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MongoUpdateParams struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      struct.mongoDocument.write(oprot);
      BitSet optionals = new BitSet();
      if (struct.isSetJsonQuery()) {
        optionals.set(0);
      }
      if (struct.isSetUpdateWithOperators()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetJsonQuery()) {
        oprot.writeString(struct.jsonQuery);
      }
      if (struct.isSetUpdateWithOperators()) {
        oprot.writeBool(struct.updateWithOperators);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MongoUpdateParams struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.mongoDocument = new MongoEzbakeDocument();
      struct.mongoDocument.read(iprot);
      struct.setMongoDocumentIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.jsonQuery = iprot.readString();
        struct.setJsonQueryIsSet(true);
      }
      if (incoming.get(1)) {
        struct.updateWithOperators = iprot.readBool();
        struct.setUpdateWithOperatorsIsSet(true);
      }
    }
  }

}

