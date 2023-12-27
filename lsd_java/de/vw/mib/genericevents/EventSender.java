/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventGeneric;

public interface EventSender {
    default public void send(EventGeneric eventGeneric) {
    }
}

