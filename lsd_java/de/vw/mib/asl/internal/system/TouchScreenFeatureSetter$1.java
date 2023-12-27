/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.TouchScreenFeatureSetter;
import de.vw.mib.asl.internal.system.abtfeatures.DsiKeyPanelListenerAdapter;

class TouchScreenFeatureSetter$1
extends DsiKeyPanelListenerAdapter {
    private final /* synthetic */ TouchScreenFeatureSetter this$0;

    TouchScreenFeatureSetter$1(TouchScreenFeatureSetter touchScreenFeatureSetter) {
        this.this$0 = touchScreenFeatureSetter;
    }

    @Override
    public void updateInputPanelReady(int n, int n2, int n3) {
        this.this$0.onInputPanelReady();
    }
}

