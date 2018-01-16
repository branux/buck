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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-01-10")
public class BuildRuleStartedEvent implements org.apache.thrift.TBase<BuildRuleStartedEvent, BuildRuleStartedEvent._Fields>, java.io.Serializable, Cloneable, Comparable<BuildRuleStartedEvent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BuildRuleStartedEvent");

  private static final org.apache.thrift.protocol.TField BUILD_TARGET_FIELD_DESC = new org.apache.thrift.protocol.TField("buildTarget", org.apache.thrift.protocol.TType.STRING, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BuildRuleStartedEventStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BuildRuleStartedEventTupleSchemeFactory());
  }

  public String buildTarget; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BUILD_TARGET((short)1, "buildTarget");

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
        case 1: // BUILD_TARGET
          return BUILD_TARGET;
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
  private static final _Fields optionals[] = {_Fields.BUILD_TARGET};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BUILD_TARGET, new org.apache.thrift.meta_data.FieldMetaData("buildTarget", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BuildRuleStartedEvent.class, metaDataMap);
  }

  public BuildRuleStartedEvent() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BuildRuleStartedEvent(BuildRuleStartedEvent other) {
    if (other.isSetBuildTarget()) {
      this.buildTarget = other.buildTarget;
    }
  }

  public BuildRuleStartedEvent deepCopy() {
    return new BuildRuleStartedEvent(this);
  }

  @Override
  public void clear() {
    this.buildTarget = null;
  }

  public String getBuildTarget() {
    return this.buildTarget;
  }

  public BuildRuleStartedEvent setBuildTarget(String buildTarget) {
    this.buildTarget = buildTarget;
    return this;
  }

  public void unsetBuildTarget() {
    this.buildTarget = null;
  }

  /** Returns true if field buildTarget is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildTarget() {
    return this.buildTarget != null;
  }

  public void setBuildTargetIsSet(boolean value) {
    if (!value) {
      this.buildTarget = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BUILD_TARGET:
      if (value == null) {
        unsetBuildTarget();
      } else {
        setBuildTarget((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BUILD_TARGET:
      return getBuildTarget();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BUILD_TARGET:
      return isSetBuildTarget();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BuildRuleStartedEvent)
      return this.equals((BuildRuleStartedEvent)that);
    return false;
  }

  public boolean equals(BuildRuleStartedEvent that) {
    if (that == null)
      return false;

    boolean this_present_buildTarget = true && this.isSetBuildTarget();
    boolean that_present_buildTarget = true && that.isSetBuildTarget();
    if (this_present_buildTarget || that_present_buildTarget) {
      if (!(this_present_buildTarget && that_present_buildTarget))
        return false;
      if (!this.buildTarget.equals(that.buildTarget))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_buildTarget = true && (isSetBuildTarget());
    list.add(present_buildTarget);
    if (present_buildTarget)
      list.add(buildTarget);

    return list.hashCode();
  }

  @Override
  public int compareTo(BuildRuleStartedEvent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetBuildTarget()).compareTo(other.isSetBuildTarget());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildTarget()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildTarget, other.buildTarget);
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
    StringBuilder sb = new StringBuilder("BuildRuleStartedEvent(");
    boolean first = true;

    if (isSetBuildTarget()) {
      sb.append("buildTarget:");
      if (this.buildTarget == null) {
        sb.append("null");
      } else {
        sb.append(this.buildTarget);
      }
      first = false;
    }
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

  private static class BuildRuleStartedEventStandardSchemeFactory implements SchemeFactory {
    public BuildRuleStartedEventStandardScheme getScheme() {
      return new BuildRuleStartedEventStandardScheme();
    }
  }

  private static class BuildRuleStartedEventStandardScheme extends StandardScheme<BuildRuleStartedEvent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BuildRuleStartedEvent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BUILD_TARGET
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.buildTarget = iprot.readString();
              struct.setBuildTargetIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, BuildRuleStartedEvent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.buildTarget != null) {
        if (struct.isSetBuildTarget()) {
          oprot.writeFieldBegin(BUILD_TARGET_FIELD_DESC);
          oprot.writeString(struct.buildTarget);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BuildRuleStartedEventTupleSchemeFactory implements SchemeFactory {
    public BuildRuleStartedEventTupleScheme getScheme() {
      return new BuildRuleStartedEventTupleScheme();
    }
  }

  private static class BuildRuleStartedEventTupleScheme extends TupleScheme<BuildRuleStartedEvent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BuildRuleStartedEvent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetBuildTarget()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetBuildTarget()) {
        oprot.writeString(struct.buildTarget);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BuildRuleStartedEvent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.buildTarget = iprot.readString();
        struct.setBuildTargetIsSet(true);
      }
    }
  }

}

