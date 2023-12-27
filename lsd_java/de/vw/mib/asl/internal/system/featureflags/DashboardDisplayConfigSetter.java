/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.config.DashboardDisplayConfig;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;

public class DashboardDisplayConfigSetter {
    private static final String LOG_PREFIX;
    private static final int NAVIGATION_MAP_MOST_TRANSMISSION_MODE_MOST_STREAMING;
    private static final int NAVIGATION_MAP_COMPRESSION_MODE_H264;
    private static final int NAVIGATION_MAP_MOST_TRANSMISSION_MODE_OFF;
    private static final int NAVIGATION_MAP_MOST_TRANSMISSION_MODE_LVDS_MAP_FPK;
    private static final int CROSSROAD_DETAIL_MAP_MOST_TRANSMISSION_MODE_OFF;
    private static final int NAVIGATION_MAP_MOST_TRANSMISSION_MODE_MOST_HIGH;
    private static final int CROSSROAD_DETAIL_MAP_MOST_TRANSMISSION_MODE_MOST_HIGH;
    private final int CROSSROAD_DETAIL_MAP_MOST_TRANSMISSION_MODE_MOST_STREAMING;
    private final ConfigurationManagerDiag configurationManager;
    private final ASLPropertyManager propertyManager;
    private final Logger logger;
    private final ServiceRegister serviceRegister;

    public DashboardDisplayConfigSetter(SystemServices systemServices) {
        this.CROSSROAD_DETAIL_MAP_MOST_TRANSMISSION_MODE_MOST_STREAMING = 2;
        Preconditions.checkArgumentNotNull(systemServices);
        this.configurationManager = systemServices.getConfigManagerDiag();
        this.propertyManager = systemServices.getPropertyManager();
        this.logger = systemServices.getAsl1Logger();
        this.serviceRegister = systemServices.getServiceRegister();
    }

    public void update(DashboardDisplayConfig dashboardDisplayConfig) {
        if (dashboardDisplayConfig != null) {
            byte[] byArray = dashboardDisplayConfig.getRawData();
            if (byArray.length != 0) {
                this.triggerMostCapabilitiesEvents(dashboardDisplayConfig);
                this.evaluateIsFPKMapAvailable(dashboardDisplayConfig);
                this.writeNavMapSwitchFeatureFlag(dashboardDisplayConfig);
                this.writeFpkOverLVDSFeatureFlag(dashboardDisplayConfig);
            } else {
                this.trace("South side returns no data");
            }
        } else {
            this.error("Data could not be read");
        }
    }

    private void evaluateIsFPKMapAvailable(DashboardDisplayConfig dashboardDisplayConfig) {
        boolean bl = this.checkIsFPKMapAvailable(dashboardDisplayConfig);
        this.trace(new StringBuffer().append("evaluateIsFPKMapAvailable, isFPKMapAvailable = ").append(bl).toString());
        this.writeFPKMapFeatureFlag(bl);
    }

    private void writeFpkOverLVDSFeatureFlag(DashboardDisplayConfig dashboardDisplayConfig) {
        boolean bl = dashboardDisplayConfig.getValue(1172) == 3;
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isFpkOverLVDS", bl);
    }

    private void writeFPKMapFeatureFlag(boolean bl) {
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isFPKMapAvailable", bl);
        this.propertyManager.valueChangedBoolean(647043072, bl);
    }

    private boolean checkIsFPKMapAvailable(DashboardDisplayConfig dashboardDisplayConfig) {
        if (dashboardDisplayConfig.contains(1172) && dashboardDisplayConfig.contains(171)) {
            int n = dashboardDisplayConfig.getValue(1172);
            int n2 = dashboardDisplayConfig.getValue(171);
            return n == 2 && n2 == 1;
        }
        return false;
    }

    private void writeNavMapSwitchFeatureFlag(DashboardDisplayConfig dashboardDisplayConfig) {
        boolean bl = dashboardDisplayConfig.getBoolean(1176);
        this.propertyManager.valueChangedBoolean(1116805120, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isNavMapSwitch", bl);
    }

    private void triggerMostCapabilitiesEvents(DashboardDisplayConfig dashboardDisplayConfig) {
        this.triggerKombiMapEvent(dashboardDisplayConfig);
        this.triggerMostEvent(dashboardDisplayConfig);
    }

    private void triggerMostEvent(DashboardDisplayConfig dashboardDisplayConfig) {
        if (dashboardDisplayConfig.contains(1174) && dashboardDisplayConfig.contains(177) && dashboardDisplayConfig.contains(178)) {
            boolean bl = dashboardDisplayConfig.getBoolean(1174);
            boolean bl2 = dashboardDisplayConfig.getBoolean(178);
            boolean bl3 = dashboardDisplayConfig.getBoolean(177);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, bl);
            eventGeneric.setBoolean(1, bl2);
            eventGeneric.setBoolean(2, bl3);
            this.serviceRegister.triggerObserver(832389376, eventGeneric);
        }
    }

    private void triggerKombiMapEvent(DashboardDisplayConfig dashboardDisplayConfig) {
        if (dashboardDisplayConfig.contains(1172) && dashboardDisplayConfig.contains(1173)) {
            int n = this.checkKombiMapCapabilities(dashboardDisplayConfig);
            int n2 = this.checkKombiKdkCapabilities(dashboardDisplayConfig);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, n);
            eventGeneric.setInt(1, n2);
            this.serviceRegister.triggerObserver(815612160, eventGeneric);
        }
    }

    private int checkKombiKdkCapabilities(DashboardDisplayConfig dashboardDisplayConfig) {
        int n = dashboardDisplayConfig.getValue(1173);
        switch (n) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            default: {
                this.warn(new StringBuffer().append("triggerMostCapabilitiesEvent value kombiKdkCapabilities out of range: ").append(n).toString());
            }
        }
        return n;
    }

    private int checkKombiMapCapabilities(DashboardDisplayConfig dashboardDisplayConfig) {
        int n = dashboardDisplayConfig.getValue(1172);
        switch (n) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            default: {
                this.warn(new StringBuffer().append("triggerMostCapabilitiesEvent value kombiMapCapabilities out of range: ").append(n).toString());
            }
        }
        return n;
    }

    private void trace(String string) {
        if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048).append("[DashboardDisplayConfigSetter] ").append(string).log();
        }
    }

    private void warn(String string) {
        this.logger.warn(2048).append("[DashboardDisplayConfigSetter] ").append(string).log();
    }

    private void error(String string) {
        this.logger.error(2048).append("[DashboardDisplayConfigSetter] ").append(string).log();
    }
}

