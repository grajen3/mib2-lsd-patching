/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.setup;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IPersistableExtension;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;

public class TargetOnlineService
extends AbstractTarget
implements DSIServiceStateListener {
    static final String ONLINE_SERVICE_TRAFFIC_ID;
    static final String ONLINE_SERVICE_TRAFFIC_ID_TECHNISAT;
    public static final int[] OBSERVER;
    static final IPersistableExtension NAVI_OPTIONS_EXT;
    private static final int EV_INTERNAL_ACTIVATE_LICENSE;
    private DSIOnlineServiceRegistration dsiOnlineServiceRegistration;
    private DSIListener dsiOnlineServiceRegistrationListener;
    private DSIServiceLocator locator;
    private boolean isLicenseActive = false;
    private boolean isOnlineConnectionAvailable;
    private boolean lastLicenseActiveState;
    private OSRApplication trafficApp;
    private int activationAttempts;
    private boolean requestedTeSaTrafficApp;
    private boolean wasServiceStateListenerRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineServiceRegistration;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener;

    public TargetOnlineService(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.traceState("POWER_ON");
                ServiceManager.eventMain.getServiceRegister().registerService(1222718208, this.getTargetId(), 1222718208, true);
                break;
            }
            case 101003: {
                this.traceState("NAVI_TARGET_PREPARE_ON");
                break;
            }
            case 101001: {
                this.traceState("NAVI_TARGET_GO_ON");
                this.loadPersistence();
                if (!this.wasServiceStateListenerRegistered) {
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$online$DSIOnlineServiceRegistration == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistration = TargetOnlineService.class$("org.dsi.ifc.online.DSIOnlineServiceRegistration")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistration, this);
                    this.wasServiceStateListenerRegistered = true;
                }
                this.addObservers(OBSERVER);
                this.checkLicense();
                break;
            }
            case 101002: {
                this.traceState("NAVI_TARGET_PREPARE_OFF");
                break;
            }
            case 101000: {
                this.traceState("NAVI_TARGET_GO_OFF");
                this.removeObservers(OBSERVER);
                break;
            }
            case 107: {
                this.traceState("POWER_OFF");
                break;
            }
            case 2200001: {
                this.traceState("ASL_CONNECTIVITY_IS_DATA_CONNECTION_AVAILABLE");
                this.updateDataConnectionAvailable(eventGeneric);
                break;
            }
            case 3400008: {
                this.traceState("ASL_NAVI_ONLINE_SERVICE_LICENSE_VALID");
                this.updateOnlineServiceLicenseValid(eventGeneric);
                break;
            }
            case 1073744556: {
                this.traceState("ASLNavigationOnlineServiceServiceConstants.SET_ONLINE_TRAFFIC_DATA_STATUS");
                this.setOnlineTrafficDataStatus(eventGeneric);
                break;
            }
            case 100042: {
                this.traceState("EV_INTERNAL_ACTIVATE_LICENSE");
                this.activateLicense();
                break;
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (string2.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[92]) && this.dsiOnlineServiceRegistration == null) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.traceState("ONLINE_SERVICE_REGISTRATION service registered");
            this.dsiOnlineServiceRegistration = (DSIOnlineServiceRegistration)dSIProxy.getService(this, class$org$dsi$ifc$online$DSIOnlineServiceRegistration == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistration = TargetOnlineService.class$("org.dsi.ifc.online.DSIOnlineServiceRegistration")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistration);
            this.dsiOnlineServiceRegistrationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener = TargetOnlineService.class$("org.dsi.ifc.online.DSIOnlineServiceRegistrationListener")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener);
            this.dsiOnlineServiceRegistration.setNotification(1, this.dsiOnlineServiceRegistrationListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener = TargetOnlineService.class$("org.dsi.ifc.online.DSIOnlineServiceRegistrationListener")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener, this.dsiOnlineServiceRegistrationListener);
            if (this.isLicenseActive) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(3876, true);
            }
            this.trafficApp = null;
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (string2.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[92])) {
            this.traceState("ONLINE_SERVICE_REGISTRATION service tries to unregister");
            try {
                ServiceManager.aslPropertyManager.valueChangedBoolean(3876, false);
                this.trafficApp = null;
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                if (dSIProxy == null) {
                    this.trace().append("DSIProxy was null!");
                    return;
                }
                if (this.dsiOnlineServiceRegistrationListener != null) {
                    dSIProxy.removeResponseListener(this, class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener = TargetOnlineService.class$("org.dsi.ifc.online.DSIOnlineServiceRegistrationListener")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener, this.dsiOnlineServiceRegistrationListener);
                    this.dsiOnlineServiceRegistrationListener = null;
                }
                this.traceState("ONLINE_SERVICE_REGISTRATION service unregistered");
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void updateDataConnectionAvailable(EventGeneric eventGeneric) {
        this.isOnlineConnectionAvailable = eventGeneric.getBoolean(0);
        if (this.isOnlineConnectionAvailable) {
            this.traceState("Online connection is now available");
            if (this.trafficApp != null || this.dsiOnlineServiceRegistration == null) {
                this.traceState("Connection available and traffic app active. Check license again");
                this.checkLicense();
            }
        } else {
            this.traceState("Online connection is NOT available");
        }
    }

    private void checkLicense() {
        if (this.isLicenseActive) {
            this.sendLicenseAvailable(true);
        } else {
            this.sendLicenseAvailable(false);
            if (this.isOnlineConnectionAvailable && this.trafficApp != null) {
                if (this.activationAttempts < 3) {
                    this.activateLicense();
                } else {
                    this.startTimer(-897187584, (long)0, false);
                }
            }
        }
    }

    private void activateLicense() {
        if (this.isOnlineConnectionAvailable && this.trafficApp != null && this.trafficApp.licenseList != null && this.trafficApp.licenseList.length > 0) {
            if (this.trafficApp.licenseList[0].state != 1) {
                this.traceState("Activating license for online traffic!");
                if (this.activationAttempts < 10) {
                    this.dsiOnlineServiceRegistration.activateLicense(this.trafficApp.licenseList[0]);
                    ++this.activationAttempts;
                }
            } else {
                this.traceState("License already active!");
                this.isLicenseActive = true;
                NAVI_OPTIONS_EXT.setBoolean("OnlineServiceTrafficLicenseValid", true);
                this.checkLicense();
            }
        } else {
            this.error("No license for online traffic available!");
        }
    }

    private void sendLicenseAvailable(boolean bl) {
        this.traceState("sendLicenseAvailable()");
        if (bl) {
            this.traceState("Sending license valid to model and ASL listeners");
            ServiceManager.aslPropertyManager.valueChangedBoolean(3876, true);
        } else {
            this.traceState("Sending license not valid to model and ASL listeners");
            ServiceManager.aslPropertyManager.valueChangedBoolean(3876, false);
        }
        if (this.lastLicenseActiveState != bl) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1222718208);
            eventGeneric.setBoolean(0, bl);
            this.triggerObserver(1222718208, eventGeneric);
            this.lastLicenseActiveState = bl;
        } else {
            this.traceState("ASL event NOT sent because the license status did not change since last time!");
        }
    }

    public void dsiOnlineServiceRegistrationGetServiceListResponse(int n) {
        this.traceState("dsiOnlineServiceRegistrationGetServiceListResponse()");
        if (n == 0) {
            this.traceState("Service list request succeeded! Trying to request the application with license!");
            this.dsiOnlineServiceRegistration.getOnlineApplication("service_dsi_onlinetraffic");
        } else {
            this.traceState("Service list request was not successful!");
        }
    }

    public void dsiOnlineServiceRegistrationGetOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.traceState("dsiOnlineServiceRegistrationGetOnlineApplicationResponse()");
        if (oSRApplication != null) {
            this.trafficApp = oSRApplication;
            this.checkLicense();
            this.requestedTeSaTrafficApp = false;
        } else if (!this.requestedTeSaTrafficApp) {
            this.requestedTeSaTrafficApp = true;
            this.dsiOnlineServiceRegistration.getOnlineApplication("traffic-online_v1");
        } else {
            this.warn().append(super.getClass()).append(": No traffic application found. Online functions may not work correctly!").log();
        }
    }

    public void dsiOnlineServiceRegistrationActivateLicenseResponse(OSRLicense oSRLicense, int n) {
        this.traceState("dsiOnlineServiceRegistrationActivateLicenseResponse()");
        if (oSRLicense != null && (oSRLicense.getState() == 1 || n == 0)) {
            this.traceState("Traffic license activation successful!");
            this.isLicenseActive = true;
            this.activationAttempts = 0;
        } else {
            this.traceState("Traffic license activation NOT successful!");
            this.isLicenseActive = false;
        }
        NAVI_OPTIONS_EXT.setBoolean("OnlineServiceTrafficLicenseValid", this.isLicenseActive);
        this.checkLicense();
    }

    public void dsiOnlineServiceRegistrationAsyncException(int n, String string, int n2) {
    }

    private void updateOnlineServiceLicenseValid(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (bl) {
            int n = NAVI_OPTIONS_EXT.getInt("OnlineServiceTrafficStatus", 0);
            if (n == 1) {
                this.traceState("OnlineLicense active and online traffic activated in setup");
                this.activateOnlineTraffic(true);
            } else {
                this.traceState("OnlineLicense active but online traffic not activated in setup");
                this.activateOnlineTraffic(false);
            }
        } else {
            this.traceState("OnlineLicense NOT active");
            this.activateOnlineTraffic(false);
        }
    }

    private void setOnlineTrafficDataStatus(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n == 1) {
            if (!this.isLicenseActive) {
                if (this.trafficApp != null) {
                    this.checkLicense();
                }
            } else {
                this.activateOnlineTraffic(true);
            }
        } else {
            this.activateOnlineTraffic(false);
        }
    }

    public void dsiOnlineServiceRegistrationUpdateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
        this.traceState("dsiOnlineServiceRegistrationUpdateApplicationState()");
        if (oSRNotifyPropertiesArray != null) {
            for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
                if (!oSRNotifyPropertiesArray[i2].idonlineapp.equalsIgnoreCase("service_dsi_onlinetraffic")) continue;
                this.traceState("AppId ==", "service_dsi_onlinetraffic");
                this.traceState("Reason == ", oSRNotifyPropertiesArray[i2].reason);
                if (oSRNotifyPropertiesArray[i2].reason != 0) break;
                this.traceState("Reason == 0 -> activate license");
                if (!this.isLicenseActive && !NAVI_OPTIONS_EXT.getBoolean("OnlineServiceTrafficLicenseValid", false)) {
                    this.traceState("License is not active yet -> activate!");
                    this.checkLicense();
                }
                break;
            }
        } else {
            this.traceState("OSRNotifyProperties[] props == null");
        }
    }

    private void activateOnlineTraffic(boolean bl) {
        this.traceState("activateOnlineTraffic()");
        if (this.dsiOnlineServiceRegistration != null) {
            if (bl) {
                this.traceState("Activating online traffic!");
                this.dsiOnlineServiceRegistration.setOnlineApplicationState("service_dsi_onlinetraffic", 1);
                ServiceManager.aslPropertyManager.valueChangedInteger(3776, 1);
                NAVI_OPTIONS_EXT.setInt("OnlineServiceTrafficStatus", 1);
            } else {
                this.traceState("Deactivating online traffic!");
                this.dsiOnlineServiceRegistration.setOnlineApplicationState("service_dsi_onlinetraffic", 0);
                ServiceManager.aslPropertyManager.valueChangedInteger(3776, 0);
                NAVI_OPTIONS_EXT.setInt("OnlineServiceTrafficStatus", 0);
            }
        } else {
            this.traceState("DSIOnlineServiceRegistration is null!");
        }
    }

    private void loadPersistence() {
        this.isLicenseActive = NAVI_OPTIONS_EXT.getBoolean("OnlineServiceTrafficLicenseValid", false);
        int n = NAVI_OPTIONS_EXT.getInt("OnlineServiceTrafficStatus", 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(3776, n);
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    private void traceState(String string) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            this.trace().append(super.getClass()).append(": ").append(string).log();
        }
    }

    private void traceState(String string, String string2) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            this.trace().append(super.getClass()).append(": ").append(string).append(" ").append(string2).log();
        }
    }

    private void traceState(String string, int n) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            this.trace().append(super.getClass()).append(": ").append(string).append(": ").append(n).log();
        }
    }

    public DSIServiceLocator getLocator() {
        return this.locator;
    }

    public void setLocator(DSIServiceLocator dSIServiceLocator) {
        this.locator = dSIServiceLocator;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        OBSERVER = new int[]{-1408630720, -1047453440, 1222718208};
        NAVI_OPTIONS_EXT = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence();
    }
}

