/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public interface PictureStoreReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void beginImportResult(int n) {
    }

    default public void endImportResult(int n) {
    }

    default public void importPictureFromSourceResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
    }

    default public void importPictureWithSynchronizationIDResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2, long l) {
    }

    default public void getMaxSynchronizationIDResult(int n, long l) {
    }

    default public void setSynchronizationIDResult(int n, long l) {
    }

    default public void renameFolderResult(int n, String string, String string2, long l, int n2) {
    }

    default public void countPicturesInContextResult(int n, int n2, int n3) {
    }

    default public void increaseRefCounterResult(ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n) {
    }

    default public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
    }

    default public void deleteSynchronizedPictureResult(int n, long l, long l2, int n2) {
    }

    default public void getPictureAttributesResult(ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
    }

    default public void listWithFilterResult(ResourceLocator[] resourceLocatorArray, int n) {
    }

    default public void listForContextResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
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

    default public void invalidData(int[] nArray, int n) {
    }

    default public void getAvailableFoldersResult(int n, String[] stringArray) {
    }
}

