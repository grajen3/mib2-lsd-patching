/*
 * Decompiled with CFR 0.152.
 */
package java.io;

public abstract class Writer {
    protected Object lock;

    protected Writer() {
        this.lock = this;
    }

    protected Writer(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.lock = object;
    }

    public abstract void close() {
    }

    public abstract void flush() {
    }

    public void write(char[] cArray) {
        this.write(cArray, 0, cArray.length);
    }

    public abstract void write(char[] cArray, int n, int n2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(int n) {
        Object object = this.lock;
        synchronized (object) {
            char[] cArray = new char[]{(char)n};
            this.write(cArray);
        }
    }

    public void write(String string) {
        char[] cArray = new char[string.length()];
        string.getChars(0, cArray.length, cArray, 0);
        this.write(cArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(String string, int n, int n2) {
        if (n2 >= 0) {
            char[] cArray = new char[n2];
            string.getChars(n, n + n2, cArray, 0);
            Object object = this.lock;
            synchronized (object) {
                this.write(cArray);
            }
        } else {
            throw new StringIndexOutOfBoundsException();
        }
    }
}

