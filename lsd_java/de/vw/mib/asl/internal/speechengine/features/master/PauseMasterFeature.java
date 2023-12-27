/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.master.MasterFeature;

public interface PauseMasterFeature
extends MasterFeature {
    default public boolean isPauseCommandValid() {
    }

    default public boolean isCommandPausePromptsValid() {
    }

    default public boolean isPauseTimeoutPromptsValid() {
    }

    default public boolean isErrorPausePromptsValid() {
    }

    default public int getPauseCommand() {
    }

    default public OrderedPrompts getCommandPausePrompts() {
    }

    default public OrderedPrompts getPauseTimeoutPrompts() {
    }

    default public OrderedPrompts getErrorPausePrompts() {
    }
}

