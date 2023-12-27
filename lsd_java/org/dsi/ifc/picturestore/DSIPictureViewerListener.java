/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.PictureEntryInfo;

public interface DSIPictureViewerListener
extends DSIListener {
    default public void updateViewerState(int n, int n2) {
    }

    default public void updateScrollMode(int n, int n2) {
    }

    default public void updateListPosition(long l, int n, int n2) {
    }

    default public void updateNumEntries(long l, int n) {
    }

    default public void updateNumSelectedEntries(long l, int n) {
    }

    default public void getPictureInfoResult(long l, PictureEntryInfo pictureEntryInfo, int n) {
    }

    default public void selectionResult(int n) {
    }

    default public void createFilterSetResult(int n, int n2) {
    }

    default public void deleteFilterSetResult(int n, int n2) {
    }

    default public void changedFilterSetResult(int n, int n2) {
    }

    default public void getAvailableYearsResult(int[] nArray, int n) {
    }

    default public void getAvailableMonthsResult(int[] nArray, int n) {
    }

    default public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2, int n3) {
    }

    default public void deletePicturesWithFilterSetResult(int n, int n2) {
    }
}

