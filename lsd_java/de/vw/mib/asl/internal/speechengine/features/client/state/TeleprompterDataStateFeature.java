/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.model.DynamicString;
import de.vw.mib.asl.internal.speechengine.features.client.state.StateFeature;

public interface TeleprompterDataStateFeature
extends StateFeature {
    default public DynamicString[] getCommandExamples() {
    }

    default public DynamicString getHeadlineText() {
    }

    default public int getTeleprompterType() {
    }

    default public boolean isCommandExamplesValid() {
    }

    default public boolean isHeadlineTextValid() {
    }

    default public boolean isTeleprompterTypeValid() {
    }
}

