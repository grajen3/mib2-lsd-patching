/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.transport.IWriteable;

public class StreamSerializerProxy
implements IStreamSerializer {
    protected IStreamSerializer serializer;

    public StreamSerializerProxy(IStreamSerializer iStreamSerializer) {
        this.serializer = iStreamSerializer;
    }

    @Override
    public void attachBuffer(IWriteable iWriteable) {
        this.serializer.attachBuffer(iWriteable);
    }

    @Override
    public void beginSizeCalc() {
        this.serializer.beginSizeCalc();
    }

    @Override
    public IWriteable getAttachedBuffer() {
        return this.serializer.getAttachedBuffer();
    }

    @Override
    public int getDirectPos() {
        return this.serializer.getDirectPos();
    }

    @Override
    public int detachBuffer() {
        return this.serializer.detachBuffer();
    }

    @Override
    public int endSizeCalc() {
        return this.serializer.endSizeCalc();
    }

    @Override
    public byte getSerializerId() {
        return this.serializer.getSerializerId();
    }

    @Override
    public void putBool(boolean bl) {
        this.serializer.putBool(bl);
    }

    @Override
    public void putBoolArray(boolean[] blArray) {
        this.serializer.putBoolArray(blArray);
    }

    @Override
    public void putUChar16(char c2) {
        this.serializer.putUChar16(c2);
    }

    @Override
    public void putUChar16Array(char[] cArray) {
        this.serializer.putUChar16Array(cArray);
    }

    @Override
    public void putDouble(double d2) {
        this.serializer.putDouble(d2);
    }

    @Override
    public void putDoubleArray(double[] dArray) {
        this.serializer.putDoubleArray(dArray);
    }

    @Override
    public void putFlags(byte by, int n) {
        this.serializer.putFlags(by, n);
    }

    @Override
    public void putFloat(float f2) {
        this.serializer.putFloat(f2);
    }

    @Override
    public void putFloatArray(float[] fArray) {
        this.serializer.putFloatArray(fArray);
    }

    @Override
    public void putInt16(short s) {
        this.serializer.putInt16(s);
    }

    @Override
    public void putInt16Array(short[] sArray) {
        this.serializer.putInt16Array(sArray);
    }

    @Override
    public void putInt32(int n) {
        this.serializer.putInt32(n);
    }

    @Override
    public void putInt32Array(int[] nArray) {
        this.serializer.putInt32Array(nArray);
    }

    @Override
    public void putInt64(long l) {
        this.serializer.putInt64(l);
    }

    @Override
    public void putInt64Array(long[] lArray) {
        this.serializer.putInt64Array(lArray);
    }

    @Override
    public void putInt8(byte by) {
        this.serializer.putInt8(by);
    }

    @Override
    public void putInt8Array(byte[] byArray) {
        this.serializer.putInt8Array(byArray);
    }

    @Override
    public void putUInt16(int n) {
        this.serializer.putUInt16(n);
    }

    @Override
    public void putUInt16Array(int[] nArray) {
        this.serializer.putUInt16Array(nArray);
    }

    @Override
    public void putUInt32(long l) {
        this.serializer.putUInt32(l);
    }

    @Override
    public void putUInt32Array(long[] lArray) {
        this.serializer.putUInt32Array(lArray);
    }

    @Override
    public void putUInt64(long l) {
        this.serializer.putUInt64(l);
    }

    @Override
    public void putUInt64Array(long[] lArray) {
        this.serializer.putUInt64Array(lArray);
    }

    @Override
    public void putUInt8(short s) {
        this.serializer.putUInt8(s);
    }

    @Override
    public void putUInt8Array(short[] sArray) {
        this.serializer.putUInt8Array(sArray);
    }

    @Override
    public void putRawBytes(byte[] byArray) {
        this.serializer.putRawBytes(byArray);
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[Proxy:").append(this.serializer.getDescription()).append("]").toString();
    }

    @Override
    public byte getId() {
        return this.serializer.getId();
    }

    @Override
    public IStreamSerializer createCompatibleStreamSerializer() {
        return this.serializer.createCompatibleStreamSerializer();
    }

    @Override
    public IStreamDeserializer createCompatibleStreamDeserializer() {
        return this.serializer.createCompatibleStreamDeserializer();
    }
}

