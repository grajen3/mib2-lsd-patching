/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.impl.lsc.DiagLanguageUpdateListener;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;

class AslTargetLscTNGBullhorn$4
implements DiagLanguageUpdateListener {
    private final /* synthetic */ AslTargetLscTNGBullhorn this$0;

    AslTargetLscTNGBullhorn$4(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn) {
        this.this$0 = aslTargetLscTNGBullhorn;
    }

    @Override
    public void onDiagLanguagesUpdated() {
        boolean bl = this.this$0.configManagerDiag.isArabicAvailable();
        boolean bl2 = this.this$0.configManagerDiag.isArabicReplacementActive();
        if (bl) {
            this.this$0.info().append("[AslTargetLscTNGBullhorn]").append("Arabic Language was detected in coded Languages - switching mode").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(3568, bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1446125568, bl2);
        AslTargetLscTNGBullhorn.access$202(this.this$0, true);
        AslTargetLscTNGBullhorn.access$100(this.this$0).markVisibleLanguageDataReceived();
        this.this$0.updateLanguageAndSpellerList();
    }
}

