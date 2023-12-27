/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.trafficmap;

import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupHsmTarget;

class TrafficMapSetupHsmTarget$1
implements ASLOnlineServiceListener {
    private final /* synthetic */ TrafficMapSetupHsmTarget this$0;

    TrafficMapSetupHsmTarget$1(TrafficMapSetupHsmTarget trafficMapSetupHsmTarget) {
        this.this$0 = trafficMapSetupHsmTarget;
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (0 == n) {
            this.this$0.handleOnlineTrafficServiceAvailable();
        } else {
            this.this$0.handleOnlineTrafficServiceNotAvailable();
        }
    }
}

