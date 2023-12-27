/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDb;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RecordByteArray;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileCopyService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileOperationRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAdapterProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.PersonalizedAppAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ProfileCopyServiceImpl$1;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.log4mib.Logger;
import java.util.Iterator;
import java.util.List;

public class ProfileCopyServiceImpl
implements ProfileCopyService {
    private static final String PREFIX;
    private final ApiPersDb apiPersDb;
    private final DsiAdapterProvider dsiAdapterProvider;
    private final Logger logger;
    private final PersistableService persistableService;
    private final PersistenceKeyProvider persistenceKeyProvider;
    private final StartupStateService startupStateService;
    private final ProfileOperationRegistry profileOperationRegistry;
    private boolean dsiListenerInitialized = false;

    public ProfileCopyServiceImpl(PersistenceServices persistenceServices) {
        this.checkConstructorArgument(persistenceServices);
        this.persistableService = persistenceServices.getPersistableService();
        this.persistenceKeyProvider = persistenceServices.getPersistenceKeyProvider();
        this.apiPersDb = persistenceServices.getApiPersDb();
        this.logger = persistenceServices.getLogger();
        this.startupStateService = persistenceServices.getStartupStateService();
        this.dsiAdapterProvider = persistenceServices.getDsiAdapterProvider();
        this.profileOperationRegistry = persistenceServices.getProfileOperationRegistry();
    }

    @Override
    public void copyProfile(byte by, byte by2) {
        this.logTrace(new StringBuffer().append("Copying profile from >").append(by).append("< to >").append(by2).append("<.").toString());
        this.checkCopyCanBePerformed(by, by2);
        this.copyNamespaces(by, by2);
        this.profileOperationRegistry.copyProfile(by, by2);
        if (!this.dsiListenerInitialized) {
            this.initDsiListener();
        }
        this.copyDsiProfiles(by, by2);
    }

    void logWarning(String string) {
        this.logger.warn(32, new StringBuffer().append("[ProfileCopyServiceImpl] ").append(string).toString());
    }

    private void assureNoProfileChangeIsRunning() {
        if (this.persistableService.isProfileSwitchOngoing()) {
            throw new IllegalStateException("Cannot copy profile since a profile switch is running.");
        }
    }

    private void assureStartupIsDone() {
        if (this.startupStateService.getStartupState() != 2) {
            throw new IllegalStateException("Cannot copy profile since the startup is running.");
        }
    }

    private void checkConstructorArgument(PersistenceServices persistenceServices) {
        if (persistenceServices == null) {
            throw new IllegalArgumentException("Persistence services must not be null.");
        }
    }

    private void checkCopyCanBePerformed(byte by, byte by2) {
        this.validateParameters(by, by2);
        this.assureNoProfileChangeIsRunning();
        this.assureStartupIsDone();
    }

    private void copyData(int n, long l, long l2) {
        boolean bl = true;
        boolean bl2 = false;
        byte[] byArray = this.readPersistenceData(n, l);
        RecordByteArray recordByteArray = new RecordByteArray(n, l2, byArray, bl);
        this.apiPersDb.putIntoCache(n, l2, recordByteArray, bl2);
    }

    private void copyDsiProfiles(byte by, byte by2) {
        List list = this.dsiAdapterProvider.getAllDsiAdapters();
        list = this.dsiAdapterProvider.filterUnregisteredDsis(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = (AbstractPersonalizedAppDsiAdapter)iterator.next();
            abstractPersonalizedAppDsiAdapter.profileCopy(by, by2);
        }
    }

    private void copyNamespace(byte by, byte by2, int n) {
        int[] nArray = this.persistenceKeyProvider.retrieveUserSpecificPersistableIds(n);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2];
            long l = PersistenceKeyUtil.calcUserKey(n2, by);
            long l2 = PersistenceKeyUtil.calcUserKey(n2, by2);
            this.copyData(n, l, l2);
        }
    }

    private void copyNamespaces(byte by, byte by2) {
        int[] nArray = this.persistenceKeyProvider.retrieveNamespaceIds();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.copyNamespace(by, by2, nArray[i2]);
        }
    }

    private PersonalizedAppAdapter createDsiListener(AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        return new ProfileCopyServiceImpl$1(this, abstractPersonalizedAppDsiAdapter);
    }

    private void initDsiListener() {
        try {
            Iterator iterator = this.dsiAdapterProvider.getAllDsiAdapters().iterator();
            while (iterator.hasNext()) {
                AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = (AbstractPersonalizedAppDsiAdapter)iterator.next();
                this.dsiAdapterProvider.addDsiListener(abstractPersonalizedAppDsiAdapter, this.createDsiListener(abstractPersonalizedAppDsiAdapter));
            }
            this.dsiListenerInitialized = true;
        }
        catch (Exception exception) {
            throw new RuntimeException("Listener registration on copy profile was interrupted.", exception);
        }
    }

    private void logTrace(String string) {
        if (this.logger.isTraceEnabled(32)) {
            this.logger.trace(32, new StringBuffer().append("[ProfileCopyServiceImpl] ").append(string).toString());
        }
    }

    private byte[] readPersistenceData(int n, long l) {
        boolean bl;
        AbstractRecord abstractRecord = this.apiPersDb.getCachedRecord(n, l);
        boolean bl2 = bl = abstractRecord != null && abstractRecord.getType() == 3 && abstractRecord.isValid();
        if (abstractRecord != null && bl) {
            return abstractRecord.getByteArray();
        }
        this.logWarning(new StringBuffer().append("No valid data for NS ").append(n).append(", key ").append(l).toString());
        return new byte[0];
    }

    private void validateParameters(byte by, byte by2) {
        if (by != this.persistableService.getActiveProfile()) {
            throw new IllegalArgumentException("It is only allowed to copy values from the active profile");
        }
        if (by2 == this.persistableService.getActiveProfile()) {
            throw new IllegalArgumentException("Cannot copy profile into active profile");
        }
    }
}

