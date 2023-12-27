/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.context;

import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.features.client.context.ContextFeature;

public interface TeleprompterOnOffContextFeature
extends ContextFeature {
    default public boolean isTeleprompterOnEventValid() {
    }

    default public boolean isTeleprompterOffEventValid() {
    }

    default public boolean isTeleprompterStateChangingValid() {
    }

    default public Event getTeleprompterOnEvent() {
    }

    default public Event getTeleprompterOffEvent() {
    }

    default public boolean isTeleprompterStateChanging() {
    }
}

