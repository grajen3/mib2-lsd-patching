/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.asl.service;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.ServiceRegister;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;

public class ASLNavigationServiceMainMapEvents {
    private static IExtLogger LOGGER = null;
    private static final int[] MAINMAP_SERVICES = new int[]{1524708096, 1457599232, 1491153664, 1507930880, 1273049856, 1356935936, 1373713152, 1424044800, 1407267584, 1340158720, 1323381504, 1306604288, 1575039744, 342111488, 358888704, 375665920, 929314048, 946091264, 962868480, 979645696, 996422912, 1013200128};
    static final int[] ASL_OBSERVERS = new int[]{375665920};
    static final int[] ATTRIBUTES_MAPVIEWERCONTROL = new int[]{10, 9, 47, 46, 13, 1, 8};
    static final int[] ATTRITBUTES_NAVIGATION = new int[]{52};

    private static IExtLogger getLogger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[ASLNavigationServiceMainMapEvents]");
        }
        return LOGGER;
    }

    private static EventGeneric createEvent(int n) {
        return ServiceManager.mGenericEventFactory.newEvent(n);
    }

    static void sendEventToTarget(AbstractTarget abstractTarget, EventGeneric eventGeneric) {
        try {
            eventGeneric.setReceiverTargetId(abstractTarget.getTargetId());
            if (ASLNavigationServiceMainMapEvents.getLogger().isTraceEnabled()) {
                ASLNavigationServiceMainMapEvents.getLogger().makeTrace().append("sendEventToTarget(evId=").append(eventGeneric.getServiceId()).append(", targetId=").append(eventGeneric.getReceiverTargetId()).append(")").log();
            }
            ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            ASLNavigationServiceMainMapEvents.getLogger().error(genericEventException.toString());
        }
    }

    private static void sendEventToService(EventGeneric eventGeneric) {
        try {
            if (ASLNavigationServiceMainMapEvents.getLogger().isTraceEnabled()) {
                ASLNavigationServiceMainMapEvents.getLogger().makeTrace().append("sendEventToService(serviceId=").append(eventGeneric.getServiceId()).append(")").log();
            }
            ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            ASLNavigationServiceMainMapEvents.getLogger().error(genericEventException.toString());
        }
    }

    static void registerServices() {
        ServiceRegister serviceRegister = ServiceManager.eventMain.getServiceRegister();
        for (int i2 = 0; i2 < MAINMAP_SERVICES.length; ++i2) {
            serviceRegister.registerService(MAINMAP_SERVICES[i2], -1152707584, MAINMAP_SERVICES[i2], true);
        }
    }

    public static void preRegisterServices() {
        for (int i2 = 0; i2 < MAINMAP_SERVICES.length; ++i2) {
            PreRegisteredIds.addServiceOrObserverToArray(0, -1152707584, MAINMAP_SERVICES[i2], true);
        }
    }

    static void sendEventServiceError(AbstractTarget abstractTarget, int n) {
        ASLNavigationServiceMainMapEvents.getLogger().makeError().append("sendEventServiceError( targetId=").append(abstractTarget.getTargetId()).append(", errorCode=").append(n).append(" )").log();
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1457599232);
        eventGeneric.setInt(0, n);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    static void sendEventServiceStatusChange(boolean bl) {
        EventGeneric eventGeneric = bl ? ServiceManager.mGenericEventFactory.newEvent(1491153664) : ServiceManager.mGenericEventFactory.newEvent(1507930880);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }

    static void sendEventMapLocked(AbstractTarget abstractTarget) {
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1373713152);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    static void sendEventMapClickInMapResult(AbstractTarget abstractTarget, PosInfo[] posInfoArray) {
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1273049856);
        eventGeneric.setObject(0, posInfoArray);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    static void sendEventMapZoomListUpdate(AbstractTarget abstractTarget, int[] nArray) {
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1424044800);
        eventGeneric.setObject(0, nArray);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    static void sendEventMapPositionUpdate(AbstractTarget abstractTarget, NavLocationWgs84 navLocationWgs84) {
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1356935936);
        eventGeneric.setObject(0, navLocationWgs84);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    static void sendEventMapZoomLevelUpdate(AbstractTarget abstractTarget, int n, int n2) {
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1407267584);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    static void sendEventMapGoToLocationMapReady(AbstractTarget abstractTarget) {
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1306604288);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    static void sendEventMapLayersAvailable(AbstractTarget abstractTarget, int[] nArray) {
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1323381504);
        eventGeneric.setObject(0, nArray);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    static void sendEventMapLayersVisibleUpdate(AbstractTarget abstractTarget, int[] nArray) {
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1340158720);
        eventGeneric.setObject(0, nArray);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    static void sendEventZoomIn() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1409417280);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }

    static void sendEventZoomOut() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1442971712);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }

    static void sendEventTwoFingerZoomed(int n, int n2, int n3, int n4) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-523759552);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setInt(3, n4);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }

    static void sendEventToggleOverviewZoom() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1342308416);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }

    static void sendEventCenterMapToCCP() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1224867904);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }

    static void sendEventToggleAutozoom() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(889323584);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }

    static void sendEventServiceInit() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1524708096);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }

    static void sendEventClickInMap(int n, int n2, int n3) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1258422336);
        eventGeneric.setInt(0, n3);
        eventGeneric.setInt(1, n);
        eventGeneric.setInt(2, n2);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }

    static void sendEventServiceErrorAPICall(AbstractTarget abstractTarget, int n, int n2) {
        ASLNavigationServiceMainMapEvents.getLogger().makeError().append("sendEventServiceErrorAPICall( targetId=").append(abstractTarget).append(", requestType=").append(n).append(", errorCode=").append(n2).append(" )").log();
        EventGeneric eventGeneric = ASLNavigationServiceMainMapEvents.createEvent(1457599232);
        eventGeneric.setInt(0, 6);
        eventGeneric.setInt(1, n);
        eventGeneric.setInt(2, n2);
        ASLNavigationServiceMainMapEvents.sendEventToTarget(abstractTarget, eventGeneric);
    }

    public static void sendEventKombiMapSwitchState(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1575039744);
        eventGeneric.setInt(0, n);
        ASLNavigationServiceMainMapEvents.sendEventToService(eventGeneric);
    }
}

