/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.master.MasterFeature;

public interface HelpMasterFeature
extends MasterFeature {
    default public boolean isHelpCommandValid() {
    }

    default public boolean isFeedbackPromptsValid() {
    }

    default public int getHelpCommand() {
    }

    default public OrderedPrompts getFeedbackPrompts() {
    }
}

