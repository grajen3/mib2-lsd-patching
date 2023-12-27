/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.system.featureflags.SpeechFeatureFlagSetter$1;
import de.vw.mib.asl.systemearly.persistence.SystemEarly;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.configuration.RtMethodListener;

public class SpeechFeatureFlagSetter {
    private final ConfigurationManagerDiag configurationManager;
    private final ASLPropertyManager propertyManager;
    private final SystemEarly systemEarly;

    public SpeechFeatureFlagSetter(SystemEarly systemEarly, ConfigurationManagerDiag configurationManagerDiag, ASLPropertyManager aSLPropertyManager) {
        this.systemEarly = systemEarly;
        this.configurationManager = configurationManagerDiag;
        this.propertyManager = aSLPropertyManager;
        configurationManagerDiag.addRtMethodListener(this.createRtMethodListener());
    }

    public void installPersistedValues() {
        boolean bl = this.systemEarly.isLastValueFeatureFlagSdsCoding();
        boolean bl2 = this.systemEarly.isLastValueFeatureFlagSdsSwap();
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isSdsCoding", bl);
        this.propertyManager.valueChangedBoolean(781260800, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isSdsSwAP", bl2);
        this.propertyManager.valueChangedBoolean(764483584, bl2);
    }

    private RtMethodListener createRtMethodListener() {
        SystemEarly systemEarly = this.systemEarly;
        ConfigurationManagerDiag configurationManagerDiag = this.configurationManager;
        ASLPropertyManager aSLPropertyManager = this.propertyManager;
        return new SpeechFeatureFlagSetter$1(this, configurationManagerDiag, systemEarly, aSLPropertyManager);
    }
}

