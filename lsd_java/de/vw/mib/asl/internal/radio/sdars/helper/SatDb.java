/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.internal.radio.sdars.categories.CategoryHandler;
import de.vw.mib.asl.internal.radio.sdars.categories.ChannelFilterCategory;
import de.vw.mib.asl.internal.radio.sdars.database.AslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.SatKey;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.debug.namedb.INameDb;
import de.vw.mib.asl.internal.radio.sdars.debug.namedb.NameDb;
import de.vw.mib.asl.internal.radio.sdars.debug.namedb.NameTypes;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiApi;
import de.vw.mib.asl.internal.radio.sdars.filterlist.SatFilterListApi;
import de.vw.mib.asl.internal.radio.sdars.helper.AudioManager;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.HmiUpdater;
import de.vw.mib.asl.internal.radio.sdars.helper.IChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.ITunesHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.ImageDb;
import de.vw.mib.asl.internal.radio.sdars.helper.PreviewHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.RadioTextHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.helper.SatPersistable;
import de.vw.mib.asl.internal.radio.sdars.helper.SatPrepareChannelList;
import de.vw.mib.asl.internal.radio.sdars.helper.SatTuneHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.StationDescriptionHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.StatusHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.SubscriptionHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.TempDisplayChannelHandler;
import de.vw.mib.asl.internal.radio.sdars.list.SatListApi;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPresetApi;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekApi;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.TrafficApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Comparator;
import org.dsi.ifc.sdars.StationInfo;

public final class SatDb {
    private static SatDb mInstance;
    private AslPool mPool;
    private INameDb mNameDb;
    private SatLogHandler mLogHandler;
    private final Comparator mMainComparator = SatConfig.COMP_NO;
    private final Comparator mBapComparator = SatConfig.COMP_NO;
    private RadioTextHandler mRadioTextHandler;
    private StationDescriptionHandler mDescriptionHandler;
    private HmiUpdater mHmiUpdater;
    private PreviewHandler mPreviewHandler;
    private ChannelListFromSouth mChannels;
    private SatPersistable mPersistable;
    private CategoryHandler mCategoryHandler;
    private ChannelFilter[] mTreeChannelFilterArray;
    private ChannelFilter[] mBapFilterArray;
    private ChannelFilter[] mMainFilterArray;
    private ChannelFilter[] mFlatFilterArray;
    private IChannelWalker mBapChannelWalker;
    private IChannelWalker mTileChannelWalker;
    private IChannelWalker mMainChannelWalker;
    private SatModelApi mModelApi;
    private SatTuneHandler mTuneHandler;
    private ImageDb mImageDb;
    private SatSeekApi mSeekApi;
    private SatPresetApi mPresetApi;
    private SatDsiApi mDsiApi;
    private SatListApi mListApi;
    private SatFilterListApi mFilterListApi;
    private StatusHandler mStatusHandler;
    private SubscriptionHandler mSubscriptionHandler;
    private SatMainTarget mMainTarget;
    private AudioManager mAudioManager;
    private ITunesHandler mITunesHandler;
    private boolean prepareStatus;
    private ArrayList sidList;
    private TrafficApi mTrafficApi;
    private SatPrepareChannelList mSatPrepareChannelList;
    private boolean isChannelSorting;
    private boolean isUnsubscribedPopupTriggered;
    private boolean isScanStartedWithFilteredChannel;
    public static boolean mLSMTuneFailed;
    public static int selectedStationStatus;

    private SatDb() {
    }

