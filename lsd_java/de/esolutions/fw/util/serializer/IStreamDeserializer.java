/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.transport.IReadable;

public interface IStreamDeserializer
extends Cloneable {
    default public Object clone() {
    }

    default public boolean canHandleSerializerId(byte by) {
    }

    default public void attachBuffer(IReadable iReadable) {
    }

    default public IReadable getAttachedBuffer() {
    }

    default public int getDirectPos() {
    }

    default public int detachBuffer() {
    }

    default public boolean getBool() {
    }

    default public char getUChar16() {
    }

    default public short getUInt8() {
    }

    default public byte getInt8() {
    }

    default public int getUInt16() {
    }

    default public short getInt16() {
    }

    default public long getUInt32() {
    }

    default public int getInt32() {
    }

    default public long getUInt64() {
    }

    default public long getInt64() {
    }

    default public float getFloat() {
    }

    default public double getDouble() {
    }

    default public int getFlags(byte by) {
    }

    default public void getBoolArray(boolean[] blArray) {
    }

    default public void getUChar16Array(char[] cArray) {
    }

    default public void getUInt8Array(short[] sArray) {
    }

    default public void getInt8Array(byte[] byArray) {
    }

    default public void getUInt16Array(int[] nArray) {
    }

    default public void getInt16Array(short[] sArray) {
    }

    default public void getUInt32Array(long[] lArray) {
    }

    default public void getInt32Array(int[] nArray) {
    }

    default public void getUInt64Array(long[] lArray) {
    }

    default public void getInt64Array(long[] lArray) {
    }

    default public void getFloatArray(float[] fArray) {
    }

    default public void getDoubleArray(double[] dArray) {
    }

    default public String getDescription() {
    }

    default public byte getId() {
    }

    default public int bytesLeft() {
    }

    default public void getRawBytes(byte[] byArray) {
    }

    default public IStreamSerializer createCompatibleStreamSerializer() {
    }

    default public IStreamDeserializer createCompatibleStreamDeserializer() {
    }
}

