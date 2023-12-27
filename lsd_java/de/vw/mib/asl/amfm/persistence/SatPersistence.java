/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.collections.ints.IntArrayList;
import java.util.List;

public interface SatPersistence
extends Persistable {
    default public int getSatNoOfPresets() {
    }

    default public void setSatNoOfPresets(int n) {
    }

    default public StationInfoPersistence getUserChannel() {
    }

    default public void setUserChannel(StationInfoPersistence stationInfoPersistence) {
    }

    default public StationInfoPersistence getPlayingChannel() {
    }

    default public void setPlayingChannel(StationInfoPersistence stationInfoPersistence) {
    }

    default public int getSorting() {
    }

    default public void setSorting(int n) {
    }

    default public boolean isSeekEnabled() {
    }

    default public void setSeekEnabled(boolean bl) {
    }

    default public int getViewMode() {
    }

    default public void setViewMode(int n) {
    }

    default public List getSatPresets() {
    }

    default public int getCurrentPresetIndex() {
    }

    default public void setCurrentPresetIndex(int n) {
    }

    default public byte getCurrentPresetsBankIndex() {
    }

    default public void setCurrentPresetsBankIndex(byte by) {
    }

    default public boolean isUseChannelFilter() {
    }

    default public void setUseChannelFilter(boolean bl) {
    }

    default public IntArrayList getSkippedChannels() {
    }

    default public IntArrayList getNonSkippedChannels() {
    }

    default public int getSubscriptionDay() {
    }

    default public void setSubscriptionDay(int n) {
    }

    default public int getSubscriptionMonth() {
    }

    default public void setSubscriptionMonth(int n) {
    }

    default public int getSubscriptionYear() {
    }

    default public void setSubscriptionYear(int n) {
    }

    default public String getSubscriptionPhone() {
    }

    default public void setSubscriptionPhone(String string) {
    }

    default public int getSubscriptionReasonCode() {
    }

    default public void setSubscriptionReasonCode(int n) {
    }

    default public String getSubscriptionReasonText() {
    }

    default public void setSubscriptionReasonText(String string) {
    }

    default public int getSubscriptionState() {
    }

    default public void setSubscriptionState(int n) {
    }

    default public int getSubscriptionTrafficState() {
    }

    default public void setSubscriptionTrafficState(int n) {
    }

    default public boolean isSubscriptionShowPopupSubscriptionChanged() {
    }

    default public void setSubscriptionShowPopupSubscriptionChanged(boolean bl) {
    }

    default public boolean isIsNoneFilterSelected() {
    }

    default public void setIsNoneFilterSelected(boolean bl) {
    }

    default public boolean isAllChannelsFilteredOut() {
    }

    default public void setAllChannelsFilteredOut(boolean bl) {
    }

    default public List getSatImages() {
    }
}

