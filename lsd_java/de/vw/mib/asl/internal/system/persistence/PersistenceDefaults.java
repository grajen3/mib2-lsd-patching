/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.configuration.ConfigurationManagerDiag;

public class PersistenceDefaults {
    public static int getDefaultBrightness() {
        return PersistenceDefaults.getConfigurationManager().getSystemDisplayBrightnessDefault();
    }

    public static int getDefaultDistanceUnit() {
        return 0;
    }

    public static int getDefaultTemperatureUnit() {
        return 0;
    }

    public static int getDefaultVolumeUnit() {
        return 0;
    }

    public static int getDefaultPetrolConsumptionUnit() {
        return 0;
    }

    public static int getDefaultGasConsumptionUnit() {
        return 0;
    }

    public static int getDefaultElectricConsumptionUnit() {
        return 0;
    }

    public static int getDefaultPressureUnit() {
        return 0;
    }

    public static int getDefaultSpeedUnit() {
        return 0;
    }

    public static int getDefaultAstaWeightUnit() {
        return 0;
    }

    public static boolean getDefaultShowClock() {
        return PersistenceDefaults.getConfigurationManager().getSystemShowOffClockActiveDefaultBoolean();
    }

    public static boolean getDefaultGestureActive() {
        return true;
    }

    public static boolean getDefaultGestureInformationActive() {
        return true;
    }

    public static boolean getDefaultGestureSoundEffectActive() {
        return true;
    }

    public static int getDefaultSpellerLayout() {
        return PersistenceDefaults.getConfigurationManager().getSystemSpellerLayoutDefault();
    }

    public static String getDefaultLastContentId() {
        return "HMI_RADIO";
    }

    public static boolean getDefaultProximityEnablement() {
        return PersistenceDefaults.getConfigurationManager().getSystemProximityOnDefaultBoolean();
    }

    public static int getDefaultMenuMode() {
        return PersistenceDefaults.getConfigurationManager().getDefaultMenuMode();
    }

    public static boolean getIsSystemClimateMenuIconVisible() {
        return PersistenceDefaults.getConfigurationManager().isFeatureFlagSet(374);
    }

    public static int getDefaultProximitySensor() {
        boolean bl = PersistenceDefaults.getConfigurationManager().isFeatureFlagSet(389);
        if (bl) {
            return 1;
        }
        return 0;
    }

    public static boolean getDefaultDisplayOffClock() {
        return true;
    }

    private static ConfigurationManagerDiag getConfigurationManager() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getConfigurationManagerDiag();
    }
}

