/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

final class AndroidAutoGlobalProperties {
    private int entertainmentState = 0;
    private int audioState_CL_ANN_AMP_GAL_ANNOUNCEMENT = 0;
    private int audioState_CL_ANN_AMP_GAL_LOWERING = 0;
    private int audioState_CL_ANN_AMP_GAL_SPEECH = 0;
    private int audioState_CL_SYS_AMP_GAL_SPEECH_INPUT = 0;
    private int videoFocusState = 2;
    private int lastAudioFocusState = 3;
    private int currentAudioFocusState = 3;
    private int currentAudioFocusRequest = 0;
    private int audioConnectionToObserve = 0;
    private int hkPTTState = 0;
    private boolean isVideoStreamAvailable = false;
    private boolean isAudioManagementAvailable = true;
    private boolean isNightModeActive = false;
    private boolean isAudible = true;
    private boolean isGALSpeechActive = false;
    private boolean isPTTPressedToStartGALSpeech = false;
    private boolean isUserMuteActive = false;
    private boolean isUserMuteStarted = false;
    private boolean isAndroidAutoNavigationActive = false;

    public int getAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT() {
        return this.audioState_CL_ANN_AMP_GAL_ANNOUNCEMENT;
    }

    public void setAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT(int n) {
        this.audioState_CL_ANN_AMP_GAL_ANNOUNCEMENT = n;
    }

    public int getAudioState_CL_ANN_AMP_GAL_LOWERING() {
        return this.audioState_CL_ANN_AMP_GAL_LOWERING;
    }

    public void setAudioState_CL_ANN_AMP_GAL_LOWERING(int n) {
        this.audioState_CL_ANN_AMP_GAL_LOWERING = n;
    }

    public int getAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT() {
        return this.audioState_CL_SYS_AMP_GAL_SPEECH_INPUT;
    }

    public void setAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT(int n) {
        this.audioState_CL_SYS_AMP_GAL_SPEECH_INPUT = n;
    }

    public int getVideoFocusState() {
        return this.videoFocusState;
    }

    public void setVideoFocusState(int n) {
        this.videoFocusState = n;
    }

    public int getLastAudioFocusState() {
        return this.lastAudioFocusState;
    }

    public void setLastAudioFocusState(int n) {
        this.lastAudioFocusState = n;
    }

    public int getCurrentAudioFocusState() {
        return this.currentAudioFocusState;
    }

    public void setCurrentAudioFocusState(int n) {
        this.currentAudioFocusState = n;
    }

    public int getCurrentAudioFocusRequest() {
        return this.currentAudioFocusRequest;
    }

    public void setCurrentAudioFocusRequest(int n) {
        this.currentAudioFocusRequest = n;
    }

    public int getAudioConnectionToObserve() {
        return this.audioConnectionToObserve;
    }

    public void setAudioConnectionToObserve(int n) {
        this.audioConnectionToObserve = n;
    }

    public int getEntertainmentState() {
        return this.entertainmentState;
    }

    public void setEntertainmentState(int n) {
        this.entertainmentState = n;
    }

    public boolean isVideoStreamAvailable() {
        return this.isVideoStreamAvailable;
    }

    public void setVideoStreamAvailable(boolean bl) {
        this.isVideoStreamAvailable = bl;
    }

    public boolean isNightModeActive() {
        return this.isNightModeActive;
    }

    public void setNightModeActive(boolean bl) {
        this.isNightModeActive = bl;
    }

    public boolean isAudible() {
        return this.isAudible;
    }

    public void setAudible(boolean bl) {
        this.isAudible = bl;
    }

    public boolean isAudioManagementAvailable() {
        return this.isAudioManagementAvailable;
    }

    public void setAudioManagementAvailable(boolean bl) {
        this.isAudioManagementAvailable = bl;
    }

    public int getAudioState_CL_ANN_AMP_GAL_SPEECH() {
        return this.audioState_CL_ANN_AMP_GAL_SPEECH;
    }

    public void setAudioState_CL_ANN_AMP_GAL_SPEECH(int n) {
        this.audioState_CL_ANN_AMP_GAL_SPEECH = n;
    }

    public boolean isGALSpeechActive() {
        return this.isGALSpeechActive;
    }

    public void setGALSpeechActive(boolean bl) {
        this.isGALSpeechActive = bl;
    }

    public boolean isPTTPressedToStartGALSpeech() {
        return this.isPTTPressedToStartGALSpeech;
    }

    public void setPTTPressedToStartGALSpeech(boolean bl) {
        this.isPTTPressedToStartGALSpeech = bl;
    }

    public int getHkPTTState() {
        return this.hkPTTState;
    }

    public void setHkPTTState(int n) {
        this.hkPTTState = n;
    }

    public boolean isUserMuteActive() {
        return this.isUserMuteActive;
    }

    public void setUserMuteActive(boolean bl) {
        this.isUserMuteActive = bl;
    }

    public boolean isUserMuteStarted() {
        return this.isUserMuteStarted;
    }

    public void setUserMuteStarted(boolean bl) {
        this.isUserMuteStarted = bl;
    }

    public boolean isAndroidAutoNavigationActive() {
        return this.isAndroidAutoNavigationActive;
    }

    public void setAndroidAutoNavigationActive(boolean bl) {
        this.isAndroidAutoNavigationActive = bl;
    }
}

