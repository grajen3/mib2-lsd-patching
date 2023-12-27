/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;

public interface Persistable {
    default public void fromStream(PersistenceInputStream persistenceInputStream) {
    }

    default public void toStream(PersistenceOutputStream persistenceOutputStream) {
    }

    default public void clear() {
    }
}

