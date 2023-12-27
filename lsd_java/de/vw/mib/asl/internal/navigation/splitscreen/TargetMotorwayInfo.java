/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.motorwayinfo.transformer.NavigationMotorwayInfoDataCollector;
import de.vw.mib.asl.internal.navigation.motorwayinfo.transformer.TmcMessageAheadDataCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import edu.emory.mathcs.backport.java.util.Collections;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.HashMap;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public class TargetMotorwayInfo
extends AbstractResettableAslTarget
implements CacheClient,
DSIServiceStateListener {
    private static final int[] OBSERVERS = new int[]{701042752};
    public static final int EV_UPDATE_SPLITSCREEN_MOTORWAY_INFO;
    public static final int EV_UPDATE_SPLITSCREEN_MOTORWAY_INFO_P0_INDEX;
    private static final int ICON_CACHE_ID_MOTORWAY_INFO_ICON_TYPE_EXIT_OR_SAPA_ICON;
    private static final int ICON_CACHE_ID_MOTORWAY_INFO_ICON_TYPE_POI_ICONS;
    private static final int ICON_CACHE_ID_MOTORWAY_INFO_ICON_TYPE_TMC_ICONS;
    private static final int ICON_LIST_ID_SHORT_DESCRIPTION;
    private static final int MAX_TRAFFIC_EVENTS;
    private static final int MAX_SPEED_AND_FLOW_EVENTS;
    private RgInfoForNextDestination destinationInfo;
    private NavPoiInfo[] motorwayInfo;
    private TmcMessage[] tmcMessagesAhead;
    private SpeedAndFlowSegment[] segments;
    private LinkedList motorwayInfoList = new LinkedList();
    private boolean isServiceStateListenerAdded = false;
    private DSINavigation navigationService;
    private DSITmcOnRoute tmcOnRouteService;
    private DSIListener navListener;
    private DSIListener tmcOnRouteListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRouteListener;
    static /* synthetic */ Class array$Ljava$lang$Object;

    public TargetMotorwayInfo(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    public void traceState(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append(super.getClass().getName()).append(" POWER_ON").log();
                }
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMotorwayInfo.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = TargetMotorwayInfo.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute, this);
                }
                this.addObservers(OBSERVERS);
                break;
            }
            case 107: {
                if (!this.isTraceEnabled()) break;
                this.trace().append(super.getClass().getName()).append(" POWER_OFF").log();
                break;
            }
            case 1074841897: {
                this.handleSelectListElement(eventGeneric);
                break;
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        DSIProxy dSIProxy;
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMotorwayInfo.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            this.traceMessage("TargetMotorwayInfo tries to register to ", string);
            dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.navigationService = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMotorwayInfo.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
            this.navListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetMotorwayInfo.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
            this.navigationService.setNotification(new int[]{99, 98, 75}, this.navListener);
            this.traceMessage("TargetMotorwayInfo registered to ", string);
        }
        if (string.intern() == (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = TargetMotorwayInfo.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName().intern()) {
            this.traceMessage("TargetMotorwayInfo tries to register to ", string);
            dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.tmcOnRouteService = (DSITmcOnRoute)dSIProxy.getService(this, class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = TargetMotorwayInfo.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute);
            this.tmcOnRouteListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = TargetMotorwayInfo.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener);
            this.tmcOnRouteService.setNotification(new int[]{1, 6}, this.tmcOnRouteListener);
            this.traceMessage("TargetMotorwayInfo registered to ", string);
        }
    }

    private void initDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.navigationService = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMotorwayInfo.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetMotorwayInfo.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.navigationService.setNotification(new int[]{99, 98, 75}, this.navListener);
        this.tmcOnRouteService = (DSITmcOnRoute)dSIProxy.getService(this, class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = TargetMotorwayInfo.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute);
        this.tmcOnRouteListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = TargetMotorwayInfo.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener);
        this.tmcOnRouteService.setNotification(new int[]{1, 6}, this.tmcOnRouteListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMotorwayInfo.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            try {
                this.unregisterDsiNavigation(string);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
        if (string.intern() == (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = TargetMotorwayInfo.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName().intern()) {
            try {
                this.unregisterDSITmcOnRoute(string);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void unregisterDsiNavigation(String string) {
        this.traceMessage("TargetMotorwayInfo tries to unregister from ", string);
        this.navListener = null;
        this.traceMessage("TargetMotorwayInfo unregistered from ", string);
    }

    private void unregisterDSITmcOnRoute(String string) {
        this.traceMessage("TargetMotorwayInfo tries to unregister from ", string);
        this.tmcOnRouteListener = null;
        this.traceMessage("TargetMotorwayInfo unregistered from ", string);
    }

    private void traceMessage(String string, String string2) {
        if (this.isTraceEnabled()) {
            this.trace().append(string).append(string2).append("...").log();
        }
    }

    private void handleSelectListElement(EventGeneric eventGeneric) {
        this.traceState(new StringBuffer().append("SELECT_LIST_ELEMENT (").append(eventGeneric.getInt(0)).append(")").toString());
        int n = eventGeneric.getInt(0);
        if (n < this.motorwayInfoList.size()) {
            NavLocation navLocation = ((NavigationMotorwayInfoDataCollector)this.motorwayInfoList.get((int)n)).navLocation;
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-1068821504, 1598755840, 1155609344);
            eventGeneric2.setObject(0, navLocation);
            try {
                this.send(eventGeneric2);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setCrosshairLocation(navLocation);
        }
    }

    public void dsiTmcOnRouteUpdateTmcMessagesAhead(TmcMessage[] tmcMessageArray, int n) {
        if (n == 1) {
            this.tmcMessagesAhead = tmcMessageArray;
            if (this.motorwayInfoList != null) {
                this.updateTmcMessageElements();
                this.updateModel();
            }
        }
    }

    public void dsiTmcOnRouteUpdateSpeedAndFlowAhead(SpeedAndFlowSegment[] speedAndFlowSegmentArray, int n) {
        if (n == 1) {
            this.segments = speedAndFlowSegmentArray;
            if (this.motorwayInfoList != null) {
                this.updateSpeedAndFlowElements();
                this.updateModel();
            }
        }
    }

    public void dsiNavigationUpdateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        if (n == 1) {
            this.motorwayInfo = navPoiInfoArray;
            this.updateMotorwayInfoElements();
            this.updateTmcMessageElements();
            this.updateSpeedAndFlowElements();
            this.updateModel();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1068821504, -1085598720, 75956480);
            eventGeneric.setInt(0, this.motorwayInfoList == null || this.motorwayInfoList.size() == 0 ? 0 : 1);
            try {
                this.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
        }
    }

    private void updateModel() {
        ListManager.getGenericASLList(720375808).updateList(this.motorwayInfoList.toArray());
        this.sendHMIEvent(-1110016);
    }

    private void updateMotorwayInfoElements() {
        this.motorwayInfoList = new LinkedList();
        if (this.motorwayInfo != null) {
            for (int i2 = 0; i2 < this.motorwayInfo.length; ++i2) {
                if (!this.isDestinationIndexValid(this.motorwayInfo[i2].destinationIndex)) continue;
                NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = this.createMotorwayInfoListElement(this.motorwayInfo[i2]);
                if (navigationMotorwayInfoDataCollector.dtm <= 0) continue;
                this.motorwayInfoList.addFirst(navigationMotorwayInfoDataCollector);
            }
        }
    }

    private void updateTmcMessageElements() {
        if (this.tmcMessagesAhead != null && this.tmcMessagesAhead.length > 0 && this.motorwayInfoList.size() > 0) {
            int n = 0;
            for (int i2 = this.motorwayInfoList.size() - 1; i2 >= 0; --i2) {
                TmcMessageAheadDataCollector tmcMessageAheadDataCollector;
                int n2;
                NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)this.motorwayInfoList.get(i2);
                navigationMotorwayInfoDataCollector.tmcIcons = null;
                LinkedList linkedList = new LinkedList();
                for (n2 = 0; n2 < this.tmcMessagesAhead.length; ++n2) {
                    tmcMessageAheadDataCollector = this.createTmcMessageAheadListElement(this.tmcMessagesAhead[n2]);
                    if (tmcMessageAheadDataCollector.resourceId <= 0 || tmcMessageAheadDataCollector.dtm <= (long)n || tmcMessageAheadDataCollector.dtm > (long)navigationMotorwayInfoDataCollector.dtm || !this.isDestinationIndexValid(tmcMessageAheadDataCollector.destinationIndex)) continue;
                    linkedList.add(tmcMessageAheadDataCollector);
                }
                n = navigationMotorwayInfoDataCollector.dtm;
                if (linkedList.size() <= 0) continue;
                Collections.sort(linkedList);
                navigationMotorwayInfoDataCollector.tmcIcons = new ResourceLocator[linkedList.size() > 3 ? 3 : linkedList.size()];
                for (n2 = 0; n2 < navigationMotorwayInfoDataCollector.tmcIcons.length; ++n2) {
                    tmcMessageAheadDataCollector = (TmcMessageAheadDataCollector)linkedList.get(n2);
                    Object[] objectArray = new Object[]{new Integer(2), navigationMotorwayInfoDataCollector, new Integer(n2)};
                    navigationMotorwayInfoDataCollector.tmcIcons[n2] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTMCEventIcon(tmcMessageAheadDataCollector.resourceId, 0, 1, this, objectArray);
                }
            }
        }
    }

    private void updateSpeedAndFlowElements() {
        if (this.segments != null && this.segments.length > 0 && this.motorwayInfoList.size() > 0) {
            int n = 0;
            for (int i2 = 0; i2 < this.motorwayInfoList.size(); ++i2) {
                NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)this.motorwayInfoList.get(this.motorwayInfoList.size() - i2 - 1);
                int n2 = n;
                int n3 = 0;
                while (n2 < this.segments.length && n3 < 4) {
                    navigationMotorwayInfoDataCollector.speedFlowSegments[3 - n3] = 0;
                    if (this.isDestinationIndexValid(this.segments[n2].destinationIndex) && this.segments[n2].distance >= navigationMotorwayInfoDataCollector.distance && this.calculateDTM(this.segments[n2].distance) > 0) {
                        navigationMotorwayInfoDataCollector.speedFlowSegments[3 - n3] = this.segments[n2].severity;
                    }
                    ++n2;
                    ++n3;
                    ++n;
                }
            }
        }
    }

    private NavigationMotorwayInfoDataCollector createMotorwayInfoListElement(NavPoiInfo navPoiInfo) {
        ILocationWrapper iLocationWrapper;
        NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = new NavigationMotorwayInfoDataCollector();
        if (navPoiInfo.type == 1) {
            iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navPoiInfo.exitPoiLocation);
            navigationMotorwayInfoDataCollector.navLocation = navPoiInfo.exitPoiLocation;
            navigationMotorwayInfoDataCollector.exitOrSAPAIcon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, this, new Object[]{new Integer(0), navigationMotorwayInfoDataCollector});
            navigationMotorwayInfoDataCollector.name = navPoiInfo.signpostInfo;
            navigationMotorwayInfoDataCollector.exitNumber = navPoiInfo.exitNumber;
        } else if (navPoiInfo.type == 2 && navPoiInfo.poiLocations != null && navPoiInfo.poiLocations.length > 0) {
            iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navPoiInfo.poiLocations[0]);
            navigationMotorwayInfoDataCollector.navLocation = navPoiInfo.poiLocations[0];
            navigationMotorwayInfoDataCollector.exitOrSAPAIcon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, this, new Object[]{new Integer(0), navigationMotorwayInfoDataCollector});
            navigationMotorwayInfoDataCollector.name = iLocationWrapper.getPoiName();
            navigationMotorwayInfoDataCollector.exitNumber = "";
        }
        navigationMotorwayInfoDataCollector.poiIcons = new ResourceLocator[navPoiInfo.getPoiIcons().length];
        for (int i2 = 0; i2 < navPoiInfo.getPoiIcons().length; ++i2) {
            navigationMotorwayInfoDataCollector.poiIcons[i2] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(navPoiInfo.getPoiIcons()[i2].criteria1, navPoiInfo.getPoiIcons()[i2].criteria2, 0, this, new Object[]{new Integer(1), navigationMotorwayInfoDataCollector, new Integer(i2)});
        }
        navigationMotorwayInfoDataCollector.distance = navPoiInfo.distance;
        navigationMotorwayInfoDataCollector.dtm = this.calculateDTM(navPoiInfo.distance);
        int[] nArray = this.calculateRTT(navPoiInfo.remainingTime / 0);
        navigationMotorwayInfoDataCollector.rtth = nArray[0];
        navigationMotorwayInfoDataCollector.rttm = nArray[1];
        return navigationMotorwayInfoDataCollector;
    }

    private TmcMessageAheadDataCollector createTmcMessageAheadListElement(TmcMessage tmcMessage) {
        TmcMessageAheadDataCollector tmcMessageAheadDataCollector = new TmcMessageAheadDataCollector();
        tmcMessageAheadDataCollector.id = tmcMessage.messageID;
        tmcMessageAheadDataCollector.distance = tmcMessage.distanceToEvent;
        tmcMessageAheadDataCollector.dtm = this.calculateDTM(tmcMessage.distanceToEvent);
        tmcMessageAheadDataCollector.resourceId = tmcMessage.iconListId[0];
        tmcMessageAheadDataCollector.destinationIndex = tmcMessage.destinationIndex;
        return tmcMessageAheadDataCollector;
    }

    public void dsiNavigationUpdateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        if (n == 1) {
            if (this.isDestinationIndexValid(rgInfoForNextDestination.destinationIndex)) {
                this.destinationInfo = rgInfoForNextDestination;
            }
            this.updateMotorwayInfoElements();
            this.updateTmcMessageElements();
            this.updateSpeedAndFlowElements();
            this.updateModel();
        }
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        if (n == 1) {
            if (this.isDestinationIndexValid(rgInfoForNextDestination.destinationIndex)) {
                this.destinationInfo = rgInfoForNextDestination;
            }
            this.updateMotorwayInfoElements();
            this.updateTmcMessageElements();
            this.updateSpeedAndFlowElements();
            this.updateModel();
        }
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (object.getClass() == (array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = TargetMotorwayInfo.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object)) {
            Object[] objectArray = (Object[])object;
            int n = (Integer)objectArray[0];
            switch (n) {
                case 0: {
                    NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)objectArray[1];
                    navigationMotorwayInfoDataCollector.exitOrSAPAIcon = resourceLocator;
                    break;
                }
                case 1: {
                    NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)objectArray[1];
                    Integer n2 = (Integer)objectArray[2];
                    if (n2 >= navigationMotorwayInfoDataCollector.poiIcons.length) break;
                    navigationMotorwayInfoDataCollector.poiIcons[n2.intValue()] = resourceLocator;
                    break;
                }
                case 2: {
                    NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)objectArray[1];
                    Integer n3 = (Integer)objectArray[2];
                    if (n3 >= navigationMotorwayInfoDataCollector.tmcIcons.length) break;
                    navigationMotorwayInfoDataCollector.tmcIcons[n3.intValue()] = resourceLocator;
                    break;
                }
            }
        }
        this.updateModel();
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    private int calculateDTM(long l) {
        long l2 = 0L;
        if (this.destinationInfo != null) {
            l2 = this.destinationInfo.distanceToNextDest;
            if ((l2 -= l) < 0L) {
                l2 = 0L;
            }
        }
        return (int)l2;
    }

    private int[] calculateRTT(long l) {
        int n;
        int[] nArray = new int[]{0, 0};
        if (this.destinationInfo != null && (n = (int)(this.destinationInfo.timeToNextDest - l)) > 0) {
            nArray[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttHours(n * 1000);
            nArray[1] = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttMinutes(n * 1000);
        }
        return nArray;
    }

    boolean isDestinationIndexValid(int n) {
        return n == 0 || !ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive();
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMotorwayInfo.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("TargetMotorwayInfo: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.initDSI();
        } else if (this.isTraceEnabled()) {
            this.trace("TargetMotorwayInfo: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.motorwayInfoList = new LinkedList();
        this.destinationInfo = null;
        this.motorwayInfo = null;
        this.tmcMessagesAhead = null;
        this.segments = null;
        this.motorwayInfoList = new LinkedList();
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

