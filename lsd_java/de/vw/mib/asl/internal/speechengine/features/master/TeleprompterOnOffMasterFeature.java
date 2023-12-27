/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.master.MasterFeature;

public interface TeleprompterOnOffMasterFeature
extends MasterFeature {
    default public boolean isTeleprompterOnCommandValid() {
    }

    default public boolean isTeleprompterOffCommandValid() {
    }

    default public boolean isTeleprompterOnPromptsValid() {
    }

    default public boolean isTeleprompterOffPromptsValid() {
    }

    default public int getTeleprompterOnCommand() {
    }

    default public int getTeleprompterOffCommand() {
    }

    default public OrderedPrompts getTeleprompterOnPrompts() {
    }

    default public OrderedPrompts getTeleprompterOffPrompts() {
    }
}

