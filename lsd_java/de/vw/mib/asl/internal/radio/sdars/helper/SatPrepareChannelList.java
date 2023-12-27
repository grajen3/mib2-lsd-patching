/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.filterlist.SatFilterListApi;
import de.vw.mib.asl.internal.radio.sdars.helper.CategoryWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.list.SatListApi;
import de.vw.mib.asl.internal.radio.sdars.list.SatListModel;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.StationInfo;

public class SatPrepareChannelList {
    private final SatDb mSatDb;
    private final IAslPool mPool;
    private CategoryWalker mCategoryWalker;
    private ChannelWalker mChannelWalkerNo;
    private ChannelWalker mChannelWalkerName;
    private ChannelWalker mChannelWalker;

    public SatPrepareChannelList(SatDb satDb, IAslPool iAslPool) {
        this.mSatDb = satDb;
        this.mPool = iAslPool;
        this.mCategoryWalker = new CategoryWalker(satDb, false, false, false, satDb.getTreeChannelFilterArray());
        this.mChannelWalker = new ChannelWalker(satDb, "ListCategoryWalker", false);
        this.mChannelWalker.setFilter(satDb.getTreeChannelFilterArray());
        this.mChannelWalker.setSorting(SatConfig.COMP_NO);
        this.mChannelWalkerNo = new ChannelWalker(satDb, "ListNumberWalker", false);
        this.mChannelWalkerNo.setFilter(satDb.getFlatFilterArray());
        this.mChannelWalkerNo.setSorting(SatConfig.COMP_NO);
        this.mChannelWalkerName = new ChannelWalker(satDb, "ListNameWalker", false);
        this.mChannelWalkerName.setFilter(satDb.getFlatFilterArray());
        this.mChannelWalkerName.setSorting(SatConfig.COMP_NAME);
    }

    public void updateChannelListNo() {
        if (null != this.mChannelWalker && null != this.mSatDb && null != this.mChannelWalkerNo) {
            StationInfo stationInfo;
            this.mChannelWalker.fill();
            SatListModel satListModel = this.mSatDb.getListApi().getSatListModel();
            if (null != satListModel && null != (stationInfo = satListModel.getCurrentChannel())) {
                this.mChannelWalkerNo.setCursor(stationInfo.getStationNumber());
                satListModel.notifyChannelListToHmi(this.mChannelWalkerNo);
            }
        }
    }

    public void completeUpdate() {
        SatListModel satListModel = this.mSatDb.getListApi().getSatListModel();
        StationInfo stationInfo = satListModel.getCurrentChannel();
        this.mCategoryWalker.fill(false, false, false, this.mSatDb.getTreeChannelFilterArray());
        short s = stationInfo.getCategoryNumber();
        this.mCategoryWalker.setCurrentByNo(s);
        this.notifyCategoryListToHmi();
        this.mSatDb.getCategories().getCategoryChannelFilter().setCategory(s);
        this.mChannelWalker.fill();
        this.mChannelWalker.setCursor(stationInfo.getStationNumber());
        satListModel.notifyCategorySubItemListToHmi(this.mChannelWalker);
    }

    public void showCurrentChannel() {
        if (null != this.mCategoryWalker && null != this.mSatDb && null != this.mChannelWalker) {
            short s;
            StationInfo stationInfo;
            SatListModel satListModel;
            this.mCategoryWalker.fill(false, false, false, this.mSatDb.getTreeChannelFilterArray());
            boolean bl = false;
            SatListApi satListApi = this.mSatDb.getListApi();
            if (null != satListApi && null != (satListModel = satListApi.getSatListModel()) && null != (stationInfo = satListModel.getCurrentChannel()) && (s = stationInfo.getCategoryNumber()) != this.mCategoryWalker.getCurrentNo()) {
                this.mCategoryWalker.setCurrentByNo(s);
                bl = true;
                if (null != this.mSatDb.getCategories() && null != this.mSatDb.getCategories().getCategoryChannelFilter()) {
                    this.mSatDb.getCategories().getCategoryChannelFilter().setCategory(s);
                    this.mChannelWalker.fill();
                }
                this.mChannelWalker.setCursor(stationInfo.getStationNumber());
                if (bl) {
                    this.notifyCategoryListToHmi();
                }
                satListModel.notifyCategorySubItemListToHmi(this.mChannelWalker);
            }
        }
    }

