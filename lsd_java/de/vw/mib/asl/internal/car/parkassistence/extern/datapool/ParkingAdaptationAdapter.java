/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.extern.datapool;

import de.vw.mib.asl.internal.car.parkassistence.extern.datapool.DataPoolAdapter;
import de.vw.mib.asl.internal.car.parkassistence.extern.datapool.ParkingAdaptationDelegate;
import de.vw.mib.asl.internal.car.parkassistence.extern.datapool.ParkingAdaptationService;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;
import java.util.List;

public class ParkingAdaptationAdapter
extends DataPoolAdapter
implements ParkingAdaptationService {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$car$parkassistence$extern$datapool$ParkingAdaptationService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$car$parkassistence$extern$datapool$ParkingAdaptationService == null ? (class$de$vw$mib$asl$internal$car$parkassistence$extern$datapool$ParkingAdaptationService = ParkingAdaptationAdapter.class$("de.vw.mib.asl.internal.car.parkassistence.extern.datapool.ParkingAdaptationService")) : class$de$vw$mib$asl$internal$car$parkassistence$extern$datapool$ParkingAdaptationService;
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ParkingAdaptationDelegate parkingAdaptationDelegate = (ParkingAdaptationDelegate)iterator.next();
                parkingAdaptationDelegate.updateAdaptation(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return ParkingAdaptationDelegate.ADAPTATION_PROPERTIES;
    }

    @Override
    protected int[] getListIds() {
        return ParkingAdaptationDelegate.ADAPTATION_LISTS;
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public int getIntPropertyValue(int n) {
        return this.getDataPool().getInteger(n, 0);
    }

    @Override
    public boolean getBoolPropertyValue(int n) {
        return this.getDataPool().getBoolean(n, false);
    }

    @Override
    public int[] getArrayPropertyValue(int n) {
        return this.getDataPool().getIntegerArray(n, new int[0]);
    }

    @Override
    public Object[] getListPropertyValue(int n) {
        int n2 = ListManager.getGenericASLList(n).getSize();
        Object[] objectArray = new Object[n2];
        ListManager.getGenericASLList(n).toArray(0, objectArray);
        return objectArray;
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

