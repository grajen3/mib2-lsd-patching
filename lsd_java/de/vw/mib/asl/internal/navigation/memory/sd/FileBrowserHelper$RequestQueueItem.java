/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.sd;

import de.vw.mib.genericevents.EventGeneric;

class FileBrowserHelper$RequestQueueItem {
    public int startIndex;
    public EventGeneric event;

    public FileBrowserHelper$RequestQueueItem(int n, EventGeneric eventGeneric) {
        this.startIndex = n;
        this.event = eventGeneric;
    }
}

