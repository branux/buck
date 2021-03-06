/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.remoteexecution.executionengine;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.facebook.thrift.*;
import com.facebook.thrift.async.*;
import com.facebook.thrift.meta_data.*;
import com.facebook.thrift.server.*;
import com.facebook.thrift.transport.*;
import com.facebook.thrift.protocol.*;

@SuppressWarnings({ "unused", "serial" })
public class ExecuteOperationMetadata implements TBase, java.io.Serializable, Cloneable, Comparable<ExecuteOperationMetadata> {
  private static final TStruct STRUCT_DESC = new TStruct("ExecuteOperationMetadata");
  private static final TField STAGE_FIELD_DESC = new TField("stage", TType.I32, (short)1);
  private static final TField ACTION_DIGEST_FIELD_DESC = new TField("action_digest", TType.STRUCT, (short)2);

  /**
   * 
   * @see ExecuteOperationStage
   */
  public int stage;
  public com.facebook.remoteexecution.cas.Digest action_digest;
  public static final int STAGE = 1;
  public static final int ACTION_DIGEST = 2;
  public static boolean DEFAULT_PRETTY_PRINT = true;

  // isset id assignments
  private static final int __STAGE_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<Integer, FieldMetaData> metaDataMap;
  static {
    Map<Integer, FieldMetaData> tmpMetaDataMap = new HashMap<Integer, FieldMetaData>();
    tmpMetaDataMap.put(STAGE, new FieldMetaData("stage", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I32)));
    tmpMetaDataMap.put(ACTION_DIGEST, new FieldMetaData("action_digest", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, com.facebook.remoteexecution.cas.Digest.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMetaDataMap);
  }

  static {
    FieldMetaData.addStructMetaDataMap(ExecuteOperationMetadata.class, metaDataMap);
  }

  public ExecuteOperationMetadata() {
  }

