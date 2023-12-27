/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.api.impl.guidance;

import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceListener;
import de.vw.mib.asl.api.exboxm.guidance.GuidanceState;
import de.vw.mib.asl.internal.exboxm.api.impl.guidance.ExboxGuidanceManagerImpl;

class ExboxGuidanceManagerImpl$1
implements Runnable {
    private final /* synthetic */ ExboxGuidanceListener val$listener;
    private final /* synthetic */ GuidanceState val$newExboxGuidanceState;
    private final /* synthetic */ ExboxGuidanceManagerImpl this$0;

    ExboxGuidanceManagerImpl$1(ExboxGuidanceManagerImpl exboxGuidanceManagerImpl, ExboxGuidanceListener exboxGuidanceListener, GuidanceState guidanceState) {
        this.this$0 = exboxGuidanceManagerImpl;
        this.val$listener = exboxGuidanceListener;
        this.val$newExboxGuidanceState = guidanceState;
    }

    @Override
    public void run() {
        this.val$listener.onExboxGuidanceStateChanged(this.val$newExboxGuidanceState);
    }
}

