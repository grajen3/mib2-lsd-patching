/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.diag.DiagnoseDatapool;
import de.vw.mib.datapool.diag.DiagnoseDatapoolObserver;
import de.vw.mib.hmi.internal.DiagnoseDatapoolObservers;

public class DiagnoseDatapoolDispatcher
implements DiagnoseDatapool {
    final DiagnoseDatapoolObservers observers = new DiagnoseDatapoolObservers();

    @Override
    public void registerObserver(DiagnoseDatapoolObserver diagnoseDatapoolObserver) {
        this.observers.registerObserver(diagnoseDatapoolObserver);
    }

    @Override
    public void unregisterObserver(DiagnoseDatapoolObserver diagnoseDatapoolObserver) {
        this.observers.unregisterObserver(diagnoseDatapoolObserver);
    }

    @Override
    public String getValueAsString(int n, int n2, int n3, AppDefinition appDefinition) {
        return null;
    }

    @Override
    public void setValueFromString(int n, int n2, int n3, AppDefinition appDefinition, String string) {
    }
}

