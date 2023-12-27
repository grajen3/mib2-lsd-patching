/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.sdars.StationInfo;

public final class SatTuneHandler {
    private final SatDb mDb;
    private final IAslPool mPool;

    public SatTuneHandler(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
    }

    public void tuneChannel(int n, StationInfo stationInfo, boolean bl, int n2, int n3) {
        if (stationInfo != null) {
            Object object;
            this.mPool.setInt(83, n);
            if (stationInfo.stationNumber != SatDb.getInstance().getListApi().getSatListModel().getCurrentChannel().stationNumber) {
                this.mPool.setBoolean(197, false);
                this.mPool.setBoolean(198, false);
            }
            boolean bl2 = false;
            int n4 = this.mPool.getInt(35);
            if (RadioCodingAdapter.isRadioTileFeatureActivated() && RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible() && n4 == 1 && !this.mDb.isChannelAvailableInChannelList((StationInfo)(object = SatDb.getInstance().getListApi().getSatListModel().getCurrentChannel()))) {
                bl2 = true;
            }
            this.mPool.setChannel(23, stationInfo);
            this.mPool.setChannel(15, stationInfo);
            if (bl2 && null != (object = RadioServiceManager.getServiceManager().getTileStationList())) {
                ((TileStationList)object).initTiles();
            }
            if (stationInfo.getStationNumber() == 0) {
                if (n2 != 0 && n3 != 0) {
                    object = this.mDb.newEvent();
                    ((EventGeneric)object).setReceiverEventId(n3);
                    ((EventGeneric)object).setReceiverTargetId(n2);
                    ((EventGeneric)object).setResult(16);
                    this.mDb.getMainTarget().send((EventGeneric)object);
                }
            } else if (stationInfo.subscription != 2) {
                this.mPool.setChannel(72, stationInfo);
            } else if (!SatDb.mLSMTuneFailed) {
                this.mDb.getDsiApi().selectStation(n2, n3, 4, (short)stationInfo.sID);
            }
        }
    }

    public void tuneChannel(int n, StationInfo stationInfo, boolean bl) {
        this.tuneChannel(n, stationInfo, bl, 0, 0);
    }

    public void tuneChannelSafe(int n, StationInfo stationInfo, boolean bl) {
        try {
            this.tuneChannel(n, stationInfo, bl, 0, 0);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public StationInfo getLSM() {
        LogMessage logMessage;
        StationInfo stationInfo = this.mPool.getChannel(23);
        if (null != stationInfo && (stationInfo.stationNumber == 0 || stationInfo.subscription != 2)) {
            ServiceManager.logger.info(512).append("SatTuneHandler - getLSM() - User channel Subscription:").append(stationInfo.subscription).log();
            stationInfo = this.mPool.getChannel(21);
        }
        if (null != stationInfo && stationInfo.subscription != 2) {
            ServiceManager.logger.info(512).append("SatTuneHandler - getLSM: Default channel is set ").log();
            stationInfo = SatConfig.DEFAULT_CHANNEL;
        }
        if ((logMessage = this.mDb.getLogHandler().getLogMsg()) != null && null != stationInfo) {
            logMessage.append("LSM=").append(stationInfo.toString()).log();
        }
        return stationInfo;
    }

    public StationInfo getPlaying() {
        LogMessage logMessage;
        StationInfo stationInfo = this.mPool.getChannel(21);
        if (stationInfo.stationNumber == 0) {
            ServiceManager.logger.info(512).append("SatTuneHandler - getPlaying: Default channel is set ").log();
            stationInfo = SatConfig.DEFAULT_CHANNEL;
        }
        if ((logMessage = this.mDb.getLogHandler().getLogMsg()) != null) {
            logMessage.append("LSM=").append(stationInfo.toString()).log();
        }
        return stationInfo;
    }
}

