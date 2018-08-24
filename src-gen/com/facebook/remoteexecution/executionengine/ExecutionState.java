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
public class ExecutionState implements TBase, java.io.Serializable, Cloneable, Comparable<ExecutionState> {
  private static final TStruct STRUCT_DESC = new TStruct("ExecutionState");
  private static final TField EXECUTION_ID_FIELD_DESC = new TField("execution_id", TType.STRING, (short)1);
  private static final TField METADATA_FIELD_DESC = new TField("metadata", TType.STRUCT, (short)2);
  private static final TField DONE_FIELD_DESC = new TField("done", TType.BOOL, (short)3);
  private static final TField RESULT_FIELD_DESC = new TField("result", TType.STRUCT, (short)4);

  public String execution_id;
  public ExecutionMetadata metadata;
  public boolean done;
  public ExecutionResult result;
  public static final int EXECUTION_ID = 1;
  public static final int METADATA = 2;
  public static final int DONE = 3;
  public static final int RESULT = 4;
  public static boolean DEFAULT_PRETTY_PRINT = true;

  // isset id assignments
  private static final int __DONE_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<Integer, FieldMetaData> metaDataMap;
  static {
    Map<Integer, FieldMetaData> tmpMetaDataMap = new HashMap<Integer, FieldMetaData>();
    tmpMetaDataMap.put(EXECUTION_ID, new FieldMetaData("execution_id", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMetaDataMap.put(METADATA, new FieldMetaData("metadata", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, ExecutionMetadata.class)));
    tmpMetaDataMap.put(DONE, new FieldMetaData("done", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.BOOL)));
    tmpMetaDataMap.put(RESULT, new FieldMetaData("result", TFieldRequirementType.OPTIONAL, 
        new StructMetaData(TType.STRUCT, ExecutionResult.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMetaDataMap);
  }

  static {
    FieldMetaData.addStructMetaDataMap(ExecutionState.class, metaDataMap);
  }

  public ExecutionState() {
  }

  public ExecutionState(
    String execution_id,
    ExecutionMetadata metadata,
    boolean done)
  {
    this();
    this.execution_id = execution_id;
    this.metadata = metadata;
    this.done = done;
    setDoneIsSet(true);
  }

  public ExecutionState(
    String execution_id,
    ExecutionMetadata metadata,
    boolean done,
    ExecutionResult result)
  {
    this();
    this.execution_id = execution_id;
    this.metadata = metadata;
    this.done = done;
    setDoneIsSet(true);
    this.result = result;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ExecutionState(ExecutionState other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetExecution_id()) {
      this.execution_id = TBaseHelper.deepCopy(other.execution_id);
    }
    if (other.isSetMetadata()) {
      this.metadata = TBaseHelper.deepCopy(other.metadata);
    }
    this.done = TBaseHelper.deepCopy(other.done);
    if (other.isSetResult()) {
      this.result = TBaseHelper.deepCopy(other.result);
    }
  }

  public ExecutionState deepCopy() {
    return new ExecutionState(this);
  }

  @Deprecated
  public ExecutionState clone() {
    return new ExecutionState(this);
  }

  public String  getExecution_id() {
    return this.execution_id;
  }

  public ExecutionState setExecution_id(String execution_id) {
    this.execution_id = execution_id;
    return this;
  }

  public void unsetExecution_id() {
    this.execution_id = null;
  }

  // Returns true if field execution_id is set (has been assigned a value) and false otherwise
  public boolean isSetExecution_id() {
    return this.execution_id != null;
  }

  public void setExecution_idIsSet(boolean value) {
    if (!value) {
      this.execution_id = null;
    }
  }

  public ExecutionMetadata  getMetadata() {
    return this.metadata;
  }

  public ExecutionState setMetadata(ExecutionMetadata metadata) {
    this.metadata = metadata;
    return this;
  }

  public void unsetMetadata() {
    this.metadata = null;
  }

  // Returns true if field metadata is set (has been assigned a value) and false otherwise
  public boolean isSetMetadata() {
    return this.metadata != null;
  }

  public void setMetadataIsSet(boolean value) {
    if (!value) {
      this.metadata = null;
    }
  }

  public boolean  isDone() {
    return this.done;
  }

  public ExecutionState setDone(boolean done) {
    this.done = done;
    setDoneIsSet(true);
    return this;
  }

  public void unsetDone() {
    __isset_bit_vector.clear(__DONE_ISSET_ID);
  }

  // Returns true if field done is set (has been assigned a value) and false otherwise
  public boolean isSetDone() {
    return __isset_bit_vector.get(__DONE_ISSET_ID);
  }

  public void setDoneIsSet(boolean value) {
    __isset_bit_vector.set(__DONE_ISSET_ID, value);
  }

  public ExecutionResult  getResult() {
    return this.result;
  }

  public ExecutionState setResult(ExecutionResult result) {
    this.result = result;
    return this;
  }

  public void unsetResult() {
    this.result = null;
  }

  // Returns true if field result is set (has been assigned a value) and false otherwise
  public boolean isSetResult() {
    return this.result != null;
  }

  public void setResultIsSet(boolean value) {
    if (!value) {
      this.result = null;
    }
  }

  public void setFieldValue(int fieldID, Object value) {
    switch (fieldID) {
    case EXECUTION_ID:
      if (value == null) {
        unsetExecution_id();
      } else {
        setExecution_id((String)value);
      }
      break;

    case METADATA:
      if (value == null) {
        unsetMetadata();
      } else {
        setMetadata((ExecutionMetadata)value);
      }
      break;

    case DONE:
      if (value == null) {
        unsetDone();
      } else {
        setDone((Boolean)value);
      }
      break;

    case RESULT:
      if (value == null) {
        unsetResult();
      } else {
        setResult((ExecutionResult)value);
      }
      break;

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  public Object getFieldValue(int fieldID) {
    switch (fieldID) {
    case EXECUTION_ID:
      return getExecution_id();

    case METADATA:
      return getMetadata();

    case DONE:
      return new Boolean(isDone());

    case RESULT:
      return getResult();

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  // Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise
  public boolean isSet(int fieldID) {
    switch (fieldID) {
    case EXECUTION_ID:
      return isSetExecution_id();
    case METADATA:
      return isSetMetadata();
    case DONE:
      return isSetDone();
    case RESULT:
      return isSetResult();
    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ExecutionState)
      return this.equals((ExecutionState)that);
    return false;
  }

  public boolean equals(ExecutionState that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_execution_id = true && this.isSetExecution_id();
    boolean that_present_execution_id = true && that.isSetExecution_id();
    if (this_present_execution_id || that_present_execution_id) {
      if (!(this_present_execution_id && that_present_execution_id))
        return false;
      if (!TBaseHelper.equalsNobinary(this.execution_id, that.execution_id))
        return false;
    }

    boolean this_present_metadata = true && this.isSetMetadata();
    boolean that_present_metadata = true && that.isSetMetadata();
    if (this_present_metadata || that_present_metadata) {
      if (!(this_present_metadata && that_present_metadata))
        return false;
      if (!TBaseHelper.equalsNobinary(this.metadata, that.metadata))
        return false;
    }

    boolean this_present_done = true;
    boolean that_present_done = true;
    if (this_present_done || that_present_done) {
      if (!(this_present_done && that_present_done))
        return false;
      if (!TBaseHelper.equalsNobinary(this.done, that.done))
        return false;
    }

    boolean this_present_result = true && this.isSetResult();
    boolean that_present_result = true && that.isSetResult();
    if (this_present_result || that_present_result) {
      if (!(this_present_result && that_present_result))
        return false;
      if (!TBaseHelper.equalsNobinary(this.result, that.result))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ExecutionState other) {
    if (other == null) {
      // See java.lang.Comparable docs
      throw new NullPointerException();
    }

    if (other == this) {
      return 0;
    }
    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetExecution_id()).compareTo(other.isSetExecution_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(execution_id, other.execution_id);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetMetadata()).compareTo(other.isSetMetadata());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(metadata, other.metadata);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetDone()).compareTo(other.isSetDone());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(done, other.done);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetResult()).compareTo(other.isSetResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(result, other.result);
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
        case EXECUTION_ID:
          if (field.type == TType.STRING) {
            this.execution_id = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case METADATA:
          if (field.type == TType.STRUCT) {
            this.metadata = new ExecutionMetadata();
            this.metadata.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case DONE:
          if (field.type == TType.BOOL) {
            this.done = iprot.readBool();
            setDoneIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case RESULT:
          if (field.type == TType.STRUCT) {
            this.result = new ExecutionResult();
            this.result.read(iprot);
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
    if (this.execution_id != null) {
      oprot.writeFieldBegin(EXECUTION_ID_FIELD_DESC);
      oprot.writeString(this.execution_id);
      oprot.writeFieldEnd();
    }
    if (this.metadata != null) {
      oprot.writeFieldBegin(METADATA_FIELD_DESC);
      this.metadata.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(DONE_FIELD_DESC);
    oprot.writeBool(this.done);
    oprot.writeFieldEnd();
    if (this.result != null) {
      if (isSetResult()) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        this.result.write(oprot);
        oprot.writeFieldEnd();
      }
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
    StringBuilder sb = new StringBuilder("ExecutionState");
    sb.append(space);
    sb.append("(");
    sb.append(newLine);
    boolean first = true;

    sb.append(indentStr);
    sb.append("execution_id");
    sb.append(space);
    sb.append(":").append(space);
    if (this. getExecution_id() == null) {
      sb.append("null");
    } else {
      sb.append(TBaseHelper.toString(this. getExecution_id(), indent + 1, prettyPrint));
    }
    first = false;
    if (!first) sb.append("," + newLine);
    sb.append(indentStr);
    sb.append("metadata");
    sb.append(space);
    sb.append(":").append(space);
    if (this. getMetadata() == null) {
      sb.append("null");
    } else {
      sb.append(TBaseHelper.toString(this. getMetadata(), indent + 1, prettyPrint));
    }
    first = false;
    if (!first) sb.append("," + newLine);
    sb.append(indentStr);
    sb.append("done");
    sb.append(space);
    sb.append(":").append(space);
    sb.append(TBaseHelper.toString(this. isDone(), indent + 1, prettyPrint));
    first = false;
    if (isSetResult())
    {
      if (!first) sb.append("," + newLine);
      sb.append(indentStr);
      sb.append("result");
      sb.append(space);
      sb.append(":").append(space);
      if (this. getResult() == null) {
        sb.append("null");
      } else {
        sb.append(TBaseHelper.toString(this. getResult(), indent + 1, prettyPrint));
      }
      first = false;
    }
    sb.append(newLine + TBaseHelper.reduceIndent(indentStr));
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check that fields of type enum have valid values
  }

}

