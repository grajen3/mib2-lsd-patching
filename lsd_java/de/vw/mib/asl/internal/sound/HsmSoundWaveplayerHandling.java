/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.AbstractASLHsmSoundTarget;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingAborting;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingActive;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingConnecting;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingDisconnecting;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingFading;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingIdle;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingMain;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingTonesetting;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingTriggering;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerHandlingTriggeringTriggerDefaultTone;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateWaveplayerTriggeringTrigger;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.sound.asl.ASLSoundWaveplayer;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSIAudioManagementListener;
import org.dsi.ifc.waveplayer.DSIWavePlayer;
import org.dsi.ifc.waveplayer.DSIWavePlayerListener;

public class HsmSoundWaveplayerHandling
extends AbstractASLHsmSoundTarget
implements ASLSoundWaveplayer {
    protected DSIWavePlayer dsiWavePlayer;
    protected DSIWavePlayerListener dsiWavePlayerListener;
    protected DSIAudioManagement dsiAudioManagement;
    protected DSIAudioManagementListener dsiAudioManagementListener;
    final HsmState stateInit;
    final HsmState stateWaveplayerMain;
    final HsmState stateWaveplayerIdle;
    final HsmState stateWaveplayerTriggering;
    final HsmState stateWaveplayerTriggeringTrigger;
    final HsmState stateWaveplayerTriggeringTriggerDefaultTone;
    final HsmState stateWaveplayerActive;
    final HsmState stateWaveplayerAborting;
    final HsmState stateWaveplayerConnecting;
    final HsmState stateWaveplayerTonesetting;
    final HsmState stateWaveplayerFading;
    final HsmState stateWaveplayerDisconnecting;
    static int actPlayTone = -1;
    static int newPlayTone = -1;
    public EventGeneric pendingSystemBeep;
    protected final int EV_RESPONSE_TONE_NAVPOI_CONNECTION_SET;
    protected final int EV_RESPONSE_TONE_NAVPOI_FADEDIN;
    protected final int EV_RESPONSE_TONE_NAVPOI_CONNECTION_RELEASED;
    static /* synthetic */ Class class$org$dsi$ifc$waveplayer$DSIWavePlayer;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagement;
    static /* synthetic */ Class class$org$dsi$ifc$waveplayer$DSIWavePlayerListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagementListener;
    static /* synthetic */ Class class$de$vw$mib$sound$asl$ASLSoundWaveplayer;

    protected void initDsi() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiWavePlayer = (DSIWavePlayer)dSIProxy.getService(this, class$org$dsi$ifc$waveplayer$DSIWavePlayer == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayer = HsmSoundWaveplayerHandling.class$("org.dsi.ifc.waveplayer.DSIWavePlayer")) : class$org$dsi$ifc$waveplayer$DSIWavePlayer, 1);
        this.dsiAudioManagement = (DSIAudioManagement)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSIAudioManagement == null ? (class$org$dsi$ifc$audio$DSIAudioManagement = HsmSoundWaveplayerHandling.class$("org.dsi.ifc.audio.DSIAudioManagement")) : class$org$dsi$ifc$audio$DSIAudioManagement);
        this.dsiWavePlayerListener = (DSIWavePlayerListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$waveplayer$DSIWavePlayerListener == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayerListener = HsmSoundWaveplayerHandling.class$("org.dsi.ifc.waveplayer.DSIWavePlayerListener")) : class$org$dsi$ifc$waveplayer$DSIWavePlayerListener);
        this.dsiAudioManagementListener = (DSIAudioManagementListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = HsmSoundWaveplayerHandling.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$waveplayer$DSIWavePlayerListener == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayerListener = HsmSoundWaveplayerHandling.class$("org.dsi.ifc.waveplayer.DSIWavePlayerListener")) : class$org$dsi$ifc$waveplayer$DSIWavePlayerListener, 1, this.dsiWavePlayerListener);
    }

    public HsmSoundWaveplayerHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateInit = new HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit(this, this.hsm, "SoundWaveplayerHandlingInit", this.getWorkStateParent());
        this.stateWaveplayerMain = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingMain(this, this.hsm, "SoundWaveplayerHandlingMain", this.stateInit);
        this.stateWaveplayerIdle = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingIdle(this, this.hsm, "SoundWaveplayerHandlingIdle", this.stateWaveplayerMain);
        this.stateWaveplayerTriggering = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingTriggering(this, this.hsm, "SoundWaveplayerHandlingTriggering", this.stateWaveplayerMain);
        this.stateWaveplayerTriggeringTrigger = new HsmSoundWaveplayerHandling$StateWaveplayerTriggeringTrigger(this, this.hsm, "SoundWaveplayerHandlingTriggering", this.stateWaveplayerTriggering);
        this.stateWaveplayerTriggeringTriggerDefaultTone = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingTriggeringTriggerDefaultTone(this, this.hsm, "SoundWaveplayerHandlingTriggering", this.stateWaveplayerTriggering);
        this.stateWaveplayerActive = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingActive(this, this.hsm, "SoundWaveplayerHandlingActive", this.stateWaveplayerMain);
        this.stateWaveplayerAborting = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingAborting(this, this.hsm, "SoundWaveplayerHandlingAborting", this.stateWaveplayerMain);
        this.stateWaveplayerConnecting = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingConnecting(this, this.hsm, "SoundWaveplayerHandlingConnecting", this.stateWaveplayerMain);
        this.stateWaveplayerTonesetting = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingTonesetting(this, this.hsm, "SoundWaveplayerHandlingTonesetting", this.stateWaveplayerMain);
        this.stateWaveplayerFading = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingFading(this, this.hsm, "SoundWaveplayerHandlingFading", this.stateWaveplayerMain);
        this.stateWaveplayerDisconnecting = new HsmSoundWaveplayerHandling$StateWaveplayerHandlingDisconnecting(this, this.hsm, "SoundWaveplayerHandlingDisconnecting", this.stateWaveplayerMain);
        this.pendingSystemBeep = null;
        this.EV_RESPONSE_TONE_NAVPOI_CONNECTION_SET = -1585053440;
        this.EV_RESPONSE_TONE_NAVPOI_FADEDIN = -1568276224;
        this.EV_RESPONSE_TONE_NAVPOI_CONNECTION_RELEASED = -1551499008;
        if (ServiceManager.bundleContext != null) {
            ServiceManager.bundleContext.registerService((class$de$vw$mib$sound$asl$ASLSoundWaveplayer == null ? (class$de$vw$mib$sound$asl$ASLSoundWaveplayer = HsmSoundWaveplayerHandling.class$("de.vw.mib.sound.asl.ASLSoundWaveplayer")) : class$de$vw$mib$sound$asl$ASLSoundWaveplayer).getName(), (Object)this, null);
        }
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getDefaultTargetId() {
        return -1288366848;
    }

    int getPlayTone(EventGeneric eventGeneric) {
        int n = 13;
        switch (eventGeneric.getReceiverEventId()) {
            case 0x400004EE: {
                n = this.getPlayToneSetter(eventGeneric);
                break;
            }
            case 4000038: {
                n = this.getPlayToneASL(eventGeneric);
                break;
            }
        }
        return n;
    }

    int getPlayToneSetter(EventGeneric eventGeneric) {
        int n = 13;
        boolean bl = eventGeneric.contains(0);
        if (bl) {
            int n2 = eventGeneric.getInt(0);
            if (n2 == 0) {
                n = 15;
            } else if (n2 == 2) {
                n = 16;
            } else if (n2 == 1) {
                n = 14;
            } else if (n2 == 3) {
                n = 21;
            } else if (n2 == 4) {
                n = 13;
            } else if (n2 == 5) {
                n = 17;
            }
        }
        return n;
    }

    int getPlayToneASL(EventGeneric eventGeneric) {
        int n = 13;
        boolean bl = eventGeneric.contains(0);
        if (bl) {
            int n2 = eventGeneric.getInt(0);
            switch (n2) {
                case 0: {
                    n = 15;
                    break;
                }
                case 1: {
                    n = 14;
                    break;
                }
                case 2: {
                    n = 16;
                    break;
                }
                case 3: {
                    n = 21;
                    break;
                }
                case 4: {
                    n = 13;
                    break;
                }
                case 5: {
                    n = 17;
                    break;
                }
                default: {
                    n = 13;
                }
            }
        }
        return n;
    }

    boolean isStaticConnectionTone(int n) {
        boolean bl = true;
        if (n == 21) {
            bl = false;
        }
        return bl;
    }

    @Override
    public void playButtonPressedTone() {
        this.triggerObserver(-301727680, ServiceManager.mGenericEventFactory.newEvent());
    }

    @Override
    public void playButtonReleasedTone() {
        this.triggerObserver(-301727680, ServiceManager.mGenericEventFactory.newEvent());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