  public ExecuteOperationMetadata(
    int stage,
    com.facebook.remoteexecution.cas.Digest action_digest)
  {
    this();
    this.stage = stage;
    setStageIsSet(true);
    this.action_digest = action_digest;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ExecuteOperationMetadata(ExecuteOperationMetadata other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.stage = TBaseHelper.deepCopy(other.stage);
    if (other.isSetAction_digest()) {
      this.action_digest = TBaseHelper.deepCopy(other.action_digest);
    }
  }

  public ExecuteOperationMetadata deepCopy() {
    return new ExecuteOperationMetadata(this);
  }

  @Deprecated
  public ExecuteOperationMetadata clone() {
    return new ExecuteOperationMetadata(this);
  }

  /**
   * 
   * @see ExecuteOperationStage
   */
  public int  getStage() {
    return this.stage;
  }

  /**
   * 
   * @see ExecuteOperationStage
   */
  public ExecuteOperationMetadata setStage(int stage) {
    this.stage = stage;
    setStageIsSet(true);
    return this;
  }

  public void unsetStage() {
    __isset_bit_vector.clear(__STAGE_ISSET_ID);
  }

  // Returns true if field stage is set (has been assigned a value) and false otherwise
  public boolean isSetStage() {
    return __isset_bit_vector.get(__STAGE_ISSET_ID);
  }

  public void setStageIsSet(boolean value) {
    __isset_bit_vector.set(__STAGE_ISSET_ID, value);
  }

  public com.facebook.remoteexecution.cas.Digest  getAction_digest() {
    return this.action_digest;
  }

  public ExecuteOperationMetadata setAction_digest(com.facebook.remoteexecution.cas.Digest action_digest) {
    this.action_digest = action_digest;
    return this;
  }

  public void unsetAction_digest() {
    this.action_digest = null;
  }

  // Returns true if field action_digest is set (has been assigned a value) and false otherwise
  public boolean isSetAction_digest() {
    return this.action_digest != null;
  }

  public void setAction_digestIsSet(boolean value) {
    if (!value) {
      this.action_digest = null;
    }
  }

  public void setFieldValue(int fieldID, Object value) {
    switch (fieldID) {
    case STAGE:
      if (value == null) {
        unsetStage();
      } else {
        setStage((Integer)value);
      }
      break;

    case ACTION_DIGEST:
      if (value == null) {
        unsetAction_digest();
      } else {
        setAction_digest((com.facebook.remoteexecution.cas.Digest)value);
      }
      break;

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  public Object getFieldValue(int fieldID) {
    switch (fieldID) {
    case STAGE:
      return getStage();

    case ACTION_DIGEST:
      return getAction_digest();

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  // Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise
  public boolean isSet(int fieldID) {
    switch (fieldID) {
    case STAGE:
      return isSetStage();
    case ACTION_DIGEST:
      return isSetAction_digest();
    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ExecuteOperationMetadata)
      return this.equals((ExecuteOperationMetadata)that);
    return false;
  }

  public boolean equals(ExecuteOperationMetadata that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_stage = true;
    boolean that_present_stage = true;
    if (this_present_stage || that_present_stage) {
      if (!(this_present_stage && that_present_stage))
        return false;
      if (!TBaseHelper.equalsNobinary(this.stage, that.stage))
        return false;
    }

    boolean this_present_action_digest = true && this.isSetAction_digest();
    boolean that_present_action_digest = true && that.isSetAction_digest();
    if (this_present_action_digest || that_present_action_digest) {
      if (!(this_present_action_digest && that_present_action_digest))
        return false;
      if (!TBaseHelper.equalsNobinary(this.action_digest, that.action_digest))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ExecuteOperationMetadata other) {
    if (other == null) {
      // See java.lang.Comparable docs
      throw new NullPointerException();
    }

    if (other == this) {
      return 0;
    }
    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStage()).compareTo(other.isSetStage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(stage, other.stage);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetAction_digest()).compareTo(other.isSetAction_digest());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(action_digest, other.action_digest);
    if (lastComparison != 0) {
      return lastComparison;
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin(metaDataMap);
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id)
      {
        case STAGE:
          if (field.type == TType.I32) {
            this.stage = iprot.readI32();
            setStageIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case ACTION_DIGEST:
          if (field.type == TType.STRUCT) {
            this.action_digest = new com.facebook.remoteexecution.cas.Digest();
            this.action_digest.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
          break;
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();


    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(STAGE_FIELD_DESC);
    oprot.writeI32(this.stage);
    oprot.writeFieldEnd();
    if (this.action_digest != null) {
      oprot.writeFieldBegin(ACTION_DIGEST_FIELD_DESC);
      this.action_digest.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    return toString(DEFAULT_PRETTY_PRINT);
  }

  @Override
  public String toString(boolean prettyPrint) {
    return toString(1, prettyPrint);
  }

  @Override
  public String toString(int indent, boolean prettyPrint) {
    String indentStr = prettyPrint ? TBaseHelper.getIndentedString(indent) : "";
    String newLine = prettyPrint ? "\n" : "";
String space = prettyPrint ? " " : "";
    StringBuilder sb = new StringBuilder("ExecuteOperationMetadata");
    sb.append(space);
    sb.append("(");
    sb.append(newLine);
    boolean first = true;

    sb.append(indentStr);
    sb.append("stage");
    sb.append(space);
    sb.append(":").append(space);
    String stage_name = ExecuteOperationStage.VALUES_TO_NAMES.get(this. getStage());
    if (stage_name != null) {
      sb.append(stage_name);
      sb.append(" (");
    }
    sb.append(this. getStage());
    if (stage_name != null) {
      sb.append(")");
    }
    first = false;
    if (!first) sb.append("," + newLine);
    sb.append(indentStr);
    sb.append("action_digest");
    sb.append(space);
    sb.append(":").append(space);
    if (this. getAction_digest() == null) {
      sb.append("null");
    } else {
      sb.append(TBaseHelper.toString(this. getAction_digest(), indent + 1, prettyPrint));
    }
    first = false;
    sb.append(newLine + TBaseHelper.reduceIndent(indentStr));
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check that fields of type enum have valid values
    if (isSetStage() && !ExecuteOperationStage.VALID_VALUES.contains(stage)){
      throw new TProtocolException("The field 'stage' has been assigned the invalid value " + stage);
    }
  }

}

