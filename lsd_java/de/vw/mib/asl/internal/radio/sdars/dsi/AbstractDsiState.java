/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import de.vw.mib.asl.internal.radio.sdars.helper.HmiUpdater;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

abstract class AbstractDsiState
extends AbstractHsmState {
    protected final SatDb mDb;
    protected final IAslPool mPool;
    protected final SatDsiTarget mTarget;

    public AbstractDsiState(SatDb satDb, SatDsiTarget satDsiTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mTarget = satDsiTarget;
    }

    protected ChannelListFromSouth getChannels() {
        return this.mDb.getChannels();
    }

    protected HmiUpdater getHmiUpdater() {
        return this.mDb.getHmiUpdater();
    }

    protected SatLogHandler getLogHandler() {
        return this.mDb.getLogHandler();
    }
}

