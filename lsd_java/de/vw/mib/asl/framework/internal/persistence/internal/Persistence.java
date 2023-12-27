/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence.SharedPersistable;
import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.ProfileOperationParticipant;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.Persistence$1;
import de.vw.mib.asl.framework.internal.persistence.internal.config.PersistenceConfig;
import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDbImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.ApiPersFlush;
import de.vw.mib.asl.framework.internal.persistence.internal.load.PersistenceLoadNamespaceTarget;
import de.vw.mib.asl.framework.internal.persistence.internal.main.ApiPersMain;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ProfileChangeListenerAsyncMappingServiceImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServicesProvider;
import de.vw.mib.genericevents.GenericEvents;

public final class Persistence
implements AslPersistenceSyncApi {
    private final PersistableServiceImpl persistableService;
    private final ProfileChangeListenerAsyncMappingServiceImpl asyncprofileChangeListenerService;
    private PersistenceServices persistenceServices;
    static /* synthetic */ Class class$org$dsi$ifc$personalization$DSIPersonalization;
    static /* synthetic */ Class class$org$dsi$ifc$personalization$DSIPersonalizationListener;

    public Persistence(GenericEvents genericEvents, String string) {
        ApiPersMain.start(genericEvents, 5120, string, this);
        ApiPersFlush.start(genericEvents, string);
        new PersistenceLoadNamespaceTarget();
        this.persistenceServices = PersistenceServicesProvider.getPersistenceServices();
        this.persistableService = (PersistableServiceImpl)this.persistenceServices.getPersistableService();
        this.asyncprofileChangeListenerService = new ProfileChangeListenerAsyncMappingServiceImpl(this.persistableService, this.persistenceServices.getBundleContext(), this.persistenceServices.getLogger());
        this.connectToDsi(this.persistenceServices);
    }

    @Override
    public void setUser(long l) {
        PersistenceConfig.mCurrentUser = l;
    }

    @Override
    public long makeKey(long l, long l2) {
        return PersistenceConfig.makeKey(l, l2);
    }

    @Override
    public boolean loadPersistable(int n, long l, de.vw.mib.asl.framework.api.persistence.Persistable persistable) {
        return ApiPersDbImpl.INSTANCE.loadPersistable(n, l, persistable);
    }

    @Override
    public Persistable loadPersistable(PersistenceModule persistenceModule, int n) {
        return this.persistableService.loadPersistable(persistenceModule, n);
    }

    @Override
    public boolean readBoolean(int n, long l, boolean bl) {
        AbstractRecord abstractRecord = ApiPersDbImpl.INSTANCE.getCachedRecord(n, l);
        if (abstractRecord != null && abstractRecord.getType() == 1) {
            return abstractRecord.getInt() != 0;
        }
        return bl;
    }

    @Override
    public byte[] readByteArray(int n, long l, byte[] byArray) {
        AbstractRecord abstractRecord = ApiPersDbImpl.INSTANCE.getCachedRecord(n, l);
        if (abstractRecord != null && abstractRecord.getType() == 3) {
            return abstractRecord.getByteArray();
        }
        return byArray;
    }

    @Override
    public int readInt(int n, long l, int n2) {
        AbstractRecord abstractRecord = ApiPersDbImpl.INSTANCE.getCachedRecord(n, l);
        if (abstractRecord != null && abstractRecord.getType() == 1) {
            return abstractRecord.getInt();
        }
        return n2;
    }

    @Override
    public String readString(int n, long l, String string) {
        AbstractRecord abstractRecord = ApiPersDbImpl.INSTANCE.getCachedRecord(n, l);
        if (abstractRecord != null && abstractRecord.getType() == 2) {
            return abstractRecord.getString();
        }
        return string;
    }

    @Override
    public String[] readStringArray(int n, long l, String[] stringArray) {
        AbstractRecord abstractRecord = ApiPersDbImpl.INSTANCE.getCachedRecord(n, l);
        if (abstractRecord != null && abstractRecord.getType() == 4) {
            return abstractRecord.getStringArray();
        }
        return stringArray;
    }

    @Override
    public void registerSharedPersistable(SharedPersistable sharedPersistable) {
        ApiPersDbImpl.INSTANCE.registerSharedPersistable(sharedPersistable);
    }

    @Override
    public boolean storePersistable(int n, long l, de.vw.mib.asl.framework.api.persistence.Persistable persistable) {
        return ApiPersDbImpl.INSTANCE.storePersistable(n, l, persistable);
    }

    @Override
    public void writeBoolean(int n, long l, boolean bl) {
        this.writeInt(n, l, bl ? 1 : 0);
    }

    @Override
    public void writeByteArray(int n, long l, byte[] byArray) {
        this.putIntoCache(n, l, AbstractRecord.createRecord(n, l, byArray));
    }

    @Override
    public void writeInt(int n, long l, int n2) {
        this.putIntoCache(n, l, AbstractRecord.createRecord(n, l, n2));
    }

    @Override
    public void writeString(int n, long l, String string) {
        this.putIntoCache(n, l, AbstractRecord.createRecord(n, l, string));
    }

    @Override
    public void writeStringArray(int n, long l, String[] stringArray) {
        this.putIntoCache(n, l, AbstractRecord.createRecord(n, l, stringArray));
    }

    @Override
    public void flushDatabase(boolean bl) {
        ApiPersFlush.flushDatabase(bl);
    }

    @Override
    public void registerDsiAdapter(PersistenceModule persistenceModule, AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        PersistenceServicesProvider.getPersistenceServices().getDsiAdapterProvider().registerDsiAdapter(persistenceModule, abstractPersonalizedAppDsiAdapter);
    }

    @Override
    public ProfileChangeListener createProfileChangeListener(PersistenceModule persistenceModule, DsiAwareProfileChangeListener dsiAwareProfileChangeListener) {
        return PersistenceServicesProvider.getPersistenceServices().getDsiAwareProfileChangeListenerFactory().createProfileChangeListener(persistenceModule, dsiAwareProfileChangeListener);
    }

    @Override
    public void addProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
        this.asyncprofileChangeListenerService.addProfileChangeListener(persistenceModule, profileChangeListener);
    }

    @Override
    public void removeProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
        this.asyncprofileChangeListenerService.removeProfileChangeListener(persistenceModule, profileChangeListener);
    }

    @Override
    public void addGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener) {
        this.addGlobalProfileChangeListener(globalProfileChangeListener, 0);
    }

    @Override
    public void addGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener, int n) {
        this.asyncprofileChangeListenerService.addGlobalProfileChangeListener(globalProfileChangeListener, n);
    }

    @Override
    public void removeGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener) {
        this.asyncprofileChangeListenerService.removeGlobalProfileChangeListener(globalProfileChangeListener);
    }

    @Override
    public void activateProfile(byte by) {
        this.persistableService.activateProfile(by);
    }

    @Override
    public byte getActiveProfile() {
        return this.persistableService.getActiveProfile();
    }

    @Override
    public void addProfileOperationParticipant(ProfileOperationParticipant profileOperationParticipant) {
        this.persistenceServices.getProfileOperationRegistry().addProfileOperationParticipant(profileOperationParticipant);
    }

    @Override
    public boolean isProfileChangeRunning() {
        return this.persistableService.isProfileSwitchOngoing();
    }

    private void putIntoCache(int n, long l, AbstractRecord abstractRecord) {
        if (abstractRecord != null) {
            PersDebug.ioLog("APP WR", n, l, 0, abstractRecord.getType(), abstractRecord.toString());
            ApiPersDbImpl.INSTANCE.putIntoCache(n, l, abstractRecord, false);
        }
    }

    private void connectToDsi(PersistenceServices persistenceServices) {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$personalization$DSIPersonalization == null ? (class$org$dsi$ifc$personalization$DSIPersonalization = Persistence.class$("org.dsi.ifc.personalization.DSIPersonalization")) : class$org$dsi$ifc$personalization$DSIPersonalization, new Persistence$1(this, persistenceServices));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

