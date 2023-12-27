/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedDeserializer;
import de.esolutions.fw.util.serializer.adapter.StreamSerializerProxy;
import de.esolutions.fw.util.serializer.adapter.StringEncodings;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ListIterator;

public class DefaultExtendedSerializer
extends StreamSerializerProxy
implements ISerializer {
    protected int stringEncoding;

    public DefaultExtendedSerializer(IStreamSerializer iStreamSerializer) {
        super(iStreamSerializer);
        this.stringEncoding = 0;
    }

    public DefaultExtendedSerializer(IStreamSerializer iStreamSerializer, int n) {
        super(iStreamSerializer);
        this.stringEncoding = n;
    }

    public void setStringEncoding(int n) {
        if (n >= 0 && n < 3) {
            this.stringEncoding = n;
        }
    }

    public int stringEncoding() {
        return this.stringEncoding;
    }

    public void putOptionalFlag(boolean bl) {
        this.serializer.putInt8(bl ? (byte)0 : -1);
    }

    @Override
    public void putString(String string) {
        try {
            StringConverter stringConverter = StringEncodings.getConverter(this.stringEncoding);
            if (stringConverter == null) {
                throw new SerializerException("No converter found");
            }
            byte[] byArray = stringConverter.getBytes(string);
            int n = byArray.length / StringEncodings.byteWidth[this.stringEncoding];
            if (n > Short.MAX_VALUE) {
                throw new SerializerException(new StringBuffer().append("String too long: ").append(n).toString());
            }
            this.serializer.putInt8((byte)this.stringEncoding);
            this.serializer.putInt16((short)n);
            this.serializer.putInt8Array(byArray);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new SerializerException("Invalid String Type");
        }
    }

    @Override
    public void putOptionalString(String string) {
        this.putOptionalFlag(string != null);
        if (string != null) {
            this.putString(string);
        }
    }

    @Override
    public void putOptionalStringVarArray(String[] stringArray) {
        this.putOptionalFlag(stringArray != null);
        if (stringArray != null) {
            this.serializer.putInt32(stringArray.length);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.putOptionalString(stringArray[i2]);
            }
        }
    }

    @Override
    public void putEnum(int n) {
        this.serializer.putInt32(n);
    }

    @Override
    public void putObject(ISerializable iSerializable) {
        iSerializable.serialize(this);
    }

    @Override
    public void putOptionalObject(ISerializable iSerializable) {
        this.putOptionalFlag(iSerializable != null);
        if (iSerializable != null) {
            iSerializable.serialize(this);
        }
    }

    @Override
    public void putObjectArray(ISerializable[] iSerializableArray) {
        for (int i2 = 0; i2 < iSerializableArray.length; ++i2) {
            ISerializable iSerializable = iSerializableArray[i2];
            this.putOptionalFlag(iSerializable != null);
            if (iSerializable == null) continue;
            iSerializable.serialize(this);
        }
    }

    @Override
    public void putOptionalObjectArray(ISerializable[] iSerializableArray) {
        this.putOptionalFlag(iSerializableArray != null);
        if (iSerializableArray != null) {
            for (int i2 = 0; i2 < iSerializableArray.length; ++i2) {
                ISerializable iSerializable = iSerializableArray[i2];
                this.putOptionalFlag(iSerializable != null);
                if (iSerializable == null) continue;
                iSerializable.serialize(this);
            }
        }
    }

    @Override
    public void putObjectVarArray(ISerializable[] iSerializableArray) {
        this.serializer.putInt32(iSerializableArray.length);
        for (int i2 = 0; i2 < iSerializableArray.length; ++i2) {
            ISerializable iSerializable = iSerializableArray[i2];
            this.putOptionalFlag(iSerializable != null);
            if (iSerializable == null) continue;
            iSerializable.serialize(this);
        }
    }

    @Override
    public void putOptionalObjectVarArray(ISerializable[] iSerializableArray) {
        this.putOptionalFlag(iSerializableArray != null);
        if (iSerializableArray != null) {
            this.serializer.putInt32(iSerializableArray.length);
            for (int i2 = 0; i2 < iSerializableArray.length; ++i2) {
                ISerializable iSerializable = iSerializableArray[i2];
                this.putOptionalFlag(iSerializable != null);
                if (iSerializable == null) continue;
                iSerializable.serialize(this);
            }
        }
    }

    @Override
    public void putList(List list) {
        this.serializer.putInt32(list.size());
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ISerializable iSerializable = (ISerializable)listIterator.next();
            this.putOptionalFlag(iSerializable != null);
            if (iSerializable == null) continue;
            iSerializable.serialize(this);
        }
    }

    @Override
    public void putOptionalList(List list) {
        this.putOptionalFlag(list != null);
        if (list != null) {
            this.serializer.putInt32(list.size());
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                ISerializable iSerializable = (ISerializable)listIterator.next();
                this.putOptionalFlag(iSerializable != null);
                if (iSerializable == null) continue;
                iSerializable.serialize(this);
            }
        }
    }

    @Override
    public void putStringArray(String[] stringArray) {
        this.serializer.putUInt32(stringArray.length);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.putString(stringArray[i2]);
        }
    }

    @Override
    public void putBoolVarArray(boolean[] blArray) {
        this.serializer.putUInt32(blArray.length);
        this.serializer.putBoolArray(blArray);
    }

    @Override
    public void putUInt8VarArray(short[] sArray) {
        this.serializer.putUInt32(sArray.length);
        this.serializer.putUInt8Array(sArray);
    }

    @Override
    public void putInt8VarArray(byte[] byArray) {
        this.serializer.putUInt32(byArray.length);
        this.serializer.putInt8Array(byArray);
    }

    @Override
    public void putUInt16VarArray(int[] nArray) {
        this.serializer.putUInt32(nArray.length);
        this.serializer.putUInt16Array(nArray);
    }

    @Override
    public void putInt16VarArray(short[] sArray) {
        this.serializer.putUInt32(sArray.length);
        this.serializer.putInt16Array(sArray);
    }

    @Override
    public void putUChar16VarArray(char[] cArray) {
        this.serializer.putUInt32(cArray.length);
        this.serializer.putUChar16Array(cArray);
    }

    @Override
    public void putUInt32VarArray(long[] lArray) {
        this.serializer.putUInt32(lArray.length);
        this.serializer.putUInt32Array(lArray);
    }

    @Override
    public void putInt32VarArray(int[] nArray) {
        this.serializer.putUInt32(nArray.length);
        this.serializer.putInt32Array(nArray);
    }

    @Override
    public void putUInt64VarArray(long[] lArray) {
        this.serializer.putUInt32(lArray.length);
        this.serializer.putUInt64Array(lArray);
    }

    @Override
    public void putInt64VarArray(long[] lArray) {
        this.serializer.putUInt32(lArray.length);
        this.serializer.putInt64Array(lArray);
    }

    @Override
    public void putFloatVarArray(float[] fArray) {
        this.serializer.putUInt32(fArray.length);
        this.serializer.putFloatArray(fArray);
    }

    @Override
    public void putDoubleVarArray(double[] dArray) {
        this.serializer.putUInt32(dArray.length);
        this.serializer.putDoubleArray(dArray);
    }

    @Override
    public void putOptionalBoolVarArray(boolean[] blArray) {
        boolean bl = blArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putBoolVarArray(blArray);
        }
    }

    @Override
    public void putOptionalDoubleVarArray(double[] dArray) {
        boolean bl = dArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putDoubleVarArray(dArray);
        }
    }

    @Override
    public void putOptionalFloatVarArray(float[] fArray) {
        boolean bl = fArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putFloatVarArray(fArray);
        }
    }

    @Override
    public void putOptionalInt16VarArray(short[] sArray) {
        boolean bl = sArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt16VarArray(sArray);
        }
    }

    @Override
    public void putOptionalUChar16VarArray(char[] cArray) {
        boolean bl = cArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUChar16VarArray(cArray);
        }
    }

    @Override
    public void putOptionalInt32VarArray(int[] nArray) {
        boolean bl = nArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt32VarArray(nArray);
        }
    }

    @Override
    public void putOptionalInt64VarArray(long[] lArray) {
        boolean bl = lArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt64VarArray(lArray);
        }
    }

    @Override
    public void putOptionalInt8VarArray(byte[] byArray) {
        boolean bl = byArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt8VarArray(byArray);
        }
    }

    @Override
    public void putOptionalUInt16VarArray(int[] nArray) {
        boolean bl = nArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUInt16VarArray(nArray);
        }
    }

    @Override
    public void putOptionalUInt32VarArray(long[] lArray) {
        boolean bl = lArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUInt32VarArray(lArray);
        }
    }

    @Override
    public void putOptionalUInt64VarArray(long[] lArray) {
        boolean bl = lArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUInt64VarArray(lArray);
        }
    }

    @Override
    public void putOptionalUInt8VarArray(short[] sArray) {
        boolean bl = sArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUInt8VarArray(sArray);
        }
    }

    @Override
    public void putOptionalEnumVarArray(int[] nArray) {
        boolean bl = nArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt32VarArray(nArray);
        }
    }

    @Override
    public ISerializer createCompatibleSerializer() {
        return new DefaultExtendedSerializer(this.serializer.createCompatibleStreamSerializer());
    }

    @Override
    public IDeserializer createCompatibleDeserializer() {
        return new DefaultExtendedDeserializer(this.serializer.createCompatibleStreamDeserializer());
    }
}

