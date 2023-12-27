/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.AbtFeatureService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.internal.impl.system.AbstractSystemTarget;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.proximity.ProximityEnablementManager$1;
import de.vw.mib.asl.internal.system.proximity.ProximityEnablementManager$2;
import de.vw.mib.asl.internal.system.proximity.filter.EnablementProximityFilter;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

public class ProximityEnablementManager
extends AbstractSystemTarget {
    private final ConfigurationManagerDiag configurationManager;
    private final ASLPropertyManager propertyManager;
    private final EnablementProximityFilter enablementFilter;
    private final AbtFeatureService abtFeatureService;
    private final SystemCommonPersistenceService persistenceService;
    private SystemCommon systemCommon;

    public ProximityEnablementManager(SystemServices systemServices, EnablementProximityFilter enablementProximityFilter) {
        super(systemServices.getGenericEvents(), systemServices.getAsl1Logger(), -257288960);
        this.verifyConstructorArguements(enablementProximityFilter);
        this.persistenceService = systemServices.getSystemCommonPersistenceService();
        this.enablementFilter = enablementProximityFilter;
        this.configurationManager = systemServices.getConfigManagerDiag();
        this.propertyManager = systemServices.getPropertyManager();
        this.abtFeatureService = systemServices.getAbtFeatureServiceImpl();
        this.loadPersistedData();
        this.registerEvents(systemServices.getServiceRegister());
        this.updateEnablement();
        this.updateProximityActivity();
        this.setupResetParticipant(systemServices);
        this.persistenceService.addProfileChangeListener(new ProximityEnablementManager$1(this));
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1073743194: {
                this.onToggleProximity();
                break;
            }
        }
    }

    void loadPersistedData() {
        this.systemCommon = this.persistenceService.loadSystemCommon();
    }

    void updateEnablement() {
        boolean bl;
        boolean bl2 = this.systemCommon.isProximityEnabled();
        boolean bl3 = bl = this.abtFeatureService.getProximitySensor() != 0;
        if (this.configurationManager.isFeatureFlagSet(390)) {
            bl = this.configurationManager.isFeatureFlagSet(389);
        }
        boolean bl4 = bl2 && bl;
        this.enablementFilter.enableProximity(bl4);
    }

    void updateProximityActivity() {
        this.propertyManager.valueChangedBoolean(1684, this.systemCommon.isProximityEnabled());
    }

    private void setupResetParticipant(SystemServices systemServices) {
        SystemCommon systemCommon = this.systemCommon;
        ConfigurationManagerDiag configurationManagerDiag = this.configurationManager;
        ProximityEnablementManager$2 proximityEnablementManager$2 = new ProximityEnablementManager$2(this, systemCommon, configurationManagerDiag);
        systemServices.getFactoryResetService().addParticipant(proximityEnablementManager$2, FactoryResetComponents.SYSTEM);
    }

    private void onToggleProximity() {
        this.systemCommon.setProximityEnabled(!this.systemCommon.isProximityEnabled());
        this.updateProximityActivity();
        this.updateEnablement();
    }

    private void verifyConstructorArguements(EnablementProximityFilter enablementProximityFilter) {
        if (enablementProximityFilter == null) {
            throw new IllegalArgumentException("The enablement filter must not be null.");
        }
    }

    private void registerEvents(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(1510277184, this.getTargetId());
    }
}

