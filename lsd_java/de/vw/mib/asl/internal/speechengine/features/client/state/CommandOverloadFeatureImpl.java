/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.client.state.FeatureParamStateKeys;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.CommandOverloadStateFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class CommandOverloadFeatureImpl
extends AbstractGenericFeature
implements CommandOverloadStateFeature,
FeatureParamStateKeys {
    private Event abortEvent;
    private Event pauseEvent;
    private Event backEvent;
    private Event helpEvent;
    private Event repeatEvent;

    public CommandOverloadFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setAbortEvent(Event event) {
        this.abortEvent = event;
    }

    private void setPauseEvent(Event event) {
        this.pauseEvent = event;
    }

    private void setBackEvent(Event event) {
        this.backEvent = event;
    }

    private void setHelpEvent(Event event) {
        this.helpEvent = event;
    }

    private void setRepeatEvent(Event event) {
        this.repeatEvent = event;
    }

    @Override
    public boolean isAbortEventValid() {
        return this.abortEvent != null;
    }

    @Override
    public boolean isPauseEventValid() {
        return this.pauseEvent != null;
    }

    @Override
    public boolean isBackEventValid() {
        return this.backEvent != null;
    }

    @Override
    public boolean isHelpEventValid() {
        return this.helpEvent != null;
    }

    @Override
    public boolean isRepeatEventValid() {
        return this.repeatEvent != null;
    }

    @Override
    public Event getAbortEvent() {
        return this.abortEvent;
    }

    @Override
    public Event getPauseEvent() {
        return this.pauseEvent;
    }

    @Override
    public Event getBackEvent() {
        return this.backEvent;
    }

    @Override
    public Event getHelpEvent() {
        return this.helpEvent;
    }

    @Override
    public Event getRepeatEvent() {
        return this.repeatEvent;
    }

    @Override
    public int getFeatureType() {
        return 308;
    }

    @Override
    public void setEvent(int n, Event event) {
        switch (n) {
            case 3060: {
                this.setAbortEvent(event);
                break;
            }
            case 3061: {
                this.setPauseEvent(event);
                break;
            }
            case 3062: {
                this.setBackEvent(event);
                break;
            }
            case 3063: {
                this.setHelpEvent(event);
                break;
            }
            case 3064: {
                this.setRepeatEvent(event);
                break;
            }
            default: {
                super.setEvent(n, event);
            }
        }
    }
}

