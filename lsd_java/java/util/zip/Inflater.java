/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import com.ibm.oti.util.Msg;
import java.util.zip.DataFormatException;

public class Inflater {
    private boolean finished = false;
    private boolean needsDictionary = false;
    private boolean noHeader = false;
    private long streamHandle = -1L;
    private byte[] inputBuffer = null;
    int inRead = 0;
    int inLength = 0;

    static {
        Inflater.oneTimeInitialization();
    }

    private static native void oneTimeInitialization() {
    }

    public synchronized void end() {
        if (this.streamHandle != -1L) {
            this.endImpl(this.streamHandle);
            this.inRead = 0;
            this.inputBuffer = null;
            this.inLength = 0;
            this.streamHandle = -1L;
        }
    }

    private synchronized native void endImpl(long l) {
    }

    protected void finalize() {
        this.end();
    }

    public synchronized boolean finished() {
        return this.finished;
    }

    public synchronized int getAdler() {
        if (this.streamHandle == -1L) {
            throw new IllegalStateException();
        }
        return this.getAdlerImpl(this.streamHandle);
    }

    private synchronized native int getAdlerImpl(long l) {
    }

    public synchronized int getRemaining() {
        return this.inLength - this.inRead;
    }

    public synchronized int getTotalIn() {
        if (this.streamHandle == -1L) {
            throw new IllegalStateException();
        }
        return this.getTotalInImpl(this.streamHandle);
    }

    private synchronized native int getTotalInImpl(long l) {
    }

    public synchronized int getTotalOut() {
        if (this.streamHandle == -1L) {
            throw new IllegalStateException();
        }
        return this.getTotalOutImpl(this.streamHandle);
    }

    private synchronized native int getTotalOutImpl(long l) {
    }

    public int inflate(byte[] byArray) {
        return this.inflate(byArray, 0, byArray.length);
    }

    public synchronized int inflate(byte[] byArray, int n, int n2) {
        if (n <= byArray.length && n2 >= 0 && n >= 0 && byArray.length - n >= n2) {
            if (this.streamHandle == -1L) {
                throw new IllegalStateException();
            }
            boolean bl = this.needsDictionary;
            this.needsDictionary = false;
            int n3 = this.inflateImpl(byArray, n, n2, this.streamHandle);
            if (this.needsDictionary && bl) {
                throw new DataFormatException(Msg.getString("K0324"));
            }
            return n3;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private synchronized native int inflateImpl(byte[] byArray, int n, int n2, long l) {
    }

    public Inflater() {
        this(false);
    }

    public Inflater(boolean bl) {
        this.noHeader = bl;
        this.streamHandle = this.createStream(bl);
    }

    public synchronized boolean needsDictionary() {
        if (this.inputBuffer == null) {
            throw new IllegalStateException();
        }
        return this.needsDictionary;
    }

    public synchronized boolean needsInput() {
        return this.inRead == this.inLength;
    }

    public synchronized void reset() {
        if (this.streamHandle == -1L) {
            throw new NullPointerException();
        }
        this.inputBuffer = null;
        this.finished = false;
        this.needsDictionary = false;
        this.inRead = 0;
        this.inLength = 0;
        this.resetImpl(this.streamHandle);
    }

    private synchronized native void resetImpl(long l) {
    }

    public synchronized void setDictionary(byte[] byArray) {
        this.setDictionary(byArray, 0, byArray.length);
    }

    public synchronized void setDictionary(byte[] byArray, int n, int n2) {
        if (this.streamHandle == -1L) {
            throw new IllegalStateException();
        }
        if (n > byArray.length || n2 < 0 || n < 0 || byArray.length - n < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.setDictionaryImpl(byArray, n, n2, this.streamHandle);
    }

    private synchronized native void setDictionaryImpl(byte[] byArray, int n, int n2, long l) {
    }

    public synchronized void setInput(byte[] byArray) {
        this.setInput(byArray, 0, byArray.length);
    }

    public synchronized void setInput(byte[] byArray, int n, int n2) {
        if (this.streamHandle == -1L) {
            throw new IllegalStateException();
        }
        if (n > byArray.length || n2 < 0 || n < 0 || byArray.length - n < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.inputBuffer = byArray;
        this.inRead = 0;
        this.inLength = n2;
        this.setInputImpl(byArray, n, n2, this.streamHandle);
    }

    private synchronized native void setInputImpl(byte[] byArray, int n, int n2, long l) {
    }

    private native long createStream(boolean bl) {
    }
}

