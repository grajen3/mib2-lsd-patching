/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.connectivity.TargetASLNetworking;
import de.vw.mib.asl.internal.connectivity.TargetASLNetworking$1;

class TargetASLNetworking$Reset
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ TargetASLNetworking this$0;

    private TargetASLNetworking$Reset(TargetASLNetworking targetASLNetworking) {
        this.this$0 = targetASLNetworking;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        TargetASLNetworking.access$1202(this.this$0, factoryResetCallback);
        TargetASLNetworking.access$1302(this.this$0, true);
        TargetASLNetworking.access$1400(this.this$0).restoreFactorySettings();
    }

    /* synthetic */ TargetASLNetworking$Reset(TargetASLNetworking targetASLNetworking, TargetASLNetworking$1 targetASLNetworking$1) {
        this(targetASLNetworking);
    }
}

