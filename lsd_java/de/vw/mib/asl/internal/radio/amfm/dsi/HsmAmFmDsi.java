/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmProxyHelper;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateActive;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateAutoSeek;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateAutostore;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateForceAmUpdate;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateForceFmUpdate;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateIdle;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateInactive;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateSelectFrequency;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateSelectStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateSetAmBandRange;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateTop;
import de.vw.mib.asl.internal.radio.amfm.dsi.StateTuneFrequencySteps;
import de.vw.mib.asl.internal.radio.util.StateMachineOwner;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.sdars.DSISDARSTuner;

public class HsmAmFmDsi
extends TargetHsmImpl
implements StateMachineOwner {
    private static final int MAX_QUEUE_SIZE;
    private final HsmState stateTop = new StateTop(this, "stateTop", null);
    final HsmState stateActive = new StateActive(this, "stateActive", this.stateTop);
    final HsmState stateInactive = new StateInactive(this, "stateInactive", this.stateTop);
    final HsmState stateAutoSeek = new StateAutoSeek(this, "stateAutoSeek", this.stateActive);
    final HsmState stateIdle = new StateIdle(this, "stateIdle", this.stateTop);
    final HsmState stateSelectFrequency = new StateSelectFrequency(this, "stateSelectFrequency", this.stateActive);
    final HsmState stateSelectStation = new StateSelectStation(this, "stateSelectStation", this.stateActive);
    final HsmState stateSetAmBandRange = new StateSetAmBandRange(this, "stateSetAmBandRange", this.stateActive);
    final HsmState stateTuneFrequencySteps = new StateTuneFrequencySteps(this, "stateTuneFrequencySteps", this.stateActive);
    final HsmState stateAutostore = new StateAutostore(this, "stateAutostore", this.stateActive);
    final HsmState stateForceAmUpdate = new StateForceAmUpdate(this, "stateForceAmUpdate", this.stateActive);
    final HsmState stateForceFmUpdate = new StateForceFmUpdate(this, "stateForceFmUpdate", this.stateActive);
    public DSIAMFMTuner dsiAMFMTuner;
    AbstractASLHsmTarget mParent;
    private final List mQueue = new LinkedList();
    EventGeneric mCurrentEvent = null;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTunerListener;

    HsmAmFmDsi(GenericEvents genericEvents, int n, String string) {
        super(genericEvents);
        this.startHsmAndRegisterTarget(genericEvents, n, string, this.stateTop);
        this.hsm.verbose = false;
    }

    @Override
    public HsmState getIdleState() {
        return this.stateIdle;
    }

    @Override
    public int getTimeoutEventId() {
        return -863567616;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void addEvent(EventGeneric eventGeneric) {
        if (eventGeneric == null) return;
        List list = this.mQueue;
        synchronized (list) {
            while (true) {
                if (this.mQueue.size() < 1) {
                    eventGeneric.setBlocked(true);
                    this.mQueue.add(eventGeneric);
                    return;
                }
                EventGeneric eventGeneric2 = (EventGeneric)this.mQueue.remove(0);
                eventGeneric2.setBlocked(false);
                eventGeneric2.setResult(11);
                try {
                    ServiceManager.eventMain.getEventDispatcher().sendBack(eventGeneric2);
                }
                catch (GenericEventException genericEventException) {
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    EventGeneric nextEvent() {
        this.mCurrentEvent = null;
        List list = this.mQueue;
        synchronized (list) {
            if (!this.mQueue.isEmpty()) {
                this.mCurrentEvent = (EventGeneric)this.mQueue.remove(0);
            }
        }
        return this.mCurrentEvent;
    }

    @Override
    public EventGeneric getCurrentEvent() {
        return this.mCurrentEvent;
    }

    @Override
    public AbstractTarget getTarget() {
        return this;
    }

    public void registerDSI() {
        this.addObserver(-2096889792);
        if (null == this.dsiAMFMTuner) {
            this.dsiAMFMTuner = new AmFmProxyHelper((DSIAMFMTuner)ServiceManager.dsiServiceLocator.getService(this, class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = HsmAmFmDsi.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner));
        }
        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = HsmAmFmDsi.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener);
        ServiceManager.dsiServiceLocator.addResponseListener(this, class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = HsmAmFmDsi.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener, dSIListener);
    }

    @Override
    public int getSubClassifier() {
        return 128;
    }

    @Override
    public DSIAMFMTuner getAmfmTuner() {
        if (null == this.dsiAMFMTuner) {
            this.dsiAMFMTuner = new AmFmProxyHelper((DSIAMFMTuner)ServiceManager.dsiServiceLocator.getService(this, class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = HsmAmFmDsi.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner));
        }
        return this.dsiAMFMTuner;
    }

    @Override
    public DSISDARSTuner getSdarsTuner() {
        return null;
    }

    @Override
    public void debugOut(String string) {
        throw new UnsupportedOperationException("use Log4MIB");
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

