/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.asgarrays;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import generated.de.vw.mib.asl.internal.ListManager;

public class ASGArrayListClientsUpdater
implements ASGArrayListChangeNotifier {
    private CarLogger logger;
    private String logTitle;
    private final int listConstant;
    private final int loadingStateConstant;

    public ASGArrayListClientsUpdater(String string, CarLogger carLogger, int n) {
        this(string, carLogger, n, -1);
    }

    public ASGArrayListClientsUpdater(String string, CarLogger carLogger, int n, int n2) {
        this.logger = carLogger;
        this.listConstant = n;
        this.loadingStateConstant = n2;
        this.logTitle = string;
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this._updateClients(aSGArrayList);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this._updateClients(aSGArrayList);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this._updateClients(aSGArrayList);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        this._updateClients(aSGArrayList);
    }

    private void updateClientsLoadingState(boolean bl) {
        if (this.loadingStateConstant != -1) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.loadingStateConstant, bl);
        }
    }

    private void _updateClients(ASGArrayList aSGArrayList) {
        if (!aSGArrayList.isLoading()) {
            Object[] objectArray = this.tranformValulesForClients(aSGArrayList);
            this._updateHmiModel(objectArray);
            this.updatePersistence(objectArray);
        }
        this.updateClientsLoadingState(aSGArrayList.isLoading());
    }

    protected void updatePersistence(Object[] objectArray) {
    }

    private Object[] tranformValulesForClients(ASGArrayList aSGArrayList) {
        BAPArrayElement[] bAPArrayElementArray = aSGArrayList.getAllElements().toArray();
        return this.transform2HMI(bAPArrayElementArray);
    }

    private void _updateHmiModel(Object[] objectArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append(this.logTitle).append(": informing HMI with asgarray list").toString());
        }
        ListManager.getGenericASLList(this.listConstant).updateList(objectArray);
    }

    protected Object[] transform2HMI(BAPArrayElement[] bAPArrayElementArray) {
        return bAPArrayElementArray;
    }
}

