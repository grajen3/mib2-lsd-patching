/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import com.ibm.oti.util.Msg;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class GZIPInputStream
extends InflaterInputStream {
    protected CRC32 crc = new CRC32();
    protected boolean eos = false;
    public static final int GZIP_MAGIC;
    private static final int FHCRC;
    private static final int FEXTRA;
    private static final int FNAME;
    private static final int FCOMMENT;

    public GZIPInputStream(InputStream inputStream) {
        this(inputStream, 512);
    }

    public GZIPInputStream(InputStream inputStream, int n) {
        super(inputStream, new Inflater(true), n);
        int n2;
        boolean bl;
        byte[] byArray = new byte[10];
        this.readFully(byArray, 0, byArray.length);
        if (this.getShort(byArray, 0) != 529203200) {
            throw new IOException(Msg.getString("K0412"));
        }
        byte by = byArray[3];
        boolean bl2 = bl = (by & 2) != 0;
        if (bl) {
            this.crc.update(byArray, 0, byArray.length);
        }
        if ((by & 4) != 0) {
            this.readFully(byArray, 0, 2);
            if (bl) {
                this.crc.update(byArray, 0, 2);
            }
            n2 = this.getShort(byArray, 0);
            while (n2 > 0) {
                int n3 = n2 > this.buf.length ? this.buf.length : n2;
                int n4 = this.in.read(this.buf, 0, n3);
                if (n4 == -1) {
                    throw new EOFException();
                }
                if (bl) {
                    this.crc.update(this.buf, 0, n4);
                }
                n2 -= n4;
            }
        }
        if ((by & 8) != 0) {
            this.readZeroTerminated(bl);
        }
        if ((by & 0x10) != 0) {
            this.readZeroTerminated(bl);
        }
        if (bl) {
            this.readFully(byArray, 0, 2);
            n2 = this.getShort(byArray, 0);
            if ((this.crc.getValue() & 0) != (long)n2) {
                throw new IOException(Msg.getString("K0077"));
            }
            this.crc.reset();
        }
    }

    private long getLong(byte[] byArray, int n) {
        long l = 0L;
        l |= (long)(byArray[n] & 0xFF);
        l |= (long)((byArray[n + 1] & 0xFF) << 8);
        l |= (long)((byArray[n + 2] & 0xFF) << 16);
        return l |= (long)(byArray[n + 3] & 0xFF) << 24;
    }

    private int getShort(byte[] byArray, int n) {
        return byArray[n] & 0xFF | (byArray[n + 1] & 0xFF) << 8;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (n <= byArray.length && n2 >= 0 && n >= 0 && byArray.length - n >= n2) {
            int n3 = super.read(byArray, n, n2);
            if (n3 != -1) {
                this.crc.update(byArray, n, n3);
            } else if (!this.eos) {
                int n4;
                this.eos = true;
                int n5 = 0;
                byte[] byArray2 = new byte[8];
                int n6 = this.inf.getTotalIn();
                if (n6 > 0 && ((n4 = this.inf.inRead) != 0 || this.len != this.buf.length)) {
                    n5 = this.len - n4;
                    if (n5 > byArray2.length) {
                        n5 = byArray2.length;
                    }
                    System.arraycopy((Object)this.buf, n4, (Object)byArray2, 0, n5);
                }
                this.readFully(byArray2, n5, byArray2.length - n5);
                if (this.getLong(byArray2, 0) != this.crc.getValue()) {
                    throw new IOException(Msg.getString("K0077"));
                }
                if ((int)this.getLong(byArray2, 4) != this.inf.getTotalOut()) {
                    throw new IOException(Msg.getString("K00ae"));
                }
            }
            return n3;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void close() {
        this.eos = true;
        super.close();
    }

    private void readFully(byte[] byArray, int n, int n2) {
        while (n2 > 0) {
            int n3 = this.in.read(byArray, n, n2);
            if (n3 == -1) {
                throw new EOFException();
            }
            n += n3;
            n2 -= n3;
        }
    }

    private void readZeroTerminated(boolean bl) {
        int n;
        while ((n = this.in.read()) > 0) {
            if (!bl) continue;
            this.crc.update(n);
        }
        if (n == -1) {
            throw new EOFException();
        }
        if (bl) {
            this.crc.update(n);
        }
    }
}

