/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.flowlistmenu;

import de.vw.mib.asl.api.background.services.ParticleBackgroundService;
import de.vw.mib.asl.api.background.services.ParticleSubStates;
import de.vw.mib.asl.internal.flowlistmenu.FlowListMenuServices;
import de.vw.mib.asl.internal.impl.flowlistmenu.AbstractFlowListMenuTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

public class ParticleAnimationSelectionTarget
extends AbstractFlowListMenuTarget {
    private final ParticleBackgroundService particleBackgroundService;

    public ParticleAnimationSelectionTarget(FlowListMenuServices flowListMenuServices) {
        super(flowListMenuServices.getGenericEvents(), flowListMenuServices.getLogger(), -2069751552);
        this.particleBackgroundService = flowListMenuServices.getParticleBackgroundService();
        this.registerObservers(flowListMenuServices.getServiceRegister());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1077741824: {
                int n = eventGeneric.getInt(0);
                this.particleBackgroundService.applySubState(ParticleSubStates.FLOWLISTMENU_PLATE1 + n);
                break;
            }
        }
    }

    private void registerObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(605504, this.getTargetId());
    }
}

