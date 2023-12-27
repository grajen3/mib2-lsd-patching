/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exlap;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.internal.exlap.ExlapTarget;

class ExlapTarget$1
extends ValetParkingListenerAdapter {
    private final /* synthetic */ ExlapTarget this$0;

    ExlapTarget$1(ExlapTarget exlapTarget) {
        this.this$0 = exlapTarget;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        this.this$0.valetParkingActivated = bl;
        if (bl) {
            if (ExlapTarget.access$000(this.this$0).isExternalAppsUserSettingEnabled() && ExlapTarget.access$100(this.this$0)) {
                this.this$0.valetParkingServiceCallback = valetParkingCallback;
                ExlapTarget.access$200(this.this$0).stop();
            } else if (valetParkingCallback != null) {
                this.this$0.valetParkingServiceCallback = null;
                valetParkingCallback.notifyValetParkingTransitionFinished(true);
            }
        } else if (ExlapTarget.access$000(this.this$0).isExternalAppsUserSettingEnabled() && ExlapTarget.access$100(this.this$0)) {
            this.this$0.valetParkingServiceCallback = valetParkingCallback;
            ExlapTarget.access$200(this.this$0).start();
        } else if (valetParkingCallback != null) {
            this.this$0.valetParkingServiceCallback = null;
            valetParkingCallback.notifyValetParkingTransitionFinished(true);
        }
    }
}

