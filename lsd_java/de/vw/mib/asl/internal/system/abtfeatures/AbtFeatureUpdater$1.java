/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureUpdater;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;
import de.vw.mib.configuration.RtMethodListener;

class AbtFeatureUpdater$1
implements RtMethodListener {
    private final /* synthetic */ AbtFeatures val$abtFeatures;
    private final /* synthetic */ AbtFeatureUpdater this$0;

    AbtFeatureUpdater$1(AbtFeatureUpdater abtFeatureUpdater, AbtFeatures abtFeatures) {
        this.this$0 = abtFeatureUpdater;
        this.val$abtFeatures = abtFeatures;
    }

    @Override
    public void onRtMethodValueChanged(String string) {
        boolean bl = "ASL.Configuration.isNotSEAT".equals(string);
        if (bl) {
            this.this$0.installDefaultProximitySensor(this.val$abtFeatures);
        }
    }
}

