/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;

class AslTargetSystemGeneral$8
extends DSIServiceStateListenerAdapter {
    private final /* synthetic */ AslTargetSystemGeneral this$0;

    AslTargetSystemGeneral$8(AslTargetSystemGeneral aslTargetSystemGeneral) {
        this.this$0 = aslTargetSystemGeneral;
    }

    @Override
    public void registered(String string, int n) {
        this.this$0.setNotificationForGeneralVehicleStates();
    }
}

