/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.AbstractASLSoundTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaRouter;
import org.dsi.ifc.sse.DSISSE;
import org.dsi.ifc.sse.DSISSEListener;

public class TargetASLSoundSSESetter
extends AbstractASLSoundTarget {
    protected DSIMediaRouter dsiMediaRouter;
    protected DSISSE dsiSSE;
    protected DSISSEListener dsiSSEListener;
    protected final int EV_SOUND_ANSWER_ADAPTATION_DATA;
    protected Adaptation mAdaptationData = null;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRouter;
    static /* synthetic */ Class class$org$dsi$ifc$sse$DSISSE;
    static /* synthetic */ Class class$org$dsi$ifc$sse$DSISSEListener;

    public TargetASLSoundSSESetter(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.EV_SOUND_ANSWER_ADAPTATION_DATA = -1585053440;
    }

    @Override
    public int getDefaultTargetId() {
        return -1254812416;
    }

    protected void registerObservers() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiMediaRouter = (DSIMediaRouter)dSIProxy.getService(this, class$org$dsi$ifc$media$DSIMediaRouter == null ? (class$org$dsi$ifc$media$DSIMediaRouter = TargetASLSoundSSESetter.class$("org.dsi.ifc.media.DSIMediaRouter")) : class$org$dsi$ifc$media$DSIMediaRouter);
        this.dsiSSE = (DSISSE)dSIProxy.getService(this, class$org$dsi$ifc$sse$DSISSE == null ? (class$org$dsi$ifc$sse$DSISSE = TargetASLSoundSSESetter.class$("org.dsi.ifc.sse.DSISSE")) : class$org$dsi$ifc$sse$DSISSE);
        this.dsiSSEListener = (DSISSEListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$sse$DSISSEListener == null ? (class$org$dsi$ifc$sse$DSISSEListener = TargetASLSoundSSESetter.class$("org.dsi.ifc.sse.DSISSEListener")) : class$org$dsi$ifc$sse$DSISSEListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$sse$DSISSEListener == null ? (class$org$dsi$ifc$sse$DSISSEListener = TargetASLSoundSSESetter.class$("org.dsi.ifc.sse.DSISSEListener")) : class$org$dsi$ifc$sse$DSISSEListener, this.dsiSSEListener);
        this.dsiSSE.setNotification(new int[]{2, 1}, (DSIListener)this.dsiSSEListener);
        this.addObservers(new int[]{403258624, 252263680, 688471296, -2075192832});
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.trace("[SoundSSESetter] gotEvent() POWER_ON");
                this.registerObservers();
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1585053440);
                break;
            }
            case 1200004: {
                if (!this.isNamespaceKey(eventGeneric, -536825343, 0)) break;
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1585053440);
                break;
            }
            case 100001: {
                if (eventGeneric.getResult() != 0 || !this.isNamespaceKey(eventGeneric, -536825343, 0)) break;
                this.mAdaptationData = (Adaptation)eventGeneric.getObject(1);
                int n = this.mAdaptationData.getValue(1141);
                this.info().append("Sound received adaptation data. MicGainLevel: ").append(n).log();
                this.setMicGainLevel(n);
                break;
            }
            case 4000024: {
                this.trace("[SoundSSESetter] gotEvent() ASL_SOUND_AUDIO_CONNECTION_STARTED");
                int n = eventGeneric.getInt(0);
                this.setModeDueToActiveCon(n);
                break;
            }
            case 4000015: {
                this.trace("[SoundSSESetter] gotEvent() ASL_SOUND_AUDIO_CONNECTION_RELEASED");
                int n = eventGeneric.getInt(0);
                this.setModeDueToInactiveCon(n);
                break;
            }
            case 4000041: {
                this.trace("[SoundSSESetter] gotEvent() ASL_SOUND_SET_MIC_MUTESTATE");
                boolean bl = eventGeneric.getBoolean(0);
                this.setMicMuteState(bl);
                break;
            }
        }
    }

    public void dsiSSEUpdateMode(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[SoundSSESetter] received updateMode ").append(n).log();
        }
    }

    public void dsiSSEUpdateMicGainLevel(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[SoundSSESetter] received dsiSSE.updateMicGainLevel ").append(n).log();
        }
    }

    protected void setModeDueToActiveCon(int n) {
        switch (n) {
            case 100: 
            case 164: {
                this.setMode(1);
                break;
            }
            case 113: 
            case 245: {
                this.setMode(2);
                break;
            }
            case 153: 
            case 159: 
            case 169: {
                this.setMode(7);
                break;
            }
            case 163: {
                this.setMode(9);
                break;
            }
        }
    }

    protected void setModeDueToInactiveCon(int n) {
        switch (n) {
            case 100: 
            case 164: {
                this.setMode(0);
                break;
            }
            case 113: 
            case 245: {
                this.setMode(3);
                break;
            }
            case 153: 
            case 159: 
            case 169: {
                this.setMode(8);
                break;
            }
            case 163: {
                this.setMode(10);
                break;
            }
        }
    }

    protected void setMode(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[SoundSSESetter] requestSeMode ").append(n).log();
        }
        this.dsiSSE.requestSetMode(n);
    }

    protected void setMicMuteState(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[SoundSSESetter] setMicMuteOn ").append(bl).log();
        }
        if (bl) {
            this.dsiSSE.requestSetMicMuteState(0);
        } else {
            this.dsiSSE.requestSetMicMuteState(1);
        }
    }

    protected void setMicGainLevel(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[SoundSSESetter] requestSetMicGainLevel ").append(n).log();
        }
        this.dsiSSE.requestSetMicGainLevel(n);
    }

    private boolean isNamespaceKey(EventGeneric eventGeneric, int n, long l) {
        int n2 = eventGeneric.getInt(2);
        long l2 = eventGeneric.getLong(3);
        return n2 == n && l2 == l;
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

