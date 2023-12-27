/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.internal.speechengine.features.client.state.StateFeature;

public interface ListStateFeature
extends StateFeature {
    default public boolean isListHelpPromptActivated() {
    }

    default public boolean isNbestList() {
    }

    default public boolean isListHelpPromptActivatedValid() {
    }

    default public boolean isNbestListValid() {
    }
}

