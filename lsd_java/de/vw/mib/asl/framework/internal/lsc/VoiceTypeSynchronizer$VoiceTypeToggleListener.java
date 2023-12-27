/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.AbstractLscTarget;
import de.vw.mib.asl.framework.internal.impl.lsc.LscLogger;
import de.vw.mib.asl.framework.internal.lsc.VoiceTypeSynchronizer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;

class VoiceTypeSynchronizer$VoiceTypeToggleListener
extends AbstractLscTarget {
    private final /* synthetic */ VoiceTypeSynchronizer this$0;

    VoiceTypeSynchronizer$VoiceTypeToggleListener(VoiceTypeSynchronizer voiceTypeSynchronizer, GenericEvents genericEvents) {
        this.this$0 = voiceTypeSynchronizer;
        super(5296, genericEvents, LscLogger.EMPTY_LOGGER);
        ServiceRegister serviceRegister = genericEvents.getServiceRegister();
        serviceRegister.addObserver(889921600, this.getTargetId());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 889921600) {
            this.this$0.onModelVoiceToggled();
        }
    }
}

