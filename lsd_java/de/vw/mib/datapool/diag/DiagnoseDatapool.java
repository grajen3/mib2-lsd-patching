/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.diag;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.diag.DiagnoseDatapoolObserver;

public interface DiagnoseDatapool {
    default public String getValueAsString(int n, int n2, int n3, AppDefinition appDefinition) {
    }

    default public void setValueFromString(int n, int n2, int n3, AppDefinition appDefinition, String string) {
    }

    default public void registerObserver(DiagnoseDatapoolObserver diagnoseDatapoolObserver) {
    }

    default public void unregisterObserver(DiagnoseDatapoolObserver diagnoseDatapoolObserver) {
    }
}

