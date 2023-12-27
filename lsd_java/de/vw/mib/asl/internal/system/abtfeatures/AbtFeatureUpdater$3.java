/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureUpdater;

class AbtFeatureUpdater$3
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ AbtFeatureUpdater this$0;

    AbtFeatureUpdater$3(AbtFeatureUpdater abtFeatureUpdater) {
        this.this$0 = abtFeatureUpdater;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.processReset(factoryResetCallback);
    }
}

