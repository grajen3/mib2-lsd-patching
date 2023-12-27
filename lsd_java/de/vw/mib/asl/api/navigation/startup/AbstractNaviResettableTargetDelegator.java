/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.startup;

import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;

public abstract class AbstractNaviResettableTargetDelegator
extends AbstractResettableTarget {
    AbstractTarget subject;

    public AbstractNaviResettableTargetDelegator(AbstractTarget abstractTarget, String string) {
        this.subject = abstractTarget;
        abstractTarget.getEventDispatcher().unregisterTarget(abstractTarget.getTargetId(), false);
        this.register(abstractTarget.getMainObject(), abstractTarget.getTargetId(), string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                eventGeneric.setSenderEventId(eventGeneric.getReceiverEventId());
                break;
            }
            case 101001: {
                eventGeneric.setSenderEventId(eventGeneric.getReceiverEventId());
                break;
            }
            case 101002: {
                eventGeneric.setSenderEventId(eventGeneric.getReceiverEventId());
                break;
            }
            case 101000: {
                eventGeneric.setSenderEventId(eventGeneric.getReceiverEventId());
                break;
            }
            default: {
                this.subject.gotEvent(eventGeneric);
            }
        }
    }
}

