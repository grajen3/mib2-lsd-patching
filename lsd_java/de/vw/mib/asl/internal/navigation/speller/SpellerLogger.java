/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.speller;

public interface SpellerLogger {
    default public void trace(String string) {
    }

    default public void warn(String string) {
    }

    default public void error(String string) {
    }

    default public void traceDatapool(String string) {
    }

    default public void traceSysevent(String string) {
    }

    default public void traceDownevent(String string) {
    }
}

