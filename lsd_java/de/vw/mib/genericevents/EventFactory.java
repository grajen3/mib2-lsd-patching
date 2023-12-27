/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventGeneric;
import java.io.DataInputStream;

public interface EventFactory {
    default public void freeEvent(EventGeneric eventGeneric) {
    }

    default public EventGeneric newEvent() {
    }

    default public EventGeneric newEvent(DataInputStream dataInputStream) {
    }

    default public EventGeneric newEvent(EventGeneric eventGeneric) {
    }

    default public EventGeneric newEvent(int n) {
    }

    default public EventGeneric newEvent(int n, int n2, int n3) {
    }

    default public EventGeneric newEvent(int n, int n2, int n3, int n4) {
    }
}

