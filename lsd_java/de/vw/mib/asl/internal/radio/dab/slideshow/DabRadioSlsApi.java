/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.dab.slideshow.HsmDabSlsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public final class DabRadioSlsApi {
    private static HsmDabSlsTarget dabSlideShowTarget = null;

    private DabRadioSlsApi() {
    }

    public static void start(GenericEvents genericEvents, int n, String string) {
        dabSlideShowTarget = new HsmDabSlsTarget(genericEvents, n, string);
    }

    public static void signalLost() {
        try {
            RadioDabTraceUtil.eventTraceDab(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_RADIOTEXT, "ASL_RADIO_HSMTARGET_DAB_DSI", "ASL_RADIO_HSMTARGET_DAB_SLS", "EV_SLS_SIGNAL_LOST", new String[0], new String[0]);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverEventId(109510912);
            eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
            DabRadioSlsApi.send(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void signalAvailable() {
        try {
            RadioDabTraceUtil.eventTraceDab(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_RADIOTEXT, "ASL_RADIO_HSMTARGET_DAB_DSI", "ASL_RADIO_HSMTARGET_DAB_SLS", "EV_SLS_SIGNAL_AVAILABLE", new String[0], new String[0]);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverEventId(126288128);
            eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
            DabRadioSlsApi.send(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyDabActivated(boolean bl) {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            if (bl) {
                RadioDabTraceUtil.eventTraceDab(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_RADIOTEXT, "ASL_RADIO_HSMTARGET_DAB", "ASL_RADIO_HSMTARGET_DAB_SLS", "EV_SLS_DAB_ON", new String[0], new String[0]);
                eventGeneric.setReceiverEventId(176619776);
            } else {
                RadioDabTraceUtil.eventTraceDab(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_RADIOTEXT, "ASL_RADIO_HSMTARGET_DAB", "ASL_RADIO_HSMTARGET_DAB_SLS", "EV_SLS_DAB_OFF", new String[0], new String[0]);
                eventGeneric.setReceiverEventId(159842560);
            }
            eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
            DabRadioSlsApi.send(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyStationSelected() {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverEventId(193396992);
            eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
            DabRadioSlsApi.send(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyNewDataServiceList() {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverEventId(75956480);
            eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
            DabRadioSlsApi.send(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyStationChanging() {
        try {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("notifyStationChanging EV_SLS_STATION_CHANGING").log();
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverEventId(210174208);
            eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
            DabRadioSlsApi.send(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifySearching() {
        try {
            DabRadioSlsApi.dabSlideShowTarget.slSSearching = true;
            dabSlideShowTarget.decideSlideShowImageOrLogoImageAndSlideShowState();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverEventId(243728640);
            eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
            DabRadioSlsApi.send(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyNewLogoAvailable() {
        try {
            dabSlideShowTarget.decideSlideShowImageOrLogoImageAndSlideShowState();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean getSearchingStatus() {
        return DabRadioSlsApi.dabSlideShowTarget.slSSearching;
    }

    private static void send(EventGeneric eventGeneric) {
        try {
            if (null != dabSlideShowTarget) {
                dabSlideShowTarget.gotEvent(eventGeneric);
            }
        }
        catch (Exception exception) {
            ServiceManager.logger.error(256, "Direct event dispatching to Slideshow target", exception);
        }
    }
}

