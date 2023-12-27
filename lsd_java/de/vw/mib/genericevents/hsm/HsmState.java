/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.hsm;

import de.vw.mib.genericevents.EventGeneric;

public interface HsmState {
    default public HsmState handle(EventGeneric eventGeneric) {
    }

    default public String getName() {
    }

    default public HsmState getParent() {
    }
}

