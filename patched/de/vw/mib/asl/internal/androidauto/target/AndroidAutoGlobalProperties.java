/*
 * Decompiled with CFR 0.151-SNAPSHOT (5569f06-dirty).
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
        System.out.println("AAProp getAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT: " + this.audioState_CL_ANN_AMP_GAL_ANNOUNCEMENT);
        return this.audioState_CL_ANN_AMP_GAL_ANNOUNCEMENT;
    }

    public void setAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT(int n) {
        System.out.println("AAProp setAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT: " + n);
        this.audioState_CL_ANN_AMP_GAL_ANNOUNCEMENT = n;
    }

    public int getAudioState_CL_ANN_AMP_GAL_LOWERING() {
        System.out.println("AAProp getAudioState_CL_ANN_AMP_GAL_LOWERING: " + this.audioState_CL_ANN_AMP_GAL_LOWERING);
        return this.audioState_CL_ANN_AMP_GAL_LOWERING;
    }

    public void setAudioState_CL_ANN_AMP_GAL_LOWERING(int n) {
        System.out.println("AAProp setAudioState_CL_ANN_AMP_GAL_LOWERING: " + n);
        this.audioState_CL_ANN_AMP_GAL_LOWERING = n;
    }

    public int getAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT() {
        System.out.println("AAProp getAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT: " + this.audioState_CL_SYS_AMP_GAL_SPEECH_INPUT);
        return this.audioState_CL_SYS_AMP_GAL_SPEECH_INPUT;
    }

    public void setAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT(int n) {
        System.out.println("AAProp setAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT: " + n);
        this.audioState_CL_SYS_AMP_GAL_SPEECH_INPUT = n;
    }

    public int getVideoFocusState() {
        System.out.println("AAProp getVideoFocusState: " + this.videoFocusState);
        return this.videoFocusState;
    }

    public void setVideoFocusState(int n) {
        System.out.println("AAProp setVideoFocusState: " + n);
        this.videoFocusState = n;
    }

    public int getLastAudioFocusState() {
        System.out.println("AAProp getLastAudioFocusState: " + this.lastAudioFocusState);
        return this.lastAudioFocusState;
    }

    public void setLastAudioFocusState(int n) {
        System.out.println("AAProp setLastAudioFocusState: " + n);
        this.lastAudioFocusState = n;
    }

    public int getCurrentAudioFocusState() {
        System.out.println("AAProp getCurrentAudioFocusState: " + this.currentAudioFocusState);
        return this.currentAudioFocusState;
    }

    public void setCurrentAudioFocusState(int n) {
        System.out.println("AAProp setCurrentAudioFocusState: " + n);
        this.currentAudioFocusState = n;
    }

    public int getCurrentAudioFocusRequest() {
        System.out.println("AAProp getCurrentAudioFocusRequest: " + this.currentAudioFocusRequest);
        return this.currentAudioFocusRequest;
    }

    public void setCurrentAudioFocusRequest(int n) {
        System.out.println("AAProp setCurrentAudioFocusRequest: " + n);
        this.currentAudioFocusRequest = n;
    }

    public int getAudioConnectionToObserve() {
        System.out.println("AAProp getAudioConnectionToObserve: " + this.audioConnectionToObserve);
        return this.audioConnectionToObserve;
    }

    public void setAudioConnectionToObserve(int n) {
        System.out.println("AAProp setAudioConnectionToObserve: " + n);
        this.audioConnectionToObserve = n;
    }

    public int getEntertainmentState() {
        System.out.println("AAProp getEntertainmentState: " + this.entertainmentState);
        return this.entertainmentState;
    }

    public void setEntertainmentState(int n) {
        System.out.println("AAProp setEntertainmentState: " + n);
        this.entertainmentState = n;
    }

    public boolean isVideoStreamAvailable() {
        System.out.println("AAProp isVideoStreamAvailable: " + this.isVideoStreamAvailable);
        return this.isVideoStreamAvailable;
    }

    public void setVideoStreamAvailable(boolean bl) {
        System.out.println("AAProp setVideoStreamAvailable: " + bl);
        this.isVideoStreamAvailable = bl;
    }

    public boolean isNightModeActive() {
        System.out.println("AAProp isNightModeActive: " + this.isNightModeActive);
        return this.isNightModeActive;
    }

    public void setNightModeActive(boolean bl) {
        System.out.println("AAProp setNightModeActive: " + bl);
        this.isNightModeActive = bl;
    }

    public boolean isAudible() {
        System.out.println("AAProp isAudible: " + this.isAudible);
        return this.isAudible;
    }

    public void setAudible(boolean bl) {
        System.out.println("AAProp setAudible: " + bl);
        this.isAudible = bl;
    }

    public boolean isAudioManagementAvailable() {
        System.out.println("AAProp isAudioManagementAvailable: " + this.isAudioManagementAvailable);
        return this.isAudioManagementAvailable;
    }

    public void setAudioManagementAvailable(boolean bl) {
        System.out.println("AAProp setAudioManagementAvailable: " + bl);
        this.isAudioManagementAvailable = bl;
    }

    public int getAudioState_CL_ANN_AMP_GAL_SPEECH() {
        System.out.println("AAProp getAudioState_CL_ANN_AMP_GAL_SPEECH: " + this.audioState_CL_ANN_AMP_GAL_SPEECH);
        return this.audioState_CL_ANN_AMP_GAL_SPEECH;
    }

    public void setAudioState_CL_ANN_AMP_GAL_SPEECH(int n) {
        System.out.println("AAProp setAudioState_CL_ANN_AMP_GAL_SPEECH: " + n);
        this.audioState_CL_ANN_AMP_GAL_SPEECH = n;
    }

    public boolean isGALSpeechActive() {
        System.out.println("AAProp isGALSpeechActive: " + this.isGALSpeechActive);
        return this.isGALSpeechActive;
    }

    public void setGALSpeechActive(boolean bl) {
        System.out.println("AAProp setGALSpeechActive: " + bl);
        this.isGALSpeechActive = bl;
    }

    public boolean isPTTPressedToStartGALSpeech() {
        System.out.println("AAProp isPTTPressedToStartGALSpeech: " + this.isPTTPressedToStartGALSpeech);
        return this.isPTTPressedToStartGALSpeech;
    }

    public void setPTTPressedToStartGALSpeech(boolean bl) {
        System.out.println("AAProp setPTTPressedToStartGALSpeech: " + bl);
        this.isPTTPressedToStartGALSpeech = bl;
    }

    public int getHkPTTState() {
        System.out.println("AAProp getHkPTTState: " + this.hkPTTState);
        return this.hkPTTState;
    }

    public void setHkPTTState(int n) {
        System.out.println("AAProp setHkPTTState: " + n);
        this.hkPTTState = n;
    }

    public boolean isUserMuteActive() {
        System.out.println("AAProp isUserMuteActive: " + this.isUserMuteActive);
        return this.isUserMuteActive;
    }

    public void setUserMuteActive(boolean bl) {
        System.out.println("AAProp setUserMuteActive: " + bl);
        this.isUserMuteActive = bl;
    }

    public boolean isUserMuteStarted() {
        System.out.println("AAProp isUserMuteStarted: " + this.isUserMuteStarted);
        return this.isUserMuteStarted;
    }

    public void setUserMuteStarted(boolean bl) {
        System.out.println("AAProp setUserMuteStarted: " + bl);
        this.isUserMuteStarted = bl;
    }

    public boolean isAndroidAutoNavigationActive() {
        System.out.println("AAProp isAndroidAutoNavigationActive: " + this.isAndroidAutoNavigationActive + " (ignored)");
        return false; // this.isAndroidAutoNavigationActive;
    }

    public void setAndroidAutoNavigationActive(boolean bl) {
        System.out.println("AAProp setAndroidAutoNavigationActive: " + bl + "(ignored)");
        new Exception("Stack trace").printStackTrace();
        this.isAndroidAutoNavigationActive = false; // bl;
    }
}

