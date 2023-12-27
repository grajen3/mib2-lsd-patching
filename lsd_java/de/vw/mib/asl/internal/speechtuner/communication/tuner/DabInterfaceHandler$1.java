/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.tuner;

import de.vw.mib.asl.api.radio.speech.TuningResponse;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.DabInterfaceHandler;

class DabInterfaceHandler$1
implements TuningResponse {
    private final /* synthetic */ DabInterfaceHandler this$0;

    DabInterfaceHandler$1(DabInterfaceHandler dabInterfaceHandler) {
        this.this$0 = dabInterfaceHandler;
    }

    @Override
    public int getResultState() {
        return 2;
    }
}

