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

public class EzRemoveRequest implements org.apache.thrift.TBase<EzRemoveRequest, EzRemoveRequest._Fields>, java.io.Serializable, Cloneable, Comparable<EzRemoveRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EzRemoveRequest");

  private static final org.apache.thrift.protocol.TField DB_OBJECT_QUERY_FIELD_DESC = new org.apache.thrift.protocol.TField("dbObjectQuery", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField WRITE_CONCERN_FIELD_DESC = new org.apache.thrift.protocol.TField("writeConcern", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DB_ENCODER_FIELD_DESC = new org.apache.thrift.protocol.TField("dbEncoder", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new EzRemoveRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new EzRemoveRequestTupleSchemeFactory());
  }

  public ByteBuffer dbObjectQuery; // required
  public ByteBuffer writeConcern; // required
  public ByteBuffer dbEncoder; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DB_OBJECT_QUERY((short)1, "dbObjectQuery"),
    WRITE_CONCERN((short)2, "writeConcern"),
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
        case 1: // DB_OBJECT_QUERY
          return DB_OBJECT_QUERY;
        case 2: // WRITE_CONCERN
          return WRITE_CONCERN;
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
    tmpMap.put(_Fields.DB_OBJECT_QUERY, new org.apache.thrift.meta_data.FieldMetaData("dbObjectQuery", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.WRITE_CONCERN, new org.apache.thrift.meta_data.FieldMetaData("writeConcern", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.DB_ENCODER, new org.apache.thrift.meta_data.FieldMetaData("dbEncoder", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EzRemoveRequest.class, metaDataMap);
  }

  public EzRemoveRequest() {
  }

  public EzRemoveRequest(
    ByteBuffer dbObjectQuery,
    ByteBuffer writeConcern,
    ByteBuffer dbEncoder)
  {
    this();
    this.dbObjectQuery = dbObjectQuery;
    this.writeConcern = writeConcern;
    this.dbEncoder = dbEncoder;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EzRemoveRequest(EzRemoveRequest other) {
    if (other.isSetDbObjectQuery()) {
      this.dbObjectQuery = org.apache.thrift.TBaseHelper.copyBinary(other.dbObjectQuery);
;
    }
    if (other.isSetWriteConcern()) {
      this.writeConcern = org.apache.thrift.TBaseHelper.copyBinary(other.writeConcern);
;
    }
    if (other.isSetDbEncoder()) {
      this.dbEncoder = org.apache.thrift.TBaseHelper.copyBinary(other.dbEncoder);
;
    }
  }

  public EzRemoveRequest deepCopy() {
    return new EzRemoveRequest(this);
  }

  @Override
  public void clear() {
    this.dbObjectQuery = null;
    this.writeConcern = null;
    this.dbEncoder = null;
  }

  public byte[] getDbObjectQuery() {
    setDbObjectQuery(org.apache.thrift.TBaseHelper.rightSize(dbObjectQuery));
    return dbObjectQuery == null ? null : dbObjectQuery.array();
  }

  public ByteBuffer bufferForDbObjectQuery() {
    return dbObjectQuery;
  }

  public EzRemoveRequest setDbObjectQuery(byte[] dbObjectQuery) {
    setDbObjectQuery(dbObjectQuery == null ? (ByteBuffer)null : ByteBuffer.wrap(dbObjectQuery));
    return this;
  }

  public EzRemoveRequest setDbObjectQuery(ByteBuffer dbObjectQuery) {
    this.dbObjectQuery = dbObjectQuery;
    return this;
  }

  public void unsetDbObjectQuery() {
    this.dbObjectQuery = null;
  }

  /** Returns true if field dbObjectQuery is set (has been assigned a value) and false otherwise */
  public boolean isSetDbObjectQuery() {
    return this.dbObjectQuery != null;
  }

  public void setDbObjectQueryIsSet(boolean value) {
    if (!value) {
      this.dbObjectQuery = null;
    }
  }

  public byte[] getWriteConcern() {
    setWriteConcern(org.apache.thrift.TBaseHelper.rightSize(writeConcern));
    return writeConcern == null ? null : writeConcern.array();
  }

  public ByteBuffer bufferForWriteConcern() {
    return writeConcern;
  }

  public EzRemoveRequest setWriteConcern(byte[] writeConcern) {
    setWriteConcern(writeConcern == null ? (ByteBuffer)null : ByteBuffer.wrap(writeConcern));
    return this;
  }

  public EzRemoveRequest setWriteConcern(ByteBuffer writeConcern) {
    this.writeConcern = writeConcern;
    return this;
  }

  public void unsetWriteConcern() {
    this.writeConcern = null;
  }

  /** Returns true if field writeConcern is set (has been assigned a value) and false otherwise */
  public boolean isSetWriteConcern() {
    return this.writeConcern != null;
  }

  public void setWriteConcernIsSet(boolean value) {
    if (!value) {
      this.writeConcern = null;
    }
  }

  public byte[] getDbEncoder() {
    setDbEncoder(org.apache.thrift.TBaseHelper.rightSize(dbEncoder));
    return dbEncoder == null ? null : dbEncoder.array();
  }

  public ByteBuffer bufferForDbEncoder() {
    return dbEncoder;
  }

  public EzRemoveRequest setDbEncoder(byte[] dbEncoder) {
    setDbEncoder(dbEncoder == null ? (ByteBuffer)null : ByteBuffer.wrap(dbEncoder));
    return this;
  }

  public EzRemoveRequest setDbEncoder(ByteBuffer dbEncoder) {
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
    case DB_OBJECT_QUERY:
      if (value == null) {
        unsetDbObjectQuery();
      } else {
        setDbObjectQuery((ByteBuffer)value);
      }
      break;

    case WRITE_CONCERN:
      if (value == null) {
        unsetWriteConcern();
      } else {
        setWriteConcern((ByteBuffer)value);
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
    case DB_OBJECT_QUERY:
      return getDbObjectQuery();

    case WRITE_CONCERN:
      return getWriteConcern();

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
    case DB_OBJECT_QUERY:
      return isSetDbObjectQuery();
    case WRITE_CONCERN:
      return isSetWriteConcern();
    case DB_ENCODER:
      return isSetDbEncoder();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EzRemoveRequest)
      return this.equals((EzRemoveRequest)that);
    return false;
  }

  public boolean equals(EzRemoveRequest that) {
    if (that == null)
      return false;

    boolean this_present_dbObjectQuery = true && this.isSetDbObjectQuery();
    boolean that_present_dbObjectQuery = true && that.isSetDbObjectQuery();
    if (this_present_dbObjectQuery || that_present_dbObjectQuery) {
      if (!(this_present_dbObjectQuery && that_present_dbObjectQuery))
        return false;
      if (!this.dbObjectQuery.equals(that.dbObjectQuery))
        return false;
    }

    boolean this_present_writeConcern = true && this.isSetWriteConcern();
    boolean that_present_writeConcern = true && that.isSetWriteConcern();
    if (this_present_writeConcern || that_present_writeConcern) {
      if (!(this_present_writeConcern && that_present_writeConcern))
        return false;
      if (!this.writeConcern.equals(that.writeConcern))
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

    boolean present_dbObjectQuery = true && (isSetDbObjectQuery());
    builder.append(present_dbObjectQuery);
    if (present_dbObjectQuery)
      builder.append(dbObjectQuery);

    boolean present_writeConcern = true && (isSetWriteConcern());
    builder.append(present_writeConcern);
    if (present_writeConcern)
      builder.append(writeConcern);

    boolean present_dbEncoder = true && (isSetDbEncoder());
    builder.append(present_dbEncoder);
    if (present_dbEncoder)
      builder.append(dbEncoder);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(EzRemoveRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDbObjectQuery()).compareTo(other.isSetDbObjectQuery());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbObjectQuery()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbObjectQuery, other.dbObjectQuery);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWriteConcern()).compareTo(other.isSetWriteConcern());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWriteConcern()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.writeConcern, other.writeConcern);
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
    StringBuilder sb = new StringBuilder("EzRemoveRequest(");
    boolean first = true;

    sb.append("dbObjectQuery:");
    if (this.dbObjectQuery == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.dbObjectQuery, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("writeConcern:");
    if (this.writeConcern == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.writeConcern, sb);
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

  private static class EzRemoveRequestStandardSchemeFactory implements SchemeFactory {
    public EzRemoveRequestStandardScheme getScheme() {
      return new EzRemoveRequestStandardScheme();
    }
  }

  private static class EzRemoveRequestStandardScheme extends StandardScheme<EzRemoveRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, EzRemoveRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DB_OBJECT_QUERY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbObjectQuery = iprot.readBinary();
              struct.setDbObjectQueryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // WRITE_CONCERN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.writeConcern = iprot.readBinary();
              struct.setWriteConcernIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, EzRemoveRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.dbObjectQuery != null) {
        oprot.writeFieldBegin(DB_OBJECT_QUERY_FIELD_DESC);
        oprot.writeBinary(struct.dbObjectQuery);
        oprot.writeFieldEnd();
      }
      if (struct.writeConcern != null) {
        oprot.writeFieldBegin(WRITE_CONCERN_FIELD_DESC);
        oprot.writeBinary(struct.writeConcern);
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

  private static class EzRemoveRequestTupleSchemeFactory implements SchemeFactory {
    public EzRemoveRequestTupleScheme getScheme() {
      return new EzRemoveRequestTupleScheme();
    }
  }

  private static class EzRemoveRequestTupleScheme extends TupleScheme<EzRemoveRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, EzRemoveRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetDbObjectQuery()) {
        optionals.set(0);
      }
      if (struct.isSetWriteConcern()) {
        optionals.set(1);
      }
      if (struct.isSetDbEncoder()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetDbObjectQuery()) {
        oprot.writeBinary(struct.dbObjectQuery);
      }
      if (struct.isSetWriteConcern()) {
        oprot.writeBinary(struct.writeConcern);
      }
      if (struct.isSetDbEncoder()) {
        oprot.writeBinary(struct.dbEncoder);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, EzRemoveRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.dbObjectQuery = iprot.readBinary();
        struct.setDbObjectQueryIsSet(true);
      }
      if (incoming.get(1)) {
        struct.writeConcern = iprot.readBinary();
        struct.setWriteConcernIsSet(true);
      }
      if (incoming.get(2)) {
        struct.dbEncoder = iprot.readBinary();
        struct.setDbEncoderIsSet(true);
      }
    }
  }

}
