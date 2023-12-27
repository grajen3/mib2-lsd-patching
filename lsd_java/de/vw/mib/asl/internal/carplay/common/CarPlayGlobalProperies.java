/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.common;

import de.vw.mib.asl.internal.carplay.common.CarPlayHMIRequestParameterConfiguration;
import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import de.vw.mib.log4mib.LogMessage;
import java.util.Hashtable;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.smartphoneintegration.Device;

public final class CarPlayGlobalProperies {
    private final String classname;
    private HsmTarget target;
    Device currentConnectedDevice;
    CarPlayHMIRequestParameterConfiguration paramconfig;
    private int connectionState = 0;
    private int currentMainScreenSource = 1;
    private int currentMainAudioSource = 1;
    private int currentMainAudioType = 0;
    private int[] currentSoundStatus = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    private boolean currentMuteState = false;
    private boolean currentAudibleState = false;
    private boolean isSoundManagementAvailable = false;
    private boolean isActiveEntertainment = false;
    private int activeNavigation = 0;
    private int activeSpeech = 0;
    private boolean isAudioBorrowState = false;
    private boolean isVideoBorrowState = false;
    private boolean isCanvasVisible = false;
    private boolean isNightMode = false;
    private int ringtoneConnection = -1;
    private boolean isVolumeLock = false;
    private boolean popupOpen = false;
    private boolean sdsOpen = false;
    private boolean canvasDimed = false;
    private boolean isAutoplayFirstMediaRequest = true;
    private int lastEntertainmentContextForAutoplay = -1;
    private int lastPTTKey = 0;
    private boolean delayBorrowAudio = false;
    private String oemIconTitle = "HMI";
    private boolean hmiRouteGuidanceActive = false;
    private boolean doEdgeDelayExecution = false;
    private int ocuCallState = 0;
    private Hashtable currentCallStates = new Hashtable();
    private TelephonyState currentTelephonyState = null;
    private boolean telephonyStateValid = false;
    private boolean phoneWaitsForResponseMainAudioType = false;

    public CarPlayGlobalProperies(HsmTarget hsmTarget) {
        this.classname = "CarPlayGlobalProperies";
        this.target = hsmTarget;
        this.currentConnectedDevice = new Device();
        this.paramconfig = new CarPlayHMIRequestParameterConfiguration();
    }

    public Device getCurrentConnectedDevice() {
        return this.currentConnectedDevice;
    }

    public void setCurrentConnectedDevice(Device device) {
        this.currentConnectedDevice = device;
    }

    public CarPlayHMIRequestParameterConfiguration getParamconfig() {
        return this.paramconfig;
    }

    public void setParamconfig(CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration) {
        this.paramconfig = carPlayHMIRequestParameterConfiguration;
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public boolean isConnected() {
        return this.connectionState == 3;
    }

    public void setConnectionState(int n) {
        if (this.target != null && this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CarPlay - connection state changed. old = ").append(this.connectionState).append(", new = ").append(n).toString());
        }
        boolean bl = false;
        if (this.connectionState != n) {
            bl = true;
        }
        this.connectionState = n;
        if (bl && this.target != null) {
            this.target.getClusterService().sendCarplayActiveUpdate();
        }
    }

    public int getActiveNavigation() {
        return this.activeNavigation;
    }

    public void setActiveNavigation(int n) {
        boolean bl = false;
        if (this.activeNavigation == 2 != (n == 2)) {
            bl = true;
        }
        this.activeNavigation = n;
        if (bl && this.target != null) {
            this.target.getClusterService().sendRouteGuidanceUpdate();
        }
    }

    public int getCurrentScreenSource() {
        return this.currentMainScreenSource;
    }

    public void setCurrentScreenSource(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarPlayGlobalProperies").append(".setCurrentScreenSource(currentMainScreenSource=").append(n).append(")").log();
        }
        this.currentMainScreenSource = n;
    }

    public int getCurrentMainAudioSource() {
        return this.currentMainAudioSource;
    }

