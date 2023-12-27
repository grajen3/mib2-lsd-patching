/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.list;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.IChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.ImageDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.list.SatListTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.StationInfo;

public final class SatListModel {
    private final SatListTarget mTarget;
    private final SatDb mDb;
    private final IAslPool mPool;
    private StationInfo mLastTunedStationByUser;
    private static boolean SET_CHANNEL_INDEX_DELAYED = true;

    SatListModel(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mTarget = new SatListTarget(this.mDb, this.mDb.getMainTarget(), this);
        this.mTarget.trace("Module SDARS List started.");
    }

    void trigger(int n) {
        try {
            this.mTarget.triggerMe(n);
        }
        catch (GenericEventException genericEventException) {
            // empty catch block
        }
    }

    boolean isShown() {
        return this.mTarget.isShown();
    }

    public void updateCategories(CategoryInfo[] categoryInfoArray) {
        SatLogHandler satLogHandler = this.mDb.getLogHandler();
        LogMessage logMessage = satLogHandler.getLogMsg();
        if (logMessage != null) {
            logMessage.append("RADIO_SAT_CATEGORY_LIST_INFO: ").log();
            for (int i2 = 0; i2 < categoryInfoArray.length; ++i2) {
                logMessage = satLogHandler.getLogMsg();
                if (logMessage == null) continue;
                satLogHandler.dumpCategory(logMessage, categoryInfoArray[i2]).log();
            }
        }
        SatModelApi satModelApi = this.mDb.getModelApi();
        satModelApi.updateCategoryListInfo(categoryInfoArray);
    }

    public void notifyCategorySubItemListToHmi(IChannelWalker iChannelWalker) {
        StationInfo[] stationInfoArray = iChannelWalker.getArray();
        StationInfo[] stationInfoArray2 = new StationInfo[]{};
        StationInfo[] stationInfoArray3 = new StationInfo[stationInfoArray.length];
        ImageDb imageDb = this.mDb.getImageDb();
        if (null != imageDb) {
            for (int i2 = 0; i2 < stationInfoArray3.length; ++i2) {
                int n = stationInfoArray[i2].sID;
                ResourceLocator resourceLocator = imageDb.getImage(n);
                stationInfoArray3[i2] = new StationInfo(stationInfoArray[i2].stationNumber, n, stationInfoArray[i2].shortLabel, stationInfoArray[i2].fullLabel, stationInfoArray[i2].subscription, stationInfoArray[i2].categoryNumber, stationInfoArray[i2].mature, resourceLocator);
            }
            SatModelApi satModelApi = this.mDb.getModelApi();
            if (null != satModelApi) {
                if (this.mDb.isChannelSorting()) {
                    satModelApi.updateCategoryListSubItemInfo(stationInfoArray2);
                    this.notifyChannelListIndex(iChannelWalker.getCursorIndex());
                    satModelApi.updateCategoryListSubItemInfo(stationInfoArray3);
                } else {
                    satModelApi.updateCategoryListSubItemInfo(stationInfoArray3);
                    this.notifyChannelListIndex(iChannelWalker.getCursorIndex());
                }
            }
        }
    }

    public void notifyChannelListToHmi(IChannelWalker iChannelWalker) {
        StationInfo[] stationInfoArray = iChannelWalker.getArray();
        StationInfo[] stationInfoArray2 = new StationInfo[]{};
        StationInfo[] stationInfoArray3 = new StationInfo[stationInfoArray.length];
        ImageDb imageDb = this.mDb.getImageDb();
        if (null != imageDb) {
            for (int i2 = 0; i2 < stationInfoArray3.length; ++i2) {
                int n = stationInfoArray[i2].sID;
                ResourceLocator resourceLocator = imageDb.getImage(n);
                stationInfoArray3[i2] = new StationInfo(stationInfoArray[i2].stationNumber, n, stationInfoArray[i2].shortLabel, stationInfoArray[i2].fullLabel, stationInfoArray[i2].subscription, stationInfoArray[i2].categoryNumber, stationInfoArray[i2].mature, resourceLocator);
            }
            SatModelApi satModelApi = this.mDb.getModelApi();
            if (null != satModelApi) {
                if (this.mDb.isChannelSorting()) {
                    satModelApi.updateChannelListItemInfo(stationInfoArray2);
                    this.notifyChannelListIndex(iChannelWalker.getCursorIndex());
                    satModelApi.updateChannelListItemInfo(stationInfoArray3);
                } else {
                    satModelApi.updateChannelListItemInfo(stationInfoArray3);
                    this.notifyChannelListIndex(iChannelWalker.getCursorIndex());
                }
            }
        }
    }

    private void notifyChannelListIndex(int n) {
        if (this.mDb.isChannelSorting()) {
            this.mPool.setInt(154, n);
        } else if (SET_CHANNEL_INDEX_DELAYED) {
            int n2 = this.mTarget.getTargetId();
            EventGeneric eventGeneric = this.mTarget.getEventFactory().newEvent(n2, n2, 1820786944);
            eventGeneric.setInt(0, n);
            this.mTarget.triggerMe(eventGeneric, 1820786944);
        } else {
            this.mPool.setInt(154, n);
        }
    }

    public StationInfo getLastTunedStationByUser() {
        return this.mLastTunedStationByUser;
    }

    public void setLastTunedStationByUser(StationInfo stationInfo) {
        this.mLastTunedStationByUser = stationInfo;
    }

    public StationInfo getCurrentChannel() {
        StationInfo stationInfo = this.mPool.getChannel(23);
        if (stationInfo.getStationNumber() == 0) {
            stationInfo = this.mPool.getChannel(21);
        }
        return stationInfo;
    }
}

