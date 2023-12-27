/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.common;

import de.vw.mib.genericevents.EventGeneric;

public interface ModelView {
    default public void handleAction(EventGeneric eventGeneric) {
    }

    default public int[] getSupportedActions() {
    }
}

