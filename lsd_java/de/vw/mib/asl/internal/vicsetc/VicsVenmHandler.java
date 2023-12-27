/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.api.navigation.traffic.IResourceLocatorExtern;
import de.vw.mib.asl.api.navigation.traffic.ITmcPhoneme;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.vicsetc.TrafficMessageFormatter;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.asl.internal.vicsetc.VicsVenmMessage;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.vicsetc.venm.transformer.VICSETCVENMVenmDetailsCollector;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.Rect;

public class VicsVenmHandler {
    private static final int RESET_ENSURE_TMC_VISIBILITY_ID;
    protected static final int VENM_DIFFY_DEFAULT;
    protected static final int VENM_DIFFX_DEFAULT;
    protected static final int VENM_KORDY_DEFAULT;
    protected static final int VENM_KORDX_DEFAULT;
    protected static final Rect VENM_ZOOM_AREA_DEFAULT;
    protected static final int TMCICONSUBNINDEX_NORMAL;
    protected static final int ICONSIZE_SMALL;
    protected static final int ICONSIZE_MEDIUM;
    protected static final int ICONSIZE_LARGE;
    protected static final int ICONSIZE_VERY_SMALL;
    protected static final int ICONSIZE_VERY_LARGE;
    protected static boolean noPopUpDelay;
    private final VicsTarget target;
    protected final GenericASLList venmResourceList;

    public VicsVenmHandler(VicsTarget vicsTarget, GenericASLList genericASLList) {
        this.target = vicsTarget;
        this.venmResourceList = genericASLList;
    }

    protected void addVenmMessageToStack(VicsVenmMessage vicsVenmMessage) {
        if (this.target.popupHandler.isPopupDisplayed && !this.target.venmMessageStack.isEmpty()) {
            int n = this.target.venmMessageStack.indexOf(this.target.venmMessageStack.lastElement()) - 1;
            this.target.venmMessageStack.add(n == -1 ? 0 : n, vicsVenmMessage);
        } else {
            this.target.venmMessageStack.push(vicsVenmMessage);
        }
        this.target.traceMsg(new StringBuffer().append("Put received VENM-Message to queue: ").append(this.target.venmMessageStack).toString(), this);
    }

    protected void handleVenmMessageReceived(IResourceLocatorExtern iResourceLocatorExtern) {
        VicsVenmMessage vicsVenmMessage;
        this.target.traceMsg("handle venm message received.", this);
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        VicsVenmMessage vicsVenmMessage2 = vicsVenmMessage = !this.target.venmMessageStack.isEmpty() ? (VicsVenmMessage)this.target.venmMessageStack.peek() : null;
        if (vicsVenmMessage != null && !this.target.popupHandler.isPopupDisplayed) {
            VICSETCVENMVenmDetailsCollector vICSETCVENMVenmDetailsCollector = new VICSETCVENMVenmDetailsCollector();
            String string = vicsVenmMessage.getMessage().getEventText().length > 0 ? vicsVenmMessage.getMessage().getEventText()[0] : "";
            String string2 = vicsVenmMessage.getMessage().getEventText().length > 1 ? vicsVenmMessage.getMessage().getEventText()[1] : "";
            String string3 = vicsVenmMessage.getMessage().getEventText().length > 2 ? vicsVenmMessage.getMessage().getEventText()[2] : "";
            VicsTarget.writeStringToDatapool(1486509312, string);
            VicsTarget.writeStringToDatapool(1503286528, string3);
            vICSETCVENMVenmDetailsCollector.vicsetc_venm_title_text = string == null ? "" : string;
            vICSETCVENMVenmDetailsCollector.vicsetc_venm_info_text = string2 == null ? "" : string2;
            vICSETCVENMVenmDetailsCollector.vicsetc_venm_event_icon_rl = iResourceLocatorExtern != null ? new ResourceLocator(iResourceLocatorExtern.getId(), iResourceLocatorExtern.getUrl()) : new ResourceLocator();
            vICSETCVENMVenmDetailsCollector.vicsetc_venm_message_reception_time = new SimpleDateFormat("HH:mm").format(new Date(vicsVenmMessage.getMessage().getTimeStamp() * 0));
            vICSETCVENMVenmDetailsCollector.vicsetc_venm_venm_message_details_for_fix_formatter = TrafficMessageFormatter.prepareFixFormatterDetailViewData(vicsVenmMessage.getMessage());
            this.venmResourceList.clear();
            this.venmResourceList.updateList(new VICSETCVENMVenmDetailsCollector[]{vICSETCVENMVenmDetailsCollector});
            this.target.popupHandler.isPopupDisplayed = true;
            if (vicsVenmMessage.isUrgent()) {
                VicsTarget.writeBooleanToDatapool(2023380224, true);
                ITmcPhoneme iTmcPhoneme = vicsVenmMessage.getMessage().getTmcPhoneme();
                String string4 = iTmcPhoneme == null ? "" : new StringBuffer().append(iTmcPhoneme.getRoadName()).append(iTmcPhoneme.getStartLocation()).append(iTmcPhoneme.getEndLocation()).append(iTmcPhoneme.getDirectionOfRoad1()).append(iTmcPhoneme.getDirectionOfRoad2()).append(iTmcPhoneme.getPhonemeAlphabet()).toString();
                VicsTarget.writeBooleanToDatapool(1754944768, !StringUtil.isEmpty(string4));
                VicsTarget.writeStringToDatapool(1469732096, string4);
                if (noPopUpDelay) {
                    this.triggerVenmPopup();
                } else {
                    this.triggerVenmPopupWithDelay();
                }
            } else if (this.target.vicsEtcDP.isVicsEventNoticeMapChecked()) {
                VicsTarget.writeBooleanToDatapool(2023380224, false);
                this.target.navGuidanceService.triggerEventAudioMessage(vicsVenmMessage.getSoundID());
                if (noPopUpDelay) {
                    this.triggerVenmPopup();
                } else {
                    this.triggerVenmPopupWithDelay();
                }
            } else {
                this.target.popupHandler.isPopupDisplayed = false;
                if (!this.target.venmMessageStack.isEmpty()) {
                    this.target.venmMessageStack.pop();
                    this.requestResourceLocatorForTmcIcon();
                }
            }
        }
    }

