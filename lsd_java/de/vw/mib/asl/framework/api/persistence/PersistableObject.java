/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

public interface PersistableObject {
    default public boolean store() {
    }

    default public boolean store(int n, long l) {
    }

    default public boolean load() {
    }

    default public boolean load(int n, long l) {
    }
}

