/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.IndexInformation;

public interface DSIAdbListListener
extends DSIListener {
    default public void updateViewSize(AdbViewSize adbViewSize, int n) {
    }

    default public void invalidData(int n) {
    }

    default public void stopSpellerResult(int n, int n2) {
    }

    default public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
    }

    default public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
    }

    default public void getViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
    }

    default public void getSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
    }

    default public void getValidHanziCharsWindowResult(int n, int n2, int n3, String string, int n4) {
    }

    default public void setListStyleResult(int n) {
    }

    default public void updateAlphabeticalIndex(IndexInformation[] indexInformationArray, int n) {
    }
}

