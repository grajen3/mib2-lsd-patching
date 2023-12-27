/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupService;
import de.vw.mib.genericevents.GenericEvents;

public interface ASLPersistenceAPI {
    default public void writeViaDsi() {
    }

    default public void asyncWriteByteArray(int n, int n2, int n3, long l, byte[] byArray) {
    }

    default public void asyncReadByteArray(int n, int n2, int n3, long l) {
    }

    default public void readByteArray(int n, long l, PersistenceReadCallback persistenceReadCallback) {
    }

    default public AslPersistenceSyncApi createPersistenceInstance(GenericEvents genericEvents, int n, String string) {
    }

    default public AslPersistenceSyncApi createPersistenceInstance(GenericEvents genericEvents, String string) {
    }

    default public AslPersistenceSyncApi getPersistenceSyncApi() {
    }

    default public PersistenceStartupService getPersistenceStartupService() {
    }
}

