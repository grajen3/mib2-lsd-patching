/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.HsmSoundConnectionHandling;
import de.vw.mib.asl.internal.sound.HsmSoundConnectionHandling$StateSoundConnectionHandlingInit$1;
import de.vw.mib.asl.internal.sound.HsmSoundConnectionHandling$ValetParkingListenerAudio;
import de.vw.mib.asl.internal.sound.SoundUtil;
import de.vw.mib.asl.internal.sound.has.SoundHASUpdater;
import de.vw.mib.asl.internal.sound.has.SoundHAServicesAdapterImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class HsmSoundConnectionHandling$StateSoundConnectionHandlingInit
extends AbstractHsmState {
    boolean amready;
    HsmState lastStateAvailable;
    BundleContext bundleContext;
    private Services aslServices;
    private final /* synthetic */ HsmSoundConnectionHandling this$0;

    public HsmSoundConnectionHandling$StateSoundConnectionHandlingInit(HsmSoundConnectionHandling hsmSoundConnectionHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundConnectionHandling;
        super(hsm, string, hsmState);
        this.amready = false;
        this.lastStateAvailable = null;
        this.bundleContext = null;
    }

    protected void init() {
        this.this$0.target.initDSI();
        this.this$0.target.dsiAudioManagement.setNotification(new int[]{1, 2, 3}, (DSIListener)this.this$0.target.dsiAudioManagementListener);
        this.this$0.target.dsiSound.setNotification(new int[]{14, 24}, (DSIListener)this.this$0.target.dsiSoundListener);
        this.this$0.target.dsiSound.setNotification(new int[]{2, 4, 9, 21, 12, 13, 17, 20, 32, 33, 27}, (DSIListener)this.this$0.target.dsiSoundListener);
        this.this$0.dsiPowerManagement.setNotification(1, (DSIListener)this.this$0.dsiPowerManagementListener);
        new SoundHAServicesAdapterImpl();
        this.aslServices = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.bundleContext = this.aslServices.getBundleContext();
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (HsmSoundConnectionHandling.class$de$vw$mib$asl$api$speechengine$PromptEngine == null ? (HsmSoundConnectionHandling.class$de$vw$mib$asl$api$speechengine$PromptEngine = HsmSoundConnectionHandling.class$("de.vw.mib.asl.api.speechengine.PromptEngine")) : HsmSoundConnectionHandling.class$de$vw$mib$asl$api$speechengine$PromptEngine).getName(), (ServiceTrackerCustomizer)new HsmSoundConnectionHandling$StateSoundConnectionHandlingInit$1(this));
        serviceTracker.open();
        this.this$0.valetParkingListener = new HsmSoundConnectionHandling$ValetParkingListenerAudio(this.this$0, null);
        this.this$0.valetParkingListener.notifyValetParkingStateChanged(ASLSystemFactory.getSystemApi().getValetParkingService().getCurrentValetParkingState(), null);
        ASLSystemFactory.getSystemApi().getValetParkingService().addListener(this.this$0.valetParkingListener);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.Top] entered HSM_ENTRY");
                this.init();
                break;
            }
            case 4: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.Top] entered HSM_EXIT");
                break;
            }
            case 3: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.Top] entered HSM_START");
                break;
            }
            case 4000028: {
                this.this$0.redirectMuteToMedia = true;
                break;
            }
            case 100001: {
                if (!this.amready) break;
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric2.setInt(0, 2);
                this.this$0.target.triggerObserver(352926976, eventGeneric2);
                SoundHASUpdater.setcontextAvailable(true);
                ServiceManager.logger.normal(16).append(" Audio broadcast ASL_SOUND_AUDIOMNGMNT_STATUS: Available restore connections").log();
                break;
            }
            case 4000002: {
                int n = eventGeneric.getInt(0);
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.target.trace().append("[HsmSoundConnectionHandling.Top] entered ASL_SOUND_SET_CONNECTION ").append(n).log();
                }
                if (this.amready) break;
                if (SoundUtil.isEntSource(n)) {
                    this.this$0.target.info().append("[HsmSoundConnectionHandling.Top] buffering entertainment connection ").append(n).log();
                    eventGeneric.setBlocked(true);
                    HsmSoundConnectionHandling.pendingSetEntertainmentConnectionEvent = eventGeneric;
                    break;
                }
                this.this$0.warn().append("[HsmSoundConnectionHandling.Top] AMUnavialable! Drop request to non entertainment connection ").append(n).log();
                eventGeneric.setResult(11);
                break;
            }
            case 4300037: {
                this.this$0.target.trace("[HsmSoundConnectionHandling.Top] entered ASLSystem.ENABLE_SOUND_STATUS");
                HsmSoundConnectionHandling.systemSoundAudible = eventGeneric.getBoolean(0);
                break;
            }
            case 4000037: {
                HsmSoundConnectionHandling.widebandOn = eventGeneric.getBoolean(0);
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("[HsmSoundConnectionHandling.Top] received SET_WIDEBANDSPEECH ").append(HsmSoundConnectionHandling.widebandOn).log();
                }
                this.this$0.dsiSound.setWidebandSpeech(1, HsmSoundConnectionHandling.widebandOn);
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

    public void dsiAudioManagementUpdateAMAvailable(int n, int n2, int n3) {
        if (n == 3) {
            ServiceManager.logger.info(16).append(" Audio received AMAvailable: available").log();
            if (!this.this$0.target.getHsm().isActive(this.this$0.stateConnectionHandling)) {
                this.trans(this.this$0.stateConnectionHandling);
            }
            if (!this.amready) {
                if (HsmSoundConnectionHandling.initialStartup) {
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                    eventGeneric.setInt(0, 1);
                    this.this$0.target.triggerObserver(352926976, eventGeneric);
                    SoundHASUpdater.setcontextAvailable(true);
                    ServiceManager.logger.info(16).append(" Audio broadcast ASL_SOUND_AUDIOMNGMNT_STATUS: Available").log();
                } else {
                    this.this$0.stopTimer(-1585053440);
                    this.this$0.startTimer(-1585053440, (long)0, false);
                }
            }
            this.amready = true;
        } else {
            ServiceManager.logger.info(16).append(" Audio received AMAvailable: unavailable/initializing").log();
            if (!this.this$0.target.getHsm().getState().equals(this.this$0.stateInit)) {
                this.trans(this.this$0.stateInit);
            }
            if (!HsmSoundConnectionHandling.initialStartup && this.amready) {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric.setInt(0, 0);
                this.this$0.target.triggerObserver(352926976, eventGeneric);
                ServiceManager.logger.info(16).append(" Audio broadcast ASL_SOUND_AUDIOMNGMNT_STATUS: UNAvailable");
                SoundHASUpdater.setcontextAvailable(false);
            }
            this.this$0.clearPendingMapsAndConnections();
            this.amready = false;
        }
    }

    public void dsiAudioManagementAsyncException(int n, String string, int n2) {
        this.this$0.trace(new StringBuffer().append("[error]ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]").toString());
    }

    public void dsiSoundAsyncException(int n, String string, int n2) {
        this.this$0.trace(new StringBuffer().append("[error]ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]").toString());
        switch (n2) {
            case 1081: {
                this.this$0.warn().append("[HsmSoundConnectionHandling.Top] asyncException in setWidebandSpeech, cleaning up MuteHfpDownlink!").log();
                this.this$0.releaseMuteHfpDownlink();
                break;
            }
        }
    }

    public void dsiSoundUpdateMutePinState(boolean bl, int n) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[HsmSoundConnectionHandling.Top] received mutePinState: ").append(bl).log();
        }
        HsmSoundConnectionHandling.currentMutePinState = bl;
        if (!bl && HsmSoundConnectionHandling.startedSoundControlledConnections.contains(210)) {
            HsmSoundConnectionHandling.startedSoundControlledConnections.remove(210);
        }
    }

    public void dsiSoundUpdateMuteTheftProtection(boolean bl, int n) {
        if (this.this$0.target.isTraceEnabled()) {
            this.this$0.target.trace().append("[HsmSoundConnectionHandling.Top] received updateMuteTheftProtection: ").append(bl).log();
        }
        HsmSoundConnectionHandling.currentTheftProtectionActive = bl;
        if (!bl && HsmSoundConnectionHandling.startedMuteSymbolConnections.containsKey(6)) {
            HsmSoundConnectionHandling.startedMuteSymbolConnections.remove(6);
        }
    }

    public void dsiPowerManagementUpdatePowerManagementState(int n, int n2, int n3) {
        if (this.this$0.target.isTraceEnabled()) {
            this.this$0.target.trace().append("[HsmSoundConnectionHandling.Top] received UpdatePowerManagementState: ").append(n).log();
        }
        boolean bl = HsmSoundConnectionHandling.isPowerstateOnTelOrStandby = n == 7 || n == 2;
        if (!HsmSoundConnectionHandling.isPowerstateOnTelOrStandby) {
            this.this$0.fadeToSuspendedConnections();
        }
    }

    private void handleSetValetparkingMuteState(boolean bl) {
        HsmSoundConnectionHandling.currentValetparkingMuteActive = bl;
        if (this.this$0.target.isTraceEnabled()) {
            this.this$0.target.trace().append("[HsmSoundConnectionHandling.Top] while AMUnavailable recieved valetparking mode: ").append(bl).log();
        }
        if (!bl && HsmSoundConnectionHandling.startedSoundControlledConnections.contains(205)) {
            HsmSoundConnectionHandling.startedSoundControlledConnections.remove(205);
        }
    }
}

