/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.start;

import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterCallback;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterParameters;

public interface SlotUpdaterActivator {
    public static final String SLOT_UPDATER_ACTIVATOR;

    default public void activate(SlotUpdaterCallback slotUpdaterCallback, SlotUpdaterParameters slotUpdaterParameters) {
    }
}

