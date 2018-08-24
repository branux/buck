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
public class ExecuteResponse implements TBase, java.io.Serializable, Cloneable, Comparable<ExecuteResponse> {
  private static final TStruct STRUCT_DESC = new TStruct("ExecuteResponse");
  private static final TField STATE_FIELD_DESC = new TField("state", TType.STRUCT, (short)1);

  public ExecutionState state;
  public static final int STATE = 1;
  public static boolean DEFAULT_PRETTY_PRINT = true;

  // isset id assignments

  public static final Map<Integer, FieldMetaData> metaDataMap;
  static {
    Map<Integer, FieldMetaData> tmpMetaDataMap = new HashMap<Integer, FieldMetaData>();
    tmpMetaDataMap.put(STATE, new FieldMetaData("state", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, ExecutionState.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMetaDataMap);
  }

  static {
    FieldMetaData.addStructMetaDataMap(ExecuteResponse.class, metaDataMap);
  }

  public ExecuteResponse() {
  }

  public ExecuteResponse(
    ExecutionState state)
  {
    this();
    this.state = state;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ExecuteResponse(ExecuteResponse other) {
    if (other.isSetState()) {
      this.state = TBaseHelper.deepCopy(other.state);
    }
  }

  public ExecuteResponse deepCopy() {
    return new ExecuteResponse(this);
  }

  @Deprecated
  public ExecuteResponse clone() {
    return new ExecuteResponse(this);
  }

  public ExecutionState  getState() {
    return this.state;
  }

  public ExecuteResponse setState(ExecutionState state) {
    this.state = state;
    return this;
  }

  public void unsetState() {
    this.state = null;
  }

  // Returns true if field state is set (has been assigned a value) and false otherwise
  public boolean isSetState() {
    return this.state != null;
  }

  public void setStateIsSet(boolean value) {
    if (!value) {
      this.state = null;
    }
  }

  public void setFieldValue(int fieldID, Object value) {
    switch (fieldID) {
    case STATE:
      if (value == null) {
        unsetState();
      } else {
        setState((ExecutionState)value);
      }
      break;

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  public Object getFieldValue(int fieldID) {
    switch (fieldID) {
    case STATE:
      return getState();

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  // Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise
  public boolean isSet(int fieldID) {
    switch (fieldID) {
    case STATE:
      return isSetState();
    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ExecuteResponse)
      return this.equals((ExecuteResponse)that);
    return false;
  }

  public boolean equals(ExecuteResponse that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_state = true && this.isSetState();
    boolean that_present_state = true && that.isSetState();
    if (this_present_state || that_present_state) {
      if (!(this_present_state && that_present_state))
        return false;
      if (!TBaseHelper.equalsNobinary(this.state, that.state))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ExecuteResponse other) {
    if (other == null) {
      // See java.lang.Comparable docs
      throw new NullPointerException();
    }

    if (other == this) {
      return 0;
    }
    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetState()).compareTo(other.isSetState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(state, other.state);
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
        case STATE:
          if (field.type == TType.STRUCT) {
            this.state = new ExecutionState();
            this.state.read(iprot);
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
    if (this.state != null) {
      oprot.writeFieldBegin(STATE_FIELD_DESC);
      this.state.write(oprot);
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
    StringBuilder sb = new StringBuilder("ExecuteResponse");
    sb.append(space);
    sb.append("(");
    sb.append(newLine);
    boolean first = true;

    sb.append(indentStr);
    sb.append("state");
    sb.append(space);
    sb.append(":").append(space);
    if (this. getState() == null) {
      sb.append("null");
    } else {
      sb.append(TBaseHelper.toString(this. getState(), indent + 1, prettyPrint));
    }
    first = false;
    sb.append(newLine + TBaseHelper.reduceIndent(indentStr));
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check that fields of type enum have valid values
  }

}

