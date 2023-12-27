/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.AbtFeatureService;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.configuration.ConfigurationManagerDiag;

public class AbtFeatureFlagSetter {
    private final ConfigurationManagerDiag configurationManager;
    private final ASLPropertyManager propertyManager;
    private final SystemLogger systemLogger;
    private final AbtFeatureService abtFeatureService;

    public AbtFeatureFlagSetter(SystemServices systemServices) {
        Preconditions.checkArgumentNotNull(systemServices);
        this.abtFeatureService = systemServices.getAbtFeatureServiceImpl();
        this.systemLogger = new SystemLogger(systemServices.getAsl1Logger(), super.getClass());
        this.propertyManager = systemServices.getPropertyManager();
        this.configurationManager = systemServices.getConfigManagerDiag();
    }

    public void update() {
        this.updateFeatureFlagProximitySensorAvailable();
        this.updateRotaryEncoderVolumeMenu();
        this.updateDTVHighResolution();
    }

    private void updateFeatureFlagProximitySensorAvailable() {
        boolean bl;
        boolean bl2 = bl = this.abtFeatureService.getProximitySensor() != 0;
        if (this.configurationManager.isFeatureFlagSet(390)) {
            bl = this.configurationManager.isFeatureFlagSet(389);
        }
        this.systemLogger.trace(new Object[]{"updateFeatureFlagProximitySensorAvailable called! isProximitySensorAvailable = ", new Boolean(bl)});
        this.propertyManager.valueChangedBoolean(1133582336, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isProximitySensorAvailable", bl);
    }

    private void updateRotaryEncoderVolumeMenu() {
        boolean bl = this.abtFeatureService.getRotaryEncoderType() == 2;
        this.systemLogger.trace(new Object[]{"updateRotaryEncoderVolumeMenu called! isRightDdsAvailable = ", new Boolean(bl)});
        this.propertyManager.valueChangedBoolean(1334908928, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isRightDDSAvailable", bl);
    }

    private void updateDTVHighResolution() {
        boolean bl = this.abtFeatureService.getAbtType() == 6;
        this.systemLogger.trace(new Object[]{"updateDTVHighResolution called! isDTVHighResolution = ", new Boolean(bl)});
        this.propertyManager.valueChangedBoolean(1351686144, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isDTVHighResolution", bl);
    }
}

