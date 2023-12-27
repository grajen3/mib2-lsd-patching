/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

import de.vw.mib.log4mib.Loggable;

public interface LogMessage {
    default public LogMessage append(boolean bl) {
    }

    default public LogMessage append(char c2) {
    }

    default public LogMessage append(double d2) {
    }

    default public LogMessage append(float f2) {
    }

    default public LogMessage append(int n) {
    }

    default public LogMessage append(int n, int n2) {
    }

    default public LogMessage append(Loggable loggable) {
    }

    default public LogMessage append(long l) {
    }

    default public LogMessage append(Object object) {
    }

    default public LogMessage append(String string) {
    }

    default public void appendMessageFinal() {
    }

    default public LogMessage attachThrowable(Throwable throwable) {
    }

    default public int getClassifier() {
    }

    default public byte[] getContent() {
    }

    default public int getLevel() {
    }

    default public int getSubClassifier() {
    }

    default public int getThreadId() {
    }

    default public Throwable getThrowable() {
    }

    default public long getTime() {
    }

    default public void log() {
    }
}

