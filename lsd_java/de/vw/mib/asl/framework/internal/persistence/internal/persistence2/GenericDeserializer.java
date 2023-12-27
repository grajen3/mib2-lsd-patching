/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

public interface GenericDeserializer {
    default public Persistable deserialize(byte[] byArray, byte[] byArray2, Persistable persistable, PersistenceModule persistenceModule, boolean bl) {
    }
}

