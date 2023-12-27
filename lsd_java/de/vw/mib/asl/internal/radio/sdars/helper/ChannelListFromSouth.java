/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.LogUtil;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth$1;
import de.vw.mib.asl.internal.radio.sdars.helper.ImageDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.helper.SatUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.log4mib.LogMessage;
import java.util.Iterator;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public final class ChannelListFromSouth
implements IAslPoolListener {
    private final SatDb mDb;
    private final IAslPool mPool;
    protected StationInfo[] mArray = new StationInfo[0];
    private final IntObjectOptHashMap mFastAccessByNumberMap = new IntObjectOptHashMap();
    private final IntObjectOptHashMap mFastAccessBySIDMap = new IntObjectOptHashMap();
    private final IntOptHashSet mInvalidChannels = new IntOptHashSet();

    public ChannelListFromSouth(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mPool.addListener(162, (IAslPoolListener)this);
    }

    public void setChannelList(StationInfo[] stationInfoArray) {
        StationInfo stationInfo;
        StationInfo stationInfo2;
        if (stationInfoArray == null) {
            if (this.mArray.length > 0) {
                this.mArray = new StationInfo[0];
            }
        } else {
            int n;
            int n2 = 0;
            for (n = 0; n < stationInfoArray.length; ++n) {
                if (stationInfoArray[n] == null) continue;
                ++n2;
            }
            if (n2 == stationInfoArray.length) {
                this.mArray = stationInfoArray;
            } else {
                this.mArray = new StationInfo[n2];
                n = 0;
                for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                    if (stationInfoArray[i2] == null) continue;
                    this.mArray[n++] = stationInfoArray[i2];
                }
            }
        }
        this.mInvalidChannels.clear();
        LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
        if (logMessage != null) {
            logMessage.append("ChannelList received, count = ").append(this.mArray.length).log();
        }
        this.updateElectronicSerialCode();
        this.recalc();
        StationInfo stationInfo3 = this.mPool.getChannel(21);
        if (stationInfo3 == null) {
            stationInfo2 = this.getChannel(1);
            if (stationInfo2 != null && this.mArray.length > 0) {
                ServiceManager.logger.info(512).append("ChannelListFromSouth - setChannelList: Playing channel is null ").log();
                this.mDb.getTuneHandler().tuneChannelSafe(7, stationInfo2, false);
            }
        } else {
            stationInfo2 = this.getChannel(stationInfo3.getStationNumber());
            if (stationInfo2 == null || stationInfo2.getSubscription() != 2) {
                if (stationInfo2 == null) {
                    ServiceManager.logger.info(512).append("ChannelListFromSouth - setChannelList: Playing channel is not available in list ").log();
                } else {
                    ServiceManager.logger.info(512).append("ChannelListFromSouth: Playing channel subscription").append(stationInfo2.getSubscription()).append("default channel set").log();
                }
                stationInfo = this.getChannel(1);
                if (stationInfo != null) {
                    this.mDb.getTuneHandler().tuneChannelSafe(7, stationInfo, false);
                }
            }
        }
        this.mDb.getLogHandler().printChannelStatistic();
        this.updateDefaultChannel();
        this.updateZeroChannel();
        stationInfo2 = this.mPool.getChannel(15);
        stationInfo = this.mPool.getChannel(23);
        for (int i3 = 0; i3 < this.mArray.length; ++i3) {
            if (this.mArray[i3] == null) continue;
            if (stationInfo2 != null && this.mArray[i3].getSID() == stationInfo2.sID) {
                this.mPool.setChannel(15, this.mArray[i3]);
            }
            if (stationInfo3 != null && this.mArray[i3].getSID() == stationInfo3.sID) {
                this.mPool.setChannel(21, this.mArray[i3]);
            }
            if (stationInfo == null || this.mArray[i3].getSID() != stationInfo.sID) continue;
            this.mPool.setChannel(23, this.mArray[i3]);
        }
        this.mPool.setObjectArray(54, this.mArray);
        this.mDb.getFilterListApi().channelListFilterDefaultSetting();
    }

    private void recalc() {
        this.mFastAccessByNumberMap.clear();
        this.mFastAccessBySIDMap.clear();
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            this.mFastAccessByNumberMap.put(this.mArray[i2].getStationNumber(), this.mArray[i2]);
            this.mFastAccessBySIDMap.put(this.mArray[i2].getSID(), this.mArray[i2]);
        }
    }

    private void updateDefaultChannel() {
        StationInfo stationInfo = this.getChannel(1);
        if (stationInfo != null) {
            SatConfig.DEFAULT_CHANNEL.categoryNumber = stationInfo.categoryNumber;
            SatConfig.DEFAULT_CHANNEL.fullLabel = stationInfo.fullLabel;
            SatConfig.DEFAULT_CHANNEL.shortLabel = stationInfo.shortLabel;
            SatConfig.DEFAULT_CHANNEL.mature = stationInfo.mature;
            SatConfig.DEFAULT_CHANNEL.sID = stationInfo.sID;
            if (SatUtil.isValid(stationInfo.channelArt)) {
                SatConfig.DEFAULT_CHANNEL.channelArt = stationInfo.channelArt;
            }
        }
    }

    private void updateZeroChannel() {
        StationInfo stationInfo = this.getChannel(0);
        if (stationInfo != null) {
            SatConfig.ZERO_CHANNEL.categoryNumber = stationInfo.categoryNumber;
            SatConfig.ZERO_CHANNEL.fullLabel = stationInfo.fullLabel;
            SatConfig.ZERO_CHANNEL.shortLabel = stationInfo.shortLabel;
            SatConfig.ZERO_CHANNEL.mature = stationInfo.mature;
            SatConfig.ZERO_CHANNEL.sID = stationInfo.sID;
            if (SatUtil.isValid(stationInfo.channelArt)) {
                SatConfig.ZERO_CHANNEL.channelArt = stationInfo.channelArt;
            }
        }
    }

    public int getChannelCount() {
        return this.mArray.length;
    }

    public int getChannelCountForCategory(int n, ChannelFilter[] channelFilterArray) {
        this.mDb.getCategories().getCategoryChannelFilter().setCategory(n);
        int n2 = 0;
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (!this.check(this.mArray[i2], channelFilterArray)) continue;
            ++n2;
        }
        return n2;
    }

    public boolean check(StationInfo stationInfo, ChannelFilter[] channelFilterArray) {
        if (stationInfo != null) {
            if (channelFilterArray != null) {
                for (int i2 = 0; i2 < channelFilterArray.length; ++i2) {
                    if (channelFilterArray[i2].checkChannel(stationInfo)) continue;
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public StationInfo getChannel(int n) {
        return (StationInfo)this.mFastAccessByNumberMap.get(n);
    }

    public void log() {
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mArray[i2] == null) continue;
            LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage == null) break;
            logMessage.append(LogUtil.fixLength(Integer.toString(i2), 3, true));
            logMessage.append(" Channel ");
            logMessage.append(LogUtil.fixLength(Integer.toString(this.mArray[i2].stationNumber), 3, true));
            logMessage.append(": ");
            logMessage.append(this.mArray[i2].fullLabel == null ? "?" : this.mArray[i2].fullLabel);
            logMessage.log();
        }
    }

    public Iterator iterator() {
        return new ChannelListFromSouth$1(this);
    }

    public StationInfo[] getArray() {
        return this.mArray;
    }

    private void updateElectronicSerialCode() {
        String string = this.mPool.getString(162);
        if (string.length() > 0) {
            RadioText radioText = new RadioText(0, "SiriusXM ID", "SiriusXM ID", "", string, string, "", "", 0);
            this.mDb.getRadioTextHandler().put(radioText);
        }
    }

    public StationInfo getChannelBySID(int n) {
        return (StationInfo)this.mFastAccessBySIDMap.get(n);
    }

    public void deleteChannelBySID(int n) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mArray[i2] == null || this.mArray[i2].getSID() == n) continue;
            ++n2;
        }
        StationInfo[] stationInfoArray = new StationInfo[n2];
        int n3 = 0;
        for (int i3 = 0; i3 < this.mArray.length; ++i3) {
            if (this.mArray[i3] == null || this.mArray[i3].getSID() == n) continue;
            stationInfoArray[n3++] = this.mArray[i3];
        }
        this.mArray = stationInfoArray;
        this.recalc();
    }

    public boolean isValid() {
        return this.mArray.length > 0;
    }

    public int size() {
        return this.mArray.length;
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 162: {
                this.updateElectronicSerialCode();
                break;
            }
        }
    }

    public void addInvalidChannel(int n) {
        this.mInvalidChannels.add(n);
    }

    public void removeInvalidChannel(int n) {
        this.mInvalidChannels.remove(n);
    }

    public boolean isInvalid(int n) {
        return this.mInvalidChannels.contains(n);
    }

    public boolean isChannelValid(int n) {
        return this.mFastAccessBySIDMap.containsKey(n);
    }

    public void storeChannelArt(ImageInformation[] imageInformationArray) {
        try {
            if (null == imageInformationArray) {
                ServiceManager.logger.error(512).append("ChannelListFromSouth - storeChannelArt() - null == imageInfos").log();
                return;
            }
            ImageDb imageDb = this.mDb.getImageDb();
            if (null != imageDb) {
                for (int i2 = 0; i2 < imageInformationArray.length; ++i2) {
                    if (imageInformationArray[i2] == null) continue;
                    imageDb.addImage(imageInformationArray[i2].sID, imageInformationArray[i2].image);
                }
                SatModelApi satModelApi = this.mDb.getModelApi();
                StationInfo stationInfo = this.mPool.getChannel(15);
                StationInfo[] stationInfoArray = (StationInfo[])this.mPool.getObjectArray(213);
                int n = this.mPool.getInt(154);
                int n2 = this.mPool.getInt(150);
                this.mDb.getHmiUpdater().updateCurrentChannel(false);
                if (n != -1) {
                    if (n2 == 0) {
                        satModelApi.updateCurrentCategoryListSubItemInfo(n, stationInfo);
                    } else {
                        satModelApi.updateCurrentChannelListItem(n, stationInfo);
                    }
                } else if (stationInfoArray.length > 0 && n2 == 0) {
                    satModelApi.updateCurrentCategoryListSubItemInfo(0, stationInfoArray[0]);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

