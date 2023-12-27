/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDb;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RecordByteArray;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileOperationRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileResetService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAdapterProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PreChangeOperation;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ProfileResetServiceImpl$1;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import java.util.Iterator;
import java.util.List;

public class ProfileResetServiceImpl
implements ProfileResetService {
    static final int PROFILE_COUNT;
    private final PersistenceServices services;
    private final ProfileOperationRegistry profileOperationRegistry;

    public ProfileResetServiceImpl(PersistenceServices persistenceServices) {
        this.services = persistenceServices;
        this.profileOperationRegistry = persistenceServices.getProfileOperationRegistry();
    }

    @Override
    public void resetAllProfiles() {
        this.services.getPersistenceLogger().trace("Resetting all profiles");
        this.assureNoProfileSwitchIsRunning();
        this.profileOperationRegistry.resetAllProfiles();
        byte by = this.services.getPersistableService().getActiveProfile();
        this.resetInactiveHmiProfiles();
        PreChangeOperation preChangeOperation = this.createResetProfileOperation(by, 3);
        this.services.getPersistableService().updateProfile(preChangeOperation);
    }

    @Override
    public void resetProfile(byte by) {
        boolean bl;
        this.services.getPersistenceLogger().trace(new StringBuffer().append("Resetting profile ").append(by).toString());
        this.assureNoProfileSwitchIsRunning();
        this.profileOperationRegistry.resetProfile(by);
        boolean bl2 = bl = this.services.getPersistableService().getActiveProfile() == by;
        if (bl) {
            PreChangeOperation preChangeOperation = this.createResetProfileOperation(by, 2);
            this.services.getPersistableService().updateProfile(preChangeOperation);
        } else {
            this.resetInactiveHmiProfile(by);
            this.resetInactiveDsiProfile(by);
        }
    }

    void resetUserSpecificData(byte by, int n) {
        this.services.getPersistenceLogger().trace(new StringBuffer().append("Resetting user specifc data for namespace ").append(n).append(", profile ").append(by).toString());
        boolean bl = true;
        boolean bl2 = false;
        int[] nArray = this.services.getPersistenceKeyProvider().retrieveUserSpecificPersistableIds(n);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2];
            long l = PersistenceKeyUtil.calcUserKey(n2, by);
            RecordByteArray recordByteArray = new RecordByteArray(n, l, new byte[0], bl);
            ApiPersDb apiPersDb = this.services.getApiPersDb();
            apiPersDb.putIntoCache(n, l, recordByteArray, bl2);
            apiPersDb.markDataWasLoaded(n, l);
        }
    }

    private void assureNoProfileSwitchIsRunning() {
        if (this.services.getPersistableService().isProfileSwitchOngoing()) {
            throw new IllegalStateException("Profile Change is currenlty running");
        }
    }

    private PreChangeOperation createResetProfileOperation(byte by, int n) {
        return new ProfileResetServiceImpl$1(this, n, by);
    }

    private void resetInactiveDsiProfile(byte by) {
        List list = this.retrieveDsiAdapters();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = (AbstractPersonalizedAppDsiAdapter)iterator.next();
            abstractPersonalizedAppDsiAdapter.profileReset(by);
        }
    }

    private List retrieveDsiAdapters() {
        DsiAdapterProvider dsiAdapterProvider = this.services.getDsiAdapterProvider();
        List list = dsiAdapterProvider.getAllDsiAdapters();
        list = dsiAdapterProvider.filterUnregisteredDsis(list);
        return list;
    }

    private void resetInactiveHmiProfile(byte by) {
        int[] nArray = this.services.getPersistenceKeyProvider().retrieveNamespaceIds();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            this.resetUserSpecificData(by, n);
        }
    }

    private void resetInactiveHmiProfiles() {
        byte by = this.services.getPersistableService().getActiveProfile();
        for (byte by2 = 1; by2 < 8; by2 = (byte)(by2 + 1)) {
            boolean bl;
            boolean bl2 = bl = by == by2;
            if (bl) continue;
            this.resetInactiveHmiProfile(by2);
        }
    }
}

