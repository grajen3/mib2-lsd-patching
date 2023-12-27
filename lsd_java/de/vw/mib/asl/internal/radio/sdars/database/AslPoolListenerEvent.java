/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.database.AslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.genericevents.EventGeneric;

final class AslPoolListenerEvent
extends AslPoolListener {
    private final int mTID;
    private final int mEID;

    AslPoolListenerEvent(int n, int n2, int n3) {
        super(n);
        this.mTID = n2;
        this.mEID = n3;
    }

    @Override
    void notifyUpdate(IAslPool iAslPool, IAslPoolRecord iAslPoolRecord) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_SDARS_MAIN_TARGET);
        eventGeneric.setReceiverTargetId(this.mTID);
        eventGeneric.setReceiverEventId(this.mEID);
        eventGeneric.setObject(0, iAslPoolRecord);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public int hashCode() {
        int n = 31;
        int n2 = super.hashCode();
        n2 = 31 * n2 + this.mEID;
        n2 = 31 * n2 + this.mTID;
        return n2;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AslPoolListenerEvent aslPoolListenerEvent = (AslPoolListenerEvent)object;
        if (this.mEID != aslPoolListenerEvent.mEID) {
            return false;
        }
        return this.mTID == aslPoolListenerEvent.mTID;
    }
}

