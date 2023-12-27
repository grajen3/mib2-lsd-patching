/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.service;

import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUICheckerService$1;

class SUICheckerService$1$1
implements Runnable {
    private final /* synthetic */ SUICheckerService$1 this$1;

    SUICheckerService$1$1(SUICheckerService$1 sUICheckerService$1) {
        this.this$1 = sUICheckerService$1;
    }

    @Override
    public void run() {
        SUICheckerService$1.access$000(this.this$1).onSystemLanguageChanged();
    }
}

