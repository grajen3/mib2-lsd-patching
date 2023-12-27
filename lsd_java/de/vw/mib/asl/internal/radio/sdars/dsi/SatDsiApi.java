/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public final class SatDsiApi {
    public static final int RESULT_TIMEOUT;
    private final SatDb mDb;
    private SatDsiTarget mTarget;

    public SatDsiApi(SatDb satDb) {
        this.mDb = satDb;
    }

    public void start(GenericEvents genericEvents, int n, String string) {
        this.mTarget = new SatDsiTarget(this.mDb, genericEvents, n, string);
    }

    public void stop() {
        if (this.mTarget != null) {
            this.mTarget.unregister();
            this.mTarget = null;
        }
    }

    public void activate() {
        EventGeneric eventGeneric = this.mDb.newEvent();
        eventGeneric.setReceiverEventId(92733696);
        this.send(eventGeneric);
    }

    public void deactivate() {
        EventGeneric eventGeneric = this.mDb.newEvent();
        eventGeneric.setReceiverEventId(109510912);
        this.send(eventGeneric);
    }

    public void selectStation(int n, int n2, int n3, short s) {
        EventGeneric eventGeneric = this.mDb.newEvent();
        eventGeneric.setReceiverEventId(159842560);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setInt(0, n3);
        eventGeneric.setShort(1, s);
        this.send(eventGeneric);
    }

    public void reset(int n) {
        EventGeneric eventGeneric = this.mDb.newEvent();
        eventGeneric.setReceiverEventId(-1501167360);
        eventGeneric.setInt(0, n);
        this.send(eventGeneric);
    }

    private void send(EventGeneric eventGeneric) {
        eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_SDARS_DSI_TARGET);
        this.mDb.getMainTarget().send(eventGeneric);
    }
}

