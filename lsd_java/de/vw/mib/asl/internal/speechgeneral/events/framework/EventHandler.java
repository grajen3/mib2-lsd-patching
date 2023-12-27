/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.events.framework;

import de.vw.mib.genericevents.EventGeneric;

public interface EventHandler {
    default public int[] getHandleEvents() {
    }

    default public void handleEvent(EventGeneric eventGeneric) {
    }
}

