/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.io.CharBuffer;
import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.io.NativeCharacterConverter;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.security.AccessController;

public class InputStreamReader
extends Reader {
    private InputStream in;
    CharacterConverter converter;
    private byte[] bytes = new byte[8192];
    private int pos;
    private int count;
    private int charsAvailable;

    public InputStreamReader(InputStream inputStream) {
        super(inputStream);
        this.in = inputStream;
        String string = (String)AccessController.doPrivileged(new PriviAction("file.encoding", "ISO8859_1"));
        this.converter = CharacterConverter.getDefaultConverter(string);
    }

    public InputStreamReader(InputStream inputStream, String string) {
        super(inputStream);
        this.in = inputStream;
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
            if (this.bytes != null) {
                this.in.close();
                this.converter = null;
                this.in = null;
                this.bytes = null;
            }
        }
    }

    private int fillbuf() {
        int n;
        if (this.count > 0 && this.pos > 0) {
            this.count -= this.pos;
            if (this.count > 0) {
                System.arraycopy((Object)this.bytes, this.pos, (Object)this.bytes, 0, this.count);
            }
            this.pos = 0;
        }
        if ((n = this.in.read(this.bytes, this.count, this.bytes.length - this.count)) >= 0) {
            this.count += n;
            this.charsAvailable = 0;
        } else if (this.count > 0) {
            throw new CharConversionException(Msg.getString("K01a0"));
        }
        return n;
    }

    private int convert(char[] cArray, int n, int n2) {
        int n3;
        CharBuffer charBuffer = new CharBuffer(cArray, n, n2);
        this.pos = n3 = this.converter.convert(this.bytes, this.pos, this.count - this.pos, charBuffer);
        if (n3 != -1) {
            return charBuffer.getPos() - n;
        }
        throw new CharConversionException();
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public int read() {
        Object object = this.lock;
        synchronized (object) {
            if (this.bytes == null) {
                throw new IOException(Msg.getString("K0070"));
            }
            char[] cArray = new char[1];
            int n = 0;
            if (this.pos < this.count) {
                n = this.convert(cArray, 0, 1);
            }
            while (true) {
                if (n != 0) {
                    return cArray[0];
                }
                int n2 = this.fillbuf();
                if (n2 == -1) {
                    return -1;
                }
                n = this.convert(cArray, 0, 1);
            }
        }
    }

    @Override
    public int read(char[] cArray, int n, int n2) {
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            int n3 = 0;
            int n4 = n;
            Object object = this.lock;
            synchronized (object) {
                if (this.bytes != null) {
                    int n5 = 0;
                    int n6 = 1;
                    if (this.pos < this.count) {
                        n5 = this.convert(cArray, n, n2);
                        n3 += n5;
                        n6 = this.in.available();
                    }
                    while (n3 < n2) {
                        n4 += n5;
                        if (n3 > 0 && n6 <= 0 && (n6 = this.in.available()) <= 0) break;
                        int n7 = this.fillbuf();
                        if (n7 == -1) {
                            return n3 == 0 ? -1 : n3;
                        }
                        n6 -= n7;
                        n5 = this.convert(cArray, n4, n2 - n3);
                        n3 += n5;
                    }
                    return n3;
                }
                throw new IOException(Msg.getString("K0070"));
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean ready() {
        Object object = this.lock;
        synchronized (object) {
            if (this.bytes != null) {
                return this.pos < this.count || this.in.available() > 0;
            }
            throw new IOException(Msg.getString("K0070"));
        }
    }
}

