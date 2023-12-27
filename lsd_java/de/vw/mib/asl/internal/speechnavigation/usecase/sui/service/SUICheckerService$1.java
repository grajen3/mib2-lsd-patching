/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.service;

import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUICheckerService;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUICheckerService$1$1;
import de.vw.mib.configuration.NvListener;

class SUICheckerService$1
implements NvListener {
    private final /* synthetic */ SUICheckerService this$0;

    SUICheckerService$1(SUICheckerService sUICheckerService) {
        this.this$0 = sUICheckerService;
    }

    @Override
    public void notifyNvListener(int n) {
        this.this$0.threadSwitchingTarget.enqueue(new SUICheckerService$1$1(this));
    }

    static /* synthetic */ SUICheckerService access$000(SUICheckerService$1 sUICheckerService$1) {
        return sUICheckerService$1.this$0;
    }
}

