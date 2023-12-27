/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.master.MasterFeature;

public interface AbortMasterFeature
extends MasterFeature {
    default public boolean isAbortCommandValid() {
    }

    default public boolean isAbortPromptsValid() {
    }

    default public int getAbortCommand() {
    }

    default public OrderedPrompts getAbortPrompts() {
    }
}

