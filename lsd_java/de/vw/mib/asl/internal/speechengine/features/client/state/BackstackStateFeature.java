/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.features.client.state.StateFeature;

public interface BackstackStateFeature
extends StateFeature {
    default public boolean isBackstackEventValid() {
    }

    default public boolean isAddToBackstackValid() {
    }

    default public Event getBackstackEvent() {
    }

    default public boolean isAddToBackstack() {
    }
}

