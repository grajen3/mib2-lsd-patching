/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.controller;

import de.vw.mib.bap.mqbab2.telephone.controller.TelephoneFunctionControlUnit;

class TelephoneFunctionControlUnit$1
implements Runnable {
    private final /* synthetic */ TelephoneFunctionControlUnit this$0;

    TelephoneFunctionControlUnit$1(TelephoneFunctionControlUnit telephoneFunctionControlUnit) {
        this.this$0 = telephoneFunctionControlUnit;
    }

    @Override
    public void run() {
        this.this$0.checkCarPlayActive();
    }
}

