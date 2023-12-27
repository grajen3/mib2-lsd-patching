/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis;

import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.internal.diagnosis.DiagnosisDataProvider;

class DiagnosisDataProvider$1
implements PersistenceReadCallback {
    private final /* synthetic */ DiagnosisDataProvider this$0;

    DiagnosisDataProvider$1(DiagnosisDataProvider diagnosisDataProvider) {
        this.this$0 = diagnosisDataProvider;
    }

    @Override
    public void onDataRead(int n, long l, int n2, byte[] byArray) {
        this.this$0.onDataRead(n, l, n2, byArray);
    }

    public void onDataRead(int n, long l, int n2, String string) {
    }
}

