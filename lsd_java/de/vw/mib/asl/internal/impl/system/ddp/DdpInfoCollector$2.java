/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.api.system.powerstate.ClampSignalAdapter;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector;

class DdpInfoCollector$2
extends ClampSignalAdapter {
    private final /* synthetic */ DdpInfoCollector this$0;

    DdpInfoCollector$2(DdpInfoCollector ddpInfoCollector) {
        this.this$0 = ddpInfoCollector;
    }

    @Override
    public void onClamp15ValueChanged(boolean bl) {
        DdpInfoCollector.access$402(this.this$0, bl);
        DdpInfoCollector.access$100(this.this$0, this.this$0.isDdpRequired());
    }
}

