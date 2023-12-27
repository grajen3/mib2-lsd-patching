/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.system.featureflags.SpeechFeatureFlagSetter;
import de.vw.mib.asl.systemearly.persistence.SystemEarly;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.configuration.RtMethodListener;

class SpeechFeatureFlagSetter$1
implements RtMethodListener {
    private final /* synthetic */ ConfigurationManagerDiag val$internalConfigurationManager;
    private final /* synthetic */ SystemEarly val$internalSystemEarly;
    private final /* synthetic */ ASLPropertyManager val$internalPropertyManager;
    private final /* synthetic */ SpeechFeatureFlagSetter this$0;

    SpeechFeatureFlagSetter$1(SpeechFeatureFlagSetter speechFeatureFlagSetter, ConfigurationManagerDiag configurationManagerDiag, SystemEarly systemEarly, ASLPropertyManager aSLPropertyManager) {
        this.this$0 = speechFeatureFlagSetter;
        this.val$internalConfigurationManager = configurationManagerDiag;
        this.val$internalSystemEarly = systemEarly;
        this.val$internalPropertyManager = aSLPropertyManager;
    }

    @Override
    public void onRtMethodValueChanged(String string) {
        if ("ASL.Configuration.isSdsCoding".equals(string)) {
            boolean bl = this.val$internalConfigurationManager.isFeatureFlagSet(241);
            this.val$internalSystemEarly.setLastValueFeatureFlagSdsCoding(bl);
            this.val$internalPropertyManager.valueChangedBoolean(781260800, bl);
        } else if ("ASL.Configuration.isSdsSwAP".equals(string)) {
            boolean bl = this.val$internalConfigurationManager.isFeatureFlagSet(307);
            this.val$internalSystemEarly.setLastValueFeatureFlagSdsSwap(bl);
            this.val$internalPropertyManager.valueChangedBoolean(764483584, bl);
        }
    }
}

