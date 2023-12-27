/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.internal.impl.system.VelocityThresholdServiceImpl;

class VelocityThresholdServiceImpl$2
extends DSIServiceStateListenerAdapter {
    private final /* synthetic */ VelocityThresholdServiceImpl this$0;

    VelocityThresholdServiceImpl$2(VelocityThresholdServiceImpl velocityThresholdServiceImpl) {
        this.this$0 = velocityThresholdServiceImpl;
    }

    @Override
    public void registered(String string, int n) {
        this.this$0.connectToDsi();
    }
}