    public void setCurrentMainAudioSource(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarPlayGlobalProperies").append(".setCurrentMainAudioSource(currentMainAudioSource=").append(n).append(")").log();
        }
        this.currentMainAudioSource = n;
    }

    public boolean isCanvasVisible() {
        return this.isCanvasVisible;
    }

    public void setCanvasVisible(boolean bl) {
        this.isCanvasVisible = bl;
    }

    public int getCurrentMainAudioType() {
        return this.currentMainAudioType;
    }

    public void setCurrentMainAudioType(int n) {
        this.currentMainAudioType = n;
    }

    public int getCurrentSoundStatus(int n) {
        return this.currentSoundStatus[this.transformConnectionToInternNumber(n)];
    }

    public void setCurrentSoundStatus(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - setCurrentSoundStatus(").append(n).append(") = ").append(n2).toString());
        }
        this.currentSoundStatus[this.transformConnectionToInternNumber((int)n)] = n2;
    }

    public int transformConnectionToInternNumber(int n) {
        switch (n) {
            case 162: {
                return 0;
            }
            case 154: {
                return 1;
            }
            case 151: {
                return 2;
            }
            case 163: {
                return 3;
            }
            case 152: {
                return 4;
            }
            case 153: {
                return 5;
            }
            case 155: {
                return 6;
            }
        }
        if (n == this.getRingtoneConnection()) {
            return 7;
        }
        return -1;
    }

    public boolean getCurrentMuteState() {
        return this.currentMuteState;
    }

    public void setCurrentMuteState(boolean bl) {
        this.currentMuteState = bl;
    }

    public boolean getCurrentAudibleState() {
        return this.currentAudibleState;
    }

    public void setCurrentAudibleState(boolean bl) {
        this.currentAudibleState = bl;
    }

    public int getActiveSpeech() {
        return this.activeSpeech;
    }

    public void setActiveSpeech(int n) {
        this.activeSpeech = n;
    }

    public boolean isSoundManagementAvailable() {
        return this.isSoundManagementAvailable;
    }

    public void setSoundManagementAvailable(boolean bl) {
        this.isSoundManagementAvailable = bl;
    }

    public boolean isActiveEntertainment() {
        return this.isActiveEntertainment;
    }

    public void setActiveEntertainment(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - setActiveEntertainment = ").append(bl).toString());
        }
        this.isActiveEntertainment = bl;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }

    public void setNightMode(boolean bl) {
        this.isNightMode = bl;
    }

    public boolean isAudioBorrowState() {
        return this.isAudioBorrowState;
    }

    public void setAudioBorrowState(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - setAudioBorrowState = ").append(bl).toString());
        }
        this.isAudioBorrowState = bl;
    }

    public boolean isVideoBorrowState() {
        return this.isVideoBorrowState;
    }

    public void setVideoBorrowState(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - setVideoBorrowState = ").append(bl).toString());
        }
        this.isVideoBorrowState = bl;
    }

    public int getRingtoneConnection() {
        return this.ringtoneConnection;
    }

    public void setRingtoneConnection(int n) {
        this.ringtoneConnection = n;
    }

    public boolean isVolumeLock() {
        return this.isVolumeLock;
    }

    public void setVolumeLock(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - setVolumeLock = ").append(bl).toString());
        }
        this.isVolumeLock = bl;
    }

    public boolean isAutoplayFirstMediaRequest() {
        return this.isAutoplayFirstMediaRequest;
    }

    public void setAutoplayFirstMediaRequest(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - setAutoplayFirstMediaRequest = ").append(bl).toString());
        }
        this.isAutoplayFirstMediaRequest = bl;
    }

    public int getLastEntertainmentContextForAutoplay() {
        return this.lastEntertainmentContextForAutoplay;
    }

    public void setLastEntertainmentContextForAutoplay(int n) {
        this.lastEntertainmentContextForAutoplay = n;
    }

    public int getLastPTTKey() {
        return this.lastPTTKey;
    }

    public void setLastPTTKey(int n) {
        this.lastPTTKey = n;
    }

    public boolean isDelayBorrowAudio() {
        return this.delayBorrowAudio;
    }

    public void setDelayBorrowAudio(boolean bl) {
        if (this.target.isTraceEnabled() && bl != this.delayBorrowAudio) {
            this.target.trace(new StringBuffer().append("CARPLAY - setDelayBorrowAudio = ").append(bl).toString());
        }
        this.delayBorrowAudio = bl;
    }

    public boolean isPopupOpen() {
        return this.popupOpen;
    }

    public void setPopupOpen(boolean bl) {
        this.popupOpen = bl;
    }

    public boolean isCanvasDimed() {
        return this.canvasDimed;
    }

    public void setCanvasDimed(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - setCanvasDimed = ").append(bl).toString());
        }
        this.canvasDimed = bl;
    }

    public String getOemIconTitle() {
        return this.oemIconTitle;
    }

    public void setOemIconTitle(String string) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - setOemIconTitle = ").append(string).toString());
        }
        this.oemIconTitle = string;
    }

    public boolean isHmiRouteGuidanceActive() {
        return this.hmiRouteGuidanceActive;
    }

    public void setHmiRouteGuidanceActive(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - setHmiRouteGuidanceActive = ").append(bl).toString());
        }
        this.hmiRouteGuidanceActive = bl;
    }

    public boolean isSdsOpen() {
        return this.sdsOpen;
    }

    public void setSdsOpen(boolean bl) {
        this.sdsOpen = bl;
    }

    public boolean isDoEdgeDelayExecution() {
        return this.doEdgeDelayExecution;
    }

    public void setDoEdgeDelayExecution(boolean bl) {
        this.doEdgeDelayExecution = bl;
    }

    public int getOcuCallState() {
        return this.ocuCallState;
    }

    public void setOcuCallState(int n) {
        this.ocuCallState = n;
    }

    public Hashtable getCurrentCallStates() {
        return new Hashtable(this.currentCallStates);
    }

    public void setCurrentCallStates(Hashtable hashtable) {
        this.currentCallStates = hashtable;
    }

    public TelephonyState getCurrentTelephonyState() {
        return this.currentTelephonyState;
    }

    public void setCurrentTelephonyState(TelephonyState telephonyState) {
        this.currentTelephonyState = telephonyState;
        if (this.target != null) {
            this.target.getClusterService().sendTelephonyStateUpdate();
        }
    }

    public boolean isTelephonyStateValid() {
        return this.telephonyStateValid;
    }

    public void setTelephonyStateValid(boolean bl) {
        boolean bl2 = false;
        if (this.telephonyStateValid != bl) {
            bl2 = true;
        }
        this.telephonyStateValid = bl;
        if (bl2 && this.target != null) {
            this.target.getClusterService().sendTelephonyStateUpdate();
        }
    }

    public boolean isPhoneWaitsForResponseMainAudioType() {
        return this.phoneWaitsForResponseMainAudioType;
    }

    public void setPhoneWaitsForResponseMainAudioType(boolean bl) {
        this.phoneWaitsForResponseMainAudioType = bl;
    }
}

