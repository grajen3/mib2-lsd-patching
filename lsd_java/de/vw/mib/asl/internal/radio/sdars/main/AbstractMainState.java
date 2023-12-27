/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.AudioManager;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import de.vw.mib.asl.internal.radio.sdars.helper.HmiUpdater;
import de.vw.mib.asl.internal.radio.sdars.helper.IChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.PreviewHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.helper.SatPersistable;
import de.vw.mib.asl.internal.radio.sdars.helper.SatTuneHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.StatusHandler;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

abstract class AbstractMainState
extends AbstractHsmState {
    protected final SatDb mDb;
    protected final IAslPool mPool;
    protected final SatMainTarget mTarget;

    public AbstractMainState(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mTarget = satMainTarget;
    }

    protected SatPersistable getPersistable() {
        return this.mDb.getPersistable();
    }

    protected HmiUpdater getHmiUpdater() {
        return this.mDb.getHmiUpdater();
    }

    protected StatusHandler getStatusHandler() {
        return this.mDb.getStatusHandler();
    }

    protected PreviewHandler getPreviewHandler() {
        return this.mDb.getPreviewHandler();
    }

    protected IChannelWalker getMainChannelWalker() {
        return this.mDb.getMainChannelWalker();
    }

    protected ChannelListFromSouth getChannels() {
        return this.mDb.getChannels();
    }

    protected AudioManager getAudioManager() {
        return this.mDb.getAudioManager();
    }

    protected SatLogHandler getLogHandler() {
        return this.mDb.getLogHandler();
    }

    protected SatModelApi getModelApi() {
        return this.mDb.getModelApi();
    }

    protected SatTuneHandler getTuneHandler() {
        return this.mDb.getTuneHandler();
    }
}

