/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore;

import org.dsi.ifc.global.ResourceLocator;

public interface PictureStoreC {
    default public void setConfig(int n, int n2, int n3, int n4) {
    }

    default public void setConfigWithFileType(int n, int n2, int n3, int n4, int n5) {
    }

    default public void beginImport() {
    }

    default public void endImport() {
    }

    default public void importPictureFromSource(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string) {
    }

    default public void importPictureWithSynchronizationID(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string, long l) {
    }

    default public void getMaxSynchronizationID(int n) {
    }

    default public void setSynchronizationID(int n, long l) {
    }

    default public void renameFolder(int n, String string, String string2, long l) {
    }

    default public void countPicturesInContext(int n, int n2) {
    }

    default public void increaseRefCounter(ResourceLocator resourceLocator, int n) {
    }

    default public void decreaseRefCounter(ResourceLocator resourceLocator, int n) {
    }

    default public void decreaseAllRefCounters(int n) {
    }

    default public void deleteAllPictures(int n, boolean bl) {
    }

    default public void deletePicturesFromContext(int n, ResourceLocator[] resourceLocatorArray, boolean bl) {
    }

    default public void deletePicturesWithFilterSet(int n, int n2, boolean bl) {
    }

    default public void deleteSynchronizedPicture(int n, long l, long l2) {
    }

    default public void getPictureAttributes(ResourceLocator resourceLocator) {
    }

    default public void listInAllContextsWithFilter(int n, int n2, int n3) {
    }

    default public void listInContext(int n, int n2, int n3) {
    }

    default public void listInContextWithFilter(int n, int n2, int n3, int n4) {
    }

    default public void listInContextWithFilterSortDist(int n, int n2, int n3, int n4, float f2, float f3) {
    }

    default public void getRectanglePicturesGrid(int n, int n2, float f2, float f3, float f4, float f5, int n3, int n4, int n5) {
    }

    default public void getAvailableYears(int n, int n2) {
    }

    default public void getAvailableMonths(int n, int n2, int n3) {
    }

    default public void createFilterSet() {
    }

    default public void cloneFilterSet(int n) {
    }

    default public void deleteFilterSet(int n) {
    }

    default public void setFilterImportSource(int n, int n2) {
    }

    default public void setFilterTimeInterval(int n, int n2, long l, long l2) {
    }

    default public void setFilterGeoArea(int n, float f2, float f3, float f4, float f5) {
    }

    default public void getAvailableFolders(int n) {
    }

    default public void setFilterFolderName(int n, String string) {
    }
}

