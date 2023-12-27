/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.context;

import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.features.client.context.ContextFeature;

public interface ContextEventsContextFeature
extends ContextFeature {
    default public boolean isContextIdleEventValid() {
    }

    default public boolean isPromptStartedEventValid() {
    }

    default public boolean isPromptsSpokenEventValid() {
    }

    default public boolean isHelpModeActivatedEventValid() {
    }

    default public boolean isHelpModeDeactivatedEventValid() {
    }

    default public Event getContextIdleEvent() {
    }

    default public Event getPromptStartedEvent() {
    }

    default public Event getPromptsSpokenEvent() {
    }

    default public Event getHelpModeActivatedEvent() {
    }

    default public Event getHelpModeDeactivatedEvent() {
    }
}

