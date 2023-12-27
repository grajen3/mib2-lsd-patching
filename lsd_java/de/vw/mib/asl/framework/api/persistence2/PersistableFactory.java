/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface PersistableFactory {
    default public Persistable createPersistable(int n) {
    }

    default public Persistable createPersistableWithDefaults(int n) {
    }
}

