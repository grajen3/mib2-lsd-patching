/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class SpeechEngineStartRec
extends AbstractTarget {
    public SpeechEngineStartRec(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 8: {
                break;
            }
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace("'POWER_ON' event for SpeechEngineStartRec ");
                }
                this.onPowerOn();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace("'POWER_OFF' event for SpeechEngineStartRec.");
                }
                this.onPowerOff();
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

    @Override
    public int getDefaultTargetId() {
        return 328275968;
    }

    private void onPowerOn() {
        String string = this.getEventDispatcher().getTaskId(this.getDefaultTargetId());
        SpeechEngineStartup.getInstance(string).powerOnASR(string);
    }

    private void onPowerOff() {
        String string = this.getEventDispatcher().getTaskId(this.getDefaultTargetId());
        SpeechEngineStartup.getInstance(string).powerOffASR();
    }
}

