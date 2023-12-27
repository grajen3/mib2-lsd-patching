/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.tuner;

import de.vw.mib.asl.api.radio.speech.TuningResponse;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.SiriusInterfaceHandler;

class SiriusInterfaceHandler$1
implements TuningResponse {
    private final /* synthetic */ SiriusInterfaceHandler this$0;

    SiriusInterfaceHandler$1(SiriusInterfaceHandler siriusInterfaceHandler) {
        this.this$0 = siriusInterfaceHandler;
    }

    @Override
    public int getResultState() {
        return 2;
    }
}

