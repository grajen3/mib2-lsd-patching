/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;

public class UUID {
    private byte[] raw = new byte[16];

    public UUID() {
    }

    public UUID(String string) {
        this.parseFromString(string);
    }

    public UUID(byte[] byArray) {
        if (byArray.length != 16) {
            throw new IllegalArgumentException("UUID bytes must be 16 in length");
        }
        this.raw = byArray;
    }

    public void parseFromString(String string) {
        int n;
        if (string == null || string.length() != 36) {
            throw new IllegalArgumentException("UUID string must be 36 chars long");
        }
        if (string.charAt(8) != '-' || string.charAt(13) != '-' || string.charAt(18) != '-' || string.charAt(23) != '-') {
            throw new IllegalArgumentException("UUID string has wrong dashes");
        }
        for (n = 0; n < 4; ++n) {
            this.raw[n] = this.parseByte(string, n * 2);
        }
        this.raw[4] = this.parseByte(string, 9);
        this.raw[5] = this.parseByte(string, 11);
        this.raw[6] = this.parseByte(string, 14);
        this.raw[7] = this.parseByte(string, 16);
        this.raw[8] = this.parseByte(string, 19);
        this.raw[9] = this.parseByte(string, 21);
        for (n = 0; n < 6; ++n) {
            this.raw[10 + n] = this.parseByte(string, 24 + n * 2);
        }
    }

    private byte parseByte(String string, int n) {
        String string2 = string.substring(n, n + 2);
        int n2 = Integer.parseInt(string2, 16) & 0xFF;
        return (byte)n2;
    }

    public String toString() {
        int n;
        Buffer buffer = new Buffer();
        for (n = 0; n < 4; ++n) {
            StringUtils.toHexByte(this.raw[n], buffer);
        }
        buffer.append('-');
        StringUtils.toHexByte(this.raw[4], buffer);
        StringUtils.toHexByte(this.raw[5], buffer);
        buffer.append('-');
        StringUtils.toHexByte(this.raw[6], buffer);
        StringUtils.toHexByte(this.raw[7], buffer);
        buffer.append('-');
        StringUtils.toHexByte(this.raw[8], buffer);
        StringUtils.toHexByte(this.raw[9], buffer);
        buffer.append('-');
        for (n = 10; n < 16; ++n) {
            StringUtils.toHexByte(this.raw[n], buffer);
        }
        return buffer.toString();
    }

    public byte[] getRawBytes() {
        return this.raw;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof UUID)) {
            return false;
        }
        UUID uUID = (UUID)object;
        if (this.raw == null) {
            return uUID.raw == null;
        }
        if (uUID.raw == null) {
            return false;
        }
        if (this.raw.length != uUID.raw.length) {
            return false;
        }
        for (int i2 = 0; i2 < this.raw.length; ++i2) {
            if (this.raw[i2] == uUID.raw[i2]) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.raw == null) {
            return 0;
        }
        int n = 0;
        for (int i2 = 0; i2 < this.raw.length; ++i2) {
            n = n * 11 + this.raw[i2];
        }
        return n;
    }
}

