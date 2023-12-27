/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.HsmSoundConnectionHandling;
import de.vw.mib.asl.internal.sound.SoundUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;

public class HsmSoundConnectionHandling$StateSoundConnectionHandlingConnectionHandling
extends AbstractHsmState {
    private short lastVolume;
    private boolean isEntVolZero;
    private boolean isAudioFeedbackActive;
    private IntObjectOptHashMap pendingImplicitFadedInConnections;
    private final /* synthetic */ HsmSoundConnectionHandling this$0;

    public HsmSoundConnectionHandling$StateSoundConnectionHandlingConnectionHandling(HsmSoundConnectionHandling hsmSoundConnectionHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundConnectionHandling;
        super(hsm, string, hsmState);
        this.lastVolume = (short)-1;
        this.isEntVolZero = false;
        this.isAudioFeedbackActive = false;
        this.pendingImplicitFadedInConnections = new IntObjectOptHashMap();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] entered HSM_ENTRY");
                this.this$0.target.dsiSound.setNotification(36, (DSIListener)this.this$0.target.dsiSoundListener);
                this.handleConnectionHandlingEntry();
                break;
            }
            case 3: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] entered HSM_START");
                break;
            }
            case 4: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] entered HSM_EXIT");
                break;
            }
            case 4300037: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] entered ASLSystem.ENABLE_SOUND_STATUS");
                HsmSoundConnectionHandling.systemSoundAudible = eventGeneric.getBoolean(0);
                this.this$0.applySystemSoundAudibleStatus();
                break;
            }
            case 1073743083: {
                int n = eventGeneric.getInt(0);
                this.isAudioFeedbackActive = n != 0;
                break;
            }
            case 1073743098: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] entered ASL_SOUND_PIN_MUTE");
                if (HsmSoundConnectionHandling.startedMuteSymbolConnections.containsKey(8)) {
                    this.handleDeMute();
                    break;
                }
                this.handleMute();
                break;
            }
            case 4000004: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] entered ASL_SOUND_RELEASE_CONNECTION");
                int n = eventGeneric.getInt(0);
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] ASL_SOUND_RELEASE_CONNECTION:").append(n).log();
                }
                if (!SoundUtil.isEntSource(n)) {
                    if (!HsmSoundConnectionHandling.lockedConnections.contains(n)) {
                        this.this$0.releaseConnection(n);
                        eventGeneric.setBlocked(true);
                        eventGeneric.setResult(12);
                        HsmSoundConnectionHandling.pendingReleaseConnectionMap.put(n, eventGeneric);
                        break;
                    }
                    if (this.this$0.isTraceEnabled()) {
                        this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] connection is locked, release request dropped.").log();
                    }
                    eventGeneric.setResult(11);
                    break;
                }
                this.this$0.warn("Release connection called for an entertainment connection. Sender: ", eventGeneric.getSenderTargetId());
                break;
            }
            case 4000002: {
                this.handleSetConnection(eventGeneric);
                break;
            }
            case 4000003: {
                int n = eventGeneric.getInt(0);
                this.pendingImplicitFadedInConnections.remove(n);
                if (HsmSoundConnectionHandling.pendingFadeToConnections.contains(n)) {
                    this.this$0.doFadeToConnection(n);
                    this.pendingImplicitFadedInConnections.put(n, eventGeneric);
                    eventGeneric.setBlocked(true);
                    break;
                }
                if (HsmSoundConnectionHandling.lastFadedInConnection == n) {
                    eventGeneric.setResult(0);
                    if (!ServiceManager.logger2.isTraceEnabled(4)) break;
                    ServiceManager.logger2.trace(4).append("ASL_SOUND_FADE_TO_CONNECTION: fadeTo ").append(n).append(" already fadedIn!").log();
                    break;
                }
                eventGeneric.setResult(11);
                if (!ServiceManager.logger2.isTraceEnabled(4)) break;
                ServiceManager.logger2.trace(4).append("ASL_SOUND_FADE_TO_CONNECTION: fadeTo ").append(n).append(" not requested for started connection!").append(HsmSoundConnectionHandling.pendingFadeToConnections).log();
                break;
            }
            case 4000011: {
                int n = eventGeneric.getInt(0);
                this.this$0.setVolumelock(n, true);
                HsmSoundConnectionHandling.volumeLockedConnectionsExplicitASL.add(n);
                break;
            }
            case 4000012: {
                int n = eventGeneric.getInt(0);
                if (n == 9) {
                    this.this$0.info("[HsmSoundConnectionHandling.ConnectionHandling] VolumeLock on EntertainmentSuppression must not be released! Request is denied!");
                    eventGeneric.setResult(11);
                    break;
                }
                HsmSoundConnectionHandling.releaseVolumelockRunningOnConnection = n;
                this.this$0.setVolumelock(n, false);
                HsmSoundConnectionHandling.volumeLockedConnectionsExplicitASL.remove(n);
                break;
            }
            case 0x400004FF: {
                if (!this.this$0.isTraceEnabled()) break;
                this.this$0.trace().append("[SoundSetterHandling] recieved ASL_SOUND_SET_VOLUME_LOCK.").log();
                break;
            }
            case 0x40000500: {
                if (!this.this$0.isTraceEnabled()) break;
                this.this$0.trace().append("[SoundSetterHandling] recieved ASL_SOUND_RESET_VOLUME_LOCK.").log();
                break;
            }
            case 4000013: {
                int n = eventGeneric.getInt(0);
                boolean bl = eventGeneric.getBoolean(1);
                if (bl) {
                    HsmSoundConnectionHandling.lockedConnections.add(n);
                    if (!this.this$0.isTraceEnabled()) break;
                    this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] locked connection: ").append(n).log();
                    break;
                }
                boolean bl2 = HsmSoundConnectionHandling.lockedConnections.contains(n);
                HsmSoundConnectionHandling.lockedConnections.remove(n);
                if (!this.this$0.isTraceEnabled() || !bl2) break;
                this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] unlock connection: ").append(n).log();
                break;
            }
            case 4300062: {
                this.initFromPersistence(false);
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (n != 2) break;
                this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] entered ASL_SOUND_AUDIOMNGMNT_STATUS: AVAILABLE_RESTORE_CONNECTIONS");
                this.restoreConnections();
                break;
            }
            case 100002: {
                int n = eventGeneric.getInt(0);
                this.this$0.handledAnsweredEntConn(n, true);
                EventGeneric eventGeneric2 = (EventGeneric)HsmSoundConnectionHandling.pendingConnectionMap.get(n);
                if (eventGeneric2 == null) break;
                ServiceManager.logger2.warn(4).append("Giving up waiting for response to requestConnection ").append(n).append(" , sending answer.").log();
                eventGeneric2.setResult(11);
                eventGeneric2.setBlocked(false);
                this.this$0.getEventDispatcher().sendBack(eventGeneric2);
                HsmSoundConnectionHandling.pendingConnectionMap.put(n, null);
                break;
            }
            case 4000034: 
            case 4000046: {
                this.handleMute();
                break;
            }
            case 4000035: 
            case 4000047: {
                this.handleDeMute();
                break;
            }
            case 4000037: {
                HsmSoundConnectionHandling.setWidebandEvent = eventGeneric;
                HsmSoundConnectionHandling.widebandOn = eventGeneric.getBoolean(0);
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] received SET_WIDEBANDSPEECH ").append(HsmSoundConnectionHandling.widebandOn).log();
                }
                if (!SoundUtil.isHigh()) {
                    this.this$0.trace("WidebandSpeech mode switch required on High systems only");
                    break;
                }
                if (!HsmSoundConnectionHandling.widebandTriggerOngoing) {
                    HsmSoundConnectionHandling.widebandTriggerOngoing = true;
                    this.handleSetWidebandspeech();
                    break;
                }
                this.this$0.info("Received setWidebandspeech during ongoing sequence");
                break;
            }
            case 4000042: {
                boolean bl = eventGeneric.getBoolean(0);
                this.handleSetMicMuteState(bl);
                break;
            }
            case 100003: {
                boolean bl = eventGeneric.getBoolean(0);
                this.handleSetValetparkingMuteState(bl);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAudioManagementStartConnection(int n, int n2) {
        this.this$0.handleStartConnection(n);
    }

    public void dsiAudioManagementPauseConnection(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("pauseConnection: ").append(n).log();
        }
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] DSIAUDIOMANAGEMENT_PAUSECONNECTION: ").append(n).log();
        }
        this.this$0.handlePauseConnection(n, this);
    }

    public void dsiAudioManagementStopConnection(int n, int n2) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] DSIAUDIOMANAGEMENT_STOPCONNECTION: ").append(n).log();
        }
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("stopConnection: ").append(n).log();
        }
        HsmSoundConnectionHandling.pendingFadeToConnections.remove(n);
        if (n == HsmSoundConnectionHandling.suspendedFadeToConnection) {
            HsmSoundConnectionHandling.suspendedFadeToConnection = -1;
        }
        this.this$0.checkRequestMuteStandbyProcessingDoneAndFadeToSuspended(n);
        this.this$0.setPendingResponseOnLoweringConnection(n, false);
        this.this$0.unlockImplicitVolumelock(n);
        if (n == 8) {
            this.this$0.sendUserMuteActive(false, this.this$0.userMuteActive);
            this.this$0.userMuteStarted = false;
        }
        this.this$0.handleStopMuteSymbolConnections(n);
        this.this$0.handleStopSoundControlledConnections(n);
        this.sendBackPendingReleaseConnectionEvent(n, 0);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(252263680);
        eventGeneric.setInt(0, n);
        this.this$0.send(eventGeneric);
        if (HsmSoundConnectionHandling.connectionsOnStackMap.containsKey(n)) {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("stopConnection: found entry for ").append(n).append(" in connectionsOnStackMap, not sending answer.").log();
            }
            HsmSoundConnectionHandling.connectionsOnStackMap.remove(n);
        } else {
            EventGeneric eventGeneric2 = (EventGeneric)HsmSoundConnectionHandling.pendingConnectionMap.get(n);
            if (eventGeneric2 != null && !SoundUtil.isMediaSource(n) && !SoundUtil.isRadioSource(n) && n != 9) {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] Connection ").append(n).append(" is stopped without ever been faded in (FCT-Con which is not fadedIn, or due to higher priority connection in foreground)").log();
                }
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("stopConnection: found entry for ").append(n).append(" in pendingConnectionMap, sending answer.").log();
                }
                eventGeneric2.setResult(11);
                eventGeneric2.setBlocked(false);
                this.this$0.getEventDispatcher().sendBack(eventGeneric2);
                HsmSoundConnectionHandling.pendingConnectionMap.put(n, null);
            }
        }
    }

    public void dsiAudioManagementErrorConnection(int n, int n2, int n3) {
        this.this$0.warn().append("AM: errorconnection (conn: ").append(n).append(", error: ").append(n3).append(", terminal: ").append(n2).append(")").log();
        this.this$0.handledAnsweredEntConn(n, false);
        this.this$0.setWidebandSpeech(n);
        this.this$0.checkRequestMuteStandbyProcessingDoneAndFadeToSuspended(n);
        this.this$0.setPendingResponseOnLoweringConnection(n, false);
        this.sendBackPendingFadeToEvent(n, 11);
        this.sendBackPendingReleaseConnectionEvent(n, 11);
        this.this$0.unlockImplicitVolumelock(n);
        HsmSoundConnectionHandling.volumeLockedConnectionsAll.remove(n);
    }

    public void dsiAudioManagementFadedIn(int n, int n2) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] DSIAUDIOMANAGEMENT_FADEDIN: ").append(n).log();
        }
        HsmSoundConnectionHandling.lastFadedInConnection = n;
        EventGeneric eventGeneric = (EventGeneric)HsmSoundConnectionHandling.pendingConnectionMap.get(n);
        if (eventGeneric != null) {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("fadedIn: sending back! ").append(eventGeneric).log();
            }
            eventGeneric.setResult(0);
            eventGeneric.setBlocked(false);
            this.this$0.getEventDispatcher().sendBack(eventGeneric);
            HsmSoundConnectionHandling.pendingConnectionMap.put(n, null);
        } else if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("fadedIn: not sending back! ").append(eventGeneric).log();
        }
        if (SoundUtil.isEntSource(n)) {
            this.this$0.sendMediaAudible(SoundUtil.isMediaSource(n) || n == 9);
            this.this$0.sendRadioAudible(SoundUtil.isRadioEntertainmentSource(n));
            this.this$0.sendMirrorLinkAudible(SoundUtil.isMirrorlinkEntertainmentSource(n));
            this.this$0.sendCarPlayAudible(SoundUtil.isCarPlayEntertainmentSource(n));
            this.this$0.sendAndroidAutoAudible(SoundUtil.isAndroidAutoEntertainmentSource(n));
            this.this$0.sendBaiduCarLifeAudible(SoundUtil.isBaiduEntertainmentSource(n));
        }
        this.this$0.handledAnsweredEntConn(n, false);
        if (!HsmSoundConnectionHandling.volumeLockedConnectionsExplicitASL.contains(n)) {
            this.this$0.setVolumelock(n, false);
        } else if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] connection is VolumeLocked, no implicit VolUnlock done.").log();
        }
        this.sendBackPendingFadeToEvent(n, 0);
    }

    public void dsiAudioManagementResponseVolumelock(int n, int n2, boolean bl) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] DSIAUDIOMANAGEMENT_RESPONSEVOLUMELOCK (conn: ").append(n).append(", locked: ").append(bl).append(", terminal: ").append(n2).append(")").log();
        }
        if (bl) {
            HsmSoundConnectionHandling.volumeLockedConnectionsAll.add(n);
            if ((this.this$0.userMuteActive || this.this$0.userMuteStarted) && SoundUtil.isEntSource(n) && !HsmSoundConnectionHandling.volumeLockedConnectionsExplicitASL.contains(n)) {
                this.this$0.trace("[HsmSoundConnectionHandling.ConnectionHandling] detected implicit entertainment volumelock below mute, unlocking");
                this.this$0.setVolumelock(n, false);
            }
        } else {
            if (HsmSoundConnectionHandling.releaseVolumelockRunningOnConnection == n) {
                HsmSoundConnectionHandling.releaseVolumelockRunningOnConnection = -1;
            }
            HsmSoundConnectionHandling.volumeLockedConnectionsAll.remove(n);
        }
    }

    public void dsiSoundResponseWidebandSpeech(int n, boolean bl) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] DSISound responseWidebandSpeech received, wideband on: ").append(bl).append(", widebandTriggerOngoing: ").append(HsmSoundConnectionHandling.widebandTriggerOngoing).append(", widebandOn:").append(HsmSoundConnectionHandling.widebandOn).append(", setWBEvent:").append(HsmSoundConnectionHandling.setWidebandEvent != null).log();
        }
        if (HsmSoundConnectionHandling.setWidebandEvent != null) {
            this.this$0.setWidebandSpeech(106);
        } else {
            HsmSoundConnectionHandling.widebandTriggerOngoing = false;
            this.this$0.releaseMuteHfpDownlink();
        }
    }

    public void dsiAudioManagementUpdateActiveConnection(int n, int n2, int n3) {
        HsmSoundConnectionHandling.standby = n == 3;
        int n4 = SoundUtil.getActiveAudioComponentASL(n);
        if (SoundUtil.getActiveAudioComponentASL(HsmSoundConnectionHandling.currentConnection) != n4) {
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] send ActiveAudioComponent: ").append(n4).log();
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(671694080);
            eventGeneric.setInt(0, n4);
            this.this$0.send(eventGeneric);
        }
        this.this$0.sendUserMuteActive(this.this$0.userMuteStarted, n == 8);
        this.this$0.userMuteActive = n == 8;
        HsmSoundConnectionHandling.currentConnection = n;
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] DSIAUDIOMANAGEMENT_UPDATEACTIVECONNECTION: ").append(HsmSoundConnectionHandling.currentConnection).append(", standby: ").append(HsmSoundConnectionHandling.standby).log();
        }
        ServiceManager.logger.normal(16).append(" Audio foreground: ").append(n).log();
    }

    public void dsiAudioManagementUpdateActiveEntertainmentConnection(int n, int n2, int n3) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] DSIAUDIOMANAGEMENT_UPDATEACTIVEENTERTAINMENTCONNECTION: ").append(n).log();
        }
        ServiceManager.logger.normal(16).append(" Audio entertainment: ").append(n).log();
        if (n != 0) {
            EventGeneric eventGeneric;
            if (SoundUtil.isRadioSource(HsmSoundConnectionHandling.currentEntConnection) && SoundUtil.isMediaSource(n) || SoundUtil.isRadioSource(HsmSoundConnectionHandling.previousEntConnection) && HsmSoundConnectionHandling.currentEntConnection == 9 && SoundUtil.isMediaSource(n)) {
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(151600384);
                this.this$0.send(eventGeneric);
            }
            if ((HsmSoundConnectionHandling.currentEntConnection = n) != (HsmSoundConnectionHandling.previousEntConnection = HsmSoundConnectionHandling.currentEntConnection)) {
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(822689024);
                eventGeneric.setInt(0, HsmSoundConnectionHandling.currentEntConnection);
                eventGeneric.setInt(1, HsmSoundConnectionHandling.previousEntConnection);
                this.this$0.sendSafe(eventGeneric);
            }
        }
    }

    public void dsiSoundUpdateMutePinState(boolean bl, int n) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling] received mutePinState: ").append(bl).log();
        }
        HsmSoundConnectionHandling.currentMutePinState = bl;
        this.requestReleaseMutPinConnections(bl);
    }

    public void dsiSoundUpdateMuteTheftProtection(boolean bl, int n) {
        if (this.this$0.target.isTraceEnabled()) {
            this.this$0.target.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] updateMuteTheftProtection: ").append(bl).log();
        }
        HsmSoundConnectionHandling.currentTheftProtectionActive = bl;
        if (bl) {
            this.this$0.requestConnection(6);
        } else {
            this.this$0.releaseConnection(6);
        }
    }

    public void dsiSoundUpdateVolume(int n, int n2, short s, int n3) {
        if (this.this$0.target.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling] update volume of connection: ").append(n).append(", volume: ").append(s).log();
        }
        if (this.lastVolume != s) {
            if (n == 8 && this.lastVolume == 0) {
                this.sendEntVolumeZero(false);
            }
            if (s == 0 && HsmSoundConnectionHandling.pendingResponseOnLoweringConnection != -1 && this.this$0.target.isTraceEnabled()) {
                this.this$0.trace().append("[HsmSoundConnectionHandling] detected MayLowering2Mute request pending on ").append(HsmSoundConnectionHandling.pendingResponseOnLoweringConnection).log();
            }
            if (n == HsmSoundConnectionHandling.currentEntConnection && n != 4 && n != 5 && n != 94 && HsmSoundConnectionHandling.currentConnection != 5 && HsmSoundConnectionHandling.currentConnection != 94 && HsmSoundConnectionHandling.currentConnection != 83 && HsmSoundConnectionHandling.currentConnection != 117 && HsmSoundConnectionHandling.currentConnection != 116 && HsmSoundConnectionHandling.currentConnection != 155 && HsmSoundConnectionHandling.currentConnection != 161 && HsmSoundConnectionHandling.currentConnection != 171 && HsmSoundConnectionHandling.currentConnection != 235 && HsmSoundConnectionHandling.currentConnection != 242 && HsmSoundConnectionHandling.pendingResponseOnLoweringConnection == -1) {
                if (s == 0) {
                    this.sendEntVolumeZero(true);
                    this.requestMute(false);
                } else if (this.lastVolume == 0) {
                    this.sendEntVolumeZero(false);
                }
            }
        }
        this.lastVolume = s;
    }

    private void requestMute(boolean bl) {
        if (this.this$0.redirectMuteToMedia && !bl) {
            this.this$0.triggerObserver(487144704, null);
        } else {
            this.this$0.requestConnection(8);
            this.this$0.info("not redirecting mute to media");
        }
    }

    private void releaseMute() {
        if (this.this$0.redirectMuteToMedia) {
            this.this$0.triggerObserver(503921920, null);
        } else {
            this.this$0.info("not redirecting demute to media");
            this.this$0.releaseConnection(8);
        }
    }

    private void handleConnectionHandlingEntry() {
        EventGeneric eventGeneric;
        if (HsmSoundConnectionHandling.initialStartup) {
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.this$0.getTargetId(), 5603, 5);
            this.this$0.send(eventGeneric);
            HsmSoundConnectionHandling.initialStartup = false;
        } else {
            this.this$0.applySystemSoundAudibleStatus();
        }
        if (HsmSoundConnectionHandling.currentTheftProtectionActive && !HsmSoundConnectionHandling.startedMuteSymbolConnections.containsKey(6)) {
            this.this$0.requestConnection(6);
        }
        this.initFromPersistence(true);
        if (HsmSoundConnectionHandling.currentMutePinState && !HsmSoundConnectionHandling.startedSoundControlledConnections.contains(210)) {
            this.requestReleaseMutPinConnections(HsmSoundConnectionHandling.currentMutePinState);
        }
        if (HsmSoundConnectionHandling.currentValetparkingMuteActive && !HsmSoundConnectionHandling.startedSoundControlledConnections.contains(205) || !HsmSoundConnectionHandling.currentValetparkingMuteActive && HsmSoundConnectionHandling.startedSoundControlledConnections.contains(205)) {
            this.handleSetValetparkingMuteState(HsmSoundConnectionHandling.currentValetparkingMuteActive);
        }
        if (HsmSoundConnectionHandling.pendingSetEntertainmentConnectionEvent != null) {
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] send pending event: ").append(HsmSoundConnectionHandling.pendingSetEntertainmentConnectionEvent).log();
            }
            this.this$0.getEventDispatcher().send(HsmSoundConnectionHandling.pendingSetEntertainmentConnectionEvent);
            HsmSoundConnectionHandling.pendingSetEntertainmentConnectionEvent = null;
        }
        eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
        eventGeneric.setInt(0, 9);
        this.this$0.sendSafe(eventGeneric);
    }

    private void handleSetConnection(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] entered ASL_SOUND_SET_CONNECTION: ").append(n).log();
        }
        eventGeneric.setBlocked(true);
        eventGeneric.setResult(12);
        boolean bl = SoundUtil.isEntSource(n);
        if (bl && HsmSoundConnectionHandling.pendingEntConnection != -1) {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("Received ASL_SOUND_SET_CONNECTION event: Holding back ").append(n).append(" because another entertainment request is still pending: ").append(HsmSoundConnectionHandling.pendingEntConnection).log();
            }
            HsmSoundConnectionHandling.pendingEntConnectionEvent = eventGeneric;
        } else {
            HsmSoundConnectionHandling.pendingConnectionMap.put(n, eventGeneric);
            this.this$0.setPendingResponseOnLoweringConnection(n, true);
            this.this$0.requestConnection(n);
        }
        if (bl) {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("Received ASL_SOUND_SET_CONNECTION event: setting pending entertainment connection ").append(n).log();
            }
            HsmSoundConnectionHandling.pendingEntConnection = n;
        }
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            boolean bl2 = this.this$0.getBooleanSafe(eventGeneric, 1);
            boolean bl3 = this.this$0.getBooleanSafe(eventGeneric, 2);
            ServiceManager.logger2.trace(4).append("Received ASL_SOUND_SET_CONNECTION event: ").append(n).append(", prevent: ").append(bl2).append(", response on pause: ").append(bl3).log();
        }
    }

    private void initFromPersistence(boolean bl) {
        if (ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData().getUserMuteStarted() == 1) {
            this.this$0.trace("[HsmSoundConnectionHandling.ConnectionHandling] Restore MUTE_USER from persistence");
            this.requestMute(bl);
        } else {
            this.this$0.trace("[HsmSoundConnectionHandling.ConnectionHandling] No MUTE_USER in persistence");
        }
    }

    private void restoreConnections() {
        if (HsmSoundConnectionHandling.startedMuteSymbolConnections.containsKey(6)) {
            this.this$0.requestConnection(6);
        }
        if (HsmSoundConnectionHandling.startedMuteSymbolConnections.containsKey(8)) {
            this.this$0.requestConnection(8);
        }
        Object object = HsmSoundConnectionHandling.startedSoundControlledConnections.iterator();
        while (object.hasNext()) {
            int n = object.next();
            this.this$0.requestConnection(n);
        }
        object = ServiceManager.mGenericEventFactory.newEvent(185154816);
        ((EventGeneric)object).setInt(0, 9);
        this.this$0.sendSafe((EventGeneric)object);
    }

    private void requestReleaseMutPinConnections(boolean bl) {
        if (bl) {
            this.this$0.requestConnection(210);
        } else {
            this.this$0.releaseConnection(210);
        }
    }

    private void sendEntVolumeZero(boolean bl) {
        if (this.isEntVolZero != bl) {
            if (this.this$0.target.isTraceEnabled()) {
                this.this$0.target.trace().append("[HsmSoundConnectionHandling] Send ASL_SOUND_ENTERTAINMENT_VOLUME_IS_ZERO: ").append(bl).log();
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(235486464);
            eventGeneric.setBoolean(0, bl);
            this.this$0.send(eventGeneric);
            this.isEntVolZero = bl;
        }
    }

    private void handleMute() {
        if (this.isAudioFeedbackActive) {
            this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] sound setup volume slider open: drop (de)mute");
            return;
        }
        this.requestMute(false);
    }

    private void handleDeMute() {
        if (this.isAudioFeedbackActive) {
            this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] sound setup volume slider open: drop (de)mute");
            return;
        }
        if (!HsmSoundConnectionHandling.volumeLockedConnectionsAll.contains(HsmSoundConnectionHandling.currentEntConnection) || HsmSoundConnectionHandling.releaseVolumelockRunningOnConnection == HsmSoundConnectionHandling.currentEntConnection) {
            this.releaseMute();
        } else {
            this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] entertainment is volumelocked: drop demute");
        }
    }

    private void handleSetWidebandspeech() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, 106);
        this.this$0.triggerObserver(34159872, eventGeneric);
    }

    private void handleSetMicMuteState(boolean bl) {
        if (ServiceManager.configManagerDiag.getAM_SSEonMMX()) {
            this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] redirect MicMute to SSE");
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(688471296);
            eventGeneric.setBoolean(0, bl);
            this.this$0.sendSafe(eventGeneric);
        } else if (bl) {
            this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] request MicMute connection");
            this.this$0.requestConnection(102);
        } else {
            this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] release MicMute connection");
            this.this$0.releaseConnection(102);
        }
    }

    private void handleSetValetparkingMuteState(boolean bl) {
        HsmSoundConnectionHandling.currentValetparkingMuteActive = bl;
        if (bl) {
            this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] request valetparking mute connection");
            this.this$0.requestConnection(205);
        } else {
            this.this$0.target.trace("[HsmSoundConnectionHandling.ConnectionHandling] release valetparking mute connection");
            this.this$0.releaseConnection(205);
        }
    }

    private void sendBackPendingFadeToEvent(int n, int n2) {
        EventGeneric eventGeneric = (EventGeneric)this.pendingImplicitFadedInConnections.get(n);
        if (eventGeneric != null && n == eventGeneric.getInt(0)) {
            eventGeneric.setResult(n2);
            eventGeneric.setBlocked(false);
            this.this$0.sendBackSafe(eventGeneric);
            this.pendingImplicitFadedInConnections.remove(n);
        }
    }

    private void sendBackPendingReleaseConnectionEvent(int n, int n2) {
        EventGeneric eventGeneric;
        if (HsmSoundConnectionHandling.pendingReleaseConnectionMap.containsKey(n) && (eventGeneric = (EventGeneric)HsmSoundConnectionHandling.pendingReleaseConnectionMap.get(n)) != null) {
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace().append("[HsmSoundConnectionHandling] sendBackPendingReleaseConnection event for connection ").append(n).log();
            }
            eventGeneric.setResult(n2);
            eventGeneric.setBlocked(false);
            this.this$0.sendBackSafe(eventGeneric);
            HsmSoundConnectionHandling.pendingReleaseConnectionMap.remove(n);
            if (this.this$0.isTraceEnabled() && !HsmSoundConnectionHandling.pendingReleaseConnectionMap.isEmpty()) {
                this.this$0.trace().append("[HsmSoundConnectionHandling] pendingReleaseConnectionMap: ").append(HsmSoundConnectionHandling.pendingReleaseConnectionMap).log();
            }
        }
    }
}

