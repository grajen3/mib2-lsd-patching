/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search;

import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.RawDataSet;

public interface DSISearchDataProviderC {
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

