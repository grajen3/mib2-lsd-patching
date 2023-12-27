/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal;

import de.vw.mib.asl.internal.car.personal.ASLTargetPersonalisation;

class ASLTargetPersonalisation$1
implements Runnable {
    private final /* synthetic */ ASLTargetPersonalisation this$0;

    ASLTargetPersonalisation$1(ASLTargetPersonalisation aSLTargetPersonalisation) {
        this.this$0 = aSLTargetPersonalisation;
    }

    @Override
    public void run() {
        this.this$0.timerCallback();
    }
}

