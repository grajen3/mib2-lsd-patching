/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceArrayList;
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceIntArrayList;
import de.vw.mib.collections.ints.IntArrayList;
import java.util.Iterator;
import java.util.List;

class SatPersistenceImpl
extends AbstractPersistable
implements SatPersistence {
    private final PersistenceModule module;
    private final PersistenceArrayList satPresets = new PersistenceArrayList();
    private final PersistenceIntArrayList skippedChannels = new PersistenceIntArrayList();
    private final PersistenceIntArrayList nonSkippedChannels = new PersistenceIntArrayList();
    private final PersistenceArrayList satImages = new PersistenceArrayList();
    private int satNoOfPresets;
    private StationInfoPersistence userChannel;
    private StationInfoPersistence playingChannel;
    private int sorting;
    private boolean seekEnabled;
    private int viewMode;
    private int currentPresetIndex;
    private byte currentPresetsBankIndex;
    private boolean useChannelFilter;
    private int subscriptionDay;
    private int subscriptionMonth;
    private int subscriptionYear;
    private String subscriptionPhone;
    private int subscriptionReasonCode;
    private String subscriptionReasonText;
    private int subscriptionState;
    private int subscriptionTrafficState;
    private boolean subscriptionShowPopupSubscriptionChanged;
    private boolean isNoneFilterSelected;
    private boolean allChannelsFilteredOut;

    SatPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 14;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        AbstractPersistable abstractPersistable;
        this.setRootPersistable(persistable);
        if (this.getUserChannel() != null) {
            this.getUserChannel().updateRootPersistable(persistable);
        }
        if (this.getPlayingChannel() != null) {
            this.getPlayingChannel().updateRootPersistable(persistable);
        }
        this.satPresets.setRootPersistable(persistable);
        Iterator iterator = this.getSatPresets().iterator();
        while (iterator.hasNext()) {
            abstractPersistable = (AbstractPersistable)iterator.next();
            if (abstractPersistable == null) continue;
            abstractPersistable.updateRootPersistable(persistable);
        }
        this.skippedChannels.setRootPersistable(persistable);
        this.nonSkippedChannels.setRootPersistable(persistable);
        this.satImages.setRootPersistable(persistable);
        iterator = this.getSatImages().iterator();
        while (iterator.hasNext()) {
            abstractPersistable = (AbstractPersistable)iterator.next();
            if (abstractPersistable == null) continue;
            abstractPersistable.updateRootPersistable(persistable);
        }
    }

    @Override
    public int getSatNoOfPresets() {
        return this.satNoOfPresets;
    }

    @Override
    public void setSatNoOfPresets(int n) {
        this.satNoOfPresets = n;
        this.markDirty();
    }

    @Override
    public StationInfoPersistence getUserChannel() {
        return this.userChannel;
    }

    @Override
    public void setUserChannel(StationInfoPersistence stationInfoPersistence) {
        this.userChannel = stationInfoPersistence;
        this.markDirty();
    }

    @Override
    public StationInfoPersistence getPlayingChannel() {
        return this.playingChannel;
    }

    @Override
    public void setPlayingChannel(StationInfoPersistence stationInfoPersistence) {
        this.playingChannel = stationInfoPersistence;
        this.markDirty();
    }

    @Override
    public int getSorting() {
        return this.sorting;
    }

    @Override
    public void setSorting(int n) {
        this.sorting = n;
        this.markDirty();
    }

    @Override
    public boolean isSeekEnabled() {
        return this.seekEnabled;
    }

    @Override
    public void setSeekEnabled(boolean bl) {
        this.seekEnabled = bl;
        this.markDirty();
    }

    @Override
    public int getViewMode() {
        return this.viewMode;
    }

    @Override
    public void setViewMode(int n) {
        this.viewMode = n;
        this.markDirty();
    }

    @Override
    public List getSatPresets() {
        return this.satPresets;
    }

    @Override
    public int getCurrentPresetIndex() {
        return this.currentPresetIndex;
    }

    @Override
    public void setCurrentPresetIndex(int n) {
        this.currentPresetIndex = n;
        this.markDirty();
    }

    @Override
    public byte getCurrentPresetsBankIndex() {
        return this.currentPresetsBankIndex;
    }

    @Override
    public void setCurrentPresetsBankIndex(byte by) {
        this.currentPresetsBankIndex = by;
        this.markDirty();
    }

    @Override
    public boolean isUseChannelFilter() {
        return this.useChannelFilter;
    }

    @Override
    public void setUseChannelFilter(boolean bl) {
        this.useChannelFilter = bl;
        this.markDirty();
    }

    @Override
    public IntArrayList getSkippedChannels() {
        return this.skippedChannels;
    }

    @Override
    public IntArrayList getNonSkippedChannels() {
        return this.nonSkippedChannels;
    }

    @Override
    public int getSubscriptionDay() {
        return this.subscriptionDay;
    }

    @Override
    public void setSubscriptionDay(int n) {
        this.subscriptionDay = n;
        this.markDirty();
    }

    @Override
    public int getSubscriptionMonth() {
        return this.subscriptionMonth;
    }

    @Override
    public void setSubscriptionMonth(int n) {
        this.subscriptionMonth = n;
        this.markDirty();
    }

    @Override
    public int getSubscriptionYear() {
        return this.subscriptionYear;
    }

    @Override
    public void setSubscriptionYear(int n) {
        this.subscriptionYear = n;
        this.markDirty();
    }

    @Override
    public String getSubscriptionPhone() {
        return this.subscriptionPhone;
    }

    @Override
    public void setSubscriptionPhone(String string) {
        this.subscriptionPhone = string;
        this.markDirty();
    }

    @Override
    public int getSubscriptionReasonCode() {
        return this.subscriptionReasonCode;
    }

    @Override
    public void setSubscriptionReasonCode(int n) {
        this.subscriptionReasonCode = n;
        this.markDirty();
    }

    @Override
    public String getSubscriptionReasonText() {
        return this.subscriptionReasonText;
    }

    @Override
    public void setSubscriptionReasonText(String string) {
        this.subscriptionReasonText = string;
        this.markDirty();
    }

    @Override
    public int getSubscriptionState() {
        return this.subscriptionState;
    }

    @Override
    public void setSubscriptionState(int n) {
        this.subscriptionState = n;
        this.markDirty();
    }

    @Override
    public int getSubscriptionTrafficState() {
        return this.subscriptionTrafficState;
    }

    @Override
    public void setSubscriptionTrafficState(int n) {
        this.subscriptionTrafficState = n;
        this.markDirty();
    }

    @Override
    public boolean isSubscriptionShowPopupSubscriptionChanged() {
        return this.subscriptionShowPopupSubscriptionChanged;
    }

    @Override
    public void setSubscriptionShowPopupSubscriptionChanged(boolean bl) {
        this.subscriptionShowPopupSubscriptionChanged = bl;
        this.markDirty();
    }

    @Override
    public boolean isIsNoneFilterSelected() {
        return this.isNoneFilterSelected;
    }

    @Override
    public void setIsNoneFilterSelected(boolean bl) {
        this.isNoneFilterSelected = bl;
        this.markDirty();
    }

    @Override
    public boolean isAllChannelsFilteredOut() {
        return this.allChannelsFilteredOut;
    }

    @Override
    public void setAllChannelsFilteredOut(boolean bl) {
        this.allChannelsFilteredOut = bl;
        this.markDirty();
    }

    @Override
    public List getSatImages() {
        return this.satImages;
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

