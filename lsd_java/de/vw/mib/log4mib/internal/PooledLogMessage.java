/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.log4mib.internal.AbstractMessage;
import de.vw.mib.log4mib.internal.PooledLogMessage$1;
import de.vw.mib.pool.PooledObject;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.osgi.framework.BundleException;

final class PooledLogMessage
extends AbstractMessage
implements LogMessage,
PooledObject {
    private static final int MAX_LINES_OF_STACK_OVERFLOW_MESSAGE;
    public static final byte CODEC_VERSION;
    private static ByteArrayOutputStream throwableByteArrayOS;
    private int lastAppendStringLength = -1;
    int classifier;
    int level;
    int subClassifier;
    int threadId;
    Throwable throwable;
    long time;

    private static synchronized byte[] convertThrowableObjToByteArray(Throwable throwable) {
        throwableByteArrayOS.reset();
        if (throwable instanceof StackOverflowError) {
            PooledLogMessage$1 pooledLogMessage$1 = new PooledLogMessage$1(throwableByteArrayOS, true);
            throwable.printStackTrace(pooledLogMessage$1);
        } else {
            Throwable throwable2;
            PrintStream printStream = new PrintStream(throwableByteArrayOS, true);
            throwable.printStackTrace(printStream);
            if (throwable instanceof BundleException && (throwable2 = ((BundleException)throwable).getNestedException()) != null) {
                throwable2.printStackTrace(printStream);
            }
        }
        return throwableByteArrayOS.toByteArray();
    }

    PooledLogMessage() {
        this.resetMessage();
    }

    @Override
    public LogMessage append(boolean bl) {
        this.appendType((byte)1);
        this.writeBoolean(bl);
        return this;
    }

    @Override
    public LogMessage append(char c2) {
        this.appendType((byte)2);
        this.writeChar(c2);
        return this;
    }

    @Override
    public LogMessage append(double d2) {
        this.appendType((byte)3);
        this.writeDouble(d2);
        return this;
    }

    @Override
    public LogMessage append(float f2) {
        this.appendType((byte)4);
        this.writeFloat(f2);
        return this;
    }

    @Override
    public LogMessage append(int n) {
        this.appendType((byte)5);
        this.writeInt(n);
        return this;
    }

    @Override
    public LogMessage append(int n, int n2) {
        this.appendType((byte)9);
        this.writeInt(n);
        this.writeInt(n2);
        return this;
    }

    @Override
    public LogMessage append(Loggable loggable) {
        this.checkLifecyleState((byte)2);
        loggable.toString(this);
        return this;
    }

    @Override
    public LogMessage append(long l) {
        this.appendType((byte)6);
        this.writeLong(l);
        return this;
    }

    @Override
    public LogMessage append(Object object) {
        if (object == null) {
            this.appendType((byte)8);
        } else {
            this.append(object.toString());
        }
        return this;
    }

    @Override
    public LogMessage append(String string) {
        if (string == null) {
            this.appendType((byte)8);
        } else if (this.lastAppendStringLength > 0) {
            this.checkLifecyleState((byte)2);
            this.appendAnotherString(string);
        } else {
            this.appendFirstString(string);
        }
        return this;
    }

    @Override
    public void appendMessageFinal() {
        if (this.getThrowable() != null) {
            byte[] byArray = PooledLogMessage.convertThrowableObjToByteArray(this.getThrowable());
            this.appendType((byte)12);
            this.writeInt(byArray.length);
            this.write(byArray);
        }
        this.appendType((byte)13);
    }

    @Override
    public LogMessage attachThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    @Override
    public void backToPool() {
        this.resetMessage();
        this.throwable = null;
        this.checkLifecyleState((byte)1, (byte)0);
    }

    @Override
    public int getClassifier() {
        return this.classifier;
    }

    @Override
    public byte[] getContent() {
        byte[] byArray = new byte[this.count - 5];
        System.arraycopy((Object)this.buffer, 5, (Object)byArray, 0, byArray.length);
        return byArray;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getSubClassifier() {
        return this.subClassifier;
    }

    @Override
    public int getThreadId() {
        return this.threadId;
    }

    @Override
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override
    public long getTime() {
        return this.time;
    }

    @Override
    public short getType() {
        return 260;
    }

    @Override
    public void log() {
        this.appendMessageFinal();
        this.checkLifecyleState((byte)2, (byte)1);
        loggingThread.addToQueue(this);
    }

    @Override
    void dispatchMessage() {
        logWriter.dispatch(this);
    }

    void setMetaData(byte by, long l, int n, int n2, int n3, int n4, InvocationContext invocationContext) {
        this.checkLifecyleState((byte)0, (byte)2);
        this.time = l;
        this.level = n;
        this.classifier = n2;
        this.subClassifier = n3;
        this.threadId = n4;
        this.appendType((byte)0);
        this.writeByte(-2);
        this.writeByte(by);
        this.writeLong(l);
        this.writeInt(n);
        this.writeInt(n2);
        this.writeInt(n3);
        this.writeInt(n4);
        this.appendInvocationContext(invocationContext);
    }

    @Override
    boolean shouldDiscardMessage() {
        return this.level > 4;
    }

    private void appendAnotherString(String string) {
        int n = string.length();
        this.ensureCapacity(this.count + 2 * n);
        int n2 = this.count - this.lastAppendStringLength * 2 - 4;
        this.lastAppendStringLength += n;
        this.buffer[n2++] = (byte)(this.lastAppendStringLength >> 24);
        this.buffer[n2++] = (byte)(this.lastAppendStringLength >> 16);
        this.buffer[n2++] = (byte)(this.lastAppendStringLength >> 8);
        this.buffer[n2++] = (byte)this.lastAppendStringLength;
        for (int i2 = 0; i2 < n; ++i2) {
            char c2 = string.charAt(i2);
            this.buffer[this.count++] = (byte)(c2 >>> 8 & 0xFF);
            this.buffer[this.count++] = (byte)(c2 >>> 0 & 0xFF);
        }
    }

    private void appendFirstString(String string) {
        this.appendType((byte)7);
        this.writeString(string);
        this.lastAppendStringLength = string.length();
    }

    private void appendInvocationContext(InvocationContext invocationContext) {
        if (invocationContext == null) {
            return;
        }
        this.appendType((byte)14);
        this.writeInt(invocationContext.getForkBranchId());
        this.writeInt(invocationContext.getInvocationId());
        this.writeInt(invocationContext.getBranchId());
    }

    private void appendType(byte by) {
        this.checkLifecyleState((byte)2);
        this.lastAppendStringLength = 0;
        this.writeByte(by);
    }

    static {
        throwableByteArrayOS = new ByteArrayOutputStream();
    }
}

