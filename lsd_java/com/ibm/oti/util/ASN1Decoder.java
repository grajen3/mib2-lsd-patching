/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.ASN1Decoder$BMPString;
import com.ibm.oti.util.ASN1Decoder$BitString;
import com.ibm.oti.util.ASN1Decoder$GeneralizedTime;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Decoder$Set;
import com.ibm.oti.util.ASN1Decoder$TypeMapper;
import com.ibm.oti.util.ASN1Decoder$UTCTime;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PositionedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Vector;

public class ASN1Decoder {
    private PositionedInputStream input;
    private int nesting = 0;
    private int sequenceItem = 0;
    private ASN1Decoder$TypeMapper[] tagConfiguration;
    private boolean collectBytes;
    private ByteArrayOutputStream bytesCollected;
    public static final int END_OF_BER_CONTENTS;
    public static final int BOOLEAN;
    public static final int INTEGER;
    public static final int BIT_STRING;
    public static final int OCTET_STRING;
    public static final int NULL;
    public static final int OBJECT_IDENTIFIER;
    public static final int SEQUENCE;
    public static final int SET;
    public static final int BMP_STRING;
    public static final int NUMERIC_STRING;
    public static final int PRINTABLE_STRING;
    public static final int T61_STRING;
    public static final int VIDEOTEXT_STRING;
    public static final int IA5_STRING;
    public static final int UTF_STRING;
    public static final int UTC_TIME;
    public static final int GENERALIZED_TIME;
    public static final int CLASS_UNIVERSAL;
    public static final int EXPLICIT;
    public static final int LENGTH_UNKNOWN;

    public ASN1Decoder(InputStream inputStream) {
        this.input = new PositionedInputStream(inputStream);
    }

    public ASN1Decoder(InputStream inputStream, boolean bl) {
        this.input = new PositionedInputStream(inputStream);
    }

