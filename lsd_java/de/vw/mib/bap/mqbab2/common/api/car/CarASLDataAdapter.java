/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.car;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.car.CarService;
import de.vw.mib.bap.mqbab2.common.api.car.CarServiceListener;
import de.vw.mib.datapool.ASLDatapool;
import java.util.Iterator;
import java.util.List;

public class CarASLDataAdapter
extends ASLDataPoolAdapter
implements CarService {
    private APIFactoryInterface apiFactory;
    private static final int[] CAR_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[0];
    private static final int[] CAR_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{10127};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$car$CarService;

    public CarASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$car$CarService == null ? (class$de$vw$mib$bap$mqbab2$common$api$car$CarService = CarASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.car.CarService")) : class$de$vw$mib$bap$mqbab2$common$api$car$CarService;
    }

    @Override
    public final int getCarCompassInfoAngle() {
        return CarASLDataAdapter.getIntegerListValue(10127, 1);
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
                CarServiceListener carServiceListener = (CarServiceListener)iterator.next();
                carServiceListener.updateCarData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return CAR_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return CAR_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addCarServiceListener(CarServiceListener carServiceListener, int[] nArray) {
        this.registerServiceListener((Object)carServiceListener, nArray);
    }

    @Override
    public void removeCarServiceListener(CarServiceListener carServiceListener, int[] nArray) {
        this.removeServiceListener(carServiceListener, nArray);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

