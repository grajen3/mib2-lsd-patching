/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.ASLSoundData;
import de.vw.mib.asl.internal.sound.AbstractASLHsmSoundTarget;
import de.vw.mib.asl.internal.sound.HsmSoundConnectionHandling$StateSoundConnectionHandlingConnectionHandling;
import de.vw.mib.asl.internal.sound.HsmSoundConnectionHandling$StateSoundConnectionHandlingInit;
import de.vw.mib.asl.internal.sound.SoundUtil;
import de.vw.mib.asl.internal.sound.has.SoundHASUpdater;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.TimerServer;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSIAudioManagementListener;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;

public final class HsmSoundConnectionHandling
extends AbstractASLHsmSoundTarget {
    static IntObjectOptHashMap pendingConnectionMap = new IntObjectOptHashMap(10);
    static IntObjectOptHashMap connectionsOnStackMap = new IntObjectOptHashMap(10);
    static IntObjectOptHashMap pendingReleaseConnectionMap = new IntObjectOptHashMap(10);
    static IntSet lockedConnections = new IntOptHashSet(3);
    static IntSet volumeLockedConnectionsExplicitASL = new IntOptHashSet(3);
    static IntSet volumeLockedConnectionsAll = new IntOptHashSet(3);
    static IntObjectOptHashMap startedMuteSymbolConnections = new IntObjectOptHashMap(3);
    static IntOptHashSet startedSoundControlledConnections = new IntOptHashSet(3);
    static EventGeneric pendingSetEntertainmentConnectionEvent = null;
    private static final int CONNECTION_UNDEFINED;
    static int currentConnection;
    static int currentEntConnection;
    static int previousEntConnection;
    static IntSet pendingFadeToConnections;
    static int lastFadedInConnection;
    static int releaseVolumelockRunningOnConnection;
    static int pendingResponseOnLoweringConnection;
    static boolean standby;
    static int muteActive;
    static boolean initialStartup;
    static boolean systemSoundAudible;
    static boolean currentMutePinState;
    static boolean currentTheftProtectionActive;
    static boolean widebandTriggerOngoing;
    static boolean widebandOn;
    static EventGeneric setWidebandEvent;
    static boolean currentValetparkingMuteActive;
    protected final int EV_SOUND_SEND_DELAYED_RESTORE_IF_APPLICABLE;
    protected static final int EV_SOUND_MISSING_ANSWER_REQUEST_ENT_CONN;
    protected final int EV_SOUND_MISSING_ANSWER_REQUEST_ENT_CONN_P0_CONNECTION_INT;
    protected final int SOUND_MISSING_ANSWER_REQUEST_ENT_CONN_TIMER;
    protected final int EV_SOUND_SET_MUTE_VALETPARKING;
    protected final int EV_SOUND_SET_MUTE_VALETPARKING_P0_BOOLEAN;
    static EventGeneric pendingEntConnectionEvent;
    static int pendingEntConnection;
    static int lastRequestedEntCon;
    ValetParkingListener valetParkingListener;
    protected DSIAudioManagement dsiAudioManagement;
    protected DSISound dsiSound;
    protected DSIAudioManagementListener dsiAudioManagementListener;
    protected DSISoundListener dsiSoundListener;
    protected DSIPowerManagement dsiPowerManagement;
    protected DSIPowerManagementListener dsiPowerManagementListener;
    protected final HsmState stateInit;
    protected final HsmState stateConnectionHandling;
    HsmSoundConnectionHandling target;
    private boolean androidAutoAudible;
    private boolean carPlayAudible;
    private boolean mirrorLinkAudible;
    private boolean baiduCarLifeAudible;
    private boolean mediaAudible;
    private boolean radioAudible;
    boolean redirectMuteToMedia;
    boolean userMuteStarted;
    boolean userMuteActive;
    static boolean isPowerstateOnTelOrStandby;
    static boolean requestMuteStandbyProcessing;
    static int suspendedFadeToConnection;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagement;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$PromptEngine;

    protected void initDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAudioManagement = (DSIAudioManagement)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSIAudioManagement == null ? (class$org$dsi$ifc$audio$DSIAudioManagement = HsmSoundConnectionHandling.class$("org.dsi.ifc.audio.DSIAudioManagement")) : class$org$dsi$ifc$audio$DSIAudioManagement);
        this.dsiSound = (DSISound)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = HsmSoundConnectionHandling.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound);
        this.dsiPowerManagement = (DSIPowerManagement)dSIProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = HsmSoundConnectionHandling.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        this.dsiAudioManagementListener = (DSIAudioManagementListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = HsmSoundConnectionHandling.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener);
        this.dsiSoundListener = (DSISoundListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = HsmSoundConnectionHandling.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener);
        this.dsiPowerManagementListener = (DSIPowerManagementListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = HsmSoundConnectionHandling.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = HsmSoundConnectionHandling.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener, this.dsiAudioManagementListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = HsmSoundConnectionHandling.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener, this.dsiSoundListener);
    }

    void clearPendingMapsAndConnections() {
        pendingConnectionMap.clear();
        connectionsOnStackMap.clear();
        pendingReleaseConnectionMap.clear();
        lockedConnections.clear();
        volumeLockedConnectionsAll.clear();
        volumeLockedConnectionsExplicitASL.clear();
        startedMuteSymbolConnections.clear();
        HsmSoundConnectionHandling.writeIntegerToDatapool(1509, 0);
        this.broadcastMuteSymbolActive(false);
        HsmSoundConnectionHandling.writeBooleanToDatapool(3538, false);
        pendingFadeToConnections.clear();
        pendingEntConnectionEvent = null;
        suspendedFadeToConnection = -1;
        currentConnection = -1;
        pendingEntConnection = -1;
        previousEntConnection = -1;
        lastRequestedEntCon = -1;
        this.baiduCarLifeAudible = false;
        this.radioAudible = false;
        this.mediaAudible = false;
        this.mirrorLinkAudible = false;
        this.carPlayAudible = false;
        this.androidAutoAudible = false;
        this.sendEntContextNotAudible();
        this.stopTimer(-1568276224);
    }

    void handleStopMuteSymbolConnections(int n) {
        if (startedMuteSymbolConnections.containsKey(n)) {
            startedMuteSymbolConnections.remove(n);
            if (startedMuteSymbolConnections.isEmpty()) {
                HsmSoundConnectionHandling.writeIntegerToDatapool(1509, 0);
                this.broadcastMuteSymbolActive(false);
            }
        }
        if (n == 8 && systemSoundAudible) {
            this.trace("[HsmSoundConnectionHandling.ConnectionHandling] remove MUTE_USER from persistence");
            ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData().setUserMuteStarted(0);
            ASLSoundData.persistence.setUserMuteActive(false);
        }
    }

    void handleStartMuteSymbolConnections(int n) {
        switch (n) {
            case 6: 
            case 8: 
            case 205: {
                startedMuteSymbolConnections.put(n, null);
                HsmSoundConnectionHandling.writeIntegerToDatapool(1509, 1);
                this.broadcastMuteSymbolActive(true);
                break;
            }
        }
        if (n == 8) {
            this.trace("[HsmSoundConnectionHandling.ConnectionHandling] store MUTE_USER in persistence");
            ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData().setUserMuteStarted(1);
            ASLSoundData.persistence.setUserMuteActive(true);
        }
    }

    void broadcastMuteSymbolActive(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(336149760, eventGeneric);
        SoundHASUpdater.setVolumeContainerEntertainmentMuted(bl);
    }

    void handleStartSoundControlledConnections(int n) {
        switch (n) {
            case 210: {
                startedSoundControlledConnections.add(n);
                HsmSoundConnectionHandling.writeBooleanToDatapool(3538, true);
                break;
            }
            case 205: 
            case 260: 
            case 261: {
                startedSoundControlledConnections.add(n);
                break;
            }
        }
        this.setWidebandSpeech(n);
    }

    void setWidebandSpeech(int n) {
        if (n == 106 && setWidebandEvent != null) {
            this.dsiSound.setWidebandSpeech(1, widebandOn);
            setWidebandEvent = null;
        }
    }

    void handleStopSoundControlledConnections(int n) {
        switch (n) {
            case 210: {
                HsmSoundConnectionHandling.writeBooleanToDatapool(3538, false);
                break;
            }
        }
        if (startedSoundControlledConnections.contains(n)) {
            startedSoundControlledConnections.remove(n);
        }
    }

    void handledAnsweredEntConn(int n, boolean bl) {
        if (SoundUtil.isEntSource(n)) {
            if (lastRequestedEntCon == n && !bl) {
                this.stopTimer(-1568276224);
            }
            if (pendingEntConnection == n) {
                if (bl) {
                    ServiceManager.logger2.error(4).append("Entertainment request has NOT been answered for too long! Reset pending connection ").append(n).log();
                } else if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("Entertainment request has been answered. Reset pending connection!").log();
                }
                pendingEntConnectionEvent = null;
                pendingEntConnection = -1;
            } else if (pendingEntConnectionEvent != null) {
                pendingConnectionMap.put(pendingEntConnection, pendingEntConnectionEvent);
                this.requestConnection(pendingEntConnection);
                pendingEntConnectionEvent = null;
                if (bl) {
                    ServiceManager.logger2.error(4).append("Entertainment request has NOT been answered for too long! Request pending: ").append(pendingEntConnection).log();
                } else if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("Entertainment request has been answered. Request pending: ").append(pendingEntConnection).log();
                }
            }
        }
    }

    void handleStartConnection(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] DSIAUDIOMANAGEMENT_STARTCONNECTION: ").append(n).log();
        }
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("startConnection: ").append(n).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this.target.triggerObserver(403258624, eventGeneric);
        this.handleStartMuteSymbolConnections(n);
        this.handleStartSoundControlledConnections(n);
        if (n == 8) {
            this.sendUserMuteActive(true, this.userMuteActive);
            this.userMuteStarted = true;
        }
        if (SoundUtil.isEntSource(n)) {
            this.sendMediaAudible(SoundUtil.isMediaSource(n) || n == 9);
            this.sendRadioAudible(SoundUtil.isRadioEntertainmentSource(n));
            this.sendMirrorLinkAudible(SoundUtil.isMirrorlinkEntertainmentSource(n));
            this.sendCarPlayAudible(SoundUtil.isCarPlayEntertainmentSource(n));
            this.sendAndroidAutoAudible(SoundUtil.isAndroidAutoEntertainmentSource(n));
            this.sendBaiduCarLifeAudible(SoundUtil.isBaiduEntertainmentSource(n));
        }
        this.checkRequestMuteStandbyProcessingDoneAndFadeToSuspended(n);
        this.checkVolumeLockedEntertainmentUnderNonVolumeFocusConnection(n);
        this.setPendingResponseOnLoweringConnection(n, false);
        if (!SoundUtil.isConnectionNeedFadeTo(n)) {
            this.checkForSentBackAndExecuteIfIndicated(n);
        } else {
            pendingFadeToConnections.add(n);
            if (!volumeLockedConnectionsExplicitASL.contains(n)) {
                this.setVolumelock(n, true);
            }
            if (!this.preventFadeTo(n)) {
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("startConnection: not sending back now because not pending! ").append(n).log();
                }
                if (n != 9) {
                    this.doFadeToConnection(n);
                }
                this.checkUnrequestedAnnouncementAndSendIfIndicated(n);
            } else {
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("startConnection: preventing fadeTo! ").log();
                }
                this.checkForSentBackAndExecuteIfIndicated(n);
            }
        }
        this.handledAnsweredEntConn(n, false);
    }

    void sendMediaAudible(boolean bl) {
        if (this.mediaAudible != bl) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(269040896);
            eventGeneric.setBoolean(0, bl);
            this.send(eventGeneric);
            this.mediaAudible = bl;
        }
    }

    void sendMirrorLinkAudible(boolean bl) {
        if (this.mirrorLinkAudible != bl) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(722025728);
            eventGeneric.setBoolean(0, bl);
            this.send(eventGeneric);
            this.mirrorLinkAudible = bl;
        }
    }

    void sendCarPlayAudible(boolean bl) {
        if (this.carPlayAudible != bl) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(738802944);
            eventGeneric.setBoolean(0, bl);
            this.send(eventGeneric);
            this.carPlayAudible = bl;
        }
    }

    void sendAndroidAutoAudible(boolean bl) {
        if (this.androidAutoAudible != bl) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(755580160);
            eventGeneric.setBoolean(0, bl);
            this.send(eventGeneric);
            this.androidAutoAudible = bl;
        }
    }

    void sendRadioAudible(boolean bl) {
        if (this.radioAudible != bl) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(654916864);
            eventGeneric.setBoolean(0, bl);
            this.send(eventGeneric);
            this.radioAudible = bl;
        }
    }

    void sendBaiduCarLifeAudible(boolean bl) {
        if (this.baiduCarLifeAudible != bl) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(839466240);
            eventGeneric.setBoolean(0, bl);
            this.send(eventGeneric);
            this.baiduCarLifeAudible = bl;
        }
    }

    void sendEntContextNotAudible() {
        this.sendAndroidAutoAudible(false);
        this.sendCarPlayAudible(false);
        this.sendMirrorLinkAudible(false);
        this.sendMediaAudible(false);
        this.sendBaiduCarLifeAudible(false);
        this.sendRadioAudible(false);
    }

    boolean checkForSentBackAndExecuteIfIndicated(int n) {
        boolean bl = false;
        EventGeneric eventGeneric = (EventGeneric)pendingConnectionMap.get(n);
        if (eventGeneric != null && (!this.getBooleanSafe(eventGeneric, 2) || this.getBooleanSafe(eventGeneric, 2) && eventGeneric.getResult() == 12)) {
            eventGeneric.setResult(0);
            eventGeneric.setBlocked(false);
            this.sendBack(eventGeneric);
            bl = true;
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("startConnection: sending back! ").append(eventGeneric).log();
            }
            connectionsOnStackMap.put(n, null);
            pendingConnectionMap.put(n, null);
        } else if (ServiceManager.logger2.isTraceEnabled(4)) {
            ServiceManager.logger2.trace(4).append("startConnection: not sending back! ").append(eventGeneric).log();
        }
        return bl;
    }

    void releaseMuteHfpDownlink() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, 106);
        this.triggerObserver(67714304, eventGeneric);
        widebandTriggerOngoing = false;
    }

    void checkUnrequestedAnnouncementAndSendIfIndicated(int n) {
        EventGeneric eventGeneric = (EventGeneric)pendingConnectionMap.get(n);
        if (eventGeneric == null && SoundUtil.isUnrequestedStartAnnouncementRetriggerCandidate(n)) {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("startConnection: send: UnrequestedAnnouncement!!!: ").append(n).log();
            }
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric2.setInt(0, n);
            this.target.triggerObserver(520699136, eventGeneric2);
        }
    }

    boolean handlePauseConnection(int n, AbstractHsmState abstractHsmState) {
        EventGeneric eventGeneric;
        pendingFadeToConnections.remove(n);
        if (n == suspendedFadeToConnection) {
            suspendedFadeToConnection = -1;
        }
        if ((eventGeneric = (EventGeneric)pendingConnectionMap.get(n)) != null && this.getBooleanSafe(eventGeneric, 2)) {
            eventGeneric.setResult(0);
            eventGeneric.setBlocked(false);
            this.sendBack(eventGeneric);
            pendingConnectionMap.put(n, null);
            connectionsOnStackMap.put(n, null);
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("pauseConnection: Sending back because answer on pause is set.").log();
            }
        }
        if (SoundUtil.isEntSource(n)) {
            this.sendEntContextNotAudible();
        }
        this.handledAnsweredEntConn(n, false);
        this.setWidebandSpeech(n);
        this.setPendingResponseOnLoweringConnection(n, false);
        return !SoundUtil.isEntSource(n);
    }

    boolean preventFadeTo(int n) {
        boolean bl = false;
        EventGeneric eventGeneric = (EventGeneric)pendingConnectionMap.get(n);
        if (eventGeneric != null) {
            bl = this.getBooleanSafe(eventGeneric, 1);
        }
        return bl;
    }

    void doFadeToConnection(int n) {
        if ((isPowerstateOnTelOrStandby || requestMuteStandbyProcessing) && SoundUtil.isEntSource(n)) {
            if (this.isTraceEnabled()) {
                this.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] ###### PowerstateOnTelOrStandby: ").append(isPowerstateOnTelOrStandby).append(", requestMuteStandbyProcessing: ").append(requestMuteStandbyProcessing).append(", suspend fadeTo for connection ").append(n).log();
            }
            suspendedFadeToConnection = n;
        } else {
            this.target.dsiAudioManagement.fadeToConnection(n, 1);
        }
    }

    void checkRequestMuteStandbyProcessingDoneAndFadeToSuspended(int n) {
        if (n == 3) {
            requestMuteStandbyProcessing = false;
            this.fadeToSuspendedConnections();
        }
    }

    void fadeToSuspendedConnections() {
        if (!isPowerstateOnTelOrStandby && !requestMuteStandbyProcessing && suspendedFadeToConnection != -1) {
            if (this.isTraceEnabled()) {
                this.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] catch up fadeTo for suspended connection ").append(suspendedFadeToConnection).log();
            }
            this.doFadeToConnection(suspendedFadeToConnection);
            suspendedFadeToConnection = -1;
        }
    }

    void setVolumelock(int n, boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[HsmSoundConnectionHandling.ConnectionHandling] setVolumelock: con: ").append(n).append(", locked: ").append(bl).log();
        }
        this.target.dsiAudioManagement.setVolumelock(n, 1, bl);
    }

    void checkVolumeLockedEntertainmentUnderNonVolumeFocusConnection(int n) {
        if (n == 8 && volumeLockedConnectionsAll.contains(currentEntConnection) && !volumeLockedConnectionsExplicitASL.contains(currentEntConnection)) {
            this.trace("[HsmSoundConnectionHandling.ConnectionHandling] unlock implicit VolumeLock entertainment under non volumeFocus connection");
            this.setVolumelock(currentEntConnection, false);
        }
    }

    void setPendingResponseOnLoweringConnection(int n, boolean bl) {
        if (SoundUtil.isConnectionMayLeadToEntVolZero(n)) {
            pendingResponseOnLoweringConnection = bl ? n : -1;
        }
    }

    void unlockImplicitVolumelock(int n) {
        if (volumeLockedConnectionsAll.contains(n) && !volumeLockedConnectionsExplicitASL.contains(n)) {
            this.setVolumelock(n, false);
            this.warn().append("[HsmSoundConnectionHandling] releasing implicit volumelock detected on end of connection ").append(n).log();
        }
    }

    void requestConnection(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[HsmSoundConnectionHandling] requestConnection: ").append(n).append(", standby:").append(standby).log();
        }
        this.dsiAudioManagement.requestConnection(n, 1, 0);
        if (SoundUtil.isEntSource(n)) {
            lastRequestedEntCon = n;
            this.stopTimer(-1568276224);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), -1568276224);
            super.getClass();
            eventGeneric.setInt(0, n);
            TimerServer timerServer = ServiceManager.eventMain.getTimerServer();
            super.getClass();
            timerServer.sendTimedEvent(eventGeneric, (long)0, false, false);
        }
    }

    void sendUserMuteActive(boolean bl, boolean bl2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[HsmSoundConnectionHandling] Send ASL_SOUND_USERMUTE_IS_ACTIVE, started: ").append(bl).append(", active: ").append(bl2).log();
        }
        if (this.userMuteStarted != bl || this.userMuteActive != bl2) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(118045952);
            eventGeneric.setBoolean(0, bl);
            eventGeneric.setBoolean(1, bl2);
            this.send(eventGeneric);
        }
    }

    void applySystemSoundAudibleStatus() {
        this.target.trace("[HsmSoundConnectionHandling] apply SYSTEM_ENABLE_SOUND_STATUS");
        if (systemSoundAudible) {
            this.releaseConnection(3);
        } else {
            this.requestConnection(3);
            requestMuteStandbyProcessing = true;
        }
    }

    void releaseConnection(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[HsmSoundConnectionHandling] releaseConnection: ").append(n).log();
        }
        this.dsiAudioManagement.releaseConnection(n, 1);
    }

    boolean getBooleanSafe(EventGeneric eventGeneric, int n) {
        return eventGeneric.getParamType(n) == 0 ? false : eventGeneric.getBoolean(n);
    }

    public HsmSoundConnectionHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.EV_SOUND_SEND_DELAYED_RESTORE_IF_APPLICABLE = -1585053440;
        this.EV_SOUND_MISSING_ANSWER_REQUEST_ENT_CONN_P0_CONNECTION_INT = 0;
        this.SOUND_MISSING_ANSWER_REQUEST_ENT_CONN_TIMER = 20000;
        this.EV_SOUND_SET_MUTE_VALETPARKING = -1551499008;
        this.EV_SOUND_SET_MUTE_VALETPARKING_P0_BOOLEAN = 0;
        this.stateInit = new HsmSoundConnectionHandling$StateSoundConnectionHandlingInit(this, this.hsm, "SoundConnectionHandlingInit", this.getWorkStateParent());
        this.stateConnectionHandling = new HsmSoundConnectionHandling$StateSoundConnectionHandlingConnectionHandling(this, this.hsm, "ConnectionHandling", this.stateInit);
        this.target = this;
        this.redirectMuteToMedia = false;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getDefaultTargetId() {
        return -1338698496;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        currentConnection = -1;
        currentEntConnection = -1;
        previousEntConnection = -1;
        pendingFadeToConnections = new IntOptHashSet(3);
        lastFadedInConnection = -1;
        releaseVolumelockRunningOnConnection = -1;
        pendingResponseOnLoweringConnection = -1;
        standby = true;
        muteActive = 0;
        initialStartup = true;
        systemSoundAudible = false;
        currentMutePinState = false;
        currentTheftProtectionActive = false;
        widebandTriggerOngoing = false;
        setWidebandEvent = null;
        currentValetparkingMuteActive = false;
        pendingEntConnection = -1;
        lastRequestedEntCon = -1;
        isPowerstateOnTelOrStandby = false;
        requestMuteStandbyProcessing = false;
        suspendedFadeToConnection = -1;
    }
}

