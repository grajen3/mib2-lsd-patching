/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.internal.dispatcher;

import de.vw.mib.bap.internal.dispatcher.BAPDispatcherTarget;

final class BAPDispatcherTarget$BAPHMIEventConsumer {
    private static final int LSG_ID_BIT_SIZE;
    private static final int ID_BIT_MAKS;
    public int lsgID;
    public int fctID;
    public int eventID;

    BAPDispatcherTarget$BAPHMIEventConsumer(int n, int n2, int n3) {
        this.lsgID = n;
        this.fctID = n2;
        this.eventID = n3;
    }

    public boolean equals(Object object) {
        boolean bl;
        if (object != null && (BAPDispatcherTarget.class$de$vw$mib$bap$internal$dispatcher$BAPDispatcherTarget$BAPHMIEventConsumer == null ? (BAPDispatcherTarget.class$de$vw$mib$bap$internal$dispatcher$BAPDispatcherTarget$BAPHMIEventConsumer = BAPDispatcherTarget.class$("de.vw.mib.bap.internal.dispatcher.BAPDispatcherTarget$BAPHMIEventConsumer")) : BAPDispatcherTarget.class$de$vw$mib$bap$internal$dispatcher$BAPDispatcherTarget$BAPHMIEventConsumer) == object.getClass()) {
            BAPDispatcherTarget$BAPHMIEventConsumer bAPDispatcherTarget$BAPHMIEventConsumer = (BAPDispatcherTarget$BAPHMIEventConsumer)object;
            bl = this.lsgID == bAPDispatcherTarget$BAPHMIEventConsumer.lsgID && this.fctID == bAPDispatcherTarget$BAPHMIEventConsumer.fctID && this.eventID == bAPDispatcherTarget$BAPHMIEventConsumer.eventID;
        } else {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return this.lsgID << 8 | this.fctID & 0xFF;
    }
}

