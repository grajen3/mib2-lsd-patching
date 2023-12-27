/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

public interface Persistable {
    default public int getId() {
    }

    default public boolean hasUserSpecificData() {
    }

    default public void updateRootPersistable(Persistable persistable) {
    }

    default public void resetToDefaults() {
    }
}

