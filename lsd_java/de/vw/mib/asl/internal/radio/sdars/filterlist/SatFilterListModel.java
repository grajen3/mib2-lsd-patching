/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.filterlist;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.categories.CategoryHandler;
import de.vw.mib.asl.internal.radio.sdars.categories.ChannelFilterCategory;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.filterlist.ChannelFilterUser;
import de.vw.mib.asl.internal.radio.sdars.filterlist.SatFilterListTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.CategoryWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatIntSet;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.Iterator;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.StationInfo;

final class SatFilterListModel
implements IAslPoolListener {
    private final SatDb mDb;
    private final IAslPool mPool;
    private boolean mListShown = false;
    private int mVisibleCategoryIndex = 0;
    private CategoryWalker mCategories;
    private ChannelWalker mChannels;
    private ChannelFilterCategory mFilterCategory;
    private ChannelFilter[] mFilterArray;
    private final IntObjectMap mCategoryStatusMap;
    private final SatIntSet mSkippedChannels;
    private final SatIntSet mNonSkippedChannels;
    private ChannelFilter[] mFilterArrayForCat;
    private final ChannelFilterUser mUserFilter;

    SatFilterListModel(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mCategoryStatusMap = new IntObjectOptHashMap(30);
        this.mSkippedChannels = new SatIntSet(this.mPool);
        this.mNonSkippedChannels = new SatIntSet(this.mPool);
        this.mUserFilter = new ChannelFilterUser(this.mPool, this);
        this.mPool.addListener(175, (IAslPoolListener)this);
        this.mPool.addListener(37, (IAslPoolListener)this);
        this.mPool.addListener(68, (IAslPoolListener)this);
        this.mPool.addListener(55, (IAslPoolListener)this);
        this.mPool.addListener(2, (IAslPoolListener)this);
    }

    void start() {
        this.mFilterCategory = this.mDb.getCategories().getCategoryChannelFilter();
        this.mFilterArray = new ChannelFilter[]{SatConfig.FILTER_VALIDITY, SatConfig.FILTER_SUBSCRIPTION, this.mFilterCategory, SatConfig.FILTER_CHANNEL_ZERO, SatConfig.FILTER_CHANNEL_DEFAULT};
        this.mFilterArrayForCat = new ChannelFilter[]{SatConfig.FILTER_VALIDITY, SatConfig.FILTER_SUBSCRIPTION, this.mFilterCategory, SatConfig.FILTER_CHANNEL_ZERO, SatConfig.FILTER_CHANNEL_DEFAULT};
        new SatFilterListTarget(this.mDb.getMainTarget(), this);
        this.mDb.getLogHandler().simpleTrace("Module SDARS Filter List started.");
    }

    boolean isListShown() {
        return this.mListShown;
    }

    void openCategoryById(short s) {
        CategoryHandler categoryHandler = this.mDb.getCategories();
        this.mVisibleCategoryIndex = categoryHandler.getIndex(s);
        this.updateCategories();
        this.updateChannels();
    }

    void openCategoryByIndex(int n) {
        this.mVisibleCategoryIndex = n;
        this.updateCategories();
        this.updateChannels();
    }

    void selectAll() {
        Iterator iterator = this.mDb.getChannels().iterator();
        while (iterator.hasNext()) {
            StationInfo stationInfo = (StationInfo)iterator.next();
            this.mSkippedChannels.add(stationInfo.stationNumber);
        }
        this.mNonSkippedChannels.clearNonSkipped();
        this.fillCategoryStatus(2);
        this.mPool.setBoolean(37, true);
        this.mPool.setBoolean(175, true);
        this.mPool.setBoolean(206, false);
        this.mDb.getSatPrepareChannelList().updateSdarsSpeechData();
    }

    void selectNone() {
        this.mSkippedChannels.clear();
        Iterator iterator = this.mDb.getChannels().iterator();
        while (iterator.hasNext()) {
            StationInfo stationInfo = (StationInfo)iterator.next();
            this.mNonSkippedChannels.addNonSkipped(stationInfo.stationNumber);
        }
        this.fillCategoryStatus(0);
        this.mPool.setBoolean(175, false);
        this.mPool.setBoolean(37, true);
        this.mPool.setBoolean(206, true);
        this.mDb.getSatPrepareChannelList().updateSdarsSpeechData();
    }

    private void fillCategoryStatus(int n) {
        Integer n2 = new Integer(n);
        Iterator iterator = this.mDb.getCategories().iterator();
        while (iterator.hasNext()) {
            CategoryInfo categoryInfo = (CategoryInfo)iterator.next();
            this.mCategoryStatusMap.put(categoryInfo.getCategoryNumber(), n2);
        }
    }

    void setListShown(boolean bl) {
        this.mListShown = bl;
        if (this.mListShown) {
            this.mPool.setChannel(22, null);
            this.mCategories = new CategoryWalker(this.mDb, false, false, SatConfig.mShowEmptyCategories, this.mFilterArrayForCat);
            this.mChannels = new ChannelWalker(this.mDb, "FilterListWalker", false);
            this.mChannels.setSorting(SatConfig.COMP_NO);
            this.calculateCategoryHeader();
            this.updateChannels();
            this.updateCategories();
        }
    }

    int getCategoryStatus(int n) {
        int n2;
        Integer n3 = (Integer)this.mCategoryStatusMap.get(n);
        if (n3 == null) {
            n2 = 2;
            this.mCategoryStatusMap.put(n, new Integer(n2));
        } else {
            n2 = n3;
        }
        return n2;
    }

    void calculateCategoryHeader() {
        if (this.mCategories != null) {
            CategoryInfo[] categoryInfoArray = this.mCategories.getArray();
            for (int i2 = 0; i2 < categoryInfoArray.length; ++i2) {
                this.checkCategory(categoryInfoArray[i2].getCategoryNumber());
            }
        }
    }

    void defaultSettingForChannelFilter() {
        boolean bl = this.mPool.getBoolean(206);
        boolean bl2 = this.mPool.getBoolean(207);
        if (this.mSkippedChannels.getSize() == 0 && !bl && !bl2) {
            this.selectAll();
        }
        StationInfo[] stationInfoArray = (StationInfo[])this.mPool.getObjectArray(54);
        for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
            if (this.mNonSkippedChannels.containsNonSkipped(stationInfoArray[i2].getStationNumber())) continue;
            this.mSkippedChannels.add(stationInfoArray[i2].getStationNumber());
        }
    }

    void toggleCategory(int n) {
        CategoryInfo categoryInfo = this.mCategories.getByIndex(n);
        if (categoryInfo != null) {
            int n2 = this.getCategoryStatus(categoryInfo.categoryNumber);
            n2 = n2 == 2 ? 0 : 2;
            this.mCategoryStatusMap.put(categoryInfo.categoryNumber, new Integer(n2));
            Iterator iterator = this.mDb.getChannels().iterator();
            while (iterator.hasNext()) {
                StationInfo stationInfo = (StationInfo)iterator.next();
                if (stationInfo.categoryNumber != categoryInfo.categoryNumber) continue;
                if (n2 == 2) {
                    this.mSkippedChannels.add(stationInfo.stationNumber);
                    this.mNonSkippedChannels.removeNonSkipped(stationInfo.stationNumber);
                    continue;
                }
                this.mSkippedChannels.remove(stationInfo.stationNumber);
                this.mNonSkippedChannels.addNonSkipped(stationInfo.stationNumber);
            }
            if (this.mSkippedChannels.getSize() == 0) {
                this.mPool.setBoolean(207, true);
            } else {
                this.mPool.setBoolean(207, false);
                this.mPool.setBoolean(206, false);
            }
            this.mPool.setBoolean(37, true);
            this.mPool.setBoolean(175, true);
            this.mDb.getSatPrepareChannelList().updateSdarsSpeechData();
        }
    }

    void toggleChannel(int n) {
        StationInfo stationInfo;
        if (n >= 0 && n < this.mChannels.size() && (stationInfo = this.mChannels.getChannelByIndex(n)) != null) {
            this.mSkippedChannels.toggle(stationInfo.stationNumber);
            this.mNonSkippedChannels.toggleNonSkipped(stationInfo.stationNumber);
            this.mDb.getModelApi().updateChannelFilterChannelList(this.mChannels.getArray());
            this.checkCategory(stationInfo.getCategoryNumber());
            if (this.mSkippedChannels.getSize() == 0) {
                this.mPool.setBoolean(207, true);
            } else {
                this.mPool.setBoolean(207, false);
                this.mPool.setBoolean(206, false);
            }
            this.mPool.setBoolean(37, true);
            this.mPool.setBoolean(175, true);
            this.mDb.getSatPrepareChannelList().updateSdarsSpeechData();
        }
    }

    private boolean checkCategory(short s) {
        int n = this.getCategoryStatus(s);
        int n2 = 0;
        boolean bl = false;
        Iterator iterator = this.mDb.getChannels().iterator();
        while (iterator.hasNext()) {
            StationInfo stationInfo = (StationInfo)iterator.next();
            if (stationInfo.categoryNumber != s) continue;
            boolean bl2 = this.isChannelSelected(stationInfo.getStationNumber());
            if (bl2) {
                n2 = 1;
                continue;
            }
            bl = true;
        }
        if (!bl) {
            n2 = 2;
        }
        if (n2 != n) {
            this.mCategoryStatusMap.put(s, new Integer(n2));
            return true;
        }
        return false;
    }

    void updateCategories() {
        if (this.mCategories != null) {
            this.mDb.getModelApi().updateChannelFilterCategoryList(this.mCategories.getArray());
        }
        if (this.mVisibleCategoryIndex >= 0) {
            this.mPool.setInt(153, this.mVisibleCategoryIndex);
        }
    }

    void updateChannels() {
        if (this.mCategories != null) {
            CategoryInfo categoryInfo = this.mCategories.getByIndex(this.mVisibleCategoryIndex);
            if (categoryInfo != null) {
                this.mFilterCategory.setCategory(categoryInfo.categoryNumber);
                this.mChannels.setFilter(this.mFilterArray);
                this.mChannels.fill();
            } else {
                this.mChannels.clear();
            }
            this.mDb.getModelApi().updateChannelFilterChannelList(this.mChannels.getArray());
        }
    }

    boolean isChannelSelected(short s) {
        return this.mSkippedChannels.contains(s);
    }

    boolean isChannelSelectedCopy(short s) {
        return this.mNonSkippedChannels.contains(s);
    }

    void clear() {
        this.mPool.setBoolean(175, false);
        this.selectAll();
        this.mPool.setBoolean(37, true);
    }

    void resetSettings() {
        this.selectAll();
    }

    ChannelFilter getUserChannelFilter() {
        return this.mUserFilter;
    }

    SatDb getDb() {
        return this.mDb;
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 175: {
                this.calculateCategoryHeader();
                boolean bl = iAslPoolRecord.getBoolean();
                if (!bl) break;
                this.updateChannels();
                this.updateCategories();
                break;
            }
            case 37: {
                this.updateChannels();
                this.updateCategories();
                try {
                    TileStationList tileStationList;
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    tileStationList.initTiles();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 2: {
                break;
            }
            case 68: {
                this.selectAll();
                iAslPool.setBoolean(175, true);
                break;
            }
        }
    }

    public SatIntSet getSkippedChannels() {
        return this.mSkippedChannels;
    }

    public SatIntSet getNonSkippedChannels() {
        return this.mNonSkippedChannels;
    }
}

