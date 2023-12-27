/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.vicsetc.PhoneticStringUtils;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.vicsetc.emergency.ASLVICSETCEmergencyPropertyManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VicsEmergencyHandler {
    private final VicsTarget target;
    protected HashSet emergencyMenuResourcesLoaded = new HashSet();
    protected HashSet emergencyDetailResourcesLoaded = new HashSet();
    protected int emergencyMenuResourceIndex = 0;
    protected int emergencyDetailsResourceIndex = 0;
    protected boolean isEnterContextAfterUpdate = false;
    protected boolean isMessagePlaying = false;
    protected final GenericASLList emergencyButtonInfoList;
    protected final List emergencyMenuResourceList;
    protected final List emergencyDetailsResourceList;

    public VicsEmergencyHandler(VicsTarget vicsTarget, GenericASLList genericASLList) {
        this.target = vicsTarget;
        this.emergencyButtonInfoList = genericASLList;
        this.emergencyMenuResourceList = new ArrayList();
        this.emergencyDetailsResourceList = new ArrayList();
    }

    protected void handleEmergencyEnterContext() {
        this.target.traceMsg("enter emergency context.", this);
        this.emergencyButtonInfoList.clear();
        this.emergencyMenuResourceList.clear();
        this.resetEmergencyMenuResourceIndex();
        this.target.vicsTrafficLists.updateTrafficMessages(this.target.currentInfos);
        boolean bl = this.emergencyNotifiyModelIfFirstMessageIsAvailable();
        if (bl) {
            this.target.vicsTrafficLists.emergencyMessages = this.target.vicsTrafficLists.getEmergencyMessages();
            this.emergencyNotifyModelOnMenuImageCount(this.target.vicsTrafficLists.emergencyMessages);
            this.emergencyButtonInfoList.updateList(this.target.vicsTrafficLists.emergencyMessages);
            this.emergencyRequestResourcesForMessagesFromDsi(this.target.vicsTrafficLists.emergencyMessages);
        } else {
            this.emergencyMenuResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1285182720, 0);
            VicsTarget.writeIntegerToDatapool(1301959936, 0);
            this.target.quitModelWaitState(1587172608, 0);
        }
    }

    protected void emergencyRequestResourcesForMessagesFromDsi(TrafficMessage[] trafficMessageArray) {
        if (trafficMessageArray.length > 0) {
            this.emergencyMenuResourcesLoaded.clear();
            this.emergencyMenuResourceList.clear();
            for (int i2 = 0; i2 < trafficMessageArray[0].detailContentIDs.length; ++i2) {
                this.emergencyMenuResourcesLoaded = this.target.requestResourceInformation(trafficMessageArray[0].detailContentIDs[i2], this.emergencyMenuResourcesLoaded);
            }
        } else {
            this.target.traceMsg("Filtered TrafficMessages was empty.", this);
            this.target.quitModelWaitState(1587172608, 0);
        }
    }

    protected void emergencyRequestDetailsResourcesForMessagesFromDsi(TrafficMessage trafficMessage) {
        this.emergencyDetailResourcesLoaded.clear();
        for (int i2 = 0; i2 < trafficMessage.detailContentIDs.length; ++i2) {
            this.emergencyDetailResourcesLoaded = this.target.requestResourceInformation(trafficMessage.detailContentIDs[i2], this.emergencyDetailResourcesLoaded);
        }
    }

    private void emergencyNotifyModelOnMenuImageCount(TrafficMessage[] trafficMessageArray) {
        int n = trafficMessageArray.length > 0 ? trafficMessageArray[0].detailContentIDs.length : 0;
        VicsTarget.writeIntegerToDatapool(1285182720, n);
    }

    private void resetEmergencyMenuResourceIndex() {
        if (!this.isEnterContextAfterUpdate) {
            this.emergencyMenuResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1301959936, this.emergencyMenuResourceIndex);
            VicsTarget.writeIntegerToDatapool(1805276416, this.emergencyMenuResourceIndex + 1);
        }
    }

    private boolean emergencyNotifiyModelIfFirstMessageIsAvailable() {
        boolean bl;
        boolean bl2 = this.target.vicsTrafficLists.getEmergencyMessages().length > 0;
        boolean bl3 = bl = bl2 && !this.target.isMessageExpired(this.target.vicsTrafficLists.getEmergencyMessages()[0], 5);
        if (bl2) {
            this.target.traceMsg(new StringBuffer().append("the first message ").append(this.target.vicsTrafficLists.getEmergencyMessages()[0]).append(" is available: ").append(bl).toString(), this);
            this.target.selectedMessage = this.target.vicsTrafficLists.getEmergencyMessages()[0];
        }
        VicsTarget.writeBooleanToDatapool(1218073856, bl);
        return bl;
    }

    protected void handleEmergencyTrafficMessageSelected(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.selectedMessage = this.target.vicsTrafficLists.emergencyMessages.length > 0 ? this.target.vicsTrafficLists.emergencyMessages[n] : null;
        this.target.traceMsg(new StringBuffer().append("Traffic message selected. ListIndex: ").append(n).append("\nMessage: ").append(this.target.selectedMessage).toString(), this);
        this.target.stateMain.transStateEmergencyDetails();
    }

    protected boolean notifyModelIfFirstEmergencyMessageIsAvailable() {
        boolean bl = this.target.vicsTrafficLists.emergencyMessages.length > 0 && !this.target.isMessageExpired(this.target.vicsTrafficLists.emergencyMessages[0], 5);
        this.target.traceMsg(new StringBuffer().append("the first message ").append(this.target.vicsTrafficLists.emergencyMessages[0]).append(" is available: ").append(bl).toString(), this);
        VicsTarget.writeBooleanToDatapool(1218073856, bl);
        return bl;
    }

    protected void handleEmegrencyMenuPressedNext() {
        this.target.traceMsg("PRESS_BUTTON_NEXT - VicsStateEmergency", this);
        boolean bl = this.notifyModelIfFirstEmergencyMessageIsAvailable();
        if (bl) {
            if (this.target.selectedMessage.detailContentIDs.length > this.emergencyMenuResourceIndex + 1) {
                ++this.emergencyMenuResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.emergencyMenuResourceList.get(this.emergencyMenuResourceIndex);
                VicsTarget.writeIntegerToDatapool(1301959936, this.emergencyMenuResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.emergencyMenuResourceIndex + 1);
                this.handlePhoneticStringAndUpdatePlayButtonStatus(resourceInformation, false);
                VicsTarget.writeResourceLocatorToDatapool(2107266304, resourceInformation.getResourceLocator());
            }
        } else {
            this.emergencyDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1301959936, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeStringToDatapool(1956271360, "");
            VicsTarget.writeResourceLocatorToDatapool(2107266304, ASLVICSETCEmergencyPropertyManager.MESSAGE_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1587172608, 0);
        }
    }

    protected void handleEmergencyMenuPressedPrev() {
        this.target.traceMsg("PRESS_BUTTON_PREV - VicsStateEmergency", this);
        boolean bl = this.notifyModelIfFirstEmergencyMessageIsAvailable();
        if (bl) {
            if (this.emergencyMenuResourceIndex > 0) {
                --this.emergencyMenuResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.emergencyMenuResourceList.get(this.emergencyMenuResourceIndex);
                VicsTarget.writeIntegerToDatapool(1301959936, this.emergencyMenuResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.emergencyMenuResourceIndex + 1);
                this.handlePhoneticStringAndUpdatePlayButtonStatus(resourceInformation, false);
                VicsTarget.writeResourceLocatorToDatapool(2107266304, resourceInformation.getResourceLocator());
            }
        } else {
            this.emergencyDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1301959936, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeStringToDatapool(1956271360, "");
            VicsTarget.writeResourceLocatorToDatapool(2107266304, ASLVICSETCEmergencyPropertyManager.MESSAGE_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1587172608, 0);
        }
    }

    private void handlePhoneticStringAndUpdatePlayButtonStatus(ResourceInformation resourceInformation, boolean bl) {
        String string = PhoneticStringUtils.extractPhonemeString(resourceInformation.getPhoneticString(), this.target);
        String string2 = PhoneticStringUtils.extractPhonemeAlphabet(resourceInformation.getPhoneticString(), this.target);
        boolean bl2 = !StringUtil.isEmpty(string);
        VicsTarget.writeIntegerToDatapool(1268405504, bl2 ? 0 : 2);
        VicsTarget.writeStringToDatapool(1956271360, string);
        VicsTarget.writeStringToDatapool(-2103814912, string2);
        if (bl && bl2) {
            VicsTarget.writeIntegerToDatapool(1268405504, 1);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(714757376);
        }
    }

    protected void handleEmergencySubViewPressedNext() {
        this.target.traceMsg("PRESS_BUTTON_NEXT_SUB_VIEW - VicsStateEmergencyDetails", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(1738167552, 5);
        if (bl) {
            if (this.target.selectedMessage.detailContentIDs.length > this.emergencyDetailsResourceIndex + 1) {
                ++this.emergencyDetailsResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.emergencyDetailsResourceList.get(this.emergencyDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1335514368, this.emergencyDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.emergencyDetailsResourceIndex + 1);
                VicsTarget.writeResourceLocatorToDatapool(2124043520, resourceInformation.getResourceLocator());
                this.handlePhoneticStringAndUpdatePlayButtonStatus(resourceInformation, true);
            }
        } else {
            this.emergencyDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1335514368, 1335514368);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeStringToDatapool(1956271360, "");
            VicsTarget.writeResourceLocatorToDatapool(2124043520, ASLVICSETCEmergencyPropertyManager.MESSAGE_SUB_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1587172608, 0);
        }
    }

    protected void handleEmergencySubViewPressedPrev() {
        this.target.traceMsg("PRESS_BUTTON_PREV_SUB_VIEW - VicsStateEmergencyDetails", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(1738167552, 5);
        if (bl) {
            if (this.emergencyDetailsResourceIndex > 0) {
                --this.emergencyDetailsResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.emergencyDetailsResourceList.get(this.emergencyDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1335514368, this.emergencyDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.emergencyDetailsResourceIndex + 1);
                VicsTarget.writeResourceLocatorToDatapool(2124043520, resourceInformation.getResourceLocator());
                this.handlePhoneticStringAndUpdatePlayButtonStatus(resourceInformation, true);
            }
        } else {
            this.emergencyDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1335514368, 1335514368);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeStringToDatapool(1956271360, "");
            VicsTarget.writeResourceLocatorToDatapool(2124043520, ASLVICSETCEmergencyPropertyManager.MESSAGE_SUB_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1587172608, 0);
        }
    }

    protected void handleEmergencyEnterDetails() {
        this.target.traceMsg("HSM_START - VicsStateEmergencyDetails", this);
        this.emergencyDetailsResourceList.clear();
        this.resetEmergencyDetailsResourceIndex();
        boolean bl = this.target.notfiyModelIfMessageExpired(1738167552, 5);
        this.emergencyNotifyModelOnDetailsImageCount();
        if (bl) {
            this.emergencyRequestDetailsResourcesForMessagesFromDsi(this.target.selectedMessage);
        } else {
            this.emergencyDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1335514368, 1335514368);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            this.target.quitModelWaitState(1587172608, 0);
        }
    }

    private void emergencyNotifyModelOnDetailsImageCount() {
        if (this.target.selectedMessage == null) {
            this.target.traceMsg("Selected traffic message was null!", this);
            VicsTarget.writeIntegerToDatapool(1318737152, 0);
            return;
        }
        int n = this.target.selectedMessage.detailContentIDs.length;
        VicsTarget.writeIntegerToDatapool(1318737152, n);
    }

    private void resetEmergencyDetailsResourceIndex() {
        if (!this.isEnterContextAfterUpdate) {
            this.emergencyDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1335514368, this.emergencyDetailsResourceIndex);
            VicsTarget.writeIntegerToDatapool(1805276416, this.emergencyDetailsResourceIndex + 1);
        }
    }

    protected void handleEmergencyPressedPlay() {
        this.target.traceMsg("PRESS_BUTTON_PLAY - VicsStateEmergency", this);
        boolean bl = this.emergencyNotifiyModelIfFirstMessageIsAvailable();
        if (bl) {
            this.isMessagePlaying = !this.isMessagePlaying;
            VicsTarget.writeIntegerToDatapool(1268405504, this.isMessagePlaying ? 1 : 0);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(this.isMessagePlaying ? 714757376 : 731534592);
            if (!this.isMessagePlaying) {
                this.target.promptEngine.getSpeakOnlyService(2).cancelCurrentRunningPrompt();
            }
        }
    }

    protected void handleEmergencyDetailsPressedPlay() {
        this.target.traceMsg("PRESS_BUTTON_PLAY - VicsStateEmergencyDetails", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(1738167552, 5);
        if (bl) {
            this.isMessagePlaying = !this.isMessagePlaying;
            VicsTarget.writeIntegerToDatapool(1268405504, this.isMessagePlaying ? 1 : 0);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(this.isMessagePlaying ? 714757376 : 731534592);
            if (!this.isMessagePlaying) {
                this.target.promptEngine.getSpeakOnlyService(2).cancelCurrentRunningPrompt();
            }
        }
    }

    protected void handleEmergencyEnterContextAfterUpdate(EventGeneric eventGeneric) {
        this.target.traceMsg("ENTER_CONTEXT_AFTER_UPDATE - VicsStateEmergency", this);
        this.isEnterContextAfterUpdate = eventGeneric.getBoolean(0);
    }

    protected void handleSpeechPromptStarted() {
        this.target.traceMsg("EVT_SPEECH_PROMPT_STARTED - VicsStateEmergency", this);
        this.target.emergencyHandler.isMessagePlaying = true;
        VicsTarget.writeIntegerToDatapool(1268405504, 1);
    }

    protected void handleSpeechPromptFinished() {
        this.target.traceMsg("EVT_SPEECH_PROMPT_FINISHED - VicsStateEmergency", this);
        this.target.emergencyHandler.isMessagePlaying = false;
        VicsTarget.writeIntegerToDatapool(1268405504, 0);
    }

    protected void handleEmergencyCheckIfCurrentMessageExpired() {
        this.target.traceMsg("EV_ASL_CHECK_IF_TRAFFIC_EMERGENCY_MSG_EXPIRED - VicsStateEmergency", this);
        boolean bl = this.target.vicsTrafficLists.getEmergencyMessages().length > 0;
        boolean bl2 = bl && this.target.isMessageExpired(this.target.selectedMessage, 5);
        this.target.traceMsg(new StringBuffer().append("The current emergency message ").append(this.target.selectedMessage).append(" is expired? ").append(bl2).toString(), this);
        if (bl2) {
            this.target.sendHMIEvent(647648512);
            this.target.stateMain.transStateMain();
        }
    }
}

