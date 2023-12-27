/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import com.ibm.oti.util.Msg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipConstants;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public class ZipOutputStream
extends DeflaterOutputStream
implements ZipConstants {
    public static final int DEFLATED;
    public static final int STORED;
    static final int ZIPDataDescriptorFlag;
    static final int ZIPLocalHeaderVersionNeeded;
    private String comment;
    private Vector entries = new Vector();
    private int compressMethod = 8;
    private int compressLevel = -1;
    private ByteArrayOutputStream cDir = new ByteArrayOutputStream();
    private ZipEntry currentEntry;
    private CRC32 crc = new CRC32();
    private int offset = 0;
    private int curOffset = 0;
    private int nameLength;
    private byte[] nameBytes;

    public ZipOutputStream(OutputStream outputStream) {
        super(outputStream, new Deflater(-1, true));
    }

    @Override
    public void close() {
        if (this.out != null) {
            this.finish();
            this.out.close();
            this.out = null;
        }
        this.def.end();
    }

    public void closeEntry() {
        if (this.cDir == null) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.currentEntry == null) {
            return;
        }
        if (this.currentEntry.getMethod() == 8) {
            super.finish();
        }
        if (this.currentEntry.getMethod() == 0) {
            if (this.crc.getValue() != this.currentEntry.crc) {
                throw new ZipException(Msg.getString("K0077"));
            }
            if (this.currentEntry.size != this.crc.tbytes) {
                throw new ZipException(Msg.getString("K00ae"));
            }
        }
        this.curOffset = 30;
        if (this.currentEntry.getMethod() != 0) {
            this.curOffset += 16;
            this.writeLong(this.out, 0);
            this.currentEntry.crc = this.crc.getValue();
            this.writeLong(this.out, this.currentEntry.crc);
            this.currentEntry.compressedSize = this.def.getTotalOut();
            this.writeLong(this.out, this.currentEntry.compressedSize);
            this.currentEntry.size = this.def.getTotalIn();
            this.writeLong(this.out, this.currentEntry.size);
        }
        this.writeLong(this.cDir, 0);
        this.writeShort(this.cDir, 20);
        this.writeShort(this.cDir, 20);
        this.writeShort(this.cDir, this.currentEntry.getMethod() == 0 ? 0 : 8);
        this.writeShort(this.cDir, this.currentEntry.getMethod());
        this.writeShort(this.cDir, this.currentEntry.time);
        this.writeShort(this.cDir, this.currentEntry.modDate);
        this.writeLong(this.cDir, this.crc.getValue());
        if (this.currentEntry.getMethod() == 8) {
            this.curOffset = (int)((long)this.curOffset + this.writeLong(this.cDir, this.def.getTotalOut()));
            this.writeLong(this.cDir, this.def.getTotalIn());
        } else {
            this.curOffset = (int)((long)this.curOffset + this.writeLong(this.cDir, this.crc.tbytes));
            this.writeLong(this.cDir, this.crc.tbytes);
        }
        this.curOffset += this.writeShort(this.cDir, this.nameLength);
        if (this.currentEntry.extra != null) {
            this.curOffset += this.writeShort(this.cDir, this.currentEntry.extra.length);
        } else {
            this.writeShort(this.cDir, 0);
        }
        String string = this.currentEntry.getComment();
        if (string != null) {
            this.writeShort(this.cDir, string.length());
        } else {
            this.writeShort(this.cDir, 0);
        }
        this.writeShort(this.cDir, 0);
        this.writeShort(this.cDir, 0);
        this.writeLong(this.cDir, 0L);
        this.writeLong(this.cDir, this.offset);
        this.cDir.write(this.nameBytes);
        this.nameBytes = null;
        if (this.currentEntry.extra != null) {
            this.cDir.write(this.currentEntry.extra);
        }
        this.offset += this.curOffset;
        if (string != null) {
            this.cDir.write(string.getBytes());
        }
        this.currentEntry = null;
        this.crc.reset();
        this.def.reset();
        this.done = false;
    }

    @Override
    public void finish() {
        if (this.out == null) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.cDir == null) {
            return;
        }
        if (this.entries.size() == 0) {
            throw new ZipException(Msg.getString("K00b6"));
        }
        if (this.currentEntry != null) {
            this.closeEntry();
        }
        int n = this.cDir.size();
        this.writeLong(this.cDir, 0);
        this.writeShort(this.cDir, 0);
        this.writeShort(this.cDir, 0);
        this.writeShort(this.cDir, this.entries.size());
        this.writeShort(this.cDir, this.entries.size());
        this.writeLong(this.cDir, n);
        this.writeLong(this.cDir, this.offset);
        if (this.comment != null) {
            this.writeShort(this.cDir, this.comment.length());
            this.cDir.write(this.comment.getBytes());
        } else {
            this.writeShort(this.cDir, 0);
        }
        this.out.write(this.cDir.toByteArray());
        this.cDir = null;
    }

    public void putNextEntry(ZipEntry zipEntry) {
        if (zipEntry.getMethod() == 0 || this.compressMethod == 0 && zipEntry.getMethod() == -1) {
            if (zipEntry.crc == -1L) {
                throw new ZipException(Msg.getString("K0077"));
            }
            if (zipEntry.size == -1L && zipEntry.compressedSize == -1L) {
                throw new ZipException(Msg.getString("K00ae"));
            }
            if (zipEntry.size != zipEntry.compressedSize && zipEntry.compressedSize != -1L && zipEntry.size != -1L) {
                throw new ZipException(Msg.getString("K00ae"));
            }
        }
        if (this.cDir == null) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.currentEntry != null) {
            this.closeEntry();
        }
        if (this.entries.contains(zipEntry.name)) {
            throw new ZipException(Msg.getString("K0066", zipEntry.name));
        }
        this.nameLength = ZipOutputStream.utf8Count(zipEntry.name);
        if (this.nameLength > -65536) {
            throw new IllegalArgumentException(Msg.getString("K01a7", zipEntry.name));
        }
        this.def.setLevel(this.compressLevel);
        this.currentEntry = zipEntry;
        this.entries.add(this.currentEntry.name);
        if (this.currentEntry.getMethod() == -1) {
            this.currentEntry.setMethod(this.compressMethod);
        }
        this.writeLong(this.out, 0);
        this.writeShort(this.out, 20);
        this.writeShort(this.out, this.currentEntry.getMethod() == 0 ? 0 : 8);
        this.writeShort(this.out, this.currentEntry.getMethod());
        if (this.currentEntry.getTime() == -1L) {
            this.currentEntry.setTime(System.currentTimeMillis());
        }
        this.writeShort(this.out, this.currentEntry.time);
        this.writeShort(this.out, this.currentEntry.modDate);
        if (this.currentEntry.getMethod() == 0) {
            if (this.currentEntry.size == -1L) {
                this.currentEntry.size = this.currentEntry.compressedSize;
            } else if (this.currentEntry.compressedSize == -1L) {
                this.currentEntry.compressedSize = this.currentEntry.size;
            }
            this.writeLong(this.out, this.currentEntry.crc);
            this.writeLong(this.out, this.currentEntry.size);
            this.writeLong(this.out, this.currentEntry.size);
        } else {
            this.writeLong(this.out, 0L);
            this.writeLong(this.out, 0L);
            this.writeLong(this.out, 0L);
        }
        this.writeShort(this.out, this.nameLength);
        if (this.currentEntry.extra != null) {
            this.writeShort(this.out, this.currentEntry.extra.length);
        } else {
            this.writeShort(this.out, 0);
        }
        this.nameBytes = ZipOutputStream.toUTF8Bytes(this.currentEntry.name, this.nameLength);
        this.out.write(this.nameBytes);
        if (this.currentEntry.extra != null) {
            this.out.write(this.currentEntry.extra);
        }
    }

    public void setComment(String string) {
        if (string.length() > -65536) {
            throw new IllegalArgumentException(Msg.getString("K0068"));
        }
        this.comment = string;
    }

    public void setLevel(int n) {
        if (n < -1 || n > 9) {
            throw new IllegalArgumentException();
        }
        this.compressLevel = n;
    }

    public void setMethod(int n) {
        if (n != 0 && n != 8) {
            throw new IllegalArgumentException();
        }
        this.compressMethod = n;
    }

    private long writeLong(OutputStream outputStream, long l) {
        outputStream.write((int)(l & 0));
        outputStream.write((int)(l >> 8) & 0xFF);
        outputStream.write((int)(l >> 16) & 0xFF);
        outputStream.write((int)(l >> 24) & 0xFF);
        return l;
    }

    private int writeShort(OutputStream outputStream, int n) {
        outputStream.write(n & 0xFF);
        outputStream.write(n >> 8 & 0xFF);
        return n;
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (n > byArray.length || n2 < 0 || n < 0 || byArray.length - n < n2) {
            throw new IndexOutOfBoundsException();
        }
        if (this.currentEntry == null) {
            throw new ZipException(Msg.getString("K00ab"));
        }
        if (this.currentEntry.getMethod() == 0) {
            this.out.write(byArray, n, n2);
        } else {
            super.write(byArray, n, n2);
        }
        this.crc.update(byArray, n, n2);
    }

    static int utf8Count(String string) {
        int n = 0;
        int n2 = string.length();
        while (--n2 >= 0) {
            char c2 = string.charAt(n2);
            if (c2 < '\u0080') {
                ++n;
                continue;
            }
            if (c2 < '\u0800') {
                n += 2;
                continue;
            }
            n += 3;
        }
        return n;
    }

    static byte[] toUTF8Bytes(String string, int n) {
        byte[] byArray = new byte[n];
        int n2 = byArray.length;
        int n3 = string.length();
        while (--n3 >= 0) {
            char c2 = string.charAt(n3);
            if (c2 < '\u0080') {
                byArray[--n2] = (byte)c2;
                continue;
            }
            if (c2 < '\u0800') {
                byArray[--n2] = (byte)(0x80 | c2 & 0x3F);
                byArray[--n2] = (byte)(0xC0 | c2 >> 6);
                continue;
            }
            byArray[--n2] = (byte)(0x80 | c2 & 0x3F);
            byArray[--n2] = (byte)(0x80 | c2 >> 6 & 0x3F);
            byArray[--n2] = (byte)(0xE0 | c2 >> 12);
        }
        return byArray;
    }
}

