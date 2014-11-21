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

public class EzMongoDriverException extends TException implements org.apache.thrift.TBase<EzMongoDriverException, EzMongoDriverException._Fields>, java.io.Serializable, Cloneable, Comparable<EzMongoDriverException> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EzMongoDriverException");

  private static final org.apache.thrift.protocol.TField EX_FIELD_DESC = new org.apache.thrift.protocol.TField("ex", org.apache.thrift.protocol.TType.STRING, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new EzMongoDriverExceptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new EzMongoDriverExceptionTupleSchemeFactory());
  }

  public ByteBuffer ex; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EX((short)1, "ex");

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
        case 1: // EX
          return EX;
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
    tmpMap.put(_Fields.EX, new org.apache.thrift.meta_data.FieldMetaData("ex", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EzMongoDriverException.class, metaDataMap);
  }

  public EzMongoDriverException() {
  }

  public EzMongoDriverException(
    ByteBuffer ex)
  {
    this();
    this.ex = ex;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EzMongoDriverException(EzMongoDriverException other) {
    if (other.isSetEx()) {
      this.ex = org.apache.thrift.TBaseHelper.copyBinary(other.ex);
;
    }
  }

  public EzMongoDriverException deepCopy() {
    return new EzMongoDriverException(this);
  }

  @Override
  public void clear() {
    this.ex = null;
  }

  public byte[] getEx() {
    setEx(org.apache.thrift.TBaseHelper.rightSize(ex));
    return ex == null ? null : ex.array();
  }

  public ByteBuffer bufferForEx() {
    return ex;
  }

  public EzMongoDriverException setEx(byte[] ex) {
    setEx(ex == null ? (ByteBuffer)null : ByteBuffer.wrap(ex));
    return this;
  }

  public EzMongoDriverException setEx(ByteBuffer ex) {
    this.ex = ex;
    return this;
  }

  public void unsetEx() {
    this.ex = null;
  }

  /** Returns true if field ex is set (has been assigned a value) and false otherwise */
  public boolean isSetEx() {
    return this.ex != null;
  }

  public void setExIsSet(boolean value) {
    if (!value) {
      this.ex = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EX:
      if (value == null) {
        unsetEx();
      } else {
        setEx((ByteBuffer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EX:
      return getEx();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EX:
      return isSetEx();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EzMongoDriverException)
      return this.equals((EzMongoDriverException)that);
    return false;
  }

  public boolean equals(EzMongoDriverException that) {
    if (that == null)
      return false;

    boolean this_present_ex = true && this.isSetEx();
    boolean that_present_ex = true && that.isSetEx();
    if (this_present_ex || that_present_ex) {
      if (!(this_present_ex && that_present_ex))
        return false;
      if (!this.ex.equals(that.ex))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_ex = true && (isSetEx());
    builder.append(present_ex);
    if (present_ex)
      builder.append(ex);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(EzMongoDriverException other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetEx()).compareTo(other.isSetEx());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEx()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ex, other.ex);
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
    StringBuilder sb = new StringBuilder("EzMongoDriverException(");
    boolean first = true;

    sb.append("ex:");
    if (this.ex == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.ex, sb);
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

  private static class EzMongoDriverExceptionStandardSchemeFactory implements SchemeFactory {
    public EzMongoDriverExceptionStandardScheme getScheme() {
      return new EzMongoDriverExceptionStandardScheme();
    }
  }

  private static class EzMongoDriverExceptionStandardScheme extends StandardScheme<EzMongoDriverException> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, EzMongoDriverException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EX
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ex = iprot.readBinary();
              struct.setExIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, EzMongoDriverException struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ex != null) {
        oprot.writeFieldBegin(EX_FIELD_DESC);
        oprot.writeBinary(struct.ex);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class EzMongoDriverExceptionTupleSchemeFactory implements SchemeFactory {
    public EzMongoDriverExceptionTupleScheme getScheme() {
      return new EzMongoDriverExceptionTupleScheme();
    }
  }

  private static class EzMongoDriverExceptionTupleScheme extends TupleScheme<EzMongoDriverException> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, EzMongoDriverException struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetEx()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetEx()) {
        oprot.writeBinary(struct.ex);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, EzMongoDriverException struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.ex = iprot.readBinary();
        struct.setExIsSet(true);
      }
    }
  }

}
