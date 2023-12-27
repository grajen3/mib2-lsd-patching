/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import de.vw.mib.asl.internal.radio.sdars.helper.IChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.TrafficApi;
import de.vw.mib.genericevents.GenericEventException;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCurrentChannelInfoCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

public final class HmiUpdater
implements IAslPoolListener {
    private final SatDb mDb;
    private final IAslPool mPool;

    public HmiUpdater(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mPool.addListener(54, (IAslPoolListener)this);
        this.mPool.addListener(79, (IAslPoolListener)this);
        this.mPool.addListener(15, (IAslPoolListener)this);
        this.mPool.addListener(26, (IAslPoolListener)this);
        this.mPool.addListener(25, (IAslPoolListener)this);
        this.mPool.addListener(14, (IAslPoolListener)this);
        this.mPool.addListener(34, (IAslPoolListener)this);
        this.mPool.addListener(81, (IAslPoolListener)this);
        this.mPool.addListener(156, (IAslPoolListener)this);
        this.mPool.addListener(147, (IAslPoolListener)this);
        this.mPool.addListener(19, (IAslPoolListener)this);
        this.mPool.addListener(38, (IAslPoolListener)this);
    }

    public void updateCurrentChannel(boolean bl) {
        SatModelApi satModelApi = this.mDb.getModelApi();
        this.mPool.incInt(63);
        StationInfo stationInfo = this.mPool.getChannel(15);
        if (stationInfo != null) {
            short s = stationInfo.getStationNumber();
            RadioSATCurrentChannelInfoCollector[] radioSATCurrentChannelInfoCollectorArray = new RadioSATCurrentChannelInfoCollector[1];
            ResourceLocator resourceLocator = this.mDb.getImageDb().getImage(stationInfo.sID);
            radioSATCurrentChannelInfoCollectorArray[0] = new RadioSATCurrentChannelInfoCollector();
            if (stationInfo.getSID() == 0) {
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__channel000information = this.mPool.getString(47);
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__logo = resourceLocator;
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__name = "SiriusXM ID";
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__short_name = "";
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__number = 0;
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__status = 0;
            } else {
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__channel000information = "";
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__logo = resourceLocator;
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__name = stationInfo.fullLabel;
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__short_name = stationInfo.shortLabel;
                int n = this.mPool.getInt(34);
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__status = stationInfo.stationNumber < 0 || stationInfo.stationNumber > 999 || stationInfo.getSID() == n ? 1 : (stationInfo.stationNumber == 0 ? 0 : (stationInfo.subscription != 2 ? 2 : 0));
                radioSATCurrentChannelInfoCollectorArray[0].radio_sat_current_channel_info__number = s;
            }
            satModelApi.updateCurrentChannelInfo(radioSATCurrentChannelInfoCollectorArray, bl);
            this.mPool.setResourceLocator(180, resourceLocator);
            if (TrafficApi.jump != 0 && TrafficApi.jump != stationInfo.sID && TrafficApi.isJumped) {
                TrafficApi.isJumped = false;
                this.mPool.setInt(173, 0);
                TrafficApi.jumpCancelled = true;
            }
        }
    }

    public void prepareBapList() {
        IChannelWalker iChannelWalker = this.mDb.getBapChannelWalker();
        iChannelWalker.fill();
        StationInfo[] stationInfoArray = iChannelWalker.getArray();
        this.mDb.getModelApi().updateBapChannelList(stationInfoArray);
    }

    private static String getShortLabel(StationInfo stationInfo) {
        if (stationInfo != null) {
            if (stationInfo.shortLabel != null && stationInfo.shortLabel.length() > 0) {
                return stationInfo.shortLabel;
            }
            if (stationInfo.fullLabel != null && stationInfo.fullLabel.length() > 0) {
                return stationInfo.fullLabel;
            }
        }
        return "";
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        block1 : switch (n) {
            case 15: {
                String string = "";
                StationInfo stationInfo = iAslPoolRecord.getChannel();
                if (stationInfo == null) break;
                this.updateCurrentChannel(false);
                string = HmiUpdater.getShortLabel(stationInfo);
                iAslPool.setString(146, string);
                this.mDb.getModelApi().updateBapCurrentStationIndices(stationInfo.getSID());
                break;
            }
            case 79: {
                this.updateCurrentChannel(false);
                break;
            }
            case 38: {
                boolean bl = iAslPoolRecord.getBoolean();
                if (!bl) break;
                this.mDb.getHmiUpdater().prepareBapList();
                break;
            }
            case 19: {
                SatMainTarget satMainTarget = this.mDb.getMainTarget();
                if (satMainTarget != null) {
                    satMainTarget.startTimerCheckPlayingChannel();
                }
                this.updateCurrentChannel(false);
                break;
            }
            case 25: {
                iAslPool.copy(25, 161);
                break;
            }
            case 26: {
                iAslPool.copy(26, 140);
                break;
            }
            case 54: {
                this.updateCurrentChannel(false);
                break;
            }
            case 147: {
                int n2 = iAslPoolRecord.getInt();
                if (n2 != 1) break;
                this.updateCurrentChannel(true);
                break;
            }
            case 34: {
                int n3 = iAslPoolRecord.getInt();
                if (n3 != 0) {
                    ChannelListFromSouth channelListFromSouth = this.mDb.getChannels();
                    StationInfo stationInfo = channelListFromSouth.getChannelBySID(n3);
                    if (stationInfo == null && (stationInfo = this.mDb.getPresetApi().findStation(n3)) != null) break;
                    if (stationInfo != null) {
                        int n4 = this.mPool.getInt(83);
                        switch (n4) {
                            case 0x4000044F: 
                            case 1073742930: 
                            case 1073742971: 
                            case 1073742974: {
                                this.mDb.getMainChannelWalker().setCursor(stationInfo.getStationNumber());
                                try {
                                    this.mDb.getMainTarget().triggerMe(n4);
                                }
                                catch (GenericEventException genericEventException) {}
                                break block1;
                            }
                            case 16: 
                            case 17: {
                                break block1;
                            }
                        }
                        this.mPool.setChannel(72, stationInfo);
                        break;
                    }
                    stationInfo = this.mDb.getTuneHandler().getPlaying();
                    if (stationInfo == null) break;
                    this.mDb.getTuneHandler().tuneChannelSafe(6, stationInfo, false);
                    break;
                }
                this.updateCurrentChannel(false);
                break;
            }
            case 81: {
                int n5 = iAslPoolRecord.getInt();
                if (n5 == 0) break;
                StationInfo stationInfo = this.mDb.getChannels().getChannelBySID(n5);
                if (stationInfo != null) {
                    stationInfo.subscription = 1;
                    this.mPool.setChannel(72, stationInfo);
                    break;
                }
                StationInfo stationInfo2 = this.mPool.getChannel(15);
                if (null == stationInfo2) break;
                stationInfo2.subscription = 1;
                this.mPool.setChannel(72, stationInfo2);
                break;
            }
            case 156: {
                break;
            }
        }
    }
}

