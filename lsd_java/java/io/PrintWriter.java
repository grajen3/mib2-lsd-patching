/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.PriviAction;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.AccessController;

public class PrintWriter
extends Writer {
    protected Writer out;
    boolean ioError = false;
    boolean autoflush = false;
    private final String lineSeparator = (String)AccessController.doPrivileged(new PriviAction("line.separator"));

    public PrintWriter(OutputStream outputStream) {
        this(new OutputStreamWriter(outputStream), false);
    }

    public PrintWriter(OutputStream outputStream, boolean bl) {
        this(new OutputStreamWriter(outputStream), bl);
    }

    public PrintWriter(Writer writer) {
        this(writer, false);
    }

    public PrintWriter(Writer writer, boolean bl) {
        super(writer);
        this.autoflush = bl;
        this.out = writer;
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
            if (this.out != null) {
                try {
                    this.out.close();
                }
                catch (IOException iOException) {
                    this.setError();
                }
                this.out = null;
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
                }
                catch (IOException iOException) {
                    this.setError();
                }
            } else {
                this.setError();
            }
        }
    }

    private void newline() {
        this.print(this.lineSeparator);
        if (this.autoflush) {
            this.flush();
        }
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
            if (this.out != null) {
                try {
                    this.out.write(string != null ? string : String.valueOf(null));
                }
                catch (IOException iOException) {
                    this.setError();
                }
            } else {
                this.setError();
            }
        }
    }

    public void print(boolean bl) {
        this.print(String.valueOf(bl));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void println() {
        Object object = this.lock;
        synchronized (object) {
            this.newline();
        }
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setError() {
        Object object = this.lock;
        synchronized (object) {
            this.ioError = true;
        }
    }

    @Override
    public void write(char[] cArray) {
        this.write(cArray, 0, cArray.length);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(char[] cArray, int n, int n2) {
        Object object = this.lock;
        synchronized (object) {
            if (this.out != null) {
                try {
                    this.out.write(cArray, n, n2);
                }
                catch (IOException iOException) {
                    this.setError();
                }
            } else {
                this.setError();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int n) {
        Object object = this.lock;
        synchronized (object) {
            this.write(new char[]{(char)n}, 0, 1);
        }
    }

    @Override
    public void write(String string) {
        this.print(string);
    }

    @Override
    public void write(String string, int n, int n2) {
        this.print(string.substring(n, n + n2));
    }
}

