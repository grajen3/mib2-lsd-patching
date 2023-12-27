/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online;

import de.vw.mib.asl.api.navigation.AbstractASLNavigationServicesListener;
import de.vw.mib.asl.internal.online.OnlineCallCenterServiceController;

class OnlineCallCenterServiceController$1
extends AbstractASLNavigationServicesListener {
    private final /* synthetic */ OnlineCallCenterServiceController this$0;

    OnlineCallCenterServiceController$1(OnlineCallCenterServiceController onlineCallCenterServiceController) {
        this.this$0 = onlineCallCenterServiceController;
    }

    @Override
    public void importContactResult(int n) {
        if (n == 1) {
            OnlineCallCenterServiceController.access$008(this.this$0);
        } else {
            OnlineCallCenterServiceController.access$108(this.this$0);
        }
        OnlineCallCenterServiceController.access$200(this.this$0);
    }
}

