/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.context;

import de.vw.mib.asl.api.speechengine.features.client.context.FeatureParamContextKeys;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.context.ContextEventsContextFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class ContextEventsFeatureImpl
extends AbstractGenericFeature
implements ContextEventsContextFeature,
FeatureParamContextKeys {
    private Event contextIdleEvent;
    private Event promptStartedEvent;
    private Event promptSpokenEvent;
    private Event helpModeActivatedEvent;
    private Event helpModeDeactivatedEvent;

    public ContextEventsFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setContextIdleEvent(Event event) {
        this.contextIdleEvent = event;
    }

    private void setPromptStartedEvent(Event event) {
        this.promptStartedEvent = event;
    }

    private void setPromptsSpokenEvent(Event event) {
        this.promptSpokenEvent = event;
    }

    private void setHelpModeActivatedEvent(Event event) {
        this.helpModeActivatedEvent = event;
    }

    private void setHelpModeDeactivatedEvent(Event event) {
        this.helpModeDeactivatedEvent = event;
    }

    @Override
    public boolean isContextIdleEventValid() {
        return this.contextIdleEvent != null;
    }

    @Override
    public boolean isPromptStartedEventValid() {
        return this.promptStartedEvent != null;
    }

    @Override
    public boolean isPromptsSpokenEventValid() {
        return this.promptSpokenEvent != null;
    }

    @Override
    public Event getContextIdleEvent() {
        return this.contextIdleEvent;
    }

    @Override
    public Event getPromptStartedEvent() {
        return this.promptStartedEvent;
    }

    @Override
    public Event getPromptsSpokenEvent() {
        return this.promptSpokenEvent;
    }

    @Override
    public boolean isHelpModeActivatedEventValid() {
        return this.helpModeActivatedEvent != null;
    }

    @Override
    public boolean isHelpModeDeactivatedEventValid() {
        return this.helpModeDeactivatedEvent != null;
    }

    @Override
    public Event getHelpModeActivatedEvent() {
        return this.helpModeActivatedEvent;
    }

    @Override
    public Event getHelpModeDeactivatedEvent() {
        return this.helpModeDeactivatedEvent;
    }

    @Override
    public int getFeatureType() {
        return 201;
    }

    @Override
    public void setEvent(int n, Event event) {
        switch (n) {
            case 2001: {
                this.setContextIdleEvent(event);
                break;
            }
            case 2002: {
                this.setPromptStartedEvent(event);
                break;
            }
            case 2003: {
                this.setPromptsSpokenEvent(event);
                break;
            }
            case 2006: {
                this.setHelpModeActivatedEvent(event);
                break;
            }
            case 2007: {
                this.setHelpModeDeactivatedEvent(event);
                break;
            }
            default: {
                super.setEvent(n, event);
            }
        }
    }
}

