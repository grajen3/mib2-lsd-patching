/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.flowlistmenu;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.impl.flowlistmenu.AbstractFlowListMenuTarget;
import de.vw.mib.asl.internal.impl.flowlistmenu.FlowListMenuServicesImpl;
import de.vw.mib.asl.internal.impl.flowlistmenu.ParticleAnimationSelectionTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class FlowListMenuStartupTarget
extends AbstractFlowListMenuTarget {
    public FlowListMenuStartupTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, ServiceManager.logger, -2086528768);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
        }
    }

    private void processPowerOn() {
        new ParticleAnimationSelectionTarget(new FlowListMenuServicesImpl());
    }
}

