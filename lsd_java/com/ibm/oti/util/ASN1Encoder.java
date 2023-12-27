/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.ASN1Decoder$BMPString;
import com.ibm.oti.util.ASN1Decoder$BitString;
import com.ibm.oti.util.ASN1Decoder$CertificateSet;
import com.ibm.oti.util.ASN1Decoder$Data;
import com.ibm.oti.util.ASN1Decoder$Explicit;
import com.ibm.oti.util.ASN1Decoder$GeneralizedTime;
import com.ibm.oti.util.ASN1Decoder$ImplicitSet;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Decoder$Set;
import com.ibm.oti.util.ASN1Decoder$Set2;
import com.ibm.oti.util.ASN1Decoder$UTCTime;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ASN1Encoder {
    private OutputStream output;

    public ASN1Encoder(OutputStream outputStream) {
        this.output = outputStream;
    }

    public static byte[] getEncoding(Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
        try {
            aSN1Encoder.writeObject(object);
        }
        catch (ASN1Exception aSN1Exception) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void writeByte(int n, OutputStream outputStream) {
        try {
            outputStream.write(n);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    private static void writeBytes(byte[] byArray, OutputStream outputStream) {
        try {
            outputStream.write(byArray);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    private static void writeTagNumber(int n, OutputStream outputStream) {
        if (n == 16 || n == 17) {
            n |= 0x20;
        }
        ASN1Encoder.writeByte(n, outputStream);
    }

    protected void writeTagNumber(int n) {
        ASN1Encoder.writeTagNumber(n, this.output);
    }

    private static void writeInteger(BigInteger bigInteger, OutputStream outputStream) {
        byte[] byArray = bigInteger.toByteArray();
        ASN1Encoder.writeTagNumber(2, outputStream);
        ASN1Encoder.writeLength(byArray.length, outputStream);
        ASN1Encoder.writeBytes(byArray, outputStream);
    }

    private static void writeOctetString(byte[] byArray, OutputStream outputStream) {
        ASN1Encoder.writeTagNumber(4, outputStream);
        ASN1Encoder.writeLength(byArray.length, outputStream);
        ASN1Encoder.writeBytes(byArray, outputStream);
    }

    protected void writeOctetString(byte[] byArray) {
        ASN1Encoder.writeOctetString(byArray, this.output);
    }

    private static void writeBitString(ASN1Decoder$BitString aSN1Decoder$BitString, OutputStream outputStream) {
        ASN1Encoder.writeTagNumber(3, outputStream);
        ASN1Encoder.writeLength(aSN1Decoder$BitString.data.length + 1, outputStream);
        ASN1Encoder.writeByte(aSN1Decoder$BitString.unusedBits, outputStream);
        ASN1Encoder.writeBytes(aSN1Decoder$BitString.data, outputStream);
    }

    protected void writeBitString(ASN1Decoder$BitString aSN1Decoder$BitString) {
        ASN1Encoder.writeBitString(aSN1Decoder$BitString, this.output);
    }

    private static void writeObjectIdentifier(int[] nArray, OutputStream outputStream) {
        int n = 0;
        while (n < nArray.length) {
            if (nArray[n] < 0) {
                throw new ASN1Exception();
            }
            ++n;
        }
        if (nArray.length < 2) {
            throw new ASN1Exception();
        }
        if (nArray[1] > 39) {
            throw new ASN1Exception();
        }
        n = (short)(nArray[0] * 40 + nArray[1]);
        if (n > 255 || n < 0) {
            throw new ASN1Exception();
        }
        short[] sArray = new short[nArray.length * 5];
        int n2 = 0;
        int n3 = nArray.length - 1;
        while (n3 > 1) {
            int n4 = nArray[n3];
            sArray[n2++] = (short)(n4 & 0x7F);
            n4 /= 128;
            while (n4 > 0) {
                sArray[n2++] = (short)((n4 & 0x7F) + 128);
                n4 /= 128;
            }
            --n3;
        }
        sArray[n2] = n;
        ASN1Encoder.writeTagNumber(6, outputStream);
        ASN1Encoder.writeLength(n2 + 1, outputStream);
        while (n2 >= 0) {
            ASN1Encoder.writeByte(sArray[n2--], outputStream);
        }
    }

    protected void writeObjectIdentifier(int[] nArray) {
        ASN1Encoder.writeObjectIdentifier(nArray, this.output);
    }

    private static void writeLength(int n, OutputStream outputStream) {
        if (n < 128) {
            ASN1Encoder.writeByte(n, outputStream);
            return;
        }
        short[] sArray = new short[5];
        int n2 = 0;
        while (n > 0) {
            sArray[n2++] = (short)(n & 0xFF);
            n >>>= 8;
        }
        ASN1Encoder.writeByte(n2 | 0x80, outputStream);
        while (--n2 >= 0) {
            ASN1Encoder.writeByte(sArray[n2], outputStream);
        }
    }

    protected void writeLength(int n) {
        ASN1Encoder.writeLength(n, this.output);
    }

    protected void writeInteger(BigInteger bigInteger) {
        ASN1Encoder.writeInteger(bigInteger, this.output);
    }

    public void writeIntegers(BigInteger[] bigIntegerArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        int n = 0;
        while (n < bigIntegerArray.length) {
            ASN1Encoder.writeInteger(bigIntegerArray[n], byteArrayOutputStream);
            ++n;
        }
        ASN1Encoder.writeTagNumber(16, this.output);
        ASN1Encoder.writeLength(byteArrayOutputStream.size(), this.output);
        try {
            byteArrayOutputStream.writeTo(this.output);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    protected void writeSequence(Object[] objectArray) {
        ASN1Encoder.writeSequence(objectArray, this.output);
    }

    private static void writeSequence(Object[] objectArray, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0;
        while (n < objectArray.length) {
            ASN1Encoder.writeObject(objectArray[n], byteArrayOutputStream);
            ++n;
        }
        ASN1Encoder.writeTagNumber(16, outputStream);
        ASN1Encoder.writeLength(byteArrayOutputStream.size(), outputStream);
        try {
            byteArrayOutputStream.writeTo(outputStream);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    public void writeObject(Object object) {
        ASN1Encoder.writeObject(object, this.output);
    }

    private static void writeObject(Object object, OutputStream outputStream) {
        if (object == null) {
            ASN1Encoder.writeTagNumber(5, outputStream);
            ASN1Encoder.writeLength(0, outputStream);
            return;
        }
        if (object instanceof BigInteger) {
            ASN1Encoder.writeInteger((BigInteger)object, outputStream);
            return;
        }
        if (object instanceof byte[]) {
            ASN1Encoder.writeOctetString((byte[])object, outputStream);
            return;
        }
        if (object instanceof int[]) {
            ASN1Encoder.writeObjectIdentifier((int[])object, outputStream);
            return;
        }
        if (object instanceof Object[]) {
            ASN1Encoder.writeSequence((Object[])object, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$BitString) {
            ASN1Encoder.writeBitString((ASN1Decoder$BitString)object, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$UTCTime) {
            ASN1Encoder.writeUTCTime(((ASN1Decoder$UTCTime)object).utcTime, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$GeneralizedTime) {
            ASN1Encoder.writeGeneralizedTime(((ASN1Decoder$GeneralizedTime)object).generalizedTime, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$Set) {
            ASN1Encoder.writeSet(((ASN1Decoder$Set)object).sequence, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$Set2) {
            ASN1Encoder.writeSet2(((ASN1Decoder$Set2)object).sequence, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$CertificateSet) {
            ASN1Encoder.writeCertificateSet(((ASN1Decoder$CertificateSet)object).sequence, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$Explicit) {
            ASN1Encoder.writeExplicit(((ASN1Decoder$Explicit)object).type, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$BMPString) {
            ASN1Encoder.writeBMPString(((ASN1Decoder$BMPString)object).bmpString, outputStream);
            return;
        }
        if (object instanceof String) {
            ASN1Encoder.writeUTF8String((String)object, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$Data) {
            ASN1Encoder.writeBytes(((ASN1Decoder$Data)object).data, outputStream);
            return;
        }
        if (object instanceof ASN1Decoder$ImplicitSet) {
            ASN1Encoder.writeImplicitSet(((ASN1Decoder$ImplicitSet)object).set, outputStream, ((ASN1Decoder$ImplicitSet)object).tag);
            return;
        }
        ASN1Encoder.writeObjectTypeExtensions(object, outputStream);
        throw new ASN1Exception();
    }

    private static StringBuffer getDateString(int[] nArray, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        if (n > 4) {
            stringBuffer.append(nArray[0]);
        } else {
            if (nArray[0] < 10) {
                stringBuffer.append("0");
            }
            stringBuffer.append(nArray[0]);
        }
        int n2 = 1;
        while (n2 < nArray.length) {
            if (nArray[n2] < 10) {
                stringBuffer.append("0");
            }
            stringBuffer.append(nArray[n2]);
            ++n2;
        }
        return stringBuffer;
    }

    private static void writeGeneralizedTime(Date date, OutputStream outputStream) {
        int[] nArray = new int[6];
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.setTime(date);
        nArray[0] = calendar.get(1);
        nArray[1] = calendar.get(2);
        nArray[2] = calendar.get(5);
        nArray[3] = calendar.get(2);
        nArray[4] = calendar.get(12);
        nArray[5] = calendar.get(13);
        StringBuffer stringBuffer = ASN1Encoder.getDateString(nArray, 4);
        String string = "Z";
        stringBuffer.append(string);
        ASN1Encoder.writeTagNumber(24, outputStream);
        try {
            byte[] byArray = stringBuffer.toString().getBytes("ISO8859_1");
            ASN1Encoder.writeLength(byArray.length, outputStream);
            ASN1Encoder.writeBytes(byArray, outputStream);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.getMessage());
        }
    }

    protected void writeGeneralizedTime(Date date) {
        ASN1Encoder.writeGeneralizedTime(date, this.output);
    }

    private static void writePrintableString(String string, OutputStream outputStream) {
        ASN1Encoder.writeTagNumber(19, outputStream);
        try {
            byte[] byArray = string.getBytes("ISO8859_1");
            ASN1Encoder.writeLength(byArray.length, outputStream);
            ASN1Encoder.writeBytes(byArray, outputStream);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.getMessage());
        }
    }

    protected void writePrintableString(String string) {
        ASN1Encoder.writePrintableString(string, this.output);
    }

    private static void writeUTF8String(String string, OutputStream outputStream) {
        ASN1Encoder.writeTagNumber(12, outputStream);
        try {
            byte[] byArray = string.getBytes("UTF8");
            ASN1Encoder.writeLength(byArray.length, outputStream);
            ASN1Encoder.writeBytes(byArray, outputStream);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.getMessage());
        }
    }

    protected void writeUTF8String(String string) {
        ASN1Encoder.writeUTF8String(string, this.output);
    }

    private static void writeSet(Object[] objectArray, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder.writeSequence(objectArray, byteArrayOutputStream);
        ASN1Encoder.writeTagNumber(17, outputStream);
        ASN1Encoder.writeLength(byteArrayOutputStream.size(), outputStream);
        try {
            byteArrayOutputStream.writeTo(outputStream);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    private static void writeCertificateSet(Object[] objectArray, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0;
        while (n < objectArray.length) {
            ASN1Encoder.writeObject(objectArray[n], byteArrayOutputStream);
            ++n;
        }
        ASN1Encoder.writeTagNumber(160, outputStream);
        ASN1Encoder.writeLength(byteArrayOutputStream.size(), outputStream);
        try {
            byteArrayOutputStream.writeTo(outputStream);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    private static void writeSet2Save(Object[] objectArray, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0;
        while (n < objectArray.length) {
            ASN1Encoder.writeObject(objectArray[n], byteArrayOutputStream);
            ++n;
        }
        ASN1Encoder.writeTagNumber(17, outputStream);
        ASN1Encoder.writeLength(byteArrayOutputStream.size(), outputStream);
        try {
            byteArrayOutputStream.writeTo(outputStream);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    private static void writeSet2(Object[] objectArray, OutputStream outputStream) {
        new ByteArrayOutputStream();
        Object[] objectArray2 = new Object[objectArray.length];
        int n = 0;
        int n2 = 0;
        while (n2 < objectArray.length) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1Encoder.writeObject(objectArray[n2], byteArrayOutputStream);
            objectArray2[n2] = byteArrayOutputStream.toByteArray();
            n += byteArrayOutputStream.size();
            ++n2;
        }
        Object[] objectArray3 = new Object[objectArray2.length];
        int n3 = 0;
        while (n3 < objectArray3.length) {
            byte[] byArray = null;
            int n4 = -1;
            int n5 = 0;
            while (n5 < objectArray2.length) {
                byte[] byArray2 = ASN1Encoder.getSmallestEncoding(byArray, (byte[])objectArray2[n5]);
                if (byArray2 != byArray) {
                    byArray = byArray2;
                    n4 = n5;
                }
                ++n5;
            }
            objectArray2[n4] = null;
            objectArray3[n3] = byArray;
            ++n3;
        }
        ASN1Encoder.writeTagNumber(17, outputStream);
        ASN1Encoder.writeLength(n, outputStream);
        n3 = 0;
        while (n3 < objectArray3.length) {
            try {
                outputStream.write((byte[])objectArray3[n3]);
            }
            catch (IOException iOException) {}
            ++n3;
        }
    }

    private static void writeImplicitSet(ASN1Decoder$Set2 aSN1Decoder$Set2, OutputStream outputStream, int n) {
        Object[] objectArray = aSN1Decoder$Set2.sequence;
        new ByteArrayOutputStream();
        Object[] objectArray2 = new Object[objectArray.length];
        int n2 = 0;
        int n3 = 0;
        while (n3 < objectArray.length) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1Encoder.writeObject(objectArray[n3], byteArrayOutputStream);
            objectArray2[n3] = byteArrayOutputStream.toByteArray();
            n2 += byteArrayOutputStream.size();
            ++n3;
        }
        Object[] objectArray3 = new Object[objectArray2.length];
        int n4 = 0;
        while (n4 < objectArray3.length) {
            byte[] byArray = null;
            int n5 = -1;
            int n6 = 0;
            while (n6 < objectArray2.length) {
                byte[] byArray2 = ASN1Encoder.getSmallestEncoding(byArray, (byte[])objectArray2[n6]);
                if (byArray2 != byArray) {
                    byArray = byArray2;
                    n5 = n6;
                }
                ++n6;
            }
            objectArray2[n5] = null;
            objectArray3[n4] = byArray;
            ++n4;
        }
        ASN1Encoder.writeTagNumber(160 + n, outputStream);
        ASN1Encoder.writeLength(n2, outputStream);
        n4 = 0;
        while (n4 < objectArray3.length) {
            try {
                outputStream.write((byte[])objectArray3[n4]);
            }
            catch (IOException iOException) {}
            ++n4;
        }
    }

    private static void writeBMPString(String string, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = null;
        try {
            byArray = string.getBytes("UnicodeBigUnmarked");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new ASN1Exception(Msg.getString("K018f", unsupportedEncodingException));
        }
        ASN1Encoder.writeTagNumber(30, outputStream);
        ASN1Encoder.writeLength(byArray.length, outputStream);
        ASN1Encoder.writeBytes(byArray, outputStream);
        try {
            byteArrayOutputStream.writeTo(outputStream);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    protected void writeSet(Object[] objectArray) {
        ASN1Encoder.writeSet(objectArray, this.output);
    }

    protected void writeSet2(Object[] objectArray) {
        ASN1Encoder.writeSet2(objectArray, this.output);
    }

    protected void writeImplicitSet(ASN1Decoder$Set2 aSN1Decoder$Set2, int n) {
        ASN1Encoder.writeImplicitSet(aSN1Decoder$Set2, this.output, n);
    }

    protected void writeCertificateSet(Object[] objectArray) {
        ASN1Encoder.writeCertificateSet(objectArray, this.output);
    }

    private static void writeUTCTime(Date date, OutputStream outputStream) {
        int[] nArray = new int[6];
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.setTime(date);
        nArray[0] = calendar.get(1);
        nArray[0] = nArray[0] >= 2000 ? nArray[0] - 2000 : nArray[0] - 1900;
        nArray[1] = calendar.get(2) + 1;
        nArray[2] = calendar.get(5);
        nArray[3] = calendar.get(11);
        nArray[4] = calendar.get(12);
        nArray[5] = calendar.get(13);
        StringBuffer stringBuffer = ASN1Encoder.getDateString(nArray, 2);
        stringBuffer.append("Z");
        ASN1Encoder.writeTagNumber(23, outputStream);
        try {
            byte[] byArray = stringBuffer.toString().getBytes("ISO8859_1");
            ASN1Encoder.writeLength(byArray.length, outputStream);
            ASN1Encoder.writeBytes(byArray, outputStream);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.getMessage());
        }
    }

    protected void writeUTCTime(Date date) {
        ASN1Encoder.writeUTCTime(date, this.output);
    }

    private static void writeExplicit(Object object, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder.writeObject(object, byteArrayOutputStream);
        try {
            ASN1Encoder.writeTagNumber(160, outputStream);
            ASN1Encoder.writeLength(byteArrayOutputStream.size(), outputStream);
            byteArrayOutputStream.writeTo(outputStream);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    public static byte[] encodeNode(ASN1Decoder$Node aSN1Decoder$Node) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ASN1Encoder.encodeNode(aSN1Decoder$Node, byteArrayOutputStream);
        }
        catch (ASN1Exception aSN1Exception) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void encodeNode(ASN1Decoder$Node aSN1Decoder$Node, OutputStream outputStream) {
        if (aSN1Decoder$Node.originalType == -1) {
            aSN1Decoder$Node.originalType = aSN1Decoder$Node.type;
        }
        if (aSN1Decoder$Node.tagtype == 2) {
            ASN1Encoder.writeTagNumber(aSN1Decoder$Node.originalType | 0xA0, outputStream);
            if (aSN1Decoder$Node.type != -1) {
                ASN1Decoder$Node aSN1Decoder$Node2 = new ASN1Decoder$Node();
                aSN1Decoder$Node2.data = aSN1Decoder$Node.data;
                aSN1Decoder$Node2.isPrimitive = aSN1Decoder$Node.isPrimitive;
                aSN1Decoder$Node2.type = aSN1Decoder$Node.type;
                aSN1Decoder$Node2.originalType = aSN1Decoder$Node.type;
                aSN1Decoder$Node2.tagtype = 1;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ASN1Encoder.encodeNode(aSN1Decoder$Node2, byteArrayOutputStream);
                ASN1Encoder.writeLength(byteArrayOutputStream.size(), outputStream);
                try {
                    outputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException iOException) {}
            } else {
                ASN1Encoder.writeLength(0, outputStream);
            }
        } else {
            if (aSN1Decoder$Node.type == 17) {
                ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
                Object[] objectArray = new Object[aSN1Decoder$NodeArray.length];
                int n = 0;
                int n2 = 0;
                while (n2 < aSN1Decoder$NodeArray.length) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ASN1Encoder.encodeNode(aSN1Decoder$NodeArray[n2], byteArrayOutputStream);
                    objectArray[n2] = byteArrayOutputStream.toByteArray();
                    n += byteArrayOutputStream.size();
                    ++n2;
                }
                Object[] objectArray2 = new Object[objectArray.length];
                int n3 = 0;
                while (n3 < objectArray2.length) {
                    byte[] byArray = null;
                    int n4 = -1;
                    int n5 = 0;
                    while (n5 < objectArray.length) {
                        byte[] byArray2 = ASN1Encoder.getSmallestEncoding(byArray, (byte[])objectArray[n5]);
                        if (byArray2 != byArray) {
                            byArray = byArray2;
                            n4 = n5;
                        }
                        ++n5;
                    }
                    objectArray[n4] = null;
                    objectArray2[n3] = byArray;
                    ++n3;
                }
                ASN1Encoder.writeTagNumber(17, outputStream);
                ASN1Encoder.writeLength(n, outputStream);
                n3 = 0;
                while (n3 < objectArray2.length) {
                    try {
                        outputStream.write((byte[])objectArray2[n3]);
                    }
                    catch (IOException iOException) {}
                    ++n3;
                }
                return;
            }
            if (aSN1Decoder$Node.type == 16) {
                ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
                Object[] objectArray = new Object[aSN1Decoder$NodeArray.length];
                int n = 0;
                int n6 = 0;
                while (n6 < aSN1Decoder$NodeArray.length) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ASN1Encoder.encodeNode(aSN1Decoder$NodeArray[n6], byteArrayOutputStream);
                    objectArray[n6] = byteArrayOutputStream.toByteArray();
                    n += byteArrayOutputStream.size();
                    ++n6;
                }
                ASN1Encoder.writeTagNumber(16, outputStream);
                ASN1Encoder.writeLength(n, outputStream);
                n6 = 0;
                while (n6 < objectArray.length) {
                    try {
                        outputStream.write((byte[])objectArray[n6]);
                    }
                    catch (IOException iOException) {}
                    ++n6;
                }
                return;
            }
            if (aSN1Decoder$Node.type == 6) {
                ASN1Encoder.writeObjectIdentifier((int[])aSN1Decoder$Node.data, outputStream);
                return;
            }
            if (aSN1Decoder$Node.type == 23) {
                ASN1Encoder.writeUTCTime((Date)aSN1Decoder$Node.data, outputStream);
                return;
            }
            if (aSN1Decoder$Node.type == 4) {
                ASN1Encoder.writeOctetString((byte[])aSN1Decoder$Node.data, outputStream);
                return;
            }
            if (aSN1Decoder$Node.type == 5) {
                ASN1Encoder.writeTagNumber(5, outputStream);
                ASN1Encoder.writeLength(0, outputStream);
                return;
            }
            if (aSN1Decoder$Node.type == 2) {
                ASN1Encoder.writeInteger((BigInteger)aSN1Decoder$Node.data, outputStream);
                return;
            }
            if (aSN1Decoder$Node.type == 3) {
                ASN1Encoder.writeBitString((ASN1Decoder$BitString)aSN1Decoder$Node.data, outputStream);
                return;
            }
            if (aSN1Decoder$Node.type == 19) {
                ASN1Encoder.writePrintableString((String)aSN1Decoder$Node.data, outputStream);
                return;
            }
            if (aSN1Decoder$Node.type == 12) {
                ASN1Encoder.writeUTF8String((String)aSN1Decoder$Node.data, outputStream);
                return;
            }
            throw new ASN1Exception();
        }
    }

    private static byte[] getSmallestEncoding(byte[] byArray, byte[] byArray2) {
        if (byArray == null) {
            return byArray2;
        }
        if (byArray2 == null) {
            return byArray;
        }
        int n = 0;
        while (n != byArray.length) {
            if (n == byArray2.length) {
                return byArray;
            }
            if (byArray[n] < byArray2[n]) {
                return byArray;
            }
            if (byArray2[n] < byArray[n]) {
                return byArray2;
            }
            ++n;
        }
        return byArray2;
    }

    protected static void writeObjectTypeExtensions(Object object, OutputStream outputStream) {
    }
}

