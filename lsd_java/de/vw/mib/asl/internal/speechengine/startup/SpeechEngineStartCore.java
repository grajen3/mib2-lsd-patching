/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class SpeechEngineStartCore
extends AbstractTarget {
    public SpeechEngineStartCore(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 311498752;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace("'POWER_ON' event for SpeechEngineStartCore");
                }
                this.onPowerOn();
                break;
            }
            case 107: {
                this.warn("'POWER_OFF' event for SpeechEngineStartCore. This should not be send from ASL startup");
                break;
            }
        }
    }

    @Override
    public int getClassifier() {
        return 4096;
    }

    @Override
    public int getSubClassifier() {
        return 8;
    }

    private void onPowerOn() {
        String string = this.getEventDispatcher().getTaskId(this.getDefaultTargetId());
        SpeechEngineStartup.getInstance(string);
    }
}

