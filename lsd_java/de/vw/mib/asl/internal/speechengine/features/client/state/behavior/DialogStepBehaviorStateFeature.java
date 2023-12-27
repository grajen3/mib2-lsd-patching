/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state.behavior;

import de.vw.mib.asl.internal.speechengine.features.client.state.behavior.BehaviorFeature;

public interface DialogStepBehaviorStateFeature
extends BehaviorFeature {
    default public boolean isEndSessionTypeValid() {
    }

    default public boolean isKeepPromptsValid() {
    }

    default public boolean isStartRecognizerAutomaticallyValid() {
    }

    default public boolean isEndSessionValid() {
    }

    default public boolean isPauseAutomaticallyValid() {
    }

    default public boolean isPlayHelpPromptValid() {
    }

    default public boolean isKeepPrompts() {
    }

    default public boolean isStartRecognizerAutomatically() {
    }

    default public boolean isEndSession() {
    }

    default public int getEndSessionType() {
    }

    default public boolean isPauseAutomatically() {
    }

    default public boolean isPlayHelpPrompt() {
    }
}

