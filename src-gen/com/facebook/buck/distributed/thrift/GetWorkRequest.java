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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-11-16")
public class GetWorkRequest implements org.apache.thrift.TBase<GetWorkRequest, GetWorkRequest._Fields>, java.io.Serializable, Cloneable, Comparable<GetWorkRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetWorkRequest");

  private static final org.apache.thrift.protocol.TField MINION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("minionId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField STAMPEDE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("stampedeId", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_EXIT_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("lastExitCode", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField FINISHED_TARGETS_FIELD_DESC = new org.apache.thrift.protocol.TField("finishedTargets", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField MAX_WORK_UNITS_TO_FETCH_FIELD_DESC = new org.apache.thrift.protocol.TField("maxWorkUnitsToFetch", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GetWorkRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GetWorkRequestTupleSchemeFactory());
  }

  public String minionId; // optional
  public com.facebook.buck.distributed.thrift.StampedeId stampedeId; // optional
  public int lastExitCode; // optional
  public List<String> finishedTargets; // optional
  public int maxWorkUnitsToFetch; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MINION_ID((short)1, "minionId"),
    STAMPEDE_ID((short)2, "stampedeId"),
    LAST_EXIT_CODE((short)3, "lastExitCode"),
    FINISHED_TARGETS((short)4, "finishedTargets"),
    MAX_WORK_UNITS_TO_FETCH((short)6, "maxWorkUnitsToFetch");

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
        case 1: // MINION_ID
          return MINION_ID;
        case 2: // STAMPEDE_ID
          return STAMPEDE_ID;
        case 3: // LAST_EXIT_CODE
          return LAST_EXIT_CODE;
        case 4: // FINISHED_TARGETS
          return FINISHED_TARGETS;
        case 6: // MAX_WORK_UNITS_TO_FETCH
          return MAX_WORK_UNITS_TO_FETCH;
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
  private static final int __LASTEXITCODE_ISSET_ID = 0;
  private static final int __MAXWORKUNITSTOFETCH_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.MINION_ID,_Fields.STAMPEDE_ID,_Fields.LAST_EXIT_CODE,_Fields.FINISHED_TARGETS,_Fields.MAX_WORK_UNITS_TO_FETCH};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MINION_ID, new org.apache.thrift.meta_data.FieldMetaData("minionId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STAMPEDE_ID, new org.apache.thrift.meta_data.FieldMetaData("stampedeId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.facebook.buck.distributed.thrift.StampedeId.class)));
    tmpMap.put(_Fields.LAST_EXIT_CODE, new org.apache.thrift.meta_data.FieldMetaData("lastExitCode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FINISHED_TARGETS, new org.apache.thrift.meta_data.FieldMetaData("finishedTargets", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.MAX_WORK_UNITS_TO_FETCH, new org.apache.thrift.meta_data.FieldMetaData("maxWorkUnitsToFetch", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetWorkRequest.class, metaDataMap);
  }

  public GetWorkRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GetWorkRequest(GetWorkRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetMinionId()) {
      this.minionId = other.minionId;
    }
    if (other.isSetStampedeId()) {
      this.stampedeId = new com.facebook.buck.distributed.thrift.StampedeId(other.stampedeId);
    }
    this.lastExitCode = other.lastExitCode;
    if (other.isSetFinishedTargets()) {
      List<String> __this__finishedTargets = new ArrayList<String>(other.finishedTargets);
      this.finishedTargets = __this__finishedTargets;
    }
    this.maxWorkUnitsToFetch = other.maxWorkUnitsToFetch;
  }

  public GetWorkRequest deepCopy() {
    return new GetWorkRequest(this);
  }

  @Override
  public void clear() {
    this.minionId = null;
    this.stampedeId = null;
    setLastExitCodeIsSet(false);
    this.lastExitCode = 0;
    this.finishedTargets = null;
    setMaxWorkUnitsToFetchIsSet(false);
    this.maxWorkUnitsToFetch = 0;
  }

  public String getMinionId() {
    return this.minionId;
  }

  public GetWorkRequest setMinionId(String minionId) {
    this.minionId = minionId;
    return this;
  }

  public void unsetMinionId() {
    this.minionId = null;
  }

  /** Returns true if field minionId is set (has been assigned a value) and false otherwise */
  public boolean isSetMinionId() {
    return this.minionId != null;
  }

  public void setMinionIdIsSet(boolean value) {
    if (!value) {
      this.minionId = null;
    }
  }

  public com.facebook.buck.distributed.thrift.StampedeId getStampedeId() {
    return this.stampedeId;
  }

  public GetWorkRequest setStampedeId(com.facebook.buck.distributed.thrift.StampedeId stampedeId) {
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

  public int getLastExitCode() {
    return this.lastExitCode;
  }

  public GetWorkRequest setLastExitCode(int lastExitCode) {
    this.lastExitCode = lastExitCode;
    setLastExitCodeIsSet(true);
    return this;
  }

  public void unsetLastExitCode() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LASTEXITCODE_ISSET_ID);
  }

  /** Returns true if field lastExitCode is set (has been assigned a value) and false otherwise */
  public boolean isSetLastExitCode() {
    return EncodingUtils.testBit(__isset_bitfield, __LASTEXITCODE_ISSET_ID);
  }

  public void setLastExitCodeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LASTEXITCODE_ISSET_ID, value);
  }

  public int getFinishedTargetsSize() {
    return (this.finishedTargets == null) ? 0 : this.finishedTargets.size();
  }

  public java.util.Iterator<String> getFinishedTargetsIterator() {
    return (this.finishedTargets == null) ? null : this.finishedTargets.iterator();
  }

  public void addToFinishedTargets(String elem) {
    if (this.finishedTargets == null) {
      this.finishedTargets = new ArrayList<String>();
    }
    this.finishedTargets.add(elem);
  }

  public List<String> getFinishedTargets() {
    return this.finishedTargets;
  }

  public GetWorkRequest setFinishedTargets(List<String> finishedTargets) {
    this.finishedTargets = finishedTargets;
    return this;
  }

  public void unsetFinishedTargets() {
    this.finishedTargets = null;
  }

  /** Returns true if field finishedTargets is set (has been assigned a value) and false otherwise */
  public boolean isSetFinishedTargets() {
    return this.finishedTargets != null;
  }

  public void setFinishedTargetsIsSet(boolean value) {
    if (!value) {
      this.finishedTargets = null;
    }
  }

  public int getMaxWorkUnitsToFetch() {
    return this.maxWorkUnitsToFetch;
  }

  public GetWorkRequest setMaxWorkUnitsToFetch(int maxWorkUnitsToFetch) {
    this.maxWorkUnitsToFetch = maxWorkUnitsToFetch;
    setMaxWorkUnitsToFetchIsSet(true);
    return this;
  }

  public void unsetMaxWorkUnitsToFetch() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MAXWORKUNITSTOFETCH_ISSET_ID);
  }

  /** Returns true if field maxWorkUnitsToFetch is set (has been assigned a value) and false otherwise */
  public boolean isSetMaxWorkUnitsToFetch() {
    return EncodingUtils.testBit(__isset_bitfield, __MAXWORKUNITSTOFETCH_ISSET_ID);
  }

  public void setMaxWorkUnitsToFetchIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MAXWORKUNITSTOFETCH_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MINION_ID:
      if (value == null) {
        unsetMinionId();
      } else {
        setMinionId((String)value);
      }
      break;

    case STAMPEDE_ID:
      if (value == null) {
        unsetStampedeId();
      } else {
        setStampedeId((com.facebook.buck.distributed.thrift.StampedeId)value);
      }
      break;

    case LAST_EXIT_CODE:
      if (value == null) {
        unsetLastExitCode();
      } else {
        setLastExitCode((Integer)value);
      }
      break;

    case FINISHED_TARGETS:
      if (value == null) {
        unsetFinishedTargets();
      } else {
        setFinishedTargets((List<String>)value);
      }
      break;

    case MAX_WORK_UNITS_TO_FETCH:
      if (value == null) {
        unsetMaxWorkUnitsToFetch();
      } else {
        setMaxWorkUnitsToFetch((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MINION_ID:
      return getMinionId();

    case STAMPEDE_ID:
      return getStampedeId();

    case LAST_EXIT_CODE:
      return getLastExitCode();

    case FINISHED_TARGETS:
      return getFinishedTargets();

    case MAX_WORK_UNITS_TO_FETCH:
      return getMaxWorkUnitsToFetch();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MINION_ID:
      return isSetMinionId();
    case STAMPEDE_ID:
      return isSetStampedeId();
    case LAST_EXIT_CODE:
      return isSetLastExitCode();
    case FINISHED_TARGETS:
      return isSetFinishedTargets();
    case MAX_WORK_UNITS_TO_FETCH:
      return isSetMaxWorkUnitsToFetch();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GetWorkRequest)
      return this.equals((GetWorkRequest)that);
    return false;
  }

  public boolean equals(GetWorkRequest that) {
    if (that == null)
      return false;

    boolean this_present_minionId = true && this.isSetMinionId();
    boolean that_present_minionId = true && that.isSetMinionId();
    if (this_present_minionId || that_present_minionId) {
      if (!(this_present_minionId && that_present_minionId))
        return false;
      if (!this.minionId.equals(that.minionId))
        return false;
    }

    boolean this_present_stampedeId = true && this.isSetStampedeId();
    boolean that_present_stampedeId = true && that.isSetStampedeId();
    if (this_present_stampedeId || that_present_stampedeId) {
      if (!(this_present_stampedeId && that_present_stampedeId))
        return false;
      if (!this.stampedeId.equals(that.stampedeId))
        return false;
    }

    boolean this_present_lastExitCode = true && this.isSetLastExitCode();
    boolean that_present_lastExitCode = true && that.isSetLastExitCode();
    if (this_present_lastExitCode || that_present_lastExitCode) {
      if (!(this_present_lastExitCode && that_present_lastExitCode))
        return false;
      if (this.lastExitCode != that.lastExitCode)
        return false;
    }

    boolean this_present_finishedTargets = true && this.isSetFinishedTargets();
    boolean that_present_finishedTargets = true && that.isSetFinishedTargets();
    if (this_present_finishedTargets || that_present_finishedTargets) {
      if (!(this_present_finishedTargets && that_present_finishedTargets))
        return false;
      if (!this.finishedTargets.equals(that.finishedTargets))
        return false;
    }

    boolean this_present_maxWorkUnitsToFetch = true && this.isSetMaxWorkUnitsToFetch();
    boolean that_present_maxWorkUnitsToFetch = true && that.isSetMaxWorkUnitsToFetch();
    if (this_present_maxWorkUnitsToFetch || that_present_maxWorkUnitsToFetch) {
      if (!(this_present_maxWorkUnitsToFetch && that_present_maxWorkUnitsToFetch))
        return false;
      if (this.maxWorkUnitsToFetch != that.maxWorkUnitsToFetch)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_minionId = true && (isSetMinionId());
    list.add(present_minionId);
    if (present_minionId)
      list.add(minionId);

    boolean present_stampedeId = true && (isSetStampedeId());
    list.add(present_stampedeId);
    if (present_stampedeId)
      list.add(stampedeId);

    boolean present_lastExitCode = true && (isSetLastExitCode());
    list.add(present_lastExitCode);
    if (present_lastExitCode)
      list.add(lastExitCode);

    boolean present_finishedTargets = true && (isSetFinishedTargets());
    list.add(present_finishedTargets);
    if (present_finishedTargets)
      list.add(finishedTargets);

    boolean present_maxWorkUnitsToFetch = true && (isSetMaxWorkUnitsToFetch());
    list.add(present_maxWorkUnitsToFetch);
    if (present_maxWorkUnitsToFetch)
      list.add(maxWorkUnitsToFetch);

    return list.hashCode();
  }

  @Override
  public int compareTo(GetWorkRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetMinionId()).compareTo(other.isSetMinionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMinionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.minionId, other.minionId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = Boolean.valueOf(isSetLastExitCode()).compareTo(other.isSetLastExitCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastExitCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastExitCode, other.lastExitCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFinishedTargets()).compareTo(other.isSetFinishedTargets());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFinishedTargets()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.finishedTargets, other.finishedTargets);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMaxWorkUnitsToFetch()).compareTo(other.isSetMaxWorkUnitsToFetch());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxWorkUnitsToFetch()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.maxWorkUnitsToFetch, other.maxWorkUnitsToFetch);
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
    StringBuilder sb = new StringBuilder("GetWorkRequest(");
    boolean first = true;

    if (isSetMinionId()) {
      sb.append("minionId:");
      if (this.minionId == null) {
        sb.append("null");
      } else {
        sb.append(this.minionId);
      }
      first = false;
    }
    if (isSetStampedeId()) {
      if (!first) sb.append(", ");
      sb.append("stampedeId:");
      if (this.stampedeId == null) {
        sb.append("null");
      } else {
        sb.append(this.stampedeId);
      }
      first = false;
    }
    if (isSetLastExitCode()) {
      if (!first) sb.append(", ");
      sb.append("lastExitCode:");
      sb.append(this.lastExitCode);
      first = false;
    }
    if (isSetFinishedTargets()) {
      if (!first) sb.append(", ");
      sb.append("finishedTargets:");
      if (this.finishedTargets == null) {
        sb.append("null");
      } else {
        sb.append(this.finishedTargets);
      }
      first = false;
    }
    if (isSetMaxWorkUnitsToFetch()) {
      if (!first) sb.append(", ");
      sb.append("maxWorkUnitsToFetch:");
      sb.append(this.maxWorkUnitsToFetch);
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

  private static class GetWorkRequestStandardSchemeFactory implements SchemeFactory {
    public GetWorkRequestStandardScheme getScheme() {
      return new GetWorkRequestStandardScheme();
    }
  }

  private static class GetWorkRequestStandardScheme extends StandardScheme<GetWorkRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GetWorkRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MINION_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.minionId = iprot.readString();
              struct.setMinionIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STAMPEDE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.stampedeId = new com.facebook.buck.distributed.thrift.StampedeId();
              struct.stampedeId.read(iprot);
              struct.setStampedeIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LAST_EXIT_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.lastExitCode = iprot.readI32();
              struct.setLastExitCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // FINISHED_TARGETS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.finishedTargets = new ArrayList<String>(_list8.size);
                String _elem9;
                for (int _i10 = 0; _i10 < _list8.size; ++_i10)
                {
                  _elem9 = iprot.readString();
                  struct.finishedTargets.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setFinishedTargetsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // MAX_WORK_UNITS_TO_FETCH
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.maxWorkUnitsToFetch = iprot.readI32();
              struct.setMaxWorkUnitsToFetchIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GetWorkRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.minionId != null) {
        if (struct.isSetMinionId()) {
          oprot.writeFieldBegin(MINION_ID_FIELD_DESC);
          oprot.writeString(struct.minionId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.stampedeId != null) {
        if (struct.isSetStampedeId()) {
          oprot.writeFieldBegin(STAMPEDE_ID_FIELD_DESC);
          struct.stampedeId.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetLastExitCode()) {
        oprot.writeFieldBegin(LAST_EXIT_CODE_FIELD_DESC);
        oprot.writeI32(struct.lastExitCode);
        oprot.writeFieldEnd();
      }
      if (struct.finishedTargets != null) {
        if (struct.isSetFinishedTargets()) {
          oprot.writeFieldBegin(FINISHED_TARGETS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.finishedTargets.size()));
            for (String _iter11 : struct.finishedTargets)
            {
              oprot.writeString(_iter11);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetMaxWorkUnitsToFetch()) {
        oprot.writeFieldBegin(MAX_WORK_UNITS_TO_FETCH_FIELD_DESC);
        oprot.writeI32(struct.maxWorkUnitsToFetch);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GetWorkRequestTupleSchemeFactory implements SchemeFactory {
    public GetWorkRequestTupleScheme getScheme() {
      return new GetWorkRequestTupleScheme();
    }
  }

  private static class GetWorkRequestTupleScheme extends TupleScheme<GetWorkRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GetWorkRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetMinionId()) {
        optionals.set(0);
      }
      if (struct.isSetStampedeId()) {
        optionals.set(1);
      }
      if (struct.isSetLastExitCode()) {
        optionals.set(2);
      }
      if (struct.isSetFinishedTargets()) {
        optionals.set(3);
      }
      if (struct.isSetMaxWorkUnitsToFetch()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetMinionId()) {
        oprot.writeString(struct.minionId);
      }
      if (struct.isSetStampedeId()) {
        struct.stampedeId.write(oprot);
      }
      if (struct.isSetLastExitCode()) {
        oprot.writeI32(struct.lastExitCode);
      }
      if (struct.isSetFinishedTargets()) {
        {
          oprot.writeI32(struct.finishedTargets.size());
          for (String _iter12 : struct.finishedTargets)
          {
            oprot.writeString(_iter12);
          }
        }
      }
      if (struct.isSetMaxWorkUnitsToFetch()) {
        oprot.writeI32(struct.maxWorkUnitsToFetch);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GetWorkRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.minionId = iprot.readString();
        struct.setMinionIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.stampedeId = new com.facebook.buck.distributed.thrift.StampedeId();
        struct.stampedeId.read(iprot);
        struct.setStampedeIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.lastExitCode = iprot.readI32();
        struct.setLastExitCodeIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.finishedTargets = new ArrayList<String>(_list13.size);
          String _elem14;
          for (int _i15 = 0; _i15 < _list13.size; ++_i15)
          {
            _elem14 = iprot.readString();
            struct.finishedTargets.add(_elem14);
          }
        }
        struct.setFinishedTargetsIsSet(true);
      }
      if (incoming.get(4)) {
        struct.maxWorkUnitsToFetch = iprot.readI32();
        struct.setMaxWorkUnitsToFetchIsSet(true);
      }
    }
  }

}

