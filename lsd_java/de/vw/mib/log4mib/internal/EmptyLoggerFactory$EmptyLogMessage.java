/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public class EmptyLoggerFactory$EmptyLogMessage
implements LogMessage {
    public String getText() {
        return null;
    }

    @Override
    public LogMessage append(boolean bl) {
        return this;
    }

    @Override
    public LogMessage append(char c2) {
        return this;
    }

    @Override
    public LogMessage append(double d2) {
        return this;
    }

    @Override
    public LogMessage append(float f2) {
        return this;
    }

    @Override
    public LogMessage append(int n) {
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
        return this;
    }

    @Override
    public LogMessage append(Object object) {
        return this;
    }

    @Override
    public LogMessage append(String string) {
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
        return 0;
    }

    @Override
    public byte[] getContent() {
        return new byte[0];
    }

    public byte[] getData() {
        return new byte[0];
    }

    @Override
    public int getLevel() {
        return 0;
    }

    public int getSize() {
        return 0;
    }

    @Override
    public int getSubClassifier() {
        return 0;
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
        return 0L;
    }

    public short getType() {
        return 0;
    }

    @Override
    public void log() {
    }
}

