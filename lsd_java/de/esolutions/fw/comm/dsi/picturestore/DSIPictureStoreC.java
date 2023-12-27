/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore;

import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureStoreC {
    default public void setConfig(int n, int n2, int n3, int n4) {
    }

    default public void importPicture(int n, ResourceLocator resourceLocator, boolean bl) {
    }

    default public void pictureExists(ResourceLocator resourceLocator) {
    }

    default public void increaseRefCounter(ResourceLocator resourceLocator, int n) {
    }

    default public void decreaseRefCounter(ResourceLocator resourceLocator, int n) {
    }

    default public void getFreeSlots(int n) {
    }

    default public void getReferences(ResourceLocator resourceLocator) {
    }

    default public void deleteAllPictures(int n, boolean bl) {
    }

    default public void deletePicturesFromContext(int n, ResourceLocator[] resourceLocatorArray, boolean bl) {
    }

    default public void deletePictures(ResourceLocator[] resourceLocatorArray, boolean bl) {
    }

    default public void getLRUPictures(int n, boolean bl, int n2) {
    }

    default public void listInAllContexts(int n, int n2) {
    }

    default public void listInContext(int n, int n2, int n3) {
    }

    default public void getPictureAttributes(ResourceLocator resourceLocator) {
    }

    default public void setConfigWithFileType(int n, int n2, int n3, int n4, int n5) {
    }

    default public void importPictureFromSource(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string) {
    }

    default public void deletePicturesWithFilterSet(int n, int n2, boolean bl) {
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

    default public void resetToFactorySettings() {
    }

    default public void getAvailableFolders(int n) {
    }

    default public void setFilterFolderName(int n, String string) {
    }

    default public void countPicturesInContext(int n, int n2) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

