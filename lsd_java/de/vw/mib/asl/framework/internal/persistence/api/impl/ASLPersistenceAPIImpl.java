/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.api.impl;

import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.framework.internal.persistence.AslPersistenceAsyncApiImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.Persistence;
import de.vw.mib.asl.framework.internal.persistence.internal.main.ApiPersMain;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServicesProvider;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;

public class ASLPersistenceAPIImpl
implements ASLPersistenceAPI {
    private AslPersistenceSyncApi aslPersistenceSyncApi;

    @Override
    public void asyncReadByteArray(int n, int n2, int n3, long l) {
        try {
            AslPersistenceAsyncApiImpl.INSTANCE.readByteArray(n, n2, n3, l);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void readByteArray(int n, long l, PersistenceReadCallback persistenceReadCallback) {
        try {
            AslPersistenceAsyncApiImpl.INSTANCE.readByteArray(persistenceReadCallback, n, l);
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.errorHandler.handleError(genericEventException);
        }
    }

    @Override
    public void asyncWriteByteArray(int n, int n2, int n3, long l, byte[] byArray) {
        try {
            AslPersistenceAsyncApiImpl.INSTANCE.writeByteArray(n, n2, n3, l, byArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public AslPersistenceSyncApi createPersistenceInstance(GenericEvents genericEvents, int n, String string) {
        this.aslPersistenceSyncApi = new Persistence(genericEvents, string);
        return this.aslPersistenceSyncApi;
    }

    @Override
    public AslPersistenceSyncApi createPersistenceInstance(GenericEvents genericEvents, String string) {
        this.aslPersistenceSyncApi = new Persistence(genericEvents, string);
        return this.aslPersistenceSyncApi;
    }

    @Override
    public PersistenceStartupService getPersistenceStartupService() {
        return PersistenceServicesProvider.getPersistenceServices().getPersistenceStartupService();
    }

    @Override
    public AslPersistenceSyncApi getPersistenceSyncApi() {
        return this.aslPersistenceSyncApi;
    }

    @Override
    public void writeViaDsi() {
        ApiPersMain.writeViaDsi();
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(1, 5120, -1427105536);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5120, -1561323264);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5120, -1544546048);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5120, -1527768832);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5120, -1510991616);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5120, -1494214400);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5120, -1477437184);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5120, -1460659968);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5120, -1443882752);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5122, -711131136);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5120, -2125524480);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5120, -2108747264);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5120, 178077952);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5120, 379404544);
    }
}

