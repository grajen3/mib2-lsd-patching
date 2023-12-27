/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.vicsetc.PhoneticStringUtils;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import generated.de.vw.mib.asl.internal.vicsetc.popups.ASLVICSETCPopupsPropertyManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public class VicsPopupHandler {
    private final VicsTarget target;
    protected HashSet popupGraphicsResourcesLoaded = new HashSet();
    protected int popupGraphicsDetailsResourceIndex = 0;
    protected boolean isPopupDisplayed = false;
    protected final List popupGraphicsDetailsResourceList;

    public VicsPopupHandler(VicsTarget vicsTarget) {
        this.target = vicsTarget;
        this.popupGraphicsDetailsResourceList = new ArrayList();
    }

    protected void handleReceivedInterrupt(Interrupt interrupt) {
        if (interrupt == null) {
            this.target.traceMsg("Interrupt was null.", this);
            return;
        }
        if (this.target.vicsEtcDP == null) {
            this.target.error("DataPool was null.");
            return;
        }
        this.resetPopupResourceImageIndex();
        this.notifyModelOnResourceImageCount(interrupt);
        this.target.traceMsg(new StringBuffer().append("Received interrupt message with following type: ").append(interrupt.interruptType).toString(), this);
        boolean bl = this.isEmergencyMessage(interrupt);
        VicsTarget.writeBooleanToDatapool(2023380224, bl);
        this.target.popupWasShown = false;
        this.target.traceMsg(new StringBuffer().append("setting popupWasShown to false. popupWasShown = ").append(this.target.popupWasShown).toString(), this);
        if (this.isBeaconMessageReceivedAndActive(interrupt)) {
            this.target.traceMsg("Trigger PU for beacon message.", this);
            this.triggerPopup();
        } else if (this.isBeaconGraphicReceivedAndActive(interrupt)) {
            this.target.traceMsg("Trigger PU for beacon graphic.", this);
            this.triggerPopup();
        } else if (this.isDrivingSupportOrTrafficInformationReceivedAndActive(interrupt)) {
            this.target.traceMsg("Trigger PU for driving support or traffic information.", this);
            this.triggerPopup();
        } else if (this.isTrafficInformationReceivedAndActive(interrupt)) {
            this.target.traceMsg("Trigger PU for traffic information.", this);
            this.triggerPopup();
        } else if (this.isDrivingSupportReceivedAndActive(interrupt)) {
            this.target.traceMsg("Trigger PU for driving support.", this);
            this.triggerPopup();
        } else if (this.isTrafficAnnouncementReceivedAndActive(interrupt)) {
            this.target.traceMsg("Trigger PU for traffic announcement.", this);
            this.triggerVoicePopup();
        } else {
            this.target.traceMsg("Interrupt was unknown or not active in setup.", this);
            this.isPopupDisplayed = false;
            if (!this.target.interruptStack.isEmpty()) {
                this.target.interruptStack.pop();
                Interrupt interrupt2 = !this.target.interruptStack.isEmpty() ? (Interrupt)this.target.interruptStack.peek() : null;
                this.requestInterruptResourcesFromDsi(interrupt2);
            }
        }
    }

    private void triggerVoicePopup() {
        this.target.startTimer(143065344, (long)0, false);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(479876352);
    }

    private void triggerPopup() {
        this.target.startTimer(143065344, (long)0, false);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(446321920);
    }

    private boolean isTrafficAnnouncementReceivedAndActive(Interrupt interrupt) {
        return interrupt.getInterruptType() == 20 && this.target.vicsEtcDP.isPopupEtcTrafficAnnouncementChecked();
    }

    private boolean isDrivingSupportReceivedAndActive(Interrupt interrupt) {
        return (interrupt.getInterruptType() == 16 || interrupt.getInterruptType() == 15 || interrupt.getInterruptType() == 14 || interrupt.getInterruptType() == 9) && this.target.vicsEtcDP.isPopupEtcDrivingSupportChecked();
    }

    private boolean isTrafficInformationReceivedAndActive(Interrupt interrupt) {
        return (interrupt.getInterruptType() == 12 || interrupt.getInterruptType() == 17 || interrupt.getInterruptType() == 19 || interrupt.getInterruptType() == 11 || interrupt.getInterruptType() == 13 || interrupt.getInterruptType() == 18) && this.target.vicsEtcDP.isPopupEtcTrafficInformationChecked();
    }

    private boolean isEmergencyMessage(Interrupt interrupt) {
        return interrupt.getInterruptType() == 5 || interrupt.getInterruptType() == 1 || interrupt.getInterruptType() == 8 || interrupt.getInterruptType() == 14 || interrupt.getInterruptType() == 5;
    }

    private boolean isDrivingSupportOrTrafficInformationReceivedAndActive(Interrupt interrupt) {
        return !(interrupt.getInterruptType() != 8 && interrupt.getInterruptType() != 10 || !this.target.vicsEtcDP.isPopupEtcDrivingSupportChecked() && !this.target.vicsEtcDP.isPopupEtcTrafficInformationChecked());
    }

    private boolean isBeaconGraphicReceivedAndActive(Interrupt interrupt) {
        return (interrupt.getInterruptType() == 4 || interrupt.getInterruptType() == 7) && this.target.vicsEtcDP.isVicsBeaconGraphicsChecked();
    }

    private boolean isBeaconMessageReceivedAndActive(Interrupt interrupt) {
        return (interrupt.getInterruptType() == 1 || interrupt.getInterruptType() == 3 || interrupt.getInterruptType() == 2 || interrupt.getInterruptType() == 5 || interrupt.getInterruptType() == 6) && this.target.vicsEtcDP.isVicsBeaconMessageChecked();
    }

    protected void notifyModelOnResourceImageCount(Interrupt interrupt) {
        if (interrupt == null) {
            this.target.traceMsg("Interrupt was null.", this);
            return;
        }
        VicsTarget.writeIntegerToDatapool(949638400, interrupt.contentID.length);
    }

    protected void resetPopupResourceImageIndex() {
        this.target.traceMsg("resetPopupResourceImageIndex()", this);
        this.popupGraphicsDetailsResourceIndex = 0;
        VicsTarget.writeIntegerToDatapool(1352291584, this.popupGraphicsDetailsResourceIndex);
    }

    protected void requestInterruptResourcesAndActivatePopup(Interrupt[] interruptArray) {
        this.target.traceMsg("requestInterruptResourcesAndActivatePopup()", this);
        for (int i2 = 0; i2 < interruptArray.length; ++i2) {
            Interrupt interrupt = interruptArray[i2];
            if (this.isInterruptHighPriority(interrupt)) {
                this.addHighPriorityInterruptToStack(interrupt);
                continue;
            }
            this.addLowPriorityInterruptToStack(interrupt);
        }
        Interrupt interrupt = !this.target.interruptStack.isEmpty() ? (Interrupt)this.target.interruptStack.peek() : null;
        this.requestInterruptResourcesFromDsi(interrupt);
    }

    protected void addLowPriorityInterruptToStack(Interrupt interrupt) {
        this.target.traceMsg(new StringBuffer().append("addLowPriorityInterruptToStack() : ").append(interrupt).toString(), this);
        if (this.target.interruptStack.isEmpty()) {
            this.target.interruptStack.push(interrupt);
        } else {
            int n = this.target.interruptStack.indexOf(this.target.interruptStack.lastElement()) - 1;
            this.target.interruptStack.add(n == -1 ? 0 : n, interrupt);
        }
    }

    protected void addHighPriorityInterruptToStack(Interrupt interrupt) {
        this.target.traceMsg(new StringBuffer().append("addHighPriorityInterruptToStack() : ").append(interrupt).toString(), this);
        if (this.isPopupDisplayed && !this.target.interruptStack.isEmpty()) {
            int n = this.target.interruptStack.indexOf(this.target.interruptStack.lastElement()) - 1;
            this.target.interruptStack.add(n == -1 ? 0 : n, interrupt);
        } else {
            this.target.interruptStack.push(interrupt);
        }
    }

    private boolean isInterruptHighPriority(Interrupt interrupt) {
        this.target.traceMsg(new StringBuffer().append("isInterruptHighPriority() : ").append(interrupt).toString(), this);
        return interrupt.getInterruptType() == 1 || interrupt.getInterruptType() == 8 || interrupt.getInterruptType() == 14 || interrupt.getInterruptType() == 5;
    }

    protected void handlePopupTimedOut() {
        this.target.traceMsg("EV_NAV_POPUP_TIMED_OUT - VicsStateMain", this);
        if (!this.target.popupWasShown) {
            this.target.traceMsg("Popup timed out.", this);
            this.isPopupDisplayed = false;
            if (!this.target.interruptStack.isEmpty()) {
                this.target.interruptStack.pop();
                Interrupt interrupt = !this.target.interruptStack.isEmpty() ? (Interrupt)this.target.interruptStack.peek() : null;
                this.requestInterruptResourcesFromDsi(interrupt);
            }
        }
        this.target.popupWasShown = false;
        this.target.traceMsg(new StringBuffer().append("Setting popupWasShown to false. popupWasShown = ").append(this.target.popupWasShown).toString(), this);
    }

    protected void handleVenmPopupTimedOut() {
        this.target.traceMsg("EV_NAV_VENM_POPUP_TIMED_OUT - VicsStateMain", this);
        if (!this.target.popupWasShown) {
            this.target.traceMsg("Popup timed out.", this);
            this.isPopupDisplayed = false;
            if (!this.target.venmMessageStack.isEmpty()) {
                this.target.venmMessageStack.pop();
                this.target.venmHandler.requestResourceLocatorForTmcIcon();
            }
        }
        this.target.popupWasShown = false;
        this.target.traceMsg(new StringBuffer().append("Setting popupWasShown to false. popupWasShown = ").append(this.target.popupWasShown).toString(), this);
    }

    private void requestInterruptResourcesFromDsi(Interrupt interrupt) {
        this.target.traceMsg(new StringBuffer().append("requestInterruptResourcesFromDsi() : ").append(interrupt).toString(), this);
        if (interrupt == null) {
            this.target.traceMsg("Interrupt was null.", this);
            return;
        }
        if (!this.isPopupDisplayed) {
            this.isPopupDisplayed = true;
            this.resetPopupResourcesAndGetterForNextInterrupt(interrupt);
            this.popupGraphicsResourcesLoaded.clear();
            for (int i2 = 0; i2 < interrupt.contentID.length; ++i2) {
                int n = interrupt.contentID[i2];
                this.popupGraphicsResourcesLoaded = this.target.requestResourceInformation(n, this.popupGraphicsResourcesLoaded);
            }
        }
    }

    private void resetPopupResourcesAndGetterForNextInterrupt(Interrupt interrupt) {
        this.target.traceMsg(new StringBuffer().append("resetPopupResourcesAndGetterForNextInterrupt() : ").append(interrupt).toString(), this);
        this.popupGraphicsResourcesLoaded.clear();
        this.popupGraphicsDetailsResourceIndex = 0;
        this.popupGraphicsDetailsResourceList.clear();
        VicsTarget.writeBooleanToDatapool(1754944768, false);
        VicsTarget.writeIntegerToDatapool(1369068800, interrupt.contentID.length);
        VicsTarget.writeIntegerToDatapool(1352291584, 0);
        VicsTarget.writeStringToDatapool(1452954880, "");
        VicsTarget.writeResourceLocatorToDatapool(2140820736, ASLVICSETCPopupsPropertyManager.MESSAGE_GRAPHIC_RESOURCE__DEFAULT_VALUE);
    }

    protected void handlePopupsPressedNext() {
        boolean bl;
        this.target.traceMsg("PRESS_BUTTON_NEXT - VicsStateMain", this);
        boolean bl2 = bl = !this.target.interruptStack.isEmpty() && this.target.interruptStack.peek() != null;
        if (bl && ((Interrupt)this.target.interruptStack.peek()).contentID.length > this.popupGraphicsDetailsResourceIndex + 1) {
            ++this.popupGraphicsDetailsResourceIndex;
            VicsTarget.writeIntegerToDatapool(1352291584, this.popupGraphicsDetailsResourceIndex);
            ResourceInformation resourceInformation = (ResourceInformation)this.target.popupHandler.popupGraphicsDetailsResourceList.get(this.target.popupHandler.popupGraphicsDetailsResourceIndex);
            String string = PhoneticStringUtils.extractPhonemeString(resourceInformation.getPhoneticString(), this.target);
            String string2 = PhoneticStringUtils.extractPhonemeAlphabet(resourceInformation.getPhoneticString(), this.target);
            boolean bl3 = !StringUtil.isEmpty(string);
            VicsTarget.writeBooleanToDatapool(1754944768, bl3);
            VicsTarget.writeStringToDatapool(1452954880, string);
            VicsTarget.writeStringToDatapool(-2103814912, string2);
            VicsTarget.writeResourceLocatorToDatapool(2140820736, resourceInformation.getResourceLocator());
            if (bl3) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(781866240);
            }
        }
    }

    protected void handlePopupsPressedPrev() {
        boolean bl;
        this.target.traceMsg("PRESS_BUTTON_NEXT - VicsStateMain", this);
        boolean bl2 = bl = !this.target.interruptStack.isEmpty() && this.target.interruptStack.peek() != null;
        if (bl && this.popupGraphicsDetailsResourceIndex > 0) {
            --this.popupGraphicsDetailsResourceIndex;
            VicsTarget.writeIntegerToDatapool(1352291584, this.popupGraphicsDetailsResourceIndex);
            ResourceInformation resourceInformation = (ResourceInformation)this.target.popupHandler.popupGraphicsDetailsResourceList.get(this.target.popupHandler.popupGraphicsDetailsResourceIndex);
            String string = PhoneticStringUtils.extractPhonemeString(resourceInformation.getPhoneticString(), this.target);
            String string2 = PhoneticStringUtils.extractPhonemeAlphabet(resourceInformation.getPhoneticString(), this.target);
            boolean bl3 = !StringUtil.isEmpty(string);
            VicsTarget.writeBooleanToDatapool(1754944768, bl3);
            VicsTarget.writeStringToDatapool(1452954880, string);
            VicsTarget.writeStringToDatapool(-2103814912, string2);
            VicsTarget.writeResourceLocatorToDatapool(2140820736, resourceInformation.getResourceLocator());
            if (bl3) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(781866240);
            }
        }
    }

    protected void handlePopupsClosed() {
        this.target.traceMsg("PRESS_BUTTON_OK - VicsStateMain", this);
        this.isPopupDisplayed = false;
        VicsTarget.writeIntegerToDatapool(1352291584, 0);
        if (!this.target.interruptStack.isEmpty()) {
            this.target.interruptStack.pop();
            Interrupt interrupt = !this.target.interruptStack.isEmpty() ? (Interrupt)this.target.interruptStack.peek() : null;
            this.requestInterruptResourcesFromDsi(interrupt);
        }
    }

    protected void handleVenmPopupClosed() {
        this.target.traceMsg("PRESS_BUTTON_OK - VENM_BUTTON_OK_PRESSED", this);
        this.isPopupDisplayed = false;
        if (!this.target.venmMessageStack.isEmpty()) {
            this.target.venmMessageStack.pop();
            this.target.venmHandler.requestResourceLocatorForTmcIcon();
        }
    }
}

