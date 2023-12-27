/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.internal.lsc.DiagnosisHandler;

class DiagnosisHandler$1
implements AdaptionResponse {
    private final /* synthetic */ DiagnosisHandler this$0;

    DiagnosisHandler$1(DiagnosisHandler diagnosisHandler) {
        this.this$0 = diagnosisHandler;
    }

    @Override
    public void onSuccess(Access access) {
        DiagnosisHandler.access$000(this.this$0, (Coding)access);
    }

    @Override
    public void onError() {
        DiagnosisHandler.access$100(this.this$0, "Coding was invalid");
    }
}

