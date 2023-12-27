/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.settings;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.internal.phone.setup.settings.TargetASLPhoneSetupSettings;
import de.vw.mib.asl.internal.phone.setup.settings.TargetASLPhoneSetupSettings$1;

class TargetASLPhoneSetupSettings$ValetParkingListenerNAD
extends ValetParkingListenerAdapter {
    private final /* synthetic */ TargetASLPhoneSetupSettings this$0;

    private TargetASLPhoneSetupSettings$ValetParkingListenerNAD(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings) {
        this.this$0 = targetASLPhoneSetupSettings;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        boolean bl2;
        boolean bl3 = bl2 = TargetASLPhoneSetupSettings.access$000(this.this$0) != null && TargetASLPhoneSetupSettings.access$000(this.this$0).getTelPhoneModuleState() == 2;
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("TargetASLPhoneSetupSettings.ValetParkingListenerNAD.notifyValetParkingStateChanged() ").append(bl).append(", pre VP NAD state = ").append(ASLPhoneFactory.getPhoneApi().getPersistence().getPreValetParkingNadState()).append(", nadActivationState: ").append(TargetASLPhoneSetupSettings.access$000(this.this$0)).append(valetParkingCallback == null ? ", callback == null" : "").log();
        }
        if (bl) {
            if (ASLPhoneFactory.getPhoneApi().getPersistence().getPreValetParkingNadState() == -1) {
                ASLPhoneFactory.getPhoneApi().getPersistence().setPreValetParkingNadState(bl2 ? 1 : 0);
                if (bl2) {
                    this.this$0.valetParkingCallback = valetParkingCallback;
                    TargetASLPhoneSetupSettings.access$100(this.this$0, false);
                } else if (valetParkingCallback != null) {
                    valetParkingCallback.notifyValetParkingTransitionFinished(true);
                    this.this$0.valetParkingCallback = null;
                }
            } else if (valetParkingCallback != null) {
                valetParkingCallback.notifyValetParkingTransitionFinished(true);
                this.this$0.valetParkingCallback = null;
            }
        } else {
            if (ASLPhoneFactory.getPhoneApi().getPersistence().getPreValetParkingNadState() == 1) {
                this.this$0.valetParkingCallback = valetParkingCallback;
                TargetASLPhoneSetupSettings.access$100(this.this$0, true);
            } else if (valetParkingCallback != null) {
                valetParkingCallback.notifyValetParkingTransitionFinished(true);
                this.this$0.valetParkingCallback = null;
            }
            ASLPhoneFactory.getPhoneApi().getPersistence().setPreValetParkingNadState(-1);
        }
    }

    /* synthetic */ TargetASLPhoneSetupSettings$ValetParkingListenerNAD(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings, TargetASLPhoneSetupSettings$1 targetASLPhoneSetupSettings$1) {
        this(targetASLPhoneSetupSettings);
    }
}

