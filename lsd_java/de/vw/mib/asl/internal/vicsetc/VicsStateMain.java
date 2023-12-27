/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.vicsetc.ITunerData;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.vicsetc.ITunerDataImpl;
import de.vw.mib.asl.internal.vicsetc.PhoneticStringUtils;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.asl.internal.vicsetc.api.impl.ASLVICSETCAPIImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.DateTime;

public class VicsStateMain
extends AbstractHsmState {
    protected static final int EVT_SPEECH_PROMPT_FINISHED;
    protected static final int EVT_SPEECH_PROMPT_STARTED;
    protected static final int EV_NAV_SERVICE_WAIT;
    protected static final int EV_NAV_SERVICE_READY;
    protected static final int EV_NAV_POPUP_TIMED_OUT;
    protected static final int EV_NAV_VENM_POPUP_TIMED_OUT;
    protected static final int EV_NAV_DELAY_VENM_POPUP;
    protected static final int EV_ASL_CHECK_IF_DSRC_MSG_EXPIRED;
    protected static final int EV_ASL_CHECK_IF_FM_GRAPHIC_MSG_EXPIRED;
    protected static final int EV_ASL_CHECK_IF_TRAFFIC_EMERGENCY_MSG_EXPIRED;
    private final VicsTarget target;

    public VicsStateMain(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = vicsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.target.initSpeechEngine();
                this.target.notifyLscRegisterNavi();
                break;
            }
            case 2: {
                this.handleHsmEntry();
                break;
            }
            case 3: {
                this.target.traceMsg("HSM_START - VicsStateMain", this);
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateMain", this);
                this.target.notifyLscDeregisterNavi();
                break;
            }
            case 100102: {
                this.handleNavServiceWait();
                break;
            }
            case 100103: {
                this.handleNavServiceReady();
                break;
            }
            case 100104: {
                this.target.popupHandler.handlePopupTimedOut();
                break;
            }
            case 100105: {
                this.target.popupHandler.handleVenmPopupTimedOut();
                break;
            }
            case 1079341878: {
                this.target.handleNoUserInteractionAndNotifyModelToReloadContext();
                break;
            }
            case 1079341893: {
                this.handleHapticSpeechPromptStarted();
                break;
            }
            case 1079341894: {
                this.handleHapticSpeechPromptFinished();
                break;
            }
            case 4800009: {
                this.target.doOnlineServiceRequest(eventGeneric);
                break;
            }
            case 1079341831: {
                this.transStateSetup();
                break;
            }
            case 1079341825: {
                this.transStateFmText();
                break;
            }
            case 1079341826: {
                this.transStateFmGraphic();
                break;
            }
            case 1079341827: {
                this.transStateDsrc();
                break;
            }
            case 1079341829: {
                this.transStateEmergency();
                break;
            }
            case 1079341828: {
                this.transStateShortcut();
                break;
            }
            case 1079341877: {
                this.transStateVenm();
                break;
            }
            case 1079341845: {
                this.target.popupHandler.handlePopupsPressedNext();
                break;
            }
            case 1079341846: {
                this.target.popupHandler.handlePopupsPressedPrev();
                break;
            }
            case 1079341830: {
                this.target.popupHandler.handlePopupsClosed();
                break;
            }
            case 1079341892: {
                this.target.popupHandler.handleVenmPopupClosed();
                break;
            }
            case 40003: {
                this.handleLsctngChangeLanguage(eventGeneric);
                break;
            }
            case 1079341895: {
                this.handleSpeechDebug();
                break;
            }
            case 7900004: {
                this.handleSetDataUpload(eventGeneric);
                break;
            }
            case 100106: {
                this.target.venmHandler.handleDelayedPopup();
                break;
            }
            case 7900003: {
                this.target.setupHandler.handleSetupStationSelect(eventGeneric);
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateMain", this);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleSetDataUpload(EventGeneric eventGeneric) {
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        try {
            this.target.setProbeDataSetting(eventGeneric.getBoolean(0));
        }
        catch (GenericEventException genericEventException) {
            this.target.traceMsg("An event exception occured", this);
        }
        this.target.traceMsg("changed data upload setting.", this);
    }

    protected void handleSpeechDebug() {
        this.target.traceMsg("SPEECH_DEBUG - VicsStateMain", this);
        this.target.popupWasShown = true;
        this.target.traceMsg(new StringBuffer().append("setting popupWasShown to true. popupWasShown = ").append(this.target.popupWasShown).toString(), this);
    }

    protected void handleLsctngChangeLanguage(EventGeneric eventGeneric) {
        this.target.traceMsg("LSCTNG_CHANGE_LANGUAGE - VicsStateMain", this);
        this.target.transactionId = eventGeneric.getInt(0);
        this.target.newLanguage = eventGeneric.getString(1);
        this.target.traceMsg(new StringBuffer().append("Setting language to transactionId: ").append(this.target.transactionId).append(", newLanguage: ").append(this.target.newLanguage).toString(), this);
        this.target.finishManualLanguageChange(true);
    }

    protected void handleHapticSpeechPromptFinished() {
        this.target.traceMsg("HAPTIC_SPEECH_PROMPT_FINISHED - VicsStateMain", this);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), 75956480);
        this.target.sendSafe(eventGeneric);
    }

    protected void handleHapticSpeechPromptStarted() {
        this.target.traceMsg("HAPTIC_SPEECH_PROMPT_STARTED - VicsStateMain", this);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), 92733696);
        this.target.sendSafe(eventGeneric);
    }

    protected void handleNavServiceReady() {
        this.target.traceMsg("EV_NAV_SERVICE_READY - VicsStateMain", this);
        this.target.navMapService = ASLNavigationFactory.getNavigationApi().getNavigationMapService(this.target.navigationMapHandler);
        this.target.navTrafficService = ASLNavigationFactory.getNavigationApi().getNavigationTrafficService(this.target.navigationTrafficHandler);
        this.target.navGuidanceService = ASLNavigationFactory.getNavigationApi().getNavigationGuidanceService(this.target.navigationGuidanceHandler);
        this.notifyModellOnCurrentMapType();
    }

    protected void handleHsmEntry() {
        this.target.traceMsg("HSM_ENTRY - VicsStateMain", this);
        this.target.initTarget();
        this.target.triggerMe(109510912);
    }

    protected void handleNavServiceWait() {
        this.target.traceMsg("EV_NAV_SERVICE_WAIT - VicsStateMain", this);
        if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() != 100) {
            this.target.startTimer(109510912, (long)0, false);
        } else {
            this.target.triggerMe(126288128);
        }
    }

    protected void notifyModellOnCurrentMapType() {
        int n = this.target.navMapService.getMapType() == 2 ? 1 : 0;
        this.target.traceMsg(new StringBuffer().append("notifyModellOnCurrentMapType() - currentMapType = ").append(n).toString(), this);
        VicsTarget.writeIntegerToDatapool(-2120592128, n);
    }

    protected void transStateMain() {
        this.target.traceMsg("transStateMain", this);
        this.trans(this.target.stateMain);
    }

    protected void transToPreviousState() {
        this.target.traceMsg("transToPreviousState", this);
        if (this.target.getHsm().getPreviousState() == null) {
            this.target.traceMsg("Previous state was null.", this);
        } else {
            this.trans(this.target.getHsm().getPreviousState());
        }
    }

    protected void transStateSetup() {
        this.target.traceMsg("transStateSetup", this);
        this.trans(this.target.stateSetup);
    }

    protected void transStateFmText() {
        this.target.traceMsg("transStateFmText", this);
        this.trans(this.target.stateFmText);
    }

    protected void transStateFmGraphic() {
        this.target.traceMsg("transStateFmGraphic", this);
        this.trans(this.target.stateFmGraphic);
    }

    protected void transStateFmGraphicDetails() {
        this.target.traceMsg("transStateFmGraphicDetails", this);
        this.trans(this.target.stateFmGraphicDetails);
    }

    protected void transStateDsrc() {
        this.target.traceMsg("transStateDsrc", this);
        this.trans(this.target.stateDsrc);
    }

    protected void transStateDsrcDetails() {
        this.target.traceMsg("transStateDsrcDetails", this);
        this.trans(this.target.stateDsrcDetails);
    }

    protected void transStateEmergency() {
        this.target.traceMsg("transStateEmergency", this);
        this.trans(this.target.stateEmergency);
    }

    protected void transStateEmergencyDetails() {
        this.target.traceMsg("transStateEmergencyDetails", this);
        this.trans(this.target.stateEmergencyDetails);
    }

    protected void transStateShortcut() {
        this.target.traceMsg("transStateShortcut", this);
        this.trans(this.target.stateShortcut);
    }

    protected void transStateVenm() {
        this.target.traceMsg("transStateVenm", this);
        this.trans(this.target.stateVenm);
    }

    public void dsiAsiaTrafficInfoMenuUpdateActiveInterrupts(Interrupt[] interruptArray, int n) {
        this.target.traceMsg(new StringBuffer().append("Interrupts updated! \nValidFlag: ").append(n).append("\nInterupts: ").append(interruptArray).toString(), this);
        if (n == 1 && !this.isVicsTrafficContextActive()) {
            this.target.popupHandler.requestInterruptResourcesAndActivatePopup(interruptArray);
        }
    }

    private boolean isVicsTrafficContextActive() {
        boolean bl = this.target.isStateActive(this.target.stateDsrc) || this.target.isStateActive(this.target.stateDsrcDetails) || this.target.isStateActive(this.target.stateEmergency) || this.target.isStateActive(this.target.stateEmergencyDetails) || this.target.isStateActive(this.target.stateFmGraphic) || this.target.isStateActive(this.target.stateFmGraphicDetails) || this.target.isStateActive(this.target.stateFmText) || this.target.isStateActive(this.target.stateShortcut) || this.target.isStateActive(this.target.stateVenm);
        this.target.traceMsg(new StringBuffer().append("isVicsTrafficContextActive() - ").append(bl).toString(), this);
        this.traceActiveState();
        return bl;
    }

    private void traceActiveState() {
        if (this.target.isStateActive(this.target.stateDsrc)) {
            this.target.traceMsg("traceActiveState() - stateDsrc", this);
        } else if (this.target.isStateActive(this.target.stateDsrcDetails)) {
            this.target.traceMsg("traceActiveState() - stateDsrcDetails", this);
        } else if (this.target.isStateActive(this.target.stateEmergency)) {
            this.target.traceMsg("traceActiveState() - stateEmergency", this);
        } else if (this.target.isStateActive(this.target.stateEmergencyDetails)) {
            this.target.traceMsg("traceActiveState() - stateEmergencyDetails", this);
        } else if (this.target.isStateActive(this.target.stateFmGraphic)) {
            this.target.traceMsg("traceActiveState() - stateFmGraphic", this);
        } else if (this.target.isStateActive(this.target.stateFmGraphicDetails)) {
            this.target.traceMsg("traceActiveState() - stateFmGraphicDetails", this);
        } else if (this.target.isStateActive(this.target.stateFmText)) {
            this.target.traceMsg("traceActiveState() - stateFmText", this);
        } else if (this.target.isStateActive(this.target.stateShortcut)) {
            this.target.traceMsg("traceActiveState() - stateShortcut", this);
        } else if (this.target.isStateActive(this.target.stateVenm)) {
            this.target.traceMsg("traceActiveState() - stateVenm", this);
        } else if (this.target.isStateActive(this.target.stateMain)) {
            this.target.traceMsg("traceActiveState() - stateMain", this);
        } else {
            this.target.traceMsg("traceActiveState() - state unknown", this);
        }
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.target.traceMsg(new StringBuffer().append("Received resource information! \ncontentId: ").append(n).append("\nResource: ").append(resourceInformation).toString(), this);
        this.target.traceResourceInformation(resourceInformation);
        boolean bl = this.target.popupHandler.popupGraphicsResourcesLoaded.remove(new Integer(n));
        if (bl) {
            this.target.popupHandler.popupGraphicsDetailsResourceList.add(resourceInformation);
        }
        if (this.target.popupHandler.popupGraphicsResourcesLoaded.isEmpty()) {
            this.target.traceMsg("Last resource received.", this);
            if (!this.target.popupHandler.popupGraphicsDetailsResourceList.isEmpty() && this.target.popupHandler.popupGraphicsDetailsResourceList.size() > this.target.popupHandler.popupGraphicsDetailsResourceIndex) {
                ResourceInformation resourceInformation2 = (ResourceInformation)this.target.popupHandler.popupGraphicsDetailsResourceList.get(this.target.popupHandler.popupGraphicsDetailsResourceIndex);
                String string = PhoneticStringUtils.extractPhonemeString(resourceInformation2.getPhoneticString(), this.target);
                String string2 = PhoneticStringUtils.extractPhonemeAlphabet(resourceInformation2.getPhoneticString(), this.target);
                boolean bl2 = !StringUtil.isEmpty(string);
                VicsTarget.writeBooleanToDatapool(1754944768, bl2);
                VicsTarget.writeStringToDatapool(1452954880, string);
                VicsTarget.writeStringToDatapool(-2103814912, string2);
                VicsTarget.writeResourceLocatorToDatapool(2140820736, resourceInformation2.getResourceLocator());
                Interrupt interrupt = !this.target.interruptStack.isEmpty() ? (Interrupt)this.target.interruptStack.peek() : null;
                this.target.popupHandler.handleReceivedInterrupt(interrupt);
                this.target.traceMsg("Resources for shown message updated.", this);
            } else {
                this.target.traceMsg(new StringBuffer().append("PopUp details resource index is out of bounds. Index: ").append(this.target.popupHandler.popupGraphicsDetailsResourceIndex).append("ListSize: ").append(this.target.popupHandler.popupGraphicsDetailsResourceList.size()).toString(), this);
            }
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateTrafficType(TrafficInformation[] trafficInformationArray, int n) {
        this.target.traceMsg(new StringBuffer().append("Traffic informations updated! \nValidFlag: ").append(n).append("\nMessages: ").append(trafficInformationArray).toString(), this);
        if (n == 1) {
            this.target.currentInfos = trafficInformationArray;
            this.target.resetShortcutMessageIfExpired();
            EventGeneric eventGeneric = this.target.getEventFactory().newEvent(193396992);
            EventGeneric eventGeneric2 = this.target.getEventFactory().newEvent(210174208);
            EventGeneric eventGeneric3 = this.target.getEventFactory().newEvent(226951424);
            this.target.getEventDispatcher().sendSafe(eventGeneric);
            this.target.getEventDispatcher().sendSafe(eventGeneric2);
            this.target.getEventDispatcher().sendSafe(eventGeneric3);
        } else {
            ASLVICSETCAPIImpl.notifyVicsStatusListenerToUpdateControlBar(0, 0, -1);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateFrequency(int n, int n2) {
        this.target.traceMsg(new StringBuffer().append("Frequency updated! \nValidFlag: ").append(n2).append("\nFrequency: ").append(n).toString(), this);
        if (n2 == 1) {
            this.target.vicsEtcDP.setFrequencyInfoString(Double.toString((double)((double)n / 1000.0)));
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateReceptionStatus(int n, int n2) {
        this.target.traceMsg(new StringBuffer().append("Reception status updated! \nValidFlag: ").append(n2).append("\nStatus: ").append(n).toString(), this);
        if (n2 == 1) {
            this.target.vicsEtcDP.setReceptionStatus(n);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdatePrefecture(String string, int n) {
        this.target.traceMsg(new StringBuffer().append("Prefecture updated! \nValidFlag: ").append(n).append("\nPrefecture: ").append(string).toString(), this);
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        if (n == 1 && !StringUtil.isEmpty(string)) {
            this.target.vicsEtcDP.setPrefectureInfoString(string);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateProbeDataSetting(boolean bl, int n) {
        this.target.traceMsg(new StringBuffer().append("Probe data setting updated! \nValidFlag: ").append(n).append("\nSetting: ").append(bl).toString(), this);
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        if (n == 1) {
            this.target.vicsEtcDP.setDataUploadChecked(bl);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateReceptionDate(DateTime dateTime, int n) {
        this.target.traceMsg(new StringBuffer().append("Reception date updated! \nValidFlag: ").append(n).append("\nDate: ").append(dateTime).toString(), this);
        if (n == 1 && dateTime != null) {
            long l = dateTime.time + 0;
            Date date = new Date(l);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("mm");
            int n2 = this.target.vicsEtcDP.getTrafficOnline() ? 2 : 1;
            ASLVICSETCAPIImpl.notifyVicsStatusListenerToUpdateControlBar(n2, Integer.parseInt(simpleDateFormat.format(date)), Integer.parseInt(simpleDateFormat2.format(date)));
        } else {
            ASLVICSETCAPIImpl.notifyVicsStatusListenerToUpdateControlBar(1, 0, -1);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateReceivableStations(TunerData[] tunerDataArray, int n) {
        this.target.traceMsg(new StringBuffer().append("Receivable stations updated! \nValidFlag: ").append(n).append("\nMessages: ").append(tunerDataArray).toString(), this);
        if (n == 1) {
            ITunerData[] iTunerDataArray;
            this.target.vicsTrafficLists.updateTunerDatas(tunerDataArray);
            ITunerData[] iTunerDataArray2 = iTunerDataArray = tunerDataArray != null ? new ITunerData[tunerDataArray.length] : new ITunerData[]{};
            if (tunerDataArray != null) {
                for (int i2 = 0; i2 < iTunerDataArray.length; ++i2) {
                    iTunerDataArray[i2] = new ITunerDataImpl(tunerDataArray[i2].getStationName(), tunerDataArray[i2].getFrequency());
                }
            }
            ASLVICSETCAPIImpl.notifyVicsStatusListenerToUpdateReceivableStations(iTunerDataArray, n == 1);
        }
    }
}

