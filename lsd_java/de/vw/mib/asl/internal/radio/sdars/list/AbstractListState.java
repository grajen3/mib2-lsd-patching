/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.list;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.HmiUpdater;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.helper.SatPersistable;
import de.vw.mib.asl.internal.radio.sdars.list.SatListModel;
import de.vw.mib.asl.internal.radio.sdars.list.SatListTarget;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

abstract class AbstractListState
extends AbstractHsmState {
    protected final SatDb mDb;
    protected final SatListTarget mTarget;
    protected final IAslPool mPool;

    public AbstractListState(SatDb satDb, SatListTarget satListTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mTarget = satListTarget;
    }

    protected SatPersistable getPersistable() {
        return this.mDb.getPersistable();
    }

    protected SatListModel getModel() {
        return this.mTarget.getModel();
    }

    protected HmiUpdater getHmiUpdater() {
        return this.mDb.getHmiUpdater();
    }

    protected SatLogHandler getLogHandler() {
        return this.mDb.getLogHandler();
    }

    protected SatModelApi getModelApi() {
        return this.mDb.getModelApi();
    }
}

