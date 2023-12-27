/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceDataHandler;

public interface HandlerFactory {
    default public PersistenceDataHandler createCommonHandler(Persistable persistable) {
    }

    default public PersistenceDataHandler createUserHandler(Persistable persistable) {
    }
}

