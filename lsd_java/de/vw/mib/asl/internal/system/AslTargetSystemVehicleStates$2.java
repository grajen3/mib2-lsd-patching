/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates;

class AslTargetSystemVehicleStates$2
extends DSIServiceStateListenerAdapter {
    private final /* synthetic */ AslTargetSystemVehicleStates this$0;

    AslTargetSystemVehicleStates$2(AslTargetSystemVehicleStates aslTargetSystemVehicleStates) {
        this.this$0 = aslTargetSystemVehicleStates;
    }

    @Override
    public void registered(String string, int n) {
        this.this$0.connectToDsiGeneralVehicleStates();
    }
}

