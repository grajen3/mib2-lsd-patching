/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.core.Deactivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.LegacyActivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.LegacyCallbackReceiver;
import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public class LegacyActivationStartup
extends LegacyActivation {
    int context;
    int yoursubcontext;

    public LegacyActivationStartup(LegacyCallbackReceiver legacyCallbackReceiver, int n, AbsoluteActivation absoluteActivation) {
        super(legacyCallbackReceiver, n, absoluteActivation);
    }

    @Override
    public Deactivation granted(Runnable runnable) {
        this.lcr.setOnActivated(runnable, this.activation);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, this.targetId, -1000598272);
        eventGeneric.setInt(0, this.context);
        eventGeneric.setInt(1, this.yoursubcontext);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        return this;
    }

    @Override
    public void rejected() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, this.targetId, -1000598272);
        eventGeneric.setInt(0, -1);
        eventGeneric.setInt(1, this.yoursubcontext);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }
}

