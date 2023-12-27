/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.transport.IWriteable;

public interface IStreamSerializer {
    default public byte getSerializerId() {
    }

    default public void attachBuffer(IWriteable iWriteable) {
    }

    default public IWriteable getAttachedBuffer() {
    }

    default public int getDirectPos() {
    }

    default public int detachBuffer() {
    }

    default public void beginSizeCalc() {
    }

    default public int endSizeCalc() {
    }

    default public void putBool(boolean bl) {
    }

    default public void putUChar16(char c2) {
    }

    default public void putUInt8(short s) {
    }

    default public void putInt8(byte by) {
    }

    default public void putUInt16(int n) {
    }

    default public void putInt16(short s) {
    }

    default public void putUInt32(long l) {
    }

    default public void putInt32(int n) {
    }

    default public void putUInt64(long l) {
    }

    default public void putInt64(long l) {
    }

    default public void putFloat(float f2) {
    }

    default public void putDouble(double d2) {
    }

    default public void putFlags(byte by, int n) {
    }

    default public void putBoolArray(boolean[] blArray) {
    }

    default public void putUChar16Array(char[] cArray) {
    }

    default public void putUInt8Array(short[] sArray) {
    }

    default public void putInt8Array(byte[] byArray) {
    }

    default public void putUInt16Array(int[] nArray) {
    }

    default public void putInt16Array(short[] sArray) {
    }

    default public void putUInt32Array(long[] lArray) {
    }

    default public void putInt32Array(int[] nArray) {
    }

    default public void putUInt64Array(long[] lArray) {
    }

    default public void putInt64Array(long[] lArray) {
    }

    default public void putFloatArray(float[] fArray) {
    }

    default public void putDoubleArray(double[] dArray) {
    }

    default public String getDescription() {
    }

    default public byte getId() {
    }

    default public void putRawBytes(byte[] byArray) {
    }

    default public IStreamSerializer createCompatibleStreamSerializer() {
    }

    default public IStreamDeserializer createCompatibleStreamDeserializer() {
    }
}

