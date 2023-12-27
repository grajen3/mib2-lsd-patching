/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import java.util.List;

public interface ISerializer
extends IStreamSerializer {
    default public void putString(String string) {
    }

    default public void putOptionalString(String string) {
    }

    default public void putEnum(int n) {
    }

    default public void putObject(ISerializable iSerializable) {
    }

    default public void putOptionalObject(ISerializable iSerializable) {
    }

    default public void putObjectArray(ISerializable[] iSerializableArray) {
    }

    default public void putOptionalObjectArray(ISerializable[] iSerializableArray) {
    }

    default public void putObjectVarArray(ISerializable[] iSerializableArray) {
    }

    default public void putOptionalObjectVarArray(ISerializable[] iSerializableArray) {
    }

    default public void putList(List list) {
    }

    default public void putOptionalList(List list) {
    }

    default public void putStringArray(String[] stringArray) {
    }

    default public void putOptionalStringVarArray(String[] stringArray) {
    }

    default public void putBoolVarArray(boolean[] blArray) {
    }

    default public void putUInt8VarArray(short[] sArray) {
    }

    default public void putInt8VarArray(byte[] byArray) {
    }

    default public void putUChar16VarArray(char[] cArray) {
    }

    default public void putUInt16VarArray(int[] nArray) {
    }

    default public void putInt16VarArray(short[] sArray) {
    }

    default public void putUInt32VarArray(long[] lArray) {
    }

    default public void putInt32VarArray(int[] nArray) {
    }

    default public void putUInt64VarArray(long[] lArray) {
    }

    default public void putInt64VarArray(long[] lArray) {
    }

    default public void putFloatVarArray(float[] fArray) {
    }

    default public void putDoubleVarArray(double[] dArray) {
    }

    default public void putOptionalBoolVarArray(boolean[] blArray) {
    }

    default public void putOptionalUInt8VarArray(short[] sArray) {
    }

    default public void putOptionalInt8VarArray(byte[] byArray) {
    }

    default public void putOptionalUChar16VarArray(char[] cArray) {
    }

    default public void putOptionalUInt16VarArray(int[] nArray) {
    }

    default public void putOptionalInt16VarArray(short[] sArray) {
    }

    default public void putOptionalUInt32VarArray(long[] lArray) {
    }

    default public void putOptionalInt32VarArray(int[] nArray) {
    }

    default public void putOptionalUInt64VarArray(long[] lArray) {
    }

    default public void putOptionalInt64VarArray(long[] lArray) {
    }

    default public void putOptionalFloatVarArray(float[] fArray) {
    }

    default public void putOptionalDoubleVarArray(double[] dArray) {
    }

    default public void putOptionalEnumVarArray(int[] nArray) {
    }

    default public ISerializer createCompatibleSerializer() {
    }

    default public IDeserializer createCompatibleDeserializer() {
    }
}

