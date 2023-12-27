/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils.implementation;

import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.utils.FeatureAvailabilityChecker;
import de.vw.mib.configuration.ConfigurationManager;

public class FeatureAvailabilityCheckerImpl
implements FeatureAvailabilityChecker {
    private final ConfigurationManager configurationManager;
    private EntertainmentSourceHandler entertainmentSourceHandler;

    public FeatureAvailabilityCheckerImpl(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }

    @Override
    public void setEntertainmentSourceHandler(EntertainmentSourceHandler entertainmentSourceHandler) {
        this.entertainmentSourceHandler = entertainmentSourceHandler;
    }

    @Override
    public boolean isAmFrequencyActive() {
        return this.entertainmentSourceHandler != null && this.entertainmentSourceHandler.getCurrentBand() == 0 && this.configurationManager.isFeatureFlagSet(570);
    }

    @Override
    public boolean isAmHDFrequencyActive() {
        return this.entertainmentSourceHandler != null && this.entertainmentSourceHandler.getCurrentBand() == 0 && this.configurationManager.isFeatureFlagSet(571);
    }

    @Override
    public boolean isFmFrequencyActive() {
        return this.entertainmentSourceHandler != null && this.entertainmentSourceHandler.getCurrentBand() == 1 && this.configurationManager.isFeatureFlagSet(573);
    }

    @Override
    public boolean isFmHDFrequencyActive() {
        return this.entertainmentSourceHandler != null && this.entertainmentSourceHandler.getCurrentBand() == 1 && this.configurationManager.isFeatureFlagSet(574);
    }

    @Override
    public boolean isFmByNameActive() {
        return this.entertainmentSourceHandler != null && this.entertainmentSourceHandler.getCurrentBand() == 1 && this.configurationManager.isFeatureFlagSet(575);
    }

    @Override
    public boolean isDabByNameActive() {
        return this.entertainmentSourceHandler != null && this.entertainmentSourceHandler.getCurrentBand() == 2 && this.configurationManager.isFeatureFlagSet(572);
    }

    @Override
    public boolean isSiriusByNameActive() {
        return this.entertainmentSourceHandler != null && this.entertainmentSourceHandler.getCurrentBand() == 3 && this.configurationManager.isFeatureFlagSet(576);
    }

    @Override
    public boolean isFmByNameCoded() {
        return this.entertainmentSourceHandler != null && this.configurationManager.isFeatureFlagSet(575);
    }

    @Override
    public boolean isDabByNameCoded() {
        return this.entertainmentSourceHandler != null && this.configurationManager.isFeatureFlagSet(572);
    }

    @Override
    public boolean isSiriusByNameCoded() {
        return this.entertainmentSourceHandler != null && this.configurationManager.isFeatureFlagSet(576);
    }

    @Override
    public boolean hasOnlyOneBand() {
        return this.entertainmentSourceHandler != null && !this.configurationManager.isFeatureFlagSet(576) && !this.configurationManager.isFeatureFlagSet(572) && !this.configurationManager.isFeatureFlagSet(570) && !this.configurationManager.isFeatureFlagSet(571);
    }
}

