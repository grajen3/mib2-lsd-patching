/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import java.io.UnsupportedEncodingException;

public class CommStringTool {
    public static void serializeCommString(String string, ISerializer iSerializer) {
        try {
            byte[] byArray = new byte[]{0};
            if (string == null) {
                iSerializer.putUInt16(0);
                iSerializer.putRawBytes(byArray);
            } else {
                byte[] byArray2 = StringConverter.UTF8.getBytes(string);
                int n = byArray2.length;
                iSerializer.putUInt16(n);
                iSerializer.putRawBytes(byArray2);
                iSerializer.putRawBytes(byArray);
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            SerializerException serializerException = new SerializerException("UnsupportedEncodingException");
            throw serializerException;
        }
    }

    public static String deserializeCommString(IDeserializer iDeserializer) {
        try {
            int n = iDeserializer.getUInt16();
            byte[] byArray = new byte[n];
            iDeserializer.getRawBytes(byArray);
            byte[] byArray2 = new byte[1];
            iDeserializer.getRawBytes(byArray2);
            String string = StringConverter.UTF8.getString(byArray);
            return string;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            SerializerException serializerException = new SerializerException("UnsupportedEncodingException");
            throw serializerException;
        }
    }
}

