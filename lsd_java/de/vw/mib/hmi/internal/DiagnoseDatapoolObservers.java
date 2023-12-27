/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.datapool.diag.DiagnoseDatapoolObserver;
import de.vw.mib.hmi.utils.Preconditions;

class DiagnoseDatapoolObservers
implements DiagnoseDatapoolObserver {
    private CowArray registeredObservers = new CowArray();

    DiagnoseDatapoolObservers() {
    }

    void registerObserver(DiagnoseDatapoolObserver diagnoseDatapoolObserver) {
        Preconditions.checkNotNull(diagnoseDatapoolObserver, "observer");
        this.registeredObservers.add(diagnoseDatapoolObserver);
    }

    void unregisterObserver(DiagnoseDatapoolObserver diagnoseDatapoolObserver) {
        this.registeredObservers.remove(diagnoseDatapoolObserver);
    }

    @Override
    public void datapoolUpdate(byte by, int n, int n2, AppDefinition appDefinition, String string) {
        Object[] objectArray = this.registeredObservers.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            DiagnoseDatapoolObserver diagnoseDatapoolObserver = (DiagnoseDatapoolObserver)objectArray[i2];
            diagnoseDatapoolObserver.datapoolUpdate(by, n, n2, appDefinition, string);
        }
    }

    @Override
    public void dirtyDatapool(int n, AppDefinition appDefinition) {
        Object[] objectArray = this.registeredObservers.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            DiagnoseDatapoolObserver diagnoseDatapoolObserver = (DiagnoseDatapoolObserver)objectArray[i2];
            diagnoseDatapoolObserver.dirtyDatapool(n, appDefinition);
        }
    }
}

