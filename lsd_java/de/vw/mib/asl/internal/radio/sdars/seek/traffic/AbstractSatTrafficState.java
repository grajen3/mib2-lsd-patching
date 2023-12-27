/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek.traffic;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.helper.SatTuneHandler;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficWxTarget;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import org.dsi.ifc.sdars.StationInfo;

abstract class AbstractSatTrafficState
extends AbstractHsmState {
    protected final SatTrafficWxTarget mTarget;
    protected final IAslPool mPool;

    AbstractSatTrafficState(SatTrafficWxTarget satTrafficWxTarget, String string, AbstractHsmState abstractHsmState) {
        super(satTrafficWxTarget.getHsm(), string, abstractHsmState);
        this.mPool = satTrafficWxTarget.getDb().getPool();
        this.mTarget = satTrafficWxTarget;
    }

    SatLogHandler getLogHandler() {
        return this.mTarget.getDb().getLogHandler();
    }

    SatModelApi getModelApi() {
        return this.mTarget.getDb().getModelApi();
    }

    SatTuneHandler getTuneHandler() {
        return this.mTarget.getDb().getTuneHandler();
    }

    ChannelListFromSouth getChannels() {
        return this.mTarget.getDb().getChannels();
    }

    StationInfo getCurrentChannel() {
        return this.mPool.getChannel(23);
    }
}

