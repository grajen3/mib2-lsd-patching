/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.proximity.ProximityEnablementManager;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.configuration.ConfigurationManagerDiag;

class ProximityEnablementManager$2
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ SystemCommon val$internalSystemCommon;
    private final /* synthetic */ ConfigurationManagerDiag val$internalConfigurationManager;
    private final /* synthetic */ ProximityEnablementManager this$0;

    ProximityEnablementManager$2(ProximityEnablementManager proximityEnablementManager, SystemCommon systemCommon, ConfigurationManagerDiag configurationManagerDiag) {
        this.this$0 = proximityEnablementManager;
        this.val$internalSystemCommon = systemCommon;
        this.val$internalConfigurationManager = configurationManagerDiag;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.val$internalSystemCommon.setProximityEnabled(this.val$internalConfigurationManager.getSystemProximityOnDefaultBoolean());
        this.this$0.updateProximityActivity();
        this.this$0.updateEnablement();
        factoryResetCallback.notifyResetDone();
    }
}

