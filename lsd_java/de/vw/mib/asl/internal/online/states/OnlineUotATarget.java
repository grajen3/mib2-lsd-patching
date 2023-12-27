/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.states;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;

public class OnlineUotATarget
extends AbstractASLTarget
implements DSIServiceStateListener {
    UotATarget _target;
    private final String _classname = super.getClass().getName();
    final int[] OBSERVED_EVENTS = new int[]{155076864, 1612194560, 1628971776, 701895488, 718672704, 651563840, 668341056, 567677760, 634786624, 735449920, 769004352};

    public OnlineUotATarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    private UotATarget getTarget() {
        if (this._target == null) {
            GenericEvents genericEvents = ServiceManager.eventMain;
            String string = "hsmtask";
            try {
                this._target = new UotATarget(genericEvents, string);
            }
            catch (Exception exception) {
                this.error(exception);
            }
            this.addObservers(this.OBSERVED_EVENTS);
        }
        return this._target;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.getTarget() != null) {
            if (this.isTraceEnabled()) {
                this.trace().append(this._classname).append(".gotEvent()").log();
            }
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getDefaultTargetId(), this.getTarget().getDefaultTargetId(), eventGeneric.getReceiverEventId());
            this.sendSafe(eventGeneric2);
        }
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    protected HsmState getDefaultState() {
        return this._target.getWorkStateParent();
    }

    @Override
    public int getDefaultTargetId() {
        return 846075392;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".registered(").append(string2).append(", ").append(n).append(")").log();
        }
        this.getTarget().registered(string, n);
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".unregistered(").append(string2).append(", ").append(n).append(")").log();
        }
        this.getTarget().unregistered(string, n);
    }
}

