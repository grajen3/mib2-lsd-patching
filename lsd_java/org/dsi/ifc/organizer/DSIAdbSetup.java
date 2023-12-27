/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbSetup
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETLANGUAGE;
    public static final int RT_SETSORTORDER;
    public static final int RT_SETPICTUREVISIBILITY;
    public static final int RT_SETPUBLICPROFILEVISIBILITY;
    public static final int RT_RESETTOFACTORYSETTINGS;
    public static final int RT_RESETTOPDESTINATION;
    public static final int RT_CREATEBACKUPFILE;
    public static final int RT_IMPORTBACKUPFILE;
    public static final int RT_SETCONTEXTSPECIFICVISIBILITY;
    public static final int ATTR_ADBSTATE;
    public static final int ATTR_SORTORDER;
    public static final int ATTR_PICTUREVISIBILITY;
    public static final int ATTR_CONTEXTSPECIFICVISIBILITY;
    public static final int RP_SETLANGUAGERESULT;
    public static final int RP_SETSORTORDERRESULT;
    public static final int RP_SETPUBLICPROFILEVISIBILITYRESULT;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT;
    public static final int RP_RESETTOPDESTINATIONRESULT;
    public static final int RP_CREATEBACKUPFILERESULT;
    public static final int RP_IMPORTBACKUPFILERESULT;
    public static final int RP_SETPICTUREVISIBILITYRESULT;
    public static final int RP_SETCONTEXTSPECIFICVISIBILITYRESULT;

    default public void setLanguage(String string) {
    }

    default public void setSortOrder(int n) {
    }

    default public void setPublicProfileVisibility(boolean bl) {
    }

    default public void resetToFactorySettings() {
    }

    default public void resetTopDestination() {
    }

    default public void createBackupFile(String string) {
    }

    default public void importBackupFile(String string) {
    }

    default public void setPictureVisibility(boolean bl) {
    }

    default public void setContextSpecificVisibility(boolean bl) {
    }
}

