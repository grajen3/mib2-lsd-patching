/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.core.ActivationRequest;
import de.vw.mib.asl.framework.api.entertainmentmanager.core.Deactivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.LegacyCallbackReceiver;
import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public class LegacyActivation
implements ActivationRequest,
Deactivation {
    protected final LegacyCallbackReceiver lcr;
    protected final int targetId;
    protected final AbsoluteActivation activation;

    public LegacyActivation(LegacyCallbackReceiver legacyCallbackReceiver, int n, AbsoluteActivation absoluteActivation) {
        this.lcr = legacyCallbackReceiver;
        this.targetId = n;
        this.activation = absoluteActivation;
    }

    @Override
    public Deactivation granted(Runnable runnable) {
        this.lcr.setOnActivated(runnable, this.activation);
        this.activation.activate(this.targetId);
        return this;
    }

    @Override
    public void rejected() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, this.targetId, -849603328);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void cancel() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, this.targetId, -967043840);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void deactivate(int n, Runnable runnable) {
        if (this.activation != null && this.getContext() == n) {
            runnable.run();
            return;
        }
        this.lcr.setOnDeactivated(runnable);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, this.targetId, -983821056);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public String toString() {
        return new StringBuffer().append("LegacyActivation [targetId=").append(this.targetId).append(", activation=").append(this.activation).append(", toString()=").append(super.toString()).append("]").toString();
    }

    @Override
    public int getContext() {
        return this.activation.getContext();
    }
}

