/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.sound.AbstractASLHsmSoundTarget;
import de.vw.mib.asl.internal.sound.HsmSoundSetterHandling$StateSoundSetterHandlingInit;
import de.vw.mib.asl.internal.sound.HsmSoundSetterHandling$StateSoundSetterHandlingMain;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSIAudioManagementListener;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;

public class HsmSoundSetterHandling
extends AbstractASLHsmSoundTarget {
    int onVolumeConnection = 2;
    protected DSIAudioManagement dsiAudioManagement;
    protected DSISound dsiSound;
    protected DSIAudioManagementListener dsiAudioManagementListener;
    protected DSISoundListener dsiSoundListener;
    public final HsmState stateInit = new HsmSoundSetterHandling$StateSoundSetterHandlingInit(this, this.hsm, "SoundSetterHandlingInit", this.getWorkStateParent());
    public final HsmState stateMain = new HsmSoundSetterHandling$StateSoundSetterHandlingMain(this, this.hsm, "SoundSetterHandlingMain", this.stateInit);
    protected final int EV_RESPONSE_MENU_RINGER_CONNECTION_SET;
    protected final int EV_RESPONSE_MENU_TA_CONNECTION_SET;
    protected static final int EV_SOUND_BALANCE_FADER_SYNC_ERROR;
    protected final int EV_SOUND_BALANCE_FADER_SYNC_ERROR_P0_BALANCE_INT;
    protected final int EV_SOUND_BALANCE_FADER_SYNC_ERROR_P1_FADER_INT;
    protected final int SOUND_BALANCE_FADER_SYNC_ERROR_TIMER;
    protected static final int EV_PROFILE_CHANGE;
    protected static final int EV_GLOBAL_PROFILE_CHANGE_COMPLETED;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagement;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;

    protected void initDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAudioManagement = (DSIAudioManagement)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSIAudioManagement == null ? (class$org$dsi$ifc$audio$DSIAudioManagement = HsmSoundSetterHandling.class$("org.dsi.ifc.audio.DSIAudioManagement")) : class$org$dsi$ifc$audio$DSIAudioManagement);
        this.dsiSound = (DSISound)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = HsmSoundSetterHandling.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound);
        this.dsiAudioManagementListener = (DSIAudioManagementListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = HsmSoundSetterHandling.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener);
        this.dsiSoundListener = (DSISoundListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = HsmSoundSetterHandling.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = HsmSoundSetterHandling.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener, this.dsiAudioManagementListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = HsmSoundSetterHandling.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener, this.dsiSoundListener);
    }

    public HsmSoundSetterHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.EV_RESPONSE_MENU_RINGER_CONNECTION_SET = -1585053440;
        this.EV_RESPONSE_MENU_TA_CONNECTION_SET = -1568276224;
        this.EV_SOUND_BALANCE_FADER_SYNC_ERROR_P0_BALANCE_INT = 0;
        this.EV_SOUND_BALANCE_FADER_SYNC_ERROR_P1_FADER_INT = 1;
        this.SOUND_BALANCE_FADER_SYNC_ERROR_TIMER = 200;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getDefaultTargetId() {
        return -1305144064;
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

