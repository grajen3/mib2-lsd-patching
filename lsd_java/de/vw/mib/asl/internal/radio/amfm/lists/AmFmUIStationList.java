/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.lists;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;
import java.util.Comparator;
import org.dsi.ifc.radio.Station;

public interface AmFmUIStationList {
    default public AmFmStationInfoCollector[] getStationInfoCollectors() {
    }

    default public void setStationInfoCollector(AmFmStationInfoCollector[] amFmStationInfoCollectorArray) {
    }

    default public AmFmStationInfoCollector[] getSubStationInfoCollectors() {
    }

    default public int getCurrentSubListIndex() {
    }

    default public int getActiveStationIndex() {
    }

    default public int getCurrentIndex() {
    }

    default public void loadCurrentStationList() {
    }

    default public void loadCurrentStationList(AmFmStation amFmStation) {
    }

    default public void loadCurrentSubStationList(AmFmStation amFmStation) {
    }

    default public void nextStation() {
    }

    default public void previousStation() {
    }

    default public void tuneStation(int n) {
    }

    default public void tuneSubStation(int n) {
    }

    default public void update() {
    }

    default public void clear() {
    }

    default public AmFmStation getCurrentStation() {
    }

    default public int getActiveIndex() {
    }

    default public void setActiveIndex(int n) {
    }

    default public int getStationIndexById(long l) {
    }

    default public int getStationByDatabaseId(long l) {
    }

    default public boolean updateStation(AmFmStation amFmStation, boolean bl, boolean bl2) {
    }

    default public boolean updateSubStation(AmFmStation amFmStation) {
    }

    default public void updateStationWithListIndexChange(Station station) {
    }

    default public void updateStationListItem(Station station) {
    }

    default public void updateSubStationWithListIndexChange(Station station) {
    }

    default public void updateStationIsOnPreset() {
    }

    default public void tuneStation(AmFmStation amFmStation) {
    }

    default public void tuneSubStation(AmFmStation amFmStation) {
    }

    default public int getIndexOf(AmFmStationInfoCollector[] amFmStationInfoCollectorArray, AmFmStation amFmStation) {
    }

    default public void updateActiveListItem() {
    }

    default public void setFmComparator() {
    }

    default public void setFmStationListSortOrder(int n) {
    }

    default public AmFmStationList getFrozenStationList() {
    }

    default public Comparator getFmComparator() {
    }

    default public void updateFmList(AmFmStationInfoCollector[] amFmStationInfoCollectorArray) {
    }
}