    private void triggerVenmPopupWithDelay() {
        this.target.traceMsg("triggerVenmPopupWithDelay()", this);
        noPopUpDelay = true;
        this.target.startTimer(176619776, (long)0, false);
    }

    private void triggerVenmPopup() {
        this.target.traceMsg("triggerVenmPopup()", this);
        this.target.startTimer(159842560, (long)0, false);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(412767488);
    }

    protected void handleLeaveContext() {
        this.target.traceMsg("LEAVE_CONTEXT - VicsStateVenm", this);
        this.target.navMapService.ensureTMCVisibility(0L);
        this.target.navMapService.unlockMapViewer();
        this.target.navMapService.releaseView();
        if (this.target.venmMessageStack.isEmpty()) {
            this.target.stateMain.transToPreviousState();
        } else {
            this.target.venmMessageStack.pop();
            this.requestResourceLocatorForTmcIcon();
        }
    }

    protected void handleLeaveContextToNav() {
        this.target.traceMsg("handleLeaveContextToNav()", this);
        noPopUpDelay = false;
        this.handleLeaveContext();
    }

    protected void handleEnterContext() {
        VicsVenmMessage vicsVenmMessage;
        this.target.traceMsg("HSM_START - VicsStateVenm", this);
        VicsVenmMessage vicsVenmMessage2 = vicsVenmMessage = !this.target.venmMessageStack.isEmpty() ? (VicsVenmMessage)this.target.venmMessageStack.peek() : null;
        if (vicsVenmMessage == null) {
            this.target.traceMsg(new StringBuffer().append("VENM message was null: ").append(this.target.venmMessageStack).toString(), this);
            return;
        }
        this.target.popupHandler.isPopupDisplayed = false;
        this.target.stopTimer(159842560);
        this.target.navMapService.lockMapViewer();
        ASLNavigationMapConfiguration aSLNavigationMapConfiguration = new ASLNavigationMapConfiguration();
        aSLNavigationMapConfiguration.setAutozoom(false);
        aSLNavigationMapConfiguration.setMapMode(2);
        aSLNavigationMapConfiguration.setOrientation(2);
        aSLNavigationMapConfiguration.setPerspective(-1);
        aSLNavigationMapConfiguration.setViewType(0);
        aSLNavigationMapConfiguration.setZoomArea(VENM_ZOOM_AREA_DEFAULT);
        this.target.navMapService.ensureTMCVisibility(vicsVenmMessage.getMessage().getMessageID());
        if (null != vicsVenmMessage.getRectangle()) {
            aSLNavigationMapConfiguration.setMapViewPortByWGS84Rectangle(vicsVenmMessage.getRectangle());
        }
        this.target.navMapService.goToLocation(aSLNavigationMapConfiguration);
        if (null == vicsVenmMessage.getRectangle()) {
            this.target.navMapService.configureVicsEventNoticeMap(vicsVenmMessage.getMessage().getMessageID());
        }
    }

    protected void handleVenmTwoFingerZoom(EventGeneric eventGeneric) {
        this.target.traceMsg("TWO_FINGER_ZOOMED - VicsStateVenm", this);
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        this.target.navMapService.zoomTwoFingers(n, n2, n3, n4);
    }

    protected void handleVenmZoomIn(EventGeneric eventGeneric) {
        this.target.traceMsg("ZOOM_IN_MAP - VicsStateVenm", this);
        this.target.navMapService.zoomIn();
    }

    protected void handleVenmZoomOut(EventGeneric eventGeneric) {
        this.target.traceMsg("ZOOM_OUT_MAP - VicsStateVenm", this);
        this.target.navMapService.zoomOut();
    }

    protected void requestResourceLocatorForTmcIcon() {
        VicsVenmMessage vicsVenmMessage;
        this.target.traceMsg("request ResourceLocator for venm message.", this);
        VicsVenmMessage vicsVenmMessage2 = vicsVenmMessage = !this.target.venmMessageStack.isEmpty() ? (VicsVenmMessage)this.target.venmMessageStack.peek() : null;
        if (vicsVenmMessage != null && !this.target.popupHandler.isPopupDisplayed) {
            int n = vicsVenmMessage.getMessage().getIconListId().length > 0 ? vicsVenmMessage.getMessage().getIconListId()[0] : 0;
            this.target.navTrafficService.resourceIdForTMCEventIcon(n, 0, 0);
        }
    }

    protected void handleDelayedPopup() {
        this.target.traceMsg("handle delayed popup.", this);
        this.triggerVenmPopup();
    }

    static {
        VENM_ZOOM_AREA_DEFAULT = new Rect(14, 109, 321, 371);
        noPopUpDelay = true;
    }
}

