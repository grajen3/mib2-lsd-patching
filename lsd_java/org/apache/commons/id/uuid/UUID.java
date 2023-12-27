/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid;

import java.io.DataInput;
import java.io.Serializable;
import java.util.StringTokenizer;
import org.apache.commons.id.DecoderException;
import org.apache.commons.id.DigestUtils;
import org.apache.commons.id.Hex;
import org.apache.commons.id.uuid.Bytes;
import org.apache.commons.id.uuid.Constants;
import org.apache.commons.id.uuid.UUIDFormatException;
import org.apache.commons.id.uuid.VersionFourGenerator;
import org.apache.commons.id.uuid.VersionOneGenerator;

public class UUID
implements Constants,
Serializable,
Comparable {
    private byte[] rawBytes = new byte[16];
    private Long node = null;
    private long timestamp = -1L;
    private Short clockSq = null;
    private int version = -1;
    private int variant = -1;
    private String stringValue = null;

    public UUID() {
    }

    public UUID(UUID uUID) {
        this.rawBytes = uUID.getRawBytes();
    }

    public UUID(byte[] byArray) {
        if (byArray.length != 16) {
            throw new IllegalArgumentException("UUID must be contructed using a 16 byte array.");
        }
        System.arraycopy((Object)byArray, 0, (Object)this.rawBytes, 0, 16);
    }

    public UUID(DataInput dataInput) {
        dataInput.readFully(this.rawBytes, 0, 16);
    }

    public UUID(long l, long l2) {
        this.rawBytes = Bytes.append(Bytes.toBytes(l), Bytes.toBytes(l2));
    }

    public UUID(String string) {
        this(UUID.fromString(string));
    }

    public static UUID fromString(String string) {
        String string2 = string.toLowerCase();
        UUID uUID = null;
        int n = string.lastIndexOf(":");
        if (n > 1) {
            string2 = string.substring(++n, string.length());
        }
        if (string2.length() != 36) {
            throw new UUIDFormatException(string);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string2, "-");
        if (stringTokenizer.countTokens() != 5) {
            throw new UUIDFormatException(string);
        }
        StringBuffer stringBuffer = new StringBuffer(32);
        String string3 = null;
        int n2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            string3 = stringTokenizer.nextToken();
            if (string3.length() != TOKEN_LENGTHS[n2++]) {
                throw new UUIDFormatException(string);
            }
            stringBuffer.append(string3);
        }
        try {
            char[] cArray = stringBuffer.toString().toCharArray();
            uUID = new UUID(Hex.decodeHex(cArray));
        }
        catch (DecoderException decoderException) {
            throw new UUIDFormatException(new StringBuffer().append(string).append(": ").append(decoderException.getMessage()).toString());
        }
        return uUID;
    }

    public String toString() {
        if (this.stringValue == null) {
            StringBuffer stringBuffer = new StringBuffer(new String(Hex.encodeHex(this.rawBytes)));
            while (stringBuffer.length() != 32) {
                stringBuffer.insert(0, "0");
            }
            stringBuffer.ensureCapacity(36);
            stringBuffer.insert(8, '-');
            stringBuffer.insert(13, '-');
            stringBuffer.insert(18, '-');
            stringBuffer.insert(23, '-');
            this.stringValue = stringBuffer.toString();
        }
        return this.stringValue;
    }

    public String toUrn() {
        return new StringBuffer().append("urn:uuid:").append(this.toString()).toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof UUID)) {
            return false;
        }
        return Bytes.areEqual(((UUID)object).getRawBytes(), this.rawBytes);
    }

    public int hashCode() {
        int n = 37;
        int n2 = 17;
        for (int i2 = 0; i2 < this.rawBytes.length; ++i2) {
            n2 = n2 * n + this.rawBytes[i2];
        }
        return n2;
    }

    @Override
    public int compareTo(Object object) {
        if (!(object instanceof UUID)) {
            throw new ClassCastException();
        }
        return Bytes.compareTo(this.rawBytes, ((UUID)object).getRawBytes());
    }

    public int clockSequence() {
        if (this.variant() != 2 || this.version() != 1) {
            throw new UnsupportedOperationException("Not a ietf variant 2 or version 1 (time-based UUID)");
        }
        if (this.clockSq == null) {
            byte[] byArray = new byte[]{(byte)(this.rawBytes[8] & 0x3F), this.rawBytes[9]};
            this.clockSq = new Short(Bytes.toShort(byArray));
        }
        return this.clockSq.intValue();
    }

    public int version() {
        if (this.version == -1) {
            this.version = this.rawBytes[6] >>> 4 & 0xF;
        }
        return this.version;
    }

    public int variant() {
        if (this.variant == -1) {
            this.variant = (this.rawBytes[8] & 0x80) == 0 ? 0 : ((this.rawBytes[8] & 0x40) == 0 ? 2 : ((this.rawBytes[8] & 0x20) == 0 ? 6 : 7));
        }
        return this.variant;
    }

    public long node() {
        if (this.variant() != 2 || this.version() != 1) {
            throw new UnsupportedOperationException("Not a ietf variant 2 or version 1 (time-based UUID)");
        }
        if (this.node == null) {
            byte[] byArray = new byte[8];
            System.arraycopy((Object)this.rawBytes, 10, (Object)byArray, 2, 6);
            this.node = new Long(Bytes.toLong(byArray) & 0xFFFFFFFFFFFFL);
        }
        return this.node;
    }

    public long timestamp() {
        if (this.variant() != 2 || this.version() != 1) {
            throw new UnsupportedOperationException("Not a ietf variant 2 or version 1 (time-based UUID)");
        }
        if (this.timestamp == -1L) {
            byte[] byArray = new byte[8];
            System.arraycopy((Object)this.rawBytes, 6, (Object)byArray, 0, 2);
            System.arraycopy((Object)this.rawBytes, 4, (Object)byArray, 2, 2);
            System.arraycopy((Object)this.rawBytes, 0, (Object)byArray, 4, 4);
            byArray[0] = (byte)(byArray[0] & 0xF);
            this.timestamp = Bytes.toLong(byArray);
        }
        return this.timestamp;
    }

    long getLeastSignificantBits() {
        byte[] byArray = new byte[8];
        System.arraycopy((Object)this.rawBytes, 8, (Object)byArray, 0, 8);
        return Bytes.toLong(byArray);
    }

    long getMostSignificantBits() {
        byte[] byArray = new byte[8];
        System.arraycopy((Object)this.rawBytes, 0, (Object)byArray, 0, 8);
        return Bytes.toLong(byArray);
    }

    public byte[] getRawBytes() {
        byte[] byArray = new byte[16];
        System.arraycopy((Object)this.rawBytes, 0, (Object)byArray, 0, 16);
        return byArray;
    }

    public static UUID randomUUID() {
        return VersionFourGenerator.getInstance().nextUUID();
    }

    public static UUID timeUUID() {
        return VersionOneGenerator.getInstance().nextUUID();
    }

    public static UUID nameUUIDFromString(String string, UUID uUID, String string2) {
        byte[] byArray = string.getBytes();
        byte[] byArray2 = new byte[16 + byArray.length];
        System.arraycopy((Object)uUID.getRawBytes(), 0, (Object)byArray2, 0, 16);
        System.arraycopy((Object)byArray, 0, (Object)byArray2, 16, byArray.length);
        byte[] byArray3 = null;
        if (string2.equals("MD5")) {
            byArray3 = DigestUtils.md5(byArray2);
        } else if (string2.equals("SHA1")) {
            byte[] byArray4 = DigestUtils.sha(byArray2);
            byArray3 = new byte[16];
            System.arraycopy((Object)byArray4, 0, (Object)byArray3, 0, 16);
        } else {
            throw new RuntimeException(new StringBuffer().append("Unsupported encoding ").append(string2).toString());
        }
        byArray3[6] = (byte)(byArray3[6] & 0xF);
        byArray3[6] = (byte)(byArray3[6] | 0x30);
        byArray3[8] = (byte)(byArray3[8] & 0x3F);
        byArray3[8] = (byte)(byArray3[8] | 0x80);
        return new UUID(byArray3);
    }

    public static UUID nameUUIDFromString(String string, UUID uUID) {
        return UUID.nameUUIDFromString(string, uUID, "MD5");
    }
}

