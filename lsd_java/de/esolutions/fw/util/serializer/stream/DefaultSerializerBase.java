/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.serializer.stream;

import de.esolutions.fw.util.commons.miniser.IMiniIntSerializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerBufferOverflowException;
import de.esolutions.fw.util.serializer.stream.DefaultDeserializerBase;
import de.esolutions.fw.util.transport.IWriteable;

public class DefaultSerializerBase
implements IStreamSerializer {
    protected int dpos;
    protected IWriteable writeable;
    protected byte[] ddata;
    protected boolean hasWriteable = false;
    protected IMiniIntSerializer intSer;
    protected byte id;

    public DefaultSerializerBase(IMiniIntSerializer iMiniIntSerializer, byte by) {
        this.intSer = iMiniIntSerializer;
        this.id = by;
    }

    @Override
    public byte getSerializerId() {
        return this.id;
    }

    @Override
    public void attachBuffer(IWriteable iWriteable) {
        this.writeable = iWriteable;
        this.ddata = iWriteable.getDirectData();
        this.dpos = iWriteable.getDirectOffset();
        this.hasWriteable = true;
    }

    @Override
    public IWriteable getAttachedBuffer() {
        return this.writeable;
    }

    @Override
    public int getDirectPos() {
        return this.dpos;
    }

    @Override
    public void beginSizeCalc() {
        this.writeable = null;
        this.ddata = null;
        this.dpos = 0;
        this.hasWriteable = false;
    }

    @Override
    public int detachBuffer() {
        int n = this.dpos;
        this.hasWriteable = false;
        this.writeable = null;
        this.ddata = null;
        this.dpos = 0;
        return n;
    }

    @Override
    public int endSizeCalc() {
        int n = this.dpos;
        this.hasWriteable = false;
        this.writeable = null;
        this.dpos = 0;
        return n;
    }

    @Override
    public void putBool(boolean bl) {
        if (this.hasWriteable) {
            try {
                this.ddata[this.dpos] = bl ? -1 : 0;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        ++this.dpos;
    }

    @Override
    public void putBoolArray(boolean[] blArray) {
        int n = blArray.length;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < blArray.length; ++i2) {
                    this.ddata[this.dpos] = blArray[i2] ? -1 : 0;
                    ++this.dpos;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n;
        }
    }

    @Override
    public void putDouble(double d2) {
        if (this.hasWriteable) {
            try {
                long l = Double.doubleToLongBits((double)d2);
                this.intSer.storeLong(l, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 8;
    }

    @Override
    public void putDoubleArray(double[] dArray) {
        int n = dArray.length;
        int n2 = n << 3;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeLong(Double.doubleToLongBits((double)dArray[i2]), this.ddata, this.dpos);
                    this.dpos += 8;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    @Override
    public void putFlags(byte by, int n) {
        int n2;
        int[] nArray = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4};
        if (by < 32) {
            n2 = (1 << by) - 1;
            n &= n2;
        }
        n2 = nArray[by - 1];
        if (this.hasWriteable) {
            try {
                int n3 = this.dpos + n2 - 1;
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.ddata[n3] = (byte)(n & 0xFF);
                    n >>= 8;
                    --n3;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += n2;
    }

    @Override
    public void putFloat(float f2) {
        if (this.hasWriteable) {
            try {
                int n = Float.floatToIntBits(f2);
                this.intSer.storeInt(n, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 4;
    }

    @Override
    public void putFloatArray(float[] fArray) {
        int n = fArray.length;
        int n2 = n << 2;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeInt(Float.floatToIntBits(fArray[i2]), this.ddata, this.dpos);
                    this.dpos += 4;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    @Override
    public void putInt16(short s) {
        if (this.hasWriteable) {
            try {
                this.intSer.storeShort(s, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 2;
    }

    @Override
    public void putInt16Array(short[] sArray) {
        int n = sArray.length;
        int n2 = n << 1;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeShort(sArray[i2], this.ddata, this.dpos);
                    this.dpos += 2;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    @Override
    public void putUChar16(char c2) {
        if (this.hasWriteable) {
            try {
                this.intSer.storeShort((short)c2, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 2;
    }

    @Override
    public void putUChar16Array(char[] cArray) {
        int n = cArray.length;
        int n2 = n << 1;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeShort((short)cArray[i2], this.ddata, this.dpos);
                    this.dpos += 2;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    @Override
    public void putInt32(int n) {
        if (this.hasWriteable) {
            try {
                this.intSer.storeInt(n, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 4;
    }

    @Override
    public void putInt32Array(int[] nArray) {
        int n = nArray.length;
        int n2 = n << 2;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeInt(nArray[i2], this.ddata, this.dpos);
                    this.dpos += 4;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    @Override
    public void putInt64(long l) {
        if (this.hasWriteable) {
            try {
                this.intSer.storeLong(l, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 8;
    }

    @Override
    public void putInt64Array(long[] lArray) {
        int n = lArray.length;
        int n2 = n << 3;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeLong(lArray[i2], this.ddata, this.dpos);
                    this.dpos += 8;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    @Override
    public void putInt8(byte by) {
        if (this.hasWriteable) {
            try {
                this.ddata[this.dpos] = by;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        ++this.dpos;
    }

    @Override
    public void putInt8Array(byte[] byArray) {
        int n = byArray.length;
        if (this.hasWriteable) {
            try {
                System.arraycopy((Object)byArray, 0, (Object)this.ddata, this.dpos, n);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += n;
    }

    @Override
    public void putUInt16(int n) {
        if (this.hasWriteable) {
            try {
                if (n < 0 || n > -65536) {
                    throw new Exception(new StringBuffer().append("Can't serialize unsigned short value: int=").append(n).toString());
                }
                this.intSer.storeShort((short)n, this.ddata, this.dpos);
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        }
        this.dpos += 2;
    }

    @Override
    public void putUInt16Array(int[] nArray) {
        int n = nArray.length;
        int n2 = n << 1;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    if (nArray[i2] >= 0 && nArray[i2] <= -65536) {
                        this.intSer.storeShort((short)nArray[i2], this.ddata, this.dpos);
                        this.dpos += 2;
                        continue;
                    }
                    throw new Exception(new StringBuffer().append("Can't serialize unsigned short value: int=").append(nArray[i2]).toString());
                }
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    @Override
    public void putUInt32(long l) {
        if (this.hasWriteable) {
            try {
                if (l < 0L || l > 0) {
                    throw new Exception(new StringBuffer().append("Can't serialize unsigned int value: long=").append(l).toString());
                }
                this.intSer.storeInt((int)l, this.ddata, this.dpos);
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        }
        this.dpos += 4;
    }

    @Override
    public void putUInt32Array(long[] lArray) {
        int n = lArray.length;
        int n2 = n << 2;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    if (lArray[i2] >= 0L && lArray[i2] <= 0) {
                        this.intSer.storeInt((int)lArray[i2], this.ddata, this.dpos);
                        this.dpos += 4;
                        continue;
                    }
                    throw new Exception(new StringBuffer().append("Can't serialize unsigned int value: long=").append(lArray[i2]).toString());
                }
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    @Override
    public void putUInt64(long l) {
        this.putInt64(l);
    }

    @Override
    public void putUInt64Array(long[] lArray) {
        this.putInt64Array(lArray);
    }

    @Override
    public void putUInt8(short s) {
        if (this.hasWriteable) {
            try {
                if (s < 0 || s > 255) {
                    throw new Exception(new StringBuffer().append("Can't serialize unsigned byte value: short=").append(s).toString());
                }
                this.ddata[this.dpos] = (byte)s;
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        }
        ++this.dpos;
    }

    @Override
    public void putUInt8Array(short[] sArray) {
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < sArray.length; ++i2) {
                    if (sArray[i2] >= 0 || sArray[i2] <= 255) {
                        this.ddata[this.dpos] = (byte)sArray[i2];
                        ++this.dpos;
                        continue;
                    }
                    throw new Exception(new StringBuffer().append("Can't serialize unsigned byte value: short=").append(sArray[i2]).toString());
                }
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        } else {
            this.dpos += sArray.length;
        }
    }

    @Override
    public void putRawBytes(byte[] byArray) {
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < byArray.length; ++i2) {
                    this.ddata[this.dpos] = byArray[i2];
                    ++this.dpos;
                }
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        } else {
            this.dpos += byArray.length;
        }
    }

    @Override
    public String getDescription() {
        return this.intSer.getDescription();
    }

    @Override
    public byte getId() {
        return this.id;
    }

    @Override
    public IStreamSerializer createCompatibleStreamSerializer() {
        return new DefaultSerializerBase(this.intSer.createCompatibleSerializer(), this.id);
    }

    @Override
    public IStreamDeserializer createCompatibleStreamDeserializer() {
        return new DefaultDeserializerBase(this.intSer.createCompatibleDeserializer(), this.id);
    }
}

