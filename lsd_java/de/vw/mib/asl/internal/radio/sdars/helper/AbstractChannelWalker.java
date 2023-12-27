/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.categories.ChannelFilterCategory;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import de.vw.mib.asl.internal.radio.sdars.helper.IChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.log4mib.LogMessage;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.sdars.StationInfo;

public abstract class AbstractChannelWalker
implements IChannelWalker {
    protected final SatDb mDb;
    protected final IAslPool mPool;
    private int mCursorChannelNumber;
    private int mLastNoneZeroCursorChannelNumber;
    private ChannelFilter[] mFilter;
    private String mName = "";
    private final boolean mIsBrowsing;
    protected StationInfo[] mArray;
    protected Comparator mComparator = null;

    public AbstractChannelWalker(SatDb satDb, String string, boolean bl) {
        this(satDb, string, null, bl);
    }

    public AbstractChannelWalker(SatDb satDb, String string, ChannelFilter[] channelFilterArray, boolean bl) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mName = string;
        this.mIsBrowsing = bl;
        this.clear();
        this.setFilter(channelFilterArray);
        this.mPool.addListener(175, (IAslPoolListener)this);
        this.mPool.addListener(37, (IAslPoolListener)this);
        this.mPool.addListener(54, (IAslPoolListener)this);
    }

    @Override
    public String getName() {
        return this.mName;
    }

    @Override
    public void addCommonChannels(List list) {
        LinkedList linkedList = new LinkedList();
        ChannelListFromSouth channelListFromSouth = this.mDb.getChannels();
        if (channelListFromSouth.check(SatConfig.ZERO_CHANNEL, this.mFilter) && channelListFromSouth.getChannel(0) == null) {
            linkedList.add(SatConfig.ZERO_CHANNEL);
        }
        Iterator iterator = channelListFromSouth.iterator();
        while (iterator.hasNext()) {
            StationInfo stationInfo = (StationInfo)iterator.next();
            if (!channelListFromSouth.check(stationInfo, this.mFilter)) continue;
            linkedList.add(stationInfo);
        }
        if (this.mComparator != null) {
            Collections.sort(linkedList, this.mComparator);
        }
        list.addAll(linkedList);
    }

    @Override
    public void addElementAndReSort(StationInfo stationInfo) {
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            linkedList.add(this.mArray[i2]);
        }
        if (null != stationInfo) {
            linkedList.add(stationInfo);
        }
        if (this.mComparator != null) {
            Collections.sort(linkedList, this.mComparator);
        }
        this.clear();
        this.mArray = new StationInfo[linkedList.size()];
        this.mArray = (StationInfo[])linkedList.toArray(this.mArray);
    }

    @Override
    public void clear() {
        this.mArray = new StationInfo[0];
    }

    @Override
    public boolean containsNo(int n) {
        return this.getIndexByNumber(n) >= 0;
    }

    @Override
    public void fill() {
        this.clear();
        LinkedList linkedList = new LinkedList();
        if (this.mFilter != null) {
            for (int i2 = 0; i2 < this.mFilter.length; ++i2) {
                ChannelFilterCategory channelFilterCategory;
                if (!(this.mFilter[i2] instanceof ChannelFilterCategory) || (channelFilterCategory = (ChannelFilterCategory)this.mFilter[i2]).getCategory() != 10001) continue;
                this.addSimilarChannels(linkedList);
                break;
            }
        }
        this.addCommonChannels(linkedList);
        this.mArray = new StationInfo[linkedList.size()];
        this.mArray = (StationInfo[])linkedList.toArray(this.mArray);
    }

    @Override
    public StationInfo[] getArray() {
        return this.mArray;
    }

    @Override
    public void setArray(StationInfo[] stationInfoArray) {
        this.mArray = stationInfoArray;
    }

    @Override
    public StationInfo getChannelByIndex(int n) {
        if (n >= 0 && n < this.size()) {
            return this.mArray[n];
        }
        return null;
    }

    @Override
    public int getChannelCountForCategory(int n) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mArray[i2].categoryNumber != n) continue;
            ++n2;
        }
        return n2;
    }

    @Override
    public StationInfo getCursor() {
        ChannelListFromSouth channelListFromSouth = this.mDb.getChannels();
        StationInfo stationInfo = channelListFromSouth.getChannel(this.getChannelNumber());
        if (stationInfo != null) {
            return stationInfo;
        }
        return this.mPool.getChannel(15);
    }

    @Override
    public int getCursorIndex() {
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mArray[i2].stationNumber != this.getChannelNumber()) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public ChannelFilter[] getFilter() {
        return this.mFilter;
    }

    @Override
    public int getIndexByNumber(int n) {
        for (int i2 = 0; i2 < this.mArray.length; ++i2) {
            if (this.mArray[i2].stationNumber != n) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public StationInfo getNextChannel() {
        return this.step(1);
    }

    @Override
    public StationInfo getPreviousChannel() {
        return this.step(-1);
    }

    @Override
    public void setCursor(int n) {
        this.setChannelNumber(n);
        LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
        if (logMessage != null) {
            logMessage.append(this.getName()).append(" Cursor: ChanNo=").append(n).append(", Index=").append(this.getCursorIndex()).log();
        }
    }

    @Override
    public void setFilter(ChannelFilter[] channelFilterArray) {
        this.mFilter = channelFilterArray;
    }

    @Override
    public void setSorting(Comparator comparator) {
        this.mComparator = comparator;
    }

    @Override
    public int size() {
        return this.mArray.length;
    }

    protected int getChannelNumber() {
        return this.mCursorChannelNumber;
    }

    protected int getLastNonZeroChannelNumber() {
        return this.mLastNoneZeroCursorChannelNumber;
    }

    protected void setChannelNumber(int n) {
        this.mCursorChannelNumber = n;
        if (this.mCursorChannelNumber != 0) {
            this.mLastNoneZeroCursorChannelNumber = this.mCursorChannelNumber;
        }
    }

    protected boolean isBrowsing() {
        return this.mIsBrowsing;
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 150: {
                int n2 = iAslPoolRecord.getInt();
                switch (n2) {
                    case 0: {
                        this.setSorting(SatConfig.COMP_CATEGORY);
                        break;
                    }
                    case 1: {
                        this.setSorting(SatConfig.COMP_NAME);
                        break;
                    }
                    case 2: {
                        this.setSorting(SatConfig.COMP_NO);
                        break;
                    }
                    default: {
                        return;
                    }
                }
                this.fill();
                this.mDb.getModelApi().updateBapChannelList(this.mArray);
                break;
            }
            case 15: {
                this.fill();
                this.mDb.getModelApi().updateBapChannelList(this.mArray);
                break;
            }
            case 23: {
                StationInfo stationInfo = iAslPoolRecord.getChannel();
                this.setCursor(stationInfo.getStationNumber());
                try {
                    TileStationList tileStationList;
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    tileStationList.updateSelectedSdarsChannel(stationInfo, 1170613248);
                    tileStationList.updateSelectedSdarsChannel(stationInfo, 1153836032);
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 54: {
                this.fill();
                break;
            }
            case 37: 
            case 175: {
                if (this.mFilter == null || this.mFilter.length <= 0) break;
                this.fill();
                break;
            }
        }
    }
}

