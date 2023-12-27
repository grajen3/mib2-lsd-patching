/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IDeserializable;
import de.esolutions.fw.util.serializer.IDeserializableArrayFactory;
import de.esolutions.fw.util.serializer.IDeserializableFactory;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import java.util.List;

public interface IDeserializer
extends IStreamDeserializer {
    default public String getString() {
    }

    default public String getOptionalString() {
    }

    default public String[] getOptionalStringVarArray() {
    }

    default public int getEnum() {
    }

    default public IDeserializable getObject(IDeserializableFactory iDeserializableFactory) {
    }

    default public IDeserializable getOptionalObject(IDeserializableFactory iDeserializableFactory) {
    }

    default public void getObjectArray(IDeserializableFactory iDeserializableFactory, IDeserializable[] iDeserializableArray) {
    }

    default public IDeserializable[] getOptionalObjectArray(IDeserializableArrayFactory iDeserializableArrayFactory, int n) {
    }

    default public IDeserializable[] getObjectVarArray(IDeserializableArrayFactory iDeserializableArrayFactory) {
    }

    default public IDeserializable[] getOptionalObjectVarArray(IDeserializableArrayFactory iDeserializableArrayFactory) {
    }

    default public List getObjectVarList(IDeserializableFactory iDeserializableFactory) {
    }

    default public List getOptionalObjectVarList(IDeserializableFactory iDeserializableFactory) {
    }

    default public boolean[] getBoolVarArray() {
    }

    default public char[] getUChar16VarArray() {
    }

    default public short[] getUInt8VarArray() {
    }

    default public byte[] getInt8VarArray() {
    }

    default public int[] getUInt16VarArray() {
    }

    default public short[] getInt16VarArray() {
    }

    default public long[] getUInt32VarArray() {
    }

    default public int[] getInt32VarArray() {
    }

    default public long[] getUInt64VarArray() {
    }

    default public long[] getInt64VarArray() {
    }

    default public float[] getFloatVarArray() {
    }

    default public double[] getDoubleVarArray() {
    }

    default public boolean[] getOptionalBoolVarArray() {
    }

    default public char[] getOptionalUChar16VarArray() {
    }

    default public short[] getOptionalUInt8VarArray() {
    }

    default public byte[] getOptionalInt8VarArray() {
    }

    default public int[] getOptionalUInt16VarArray() {
    }

    default public short[] getOptionalInt16VarArray() {
    }

    default public long[] getOptionalUInt32VarArray() {
    }

    default public int[] getOptionalInt32VarArray() {
    }

    default public long[] getOptionalUInt64VarArray() {
    }

    default public long[] getOptionalInt64VarArray() {
    }

    default public float[] getOptionalFloatVarArray() {
    }

    default public double[] getOptionalDoubleVarArray() {
    }

    default public int[] getOptionalEnumVarArray() {
    }

    default public ISerializer createCompatibleSerializer() {
    }

    default public IDeserializer createCompatibleDeserializer() {
    }
}

