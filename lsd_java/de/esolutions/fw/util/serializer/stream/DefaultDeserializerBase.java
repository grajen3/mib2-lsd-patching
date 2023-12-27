/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.serializer.stream;

import de.esolutions.fw.util.commons.miniser.IMiniIntDeserializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerBufferUnderrunException;
import de.esolutions.fw.util.serializer.stream.DefaultSerializerBase;
import de.esolutions.fw.util.transport.IReadable;

public class DefaultDeserializerBase
implements IStreamDeserializer,
Cloneable {
    protected IReadable readable;
    protected int dpos;
    protected byte[] ddata;
    protected IMiniIntDeserializer intDeser;
    protected byte id;

    public DefaultDeserializerBase(IMiniIntDeserializer iMiniIntDeserializer, byte by) {
        this.intDeser = iMiniIntDeserializer;
        this.id = by;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public boolean canHandleSerializerId(byte by) {
        return by == this.id;
    }

    @Override
    public void attachBuffer(IReadable iReadable) {
        this.readable = iReadable;
        this.dpos = iReadable.getDirectOffset();
        this.ddata = iReadable.getDirectData();
    }

    @Override
    public IReadable getAttachedBuffer() {
        return this.readable;
    }

    @Override
    public int getDirectPos() {
        return this.dpos;
    }

    @Override
    public int detachBuffer() {
        this.ddata = null;
        this.readable = null;
        return this.dpos;
    }

    @Override
    public boolean getBool() {
        try {
            byte by = this.ddata[this.dpos];
            ++this.dpos;
            return by != 0;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getBoolArray(boolean[] blArray) {
        try {
            int n = blArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                blArray[i2] = this.ddata[this.dpos] != 0;
                ++this.dpos;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public double getDouble() {
        try {
            long l = this.intDeser.retrieveLong(this.ddata, this.dpos);
            this.dpos += 8;
            return Double.longBitsToDouble((long)l);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getDoubleArray(double[] dArray) {
        try {
            int n = dArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                dArray[i2] = Double.longBitsToDouble((long)this.intDeser.retrieveLong(this.ddata, this.dpos));
                this.dpos += 8;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public int getFlags(byte by) {
        int[] nArray = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4};
        try {
            int n = nArray[by - 1];
            int n2 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                n2 <<= 8;
                n2 |= this.ddata[this.dpos] & 0xFF;
                ++this.dpos;
            }
            return n2;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public float getFloat() {
        try {
            float f2 = Float.intBitsToFloat(this.intDeser.retrieveInt(this.ddata, this.dpos));
            this.dpos += 4;
            return f2;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getFloatArray(float[] fArray) {
        try {
            int n = fArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                fArray[i2] = Float.intBitsToFloat(this.intDeser.retrieveInt(this.ddata, this.dpos));
                this.dpos += 4;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public short getInt16() {
        try {
            short s = this.intDeser.retrieveShort(this.ddata, this.dpos);
            this.dpos += 2;
            return s;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getInt16Array(short[] sArray) {
        try {
            int n = sArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                sArray[i2] = this.intDeser.retrieveShort(this.ddata, this.dpos);
                this.dpos += 2;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public char getUChar16() {
        try {
            short s = this.intDeser.retrieveShort(this.ddata, this.dpos);
            this.dpos += 2;
            return (char)s;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getUChar16Array(char[] cArray) {
        try {
            int n = cArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                cArray[i2] = (char)this.intDeser.retrieveShort(this.ddata, this.dpos);
                this.dpos += 2;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public int getInt32() {
        try {
            int n = this.intDeser.retrieveInt(this.ddata, this.dpos);
            this.dpos += 4;
            return n;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getInt32Array(int[] nArray) {
        try {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                nArray[i2] = this.intDeser.retrieveInt(this.ddata, this.dpos);
                this.dpos += 4;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public long getInt64() {
        try {
            long l = this.intDeser.retrieveLong(this.ddata, this.dpos);
            this.dpos += 8;
            return l;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getInt64Array(long[] lArray) {
        try {
            int n = lArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                lArray[i2] = this.intDeser.retrieveLong(this.ddata, this.dpos);
                this.dpos += 8;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public byte getInt8() {
        try {
            byte by = this.ddata[this.dpos];
            ++this.dpos;
            return by;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getInt8Array(byte[] byArray) {
        try {
            int n = byArray.length;
            System.arraycopy((Object)this.ddata, this.dpos, (Object)byArray, 0, n);
            this.dpos += n;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public int getUInt16() {
        try {
            int n = this.intDeser.retrieveUnsignedShort(this.ddata, this.dpos) & 0xFFFF0000;
            this.dpos += 2;
            return n;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getUInt16Array(int[] nArray) {
        try {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                nArray[i2] = this.intDeser.retrieveUnsignedShort(this.ddata, this.dpos) & 0xFFFF0000;
                this.dpos += 2;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public long getUInt32() {
        try {
            long l = this.intDeser.retrieveUnsignedInt(this.ddata, this.dpos) & 0;
            this.dpos += 4;
            return l;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getUInt32Array(long[] lArray) {
        try {
            int n = lArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                lArray[i2] = this.intDeser.retrieveUnsignedInt(this.ddata, this.dpos) & 0;
                this.dpos += 4;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public long getUInt64() {
        return this.getInt64();
    }

    @Override
    public void getUInt64Array(long[] lArray) {
        this.getInt64Array(lArray);
    }

    @Override
    public short getUInt8() {
        try {
            short s = (short)(this.ddata[this.dpos] & 0xFF);
            ++this.dpos;
            return s;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getUInt8Array(short[] sArray) {
        try {
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                sArray[i2] = (short)(this.ddata[this.dpos] & 0xFF);
                ++this.dpos;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public void getRawBytes(byte[] byArray) {
        try {
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                byArray[i2] = this.ddata[this.dpos];
                ++this.dpos;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    @Override
    public int bytesLeft() {
        return this.ddata.length - this.dpos;
    }

    @Override
    public String getDescription() {
        return this.intDeser.getDescription();
    }

    @Override
    public byte getId() {
        return this.id;
    }

    @Override
    public IStreamSerializer createCompatibleStreamSerializer() {
        return new DefaultSerializerBase(this.intDeser.createCompatibleSerializer(), this.id);
    }

    @Override
    public IStreamDeserializer createCompatibleStreamDeserializer() {
        return new DefaultDeserializerBase(this.intDeser.createCompatibleDeserializer(), this.id);
    }
}

