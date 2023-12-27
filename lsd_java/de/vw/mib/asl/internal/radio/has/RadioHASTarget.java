/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.has;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.radio.has.RadioHASServicesImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class RadioHASTarget
extends AbstractASLTarget {
    public RadioHASTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return ASLRadioTargetIds.ASL_RADIO_HAS_TARGET;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                new RadioHASServicesImpl(this);
                break;
            }
        }
    }
}

