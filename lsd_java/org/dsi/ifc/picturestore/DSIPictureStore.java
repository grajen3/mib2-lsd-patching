/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureStore
extends DSIBase {
    public static final String VERSION;
    public static final int IN_INVALIDDATA;
    public static final int RP_IMPORTPICTURERESULT;
    public static final int RP_PICTUREEXISTS;
    public static final int RP_FREESLOTS;
    public static final int RP_GETREFERENCESRESULT;
    public static final int RP_DELETEDPICTURES;
    public static final int RP_RESPONSELRUPICTURES;
    public static final int RP_LISTRESULT;
    public static final int RP_LISTFORCONTEXTRESULT;
    public static final int RP_GETPICTUREATTRIBUTESRESULT;
    public static final int RP_LISTFORCONTEXTWITHFILTERRESULT;
    public static final int RP_IMPORTPICTUREFROMSOURCERESULT;
    public static final int RP_GETRECTANGLEPICTURESGRIDRESULT;
    public static final int RP_GETAVAILABLEYEARSRESULT;
    public static final int RP_GETAVAILABLEMONTHSRESULT;
    public static final int RP_CREATEFILTERSETRESULT;
    public static final int RP_CLONEFILTERSETRESULT;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT;
    public static final int RP_GETAVAILABLEFOLDERSRESULT;
    public static final int RP_COUNTPICTURESINCONTEXTRESULT;
    public static final int RP_LISTFORCONTEXTWITHFILTERSORTDISTRESULT;
    public static final int RT_IMPORTPICTURE;
    public static final int RT_PICTUREEXISTS;
    public static final int RT_INCREASEREFCOUNTER;
    public static final int RT_DECREASEREFCOUNTER;
    public static final int RT_SETCONFIG;
    public static final int RT_GETFREESLOTS;
    public static final int RT_GETREFERENCES;
    public static final int RT_DELETEALLPICTURES;
    public static final int RT_DELETEPICTURESFROMCONTEXT;
    public static final int RT_DELETEPICTURES;
    public static final int RT_GETLRUPICTURES;
    public static final int RT_LISTINALLCONTEXTS;
    public static final int RT_LISTINCONTEXT;
    public static final int RT_GETPICTUREATTRIBUTES;
    public static final int RT_CLONEFILTERSET;
    public static final int RT_CREATEFILTERSET;
    public static final int RT_DELETEFILTERSET;
    public static final int RT_DELETEPICTURESWITHFILTERSET;
    public static final int RT_GETAVAILABLEMONTHS;
    public static final int RT_GETAVAILABLEYEARS;
    public static final int RT_GETRECTANGLEPICTURESGRID;
    public static final int RT_IMPORTPICTUREFROMSOURCE;
    public static final int RT_LISTINCONTEXTWITHFILTER;
    public static final int RT_SETCONFIGWITHFILETYPE;
    public static final int RT_SETFILTERGEOAREA;
    public static final int RT_SETFILTERIMPORTSOURCE;
    public static final int RT_SETFILTERTIMEINTERVAL;
    public static final int RT_RESETTOFACTORYSETTINGS;
    public static final int RT_GETAVAILABLEFOLDERS;
    public static final int RT_SETFILTERFOLDERNAME;
    public static final int RT_COUNTPICTURESINCONTEXT;
    public static final int RT_LISTINCONTEXTWITHFILTERSORTDIST;
    public static final int IMPORTRESULT_SUCCESS;
    public static final int IMPORTRESULT_NOSLOTAVAILABLE;
    public static final int IMPORTRESULT_IOERROR;
    public static final int IMPORTRESULT_PICTURENOTFOUND;
    public static final int IMPORTRESULT_INTERNALERROR;
    public static final int IMPORTRESULT_WRONG_PARAMETER;
    public static final int IMPORTSOURCE_UNDEFINED;
    public static final int IMPORTSOURCE_USB;
    public static final int IMPORTSOURCE_SDCARD;
    public static final int IMPORTSOURCE_ONLINE;
    public static final int IMPORTSOURCE_STREETVIEW;
    public static final int IMPORTSOURCE_CD;
    public static final int IMPORTSOURCE_DVD;
    public static final int TIMEINTERVALFILTERTYPE_CREATED_ON;
    public static final int TIMEINTERVALFILTERTYPE_IMPORTED_ON;
    public static final int FILETYPE_DEFAULT;
    public static final int FILETYPE_PNG;
    public static final int FILETYPE_JPEG;
    public static final int FILTERSETID_EMPTY;
    public static final int INVALIDDATATYPE_UNSPECIFIC;
    public static final int INVALIDDATATYPE_STARTED;
    public static final int INVALIDDATATYPE_RESET;
    public static final int INVALIDDATATYPE_PICS_CHANGED;

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
}

