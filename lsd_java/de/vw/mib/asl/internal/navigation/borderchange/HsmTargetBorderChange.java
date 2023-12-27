/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.borderchange;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.borderchange.transformer.BorderCrossingCollector;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.borderchange.transformer.NavigationBorderChangeNewCountryCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public final class HsmTargetBorderChange
extends AbstractResettableAslTarget
implements CacheClient,
DSIServiceStateListener {
    private DSITrafficRegulation dsiTrafficRegulation;
    private DSIListener trafficRegulationListener;
    private DSINavigation dsiNavigation;
    private DSIListener navigationListener;
    private INavigationDP datapool = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private boolean wasServiceStateListenerRegistered = false;
    NavLocation loc = null;
    RoadClassSpeedInfo[] roadClassSpeedInfoResult = null;
    BorderCrossingCollector[] crossInfoCollectorResult = new BorderCrossingCollector[0];
    NavigationBorderChangeNewCountryCollector newCountryColl = new NavigationBorderChangeNewCountryCollector();
    private Map pendingIconsForCountry = new HashMap();
    private boolean resetCountryInfoBox = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener;

    public HsmTargetBorderChange(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    private boolean traceStatus() {
        return ServiceManager.logger.isTraceEnabled(this.getSubClassifier());
    }

    private LogMessage getLogMsg() {
        LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
        logMessage.append("BC: ");
        return logMessage;
    }

    public void traceState(String string) {
        if (this.traceStatus()) {
            LogMessage logMessage = this.getLogMsg();
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    private void traceState(String[] stringArray) {
        if (this.traceStatus()) {
            LogMessage logMessage = this.getLogMsg();
            logMessage.append(super.getClass());
            logMessage.append(": ");
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                logMessage.append(stringArray[i2]);
            }
            logMessage.log();
        }
    }

    public void registerAsServiceStateListener() {
        if (!this.wasServiceStateListenerRegistered) {
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBorderChange.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetBorderChange.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation, this);
            this.wasServiceStateListenerRegistered = true;
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerAsServiceStateListener();
                break;
            }
        }
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.traceState("dsiNavigationUpdateRgActive");
        this.traceState(new StringBuffer("Demo Mode Status: ").append(this.isDemoModeRunning() ? "true" : "false").toString());
        if (!this.resetCountryInfoBox) {
            this.traceState("dsiNavigationUpdateRgActive -- RESET loc");
            this.loc = null;
        }
    }

    public void dsiNavigationUpdateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
        this.traceState(new String[]{"dsiNavigationUpdateSoPosPositionDescription: ", navLocation.toString()});
        if (n == 1 && navLocation != null) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            String string = iLocationWrapper.getCountryCode();
            String string2 = iLocationWrapper.getCountry();
            String string3 = "";
            String string4 = "";
            if (this.loc != null) {
                ILocationWrapper iLocationWrapper2 = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.loc);
                string3 = iLocationWrapper2.getCountryCode();
                string4 = iLocationWrapper2.getCountry();
            }
            this.traceState(new StringBuffer().append("New country/country code ").append(string2).append("/").append(string).toString());
            this.traceState(new StringBuffer().append("Current country/country code ").append(string4).append("/").append(string3).toString());
            if (string != null && !"".equals(string)) {
                if (this.loc == null || !string3.equals(string)) {
                    this.resetCountryInfoBox = false;
                    if (this.loc == null) {
                        this.traceState(new String[]{"Country Info. Initialisation or Reset after RG->false : ", string});
                        this.resetCountryInfoBox = true;
                    } else if (this.isDemoModeRunning() && this.euclideanDistance(navLocation, this.datapool.getDemoLocation()) < 1000) {
                        this.traceState(new String[]{"Demo restart: ", string});
                        this.resetCountryInfoBox = true;
                    } else if (!string3.equals(string)) {
                        this.traceState(new String[]{"Border Change Detected from: ", string3, " to: ", string});
                    }
                    this.traceState("Updating loc to new NavLocation object 1");
                    this.loc = iLocationWrapper.getLocationCopy();
                    this.dsiTrafficRegulation.requestRoadClassSpeedInfoForCountry(string);
                } else {
                    if (!string4.equals(string2)) {
                        this.traceState("Updating Country Name displayed in Speed Info Box (Language change occured)");
                        this.newCountryColl.navigation_borderchange_new_country_country_name = string2;
                        ListManager.getGenericASLList(760).updateList(new NavigationBorderChangeNewCountryCollector[]{this.newCountryColl});
                    }
                    this.traceState("Updating loc to new NavLocation object 2");
                    this.loc = iLocationWrapper.getLocationCopy();
                }
            }
        } else {
            this.traceState("NavLocation -- NOT VALID!!");
        }
    }

    private boolean isDemoModeRunning() {
        this.traceState("isDemoModeRunning");
        boolean bl = false;
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getEtcDemoModeState()) {
            bl = true;
        }
        this.traceState(new StringBuffer("RG Active: ").append(ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive() ? "true" : "false").toString());
        this.traceState(new StringBuffer("Demo Mode: ").append(ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getEtcDemoModeState() ? "true" : "false").toString());
        return bl;
    }

    private int euclideanDistance(NavLocation navLocation, NavLocation navLocation2) {
        this.traceState("euclideanDistance");
        int n = 0;
        double d2 = 0.0;
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation).getLatitude();
        int n3 = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation2).getLatitude();
        int n4 = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation).getLongitude();
        int n5 = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation2).getLongitude();
        d2 = Math.sqrt(Math.pow(n2 - n3, 2.0) + Math.pow(n4 - n5, 2.0));
        n = (int)d2;
        this.traceState(new String[]{"euclideanDistance: nl1: lat = ", Integer.toString(n2), " nl1: lon = ", Integer.toString(n4), " nl2: lat = ", Integer.toString(n3), " nl2: lon = ", Integer.toString(n5), "   distance = ", Integer.toString(n)});
        return n;
    }

    public void dsiTrafficRegulationRequestRoadClassSpeedInfoForCountryResult(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
        StringBuffer stringBuffer = new StringBuffer("dsiTrafficRegulationRequestRoadClassSpeedInfoForCountryResult: ").append(roadClassSpeedInfoArray == null ? "null" : new Integer(roadClassSpeedInfoArray.length).toString());
        this.traceState(stringBuffer.toString());
        this.processBorderInformation(roadClassSpeedInfoArray);
    }

    private void processBorderInformation(RoadClassSpeedInfo[] roadClassSpeedInfoArray) {
        this.traceState("processBorderInformation");
        if (this.isTraceEnabled()) {
            this.info().append("roadClassSpeedInfo: ").append(roadClassSpeedInfoArray.length).log();
        }
        String string = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.loc).getCountryCode();
        String string2 = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.loc).getCountry();
        if (roadClassSpeedInfoArray != null && roadClassSpeedInfoArray.length > 0) {
            this.processSpeedInfo(roadClassSpeedInfoArray);
            this.newCountryColl.navigation_borderchange_border_crossing_info = true;
            this.newCountryColl.navigation_borderchange_border_cross_info_speed_unit = this.roadClassSpeedInfoResult[0].speedUnit;
            this.newCountryColl.navigation_borderchange_new_country_country_code = string;
            this.newCountryColl.navigation_borderchange_new_country_country_flag = null;
            this.newCountryColl.navigation_borderchange_new_country_country_name = string2;
            Object object = this.pendingIconsForCountry.get(string.toUpperCase());
            ListManager.getGenericASLList(760).updateList(new NavigationBorderChangeNewCountryCollector[]{this.newCountryColl});
            if (!this.resetCountryInfoBox) {
                this.traceState("handleIconCacheUpdate -- NO RESET -- 2nd popup opportunity");
                ServiceManager.aslPropertyManager.valueChangedInteger(755, 4);
                this.borderChangeInfoTrace();
            } else if (this.resetCountryInfoBox) {
                this.traceState("handleIconCacheUpdate -- 2nd popup opportunity -- resetCountryInfoBox = true");
            } else if (object == null) {
                this.traceState("handleIconCacheUpdate -- 2nd popup opportunity -- o == null");
            } else if (((Boolean)object).booleanValue()) {
                this.traceState("handleIconCacheUpdate -- 2nd popup opportunity -- ((Boolean) (o)).booleanValue()");
            }
            this.traceState("processSpeedInfo -- END");
        }
    }

    private void processSpeedInfo(RoadClassSpeedInfo[] roadClassSpeedInfoArray) {
        this.traceState("processSpeedInfo -- START");
        String string = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.loc).getCountryCode();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BorderCrossingCollector[] borderCrossingCollectorArray = new BorderCrossingCollector[roadClassSpeedInfoArray.length];
        for (int i2 = 0; i2 < roadClassSpeedInfoArray.length; ++i2) {
            if (roadClassSpeedInfoArray[i2] == null) continue;
            String string2 = roadClassSpeedInfoArray[i2].countryAbbreviation.toUpperCase();
            this.info().append("COUNTRY SPEED INFORMATION FOR:").append(string2);
            if (!string2.equals(string.toUpperCase())) continue;
            this.traceState("processSpeedInfo -- start if");
            borderCrossingCollectorArray[i2] = new BorderCrossingCollector();
            borderCrossingCollectorArray[i2].myInfoSpeed = roadClassSpeedInfoArray[i2].speedLimit;
            borderCrossingCollectorArray[i2].mySpeedImage = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTrafficRegulationIcon(roadClassSpeedInfoArray[i2].roadSignIconReference, roadClassSpeedInfoArray[i2].variant, 1, this, new Object[]{Boolean.TRUE, borderCrossingCollectorArray[i2]});
            borderCrossingCollectorArray[i2].myImage = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForRoadClassIcon(roadClassSpeedInfoArray[i2].roadClassIconReference, roadClassSpeedInfoArray[i2].variant, 1, this, new Object[]{Boolean.FALSE, borderCrossingCollectorArray[i2]});
            arrayList.add(borderCrossingCollectorArray[i2]);
            arrayList2.add(roadClassSpeedInfoArray[i2]);
            this.traceState("processSpeedInfo -- end if");
        }
        this.crossInfoCollectorResult = (BorderCrossingCollector[])arrayList.toArray(new BorderCrossingCollector[0]);
        this.roadClassSpeedInfoResult = (RoadClassSpeedInfo[])arrayList2.toArray(new RoadClassSpeedInfo[0]);
        ListManager.getGenericASLList(761).updateList(this.crossInfoCollectorResult);
    }

    private boolean allIconsLoaded() {
        this.traceState(new String[]{"allIconsLoaded - entered: crossInfoCollectorResult.length: ", Integer.toString(this.crossInfoCollectorResult.length)});
        String string = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.loc).getCountryCode();
        if (this.crossInfoCollectorResult != null && this.crossInfoCollectorResult.length != 0) {
            for (int i2 = 0; i2 < this.crossInfoCollectorResult.length; ++i2) {
                if (this.crossInfoCollectorResult[i2].myImage != null && this.crossInfoCollectorResult[i2].mySpeedImage != null) continue;
                this.traceState(new String[]{"allIconsLoaded: return false (1): ", Integer.toString(i2)});
                return false;
            }
            this.pendingIconsForCountry.put(string.toUpperCase(), Boolean.FALSE);
            this.traceState("allIconsLoaded: return true");
            return true;
        }
        this.traceState("allIconsLoaded: return false (2)");
        return false;
    }

    private void borderChangeInfoTrace() {
        LogMessage logMessage = this.info();
        logMessage.append("BC -- BorderChangeInfo: (");
        logMessage.append(this.newCountryColl.navigation_borderchange_border_crossing_info);
        logMessage.append(" ");
        logMessage.append(this.newCountryColl.navigation_borderchange_border_cross_info_speed_unit);
        logMessage.append(" ");
        logMessage.append(this.newCountryColl.navigation_borderchange_new_country_country_code);
        logMessage.append(" ");
        logMessage.append(this.newCountryColl.navigation_borderchange_new_country_country_name);
        logMessage.append(" ");
        logMessage.append(this.newCountryColl.navigation_borderchange_new_country_country_flag);
        logMessage.append(" ");
        if (this.crossInfoCollectorResult != null) {
            for (int i2 = 0; i2 < this.crossInfoCollectorResult.length; ++i2) {
                logMessage.append("cross info: {");
                logMessage.append(i2);
                logMessage.append(" ");
                logMessage.append(this.crossInfoCollectorResult[i2].myInfoSpeed);
                logMessage.append(" ");
                logMessage.append(this.roadClassSpeedInfoResult[i2].roadClassIconReference);
                logMessage.append(" ");
                logMessage.append(this.crossInfoCollectorResult[i2].myImage);
                logMessage.append(" ");
                logMessage.append(this.roadClassSpeedInfoResult[i2].roadSignIconReference);
                logMessage.append(" ");
                logMessage.append(this.crossInfoCollectorResult[i2].mySpeedImage);
                logMessage.append("}; ");
            }
        }
        logMessage.append(")");
        logMessage.log();
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.traceState("handleIconCacheUpdate");
        Object[] objectArray = (Object[])object;
        BorderCrossingCollector borderCrossingCollector = (BorderCrossingCollector)objectArray[1];
        if (Boolean.TRUE.equals(objectArray[0])) {
            borderCrossingCollector.mySpeedImage = resourceLocator;
        } else {
            borderCrossingCollector.myImage = resourceLocator;
        }
        if (this.allIconsLoaded()) {
            this.traceState("handleIconCacheUpdate -- allIconsLoaded: true");
            ListManager.getGenericASLList(760).updateList(new NavigationBorderChangeNewCountryCollector[]{this.newCountryColl});
            ListManager.getGenericASLList(761).updateList(this.crossInfoCollectorResult);
            if (!this.resetCountryInfoBox) {
                this.traceState("handleIconCacheUpdate -- NO RESET --1st popup opportunity");
                ServiceManager.aslPropertyManager.valueChangedInteger(755, 4);
                this.borderChangeInfoTrace();
            } else {
                this.traceState("handleIconCacheUpdate -- 1st popup opportunity -- resetCountryInfoBox = true");
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        if (this.isFirstStartupDone) {
            return;
        }
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBorderChange.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            this.initDsiNavigation();
        } else if (string.intern() == (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetBorderChange.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName().intern()) {
            this.initDsiTrafficRegulation();
        }
        if (this.dsiNavigation != null && this.dsiTrafficRegulation != null) {
            this.isFirstStartupDone = true;
        }
    }

    private void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBorderChange.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetBorderChange.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetBorderChange.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.dsiNavigation.setNotification(new int[]{84, 29, 11}, this.navigationListener);
    }

    private void initDsiTrafficRegulation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiTrafficRegulation = (DSITrafficRegulation)dSIProxy.getService(this, class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetBorderChange.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation);
        this.trafficRegulationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = HsmTargetBorderChange.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = HsmTargetBorderChange.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener, this.trafficRegulationListener);
        this.dsiTrafficRegulation.setNotification(new int[]{2}, this.trafficRegulationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetBorderChange tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBorderChange.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDSINavigation(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetBorderChange.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName().intern()) {
                this.unregisterDSITrafficRegulation(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDSITrafficRegulation(String string, DSIProxy dSIProxy) {
        if (this.trafficRegulationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = HsmTargetBorderChange.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener, this.trafficRegulationListener);
        }
        this.traceUnregisterDone(string);
    }

    private void unregisterDSINavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetBorderChange.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        }
        this.traceUnregisterDone(string);
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetBorderChange unregistered from ").append(string).log();
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBorderChange.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetBorderChange: resetting values after DSI restart");
            }
            this.initDefaultValues();
            this.initDsiNavigation();
        }
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetBorderChange.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName(), 0)) {
            this.initDefaultValues();
            this.initDsiTrafficRegulation();
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetBorderChange: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initDefaultValues() {
        this.loc = null;
        this.roadClassSpeedInfoResult = null;
        this.crossInfoCollectorResult = new BorderCrossingCollector[0];
        this.newCountryColl = new NavigationBorderChangeNewCountryCollector();
        this.pendingIconsForCountry = new HashMap();
        this.resetCountryInfoBox = false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

