/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.remoteexecution.cas;

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
public class BatchReadBlobsResponse implements TBase, java.io.Serializable, Cloneable, Comparable<BatchReadBlobsResponse> {
  private static final TStruct STRUCT_DESC = new TStruct("BatchReadBlobsResponse");
  private static final TField RESPONSES_FIELD_DESC = new TField("responses", TType.LIST, (short)1);

  public List<ReadBlobResponse> responses;
  public static final int RESPONSES = 1;
  public static boolean DEFAULT_PRETTY_PRINT = true;

  // isset id assignments

  public static final Map<Integer, FieldMetaData> metaDataMap;
  static {
    Map<Integer, FieldMetaData> tmpMetaDataMap = new HashMap<Integer, FieldMetaData>();
    tmpMetaDataMap.put(RESPONSES, new FieldMetaData("responses", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new StructMetaData(TType.STRUCT, ReadBlobResponse.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMetaDataMap);
  }

  static {
    FieldMetaData.addStructMetaDataMap(BatchReadBlobsResponse.class, metaDataMap);
  }

  public BatchReadBlobsResponse() {
  }

  public BatchReadBlobsResponse(
    List<ReadBlobResponse> responses)
  {
    this();
    this.responses = responses;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BatchReadBlobsResponse(BatchReadBlobsResponse other) {
    if (other.isSetResponses()) {
      this.responses = TBaseHelper.deepCopy(other.responses);
    }
  }

  public BatchReadBlobsResponse deepCopy() {
    return new BatchReadBlobsResponse(this);
  }

  @Deprecated
  public BatchReadBlobsResponse clone() {
    return new BatchReadBlobsResponse(this);
  }

  public List<ReadBlobResponse>  getResponses() {
    return this.responses;
  }

  public BatchReadBlobsResponse setResponses(List<ReadBlobResponse> responses) {
    this.responses = responses;
    return this;
  }

  public void unsetResponses() {
    this.responses = null;
  }

  // Returns true if field responses is set (has been assigned a value) and false otherwise
  public boolean isSetResponses() {
    return this.responses != null;
  }

  public void setResponsesIsSet(boolean value) {
    if (!value) {
      this.responses = null;
    }
  }

  @SuppressWarnings("unchecked")
  public void setFieldValue(int fieldID, Object value) {
    switch (fieldID) {
    case RESPONSES:
      if (value == null) {
        unsetResponses();
      } else {
        setResponses((List<ReadBlobResponse>)value);
      }
      break;

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  public Object getFieldValue(int fieldID) {
    switch (fieldID) {
    case RESPONSES:
      return getResponses();

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  // Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise
  public boolean isSet(int fieldID) {
    switch (fieldID) {
    case RESPONSES:
      return isSetResponses();
    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BatchReadBlobsResponse)
      return this.equals((BatchReadBlobsResponse)that);
    return false;
  }

  public boolean equals(BatchReadBlobsResponse that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_responses = true && this.isSetResponses();
    boolean that_present_responses = true && that.isSetResponses();
    if (this_present_responses || that_present_responses) {
      if (!(this_present_responses && that_present_responses))
        return false;
      if (!TBaseHelper.equalsNobinary(this.responses, that.responses))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(BatchReadBlobsResponse other) {
    if (other == null) {
      // See java.lang.Comparable docs
      throw new NullPointerException();
    }

    if (other == this) {
      return 0;
    }
    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResponses()).compareTo(other.isSetResponses());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(responses, other.responses);
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
        case RESPONSES:
          if (field.type == TType.LIST) {
            {
              TList _list28 = iprot.readListBegin();
              this.responses = new ArrayList<ReadBlobResponse>(Math.max(0, _list28.size));
              for (int _i29 = 0; 
                   (_list28.size < 0) ? iprot.peekList() : (_i29 < _list28.size); 
                   ++_i29)
              {
                ReadBlobResponse _elem30;
                _elem30 = new ReadBlobResponse();
                _elem30.read(iprot);
                this.responses.add(_elem30);
              }
              iprot.readListEnd();
            }
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
    if (this.responses != null) {
      oprot.writeFieldBegin(RESPONSES_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.responses.size()));
        for (ReadBlobResponse _iter31 : this.responses)        {
          _iter31.write(oprot);
        }
        oprot.writeListEnd();
      }
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
    StringBuilder sb = new StringBuilder("BatchReadBlobsResponse");
    sb.append(space);
    sb.append("(");
    sb.append(newLine);
    boolean first = true;

    sb.append(indentStr);
    sb.append("responses");
    sb.append(space);
    sb.append(":").append(space);
    if (this. getResponses() == null) {
      sb.append("null");
    } else {
      sb.append(TBaseHelper.toString(this. getResponses(), indent + 1, prettyPrint));
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

