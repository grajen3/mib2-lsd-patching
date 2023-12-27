/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import org.dsi.ifc.organizer.DataSet;

public interface IListResultListener {
    default public void handleResultList(int n, DataSet[] dataSetArray, int n2, Object object) {
    }
}

