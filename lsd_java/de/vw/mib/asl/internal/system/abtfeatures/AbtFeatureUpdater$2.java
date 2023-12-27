/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureUpdater;
import de.vw.mib.asl.internal.system.abtfeatures.DsiKeyPanelListenerAdapter;

class AbtFeatureUpdater$2
extends DsiKeyPanelListenerAdapter {
    private final /* synthetic */ AbtFeatureUpdater this$0;

    AbtFeatureUpdater$2(AbtFeatureUpdater abtFeatureUpdater) {
        this.this$0 = abtFeatureUpdater;
    }

    @Override
    public void getProperty(int n, int n2, int n3, int n4, byte[] byArray) {
        this.this$0.processGetProperty(n4, byArray);
    }

    @Override
    public void updateInputPanelReady(int n, int n2, int n3) {
        this.this$0.processUpdateInputPanelReady();
    }
}

