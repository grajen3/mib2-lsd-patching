/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public interface Target {
    default public GenericEvents getMainObject() {
    }

    default public int getTargetId() {
    }

    default public void gotEvent(EventGeneric eventGeneric) {
    }

    default public void setTargetId(int n) {
    }
}

