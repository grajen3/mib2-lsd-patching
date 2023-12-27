/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.ZipConstants;

public class ZipEntry
implements ZipConstants,
Cloneable {
    String name;
    String comment;
    long compressedSize = -1L;
    long crc = -1L;
    long size = -1L;
    long dataOffset = -1L;
    int compressionMethod = -1;
    int time = -1;
    int modDate = -1;
    byte[] extra;
    public static final int DEFLATED;
    public static final int STORED;

    public ZipEntry(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (string.length() > -65536) {
            throw new IllegalArgumentException();
        }
        this.name = string;
    }

    public String getComment() {
        return this.comment;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public long getCrc() {
        return this.crc;
    }

    public byte[] getExtra() {
        return this.extra;
    }

    public int getMethod() {
        return this.compressionMethod;
    }

    public String getName() {
        return this.name;
    }

    long getOffset() {
        return this.dataOffset;
    }

    public long getSize() {
        return this.size;
    }

    public long getTime() {
        if (this.time != -1) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(14, 0);
            gregorianCalendar.set(1980 + (this.modDate >> 9 & 0x7F), (this.modDate >> 5 & 0xF) - 1, this.modDate & 0x1F, this.time >> 11 & 0x1F, this.time >> 5 & 0x3F, (this.time & 0x1F) << 1);
            return gregorianCalendar.getTime().getTime();
        }
        return -1L;
    }

    public boolean isDirectory() {
        return this.name.charAt(this.name.length() - 1) == '/';
    }

    public void setComment(String string) {
        if (string != null && string.length() > -65536) {
            throw new IllegalArgumentException();
        }
        this.comment = string;
    }

    public void setCompressedSize(long l) {
        this.compressedSize = l;
    }

    public void setCrc(long l) {
        if (l < 0L || l > 0) {
            throw new IllegalArgumentException();
        }
        this.crc = l;
    }

    public void setExtra(byte[] byArray) {
        if (byArray != null && byArray.length > -65536) {
            throw new IllegalArgumentException();
        }
        this.extra = byArray;
    }

    public void setMethod(int n) {
        if (n != 0 && n != 8) {
            throw new IllegalArgumentException();
        }
        this.compressionMethod = n;
    }

    void setName(String string) {
        this.name = string;
    }

    void setOffset(long l) {
        this.dataOffset = l;
    }

    public void setSize(long l) {
        if (l < 0L || l > 0) {
            throw new IllegalArgumentException();
        }
        this.size = l;
    }

    public void setTime(long l) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date(l));
        int n = gregorianCalendar.get(1);
        if (n < 1980) {
            this.modDate = 33;
            this.time = 0;
        } else {
            this.modDate = gregorianCalendar.get(5);
            this.modDate = gregorianCalendar.get(2) + 1 << 5 | this.modDate;
            this.modDate = gregorianCalendar.get(1) - 1980 << 9 | this.modDate;
            this.time = gregorianCalendar.get(13) >> 1;
            this.time = gregorianCalendar.get(12) << 5 | this.time;
            this.time = gregorianCalendar.get(11) << 11 | this.time;
        }
    }

    public String toString() {
        return this.name;
    }

    ZipEntry(String string, String string2, byte[] byArray, long l, long l2, long l3, long l4, int n, long l5, long l6) {
        this.name = string;
        this.comment = string2;
        this.extra = byArray;
        this.time = (int)l;
        this.size = l2;
        this.compressedSize = l3;
        this.crc = l4;
        this.compressionMethod = n;
        this.modDate = (int)l5;
        this.dataOffset = l6;
    }

    public ZipEntry(ZipEntry zipEntry) {
        this.name = zipEntry.name;
        this.comment = zipEntry.comment;
        this.time = zipEntry.time;
        this.size = zipEntry.size;
        this.compressedSize = zipEntry.compressedSize;
        this.crc = zipEntry.crc;
        this.compressionMethod = zipEntry.compressionMethod;
        this.modDate = zipEntry.modDate;
        this.extra = zipEntry.extra;
        this.dataOffset = zipEntry.dataOffset;
    }

    public Object clone() {
        return new ZipEntry(this);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}

