/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.internal.phone.TargetASLPhoneFeatures;
import de.vw.mib.asl.internal.phone.TargetASLPhoneFeatures$1;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

class TargetASLPhoneFeatures$NadListener
extends DefaultDSIMobileEquipmentListener {
    private final /* synthetic */ TargetASLPhoneFeatures this$0;

    private TargetASLPhoneFeatures$NadListener(TargetASLPhoneFeatures targetASLPhoneFeatures) {
        this.this$0 = targetASLPhoneFeatures;
    }

    @Override
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        if (n == 1) {
            TargetASLPhoneFeatures.access$102(this.this$0, activationStateStruct.telPhoneModuleState == 2 || activationStateStruct.telPhoneModuleState == 3 || activationStateStruct.telPhoneModuleState == 6 || activationStateStruct.telPhoneModuleState == 7 || activationStateStruct.telPhoneModuleState == 8);
            TargetASLPhoneFeatures.access$202(this.this$0, true);
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace().append("[TargetASLPhoneFeatures] ").append("dsiNADUpdateActivationState: ").append(activationStateStruct.telPhoneModuleState).log();
            }
            TargetASLPhoneFeatures.access$300(this.this$0);
        }
    }

    /* synthetic */ TargetASLPhoneFeatures$NadListener(TargetASLPhoneFeatures targetASLPhoneFeatures, TargetASLPhoneFeatures$1 targetASLPhoneFeatures$1) {
        this(targetASLPhoneFeatures);
    }
}

