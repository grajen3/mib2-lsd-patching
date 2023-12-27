/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carlife;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeService;
import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeServiceListener;
import de.vw.mib.datapool.ASLDatapool;
import java.util.Iterator;
import java.util.List;

public class CarLifeASLDataAdapter
extends ASLDataPoolAdapter
implements CarLifeService {
    private APIFactoryInterface apiFactory;
    private static final int[] CARLIFE_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{1332161536};

    public CarLifeASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.register();
    }

    @Override
    public boolean isCarLifeRouteGuidanceActive() {
        return this.getDataPool().getBoolean(1332161536, false);
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                CarLifeServiceListener carLifeServiceListener = (CarLifeServiceListener)iterator.next();
                carLifeServiceListener.updateCarLifeData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return CARLIFE_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return null;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addCarLifeServiceListener(CarLifeServiceListener carLifeServiceListener, int[] nArray) {
        this.registerServiceListener((Object)carLifeServiceListener, nArray);
    }

    @Override
    public void removeCarLifeServiceListener(CarLifeServiceListener carLifeServiceListener, int[] nArray) {
        this.removeServiceListener(carLifeServiceListener, nArray);
    }
}

