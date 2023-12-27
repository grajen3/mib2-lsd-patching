/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.VM;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipConstants;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public class ZipInputStream
extends InflaterInputStream
implements ZipConstants {
    static final int DEFLATED;
    static final int STORED;
    static final int ZIPDataDescriptorFlag;
    static final int ZIPLocalHeaderVersionNeeded;
    private static final boolean useNative;
    private boolean closed = false;
    private boolean entriesEnd = false;
    private boolean hasDD = false;
    private int entryIn = 0;
    private int inRead;
    private int lastRead = 0;
    ZipEntry currentEntry;
    private byte[] hdrBuf = new byte[26];
    private CRC32 crc = new CRC32();
    private byte[] nameBuf = new byte[256];
    private char[] charBuf;

    static {
        useNative = VM.useNatives();
    }

    public ZipInputStream(InputStream inputStream) {
        super(new PushbackInputStream(inputStream, 512), new Inflater(true));
        char[] cArray = this.charBuf = useNative ? null : new char[256];
        if (inputStream == null) {
            throw new NullPointerException();
        }
    }

    @Override
    public void close() {
        this.closeEntry();
        this.closed = true;
        super.close();
    }

    public void closeEntry() {
        int n;
        int n2;
        Attributes attributes;
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.currentEntry == null) {
            return;
        }
        if (this.currentEntry instanceof JarEntry && (attributes = ((JarEntry)this.currentEntry).getAttributes()) != null && attributes.containsKey("hidden")) {
            return;
        }
        this.skip(Long.MAX_VALUE);
        if (this.currentEntry.compressionMethod == 8) {
            n2 = this.inf.getTotalIn();
            n = this.inf.getTotalOut();
        } else {
            n2 = this.inRead;
            n = this.inRead;
        }
        int n3 = 0;
        n3 = this.entryIn - n2;
        if (n3 != 0) {
            ((PushbackInputStream)this.in).unread(this.buf, this.len - n3, n3);
        }
        if (this.hasDD) {
            this.in.read(this.hdrBuf, 0, 16);
            if (this.getLong(this.hdrBuf, 0) != 0) {
                throw new ZipException(Msg.getString("K0020"));
            }
            this.currentEntry.crc = this.getLong(this.hdrBuf, 4);
            this.currentEntry.compressedSize = this.getLong(this.hdrBuf, 8);
            this.currentEntry.size = this.getLong(this.hdrBuf, 12);
        }
        if (this.currentEntry.crc != this.crc.getValue()) {
            throw new ZipException(Msg.getString("K0077"));
        }
        if (this.currentEntry.compressedSize != (long)n2 || this.currentEntry.size != (long)n) {
            throw new ZipException(Msg.getString("K00ae"));
        }
        this.inf.reset();
        this.len = 0;
        this.entryIn = 0;
        this.inRead = 0;
        this.lastRead = 0;
        this.crc.reset();
        this.currentEntry = null;
    }

    public ZipEntry getNextEntry() {
        int n;
        int n2;
        if (this.currentEntry != null) {
            this.closeEntry();
        }
        if (this.entriesEnd) {
            return null;
        }
        int n3 = 0;
        for (n2 = 0; n2 != 4; n2 += n3) {
            n3 = this.in.read(this.hdrBuf, n2, 4 - n2);
            if (n3 != -1) continue;
            return null;
        }
        long l = this.getLong(this.hdrBuf, 0);
        if (l == 0) {
            this.entriesEnd = true;
            return null;
        }
        if (l != 0) {
            return null;
        }
        for (n2 = 0; n2 != 26; n2 += n3) {
            n3 = this.in.read(this.hdrBuf, n2, 26 - n2);
            if (n3 != -1) continue;
            throw new EOFException();
        }
        int n4 = this.getShort(this.hdrBuf, 0) & 0xFF;
        if (n4 > 20) {
            throw new ZipException(Msg.getString("K0008"));
        }
        int n5 = this.getShort(this.hdrBuf, 2);
        this.hasDD = (n5 & 8) == 8;
        int n6 = this.getShort(this.hdrBuf, 6);
        int n7 = this.getShort(this.hdrBuf, 8);
        int n8 = this.getShort(this.hdrBuf, 4);
        long l2 = 0L;
        long l3 = 0L;
        long l4 = -1L;
        if (!this.hasDD) {
            l2 = this.getLong(this.hdrBuf, 10);
            l3 = this.getLong(this.hdrBuf, 14);
            l4 = this.getLong(this.hdrBuf, 18);
        }
        if ((n = this.getShort(this.hdrBuf, 22)) == 0) {
            throw new ZipException(Msg.getString("K000a"));
        }
        int n9 = this.getShort(this.hdrBuf, 24);
        n2 = 0;
        if (n > this.nameBuf.length) {
            this.nameBuf = new byte[n];
            if (!useNative) {
                this.charBuf = new char[n];
            }
        }
        while (n2 != n) {
            n3 = this.in.read(this.nameBuf, n2, n - n2);
            n2 += n3;
            if (n3 != -1) continue;
            throw new EOFException();
        }
        this.currentEntry = useNative ? this.createZipEntry(Util.convertFromUTF8(this.nameBuf, 0, n)) : this.createZipEntry(Util.convertUTF8WithBuf(this.nameBuf, this.charBuf, 0, n));
        this.currentEntry.time = n6;
        this.currentEntry.modDate = n7;
        this.currentEntry.setMethod(n8);
        if (l4 != -1L) {
            this.currentEntry.setCrc(l2);
            this.currentEntry.setSize(l4);
            this.currentEntry.setCompressedSize(l3);
        }
        if (n9 > 0) {
            byte[] byArray = new byte[n9];
            for (n2 = 0; n2 != n9; n2 += n3) {
                n3 = this.in.read(byArray, n2, n9 - n2);
                if (n3 != -1) continue;
                throw new EOFException();
            }
            this.currentEntry.setExtra(byArray);
        }
        return this.currentEntry;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.inf.finished() || this.currentEntry == null) {
            return -1;
        }
        if (n <= byArray.length && n2 >= 0 && n >= 0 && byArray.length - n >= n2) {
            if (this.currentEntry.compressionMethod == 0) {
                int n3;
                int n4 = (int)this.currentEntry.size;
                if (this.inRead >= n4) {
                    return -1;
                }
                if (this.lastRead >= this.len) {
                    this.lastRead = 0;
                    this.len = this.in.read(this.buf);
                    if (this.len == -1) {
                        return -1;
                    }
                    this.entryIn += this.len;
                }
                int n5 = n3 = n2 > this.len ? this.len - this.lastRead : n2;
                if (n4 - this.inRead < n3) {
                    n3 = n4 - this.inRead;
                }
                System.arraycopy((Object)this.buf, this.lastRead, (Object)byArray, n, n3);
                this.lastRead += n3;
                this.inRead += n3;
                this.crc.update(byArray, n, n3);
                return n3;
            }
            if (this.inf.needsInput()) {
                this.fill();
                if (this.len > 0) {
                    this.entryIn += this.len;
                }
            }
            int n6 = 0;
            try {
                n6 = this.inf.inflate(byArray, n, n2);
            }
            catch (DataFormatException dataFormatException) {
                throw new ZipException(dataFormatException.getMessage());
            }
            if (n6 == 0 && this.inf.finished()) {
                return -1;
            }
            this.crc.update(byArray, n, n6);
            return n6;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public long skip(long l) {
        if (l >= 0L) {
            long l2 = 0L;
            byte[] byArray = new byte[1024];
            while (l2 != l) {
                long l3 = l - l2;
                int n = this.read(byArray, 0, (int)((long)byArray.length > l3 ? l3 : (long)byArray.length));
                if (n == -1) {
                    return l2;
                }
                l2 += (long)n;
            }
            return l2;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int available() {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.currentEntry == null) {
            return 1;
        }
        if (this.currentEntry.compressionMethod == 0 ? (long)this.inRead >= this.currentEntry.size : this.inf.finished()) {
            return 0;
        }
        return 1;
    }

    protected ZipEntry createZipEntry(String string) {
        return new ZipEntry(string);
    }

    private int getShort(byte[] byArray, int n) {
        return byArray[n] & 0xFF | (byArray[n + 1] & 0xFF) << 8;
    }

    private long getLong(byte[] byArray, int n) {
        long l = 0L;
        l |= (long)(byArray[n] & 0xFF);
        l |= (long)((byArray[n + 1] & 0xFF) << 8);
        l |= (long)((byArray[n + 2] & 0xFF) << 16);
        return l |= (long)(byArray[n + 3] & 0xFF) << 24;
    }
}