    public void updateOpenCategory(int n) {
        this.mCategoryWalker.setCurrentByIndex(n);
        this.mPool.setInt(153, this.mCategoryWalker.getCurrentIndex());
    }

    public void updateOpenCategoryByID(short s) {
        this.mCategoryWalker.setCurrentByNo(s);
        this.mPool.setInt(153, this.mCategoryWalker.getCurrentIndex());
    }

    public void updateChannelList() {
        if (null != this.mCategoryWalker && null != this.mSatDb && null != this.mChannelWalker) {
            Object object;
            Object object2;
            short s;
            CategoryInfo categoryInfo = this.mCategoryWalker.getCurrent();
            if (categoryInfo != null) {
                s = categoryInfo.getCategoryNumber();
                this.mSatDb.getCategories().getCategoryChannelFilter().setCategory(s);
                this.mChannelWalker.setFilter(this.mSatDb.getTreeChannelFilterArray());
            } else {
                s = -1;
                object2 = this.mSatDb.getFilterListApi();
                object = ((SatFilterListApi)object2).getUserChannelFilter();
                ChannelFilter[] channelFilterArray = new ChannelFilter[]{SatConfig.FILTER_VALIDITY, object, SatConfig.FILTER_SUBSCRIPTION, SatConfig.FILTER_CHANNEL_ZERO};
                this.mChannelWalker.setFilter(channelFilterArray);
            }
            this.mChannelWalker.fill();
            object2 = this.mSatDb.getListApi().getSatListModel();
            if (null != object2 && null != (object = ((SatListModel)object2).getCurrentChannel())) {
                if (((StationInfo)object).getCategoryNumber() == s) {
                    this.mChannelWalker.setCursor(((StationInfo)object).getStationNumber());
                } else {
                    this.mChannelWalker.setCursor(-1);
                }
                ((SatListModel)object2).notifyCategorySubItemListToHmi(this.mChannelWalker);
            }
        }
    }

    public void notifyCategoryListToHmi() {
        SatListModel satListModel = this.mSatDb.getListApi().getSatListModel();
        CategoryInfo[] categoryInfoArray = this.mCategoryWalker.getArray();
        satListModel.updateCategories(categoryInfoArray);
        this.mPool.setInt(153, this.mCategoryWalker.getCurrentIndex());
    }

    public void updateChannelListName() {
        if (null != this.mChannelWalkerName && null != this.mSatDb) {
            StationInfo stationInfo;
            this.mChannelWalkerName.fill();
            SatListModel satListModel = this.mSatDb.getListApi().getSatListModel();
            if (null != satListModel && null != (stationInfo = satListModel.getCurrentChannel())) {
                this.mChannelWalkerName.setCursor(stationInfo.getStationNumber());
                satListModel.notifyChannelListToHmi(this.mChannelWalkerName);
            }
        }
    }

    public void updateSdarsSpeechData() {
        this.showCurrentChannel();
        this.mSatDb.getPresetApi().refresh();
        int n = this.mPool.getInt(150);
        if (n == 2) {
            this.updateChannelListNo();
        } else {
            this.updateChannelListName();
        }
    }

    public void updateChannelChanged() {
        SatListModel satListModel = this.mSatDb.getListApi().getSatListModel();
        StationInfo stationInfo = satListModel.getCurrentChannel();
        this.mChannelWalker.setCursor(stationInfo.getStationNumber());
        this.mPool.setInt(154, this.mChannelWalker.getCursorIndex());
    }

    public void updateLoadList() {
        this.mPool.setInt(154, this.mChannelWalker.getCursorIndex());
        this.mPool.incInt(185);
    }
}

