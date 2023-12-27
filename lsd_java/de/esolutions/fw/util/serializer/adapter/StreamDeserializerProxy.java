/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.transport.IReadable;

public class StreamDeserializerProxy
implements IStreamDeserializer,
Cloneable {
    protected IStreamDeserializer deserializer;

    public StreamDeserializerProxy(IStreamDeserializer iStreamDeserializer) {
        this.deserializer = iStreamDeserializer;
    }

    @Override
    public Object clone() {
        try {
            StreamDeserializerProxy streamDeserializerProxy = (StreamDeserializerProxy)super.clone();
            streamDeserializerProxy.deserializer = (IStreamDeserializer)this.deserializer.clone();
            return streamDeserializerProxy;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public boolean canHandleSerializerId(byte by) {
        return this.deserializer.canHandleSerializerId(by);
    }

    @Override
    public void attachBuffer(IReadable iReadable) {
        this.deserializer.attachBuffer(iReadable);
    }

    @Override
    public IReadable getAttachedBuffer() {
        return this.deserializer.getAttachedBuffer();
    }

    @Override
    public int getDirectPos() {
        return this.deserializer.getDirectPos();
    }

    @Override
    public int detachBuffer() {
        return this.deserializer.detachBuffer();
    }

    @Override
    public boolean getBool() {
        return this.deserializer.getBool();
    }

    @Override
    public char getUChar16() {
        return this.deserializer.getUChar16();
    }

    @Override
    public short getUInt8() {
        return this.deserializer.getUInt8();
    }

    @Override
    public byte getInt8() {
        return this.deserializer.getInt8();
    }

    @Override
    public int getUInt16() {
        return this.deserializer.getUInt16();
    }

    @Override
    public short getInt16() {
        return this.deserializer.getInt16();
    }

    @Override
    public long getUInt32() {
        return this.deserializer.getUInt32();
    }

    @Override
    public int getInt32() {
        return this.deserializer.getInt32();
    }

    @Override
    public long getUInt64() {
        return this.deserializer.getUInt64();
    }

    @Override
    public long getInt64() {
        return this.deserializer.getInt64();
    }

    @Override
    public float getFloat() {
        return this.deserializer.getFloat();
    }

    @Override
    public double getDouble() {
        return this.deserializer.getDouble();
    }

    @Override
    public int getFlags(byte by) {
        return this.deserializer.getFlags(by);
    }

    @Override
    public void getBoolArray(boolean[] blArray) {
        this.deserializer.getBoolArray(blArray);
    }

    @Override
    public void getUChar16Array(char[] cArray) {
        this.deserializer.getUChar16Array(cArray);
    }

    @Override
    public void getUInt8Array(short[] sArray) {
        this.deserializer.getUInt8Array(sArray);
    }

    @Override
    public void getInt8Array(byte[] byArray) {
        this.deserializer.getInt8Array(byArray);
    }

    @Override
    public void getUInt16Array(int[] nArray) {
        this.deserializer.getUInt16Array(nArray);
    }

    @Override
    public void getInt16Array(short[] sArray) {
        this.deserializer.getInt16Array(sArray);
    }

    @Override
    public void getUInt32Array(long[] lArray) {
        this.deserializer.getUInt32Array(lArray);
    }

    @Override
    public void getInt32Array(int[] nArray) {
        this.deserializer.getInt32Array(nArray);
    }

    @Override
    public void getUInt64Array(long[] lArray) {
        this.deserializer.getUInt64Array(lArray);
    }

    @Override
    public void getInt64Array(long[] lArray) {
        this.deserializer.getInt64Array(lArray);
    }

    @Override
    public void getFloatArray(float[] fArray) {
        this.deserializer.getFloatArray(fArray);
    }

    @Override
    public void getDoubleArray(double[] dArray) {
        this.deserializer.getDoubleArray(dArray);
    }

    @Override
    public void getRawBytes(byte[] byArray) {
        this.deserializer.getRawBytes(byArray);
    }

    @Override
    public int bytesLeft() {
        return this.deserializer.bytesLeft();
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[Proxy:").append(this.deserializer.getDescription()).append("]").toString();
    }

    @Override
    public byte getId() {
        return this.deserializer.getId();
    }

    @Override
    public IStreamSerializer createCompatibleStreamSerializer() {
        return this.deserializer.createCompatibleStreamSerializer();
    }

    @Override
    public IStreamDeserializer createCompatibleStreamDeserializer() {
        return this.deserializer.createCompatibleStreamDeserializer();
    }
}

