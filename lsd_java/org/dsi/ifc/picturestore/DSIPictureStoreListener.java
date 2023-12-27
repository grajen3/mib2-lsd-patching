/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public interface DSIPictureStoreListener
extends DSIListener {
    default public void importPictureResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
    }

    default public void pictureExists(ResourceLocator resourceLocator, boolean bl) {
    }

    default public void freeSlots(int n, int n2) {
    }

    default public void getReferencesResult(ResourceLocator resourceLocator, int[] nArray) {
    }

    default public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
    }

    default public void responseLRUPictures(int n, ResourceLocator[] resourceLocatorArray) {
    }

    default public void listResult(ResourceLocator[] resourceLocatorArray, int n) {
    }

    default public void listForContextResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
    }

    default public void getPictureAttributesResult(ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
    }

    default public void importPictureFromSourceResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
    }

    default public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
    }

    default public void listForContextWithFilterSortDistResult(int n, ResourceLocator[] resourceLocatorArray, int n2, float f2, float f3) {
    }

    default public void getRectanglePicturesGridResult(GeoPicture[] geoPictureArray) {
    }

    default public void getAvailableYearsResult(int[] nArray) {
    }

    default public void getAvailableMonthsResult(int[] nArray) {
    }

    default public void createFilterSetResult(int n) {
    }

    default public void cloneFilterSetResult(int n, int n2) {
    }

    default public void resetToFactorySettingsResult(int n) {
    }

    default public void invalidData(int[] nArray, int n) {
    }

    default public void getAvailableFoldersResult(int n, String[] stringArray) {
    }

    default public void countPicturesInContextResult(int n, int n2, int n3) {
    }
}

