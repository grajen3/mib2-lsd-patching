/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.BufferedReader;
import java.io.Reader;

public class LineNumberReader
extends BufferedReader {
    private int lineNumber = 0;
    private int markedLineNumber = -1;
    private boolean lastWasCR = false;
    private boolean markedLastWasCR;

    public LineNumberReader(Reader reader) {
        super(reader);
    }

    public LineNumberReader(Reader reader, int n) {
        super(reader, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getLineNumber() {
        Object object = this.lock;
        synchronized (object) {
            return this.lineNumber;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void mark(int n) {
        Object object = this.lock;
        synchronized (object) {
            super.mark(n);
            this.markedLineNumber = this.lineNumber;
            this.markedLastWasCR = this.lastWasCR;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read() {
        Object object = this.lock;
        synchronized (object) {
            int n = super.read();
            if (n == 10 && this.lastWasCR) {
                n = super.read();
            }
            this.lastWasCR = false;
            switch (n) {
                case 13: {
                    n = 10;
                    this.lastWasCR = true;
                }
                case 10: {
                    ++this.lineNumber;
                }
            }
            return n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read(char[] cArray, int n, int n2) {
        Object object = this.lock;
        synchronized (object) {
            int n3;
            block10: {
                n3 = super.read(cArray, n, n2);
                if (n3 != -1) break block10;
                return -1;
            }
            int n4 = 0;
            while (n4 < n3) {
                char c2 = cArray[n + n4];
                if (c2 == '\r') {
                    ++this.lineNumber;
                    this.lastWasCR = true;
                } else if (c2 == '\n') {
                    if (!this.lastWasCR) {
                        ++this.lineNumber;
                    }
                    this.lastWasCR = false;
                } else {
                    this.lastWasCR = false;
                }
                ++n4;
            }
            return n3;
        }
    }

    @Override
    public String readLine() {
        Object object = this.lock;
        synchronized (object) {
            StringBuffer stringBuffer = new StringBuffer(80);
            while (true) {
                int n;
                if ((n = this.read()) == -1) {
                    return stringBuffer.length() != 0 ? stringBuffer.toString() : null;
                }
                if (n == 10) {
                    return stringBuffer.toString();
                }
                stringBuffer.append((char)n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reset() {
        Object object = this.lock;
        synchronized (object) {
            super.reset();
            this.lineNumber = this.markedLineNumber;
            this.lastWasCR = this.markedLastWasCR;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setLineNumber(int n) {
        Object object = this.lock;
        synchronized (object) {
            this.lineNumber = n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long skip(long l) {
        if (l >= 0L) {
            Object object = this.lock;
            synchronized (object) {
                int n = 0;
                while ((long)n < l) {
                    if (this.read() == -1) {
                        return n;
                    }
                    ++n;
                }
                return l;
            }
        }
        throw new IllegalArgumentException();
    }
}

