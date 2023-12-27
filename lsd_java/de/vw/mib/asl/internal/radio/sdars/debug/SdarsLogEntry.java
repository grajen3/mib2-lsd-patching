/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.debug;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public final class SdarsLogEntry
implements LogMessage {
    private static final int P_LOG__TIME;
    private static final int P_LOG__KEY;
    private static final int P_LOG__TEXT;
    private IAslPool mPool;
    private long mTime = ServiceManager.timerManager.getSystemTimeMillis();
    private String mKey;
    private StringBuffer mBuffer;

    public SdarsLogEntry(IAslPool iAslPool, String string) {
        this.mPool = iAslPool;
        this.mKey = string;
        this.mBuffer = new StringBuffer(100);
    }

    @Override
    public LogMessage append(String string) {
        this.mBuffer.append(string);
        return this;
    }

    @Override
    public LogMessage append(int n) {
        this.mBuffer.append(n);
        return this;
    }

    public LogMessage append(short s) {
        this.mBuffer.append(s);
        return this;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getText() {
        return this.mBuffer.toString();
    }

    @Override
    public void log() {
        IAslPool iAslPool = this.mPool;
        if (iAslPool != null) {
            iAslPool.setObject(124, this);
        }
    }

    public String toString() {
        return this.mBuffer.toString();
    }

    @Override
    public LogMessage append(boolean bl) {
        this.mBuffer.append(bl);
        return this;
    }

    @Override
    public LogMessage append(char c2) {
        this.mBuffer.append(c2);
        return this;
    }

    @Override
    public LogMessage append(double d2) {
        this.mBuffer.append(d2);
        return this;
    }

    @Override
    public LogMessage append(float f2) {
        this.mBuffer.append(f2);
        return this;
    }

    @Override
    public LogMessage append(int n, int n2) {
        return this;
    }

    @Override
    public LogMessage append(Loggable loggable) {
        return this;
    }

    @Override
    public LogMessage append(long l) {
        this.mBuffer.append(l);
        return this;
    }

    @Override
    public LogMessage append(Object object) {
        this.mBuffer.append(object.toString());
        return this;
    }

    @Override
    public void appendMessageFinal() {
    }

    @Override
    public LogMessage attachThrowable(Throwable throwable) {
        return this;
    }

    @Override
    public int getClassifier() {
        return SatDb.getInstance().getMainTarget().getClassifier();
    }

    @Override
    public byte[] getContent() {
        return null;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    @Override
    public int getThreadId() {
        return 0;
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }

    @Override
    public long getTime() {
        return this.mTime;
    }

    public void toEvent(EventGeneric eventGeneric) {
        eventGeneric.setLong(0, this.mTime);
        eventGeneric.setString(1, this.mKey);
        eventGeneric.setString(2, this.getText());
    }
}

