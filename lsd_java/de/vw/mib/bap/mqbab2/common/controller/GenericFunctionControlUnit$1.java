/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.controller;

import de.vw.mib.bap.mqbab2.common.controller.GenericFunctionControlUnit;

class GenericFunctionControlUnit$1
implements Runnable {
    private final /* synthetic */ GenericFunctionControlUnit this$0;

    GenericFunctionControlUnit$1(GenericFunctionControlUnit genericFunctionControlUnit) {
        this.this$0 = genericFunctionControlUnit;
    }

    @Override
    public void run() {
        this.this$0.setArabic(true);
    }
}

