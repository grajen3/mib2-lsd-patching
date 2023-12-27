/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStream
extends InputStream {
    Enumeration e;
    InputStream in;

    public SequenceInputStream(InputStream inputStream, InputStream inputStream2) {
        if (inputStream == null || inputStream2 == null) {
            throw new NullPointerException();
        }
        Vector vector = new Vector(1);
        vector.addElement(inputStream2);
        this.e = vector.elements();
        this.in = inputStream;
    }

    public SequenceInputStream(Enumeration enumeration) {
        this.e = enumeration;
        if (enumeration.hasMoreElements()) {
            this.in = (InputStream)enumeration.nextElement();
            if (this.in == null) {
                throw new NullPointerException();
            }
        }
    }

    @Override
    public int available() {
        if (this.e != null && this.in != null) {
            return this.in.available();
        }
        return 0;
    }

    @Override
    public void close() {
        if (this.e != null) {
            while (this.in != null) {
                this.nextStream();
            }
        } else {
            throw new IOException(Msg.getString("K00b7"));
        }
        this.e = null;
    }

    private void nextStream() {
        if (this.in != null) {
            this.in.close();
        }
        if (this.e.hasMoreElements()) {
            this.in = (InputStream)this.e.nextElement();
            if (this.in == null) {
                throw new NullPointerException();
            }
        } else {
            this.in = null;
        }
    }

    @Override
    public int read() {
        while (this.in != null) {
            int n = this.in.read();
            if (n >= 0) {
                return n;
            }
            this.nextStream();
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (byArray == null) {
            if (n < 0 || n2 < 0) throw new ArrayIndexOutOfBoundsException();
            while (this.in != null) {
                long l = this.in.skip(n2);
                if (l >= 0L) {
                    return (int)l;
                }
                this.nextStream();
            }
            return -1;
        } else {
            if (n < 0 || n > byArray.length || n2 < 0 || n2 > byArray.length - n) throw new ArrayIndexOutOfBoundsException();
            while (this.in != null) {
                int n3 = this.in.read(byArray, n, n2);
                if (n3 >= 0) {
                    return n3;
                }
                this.nextStream();
            }
        }
        return -1;
    }
}

