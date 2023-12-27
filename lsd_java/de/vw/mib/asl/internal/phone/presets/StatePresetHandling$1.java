/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.presets;

import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.phone.presets.StatePresetHandling;

class StatePresetHandling$1
implements ASLComponentAPICallback {
    private final /* synthetic */ StatePresetHandling this$0;

    StatePresetHandling$1(StatePresetHandling statePresetHandling) {
        this.this$0 = statePresetHandling;
    }

    @Override
    public void registered(Class clazz, Object object) {
        ((PhoneService)object).registerSpecialNumberUpdate(this.this$0);
    }
}

