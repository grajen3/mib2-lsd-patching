/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.features.client.state.StateFeature;

public interface CommandStateFeature
extends StateFeature {
    default public boolean isCommandsToLoadValid() {
    }

    default public boolean isCommandsToUnloadValid() {
    }

    default public Command[] getCommandsToLoad() {
    }

    default public Command[] getCommandsToUnload() {
    }
}

