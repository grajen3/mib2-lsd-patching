/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

public interface PersistenceLogger {
    default public void trace(String string) {
    }

    default public void info(String string) {
    }

    default public void warning(String string) {
    }

    default public void error(String string) {
    }

    default public void error(String string, Throwable throwable) {
    }
}

