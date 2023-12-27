/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.modelapi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.modelapi.ListRowData;

public interface DSIModelAPIListener
extends DSIListener {
    default public void showScreen(int n, boolean bl) {
    }

    default public void showInfoScreen(int n, boolean bl) {
    }

    default public void showTrafficScreen(int n, boolean bl) {
    }

    default public void showPopup(int n) {
    }

    default public void removePopup() {
    }

    default public void removeSinglePopup(int n) {
    }

    default public void setVisible(int n, boolean bl) {
    }

    default public void setLabel(int n, String string) {
    }

    default public void setModelEnabled(int n, boolean bl) {
    }

    default public void setChoiceValue(int n, int n2) {
    }

    default public void setTextfield(int n, String string) {
    }

    default public void setRangeLimits(int n, int n2, int n3) {
    }

    default public void setRangeValue(int n, int n2) {
    }

    default public void setText(int n, String string, String string2) {
    }

    default public void setMatchSpellerData(int n, String string, String string2, String string3, boolean bl, int n2, boolean bl2, int n3) {
    }

    default public void setMatchCount(int n, int n2) {
    }

    default public void setMetricsInvalid(int n) {
    }

    default public void setMetricsValue(int n, long l) {
    }

    default public void setListData(int n, ListRowData[] listRowDataArray) {
    }

    default public void setSubListData(int n, ListRowData[] listRowDataArray, long l) {
    }

    default public void setSelected(int n, long l) {
    }

    default public void setSlidingListData(int n, long[] lArray, ListRowData[] listRowDataArray, boolean bl, boolean bl2, int n2) {
    }

    default public void setSlidingListDataWithInitialCursorPos(int n, long[] lArray, ListRowData[] listRowDataArray, boolean bl, boolean bl2, int n2, long l) {
    }

    default public void setSlidingSubListData(int n, long[] lArray, ListRowData[] listRowDataArray, boolean bl, boolean bl2, int n2, long l) {
    }

    default public void fillListBufferAtStart(int n, long[] lArray, ListRowData[] listRowDataArray, boolean bl) {
    }

    default public void fillListBufferAtEnd(int n, long[] lArray, ListRowData[] listRowDataArray, boolean bl) {
    }

    default public void setRGIData(int n, short[] sArray) {
    }

    default public void fillSlidingListRow(int n, ListRowData listRowData, long l) {
    }

    default public void setSlidingListSize(int n, int n2) {
    }

    default public void switchContext(int n) {
    }

    default public void validateCharactersResult(int n, String string, String string2) {
    }

    default public void setModelPressed(int n, boolean bl) {
    }

    default public void showSetupScreen(int n, boolean bl) {
    }

    default public void showInfoSetupScreen(int n, boolean bl) {
    }

    default public void setFmtTime(int n, int n2, int n3) {
    }

    default public void setFmtDate(int n, int n2, int n3, int n4) {
    }

    default public void setFmtRTT(int n, long l) {
    }

    default public void setFmtDistance(int n, int n2) {
    }

    default public void setFmtAltitude(int n, int n2) {
    }

    default public void setFmtRadioFrequency(int n, int n2) {
    }

    default public void setFmtOrientation(int n, int n2) {
    }

    default public void setFmtGeoCoordinatesLongitude(int n, int n2, int n3, int n4) {
    }

    default public void setFmtGeoCoordinatesLatitude(int n, int n2, int n3, int n4) {
    }

    default public void triggerSDComponent(int n) {
    }

    default public void setDynamicImage(int n, ResourceLocator resourceLocator) {
    }

    default public void setSDSDynamicValue(int n, String string) {
    }

    default public void setSDSDynamicObjectID(int n, String string) {
    }

    default public void getValidHanziCharsWindowResult(int n, int n2, String string, int n3) {
    }

    default public void requestStateMachineControl() {
    }

    default public void ddsHandled(boolean bl) {
    }
}

