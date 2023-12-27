/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.has;

import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.asl.internal.media.has.MediaHASServicesImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class MediaHASTarget
extends AbstractMediaTarget {
    public MediaHASTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 498012928;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                new MediaHASServicesImpl(this);
                break;
            }
        }
    }

    @Override
    public int getComponentId() {
        throw new UnsupportedOperationException();
    }
}

