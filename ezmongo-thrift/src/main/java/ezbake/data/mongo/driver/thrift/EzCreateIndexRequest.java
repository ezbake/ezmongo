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
package ezbake.data.mongo.driver.thrift;

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

public class EzCreateIndexRequest implements org.apache.thrift.TBase<EzCreateIndexRequest, EzCreateIndexRequest._Fields>, java.io.Serializable, Cloneable, Comparable<EzCreateIndexRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EzCreateIndexRequest");

  private static final org.apache.thrift.protocol.TField DB_OBJECT_KEYS_FIELD_DESC = new org.apache.thrift.protocol.TField("dbObjectKeys", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DB_OBJECT_OPTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("dbObjectOptions", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DB_ENCODER_FIELD_DESC = new org.apache.thrift.protocol.TField("dbEncoder", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new EzCreateIndexRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new EzCreateIndexRequestTupleSchemeFactory());
  }

  public ByteBuffer dbObjectKeys; // required
  public ByteBuffer dbObjectOptions; // required
  public ByteBuffer dbEncoder; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DB_OBJECT_KEYS((short)1, "dbObjectKeys"),
    DB_OBJECT_OPTIONS((short)2, "dbObjectOptions"),
    DB_ENCODER((short)3, "dbEncoder");

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
        case 1: // DB_OBJECT_KEYS
          return DB_OBJECT_KEYS;
        case 2: // DB_OBJECT_OPTIONS
          return DB_OBJECT_OPTIONS;
        case 3: // DB_ENCODER
          return DB_ENCODER;
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
    tmpMap.put(_Fields.DB_OBJECT_KEYS, new org.apache.thrift.meta_data.FieldMetaData("dbObjectKeys", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.DB_OBJECT_OPTIONS, new org.apache.thrift.meta_data.FieldMetaData("dbObjectOptions", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.DB_ENCODER, new org.apache.thrift.meta_data.FieldMetaData("dbEncoder", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EzCreateIndexRequest.class, metaDataMap);
  }

  public EzCreateIndexRequest() {
  }

  public EzCreateIndexRequest(
    ByteBuffer dbObjectKeys,
    ByteBuffer dbObjectOptions,
    ByteBuffer dbEncoder)
  {
    this();
    this.dbObjectKeys = dbObjectKeys;
    this.dbObjectOptions = dbObjectOptions;
    this.dbEncoder = dbEncoder;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EzCreateIndexRequest(EzCreateIndexRequest other) {
    if (other.isSetDbObjectKeys()) {
      this.dbObjectKeys = org.apache.thrift.TBaseHelper.copyBinary(other.dbObjectKeys);
;
    }
    if (other.isSetDbObjectOptions()) {
      this.dbObjectOptions = org.apache.thrift.TBaseHelper.copyBinary(other.dbObjectOptions);
;
    }
    if (other.isSetDbEncoder()) {
      this.dbEncoder = org.apache.thrift.TBaseHelper.copyBinary(other.dbEncoder);
;
    }
  }

  public EzCreateIndexRequest deepCopy() {
    return new EzCreateIndexRequest(this);
  }

  @Override
  public void clear() {
    this.dbObjectKeys = null;
    this.dbObjectOptions = null;
    this.dbEncoder = null;
  }

  public byte[] getDbObjectKeys() {
    setDbObjectKeys(org.apache.thrift.TBaseHelper.rightSize(dbObjectKeys));
    return dbObjectKeys == null ? null : dbObjectKeys.array();
  }

  public ByteBuffer bufferForDbObjectKeys() {
    return dbObjectKeys;
  }

  public EzCreateIndexRequest setDbObjectKeys(byte[] dbObjectKeys) {
    setDbObjectKeys(dbObjectKeys == null ? (ByteBuffer)null : ByteBuffer.wrap(dbObjectKeys));
    return this;
  }

  public EzCreateIndexRequest setDbObjectKeys(ByteBuffer dbObjectKeys) {
    this.dbObjectKeys = dbObjectKeys;
    return this;
  }

  public void unsetDbObjectKeys() {
    this.dbObjectKeys = null;
  }

  /** Returns true if field dbObjectKeys is set (has been assigned a value) and false otherwise */
  public boolean isSetDbObjectKeys() {
    return this.dbObjectKeys != null;
  }

  public void setDbObjectKeysIsSet(boolean value) {
    if (!value) {
      this.dbObjectKeys = null;
    }
  }

  public byte[] getDbObjectOptions() {
    setDbObjectOptions(org.apache.thrift.TBaseHelper.rightSize(dbObjectOptions));
    return dbObjectOptions == null ? null : dbObjectOptions.array();
  }

  public ByteBuffer bufferForDbObjectOptions() {
    return dbObjectOptions;
  }

  public EzCreateIndexRequest setDbObjectOptions(byte[] dbObjectOptions) {
    setDbObjectOptions(dbObjectOptions == null ? (ByteBuffer)null : ByteBuffer.wrap(dbObjectOptions));
    return this;
  }

  public EzCreateIndexRequest setDbObjectOptions(ByteBuffer dbObjectOptions) {
    this.dbObjectOptions = dbObjectOptions;
    return this;
  }

  public void unsetDbObjectOptions() {
    this.dbObjectOptions = null;
  }

  /** Returns true if field dbObjectOptions is set (has been assigned a value) and false otherwise */
  public boolean isSetDbObjectOptions() {
    return this.dbObjectOptions != null;
  }

  public void setDbObjectOptionsIsSet(boolean value) {
    if (!value) {
      this.dbObjectOptions = null;
    }
  }

  public byte[] getDbEncoder() {
    setDbEncoder(org.apache.thrift.TBaseHelper.rightSize(dbEncoder));
    return dbEncoder == null ? null : dbEncoder.array();
  }

  public ByteBuffer bufferForDbEncoder() {
    return dbEncoder;
  }

  public EzCreateIndexRequest setDbEncoder(byte[] dbEncoder) {
    setDbEncoder(dbEncoder == null ? (ByteBuffer)null : ByteBuffer.wrap(dbEncoder));
    return this;
  }

  public EzCreateIndexRequest setDbEncoder(ByteBuffer dbEncoder) {
    this.dbEncoder = dbEncoder;
    return this;
  }

  public void unsetDbEncoder() {
    this.dbEncoder = null;
  }

  /** Returns true if field dbEncoder is set (has been assigned a value) and false otherwise */
  public boolean isSetDbEncoder() {
    return this.dbEncoder != null;
  }

  public void setDbEncoderIsSet(boolean value) {
    if (!value) {
      this.dbEncoder = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DB_OBJECT_KEYS:
      if (value == null) {
        unsetDbObjectKeys();
      } else {
        setDbObjectKeys((ByteBuffer)value);
      }
      break;

    case DB_OBJECT_OPTIONS:
      if (value == null) {
        unsetDbObjectOptions();
      } else {
        setDbObjectOptions((ByteBuffer)value);
      }
      break;

    case DB_ENCODER:
      if (value == null) {
        unsetDbEncoder();
      } else {
        setDbEncoder((ByteBuffer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DB_OBJECT_KEYS:
      return getDbObjectKeys();

    case DB_OBJECT_OPTIONS:
      return getDbObjectOptions();

    case DB_ENCODER:
      return getDbEncoder();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DB_OBJECT_KEYS:
      return isSetDbObjectKeys();
    case DB_OBJECT_OPTIONS:
      return isSetDbObjectOptions();
    case DB_ENCODER:
      return isSetDbEncoder();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EzCreateIndexRequest)
      return this.equals((EzCreateIndexRequest)that);
    return false;
  }

  public boolean equals(EzCreateIndexRequest that) {
    if (that == null)
      return false;

    boolean this_present_dbObjectKeys = true && this.isSetDbObjectKeys();
    boolean that_present_dbObjectKeys = true && that.isSetDbObjectKeys();
    if (this_present_dbObjectKeys || that_present_dbObjectKeys) {
      if (!(this_present_dbObjectKeys && that_present_dbObjectKeys))
        return false;
      if (!this.dbObjectKeys.equals(that.dbObjectKeys))
        return false;
    }

    boolean this_present_dbObjectOptions = true && this.isSetDbObjectOptions();
    boolean that_present_dbObjectOptions = true && that.isSetDbObjectOptions();
    if (this_present_dbObjectOptions || that_present_dbObjectOptions) {
      if (!(this_present_dbObjectOptions && that_present_dbObjectOptions))
        return false;
      if (!this.dbObjectOptions.equals(that.dbObjectOptions))
        return false;
    }

    boolean this_present_dbEncoder = true && this.isSetDbEncoder();
    boolean that_present_dbEncoder = true && that.isSetDbEncoder();
    if (this_present_dbEncoder || that_present_dbEncoder) {
      if (!(this_present_dbEncoder && that_present_dbEncoder))
        return false;
      if (!this.dbEncoder.equals(that.dbEncoder))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_dbObjectKeys = true && (isSetDbObjectKeys());
    builder.append(present_dbObjectKeys);
    if (present_dbObjectKeys)
      builder.append(dbObjectKeys);

    boolean present_dbObjectOptions = true && (isSetDbObjectOptions());
    builder.append(present_dbObjectOptions);
    if (present_dbObjectOptions)
      builder.append(dbObjectOptions);

    boolean present_dbEncoder = true && (isSetDbEncoder());
    builder.append(present_dbEncoder);
    if (present_dbEncoder)
      builder.append(dbEncoder);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(EzCreateIndexRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDbObjectKeys()).compareTo(other.isSetDbObjectKeys());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbObjectKeys()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbObjectKeys, other.dbObjectKeys);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDbObjectOptions()).compareTo(other.isSetDbObjectOptions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbObjectOptions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbObjectOptions, other.dbObjectOptions);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDbEncoder()).compareTo(other.isSetDbEncoder());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbEncoder()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbEncoder, other.dbEncoder);
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
    StringBuilder sb = new StringBuilder("EzCreateIndexRequest(");
    boolean first = true;

    sb.append("dbObjectKeys:");
    if (this.dbObjectKeys == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.dbObjectKeys, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("dbObjectOptions:");
    if (this.dbObjectOptions == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.dbObjectOptions, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("dbEncoder:");
    if (this.dbEncoder == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.dbEncoder, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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

  private static class EzCreateIndexRequestStandardSchemeFactory implements SchemeFactory {
    public EzCreateIndexRequestStandardScheme getScheme() {
      return new EzCreateIndexRequestStandardScheme();
    }
  }

  private static class EzCreateIndexRequestStandardScheme extends StandardScheme<EzCreateIndexRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, EzCreateIndexRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DB_OBJECT_KEYS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbObjectKeys = iprot.readBinary();
              struct.setDbObjectKeysIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DB_OBJECT_OPTIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbObjectOptions = iprot.readBinary();
              struct.setDbObjectOptionsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DB_ENCODER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbEncoder = iprot.readBinary();
              struct.setDbEncoderIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, EzCreateIndexRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.dbObjectKeys != null) {
        oprot.writeFieldBegin(DB_OBJECT_KEYS_FIELD_DESC);
        oprot.writeBinary(struct.dbObjectKeys);
        oprot.writeFieldEnd();
      }
      if (struct.dbObjectOptions != null) {
        oprot.writeFieldBegin(DB_OBJECT_OPTIONS_FIELD_DESC);
        oprot.writeBinary(struct.dbObjectOptions);
        oprot.writeFieldEnd();
      }
      if (struct.dbEncoder != null) {
        oprot.writeFieldBegin(DB_ENCODER_FIELD_DESC);
        oprot.writeBinary(struct.dbEncoder);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class EzCreateIndexRequestTupleSchemeFactory implements SchemeFactory {
    public EzCreateIndexRequestTupleScheme getScheme() {
      return new EzCreateIndexRequestTupleScheme();
    }
  }

  private static class EzCreateIndexRequestTupleScheme extends TupleScheme<EzCreateIndexRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, EzCreateIndexRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetDbObjectKeys()) {
        optionals.set(0);
      }
      if (struct.isSetDbObjectOptions()) {
        optionals.set(1);
      }
      if (struct.isSetDbEncoder()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetDbObjectKeys()) {
        oprot.writeBinary(struct.dbObjectKeys);
      }
      if (struct.isSetDbObjectOptions()) {
        oprot.writeBinary(struct.dbObjectOptions);
      }
      if (struct.isSetDbEncoder()) {
        oprot.writeBinary(struct.dbEncoder);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, EzCreateIndexRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.dbObjectKeys = iprot.readBinary();
        struct.setDbObjectKeysIsSet(true);
      }
      if (incoming.get(1)) {
        struct.dbObjectOptions = iprot.readBinary();
        struct.setDbObjectOptionsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.dbEncoder = iprot.readBinary();
        struct.setDbEncoderIsSet(true);
      }
    }
  }

}
