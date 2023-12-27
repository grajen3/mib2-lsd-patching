/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventGeneric;

public interface EventRouter {
    default public EventGeneric routeEvent(EventGeneric eventGeneric) {
    }
}

