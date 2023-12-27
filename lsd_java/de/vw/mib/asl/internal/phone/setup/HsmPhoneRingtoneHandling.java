/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.setup.StatePhoneRingtoneInit;
import de.vw.mib.asl.internal.phone.setup.StatePhoneRingtoneWaveplayerAborting;
import de.vw.mib.asl.internal.phone.setup.StatePhoneRingtoneWaveplayerActive;
import de.vw.mib.asl.internal.phone.setup.StatePhoneRingtoneWaveplayerIdle;
import de.vw.mib.asl.internal.phone.setup.StatePhoneRingtoneWaveplayerTriggering;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractHsmTripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.waveplayer.DSIWavePlayer;

public class HsmPhoneRingtoneHandling
extends AbstractHsmTripleMobileEquipment {
    protected DSIWavePlayer dsiWavePlayer;
    protected DSIListener dsiWavePlayerListener;
    EventGeneric playEvent = null;
    protected short selectedRingtone;
    protected final short ringtoneCount = (short)10;
    protected boolean ringtoneMenuConnectionSet = false;
    static final int EV_RESPONSE_AUDIOTRIGGER_TIMER;
    protected int RESPONSE_AUDIOTRIGGER_TIMER = 200;
    protected int lastAudioTrigger = -1;
    private boolean alreadyRegistered = false;
    final HsmState stateInit;
    final HsmState stateWaveplayerIdle;
    final HsmState stateWaveplayerTriggering;
    final HsmState stateWaveplayerActive;
    final HsmState stateWaveplayerAborting;
    static /* synthetic */ Class class$org$dsi$ifc$waveplayer$DSIWavePlayer;
    static /* synthetic */ Class class$org$dsi$ifc$waveplayer$DSIWavePlayerListener;

    public HsmPhoneRingtoneHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateInit = new StatePhoneRingtoneInit(this, genericEvents, this.hsm, "PhoneRingtoneHandlingTop", this.getWorkStateParent());
        this.stateWaveplayerIdle = new StatePhoneRingtoneWaveplayerIdle(this, genericEvents, this.hsm, "PhoneRingtoneHandlingIdle", this.stateInit);
        this.stateWaveplayerTriggering = new StatePhoneRingtoneWaveplayerTriggering(this, genericEvents, this.hsm, "PhoneRingtoneHandlingTriggering", this.stateInit);
        this.stateWaveplayerActive = new StatePhoneRingtoneWaveplayerActive(this, genericEvents, this.hsm, "PhoneRingtoneHandlingActive", this.stateInit);
        this.stateWaveplayerAborting = new StatePhoneRingtoneWaveplayerAborting(this, genericEvents, this.hsm, "PhoneRingtoneHandlingAborting", this.stateInit);
    }

    @Override
    public int getDefaultTargetId() {
        return 5262;
    }

    @Override
    protected void init() {
        super.init();
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiWavePlayer = (DSIWavePlayer)dSIProxy.getService(this, class$org$dsi$ifc$waveplayer$DSIWavePlayer == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayer = HsmPhoneRingtoneHandling.class$("org.dsi.ifc.waveplayer.DSIWavePlayer")) : class$org$dsi$ifc$waveplayer$DSIWavePlayer, 0);
            this.dsiWavePlayerListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$waveplayer$DSIWavePlayerListener == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayerListener = HsmPhoneRingtoneHandling.class$("org.dsi.ifc.waveplayer.DSIWavePlayerListener")) : class$org$dsi$ifc$waveplayer$DSIWavePlayerListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$waveplayer$DSIWavePlayerListener == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayerListener = HsmPhoneRingtoneHandling.class$("org.dsi.ifc.waveplayer.DSIWavePlayerListener")) : class$org$dsi$ifc$waveplayer$DSIWavePlayerListener, 0, this.dsiWavePlayerListener);
            this.addObserver(252263680);
            Object[] objectArray = new Boolean[10];
            for (int i2 = 9; i2 >= 0; --i2) {
                objectArray[i2] = Boolean.FALSE;
            }
            ListManager.getGenericASLList(1244).updateList(objectArray);
            dSIProxy.setUnexpectedResponsePassing(class$org$dsi$ifc$waveplayer$DSIWavePlayer == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayer = HsmPhoneRingtoneHandling.class$("org.dsi.ifc.waveplayer.DSIWavePlayer")) : class$org$dsi$ifc$waveplayer$DSIWavePlayer, 0, "audioTrigger", false);
        }
        this.alreadyRegistered = true;
    }

    @Override
    protected void setNotification() {
        super.setNotification();
        this.dsiWavePlayer.setNotification(new int[]{2, 1}, this.dsiWavePlayerListener);
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return new int[]{39};
        }
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    @Override
    protected int[] getMobileEquipmentHfpOnlyNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return ASLPhoneData.EMPTY_NOTIFICATION;
        }
        return new int[]{39};
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    void stopAudioTriggerTimerIfActive() {
        if (ServiceManager.eventMain.getTimerServer().isTimerActive(this.getTargetId(), 814219520)) {
            ServiceManager.eventMain.getTimerServer().stopTimedEvent(this.getTargetId(), 814219520);
        }
    }

    boolean isAudioTriggerTimerActive() {
        return ServiceManager.eventMain.getTimerServer().isTimerActive(this.getTargetId(), 814219520);
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

