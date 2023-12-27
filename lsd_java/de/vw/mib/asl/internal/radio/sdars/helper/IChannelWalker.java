/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import java.util.Comparator;
import java.util.List;
import org.dsi.ifc.sdars.StationInfo;

public interface IChannelWalker
extends IAslPoolListener {
    default public void addCommonChannels(List list) {
    }

    default public void addElementAndReSort(StationInfo stationInfo) {
    }

    default public void addSimilarChannels(List list) {
    }

    default public void clear() {
    }

    default public boolean containsNo(int n) {
    }

    default public void fill() {
    }

    default public void setArray(StationInfo[] stationInfoArray) {
    }

    default public StationInfo[] getArray() {
    }

    default public StationInfo getChannelByIndex(int n) {
    }

    default public int getChannelCountForCategory(int n) {
    }

    default public StationInfo getCursor() {
    }

    default public int getCursorIndex() {
    }

    default public ChannelFilter[] getFilter() {
    }

    default public int getIndexByNumber(int n) {
    }

    default public StationInfo getNextChannel() {
    }

    default public StationInfo getPreviousChannel() {
    }

    default public void setCursor(int n) {
    }

    default public void setFilter(ChannelFilter[] channelFilterArray) {
    }

    default public void setSorting(Comparator comparator) {
    }

    default public int size() {
    }

    default public StationInfo step(int n) {
    }

    default public String getName() {
    }

    default public StationInfo stepNextCategory(int n) {
    }

    default public StationInfo stepPreviousCategory(int n) {
    }
}

