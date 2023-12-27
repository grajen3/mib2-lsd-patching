/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.client.state.StateFeature;

public interface HelpPromptsStateFeature
extends StateFeature {
    default public boolean isHelpPromptsValid() {
    }

    default public OrderedPrompts[] getHelpPrompts() {
    }
}

