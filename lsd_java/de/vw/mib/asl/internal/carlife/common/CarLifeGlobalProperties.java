/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.common.CarLifeResourceOwner;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;

public final class CarLifeGlobalProperties {
    private final String classname;
    private final CarlifeHSMTarget target;
    private final CarLifeResourceOwner currentResourceOwner;
    private int connectionState = 0;
    private boolean isCanvasVisible = false;
    private boolean isNightMode = false;
    private boolean isVolumeLock = false;
    private boolean popupOpen = false;
    private boolean sdsOpen = false;
    private boolean canvasDimed = false;
    private int lastEntertainmentContextForAutoplay = -1;
    private String oemIconTitle = "HMI";
    private boolean hmiRouteGuidanceActive = false;
    private boolean videoAvailable = false;
    private boolean videoAvailableInSession = false;
    private boolean setModeActive = false;
    private boolean dsiRegistered = false;

    public CarLifeGlobalProperties(CarlifeHSMTarget carlifeHSMTarget) {
        this.classname = "CarLifeGlobalProperties";
        Preconditions.checkNotNull(carlifeHSMTarget, "CarlifeHSMTarget must not be null!");
        this.target = carlifeHSMTarget;
        this.currentResourceOwner = new CarLifeResourceOwner();
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public boolean isConnected() {
        return this.connectionState == 3;
    }

    public void setConnectionState(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CarLife - connection state changed. old = ").append(this.connectionState).append(", new = ").append(n).toString());
        }
        this.connectionState = n;
    }

    public boolean isDSIRegistered() {
        return this.dsiRegistered;
    }

    public void setDSIRegistered(boolean bl) {
        this.dsiRegistered = bl;
    }

    public int getActiveNavigation() {
        return this.currentResourceOwner.getNavigationOwner();
    }

    public void setActiveNavigation(int n) {
        this.currentResourceOwner.setNavigationOwner(n);
    }

    public int getCurrentScreenOwner() {
        return this.currentResourceOwner.getScreenOwner();
    }

    public void setCurrentScreenOwner(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarLifeGlobalProperties").append(".setCurrentScreenSource(currentMainScreenOwner=").append(n).append(")").log();
        }
        this.currentResourceOwner.setScreenOwner(n);
    }

    public int getCurrentAudioMediaOwner() {
        return this.currentResourceOwner.getAudioMediaOwner();
    }

    public void setCurrentAudioMediaOwner(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarLifeGlobalProperties").append(".setCurrentAudioMediaSource(currentAudioMediaOwner=").append(n).append(")").log();
        }
        this.currentResourceOwner.setAudioMediaOwner(n);
    }

    public int getCurrentAudioMicrophoneOwner() {
        return this.currentResourceOwner.getAudioMicrophoneOwner();
    }

    public void setCurrentAudioMicrophoneOwner(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarLifeGlobalProperties").append(".setCurrentAudioMicrophoneSource(currentAudioMicrophoneOwner=").append(n).append(")").log();
        }
        this.currentResourceOwner.setAudioMicrophoneOwner(n);
    }

    public int getCurrentAudioTTSOwner() {
        return this.currentResourceOwner.getAudioTTSOwner();
    }

    public void setCurrentAudioTTSOwner(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarLifeGlobalProperties").append(".setCurrentAudioTTSSource(currentAudioTTSOwner=").append(n).append(")").log();
        }
        this.currentResourceOwner.setAudioTTSOwner(n);
    }

    public CarLifeResourceOwner getCurrentResourceOwner() {
        return this.currentResourceOwner;
    }

    public boolean isCanvasVisible() {
        return this.isCanvasVisible;
    }

    public void setCanvasVisible(boolean bl) {
        this.isCanvasVisible = bl;
    }

    public int getActiveSpeech() {
        return this.currentResourceOwner.getSpeechOwner();
    }

    public void setActiveSpeech(int n) {
        this.currentResourceOwner.setSpeechOwner(n);
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }

    public void setNightMode(boolean bl) {
        this.isNightMode = bl;
    }

    public boolean isVolumeLock() {
        return this.isVolumeLock;
    }

    public void setVolumeLock(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARLIFE - setVolumeLock = ").append(bl).toString());
        }
        this.isVolumeLock = bl;
    }

    public int getLastEntertainmentContextForAutoplay() {
        return this.lastEntertainmentContextForAutoplay;
    }

    public void setLastEntertainmentContextForAutoplay(int n) {
        this.lastEntertainmentContextForAutoplay = n;
    }

    public boolean isPopupOpen() {
        return this.popupOpen;
    }

    public void setPopupOpen(boolean bl) {
        this.popupOpen = bl;
    }

    public boolean isCanvasDimmed() {
        return this.canvasDimed;
    }

    public void setCanvasDimed(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARLIFE - setCanvasDimmed = ").append(bl).toString());
        }
        this.canvasDimed = bl;
    }

    public String getOemIconTitle() {
        return this.oemIconTitle;
    }

    public void setOemIconTitle(String string) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARLIFE - setOemIconTitle = ").append(string).toString());
        }
        this.oemIconTitle = string;
    }

    public boolean isHmiRouteGuidanceActive() {
        return this.hmiRouteGuidanceActive;
    }

    public void setHmiRouteGuidanceActive(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARLIFE - setHmiRouteGuidanceActive = ").append(bl).toString());
        }
        this.hmiRouteGuidanceActive = bl;
    }

    public boolean isSdsOpen() {
        return this.sdsOpen;
    }

    public void setSdsOpen(boolean bl) {
        this.sdsOpen = bl;
    }

    public boolean isVideoAvailableInSession() {
        return this.videoAvailableInSession;
    }

    public void setVideoAvailableInSession(boolean bl) {
        this.videoAvailableInSession = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1365715968, bl);
    }

    public boolean isVideoAvailable() {
        return this.videoAvailable;
    }

    public void setVideoAvailable(boolean bl) {
        this.videoAvailable = bl;
    }

    public boolean isSetModeActive() {
        return this.setModeActive;
    }

    public void setSetModeActive(boolean bl) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarLifeGlobalProperties").append("::setSetModeActive( ").append(bl).append(" )").log();
        }
        this.setModeActive = bl;
    }
}

