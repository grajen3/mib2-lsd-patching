/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.io.NativeCharacterConverter;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.AccessController;

public class OutputStreamWriter
extends Writer {
    private OutputStream out;
    CharacterConverter converter;
    private byte[] buf = new byte[8192];
    private int pos;

    public OutputStreamWriter(OutputStream outputStream) {
        super(outputStream);
        this.out = outputStream;
        String string = (String)AccessController.doPrivileged(new PriviAction("file.encoding", "ISO8859_1"));
        this.converter = CharacterConverter.getDefaultConverter(string);
    }

    public OutputStreamWriter(OutputStream outputStream, String string) {
        super(outputStream);
        this.out = outputStream;
        this.converter = CharacterConverter.getConverter(string);
        if (this.converter == null) {
            throw new UnsupportedEncodingException(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                byte[] byArray = this.converter.getClosingBytes();
                if (byArray.length > 0) {
                    this.writeBytes(byArray);
                }
                this.flush();
                this.out.flush();
                this.out.close();
                this.buf = null;
                this.converter = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void flush() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                if (this.pos > 0) {
                    this.out.write(this.buf, 0, this.pos);
                }
            } else {
                throw new IOException(Msg.getString("K0073"));
            }
            this.out.flush();
            this.pos = 0;
        }
    }

    public String getEncoding() {
        if (this.converter == null) {
            return null;
        }
        if (this.converter instanceof NativeCharacterConverter) {
            return ((NativeCharacterConverter)this.converter).getJavaEncoding();
        }
        String string = super.getClass().getName();
        int n = string.indexOf(95);
        if (n < 0) {
            return "ISO8859_1";
        }
        return string.substring(n + 1);
    }

    private boolean isOpen() {
        return this.converter != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(char[] cArray, int n, int n2) {
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            Object object = this.lock;
            synchronized (object) {
                if (!this.isOpen()) {
                    throw new IOException(Msg.getString("K0073"));
                }
                byte[] byArray = this.converter.convert(cArray, n, n2);
                this.writeBytes(byArray);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void writeBytes(byte[] byArray) {
        if (this.pos + byArray.length > this.buf.length) {
            this.out.write(this.buf, 0, this.pos);
            this.out.write(byArray, 0, byArray.length);
            this.out.flush();
            this.pos = 0;
            return;
        }
        System.arraycopy((Object)byArray, 0, (Object)this.buf, this.pos, byArray.length);
        this.pos += byArray.length;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int n) {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                char[] cArray = new char[]{(char)n};
                byte[] byArray = this.converter.convert(cArray, 0, 1);
                if (this.pos + byArray.length > this.buf.length) {
                    this.out.write(this.buf, 0, this.pos);
                    this.out.write(byArray, 0, byArray.length);
                    this.out.flush();
                    this.pos = 0;
                    return;
                }
                System.arraycopy((Object)byArray, 0, (Object)this.buf, this.pos, byArray.length);
                this.pos += byArray.length;
            } else {
                throw new IOException(Msg.getString("K0073"));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(String string, int n, int n2) {
        if (n >= 0 && n <= string.length() && n2 >= 0 && n2 <= string.length() - n) {
            Object object = this.lock;
            synchronized (object) {
                char[] cArray = new char[n2];
                string.getChars(n, n + n2, cArray, 0);
                this.write(cArray, 0, cArray.length);
            }
        } else {
            throw new StringIndexOutOfBoundsException();
        }
    }
}

