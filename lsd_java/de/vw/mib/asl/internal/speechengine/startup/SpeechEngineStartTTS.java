/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class SpeechEngineStartTTS
extends AbstractTarget {
    public SpeechEngineStartTTS(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace("'POWER_ON' event for SpeechEngineStartTTS. ");
                }
                this.onPowerOn();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace("'POWER_OFF' event for SpeechEngineStartTTS. ");
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
        return 345053184;
    }

    private void onPowerOn() {
        String string = this.getEventDispatcher().getTaskId(this.getDefaultTargetId());
        SpeechEngineStartup.getInstance(string).powerOnTTS(string);
    }

    private void onPowerOff() {
        String string = this.getEventDispatcher().getTaskId(this.getDefaultTargetId());
        SpeechEngineStartup.getInstance(string).powerOffTTS();
    }
}

