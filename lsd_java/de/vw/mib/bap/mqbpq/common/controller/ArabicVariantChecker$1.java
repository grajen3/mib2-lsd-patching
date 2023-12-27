/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.controller;

import de.vw.mib.bap.mqbpq.common.controller.ArabicVariantChecker;

class ArabicVariantChecker$1
implements Runnable {
    private final /* synthetic */ ArabicVariantChecker this$0;

    ArabicVariantChecker$1(ArabicVariantChecker arabicVariantChecker) {
        this.this$0 = arabicVariantChecker;
    }

    @Override
    public void run() {
        this.this$0.switchToArabic();
    }
}

