/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.api.impl;

import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.api.startupv7r.dynamic.DynamicWorkUnitStarter;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.framework.internal.startupv7r.PersistableEarlyData;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.activators.ASLBasicActivator;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupServicesProvider;

public class ASLStartupv7rAPIImpl
implements ASLStartupv7rAPI {
    private DynamicWorkUnitStarter dynamicWorkUnitStarter;

    @Override
    public IPersistableEarlyData getPersistableEarlyData() {
        return PersistableEarlyData.getInstance();
    }

    @Override
    public int getSupplier() {
        return StartupServiceManager.getSupplier();
    }

    @Override
    public boolean isSwdlPowerstateDetected() {
        return StartupServiceManager.swdlPowerstateDetected;
    }

    @Override
    public void startTargetByNamedId(int n) {
        ASLBasicActivator.startTargetByTID(n);
    }

    @Override
    public void setOnlineServiceCodingStateForStartup(boolean bl) {
    }

    @Override
    public boolean isHighActivatorStarted() {
        return StartupServiceManager.isHighActivatorStarted;
    }

    @Override
    public boolean isNonCustomerSwdlIsInProgress() {
        return StartupServiceManager.nonCustomerSwdlIsInProgress;
    }

    @Override
    public void setNonCustomerSwdlIsInProgress(boolean bl) {
        StartupServiceManager.nonCustomerSwdlIsInProgress = bl;
    }

    @Override
    public StartupStateService getStartupStateService() {
        return StartupServicesProvider.getStartupServices().getStartupStateService();
    }

    @Override
    public String[] getVariantDsiNames() {
        return StartupServicesProvider.getStartupServices().getDsiInformationService().getVariantDsiNames();
    }

    @Override
    public int[] getVariantPersistenceNamespaceIds() {
        return StartupServicesProvider.getStartupServices().getPersistenceInformationService().getVariantPersistenceNamespaceIds();
    }

    @Override
    public DynamicWorkUnitStarter getDynamicWorkUnitStarter() {
        return this.dynamicWorkUnitStarter;
    }

    public void setDynamicWorkUnitStarter(DynamicWorkUnitStarter dynamicWorkUnitStarter) {
        this.dynamicWorkUnitStarter = dynamicWorkUnitStarter;
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(2, 5150, 1241841728);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5150, 1443168320);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5150, 839188544);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5150, 1845821504);
    }
}

