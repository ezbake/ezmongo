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

public class EzInsertRequest implements org.apache.thrift.TBase<EzInsertRequest, EzInsertRequest._Fields>, java.io.Serializable, Cloneable, Comparable<EzInsertRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EzInsertRequest");

  private static final org.apache.thrift.protocol.TField DB_OBJECT_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("dbObjectList", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField WRITE_CONCERN_FIELD_DESC = new org.apache.thrift.protocol.TField("writeConcern", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DB_ENCODER_FIELD_DESC = new org.apache.thrift.protocol.TField("dbEncoder", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField IS_UNIT_TEST_MODE_FIELD_DESC = new org.apache.thrift.protocol.TField("isUnitTestMode", org.apache.thrift.protocol.TType.BOOL, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new EzInsertRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new EzInsertRequestTupleSchemeFactory());
  }

  public ByteBuffer dbObjectList; // required
  public ByteBuffer writeConcern; // required
  public ByteBuffer dbEncoder; // required
  public boolean isUnitTestMode; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DB_OBJECT_LIST((short)1, "dbObjectList"),
    WRITE_CONCERN((short)2, "writeConcern"),
    DB_ENCODER((short)3, "dbEncoder"),
    IS_UNIT_TEST_MODE((short)4, "isUnitTestMode");

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
        case 1: // DB_OBJECT_LIST
          return DB_OBJECT_LIST;
        case 2: // WRITE_CONCERN
          return WRITE_CONCERN;
        case 3: // DB_ENCODER
          return DB_ENCODER;
        case 4: // IS_UNIT_TEST_MODE
          return IS_UNIT_TEST_MODE;
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
  private static final int __ISUNITTESTMODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DB_OBJECT_LIST, new org.apache.thrift.meta_data.FieldMetaData("dbObjectList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.WRITE_CONCERN, new org.apache.thrift.meta_data.FieldMetaData("writeConcern", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.DB_ENCODER, new org.apache.thrift.meta_data.FieldMetaData("dbEncoder", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.IS_UNIT_TEST_MODE, new org.apache.thrift.meta_data.FieldMetaData("isUnitTestMode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EzInsertRequest.class, metaDataMap);
  }

  public EzInsertRequest() {
  }

  public EzInsertRequest(
    ByteBuffer dbObjectList,
    ByteBuffer writeConcern,
    ByteBuffer dbEncoder,
    boolean isUnitTestMode)
  {
    this();
    this.dbObjectList = dbObjectList;
    this.writeConcern = writeConcern;
    this.dbEncoder = dbEncoder;
    this.isUnitTestMode = isUnitTestMode;
    setIsUnitTestModeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EzInsertRequest(EzInsertRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetDbObjectList()) {
      this.dbObjectList = org.apache.thrift.TBaseHelper.copyBinary(other.dbObjectList);
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
    this.isUnitTestMode = other.isUnitTestMode;
  }

  public EzInsertRequest deepCopy() {
    return new EzInsertRequest(this);
  }

  @Override
  public void clear() {
    this.dbObjectList = null;
    this.writeConcern = null;
    this.dbEncoder = null;
    setIsUnitTestModeIsSet(false);
    this.isUnitTestMode = false;
  }

  public byte[] getDbObjectList() {
    setDbObjectList(org.apache.thrift.TBaseHelper.rightSize(dbObjectList));
    return dbObjectList == null ? null : dbObjectList.array();
  }

  public ByteBuffer bufferForDbObjectList() {
    return dbObjectList;
  }

  public EzInsertRequest setDbObjectList(byte[] dbObjectList) {
    setDbObjectList(dbObjectList == null ? (ByteBuffer)null : ByteBuffer.wrap(dbObjectList));
    return this;
  }

  public EzInsertRequest setDbObjectList(ByteBuffer dbObjectList) {
    this.dbObjectList = dbObjectList;
    return this;
  }

  public void unsetDbObjectList() {
    this.dbObjectList = null;
  }

  /** Returns true if field dbObjectList is set (has been assigned a value) and false otherwise */
  public boolean isSetDbObjectList() {
    return this.dbObjectList != null;
  }

  public void setDbObjectListIsSet(boolean value) {
    if (!value) {
      this.dbObjectList = null;
    }
  }

  public byte[] getWriteConcern() {
    setWriteConcern(org.apache.thrift.TBaseHelper.rightSize(writeConcern));
    return writeConcern == null ? null : writeConcern.array();
  }

  public ByteBuffer bufferForWriteConcern() {
    return writeConcern;
  }

  public EzInsertRequest setWriteConcern(byte[] writeConcern) {
    setWriteConcern(writeConcern == null ? (ByteBuffer)null : ByteBuffer.wrap(writeConcern));
    return this;
  }

  public EzInsertRequest setWriteConcern(ByteBuffer writeConcern) {
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

  public EzInsertRequest setDbEncoder(byte[] dbEncoder) {
    setDbEncoder(dbEncoder == null ? (ByteBuffer)null : ByteBuffer.wrap(dbEncoder));
    return this;
  }

  public EzInsertRequest setDbEncoder(ByteBuffer dbEncoder) {
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

  public boolean isIsUnitTestMode() {
    return this.isUnitTestMode;
  }

  public EzInsertRequest setIsUnitTestMode(boolean isUnitTestMode) {
    this.isUnitTestMode = isUnitTestMode;
    setIsUnitTestModeIsSet(true);
    return this;
  }

  public void unsetIsUnitTestMode() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISUNITTESTMODE_ISSET_ID);
  }

  /** Returns true if field isUnitTestMode is set (has been assigned a value) and false otherwise */
  public boolean isSetIsUnitTestMode() {
    return EncodingUtils.testBit(__isset_bitfield, __ISUNITTESTMODE_ISSET_ID);
  }

  public void setIsUnitTestModeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISUNITTESTMODE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DB_OBJECT_LIST:
      if (value == null) {
        unsetDbObjectList();
      } else {
        setDbObjectList((ByteBuffer)value);
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

    case IS_UNIT_TEST_MODE:
      if (value == null) {
        unsetIsUnitTestMode();
      } else {
        setIsUnitTestMode((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DB_OBJECT_LIST:
      return getDbObjectList();

    case WRITE_CONCERN:
      return getWriteConcern();

    case DB_ENCODER:
      return getDbEncoder();

    case IS_UNIT_TEST_MODE:
      return Boolean.valueOf(isIsUnitTestMode());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DB_OBJECT_LIST:
      return isSetDbObjectList();
    case WRITE_CONCERN:
      return isSetWriteConcern();
    case DB_ENCODER:
      return isSetDbEncoder();
    case IS_UNIT_TEST_MODE:
      return isSetIsUnitTestMode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EzInsertRequest)
      return this.equals((EzInsertRequest)that);
    return false;
  }

  public boolean equals(EzInsertRequest that) {
    if (that == null)
      return false;

    boolean this_present_dbObjectList = true && this.isSetDbObjectList();
    boolean that_present_dbObjectList = true && that.isSetDbObjectList();
    if (this_present_dbObjectList || that_present_dbObjectList) {
      if (!(this_present_dbObjectList && that_present_dbObjectList))
        return false;
      if (!this.dbObjectList.equals(that.dbObjectList))
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

    boolean this_present_isUnitTestMode = true;
    boolean that_present_isUnitTestMode = true;
    if (this_present_isUnitTestMode || that_present_isUnitTestMode) {
      if (!(this_present_isUnitTestMode && that_present_isUnitTestMode))
        return false;
      if (this.isUnitTestMode != that.isUnitTestMode)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_dbObjectList = true && (isSetDbObjectList());
    builder.append(present_dbObjectList);
    if (present_dbObjectList)
      builder.append(dbObjectList);

    boolean present_writeConcern = true && (isSetWriteConcern());
    builder.append(present_writeConcern);
    if (present_writeConcern)
      builder.append(writeConcern);

    boolean present_dbEncoder = true && (isSetDbEncoder());
    builder.append(present_dbEncoder);
    if (present_dbEncoder)
      builder.append(dbEncoder);

    boolean present_isUnitTestMode = true;
    builder.append(present_isUnitTestMode);
    if (present_isUnitTestMode)
      builder.append(isUnitTestMode);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(EzInsertRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDbObjectList()).compareTo(other.isSetDbObjectList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbObjectList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbObjectList, other.dbObjectList);
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
    lastComparison = Boolean.valueOf(isSetIsUnitTestMode()).compareTo(other.isSetIsUnitTestMode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsUnitTestMode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isUnitTestMode, other.isUnitTestMode);
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
    StringBuilder sb = new StringBuilder("EzInsertRequest(");
    boolean first = true;

    sb.append("dbObjectList:");
    if (this.dbObjectList == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.dbObjectList, sb);
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
    if (!first) sb.append(", ");
    sb.append("isUnitTestMode:");
    sb.append(this.isUnitTestMode);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class EzInsertRequestStandardSchemeFactory implements SchemeFactory {
    public EzInsertRequestStandardScheme getScheme() {
      return new EzInsertRequestStandardScheme();
    }
  }

  private static class EzInsertRequestStandardScheme extends StandardScheme<EzInsertRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, EzInsertRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DB_OBJECT_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbObjectList = iprot.readBinary();
              struct.setDbObjectListIsSet(true);
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
          case 4: // IS_UNIT_TEST_MODE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isUnitTestMode = iprot.readBool();
              struct.setIsUnitTestModeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, EzInsertRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.dbObjectList != null) {
        oprot.writeFieldBegin(DB_OBJECT_LIST_FIELD_DESC);
        oprot.writeBinary(struct.dbObjectList);
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
      oprot.writeFieldBegin(IS_UNIT_TEST_MODE_FIELD_DESC);
      oprot.writeBool(struct.isUnitTestMode);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class EzInsertRequestTupleSchemeFactory implements SchemeFactory {
    public EzInsertRequestTupleScheme getScheme() {
      return new EzInsertRequestTupleScheme();
    }
  }

  private static class EzInsertRequestTupleScheme extends TupleScheme<EzInsertRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, EzInsertRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetDbObjectList()) {
        optionals.set(0);
      }
      if (struct.isSetWriteConcern()) {
        optionals.set(1);
      }
      if (struct.isSetDbEncoder()) {
        optionals.set(2);
      }
      if (struct.isSetIsUnitTestMode()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetDbObjectList()) {
        oprot.writeBinary(struct.dbObjectList);
      }
      if (struct.isSetWriteConcern()) {
        oprot.writeBinary(struct.writeConcern);
      }
      if (struct.isSetDbEncoder()) {
        oprot.writeBinary(struct.dbEncoder);
      }
      if (struct.isSetIsUnitTestMode()) {
        oprot.writeBool(struct.isUnitTestMode);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, EzInsertRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.dbObjectList = iprot.readBinary();
        struct.setDbObjectListIsSet(true);
      }
      if (incoming.get(1)) {
        struct.writeConcern = iprot.readBinary();
        struct.setWriteConcernIsSet(true);
      }
      if (incoming.get(2)) {
        struct.dbEncoder = iprot.readBinary();
        struct.setDbEncoderIsSet(true);
      }
      if (incoming.get(3)) {
        struct.isUnitTestMode = iprot.readBool();
        struct.setIsUnitTestModeIsSet(true);
      }
    }
  }

}

