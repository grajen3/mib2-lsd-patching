/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import generated.de.vw.mib.asl.internal.ListManager;

public class ConsumerListModelUpdater
implements ASGArrayListChangeNotifier {
    private ConsumerListContext _context;

    public ConsumerListModelUpdater(ConsumerListContext consumerListContext) {
        this._context = consumerListContext;
    }

    private ConsumerListContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
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

    private void _updateClients(ASGArrayList aSGArrayList) {
        this._updateHmiModel(aSGArrayList);
    }

    private void _updateHmiModel(ASGArrayList aSGArrayList) {
        Object[] objectArray = aSGArrayList.getAllElements().toArray();
        ListManager.getGenericASLList(10480).updateList(objectArray);
        if (this.getContextLoger().isTraceEnabled()) {
            this.getContextLoger().trace("ConsumerList update list to model");
        }
    }
}

