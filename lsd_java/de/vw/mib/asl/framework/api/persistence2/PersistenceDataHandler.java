/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import java.util.Map$Entry;

public interface PersistenceDataHandler {
    default public void handle(int n, boolean bl) {
    }

    default public void handle(int n, byte by) {
    }

    default public void handle(int n, char c2) {
    }

    default public void handle(int n, short s) {
    }

    default public void handle(int n, int n2) {
    }

    default public void handle(int n, long l) {
    }

    default public void handle(int n, float f2) {
    }

    default public void handle(int n, double d2) {
    }

    default public void handle(int n, String string) {
    }

    default public void handle(int n, Persistable persistable) {
    }

    default public void handle(int n, Map$Entry map$Entry) {
    }

    default public void handleEmptyCollection(int n) {
    }

    default public void finish() {
    }
}

