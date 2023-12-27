/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class SpeechPhoneStartTarget
extends AbstractTarget {
    private final String taskId;

    public SpeechPhoneStartTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.taskId = string;
    }

    @Override
    public int getDefaultTargetId() {
        return 1649678592;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                this.onPowerOn();
                break;
            }
            case 107: {
                break;
            }
        }
    }

    private void onPowerOn() {
        new SpeechPhoneDependencyResolver(this.taskId);
        new MessagingDependencyResolver(this.taskId);
    }
}

