/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;

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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-11-17")
public class FetchBuildSlaveFinishedStatsRequest implements org.apache.thrift.TBase<FetchBuildSlaveFinishedStatsRequest, FetchBuildSlaveFinishedStatsRequest._Fields>, java.io.Serializable, Cloneable, Comparable<FetchBuildSlaveFinishedStatsRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FetchBuildSlaveFinishedStatsRequest");

  private static final org.apache.thrift.protocol.TField STAMPEDE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("stampedeId", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField BUILD_SLAVE_RUN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("buildSlaveRunId", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FetchBuildSlaveFinishedStatsRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FetchBuildSlaveFinishedStatsRequestTupleSchemeFactory());
  }

  public StampedeId stampedeId; // optional
  public BuildSlaveRunId buildSlaveRunId; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STAMPEDE_ID((short)1, "stampedeId"),
    BUILD_SLAVE_RUN_ID((short)2, "buildSlaveRunId");

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
        case 1: // STAMPEDE_ID
          return STAMPEDE_ID;
        case 2: // BUILD_SLAVE_RUN_ID
          return BUILD_SLAVE_RUN_ID;
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
  private static final _Fields optionals[] = {_Fields.STAMPEDE_ID,_Fields.BUILD_SLAVE_RUN_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STAMPEDE_ID, new org.apache.thrift.meta_data.FieldMetaData("stampedeId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, StampedeId.class)));
    tmpMap.put(_Fields.BUILD_SLAVE_RUN_ID, new org.apache.thrift.meta_data.FieldMetaData("buildSlaveRunId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BuildSlaveRunId.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FetchBuildSlaveFinishedStatsRequest.class, metaDataMap);
  }

  public FetchBuildSlaveFinishedStatsRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FetchBuildSlaveFinishedStatsRequest(FetchBuildSlaveFinishedStatsRequest other) {
    if (other.isSetStampedeId()) {
      this.stampedeId = new StampedeId(other.stampedeId);
    }
    if (other.isSetBuildSlaveRunId()) {
      this.buildSlaveRunId = new BuildSlaveRunId(other.buildSlaveRunId);
    }
  }

  public FetchBuildSlaveFinishedStatsRequest deepCopy() {
    return new FetchBuildSlaveFinishedStatsRequest(this);
  }

  @Override
  public void clear() {
    this.stampedeId = null;
    this.buildSlaveRunId = null;
  }

  public StampedeId getStampedeId() {
    return this.stampedeId;
  }

  public FetchBuildSlaveFinishedStatsRequest setStampedeId(StampedeId stampedeId) {
    this.stampedeId = stampedeId;
    return this;
  }

  public void unsetStampedeId() {
    this.stampedeId = null;
  }

  /** Returns true if field stampedeId is set (has been assigned a value) and false otherwise */
  public boolean isSetStampedeId() {
    return this.stampedeId != null;
  }

  public void setStampedeIdIsSet(boolean value) {
    if (!value) {
      this.stampedeId = null;
    }
  }

  public BuildSlaveRunId getBuildSlaveRunId() {
    return this.buildSlaveRunId;
  }

  public FetchBuildSlaveFinishedStatsRequest setBuildSlaveRunId(BuildSlaveRunId buildSlaveRunId) {
    this.buildSlaveRunId = buildSlaveRunId;
    return this;
  }

  public void unsetBuildSlaveRunId() {
    this.buildSlaveRunId = null;
  }

  /** Returns true if field buildSlaveRunId is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildSlaveRunId() {
    return this.buildSlaveRunId != null;
  }

  public void setBuildSlaveRunIdIsSet(boolean value) {
    if (!value) {
      this.buildSlaveRunId = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STAMPEDE_ID:
      if (value == null) {
        unsetStampedeId();
      } else {
        setStampedeId((StampedeId)value);
      }
      break;

    case BUILD_SLAVE_RUN_ID:
      if (value == null) {
        unsetBuildSlaveRunId();
      } else {
        setBuildSlaveRunId((BuildSlaveRunId)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STAMPEDE_ID:
      return getStampedeId();

    case BUILD_SLAVE_RUN_ID:
      return getBuildSlaveRunId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STAMPEDE_ID:
      return isSetStampedeId();
    case BUILD_SLAVE_RUN_ID:
      return isSetBuildSlaveRunId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FetchBuildSlaveFinishedStatsRequest)
      return this.equals((FetchBuildSlaveFinishedStatsRequest)that);
    return false;
  }

  public boolean equals(FetchBuildSlaveFinishedStatsRequest that) {
    if (that == null)
      return false;

    boolean this_present_stampedeId = true && this.isSetStampedeId();
    boolean that_present_stampedeId = true && that.isSetStampedeId();
    if (this_present_stampedeId || that_present_stampedeId) {
      if (!(this_present_stampedeId && that_present_stampedeId))
        return false;
      if (!this.stampedeId.equals(that.stampedeId))
        return false;
    }

    boolean this_present_buildSlaveRunId = true && this.isSetBuildSlaveRunId();
    boolean that_present_buildSlaveRunId = true && that.isSetBuildSlaveRunId();
    if (this_present_buildSlaveRunId || that_present_buildSlaveRunId) {
      if (!(this_present_buildSlaveRunId && that_present_buildSlaveRunId))
        return false;
      if (!this.buildSlaveRunId.equals(that.buildSlaveRunId))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_stampedeId = true && (isSetStampedeId());
    list.add(present_stampedeId);
    if (present_stampedeId)
      list.add(stampedeId);

    boolean present_buildSlaveRunId = true && (isSetBuildSlaveRunId());
    list.add(present_buildSlaveRunId);
    if (present_buildSlaveRunId)
      list.add(buildSlaveRunId);

    return list.hashCode();
  }

  @Override
  public int compareTo(FetchBuildSlaveFinishedStatsRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStampedeId()).compareTo(other.isSetStampedeId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStampedeId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stampedeId, other.stampedeId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBuildSlaveRunId()).compareTo(other.isSetBuildSlaveRunId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildSlaveRunId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildSlaveRunId, other.buildSlaveRunId);
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
    StringBuilder sb = new StringBuilder("FetchBuildSlaveFinishedStatsRequest(");
    boolean first = true;

    if (isSetStampedeId()) {
      sb.append("stampedeId:");
      if (this.stampedeId == null) {
        sb.append("null");
      } else {
        sb.append(this.stampedeId);
      }
      first = false;
    }
    if (isSetBuildSlaveRunId()) {
      if (!first) sb.append(", ");
      sb.append("buildSlaveRunId:");
      if (this.buildSlaveRunId == null) {
        sb.append("null");
      } else {
        sb.append(this.buildSlaveRunId);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (stampedeId != null) {
      stampedeId.validate();
    }
    if (buildSlaveRunId != null) {
      buildSlaveRunId.validate();
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

  private static class FetchBuildSlaveFinishedStatsRequestStandardSchemeFactory implements SchemeFactory {
    public FetchBuildSlaveFinishedStatsRequestStandardScheme getScheme() {
      return new FetchBuildSlaveFinishedStatsRequestStandardScheme();
    }
  }

  private static class FetchBuildSlaveFinishedStatsRequestStandardScheme extends StandardScheme<FetchBuildSlaveFinishedStatsRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FetchBuildSlaveFinishedStatsRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STAMPEDE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.stampedeId = new StampedeId();
              struct.stampedeId.read(iprot);
              struct.setStampedeIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BUILD_SLAVE_RUN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.buildSlaveRunId = new BuildSlaveRunId();
              struct.buildSlaveRunId.read(iprot);
              struct.setBuildSlaveRunIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, FetchBuildSlaveFinishedStatsRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.stampedeId != null) {
        if (struct.isSetStampedeId()) {
          oprot.writeFieldBegin(STAMPEDE_ID_FIELD_DESC);
          struct.stampedeId.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.buildSlaveRunId != null) {
        if (struct.isSetBuildSlaveRunId()) {
          oprot.writeFieldBegin(BUILD_SLAVE_RUN_ID_FIELD_DESC);
          struct.buildSlaveRunId.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FetchBuildSlaveFinishedStatsRequestTupleSchemeFactory implements SchemeFactory {
    public FetchBuildSlaveFinishedStatsRequestTupleScheme getScheme() {
      return new FetchBuildSlaveFinishedStatsRequestTupleScheme();
    }
  }

  private static class FetchBuildSlaveFinishedStatsRequestTupleScheme extends TupleScheme<FetchBuildSlaveFinishedStatsRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FetchBuildSlaveFinishedStatsRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetStampedeId()) {
        optionals.set(0);
      }
      if (struct.isSetBuildSlaveRunId()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetStampedeId()) {
        struct.stampedeId.write(oprot);
      }
      if (struct.isSetBuildSlaveRunId()) {
        struct.buildSlaveRunId.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FetchBuildSlaveFinishedStatsRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.stampedeId = new StampedeId();
        struct.stampedeId.read(iprot);
        struct.setStampedeIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.buildSlaveRunId = new BuildSlaveRunId();
        struct.buildSlaveRunId.read(iprot);
        struct.setBuildSlaveRunIdIsSet(true);
      }
    }
  }

}

