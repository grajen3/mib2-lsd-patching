/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListContext;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.datatypes.BAPArrayDataList;

class PowerProviderModelUpdater
implements ASGArrayListChangeNotifier {
    PowerProviderListContext _context;

    public PowerProviderModelUpdater(PowerProviderListContext powerProviderListContext) {
        this._context = powerProviderListContext;
    }

    private PowerProviderListContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updatePowerProviderList(aSGArrayList);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updatePowerProviderList(aSGArrayList);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updatePowerProviderList(aSGArrayList);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        this.updatePowerProviderList(aSGArrayList);
    }

    protected void updatePowerProviderList(ASGArrayList aSGArrayList) {
        this.getContext().powerProviderListUpdated();
    }
}

