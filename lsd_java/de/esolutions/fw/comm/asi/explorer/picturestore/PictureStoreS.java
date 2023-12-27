/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore;

import de.esolutions.fw.comm.asi.explorer.picturestore.PictureStoreReply;
import org.dsi.ifc.global.ResourceLocator;

public interface PictureStoreS {
    default public void setConfig(int n, int n2, int n3, int n4, PictureStoreReply pictureStoreReply) {
    }

    default public void setConfigWithFileType(int n, int n2, int n3, int n4, int n5, PictureStoreReply pictureStoreReply) {
    }

    default public void beginImport(PictureStoreReply pictureStoreReply) {
    }

    default public void endImport(PictureStoreReply pictureStoreReply) {
    }

    default public void importPictureFromSource(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string, PictureStoreReply pictureStoreReply) {
    }

    default public void importPictureWithSynchronizationID(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string, long l, PictureStoreReply pictureStoreReply) {
    }

    default public void getMaxSynchronizationID(int n, PictureStoreReply pictureStoreReply) {
    }

    default public void setSynchronizationID(int n, long l, PictureStoreReply pictureStoreReply) {
    }

    default public void renameFolder(int n, String string, String string2, long l, PictureStoreReply pictureStoreReply) {
    }

    default public void countPicturesInContext(int n, int n2, PictureStoreReply pictureStoreReply) {
    }

    default public void increaseRefCounter(ResourceLocator resourceLocator, int n, PictureStoreReply pictureStoreReply) {
    }

    default public void decreaseRefCounter(ResourceLocator resourceLocator, int n, PictureStoreReply pictureStoreReply) {
    }

    default public void decreaseAllRefCounters(int n, PictureStoreReply pictureStoreReply) {
    }

    default public void deleteAllPictures(int n, boolean bl, PictureStoreReply pictureStoreReply) {
    }

    default public void deletePicturesFromContext(int n, ResourceLocator[] resourceLocatorArray, boolean bl, PictureStoreReply pictureStoreReply) {
    }

    default public void deletePicturesWithFilterSet(int n, int n2, boolean bl, PictureStoreReply pictureStoreReply) {
    }

    default public void deleteSynchronizedPicture(int n, long l, long l2, PictureStoreReply pictureStoreReply) {
    }

    default public void getPictureAttributes(ResourceLocator resourceLocator, PictureStoreReply pictureStoreReply) {
    }

    default public void listInAllContextsWithFilter(int n, int n2, int n3, PictureStoreReply pictureStoreReply) {
    }

    default public void listInContext(int n, int n2, int n3, PictureStoreReply pictureStoreReply) {
    }

    default public void listInContextWithFilter(int n, int n2, int n3, int n4, PictureStoreReply pictureStoreReply) {
    }

    default public void listInContextWithFilterSortDist(int n, int n2, int n3, int n4, float f2, float f3, PictureStoreReply pictureStoreReply) {
    }

    default public void getRectanglePicturesGrid(int n, int n2, float f2, float f3, float f4, float f5, int n3, int n4, int n5, PictureStoreReply pictureStoreReply) {
    }

    default public void getAvailableYears(int n, int n2, PictureStoreReply pictureStoreReply) {
    }

    default public void getAvailableMonths(int n, int n2, int n3, PictureStoreReply pictureStoreReply) {
    }

    default public void createFilterSet(PictureStoreReply pictureStoreReply) {
    }

    default public void cloneFilterSet(int n, PictureStoreReply pictureStoreReply) {
    }

    default public void deleteFilterSet(int n, PictureStoreReply pictureStoreReply) {
    }

    default public void setFilterImportSource(int n, int n2, PictureStoreReply pictureStoreReply) {
    }

    default public void setFilterTimeInterval(int n, int n2, long l, long l2, PictureStoreReply pictureStoreReply) {
    }

    default public void setFilterGeoArea(int n, float f2, float f3, float f4, float f5, PictureStoreReply pictureStoreReply) {
    }

    default public void getAvailableFolders(int n, PictureStoreReply pictureStoreReply) {
    }

    default public void setFilterFolderName(int n, String string, PictureStoreReply pictureStoreReply) {
    }
}

