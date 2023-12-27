/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling;

class AslTargetSystemPowerManagementHandling$1
implements DialogStateConsumer {
    private final /* synthetic */ AslTargetSystemPowerManagementHandling this$0;

    AslTargetSystemPowerManagementHandling$1(AslTargetSystemPowerManagementHandling aslTargetSystemPowerManagementHandling) {
        this.this$0 = aslTargetSystemPowerManagementHandling;
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (n == 3) {
            this.this$0.putDisplayAsleep(1);
        } else if (n == 2) {
            this.this$0.putDisplayAwake(1);
        }
    }
}

