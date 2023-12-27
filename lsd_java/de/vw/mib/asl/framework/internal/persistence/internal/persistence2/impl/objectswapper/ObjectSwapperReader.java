/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.objectswapper;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.objectswapper.AbstractObjectSwapper;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.objectswapper.LittleEndianDataInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ObjectSwapperReader
extends AbstractObjectSwapper {
    private LittleEndianDataInputStream stream;

    public void open(File file) {
        this.open(new BufferedInputStream(new FileInputStream(file)));
    }

    public void open(InputStream inputStream) {
        if (this.stream != null) {
            throw new IllegalStateException("Already opened");
        }
        this.stream = new LittleEndianDataInputStream(inputStream);
    }

    public Object[] linkAll() {
        Object[] objectArray = null;
        if (this.stream != null) {
            try {
                objectArray = this.linkObjects();
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
        return objectArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() {
        if (this.stream != null) {
            try {
                this.stream.close();
            }
            catch (IOException iOException) {
            }
            finally {
                this.stream = null;
            }
        } else {
            throw new IllegalStateException("Not opened");
        }
    }

    private Object[] linkObjects() {
        int n = this.readInt();
        Object[] objectArray = new Object[n];
        for (int i2 = 0; i2 < n; ++i2) {
            objectArray[i2] = this.linkObject();
        }
        return objectArray;
    }

    private Object linkObject() {
        Object object = null;
        int n = this.readInt();
        if (n == 0) {
            object = this.readString();
        } else if (n == 9) {
            this.readInt();
        } else {
            int n2 = this.readInt();
            object = this.linkArray(n, n2);
        }
        return object;
    }

    private Object linkArray(int n, int n2) {
        switch (n) {
            case 1: {
                return this.readStringArray(n2);
            }
            case 2: {
                return this.readByteArray(n2);
            }
            case 3: {
                return this.readCharArray(n2);
            }
            case 4: {
                return this.readShortArray(n2);
            }
            case 5: {
                return this.readIntegerArray(n2);
            }
            case 6: {
                return this.readLongArray(n2);
            }
            case 7: {
                return this.readFloatArray(n2);
            }
            case 8: {
                return this.readDoubleArray(n2);
            }
        }
        throw new UnsupportedOperationException(new StringBuffer().append("Unsupported type ").append(n).toString());
    }

    private String[] readStringArray(int n) {
        String[] stringArray = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = this.readInt();
            if (n2 == 0) {
                stringArray[i2] = this.readString();
                continue;
            }
            this.readInt();
            stringArray[i2] = null;
        }
        return stringArray;
    }

    private byte[] readByteArray(int n) {
        byte[] byArray = new byte[n];
        this.stream.readFully(byArray);
        return byArray;
    }

    private char[] readCharArray(int n) {
        char[] cArray = new char[n];
        for (int i2 = 0; i2 < n; ++i2) {
            cArray[i2] = this.readChar();
        }
        return cArray;
    }

    private short[] readShortArray(int n) {
        short[] sArray = new short[n];
        for (int i2 = 0; i2 < n; ++i2) {
            sArray[i2] = this.readShort();
        }
        return sArray;
    }

    private int[] readIntegerArray(int n) {
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = this.readInt();
        }
        return nArray;
    }

    private long[] readLongArray(int n) {
        long[] lArray = new long[n];
        for (int i2 = 0; i2 < n; ++i2) {
            lArray[i2] = this.readLong();
        }
        return lArray;
    }

    private float[] readFloatArray(int n) {
        float[] fArray = new float[n];
        for (int i2 = 0; i2 < n; ++i2) {
            fArray[i2] = this.readFloat();
        }
        return fArray;
    }

    private double[] readDoubleArray(int n) {
        double[] dArray = new double[n];
        for (int i2 = 0; i2 < n; ++i2) {
            dArray[i2] = this.readDouble();
        }
        return dArray;
    }

    private String readString() {
        int n = this.readInt();
        return this.readString(n);
    }

    private String readString(int n) {
        char[] cArray = new char[n];
        for (int i2 = 0; i2 < n; ++i2) {
            cArray[i2] = this.readChar();
        }
        return new String(cArray);
    }

    private char readChar() {
        return this.stream.readChar();
    }

    private short readShort() {
        return this.stream.readShort();
    }

    private int readInt() {
        return this.stream.readInt();
    }

    private long readLong() {
        int n = this.readInt();
        int n2 = this.readInt();
        return (long)n2 << 32 | (long)n & 0;
    }

    private float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    private double readDouble() {
        return Double.longBitsToDouble((long)this.readLong());
    }
}

