/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.IChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import org.dsi.ifc.sdars.StationInfo;

public final class PreviewHandler
implements IAslPoolListener {
    private final SatDb mDb;
    private IChannelWalker mWalker;
    private final IAslPool mPool;

    public PreviewHandler(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mPool.addListener(22, (IAslPoolListener)this);
        this.mPool.addListener(19, (IAslPoolListener)this);
        this.mPool.addListener(23, (IAslPoolListener)this);
        this.mPool.addListener(24, (IAslPoolListener)this);
        this.mPool.addListener(150, (IAslPoolListener)this);
        this.mPool.addListener(30, (IAslPoolListener)this);
        this.mPool.addListener(29, (IAslPoolListener)this);
        this.mPool.addListener(31, (IAslPoolListener)this);
        this.mPool.addListener(32, (IAslPoolListener)this);
        this.mPool.addListener(151, (IAslPoolListener)this);
        this.mPool.addListener(149, (IAslPoolListener)this);
        this.mPool.addListener(76, (IAslPoolListener)this);
        this.mPool.addListener(75, (IAslPoolListener)this);
        this.mPool.addListener(77, (IAslPoolListener)this);
    }

    public void start(ChannelFilter channelFilter) {
        ChannelFilter[] channelFilterArray = new ChannelFilter[]{SatConfig.FILTER_VALIDITY, channelFilter, SatConfig.FILTER_SUBSCRIPTION};
        this.mWalker = new ChannelWalker(this.mDb, "PreviewWalker", channelFilterArray, true);
        this.mWalker.setSorting(SatConfig.COMP_NO);
    }

    public StationInfo getPreviewChannel() {
        return this.mPool.getChannel(22);
    }

    public void handleDDS(int n) {
        StationInfo stationInfo = this.mWalker.step(n);
        this.mPool.setChannel(22, stationInfo);
    }

    private void calcVirtualChannelBrowsedPlaying(IAslPool iAslPool, StationInfo stationInfo, StationInfo stationInfo2) {
        boolean bl = stationInfo2 != null && stationInfo != null && stationInfo2.sID == stationInfo.sID;
        iAslPool.setBoolean(148, bl);
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 22: {
                StationInfo stationInfo;
                StationInfo stationInfo2 = iAslPoolRecord.getChannel();
                if (stationInfo2 == null) {
                    iAslPool.setBoolean(149, false);
                    stationInfo = iAslPool.getChannel(23);
                    iAslPool.setChannel(15, stationInfo);
                } else {
                    iAslPool.setBoolean(149, true);
                    this.mWalker.setCursor(stationInfo2.stationNumber);
                    iAslPool.setChannel(15, stationInfo2);
                }
                stationInfo = iAslPool.getChannel(19);
                this.calcVirtualChannelBrowsedPlaying(iAslPool, stationInfo, stationInfo2);
                break;
            }
            case 149: {
                boolean bl = iAslPoolRecord.getBoolean();
                if (!bl) break;
                StationInfo stationInfo = iAslPool.getChannel(15);
                short s = stationInfo.getStationNumber();
                this.mWalker.setCursor(s);
                break;
            }
            case 19: {
                StationInfo stationInfo = iAslPoolRecord.getChannel();
                StationInfo stationInfo3 = iAslPool.getChannel(22);
                this.calcVirtualChannelBrowsedPlaying(iAslPool, stationInfo, stationInfo3);
                break;
            }
            case 23: {
                iAslPool.setChannel(22, null);
                if (this.mWalker == null) break;
                StationInfo stationInfo = iAslPoolRecord.getChannel();
                this.mWalker.setCursor(stationInfo.getStationNumber());
                break;
            }
            case 24: {
                if (this.mWalker == null) break;
                this.mWalker.fill();
                break;
            }
            case 150: {
                break;
            }
            case 29: 
            case 30: 
            case 31: 
            case 32: {
                boolean bl = iAslPoolRecord.getBoolean();
                if (!bl) break;
                iAslPool.setChannel(22, null);
                break;
            }
            case 75: 
            case 76: 
            case 77: 
            case 151: {
                iAslPool.setChannel(22, null);
                break;
            }
        }
    }
}