    public void initialize() {
        this.mLogHandler = new SatLogHandler(this);
        this.mPool = new AslPool(this.mLogHandler);
        SatKey.initialize(this.mPool);
        this.mNameDb = new NameDb();
        NameTypes.initialize(this.mNameDb);
        this.mPool.setObject(33, this.mNameDb);
        this.mLogHandler.initialize(this.mNameDb);
        this.mModelApi = new SatModelApi(this.mPool, this.mLogHandler);
        this.mPersistable = new SatPersistable(this);
        this.mRadioTextHandler = new RadioTextHandler(this);
        this.mDescriptionHandler = new StationDescriptionHandler(this);
        this.mHmiUpdater = new HmiUpdater(this);
        this.mITunesHandler = new ITunesHandler(this);
        this.mTuneHandler = new SatTuneHandler(this);
        this.mSubscriptionHandler = new SubscriptionHandler(this);
        this.mImageDb = new ImageDb(this);
        this.mSeekApi = new SatSeekApi(this);
        this.mTrafficApi = new TrafficApi();
        this.mPresetApi = new SatPresetApi(this);
        this.mDsiApi = new SatDsiApi(this);
        this.mListApi = new SatListApi(this);
        this.mFilterListApi = new SatFilterListApi(this);
        this.mPreviewHandler = new PreviewHandler(this);
        this.mCategoryHandler = new CategoryHandler(this);
        ChannelFilter channelFilter = this.mFilterListApi.getUserChannelFilter();
        ChannelFilterCategory channelFilterCategory = this.mCategoryHandler.getCategoryChannelFilter();
        this.mFlatFilterArray = new ChannelFilter[]{SatConfig.FILTER_VALIDITY, channelFilter, SatConfig.FILTER_SUBSCRIPTION, SatConfig.FILTER_CHANNEL_ZERO};
        this.mBapFilterArray = new ChannelFilter[]{SatConfig.FILTER_VALIDITY, channelFilter, SatConfig.FILTER_SUBSCRIPTION, SatConfig.FILTER_CHANNEL_ZERO};
        this.mMainFilterArray = new ChannelFilter[]{SatConfig.FILTER_VALIDITY, channelFilter, SatConfig.FILTER_SUBSCRIPTION, SatConfig.FILTER_CHANNEL_ZERO};
        this.mTreeChannelFilterArray = new ChannelFilter[]{SatConfig.FILTER_VALIDITY, channelFilter, SatConfig.FILTER_SUBSCRIPTION, channelFilterCategory, SatConfig.FILTER_CHANNEL_ZERO};
        this.mChannels = new ChannelListFromSouth(this);
        this.mMainChannelWalker = new ChannelWalker(this, "MainWalker", false);
        this.mPool.addListener(150, (IAslPoolListener)this.mMainChannelWalker);
        this.mMainChannelWalker.setFilter(this.mMainFilterArray);
        this.mMainChannelWalker.setSorting(this.mMainComparator);
        this.mPool.addListener(23, (IAslPoolListener)this.mMainChannelWalker);
        this.mBapChannelWalker = new ChannelWalker(this, "BAPWalker", false);
        this.mPool.addListener(150, (IAslPoolListener)this.mBapChannelWalker);
        this.mPool.addListener(15, (IAslPoolListener)this.mBapChannelWalker);
        this.mPool.addListener(23, (IAslPoolListener)this.mBapChannelWalker);
        this.mBapChannelWalker.setFilter(this.mBapFilterArray);
        this.mBapChannelWalker.setSorting(this.mBapComparator);
        this.mTileChannelWalker = new ChannelWalker(this, "TileWalker", false);
        this.mPool.addListener(150, (IAslPoolListener)this.mTileChannelWalker);
        this.mPool.addListener(15, (IAslPoolListener)this.mTileChannelWalker);
        this.mPool.addListener(23, (IAslPoolListener)this.mTileChannelWalker);
        this.mTileChannelWalker.setFilter(this.mBapFilterArray);
        this.mTileChannelWalker.setSorting(this.mBapComparator);
        int n = Integer.getInteger("de.vw.mib.asl.internal.radio.sdars.timeout_check_response", SatConfig.TIMEOUT_CHECK_PLAYING_CHANNEL);
        this.mPool.setInt(56, n);
        int n2 = Integer.getInteger("de.vw.mib.asl.internal.radio.sdars.timeout_dsi_response", SatConfig.TIMEOUT_DSI_RESPONSE_SELECT_STATION);
        this.mPool.setInt(57, n2);
        int n3 = Integer.getInteger("de.vw.mib.asl.internal.radio.sdars.timeout_scan", SatConfig.TIMEOUT_SCAN);
        this.mPool.setInt(58, n3);
        int n4 = Integer.getInteger("de.vw.mib.asl.internal.radio.sdars.timeout_no_signal_no_artist", SatConfig.TIMEOUT_NO_SIGNAL_NO_ARTIST);
        this.mPool.setInt(59, n4);
        int n5 = Integer.getInteger("de.vw.mib.asl.internal.radio.sdars.timeout_speller_advisory", SatConfig.TIMEOUT_SPELLER_ADVISORY);
        this.mPool.setInt(60, n5);
        if (System.getProperty("de.vw.mib.asl.internal.radio.sdars.enable_seek_feature") != null) {
            boolean bl = Boolean.getBoolean("de.vw.mib.asl.internal.radio.sdars.enable_seek_feature");
            this.mPool.setBoolean(184, bl);
        }
        new TempDisplayChannelHandler(this, this.mPool);
        this.mSatPrepareChannelList = new SatPrepareChannelList(this, this.mPool);
        this.isUnsubscribedPopupTriggered = false;
    }

    public void initialize(SatMainTarget satMainTarget) {
        this.mMainTarget = satMainTarget;
        this.mAudioManager = new AudioManager(this, this.mMainTarget);
        this.mStatusHandler = new StatusHandler(this);
    }

    public static SatDb getInstance() {
        if (mInstance == null) {
            mInstance = new SatDb();
            mInstance.initialize();
        }
        return mInstance;
    }

    public AslPool getPool() {
        return this.mPool;
    }

    public INameDb getNameDb() {
        return this.mNameDb;
    }

    public SatLogHandler getLogHandler() {
        return this.mLogHandler;
    }

    public SatModelApi getModelApi() {
        return this.mModelApi;
    }

    public SatTuneHandler getTuneHandler() {
        return this.mTuneHandler;
    }

    public ImageDb getImageDb() {
        return this.mImageDb;
    }

    public ChannelFilter[] getTreeChannelFilterArray() {
        return this.mTreeChannelFilterArray;
    }

    public StationDescriptionHandler getStationDescriptionHandler() {
        return this.mDescriptionHandler;
    }

