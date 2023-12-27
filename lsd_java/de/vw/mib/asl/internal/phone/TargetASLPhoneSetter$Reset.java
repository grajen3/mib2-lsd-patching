/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.phone.TargetASLPhoneSetter;
import de.vw.mib.asl.internal.phone.TargetASLPhoneSetter$1;

class TargetASLPhoneSetter$Reset
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ TargetASLPhoneSetter this$0;

    private TargetASLPhoneSetter$Reset(TargetASLPhoneSetter targetASLPhoneSetter) {
        this.this$0 = targetASLPhoneSetter;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        TargetASLPhoneSetter.access$400(this.this$0);
        if (factoryResetCallback != null) {
            factoryResetCallback.notifyResetDone();
        }
    }

    /* synthetic */ TargetASLPhoneSetter$Reset(TargetASLPhoneSetter targetASLPhoneSetter, TargetASLPhoneSetter$1 targetASLPhoneSetter$1) {
        this(targetASLPhoneSetter);
    }
}

