/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.log4mib.Logger;

public class ASLNavigationEventFactory {
    private static Logger LOGGER = ServiceManager.logger;

    public static EventGeneric createEvent(int n) {
        return ServiceManager.mGenericEventFactory.newEvent(n);
    }

    public static void registerService(int n, AbstractTarget abstractTarget) {
        ASLNavigationEventFactory.registerService(n, abstractTarget.getTargetId());
    }

    public static void registerService(int n, int n2) {
        if (ASLNavigationEventFactory.getLogger().isTraceEnabled(16384)) {
            ASLNavigationEventFactory.getLogger().trace(16384).append("[ASLNavigationEventFactory]").append("registerService(serviceId=").append(n).append(", targetId=").append(n2).append(")").log();
        }
        ServiceManager.eventMain.getServiceRegister().registerService(n, n2);
    }

    public static void sendEventToAllObservers(EventGeneric eventGeneric) {
        if (ASLNavigationEventFactory.getLogger().isTraceEnabled(16384)) {
            ASLNavigationEventFactory.getLogger().trace(16384).append("[ASLNavigationEventFactory]").append("sendEventToAllObservers(serviceId=").append(eventGeneric.getServiceId()).append(")").log();
        }
        ServiceManager.eventMain.getServiceRegister().triggerObserver(eventGeneric.getServiceId(), eventGeneric);
    }

    public static void sendEventToService(EventGeneric eventGeneric) {
        try {
            if (ASLNavigationEventFactory.getLogger().isTraceEnabled(16384)) {
                ASLNavigationEventFactory.getLogger().trace(16384).append("[ASLNavigationEventFactory]").append("sendEventToService(serviceId=").append(eventGeneric.getServiceId()).append(")").log();
            }
            ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            ASLNavigationEventFactory.getLogger().error(16384, "[ASLNavigationEventFactory]", genericEventException);
        }
    }

    public static void sendEventToTarget(int n, int n2, EventGeneric eventGeneric) {
        try {
            if (ASLNavigationEventFactory.getLogger().isTraceEnabled(16384)) {
                ASLNavigationEventFactory.getLogger().trace(16384).append("[ASLNavigationEventFactory]").append("sendEventToTarget(targetIdSender=").append(n).append(", targetIdReceiver=").append(n2).append(")").log();
            }
            eventGeneric.setSenderTargetId(n);
            eventGeneric.setReceiverTargetId(n2);
            eventGeneric.setReceiverEventId(eventGeneric.getServiceId());
            eventGeneric.setServiceId(0);
            ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            ASLNavigationEventFactory.getLogger().error(16384, "[ASLNavigationEventFactory]", genericEventException);
        }
    }

    private static Logger getLogger() {
        return LOGGER;
    }
}

