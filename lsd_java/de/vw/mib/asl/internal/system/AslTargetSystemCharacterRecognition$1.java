/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.AslTargetSystemCharacterRecognition;

class AslTargetSystemCharacterRecognition$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ AslTargetSystemCharacterRecognition this$0;

    AslTargetSystemCharacterRecognition$1(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition) {
        this.this$0 = aslTargetSystemCharacterRecognition;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        AslTargetSystemCharacterRecognition.access$000(this.this$0);
        factoryResetCallback.notifyResetDone();
    }
}

