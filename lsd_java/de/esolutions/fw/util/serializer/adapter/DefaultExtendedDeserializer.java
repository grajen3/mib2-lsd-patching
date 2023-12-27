/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.serializer.IDeserializable;
import de.esolutions.fw.util.serializer.IDeserializableArrayFactory;
import de.esolutions.fw.util.serializer.IDeserializableFactory;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedSerializer;
import de.esolutions.fw.util.serializer.adapter.StreamDeserializerProxy;
import de.esolutions.fw.util.serializer.adapter.StringEncodings;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Vector;

public class DefaultExtendedDeserializer
extends StreamDeserializerProxy
implements IDeserializer {
    public DefaultExtendedDeserializer(IStreamDeserializer iStreamDeserializer) {
        super(iStreamDeserializer);
        this.deserializer = iStreamDeserializer;
    }

    @Override
    public Object clone() {
        return new DefaultExtendedDeserializer((IStreamDeserializer)this.deserializer.clone());
    }

    @Override
    public String getString() {
        byte by = this.deserializer.getInt8();
        if (by < 0 || by >= 3) {
            throw new SerializerException("Invalid String Encoding");
        }
        int n = this.deserializer.getUInt16();
        if (n < 0 || n > Short.MAX_VALUE) {
            throw new SerializerException(new StringBuffer().append("String has invalid length: ").append(n).toString());
        }
        int n2 = n * StringEncodings.byteWidth[by];
        byte[] byArray = new byte[n2];
        this.deserializer.getInt8Array(byArray);
        try {
            StringConverter stringConverter = StringEncodings.getConverter(by);
            if (stringConverter == null) {
                throw new SerializerException("No converter found");
            }
            return stringConverter.getString(byArray);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new SerializerException("Unsupported Encoding");
        }
    }

    @Override
    public String getOptionalString() {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            return this.getString();
        }
        return null;
    }

    public String[] getStringVarArray() {
        int n = this.deserializer.getInt32();
        String[] stringArray = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            boolean bl = this.getOptionalFlag();
            if (!bl) continue;
            stringArray[i2] = this.getString();
        }
        return stringArray;
    }

    @Override
    public String[] getOptionalStringVarArray() {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            return this.getStringVarArray();
        }
        return null;
    }

    @Override
    public int getEnum() {
        return this.deserializer.getInt32();
    }

    public boolean getOptionalFlag() {
        return this.deserializer.getInt8() == 0;
    }

    @Override
    public IDeserializable getObject(IDeserializableFactory iDeserializableFactory) {
        IDeserializable iDeserializable = iDeserializableFactory.createDeserializable(this);
        return iDeserializable;
    }

    @Override
    public IDeserializable getOptionalObject(IDeserializableFactory iDeserializableFactory) {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            IDeserializable iDeserializable = iDeserializableFactory.createDeserializable(this);
            return iDeserializable;
        }
        return null;
    }

    @Override
    public void getObjectArray(IDeserializableFactory iDeserializableFactory, IDeserializable[] iDeserializableArray) {
        for (int i2 = 0; i2 < iDeserializableArray.length; ++i2) {
            IDeserializable iDeserializable;
            boolean bl = this.getOptionalFlag();
            if (!bl) continue;
            iDeserializableArray[i2] = iDeserializable = iDeserializableFactory.createDeserializable(this);
        }
    }

    @Override
    public IDeserializable[] getOptionalObjectArray(IDeserializableArrayFactory iDeserializableArrayFactory, int n) {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            IDeserializable[] iDeserializableArray = iDeserializableArrayFactory.createDeserializableArray(n);
            for (int i2 = 0; i2 < n; ++i2) {
                IDeserializable iDeserializable;
                boolean bl2 = this.getOptionalFlag();
                if (!bl2) continue;
                iDeserializableArray[i2] = iDeserializable = iDeserializableArrayFactory.createDeserializable(this);
            }
            return iDeserializableArray;
        }
        return null;
    }

    @Override
    public IDeserializable[] getObjectVarArray(IDeserializableArrayFactory iDeserializableArrayFactory) {
        int n = this.deserializer.getInt32();
        IDeserializable[] iDeserializableArray = iDeserializableArrayFactory.createDeserializableArray(n);
        for (int i2 = 0; i2 < n; ++i2) {
            IDeserializable iDeserializable;
            boolean bl = this.getOptionalFlag();
            if (!bl) continue;
            iDeserializableArray[i2] = iDeserializable = iDeserializableArrayFactory.createDeserializable(this);
        }
        return iDeserializableArray;
    }

    @Override
    public IDeserializable[] getOptionalObjectVarArray(IDeserializableArrayFactory iDeserializableArrayFactory) {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            int n = this.deserializer.getInt32();
            IDeserializable[] iDeserializableArray = iDeserializableArrayFactory.createDeserializableArray(n);
            for (int i2 = 0; i2 < n; ++i2) {
                IDeserializable iDeserializable;
                boolean bl2 = this.getOptionalFlag();
                if (!bl2) continue;
                iDeserializableArray[i2] = iDeserializable = iDeserializableArrayFactory.createDeserializable(this);
            }
            return iDeserializableArray;
        }
        return null;
    }

    @Override
    public List getObjectVarList(IDeserializableFactory iDeserializableFactory) {
        int n = this.deserializer.getInt32();
        Vector vector = new Vector(n);
        for (int i2 = 0; i2 < n; ++i2) {
            boolean bl = this.getOptionalFlag();
            if (!bl) continue;
            IDeserializable iDeserializable = iDeserializableFactory.createDeserializable(this);
            vector.add(iDeserializable);
        }
        return vector;
    }

    @Override
    public List getOptionalObjectVarList(IDeserializableFactory iDeserializableFactory) {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            int n = this.deserializer.getInt32();
            Vector vector = new Vector(n);
            for (int i2 = 0; i2 < n; ++i2) {
                boolean bl2 = this.getOptionalFlag();
                if (!bl2) continue;
                IDeserializable iDeserializable = iDeserializableFactory.createDeserializable(this);
                vector.add(iDeserializable);
            }
            return vector;
        }
        return null;
    }

    @Override
    public boolean[] getBoolVarArray() {
        long l = this.deserializer.getUInt32();
        boolean[] blArray = new boolean[(int)l];
        this.getBoolArray(blArray);
        return blArray;
    }

    @Override
    public short[] getUInt8VarArray() {
        long l = this.deserializer.getUInt32();
        short[] sArray = new short[(int)l];
        this.getUInt8Array(sArray);
        return sArray;
    }

    @Override
    public byte[] getInt8VarArray() {
        long l = this.deserializer.getUInt32();
        byte[] byArray = new byte[(int)l];
        this.getInt8Array(byArray);
        return byArray;
    }

    @Override
    public int[] getUInt16VarArray() {
        long l = this.deserializer.getUInt32();
        int[] nArray = new int[(int)l];
        this.getUInt16Array(nArray);
        return nArray;
    }

    @Override
    public short[] getInt16VarArray() {
        long l = this.deserializer.getUInt32();
        short[] sArray = new short[(int)l];
        this.getInt16Array(sArray);
        return sArray;
    }

    @Override
    public char[] getUChar16VarArray() {
        long l = this.deserializer.getUInt32();
        char[] cArray = new char[(int)l];
        this.getUChar16Array(cArray);
        return cArray;
    }

    @Override
    public long[] getUInt32VarArray() {
        long l = this.deserializer.getUInt32();
        long[] lArray = new long[(int)l];
        this.getUInt32Array(lArray);
        return lArray;
    }

    @Override
    public int[] getInt32VarArray() {
        long l = this.deserializer.getUInt32();
        int[] nArray = new int[(int)l];
        this.getInt32Array(nArray);
        return nArray;
    }

    @Override
    public long[] getUInt64VarArray() {
        long l = this.deserializer.getUInt32();
        long[] lArray = new long[(int)l];
        this.getUInt64Array(lArray);
        return lArray;
    }

    @Override
    public long[] getInt64VarArray() {
        long l = this.deserializer.getUInt32();
        long[] lArray = new long[(int)l];
        this.getInt64Array(lArray);
        return lArray;
    }

    @Override
    public float[] getFloatVarArray() {
        long l = this.deserializer.getUInt32();
        float[] fArray = new float[(int)l];
        this.getFloatArray(fArray);
        return fArray;
    }

    @Override
    public double[] getDoubleVarArray() {
        long l = this.deserializer.getUInt32();
        double[] dArray = new double[(int)l];
        this.getDoubleArray(dArray);
        return dArray;
    }

    @Override
    public boolean[] getOptionalBoolVarArray() {
        boolean[] blArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            blArray = this.getBoolVarArray();
        }
        return blArray;
    }

    @Override
    public double[] getOptionalDoubleVarArray() {
        double[] dArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            dArray = this.getDoubleVarArray();
        }
        return dArray;
    }

    @Override
    public float[] getOptionalFloatVarArray() {
        float[] fArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            fArray = this.getFloatVarArray();
        }
        return fArray;
    }

    @Override
    public short[] getOptionalInt16VarArray() {
        short[] sArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            sArray = this.getInt16VarArray();
        }
        return sArray;
    }

    @Override
    public char[] getOptionalUChar16VarArray() {
        char[] cArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            cArray = this.getUChar16VarArray();
        }
        return cArray;
    }

    @Override
    public int[] getOptionalInt32VarArray() {
        int[] nArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            nArray = this.getInt32VarArray();
        }
        return nArray;
    }

    @Override
    public long[] getOptionalInt64VarArray() {
        long[] lArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            lArray = this.getInt64VarArray();
        }
        return lArray;
    }

    @Override
    public byte[] getOptionalInt8VarArray() {
        byte[] byArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            byArray = this.getInt8VarArray();
        }
        return byArray;
    }

    @Override
    public int[] getOptionalUInt16VarArray() {
        int[] nArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            nArray = this.getUInt16VarArray();
        }
        return nArray;
    }

    @Override
    public long[] getOptionalUInt32VarArray() {
        long[] lArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            lArray = this.getUInt32VarArray();
        }
        return lArray;
    }

    @Override
    public long[] getOptionalUInt64VarArray() {
        long[] lArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            lArray = this.getUInt64VarArray();
        }
        return lArray;
    }

    @Override
    public short[] getOptionalUInt8VarArray() {
        short[] sArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            sArray = this.getUInt8VarArray();
        }
        return sArray;
    }

    @Override
    public int[] getOptionalEnumVarArray() {
        int[] nArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            nArray = this.getInt32VarArray();
        }
        return nArray;
    }

    @Override
    public ISerializer createCompatibleSerializer() {
        return new DefaultExtendedSerializer(this.deserializer.createCompatibleStreamSerializer());
    }

    @Override
    public IDeserializer createCompatibleDeserializer() {
        return new DefaultExtendedDeserializer(this.deserializer.createCompatibleStreamDeserializer());
    }
}

