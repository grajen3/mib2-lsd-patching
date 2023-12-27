/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.AccessController;

public class PrintStream
extends FilterOutputStream {
    private Object lock = new Object();
    boolean ioError = false;
    boolean autoflush = false;
    private String encoding;
    private final String lineSeparator = (String)AccessController.doPrivileged(new PriviAction("line.separator"));

    public PrintStream(OutputStream outputStream) {
        super(outputStream);
        if (outputStream == null) {
            throw new NullPointerException();
        }
    }

    public PrintStream(OutputStream outputStream, boolean bl) {
        super(outputStream);
        if (outputStream == null) {
            throw new NullPointerException();
        }
        this.autoflush = bl;
    }

    public PrintStream(OutputStream outputStream, boolean bl, String string) {
        super(outputStream);
        if (outputStream == null) {
            throw new NullPointerException();
        }
        this.autoflush = bl;
        if (CharacterConverter.getConverter(string) == null) {
            throw new UnsupportedEncodingException(string);
        }
        this.encoding = string;
    }

    public boolean checkError() {
        if (this.out != null) {
            this.flush();
        }
        return this.ioError;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            this.flush();
            if (this.out != null) {
                try {
                    this.out.close();
                    this.out = null;
                }
                catch (IOException iOException) {
                    this.setError();
                }
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
            if (this.out != null) {
                try {
                    this.out.flush();
                    return;
                }
                catch (IOException iOException) {}
            }
        }
        this.setError();
    }

    private void newline() {
        this.print(this.lineSeparator);
    }

    public void print(char[] cArray) {
        this.print(new String(cArray, 0, cArray.length));
    }

    public void print(char c2) {
        this.print(String.valueOf(c2));
    }

    public void print(double d2) {
        this.print(String.valueOf(d2));
    }

    public void print(float f2) {
        this.print(String.valueOf(f2));
    }

    public void print(int n) {
        this.print(String.valueOf(n));
    }

    public void print(long l) {
        this.print(String.valueOf(l));
    }

    public void print(Object object) {
        this.print(String.valueOf(object));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void print(String string) {
        Object object = this.lock;
        synchronized (object) {
            if (this.out == null) {
                this.setError();
                return;
            }
            if (string == null) {
                this.print("null");
                return;
            }
            try {
                if (this.encoding == null) {
                    this.write(string.getBytes());
                } else {
                    this.write(string.getBytes(this.encoding));
                }
            }
            catch (IOException iOException) {
                this.setError();
            }
        }
    }

    public void print(boolean bl) {
        this.print(String.valueOf(bl));
    }

    public void println() {
        this.newline();
    }

    public void println(char[] cArray) {
        this.println(new String(cArray, 0, cArray.length));
    }

    public void println(char c2) {
        this.println(String.valueOf(c2));
    }

    public void println(double d2) {
        this.println(String.valueOf(d2));
    }

    public void println(float f2) {
        this.println(String.valueOf(f2));
    }

    public void println(int n) {
        this.println(String.valueOf(n));
    }

    public void println(long l) {
        this.println(String.valueOf(l));
    }

    public void println(Object object) {
        this.println(String.valueOf(object));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void println(String string) {
        Object object = this.lock;
        synchronized (object) {
            this.print(string);
            this.newline();
        }
    }

    public void println(boolean bl) {
        this.println(String.valueOf(bl));
    }

    protected void setError() {
        this.ioError = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (byArray != null) {
            if (n >= 0 && n <= byArray.length && n2 >= 0 && n2 <= byArray.length - n) {
                Object object = this.lock;
                synchronized (object) {
                    if (this.out == null) {
                        this.setError();
                        return;
                    }
                    try {
                        this.out.write(byArray, n, n2);
                        if (this.autoflush) {
                            this.flush();
                        }
                    }
                    catch (IOException iOException) {
                        this.setError();
                    }
                }
            }
            throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
        }
        throw new NullPointerException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int n) {
        Object object = this.lock;
        synchronized (object) {
            if (this.out == null) {
                this.setError();
                return;
            }
            try {
                this.out.write(n);
                if (this.autoflush && (n & 0xFF) == 10) {
                    this.flush();
                }
            }
            catch (IOException iOException) {
                this.setError();
            }
        }
    }
}

