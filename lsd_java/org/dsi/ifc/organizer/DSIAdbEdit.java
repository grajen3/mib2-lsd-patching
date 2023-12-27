/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.organizer.AdbEntry;

public interface DSIAdbEdit
extends DSIBase {
    public static final String VERSION;
    public static final int RT_INSERTENTRY;
    public static final int RT_GETENTRIES;
    public static final int RT_CHANGEENTRY;
    public static final int RT_COPYENTRY;
    public static final int RT_DELETEENTRIES;
    public static final int RT_GETENTRYDATASETS;
    public static final int RT_SETSPEEDDIAL;
    public static final int RT_DELETESPEEDDIAL;
    public static final int RT_GETENTRYBYREFERENCEID;
    public static final int ATTR_NEWENTRYAVAILABLE;
    public static final int ATTR_NEWPUBLICPROFILEENTRYAVAILABLE;
    public static final int ATTR_NEWTOPDESTINATIONENTRYAVAILABLE;
    public static final int ATTR_NEWPUBLICPROFILETOPDESTENTRYAVAILABLE;
    public static final int ATTR_NEWONLINEDESTINATIONENTRYAVAILABLE;
    public static final int RP_INSERTENTRYRESULT;
    public static final int RP_GETENTRIESRESULT;
    public static final int RP_COPYENTRYRESULT;
    public static final int RP_DELETEENTRIESRESULT;
    public static final int RP_CHANGEENTRYRESULT;
    public static final int RP_GETENTRYDATASETSRESULT;
    public static final int RP_SETSPEEDDIALRESULT;
    public static final int RP_DELETESPEEDDIALRESULT;
    public static final int RP_GETENTRYBYREFERENCEIDRESULT;

    default public void insertEntry(AdbEntry adbEntry, int n) {
    }

    default public void getEntries(long[] lArray, int n, int n2) {
    }

    default public void getEntryDataSets(long[] lArray, int n, int n2) {
    }

    default public void changeEntry(AdbEntry adbEntry, int n) {
    }

    default public void copyEntry(long l) {
    }

    default public void deleteEntries(long[] lArray, int n, int n2) {
    }

    default public void setSpeedDial(AdbEntry adbEntry) {
    }

    default public void deleteSpeedDial(int n) {
    }

    default public void getEntryByReferenceId(String string) {
    }
}

