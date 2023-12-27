/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.amfm.persistence.AmFmPersistenceService;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.amfm.persistence.SatImage;
import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatIntSet;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPreset;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntSet;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

public final class SatPersistable
implements IAslPoolListener {
    private final SatDb mDb;
    private final IAslPool mPool;
    public static final short VERSION_12;
    public static final short VERSION_13;
    public static final short VERSION_14;
    public static final short VERSION_15;
    public static final short VERSION_16;
    public static final short VERSION_17;
    public static final short VERSION_18;
    public static final short VERSION;
    public static final int SAT_MIN_NO_OF_PRESETS_DEFAULT_VALUE;
    public static final int SAT_MAX_NO_OF_PRESETS_DEFAULT_VALUE;
    private static final short[] SUPPORTED_VERSIONS;
    private boolean mFirstRead = false;
    private boolean mReading = false;
    private boolean isWriteAccessBlocked = false;

    public SatPersistable(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = satDb.getPool();
        this.mPool.addListener(23, (IAslPoolListener)this);
        this.mPool.addListener(21, (IAslPoolListener)this);
        this.mPool.addListener(150, (IAslPoolListener)this);
        this.mPool.addListener(151, (IAslPoolListener)this);
        this.mPool.addListener(152, (IAslPoolListener)this);
        this.mPool.addListener(156, (IAslPoolListener)this);
        this.mPool.addListener(175, (IAslPoolListener)this);
        this.mPool.addListener(37, (IAslPoolListener)this);
        this.mPool.addListener(36, (IAslPoolListener)this);
        this.mPool.addListener(166, (IAslPoolListener)this);
        this.mPool.addListener(167, (IAslPoolListener)this);
        this.mPool.addListener(168, (IAslPoolListener)this);
        this.mPool.addListener(48, (IAslPoolListener)this);
        this.mPool.addListener(49, (IAslPoolListener)this);
        this.mPool.addListener(172, (IAslPoolListener)this);
        this.mPool.addListener(183, (IAslPoolListener)this);
        this.mPool.addListener(55, (IAslPoolListener)this);
        this.mPool.addListener(206, (IAslPoolListener)this);
        this.mPool.addListener(207, (IAslPoolListener)this);
    }

    public void clear() {
        this.mReading = true;
        this.mPool.setChannel(23, SatConfig.DEFAULT_CHANNEL);
        this.mPool.setChannel(21, SatConfig.DEFAULT_CHANNEL);
        this.mPool.setInt(150, 2);
        this.mPool.setInt(151, 0);
        this.mPool.setBoolean(152, true);
        this.mDb.getFilterListApi().clear();
        this.mReading = false;
        this.mFirstRead = true;
    }

    public void fromPersistence(boolean bl) {
        try {
            SatPersistence satPersistence;
            if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append("SatPersistable - fromPersistence() - Start").log();
            }
            if (null != (satPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getSatPersistence())) {
                int n;
                Object object;
                Object object2;
                int n2;
                this.mReading = true;
                StationInfoPersistence stationInfoPersistence = satPersistence.getUserChannel();
                StationInfo stationInfo = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createStationInfo(stationInfoPersistence);
                if (null != stationInfo) {
                    this.mPool.setChannel(23, stationInfo);
                    ServiceManager.logger.info(512).append("SatPersistable - fromPersistence() - userChannel").append(stationInfo.toString()).log();
                    this.mPool.setChannel(15, stationInfo);
                } else {
                    ServiceManager.logger.info(512).append("SatPersistable - fromPersistence: Default channel is set ").log();
                    this.mPool.setChannel(23, SatConfig.DEFAULT_CHANNEL);
                    this.mPool.setChannel(15, SatConfig.DEFAULT_CHANNEL);
                }
                StationInfoPersistence stationInfoPersistence2 = satPersistence.getPlayingChannel();
                StationInfo stationInfo2 = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createStationInfo(stationInfoPersistence2);
                if (null != stationInfo2) {
                    this.mPool.setChannel(21, stationInfo2);
                } else {
                    this.mPool.setChannel(21, SatConfig.DEFAULT_CHANNEL);
                }
                int n3 = satPersistence.getSorting();
                this.mPool.setInt(150, n3);
                boolean bl2 = satPersistence.isSeekEnabled();
                this.mPool.setBoolean(152, bl2);
                int n4 = satPersistence.getViewMode();
                this.mPool.setInt(151, n4);
                if (ServiceManager.logger.isTraceEnabled(512)) {
                    ServiceManager.logger.trace(512).append("SatPersistable - fromPersistence() - sortingPersistence = ").append(n3).append(", seekEnabledPersistence = ").append(bl2).append(", viewModePersistence = ").append(n4).log();
                }
                this.mDb.getPresetApi().clear();
                List list = satPersistence.getSatPresets();
                SatPreset[] satPresetArray = this.mDb.getPresetApi().getSatPreset();
                if (null != list && null != satPresetArray) {
                    Iterator iterator = list.iterator();
                    if (null != iterator) {
                        for (n2 = 0; iterator.hasNext() && n2 < satPresetArray.length && null != satPresetArray[n2]; ++n2) {
                            object2 = (StationInfoPersistence)iterator.next();
                            satPresetArray[n2].setStationInternally(RadioServiceManager.getServiceManager().getAdapterAslPersistence().createStationInfo((StationInfoPersistence)object2));
                            if (!ServiceManager.logger.isTraceEnabled(512)) continue;
                            if (null == satPresetArray[n2]) {
                                ServiceManager.logger.trace(512).append("SatPersistable - fromPersistence() - presets[").append(n2).append("] == null").log();
                                continue;
                            }
                            object = satPresetArray[n2].getStation();
                            if (null == object) {
                                ServiceManager.logger.trace(512).append("SatPersistable - fromPersistence() - presets[").append(n2).append("].stationInfo == null").log();
                                continue;
                            }
                            ServiceManager.logger.trace(512).append("SatPersistable - fromPersistence() - presets[").append(n2).append("].stationInfo.getSID() = ").append(((StationInfo)object).toString()).log();
                        }
                    }
                }
                this.mDb.getPresetApi().updateHmi();
                int n5 = satPersistence.getCurrentPresetIndex();
                this.mDb.getPresetApi().setIndexOnLoad(n5);
                n2 = satPersistence.getCurrentPresetsBankIndex();
                this.mDb.getPresetApi().setBankIndex(n2);
                this.mDb.getPresetApi().setPresetsLoadedAndInitialized(true);
                this.mDb.getPresetApi().createNewSatPresets();
                object2 = satPersistence.getSkippedChannels();
                object = satPersistence.getNonSkippedChannels();
                SatIntSet satIntSet = this.mDb.getFilterListApi().getSkippedChannels();
                if (((IntArrayList)object2).isEmpty() && ((IntArrayList)object).isEmpty()) {
                    this.mDb.getFilterListApi().resetSettings();
                } else {
                    Object object3;
                    if (null != object2 && null != satIntSet) {
                        satIntSet.clear();
                        object3 = ((IntArrayList)object2).iterator();
                        if (null != object3) {
                            while (object3.hasNext()) {
                                int n6 = object3.next();
                                satIntSet.add(n6);
                            }
                        }
                    }
                    if (null != (object3 = this.mDb.getFilterListApi().getNonSkippedChannels()) && ((IntArrayList)object).size() > 0) {
                        IntIterator intIterator;
                        ((SatIntSet)object3).clearNonSkipped();
                        if (null != object && null != (intIterator = ((IntArrayList)object).iterator())) {
                            while (intIterator.hasNext()) {
                                n = intIterator.next();
                                ((SatIntSet)object3).addNonSkipped(n);
                            }
                        }
                    }
                }
                boolean bl3 = satPersistence.isUseChannelFilter();
                this.mPool.setBoolean(175, bl3);
                this.mPool.setBoolean(37, true);
                int n7 = satPersistence.getSubscriptionDay();
                this.mPool.setInt(166, n7);
                n = satPersistence.getSubscriptionMonth();
                this.mPool.setInt(167, n);
                int n8 = satPersistence.getSubscriptionYear();
                this.mPool.setInt(168, n8);
                int n9 = satPersistence.getSubscriptionReasonCode();
                this.mPool.setInt(48, n9);
                String string = satPersistence.getSubscriptionReasonText();
                this.setStringInAslPool(49, string);
                int n10 = satPersistence.getSubscriptionState();
                this.mPool.setInt(172, n10);
                int n11 = satPersistence.getSubscriptionTrafficState();
                this.mPool.setInt(183, n11);
                boolean bl4 = satPersistence.isSubscriptionShowPopupSubscriptionChanged();
                this.mPool.setBoolean(55, bl4);
                boolean bl5 = satPersistence.isIsNoneFilterSelected();
                this.mPool.setBoolean(206, bl5);
                boolean bl6 = satPersistence.isAllChannelsFilteredOut();
                this.mPool.setBoolean(207, bl6);
                if (bl) {
                    List list2 = satPersistence.getSatImages();
                    IntObjectMap intObjectMap = this.mDb.getImageDb().getImageMap();
                    boolean bl7 = Boolean.getBoolean("de.vw.mib.asl.internal.radio.sdars.load_image_db");
                    if (null != intObjectMap) {
                        int n12;
                        intObjectMap.clear();
                        if (bl7 && null != list2 && (n12 = list2.size()) > 0) {
                            Iterator iterator = list2.iterator();
                            while (iterator.hasNext()) {
                                SatImage satImage = (SatImage)iterator.next();
                                if (null == satImage) continue;
                                int n13 = satImage.getSid();
                                ResourceLocatorPersistence resourceLocatorPersistence = satImage.getResourceLocator();
                                ResourceLocator resourceLocator = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createResourceLocatorHmi(resourceLocatorPersistence);
                                this.mDb.getImageDb().addImage(n13, resourceLocator);
                            }
                        }
                    }
                }
            }
            this.mPool.setInt(35, AmfmScopeOfArrowKeys.get());
            this.mReading = false;
            this.mFirstRead = true;
            if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append("SatPersistable - fromPersistence() - End").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private boolean setStringInAslPool(int n, String string) {
        if (null == string) {
            string = "";
        }
        return this.mPool.setString(n, string);
    }

    public void toPersistence() {
        try {
            if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append("SatPersistable - toPersistence() - Start").log();
            }
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(512)) {
                    ServiceManager.logger.trace(512).append("SatPersistable - toPersistence() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (this.isPersistenceWriteAccessBlocked()) {
                if (ServiceManager.logger.isTraceEnabled(512)) {
                    ServiceManager.logger.trace(512).append("SatPersistable - toPersistence() - isPersistenceWriteAccessBlocked() == true").log();
                }
                return;
            }
            SatPersistence satPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getSatPersistence();
            AmFmPersistenceService amFmPersistenceService = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getRadioPersistenceService();
            if (null != satPersistence && null != amFmPersistenceService) {
                Object object;
                Object object2;
                Object object3;
                StationInfoPersistence stationInfoPersistence = satPersistence.getUserChannel();
                StationInfo stationInfo = this.mPool.getChannel(23);
                if (null == stationInfoPersistence) {
                    stationInfoPersistence = amFmPersistenceService.createStationInfoPersistence();
                    satPersistence.setUserChannel(stationInfoPersistence);
                }
                if (stationInfo != null && 2 != stationInfo.subscription) {
                    ServiceManager.logger.info(512).append("SatPersistable - toPersistence() - subscription").append(stationInfo.subscription).log();
                }
                RadioServiceManager.getServiceManager().getAdapterAslPersistence().initStationInfoPersistence(stationInfoPersistence, stationInfo);
                StationInfoPersistence stationInfoPersistence2 = satPersistence.getPlayingChannel();
                StationInfo stationInfo2 = this.mPool.getChannel(21);
                if (null == stationInfoPersistence2) {
                    stationInfoPersistence2 = amFmPersistenceService.createStationInfoPersistence();
                    satPersistence.setPlayingChannel(stationInfoPersistence2);
                }
                RadioServiceManager.getServiceManager().getAdapterAslPersistence().initStationInfoPersistence(stationInfoPersistence2, stationInfo2);
                int n = this.mPool.getInt(150);
                satPersistence.setSorting(n);
                boolean bl = this.mPool.getBoolean(152);
                satPersistence.setSeekEnabled(bl);
                int n2 = this.mPool.getInt(151);
                satPersistence.setViewMode(n2);
                if (ServiceManager.logger.isTraceEnabled(512)) {
                    ServiceManager.logger.trace(512).append("SatPersistable - toPersistence() - sorting = ").append(n).append(", seekEnabled = ").append(bl).append(", viewMode = ").append(n2).log();
                }
                List list = satPersistence.getSatPresets();
                SatPreset[] satPresetArray = this.mDb.getPresetApi().getSatPreset();
                if (null != list) {
                    list.clear();
                    if (null != satPresetArray) {
                        for (int i2 = 0; i2 < satPresetArray.length; ++i2) {
                            object3 = amFmPersistenceService.createStationInfoPersistence();
                            if (satPresetArray[i2] != null && satPresetArray[i2].getStation() != null) {
                                RadioServiceManager.getServiceManager().getAdapterAslPersistence().initStationInfoPersistence((StationInfoPersistence)object3, satPresetArray[i2].getStation());
                            } else {
                                RadioServiceManager.getServiceManager().getAdapterAslPersistence().initStationInfoPersistence((StationInfoPersistence)object3, null);
                            }
                            list.add(object3);
                            if (!ServiceManager.logger.isTraceEnabled(512)) continue;
                            ServiceManager.logger.trace(512).append("SatPersistable - toPersistence() - presetsPersistence.add() - SID = ").append(object3.getSid()).log();
                        }
                    }
                } else {
                    ServiceManager.logger.error(512).append("SatPersistable - toPersistence() - null == presetsPersistence").log();
                }
                satPersistence.setCurrentPresetIndex((byte)this.mPool.getInt(156));
                satPersistence.setCurrentPresetsBankIndex((byte)this.mDb.getPresetApi().getCurrentPresetsBankIndex());
                satPersistence.setUseChannelFilter(this.mPool.getBoolean(175));
                IntArrayList intArrayList = satPersistence.getSkippedChannels();
                object3 = this.mDb.getFilterListApi().getSkippedChannels();
                if (null != intArrayList) {
                    intArrayList.clear();
                    if (null != object3 && null != (object2 = ((SatIntSet)object3).getSetSkipped()) && object2.size() > 0) {
                        object = object2.iterator();
                        while (object.hasNext()) {
                            intArrayList.add(object.next());
                        }
                    }
                } else {
                    ServiceManager.logger.error(512).append("SatPersistable - toPersistence() - null == skippedChannelsPersistence").log();
                }
                object2 = satPersistence.getNonSkippedChannels();
                object = this.mDb.getFilterListApi().getNonSkippedChannels();
                if (null != object2) {
                    IntSet intSet;
                    ((IntArrayList)object2).clear();
                    if (null != object && null != (intSet = ((SatIntSet)object).getSetNonSkipped()) && intSet.size() > 0) {
                        IntIterator intIterator = intSet.iterator();
                        while (intIterator.hasNext()) {
                            ((IntArrayList)object2).add(intIterator.next());
                        }
                    }
                } else {
                    ServiceManager.logger.error(512).append("SatPersistable - toPersistence() - null == nonSkippedChannelsPersistence").log();
                }
                int n3 = this.mPool.getInt(166);
                satPersistence.setSubscriptionDay(n3);
                int n4 = this.mPool.getInt(167);
                satPersistence.setSubscriptionMonth(n4);
                int n5 = this.mPool.getInt(168);
                satPersistence.setSubscriptionYear(n5);
                String string = this.mPool.getString(47);
                satPersistence.setSubscriptionPhone(string);
                int n6 = this.mPool.getInt(48);
                satPersistence.setSubscriptionReasonCode(n6);
                String string2 = this.mPool.getString(49);
                satPersistence.setSubscriptionReasonText(string2);
                int n7 = this.mPool.getInt(172);
                satPersistence.setSubscriptionState(n7);
                int n8 = this.mPool.getInt(183);
                satPersistence.setSubscriptionTrafficState(n8);
                boolean bl2 = this.mPool.getBoolean(55);
                satPersistence.setSubscriptionShowPopupSubscriptionChanged(bl2);
                boolean bl3 = this.mPool.getBoolean(206);
                satPersistence.setIsNoneFilterSelected(bl3);
                boolean bl4 = this.mPool.getBoolean(207);
                satPersistence.setAllChannelsFilteredOut(bl4);
                List list2 = satPersistence.getSatImages();
                IntObjectMap intObjectMap = this.mDb.getImageDb().getImageMap();
                if (null != list2) {
                    short s;
                    list2.clear();
                    boolean bl5 = Boolean.getBoolean("de.vw.mib.asl.internal.radio.sdars.load_image_db");
                    if (bl5 && null != intObjectMap && (s = (short)intObjectMap.size()) > 0) {
                        Iterator iterator = intObjectMap.entrySet().iterator();
                        while (iterator.hasNext()) {
                            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
                            SatImage satImage = amFmPersistenceService.createSatImage();
                            RadioServiceManager.getServiceManager().getAdapterAslPersistence().initSatImagePersistence(satImage, intObjectMap$Entry);
                            list2.add(satImage);
                        }
                    }
                } else {
                    ServiceManager.logger.error(512).append("SatPersistable - toPersistence() - null == imagesPersistence").log();
                }
            }
            if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append("SatPersistable - toPersistence() - End").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void clearUnknownValues(short s) {
        this.clear();
    }

    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    public short getVersion() {
        return 18;
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 21: 
            case 23: 
            case 37: 
            case 48: 
            case 49: 
            case 55: 
            case 150: 
            case 151: 
            case 152: 
            case 156: 
            case 166: 
            case 167: 
            case 168: 
            case 172: 
            case 175: 
            case 183: 
            case 206: 
            case 207: {
                if (!this.mFirstRead || this.mReading) break;
                this.toPersistence();
                break;
            }
            case 36: {
                this.toPersistence();
                break;
            }
        }
    }

    public void setPersistenceWriteAccessBlocked(boolean bl) {
        this.isWriteAccessBlocked = bl;
    }

    private boolean isPersistenceWriteAccessBlocked() {
        return this.isWriteAccessBlocked;
    }

    public static StationInfo getDefaultChannel() {
        return SatConfig.DEFAULT_CHANNEL;
    }

    public static int getDefaultSortOrder() {
        return 2;
    }

    public static boolean getDefaultSeekEnableStatus() {
        return true;
    }

    public static boolean getDefaultchannelFilterUsage() {
        return true;
    }

    public static int getDefaultViewMode() {
        return 0;
    }

    public static boolean getDefaultNoneFilterSelected() {
        return false;
    }

    public static boolean getDefaultallChannelsFilteredOut() {
        return false;
    }

    static {
        SUPPORTED_VERSIONS = new short[]{12, 13, 14, 15, 16, 17, 18};
    }
}

