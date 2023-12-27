/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

public class Deflater {
    public static final int BEST_COMPRESSION;
    public static final int BEST_SPEED;
    public static final int DEFAULT_COMPRESSION;
    public static final int DEFAULT_STRATEGY;
    public static final int DEFLATED;
    public static final int FILTERED;
    public static final int HUFFMAN_ONLY;
    public static final int NO_COMPRESSION;
    private static final int Z_NO_FLUSH;
    private static final int Z_FINISH;
    private int flushParm = 0;
    private boolean noHeader = false;
    private boolean finished = false;
    int compressLevel = -1;
    int strategy = 0;
    long streamHandle = -1L;
    byte[] inputBuffer;
    int inRead = 0;
    int inLength = 0;

    static {
        Deflater.oneTimeInitialization();
    }

    private static native void oneTimeInitialization() {
    }

    public int deflate(byte[] byArray) {
        return this.deflate(byArray, 0, byArray.length);
    }

    public synchronized int deflate(byte[] byArray, int n, int n2) {
        if (this.streamHandle == -1L) {
            throw new IllegalStateException();
        }
        if (n <= byArray.length && n2 >= 0 && n >= 0 && byArray.length - n >= n2) {
            return this.deflateImpl(byArray, n, n2, this.streamHandle, this.flushParm);
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private synchronized native int deflateImpl(byte[] byArray, int n, int n2, long l, int n3) {
    }

    private synchronized native void endImpl(long l) {
    }

    public synchronized void end() {
        if (this.streamHandle != -1L) {
            this.endImpl(this.streamHandle);
            this.inputBuffer = null;
            this.streamHandle = -1L;
        }
    }

    protected void finalize() {
        this.end();
    }

    public synchronized void finish() {
        this.flushParm = 4;
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

    public boolean needsInput() {
        if (this.inputBuffer == null) {
            return true;
        }
        return this.inRead == this.inLength;
    }

    public synchronized void reset() {
        if (this.streamHandle == -1L) {
            throw new NullPointerException();
        }
        this.flushParm = 0;
        this.finished = false;
        this.resetImpl(this.streamHandle);
        this.inputBuffer = null;
    }

    private synchronized native void resetImpl(long l) {
    }

    public void setDictionary(byte[] byArray) {
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

    public void setInput(byte[] byArray) {
        this.setInput(byArray, 0, byArray.length);
    }

    public synchronized void setInput(byte[] byArray, int n, int n2) {
        if (this.streamHandle == -1L) {
            throw new IllegalStateException();
        }
        if (n <= byArray.length && n2 >= 0 && n >= 0 && byArray.length - n >= n2) {
            this.inLength = n2;
            this.inRead = 0;
            if (this.inputBuffer == null) {
                this.setLevelsImpl(this.compressLevel, this.strategy, this.streamHandle);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.inputBuffer = byArray;
        this.setInputImpl(byArray, n, n2, this.streamHandle);
    }

    private synchronized native void setLevelsImpl(int n, int n2, long l) {
    }

    private synchronized native void setInputImpl(byte[] byArray, int n, int n2, long l) {
    }

    public synchronized void setLevel(int n) {
        if (n < -1 || n > 9) {
            throw new IllegalArgumentException();
        }
        if (this.inputBuffer != null) {
            throw new IllegalStateException();
        }
        this.compressLevel = n;
    }

    public synchronized void setStrategy(int n) {
        if (n < 0 || n > 2) {
            throw new IllegalArgumentException();
        }
        if (this.inputBuffer != null) {
            throw new IllegalStateException();
        }
        this.strategy = n;
    }

    public Deflater() {
        this(-1, false);
    }

    public Deflater(int n, boolean bl) {
        if (n < -1 || n > 9) {
            throw new IllegalArgumentException();
        }
        this.compressLevel = n;
        this.noHeader = bl;
        this.streamHandle = this.createStream(this.compressLevel, this.strategy, bl);
    }

    public Deflater(int n) {
        this(n, false);
    }

    private native long createStream(int n, int n2, boolean bl) {
    }
}

