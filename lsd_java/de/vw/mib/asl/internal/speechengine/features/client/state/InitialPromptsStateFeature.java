/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.features.client.state.StateFeature;

public interface InitialPromptsStateFeature
extends StateFeature {
    default public boolean isInitialPromptsValid() {
    }

    default public Prompt[] getInitialPrompts() {
    }
}

