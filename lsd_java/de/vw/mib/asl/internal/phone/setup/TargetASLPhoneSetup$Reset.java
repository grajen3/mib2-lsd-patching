/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.setup.TargetASLPhoneSetup;
import de.vw.mib.asl.internal.phone.setup.TargetASLPhoneSetup$1;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;

class TargetASLPhoneSetup$Reset
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ TargetASLPhoneSetup this$0;

    private TargetASLPhoneSetup$Reset(TargetASLPhoneSetup targetASLPhoneSetup) {
        this.this$0 = targetASLPhoneSetup;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (!ASLPhoneFactory.getPhoneApi().isCallsActive()) {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(378)) {
                DSIMobileEquipment[] dSIMobileEquipmentArray = this.this$0.usedDsiMobileEquipments();
                for (int i2 = 0; i2 < dSIMobileEquipmentArray.length; ++i2) {
                    dSIMobileEquipmentArray[i2].restoreFactorySettings();
                }
            } else {
                this.this$0.getPrimary().restoreFactorySettings();
            }
            this.this$0.dsiAdbUserProfile.deleteProfiles(new int[]{1, 2, 3, 4});
            ASLPhoneData.persistence.resetValues();
        }
        if (factoryResetCallback != null) {
            factoryResetCallback.notifyResetDone();
        }
    }

    /* synthetic */ TargetASLPhoneSetup$Reset(TargetASLPhoneSetup targetASLPhoneSetup, TargetASLPhoneSetup$1 targetASLPhoneSetup$1) {
        this(targetASLPhoneSetup);
    }
}

