/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.features.client.state.StateFeature;

public interface CommandOverloadStateFeature
extends StateFeature {
    default public boolean isAbortEventValid() {
    }

    default public boolean isPauseEventValid() {
    }

    default public boolean isBackEventValid() {
    }

    default public boolean isHelpEventValid() {
    }

    default public boolean isRepeatEventValid() {
    }

    default public Event getAbortEvent() {
    }

    default public Event getPauseEvent() {
    }

    default public Event getBackEvent() {
    }

    default public Event getHelpEvent() {
    }

    default public Event getRepeatEvent() {
    }
}

