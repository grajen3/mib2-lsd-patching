/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface SpeechEvent
extends Event {
    default public int getIndex() {
    }

    default public long getObjectId() {
    }

    default public int getRuleId() {
    }

    default public int getSlotId() {
    }

    default public String getTag() {
    }

    default public void setIndex(int n) {
    }
}

