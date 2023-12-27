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
import generated.de.vw.mib.asl.internal.vicsetc.dsrc.ASLVICSETCDSRCPropertyManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VicsDsrcHandler {
    private final VicsTarget target;
    protected HashSet dsrcMenuResourcesLoad = new HashSet();
    protected HashSet dsrcDetailsResourcesLoad = new HashSet();
    protected boolean isEnterContextAfterUpdate = false;
    protected int dsrcMenuResourceIndex = 0;
    protected int dsrcDetailsResourceIndex = 0;
    protected boolean isMessagePlaying = false;
    protected final GenericASLList dsrcButtonInfoList;
    protected final List dsrcMenuResourceList;
    protected final List dsrcDetailsResourceList;

    public VicsDsrcHandler(VicsTarget vicsTarget, GenericASLList genericASLList) {
        this.target = vicsTarget;
        this.dsrcButtonInfoList = genericASLList;
        this.dsrcMenuResourceList = new ArrayList();
        this.dsrcDetailsResourceList = new ArrayList();
    }

    protected void handleDsrcEnterContext() {
        this.target.traceMsg("enter dsrc context.", this);
        this.dsrcButtonInfoList.clear();
        this.dsrcDetailsResourceList.clear();
        this.resetDsrcMenuResourceIndex();
        this.target.vicsTrafficLists.updateTrafficMessages(this.target.currentInfos);
        boolean bl = this.dsrcNotifiyModelIfFirstMessageIsAvailable();
        if (bl) {
            this.target.vicsTrafficLists.dsrcMessages = this.target.vicsTrafficLists.getDsrcMessages();
            this.dsrcNotifyModelOnMenuImageCount(this.target.vicsTrafficLists.dsrcMessages);
            this.dsrcButtonInfoList.updateList(this.target.vicsTrafficLists.dsrcMessages);
            this.dsrcRequestResourcesForMessagesFromDsi(this.target.vicsTrafficLists.dsrcMessages);
        } else {
            this.dsrcMenuResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1134187776, 0);
            VicsTarget.writeIntegerToDatapool(1150964992, 0);
            VicsTarget.writeStringToDatapool(1939494144, "");
            VicsTarget.writeResourceLocatorToDatapool(2056934656, ASLVICSETCDSRCPropertyManager.MESSAGE_SUB_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1553618176, 0);
        }
    }

    protected void dsrcRequestResourcesForMessagesFromDsi(TrafficMessage[] trafficMessageArray) {
        if (trafficMessageArray.length > 0) {
            this.dsrcMenuResourcesLoad.clear();
            this.dsrcMenuResourceList.clear();
            for (int i2 = 0; i2 < trafficMessageArray[0].detailContentIDs.length; ++i2) {
                this.dsrcMenuResourcesLoad = this.target.requestResourceInformation(trafficMessageArray[0].detailContentIDs[i2], this.dsrcMenuResourcesLoad);
            }
        } else {
            this.target.trace("Filtered TrafficMessages was empty.");
            this.target.quitModelWaitState(1553618176, 0);
        }
    }

    protected void dsrcRequestDetailsResourcesForMessagesFromDsi(TrafficMessage trafficMessage) {
        this.dsrcDetailsResourcesLoad.clear();
        for (int i2 = 0; i2 < trafficMessage.detailContentIDs.length; ++i2) {
            this.dsrcDetailsResourcesLoad = this.target.requestResourceInformation(trafficMessage.detailContentIDs[i2], this.dsrcDetailsResourcesLoad);
        }
    }

    private void dsrcNotifyModelOnMenuImageCount(TrafficMessage[] trafficMessageArray) {
        int n = trafficMessageArray.length > 0 ? trafficMessageArray[0].detailContentIDs.length : 0;
        VicsTarget.writeIntegerToDatapool(1134187776, n);
    }

    private boolean dsrcNotifiyModelIfFirstMessageIsAvailable() {
        boolean bl;
        boolean bl2 = this.target.vicsTrafficLists.getDsrcMessages().length > 0;
        boolean bl3 = bl = bl2 && !this.target.isMessageExpired(this.target.vicsTrafficLists.getDsrcMessages()[0], 2);
        if (bl2) {
            this.target.traceMsg(new StringBuffer().append("the first message ").append(this.target.vicsTrafficLists.getDsrcMessages()[0]).append(" is available: ").append(bl).toString(), this);
            this.target.selectedMessage = this.target.vicsTrafficLists.getDsrcMessages()[0];
        }
        VicsTarget.writeBooleanToDatapool(1704613120, bl);
        return bl;
    }

    private void resetDsrcMenuResourceIndex() {
        if (!this.isEnterContextAfterUpdate) {
            this.dsrcMenuResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1150964992, this.dsrcMenuResourceIndex);
            VicsTarget.writeIntegerToDatapool(1805276416, this.dsrcMenuResourceIndex + 1);
        }
    }

    protected void handleDsrcTrafficMessageSelected(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.selectedMessage = this.target.vicsTrafficLists.dsrcMessages.length > 0 ? this.target.vicsTrafficLists.dsrcMessages[n] : null;
        this.target.traceMsg(new StringBuffer().append("Traffic message selected. ListIndex: ").append(n).append("\nMessage: ").append(this.target.selectedMessage).toString(), this);
        this.target.stateMain.transStateDsrcDetails();
    }

    protected void handleDsrcMenuPressedNext() {
        this.target.traceMsg("PRESS_BUTTON_NEXT - VicsStateDsrc", this);
        boolean bl = this.dsrcNotifiyModelIfFirstMessageIsAvailable();
        if (bl) {
            if (this.target.selectedMessage.detailContentIDs.length > this.dsrcMenuResourceIndex + 1) {
                ++this.dsrcMenuResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.dsrcMenuResourceList.get(this.dsrcMenuResourceIndex);
                VicsTarget.writeIntegerToDatapool(1150964992, this.dsrcMenuResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.dsrcMenuResourceIndex + 1);
                this.handlePhoneticStringAndUpdatePlayButtonStatus(resourceInformation, false);
                VicsTarget.writeResourceLocatorToDatapool(2040157440, resourceInformation.getResourceLocator());
            }
        } else {
            this.dsrcDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1150964992, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeStringToDatapool(1939494144, "");
            VicsTarget.writeResourceLocatorToDatapool(2040157440, ASLVICSETCDSRCPropertyManager.MESSAGE_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1553618176, 0);
        }
    }

    protected void handleDsrcMenuPressedPrev() {
        this.target.traceMsg("PRESS_BUTTON_PREV - VicsStateDsrc", this);
        boolean bl = this.dsrcNotifiyModelIfFirstMessageIsAvailable();
        if (bl) {
            if (this.dsrcMenuResourceIndex > 0) {
                --this.dsrcMenuResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.dsrcMenuResourceList.get(this.dsrcMenuResourceIndex);
                VicsTarget.writeIntegerToDatapool(1150964992, this.dsrcMenuResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.dsrcMenuResourceIndex + 1);
                this.handlePhoneticStringAndUpdatePlayButtonStatus(resourceInformation, false);
                VicsTarget.writeResourceLocatorToDatapool(2040157440, resourceInformation.getResourceLocator());
            }
        } else {
            this.dsrcDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1150964992, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeStringToDatapool(1939494144, "");
            VicsTarget.writeResourceLocatorToDatapool(2040157440, ASLVICSETCDSRCPropertyManager.MESSAGE_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1553618176, 0);
        }
    }

    private void handlePhoneticStringAndUpdatePlayButtonStatus(ResourceInformation resourceInformation, boolean bl) {
        String string = PhoneticStringUtils.extractPhonemeString(resourceInformation.getPhoneticString(), this.target);
        String string2 = PhoneticStringUtils.extractPhonemeAlphabet(resourceInformation.getPhoneticString(), this.target);
        boolean bl2 = !StringUtil.isEmpty(string);
        VicsTarget.writeIntegerToDatapool(1117410560, bl2 ? 0 : 2);
        VicsTarget.writeStringToDatapool(1939494144, string);
        VicsTarget.writeStringToDatapool(-2103814912, string2);
        if (bl && bl2) {
            VicsTarget.writeIntegerToDatapool(1117410560, 1);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(681202944);
        }
    }

    protected void handleDsrcSubViewPressedNext() {
        this.target.traceMsg("PRESS_BUTTON_NEXT_SUB_VIEW - VicsStateDsrcDetails", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(1721390336, 2);
        if (bl) {
            if (this.target.selectedMessage.detailContentIDs.length > this.dsrcDetailsResourceIndex + 1) {
                ++this.dsrcDetailsResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.dsrcDetailsResourceList.get(this.dsrcDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1184519424, this.dsrcDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.dsrcDetailsResourceIndex + 1);
                VicsTarget.writeResourceLocatorToDatapool(2056934656, resourceInformation.getResourceLocator());
                this.handlePhoneticStringAndUpdatePlayButtonStatus(resourceInformation, true);
            }
        } else {
            this.dsrcDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1184519424, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeStringToDatapool(1939494144, "");
            VicsTarget.writeResourceLocatorToDatapool(2056934656, ASLVICSETCDSRCPropertyManager.MESSAGE_SUB_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1553618176, 0);
        }
    }

    protected void handleDsrcSubViewPressedPrev() {
        this.target.traceMsg("PRESS_BUTTON_PREV_SUB_VIEW - VicsStateDsrcDetails", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(1721390336, 2);
        if (bl) {
            if (this.dsrcDetailsResourceIndex > 0) {
                --this.dsrcDetailsResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.dsrcDetailsResourceList.get(this.dsrcDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1184519424, this.dsrcDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.dsrcDetailsResourceIndex + 1);
                VicsTarget.writeResourceLocatorToDatapool(2056934656, resourceInformation.getResourceLocator());
                this.handlePhoneticStringAndUpdatePlayButtonStatus(resourceInformation, true);
            }
        } else {
            this.dsrcDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1184519424, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeStringToDatapool(1939494144, "");
            VicsTarget.writeResourceLocatorToDatapool(2056934656, ASLVICSETCDSRCPropertyManager.MESSAGE_SUB_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1553618176, 0);
        }
    }

    protected void handleDsrcEnterDetails() {
        this.target.traceMsg("HSM_START - VicsStateDsrcDetails", this);
        this.dsrcDetailsResourceList.clear();
        this.resetDsrcDetailsResourceIndex();
        boolean bl = this.target.notfiyModelIfMessageExpired(1721390336, 2);
        this.dsrcNotifyModelOnDetailsImageCount();
        if (bl) {
            this.dsrcRequestDetailsResourcesForMessagesFromDsi(this.target.selectedMessage);
        } else {
            this.dsrcDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1184519424, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeStringToDatapool(1939494144, "");
            VicsTarget.writeResourceLocatorToDatapool(2056934656, ASLVICSETCDSRCPropertyManager.MESSAGE_SUB_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1553618176, 0);
        }
    }

    private void dsrcNotifyModelOnDetailsImageCount() {
        if (this.target.selectedMessage == null) {
            this.target.traceMsg("Selected traffic message was null!", this);
            VicsTarget.writeIntegerToDatapool(1167742208, 0);
            return;
        }
        int n = this.target.selectedMessage.detailContentIDs.length;
        VicsTarget.writeIntegerToDatapool(1167742208, n);
    }

    private void resetDsrcDetailsResourceIndex() {
        if (!this.isEnterContextAfterUpdate) {
            this.dsrcDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(1184519424, this.dsrcDetailsResourceIndex);
            VicsTarget.writeIntegerToDatapool(1805276416, this.dsrcDetailsResourceIndex + 1);
        }
    }

    protected void handleSpeechPromptStarted() {
        this.target.traceMsg("EVT_SPEECH_PROMPT_STARTED - VicsStateDsrc", this);
        this.target.dsrcHandler.isMessagePlaying = true;
        VicsTarget.writeIntegerToDatapool(1117410560, 1);
    }

    protected void handleSpeechPromptFinished() {
        this.target.traceMsg("EVT_SPEECH_PROMPT_FINISHED - VicsStateDsrc", this);
        this.target.dsrcHandler.isMessagePlaying = false;
        VicsTarget.writeIntegerToDatapool(1117410560, 0);
    }

    protected void handleDsrcPressedPlay() {
        this.target.traceMsg("PRESS_BUTTON_PLAY - VicsStateDsrc", this);
        boolean bl = this.dsrcNotifiyModelIfFirstMessageIsAvailable();
        if (bl) {
            this.isMessagePlaying = !this.isMessagePlaying;
            VicsTarget.writeIntegerToDatapool(1117410560, this.isMessagePlaying ? 1 : 0);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(this.isMessagePlaying ? 681202944 : 697980160);
            if (!this.isMessagePlaying) {
                this.target.promptEngine.getSpeakOnlyService(2).cancelCurrentRunningPrompt();
            }
        }
    }

    protected void handleDsrcDetailsPressedPlay() {
        this.target.traceMsg("PRESS_BUTTON_PLAY - VicsStateDsrcDetails", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(1721390336, 2);
        if (bl) {
            this.isMessagePlaying = !this.isMessagePlaying;
            VicsTarget.writeIntegerToDatapool(1117410560, this.isMessagePlaying ? 1 : 0);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(this.isMessagePlaying ? 681202944 : 697980160);
            if (!this.isMessagePlaying) {
                this.target.promptEngine.getSpeakOnlyService(2).cancelCurrentRunningPrompt();
            }
        }
    }

    protected void handleDsrcEnterContextAfterUpdate(EventGeneric eventGeneric) {
        this.target.traceMsg("ENTER_CONTEXT_AFTER_UPDATE - VicsStateDsrc", this);
        this.isEnterContextAfterUpdate = eventGeneric.getBoolean(0);
    }

    protected void handleDsrcCheckIfCurrentMessageExpired() {
        this.target.traceMsg("EV_ASL_CHECK_IF_DSRC_MSG_EXPIRED - VicsStateDsrcDetails", this);
        boolean bl = this.target.vicsTrafficLists.getDsrcMessages().length > 0;
        boolean bl2 = bl && this.target.isMessageExpired(this.target.selectedMessage, 2);
        this.target.traceMsg(new StringBuffer().append("The current dsrc message ").append(this.target.selectedMessage).append(" is expired? ").append(bl2).toString(), this);
        if (bl2) {
            this.target.sendHMIEvent(630871296);
            this.target.stateMain.transStateMain();
        }
    }
}

