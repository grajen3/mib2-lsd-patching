/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.asl.internal.carlife.common.CarLifeHelper;
import de.vw.mib.asl.internal.carlife.common.CarLifeModeHandling;
import de.vw.mib.asl.internal.carlife.common.VideoStateHandler;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.timer.Timer;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSIHandler {
    private final String classname;
    private final CarlifeHSMTarget target;
    private final CarLifeGlobalProperties properties;
    private final CarLifeModeHandling modehandling;
    private final VideoStateHandler videoStateHandler;
    boolean timerNoVideoContentPopupRunning;
    Timer carLifeNoVideoContentTimer;

    public DSIHandler(CarlifeHSMTarget carlifeHSMTarget, CarLifeGlobalProperties carLifeGlobalProperties, CarLifeModeHandling carLifeModeHandling, VideoStateHandler videoStateHandler) {
        this.classname = "DSIHandler";
        Preconditions.checkNotNull(carlifeHSMTarget, "CarlifeHSMTarget must not be null!");
        Preconditions.checkNotNull(carLifeGlobalProperties, "CarlifeProperties must not be null!");
        Preconditions.checkNotNull(videoStateHandler, "VideoStateHandler must not be null!");
        this.target = carlifeHSMTarget;
        this.properties = carLifeGlobalProperties;
        this.modehandling = carLifeModeHandling;
        this.videoStateHandler = videoStateHandler;
    }

    public void handleDsiCarlifeResponseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("CarLife.handleDsiCarlifeResponseSetMode called").log();
        }
        int n = this.modehandling.getNavigationOwner(appStateArray);
        int n2 = this.properties.getActiveNavigation();
        if (CarLifeHelper.isSwitchAppOwnerToMainUnit(n2, n)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - Active Navigation is now: HMI");
            }
            if (n2 == 2) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(1332161536, false);
            }
        }
        this.properties.getCurrentResourceOwner().update(resourceArray, appStateArray);
        this.properties.setSetModeActive(false);
        this.modehandling.sendSetMode();
    }

    public void handleDsiCarlifeUpdateNowPlayingData(TrackData trackData) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("CarLife.updateNowPlayingData called").log();
        }
    }

    public void handleDsiCarlifeUpdatePlaybackState(PlaybackInfo playbackInfo) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("CarLife.updatePlaybackState called").log();
        }
    }

    public void handleDsiCarlifeUpdatePlaymodeState(PlaymodeInfo playmodeInfo) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("CarLife.updatePlaymodeState called");
        }
    }

    public void handleDsiCarlifeUpdatePlayposition(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("CarLife.updatePlayposition called").log();
        }
    }

    public void handleDsiCarlifeUpdateCoverArtUrl(ResourceLocator resourceLocator) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("CarLife.updateCoverArtUrl called").log();
        }
    }

    public void handleDsiCarlifeUpdateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("CarLife.updateNavigationNextTurnInfo called").log();
        }
    }

    public void handleDsiCarlifeUpdateDeviceInfo(DeviceInfo deviceInfo) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("CarLife.updateDeviceInfo called").log();
        }
    }

    public void handleDsiCarlifeRequestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        this.modehandling.handleModeChanges(resourceArray, appStateArray);
    }

    public void handleDsiCarlifeUpdateCallState(CallState callState) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("CarLife.updateCallState called").log();
        }
    }

    public void handledsiCarLifeUpdateVideoAvailable(boolean bl) {
        this.videoStateHandler.handleVideoAvailable(bl);
    }
}

