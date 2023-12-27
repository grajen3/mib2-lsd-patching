/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.master.MasterFeature;

public interface MainMenuMasterFeature
extends MasterFeature {
    default public boolean isMainMenuCommandValid() {
    }

    default public boolean isMainMenuEventValid() {
    }

    default public boolean isMainMenuPromptsValid() {
    }

    default public int getMainMenuCommand() {
    }

    default public Event getMainMenuEvent() {
    }

    default public OrderedPrompts getMainMenuPrompts() {
    }
}

