/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechsetup.start;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechsetup.SpeechSetupActivatorResolver;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class SpeechSetupStartTarget
extends AbstractTarget {
    private final String taskId;

    public SpeechSetupStartTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, string);
        this.taskId = string;
    }

    @Override
    public int getDefaultTargetId() {
        return -1561323264;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                this.powerOn();
                break;
            }
        }
    }

    private void powerOn() {
        Services services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        new SpeechSetupActivatorResolver(services, this.taskId);
    }
}

