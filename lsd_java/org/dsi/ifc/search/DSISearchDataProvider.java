/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.RawDataSet;

public interface DSISearchDataProvider
extends DSIBase {
    public static final String VERSION;
    public static final int RP_REGISTERPROVIDERSOURCERESULT;
    public static final int RP_INVALIDATEALLDATARESULT;
    public static final int RP_STOREDATASETSRESULT;
    public static final int RP_DELETEDATASETRESULT;
    public static final int IN_ACTIVATEPROVIDERSOURCE;
    public static final int IN_PROVIDEDATA;
    public static final int RT_REGISTERPROVIDERSOURCE;
    public static final int RT_INVALIDATEALLDATA;
    public static final int RT_STOREDATASETS;
    public static final int RT_DELETEDATASET;
    public static final int RT_SOURCEDATAAVAILABILITYCHANGED;
    public static final int RT_STORERAWDATASETS;

    default public void registerProviderSource(int n) {
    }

    default public void sourceDataAvailabilityChanged(int n, boolean bl) {
    }

    default public void invalidateAllData(int n) {
    }

    default public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
    }

    default public void storeRawDataSets(int n, RawDataSet[] rawDataSetArray, int n2) {
    }

    default public void deleteDataSet(int n, long l) {
    }
}

