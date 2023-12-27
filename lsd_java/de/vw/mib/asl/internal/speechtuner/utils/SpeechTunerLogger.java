/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils;

public interface SpeechTunerLogger {
    default public boolean isTraceEnabled() {
    }

    default public void trace(String string) {
    }

    default public void fatal(String string) {
    }

    default public void error(String string) {
    }

    default public void warn(String string) {
    }
}

