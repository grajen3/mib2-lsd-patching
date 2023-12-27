/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.master.MasterFeature;

public interface PardonMasterFeature
extends MasterFeature {
    default public boolean isPardonPromptsValid() {
    }

    default public OrderedPrompts getPardonPrompts() {
    }
}

