/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.master.MasterFeature;

public interface ErrorsMasterFeature
extends MasterFeature {
    default public boolean isHardwareOfPoorQualityPromptsValid() {
    }

    default public boolean isUnknownErrorPromptsValid() {
    }

    default public boolean isSpeechLevelTooLoudPromptsValid() {
    }

    default public boolean isSpeechLevelTooWeakPromptsValid() {
    }

    default public boolean isSignalNoiseRatioTooLowPromptsValid() {
    }

    default public OrderedPrompts getHardwareOfPoorQualityPrompts() {
    }

    default public OrderedPrompts getUnknownErrorPrompts() {
    }

    default public OrderedPrompts getSpeechLevelTooLoudPrompts() {
    }

    default public OrderedPrompts getSpeechLevelTooWeakPrompts() {
    }

    default public OrderedPrompts getSignalNoiseRatioTooLowPrompts() {
    }
}