    public RadioTextHandler getRadioTextHandler() {
        return this.mRadioTextHandler;
    }

    public IChannelWalker getMainChannelWalker() {
        return this.mMainChannelWalker;
    }

    public IChannelWalker getBapChannelWalker() {
        return this.mBapChannelWalker;
    }

    public IChannelWalker getTileChannelWalker() {
        return this.mTileChannelWalker;
    }

    public SatMainTarget getMainTarget() {
        return this.mMainTarget;
    }

    public AudioManager getAudioManager() {
        return this.mAudioManager;
    }

    public SatPersistable getPersistable() {
        return this.mPersistable;
    }

    public StatusHandler getStatusHandler() {
        return this.mStatusHandler;
    }

    public SubscriptionHandler getSubscriptionHandler() {
        return this.mSubscriptionHandler;
    }

    public ChannelListFromSouth getChannels() {
        return this.mChannels;
    }

    public CategoryHandler getCategories() {
        return this.mCategoryHandler;
    }

    public HmiUpdater getHmiUpdater() {
        return this.mHmiUpdater;
    }

    public ITunesHandler getITunesHandler() {
        return this.mITunesHandler;
    }

    public PreviewHandler getPreviewHandler() {
        return this.mPreviewHandler;
    }

    public SatSeekApi getSeekApi() {
        return this.mSeekApi;
    }

    public TrafficApi getTrafficApi() {
        return this.mTrafficApi;
    }

    public SatPresetApi getPresetApi() {
        return this.mPresetApi;
    }

    public SatDsiApi getDsiApi() {
        return this.mDsiApi;
    }

    public SatFilterListApi getFilterListApi() {
        return this.mFilterListApi;
    }

    public ChannelFilter[] getFlatFilterArray() {
        return this.mFlatFilterArray;
    }

    public SatListApi getListApi() {
        return this.mListApi;
    }

    public EventGeneric newEvent() {
        return this.mMainTarget.getMainObject().getEventFactory().newEvent();
    }

    public void sendHmiEvent(int n) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    public static Logger getLogger() {
        SatMainTarget satMainTarget;
        if (mInstance != null && (satMainTarget = SatDb.mInstance.mMainTarget) != null) {
            return satMainTarget.getTextLogger();
        }
        return ServiceManager.logger;
    }

    public static ASLPropertyManager getPropertyManager() {
        return ServiceManager.aslPropertyManager;
    }

    public GenericEvents getEventContext() {
        return ServiceManager.eventMain;
    }

    public static DSIServiceLocator getDsiServiceLocator() {
        return ServiceManager.dsiServiceLocator;
    }

    public boolean isPrepareStatus() {
        return this.prepareStatus;
    }

    public void setPrepareStatus(boolean bl) {
        this.prepareStatus = bl;
    }

    public ArrayList getSidList() {
        return this.sidList;
    }

    public void setSidList(ArrayList arrayList) {
        this.sidList = arrayList;
    }

    public SatPrepareChannelList getSatPrepareChannelList() {
        return this.mSatPrepareChannelList;
    }

    public boolean isChannelSorting() {
        return this.isChannelSorting;
    }

    public void setChannelSorting(boolean bl) {
        this.isChannelSorting = bl;
    }

    public boolean isUnsubscribedPopupTriggered() {
        return this.isUnsubscribedPopupTriggered;
    }

    public void setUnsubscribedPopupTriggered(boolean bl) {
        this.isUnsubscribedPopupTriggered = bl;
    }

    public boolean isScanStartedWithFilteredChannel() {
        return this.isScanStartedWithFilteredChannel;
    }

    public void setScanStartedWithFilteredChannel(boolean bl) {
        this.isScanStartedWithFilteredChannel = bl;
    }

    public static void logEvent(String string, EventGeneric eventGeneric) {
        LogMessage logMessage;
        SatLogHandler satLogHandler;
        if (mInstance != null && (satLogHandler = mInstance.getLogHandler()) != null && (logMessage = satLogHandler.getLogMsg()) != null) {
            int n = eventGeneric.getReceiverEventId();
            logMessage.append("EV  ");
            logMessage.append(string);
            logMessage.append(": ");
            INameDb iNameDb = mInstance.getNameDb();
            if (iNameDb != null) {
                String string2 = iNameDb.getName(10, n);
                logMessage.append(string2);
            } else {
                logMessage.append(n);
            }
            logMessage.log();
        }
    }

    public boolean isChannelAvailableInChannelList(StationInfo stationInfo) {
        IChannelWalker iChannelWalker = SatDb.getInstance().getMainChannelWalker();
        StationInfo[] stationInfoArray = null;
        if (iChannelWalker != null) {
            iChannelWalker.fill();
            stationInfoArray = iChannelWalker.getArray();
        }
        if (stationInfoArray != null && stationInfoArray.length > 0 && null != stationInfo) {
            for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                if (stationInfoArray[i2] == null || stationInfoArray[i2].sID != stationInfo.sID) continue;
                return true;
            }
        }
        return false;
    }

    static {
        mLSMTuneFailed = false;
        selectedStationStatus = 0;
    }
}

