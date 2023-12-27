/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.config;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.SwapHandler;
import de.vw.mib.configuration.ConfigurationManagerDiag;

public class SwapConfigurationAttribute
implements SwapHandler {
    private final ConfigurationManagerDiag configManager;
    private boolean isSwapEnabled;

    public SwapConfigurationAttribute(ConfigurationManagerDiag configurationManagerDiag) {
        this.configManager = configurationManagerDiag;
        this.isSwapEnabled = this.configManager.isFeatureFlagSet(582);
    }

    private void writeFeatureFlag(boolean bl) {
        this.configManager.setFeatureFlagValue("ASL.Configuration.isSdsSwAP", bl);
    }

    public boolean isSwapEnabled() {
        return this.isSwapEnabled;
    }

    @Override
    public void setSdsAvailability(int n) {
        this.writeFeatureFlag(n == 2);
    }
}