    private int readByte() {
        try {
            int n = this.input.read();
            if (n < 0) {
                throw new ASN1Exception();
            }
            if (this.collectBytes) {
                this.bytesCollected.write(n);
            }
            return n & 0xFF;
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    private Date parseUTCDate(String string) {
        int[] nArray = this.parseYMD(string, 2);
        nArray[0] = nArray[0] <= 49 ? nArray[0] + 2000 : nArray[0] + 1900;
        return this.dateFromArray(string, nArray);
    }

    private Date parseGeneralizedDate(String string) {
        int[] nArray = this.parseYMD(string, 4);
        return this.dateFromArray(string, nArray);
    }

    private Date dateFromArray(String string, int[] nArray) {
        String string2 = this.getTZ(string);
        TimeZone timeZone = TimeZone.getTimeZone(string2);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.set(nArray[0], nArray[1] - 1, nArray[2], nArray[3], nArray[4], nArray[5]);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    private int[] parseYMD(String string, int n) {
        int n2 = 0;
        int n3 = n;
        int[] nArray = new int[6];
        int n4 = 0;
        while (n4 < nArray.length) {
            char c2;
            if (n4 == 5 && ((c2 = string.charAt(n2)) < '0' || c2 > '9')) break;
            nArray[n4] = Integer.parseInt(string.substring(n2, n2 + n3));
            n2 += n3;
            n3 = 2;
            ++n4;
        }
        return nArray;
    }

    private String getTZ(String string) {
        String string2 = "GMT";
        char c2 = string.charAt(string.length() - 1);
        if (c2 != 'Z') {
            string2 = new StringBuffer(String.valueOf(string2)).append(string.substring(string.length() - 5, string.length())).toString();
        }
        return string2;
    }

    public void collectBytes(boolean bl) {
        this.collectBytes = bl;
        this.bytesCollected = bl ? new ByteArrayOutputStream(1024) : null;
    }

    public byte[] collectedBytes() {
        if (this.collectBytes) {
            return this.bytesCollected.toByteArray();
        }
        return null;
    }

    public ASN1Decoder$Node readContents() {
        ASN1Decoder$Node aSN1Decoder$Node = new ASN1Decoder$Node();
        aSN1Decoder$Node.startPosition = this.input.currentPosition();
        this.readTag(aSN1Decoder$Node);
        this.computeTypeRedirection(aSN1Decoder$Node);
        switch (aSN1Decoder$Node.type) {
            case 16: {
                aSN1Decoder$Node.data = this.readSequence();
                break;
            }
            case 17: {
                aSN1Decoder$Node.data = this.readSet();
                break;
            }
            case 1: {
                aSN1Decoder$Node.data = this.readBoolean();
                break;
            }
            case 2: {
                aSN1Decoder$Node.data = this.readInteger();
                break;
            }
            case 5: {
                if (this.readByte() == 0) break;
                this.throwASN1Exception();
                break;
            }
            case 6: {
                aSN1Decoder$Node.data = this.readObjectIdentifier();
                break;
            }
            case 4: {
                aSN1Decoder$Node.data = this.readOctetString();
                break;
            }
            case 18: {
                aSN1Decoder$Node.data = this.readNumericString();
                break;
            }
            case 19: {
                aSN1Decoder$Node.data = this.readPrintableString();
                break;
            }
            case 30: {
                aSN1Decoder$Node.data = this.readBMPString();
                break;
            }
            case 22: {
                aSN1Decoder$Node.data = this.readIA5String();
                break;
            }
            case 12: {
                aSN1Decoder$Node.data = this.readUTFString();
                break;
            }
            case 20: {
                aSN1Decoder$Node.data = this.readT61String();
                break;
            }
            case 21: {
                aSN1Decoder$Node.data = this.readVideotextString();
                break;
            }
            case 3: {
                aSN1Decoder$Node.data = this.readBitString();
                break;
            }
            case 23: {
                aSN1Decoder$Node.data = this.readUTCTime();
                break;
            }
            case 24: {
                aSN1Decoder$Node.data = this.readGeneralizedTime();
                break;
            }
            case 0: {
                int n = this.readLength();
                if (n != 0) {
                    throw new ASN1Exception(Msg.getString("K0088"));
                }
                return null;
            }
            default: {
                throw new ASN1Exception(Msg.getString("K0089", aSN1Decoder$Node.type));
            }
        }
        aSN1Decoder$Node.endPosition = this.input.currentPosition() - 1;
        return aSN1Decoder$Node;
    }

    public Object readContentsToObject() {
        ASN1Decoder$Node aSN1Decoder$Node = new ASN1Decoder$Node();
        aSN1Decoder$Node.startPosition = this.input.currentPosition();
        this.readTag(aSN1Decoder$Node);
        this.computeTypeRedirection(aSN1Decoder$Node);
        switch (aSN1Decoder$Node.type) {
            case 16: {
                aSN1Decoder$Node.data = this.readSequenceToObject();
                break;
            }
            case 17: {
                aSN1Decoder$Node.data = this.readSetToObject();
                break;
            }
            case 1: {
                aSN1Decoder$Node.data = this.readBoolean();
                break;
            }
            case 2: {
                aSN1Decoder$Node.data = this.readInteger();
                break;
            }
            case 5: {
                if (this.readByte() == 0) break;
                this.throwASN1Exception();
                break;
            }
            case 6: {
                aSN1Decoder$Node.data = this.readObjectIdentifier();
                break;
            }
            case 4: {
                aSN1Decoder$Node.data = this.readOctetString();
                break;
            }
            case 18: {
                aSN1Decoder$Node.data = this.readNumericString();
                break;
            }
            case 19: {
                aSN1Decoder$Node.data = this.readPrintableString();
                break;
            }
            case 30: {
                aSN1Decoder$Node.data = this.readBMPString();
                break;
            }
            case 22: {
                aSN1Decoder$Node.data = this.readIA5String();
                break;
            }
            case 12: {
                aSN1Decoder$Node.data = this.readUTFString();
                break;
            }
            case 20: {
                aSN1Decoder$Node.data = this.readT61String();
                break;
            }
            case 21: {
                aSN1Decoder$Node.data = this.readVideotextString();
                break;
            }
            case 3: {
                aSN1Decoder$Node.data = this.readBitString();
                break;
            }
            case 23: {
                aSN1Decoder$Node.data = this.readUTCTimeToObject();
                break;
            }
            case 24: {
                aSN1Decoder$Node.data = this.readGeneralizedTimeToObject();
                break;
            }
            case 0: {
                int n = this.readLength();
                if (n != 0) {
                    throw new ASN1Exception(Msg.getString("K0088"));
                }
                return null;
            }
            default: {
                throw new ASN1Exception(Msg.getString("K0089", aSN1Decoder$Node.type));
            }
        }
        aSN1Decoder$Node.endPosition = this.input.currentPosition() - 1;
        return aSN1Decoder$Node.data;
    }

    private void readFully(InputStream inputStream, byte[] byArray) {
        try {
            this.readFully(inputStream, byArray, 0, byArray.length);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    private void readFully(InputStream inputStream, byte[] byArray, int n, int n2) {
        int n3 = 0;
        int n4 = n2;
        while (n3 < n2) {
            int n5 = inputStream.read(byArray, n + n3, n4);
            if (n5 <= 0) {
                throw new IOException(Msg.getString("K008a", new Object[]{Integer.toString(n5), Integer.toString(n4), inputStream}));
            }
            if (this.collectBytes) {
                this.bytesCollected.write(byArray, n + n3, n5);
            }
            n3 += n5;
            n4 -= n5;
        }
    }

    protected Date readUTCTime() {
        String string = ASN1Decoder.convertToString(this.readOctetString());
        return this.parseUTCDate(string);
    }

    protected ASN1Decoder$UTCTime readUTCTimeToObject() {
        String string = ASN1Decoder.convertToString(this.readOctetString());
        return new ASN1Decoder$UTCTime(this.parseUTCDate(string));
    }

    protected Date readGeneralizedTime() {
        String string = ASN1Decoder.convertToString(this.readOctetString());
        return this.parseGeneralizedDate(string);
    }

    protected ASN1Decoder$GeneralizedTime readGeneralizedTimeToObject() {
        String string = ASN1Decoder.convertToString(this.readOctetString());
        return new ASN1Decoder$GeneralizedTime(this.parseGeneralizedDate(string));
    }

    protected BigInteger readInteger() {
        int n = this.readLength();
        byte[] byArray = new byte[n];
        this.readFully(this.input, byArray);
        return new BigInteger(1, byArray);
    }

    protected Boolean readBoolean() {
        int n;
        int n2 = this.readLength();
        if (n2 != 1) {
            this.throwASN1Exception();
        }
        if ((n = this.readByte()) == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    protected int readLength() {
        int n = this.readByte();
        if (n < 128) {
            return n;
        }
        if (n == 128) {
            return -1;
        }
        int n2 = n & 0x7F;
        n = 0;
        int n3 = 0;
        while (n3 < n2) {
            n = n * 256 + this.readByte();
            ++n3;
        }
        if (n < 0) {
            this.throwASN1Exception();
        }
        return n;
    }

    protected int[] readObjectIdentifier() {
        int n = this.readLength();
        int[] nArray = new int[n];
        int n2 = 0;
        while (n2 < nArray.length) {
            nArray[n2] = this.readByte();
            ++n2;
        }
        n2 = nArray.length + 1;
        int n3 = 1;
        while (n3 < nArray.length) {
            if (nArray[n3] >= 128) {
                --n2;
            }
            ++n3;
        }
        int[] nArray2 = new int[n2];
        nArray2[0] = nArray[0] / 40;
        nArray2[1] = nArray[0] % 40;
        int n4 = 1;
        int n5 = 2;
        while (n4 < nArray.length) {
            int n6 = n5;
            nArray2[n6] = nArray2[n6] * 128;
            if (nArray[n4] < 128) {
                int n7 = n5++;
                nArray2[n7] = nArray2[n7] + nArray[n4];
            } else {
                int n8 = n5;
                nArray2[n8] = nArray2[n8] + (nArray[n4] - 128);
            }
            ++n4;
        }
        return nArray2;
    }

    protected byte[] readOctetString() {
        int n = this.readLength();
        byte[] byArray = new byte[n];
        this.readFully(this.input, byArray);
        return byArray;
    }

    protected String readNumericString() {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected String readPrintableString() {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected String readIA5String() {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected String readUTFString() {
        String string = null;
        try {
            string = new String(this.readOctetString(), "UTF8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new ASN1Exception(Msg.getString("K0220", unsupportedEncodingException));
        }
        return string;
    }

    protected String readT61String() {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected String readVideotextString() {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected ASN1Decoder$BitString readBitString() {
        int n = this.readLength();
        int n2 = this.readByte();
        byte[] byArray = new byte[n - 1];
        this.readFully(this.input, byArray);
        return new ASN1Decoder$BitString(n2, byArray);
    }

    protected ASN1Decoder$Node[] readSequence() {
        int n = this.readLength();
        int n2 = 0;
        Vector vector = new Vector();
        ++this.nesting;
        int n3 = 1;
        while (n2 < n || n == -1) {
            int n4 = this.input.currentPosition();
            this.sequenceItem = n3;
            ASN1Decoder$Node aSN1Decoder$Node = this.readContents();
            if (n == -1 && aSN1Decoder$Node == null) break;
            vector.addElement(aSN1Decoder$Node);
            int n5 = this.input.currentPosition();
            int n6 = n5 - n4;
            n2 += n6;
            ++n3;
        }
        --this.nesting;
        if (n != -1 && n2 != n) {
            this.throwASN1Exception();
        }
        Object[] objectArray = new ASN1Decoder$Node[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    protected Object[] readSequenceToObject() {
        int n = this.readLength();
        int n2 = 0;
        Vector vector = new Vector();
        ++this.nesting;
        int n3 = 1;
        while (n2 < n || n == -1) {
            int n4 = this.input.currentPosition();
            this.sequenceItem = n3;
            Object object = this.readContentsToObject();
            if (n == -1 && object == null) break;
            vector.addElement(object);
            int n5 = this.input.currentPosition();
            int n6 = n5 - n4;
            n2 += n6;
            ++n3;
        }
        --this.nesting;
        if (n != -1 && n2 != n) {
            this.throwASN1Exception();
        }
        Object[] objectArray = new Object[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    protected ASN1Decoder$Node[] readSet() {
        return this.readSequence();
    }

    protected ASN1Decoder$Set readSetToObject() {
        return new ASN1Decoder$Set(this.readSequenceToObject());
    }

    protected ASN1Decoder$BMPString readBMPString() {
        int n = this.readLength();
        byte[] byArray = new byte[n];
        this.readFully(this.input, byArray);
        String string = null;
        try {
            string = new String(byArray, "UnicodeBigUnmarked");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new ASN1Exception(Msg.getString("K018f", unsupportedEncodingException));
        }
        return new ASN1Decoder$BMPString(string);
    }

    protected ASN1Decoder$Node[] readConstructed() {
        return this.readSequence();
    }

    protected void readTag(ASN1Decoder$Node aSN1Decoder$Node) {
        int n = this.readByte();
        aSN1Decoder$Node.elementClass = n >> 6;
        aSN1Decoder$Node.isPrimitive = (n & 0x20) == 0;
        int n2 = n & 0x1F;
        if (n2 == 31) {
            int n3;
            n2 = 0;
            do {
                n3 = this.readByte();
                n2 = n2 * 128 + (n3 & 0x7F);
            } while ((n3 & 0x80) != 0);
        }
        aSN1Decoder$Node.originalType = n2;
        aSN1Decoder$Node.type = n2;
    }

    public void configureTypeRedirection(int n, ASN1Decoder$TypeMapper typeMapper) {
        if (this.tagConfiguration == null) {
            this.tagConfiguration = new ASN1Decoder$TypeMapper[n + 5];
        }
        if (this.tagConfiguration.length <= n) {
            ASN1Decoder$TypeMapper[] typeMapperArray = this.tagConfiguration;
            this.tagConfiguration = new ASN1Decoder$TypeMapper[n + 5];
            int n2 = 0;
            while (n2 < typeMapperArray.length) {
                this.tagConfiguration[n2] = typeMapperArray[n2];
                ++n2;
            }
        }
        this.tagConfiguration[n] = typeMapper;
    }

    private void computeTypeRedirection(ASN1Decoder$Node aSN1Decoder$Node) {
        if (aSN1Decoder$Node.elementClass == 0 && this.nesting == 0) {
            return;
        }
        if (this.tagConfiguration == null) {
            if (aSN1Decoder$Node.type == 0) {
                try {
                    this.readLength();
                    this.readTag(aSN1Decoder$Node);
                }
                catch (ASN1Exception aSN1Exception) {}
            }
            return;
        }
        if (this.nesting >= this.tagConfiguration.length) {
            return;
        }
        ASN1Decoder$TypeMapper aSN1Decoder$TypeMapper = this.tagConfiguration[this.nesting];
        if (aSN1Decoder$TypeMapper == null) {
            return;
        }
        aSN1Decoder$Node.type = aSN1Decoder$TypeMapper.map(aSN1Decoder$Node.originalType, this.nesting, this.sequenceItem);
    }

    private void throwASN1Exception() {
        throw new ASN1Exception(Msg.getString("K008b", this.input.currentPosition()));
    }

    public static Object getDecoded(byte[] byArray) {
        if (byArray == null) {
            throw new ASN1Exception(Msg.getString("K0190"));
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
        return aSN1Decoder.readContentsToObject();
    }

    private static String convertToString(byte[] byArray) {
        try {
            return new String(byArray, "ISO8859_1");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.toString());
        }
    }
}

