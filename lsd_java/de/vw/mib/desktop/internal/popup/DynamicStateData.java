/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.popup;

import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.popup.DynamicStateData$1;
import de.vw.mib.desktop.internal.popup.DynamicStateData$2;
import de.vw.mib.desktop.internal.popup.PopupEntry;
import de.vw.mib.desktop.internal.popup.TimeoutListener;
import de.vw.mib.timer.Timer;

public class DynamicStateData {
    private final int dynamicStateId;
    private final int popupInfoId;
    private TimeoutListener timeoutListener;
    protected int sequenceNr = 0;
    private PopupEntry currentPopupEntry = null;
    private Timer timerTimeout = null;
    private Timer timerMinTime = null;
    private boolean minTimeExpired = false;
    private boolean closeAfterMinTimeExpired = false;
    private boolean active = false;
    private boolean suspended = false;
    private boolean suppressedBySpeechDialog = false;
    private boolean movedToHomeContext = false;

    DynamicStateData(int n, int n2, TimeoutListener timeoutListener) {
        this.dynamicStateId = n;
        this.popupInfoId = n2;
        this.timeoutListener = timeoutListener;
    }

    public void activate() {
        if (!this.active) {
            this.active = true;
            ServiceManager.statemachineManager.activatePopup(this.dynamicStateId);
        }
    }

    public void deactivate() {
        if (this.active) {
            this.active = false;
            ServiceManager.statemachineManager.deactivatePopup(this.dynamicStateId);
        }
    }

    public void setSpeechDialogActive(boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = bl && !this.isActiveDuringSpeechDialog();
        if (bl2 != this.suppressedBySpeechDialog) {
            if (bl) {
                this.stopTimers();
            } else {
                this.restartTimers();
            }
            this.suppressedBySpeechDialog = bl2;
        }
    }

    private boolean isActiveDuringSpeechDialog() {
        return ServiceManager.popupInformationTable.isActiveDuringSpeechDialog(this.getPopupInfoId()) || ServiceManager.popupInformationTable.isStopsSpeech(this.getPopupInfoId());
    }

    public boolean isSuppressedBySpeech() {
        return this.suppressedBySpeechDialog;
    }

    public boolean isStopsSpeech() {
        return ServiceManager.popupInformationTable.isStopsSpeech(this.getPopupInfoId());
    }

    public void reinit() {
        this.stopTimers();
        this.timerTimeout = null;
        this.timerMinTime = null;
        this.minTimeExpired = false;
        this.closeAfterMinTimeExpired = false;
        this.movedToHomeContext = false;
        this.suppressedBySpeechDialog = false;
    }

    public int getDynamicStateId() {
        return this.dynamicStateId;
    }

    public int getPopupInfoId() {
        return this.currentPopupEntry != null ? this.currentPopupEntry.getPopupInfoId() : this.popupInfoId;
    }

    public PopupEntry getCurrentPopupEntry() {
        return this.currentPopupEntry;
    }

    public void setCurrentPopupEntry(PopupEntry popupEntry) {
        this.currentPopupEntry = popupEntry;
    }

    public void startTimers() {
        this.closeAfterMinTimeExpired = false;
        this.restartTimers();
    }

    private void restartTimers() {
        int n;
        int n2 = ServiceManager.popupInformationTable.getTimeout(this.getPopupInfoId());
        if (n2 > 0) {
            this.timerTimeout = ServiceManager.timerManager.createTimer(new StringBuffer().append("PopupTimeout-").append(this.getPopupInfoId()).toString(), n2, false, new DynamicStateData$1(this), ServiceManager.eventDispatcher);
            this.timerTimeout.start();
        }
        if ((n = ServiceManager.popupInformationTable.getTimeMin(this.getPopupInfoId())) > 0) {
            this.timerMinTime = ServiceManager.timerManager.createTimer(new StringBuffer().append("PopupMinTime-").append(this.getPopupInfoId()).toString(), n, false, new DynamicStateData$2(this), ServiceManager.eventDispatcher);
            this.timerMinTime.start();
        } else {
            this.minTimeExpired = true;
        }
    }

    public void restartTimeout() {
        int n;
        if (this.timerTimeout != null && (n = ServiceManager.popupInformationTable.getTimeRestart(this.popupInfoId)) > 0) {
            this.timerTimeout.setDelayFromNow(n);
        }
    }

    public void setSuspended(boolean bl) {
        this.suspended = bl;
    }

    public boolean isSuspended() {
        return this.suspended;
    }

    public void stopTimers() {
        ++this.sequenceNr;
        if (this.timerTimeout != null) {
            this.timerTimeout.stop();
        }
        if (this.timerMinTime != null) {
            this.timerMinTime.stop();
        }
    }

    public boolean hasMinTimeExpired() {
        if (ServiceManager.popupInformationTable.getTimeMin(this.getPopupInfoId()) > 0 && this.currentPopupEntry != null && this.currentPopupEntry.hasBeenVisible()) {
            return this.minTimeExpired;
        }
        return true;
    }

    void doTimeout(int n) {
        if (n == this.sequenceNr && this.timeoutListener != null) {
            this.timeoutListener.onTimeout(this.dynamicStateId);
        }
    }

    void doMinTimeExpired(int n) {
        if (n == this.sequenceNr) {
            this.minTimeExpired = true;
            if (this.closeAfterMinTimeExpired) {
                this.doTimeout(n);
            }
        }
    }

    void dispose() {
        if (this.currentPopupEntry != null) {
            this.currentPopupEntry.setHasBeenVisible(false);
        }
        this.stopTimers();
        this.timeoutListener = null;
        this.timerTimeout = null;
        this.timerMinTime = null;
        this.currentPopupEntry = null;
    }

    public void requestCloseAfterMinTimeExpired() {
        this.closeAfterMinTimeExpired = true;
    }

    public boolean hasMovedToHomeContext() {
        return this.movedToHomeContext;
    }

    public void setMovedToHomeContext(boolean bl) {
        this.movedToHomeContext = bl;
    }
}

