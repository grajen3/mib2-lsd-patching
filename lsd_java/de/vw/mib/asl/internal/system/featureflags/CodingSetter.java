/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.Logger;

public class CodingSetter {
    private final String LOG_PREFIX;
    private final ASLPropertyManager propertyManager;
    private final ConfigurationManagerDiag configurationManager;
    private final Logger logger;

    public CodingSetter(ASLPropertyManager aSLPropertyManager, ConfigurationManagerDiag configurationManagerDiag, Logger logger) {
        this.LOG_PREFIX = "[CodingSetter] ";
        this.propertyManager = aSLPropertyManager;
        this.configurationManager = configurationManagerDiag;
        this.logger = logger;
    }

    public void update(Coding coding) {
        if (coding != null) {
            this.processSteeringWheelSide(coding);
            this.writeAmFmFeatureFlags(coding);
            this.writeRseKeyPanelFeatureFlag(coding);
            this.writeSdsInstrumentClusterTeleprompterFeatureFlag(coding);
            this.writeWirelessChargerFeatureFlag(coding);
            this.writeIsDashboardGraphicVariantMost(coding);
        }
    }

    private void writeWirelessChargerFeatureFlag(Coding coding) {
        boolean bl = coding.getBoolean(1165);
        this.propertyManager.valueChangedBoolean(1217468416, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isWirelessCharger", bl);
    }

    private void writeAmFmFeatureFlags(Coding coding) {
        boolean bl = !coding.getBoolean(60);
        this.propertyManager.valueChangedBoolean(338, bl);
        this.propertyManager.valueChangedBoolean(334, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isAMAvailable", bl);
        boolean bl2 = bl && (coding.getValue(45) == 3 || coding.getValue(45) == 8);
        this.propertyManager.valueChangedBoolean(479270912, bl2);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isTuner_FM_JP_Band", bl2);
    }

    private void writeRseKeyPanelFeatureFlag(Coding coding) {
        boolean bl = coding.getBoolean(1164);
        this.propertyManager.valueChangedBoolean(1016141824, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isRseKeyPanel", bl);
    }

    private void writeSdsInstrumentClusterTeleprompterFeatureFlag(Coding coding) {
        boolean bl = coding.getBoolean(1178);
        this.propertyManager.valueChangedBoolean(1167136768, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isSdsInstrumentClusterTeleprompterCoding", bl);
    }

    private void writeIsDashboardGraphicVariantMost(Coding coding) {
        int n = coding.getValue(97);
        boolean bl = n == 0;
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isDashboardGraphicVariantMost", bl);
    }

    private void processSteeringWheelSide(Coding coding) {
        int n;
        int n2;
        int n3 = coding.getValue(80);
        switch (n3) {
            case 0: {
                this.trace("Applying steering wheel: left side");
                n2 = 0;
                n = 1;
                break;
            }
            case 1: {
                this.trace("Applying steering wheel: right side");
                n2 = 1;
                n = 2;
                break;
            }
            default: {
                this.warn(new StringBuffer().append("driverSide unknown: ").append(n3).append(", appying default values").toString());
                n2 = 0;
                n = 0;
            }
        }
        this.propertyManager.valueChangedInteger(2364, n2);
        this.configurationManager.setDriverSide(n);
    }

    private void trace(String string) {
        if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048).append("[CodingSetter] ").append(string).log();
        }
    }

    private void warn(String string) {
        this.logger.warn(2048).append("[CodingSetter] ").append(string).log();
    }
}

