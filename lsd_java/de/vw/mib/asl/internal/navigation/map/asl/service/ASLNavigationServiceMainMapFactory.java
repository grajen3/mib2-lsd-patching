/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.asl.service;

import de.vw.mib.asl.api.navigation.map.ASLNavigationServiceMainMap;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapEvents;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapTarget;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ASLNavigationServiceMainMapFactory
extends AbstractTarget {
    private static final int[] ASL_OBSERVER = new int[]{425997568};
    private static IExtLogger LOGGER = null;
    private static final Map MAP_TARGET_ID_HSM = new HashMap();
    protected static ASLNavigationServiceMainMapFactory INSTANCE = null;
    private static final int NO_TARGET_ID_AVAILABLE;

    private static IExtLogger getLogger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[ASLNavigationServiceMainMapFactory]");
        }
        return LOGGER;
    }

    public static ASLNavigationServiceMainMap createMainMapService(AbstractTarget abstractTarget, int[] nArray) {
        if (INSTANCE == null) {
            ASLNavigationServiceMainMapFactory.getLogger().error("createMainMapService() shall be invoked after EVENT_SERVICE_INIT!");
            return null;
        }
        return INSTANCE.addTarget(abstractTarget, nArray);
    }

    public ASLNavigationServiceMainMapFactory(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        INSTANCE = this;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.handlePowerOn();
                break;
            }
            case 101003: {
                this.handleTargetPrepareOn();
                break;
            }
            case 101001: {
                this.handleTargetGoOn();
                break;
            }
            case 3499033: {
                this.handleNaviPostStartup();
                break;
            }
        }
    }

    private void handleNaviPostStartup() {
        ASLNavigationServiceMainMapFactory.getLogger().trace("handleNaviPostStartup( )");
        ASLNavigationServiceMainMapEvents.sendEventServiceInit();
    }

    private void handlePowerOn() {
    }

    private void handleTargetGoOn() {
    }

    private void handleTargetPrepareOn() {
        this.addObservers(ASL_OBSERVER);
    }

    protected boolean isAnyServiceLocked() {
        Set set = MAP_TARGET_ID_HSM.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            ASLNavigationServiceMainMapTarget aSLNavigationServiceMainMapTarget = (ASLNavigationServiceMainMapTarget)MAP_TARGET_ID_HSM.get(iterator.next());
            if (!aSLNavigationServiceMainMapTarget.datapool.isMapViewerLocked()) continue;
            return true;
        }
        return false;
    }

    void sentToAllMapServiceTargets(EventGeneric eventGeneric) {
        Set set = MAP_TARGET_ID_HSM.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            ASLNavigationServiceMainMapTarget aSLNavigationServiceMainMapTarget = (ASLNavigationServiceMainMapTarget)MAP_TARGET_ID_HSM.get(iterator.next());
            EventGeneric eventGeneric2 = ServiceManager.eventMain.getEventFactory().newEvent(eventGeneric);
            ASLNavigationServiceMainMapEvents.sendEventToTarget(aSLNavigationServiceMainMapTarget.getClientTarget(), eventGeneric2);
        }
    }

    private ASLNavigationServiceMainMap addTarget(AbstractTarget abstractTarget, int[] nArray) {
        ASLNavigationServiceMainMapFactory.getLogger().trace("addTarget()");
        if (abstractTarget == null) {
            ASLNavigationServiceMainMapFactory.getLogger().error("The target can't be null, execution stopped");
            return null;
        }
        if (MAP_TARGET_ID_HSM.size() > 10) {
            ASLNavigationServiceMainMapFactory.getLogger().error("Can't create a new 'ASLNavigationServiceMainMap' because there are already 10 clients, more are note supported at the moment. Please contact the HMI-Nav-Map-Team.");
            return null;
        }
        Integer n = new Integer(abstractTarget.getTargetId());
        if (MAP_TARGET_ID_HSM.containsKey(n)) {
            ASLNavigationServiceMainMapFactory.getLogger().makeError().append("Can't create a service for targetId '").append(n).append("', the target is already registred.").log();
            return null;
        }
        int n2 = this.findFreeTargetId();
        if (n2 == -1) {
            return null;
        }
        try {
            ASLNavigationServiceMainMapTarget aSLNavigationServiceMainMapTarget = new ASLNavigationServiceMainMapTarget(ServiceManager.eventMain, n2, "hsmtask", abstractTarget, nArray);
            MAP_TARGET_ID_HSM.put(n, aSLNavigationServiceMainMapTarget);
            aSLNavigationServiceMainMapTarget.getHsm().onStart();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(106);
            eventGeneric.setReceiverEventId(106);
            aSLNavigationServiceMainMapTarget.gotEvent(eventGeneric);
            return aSLNavigationServiceMainMapTarget;
        }
        catch (Exception exception) {
            ASLNavigationServiceMainMapFactory.getLogger().error("Exception while creating service.");
            return null;
        }
    }

    private int findFreeTargetId() {
        switch (MAP_TARGET_ID_HSM.size()) {
            case 0: {
                return -1538583552;
            }
            case 1: {
                return -1521806336;
            }
            case 2: {
                return -1505029120;
            }
            case 3: {
                return -1488251904;
            }
            case 4: {
                return -1471474688;
            }
            case 5: {
                return -1454697472;
            }
            case 6: {
                return -1437920256;
            }
            case 7: {
                return -1421143040;
            }
            case 8: {
                return -1404365824;
            }
            case 9: {
                return -1387588608;
            }
        }
        ASLNavigationServiceMainMapFactory.getLogger().error("No target id avaiable");
        return -1;
    }
}

