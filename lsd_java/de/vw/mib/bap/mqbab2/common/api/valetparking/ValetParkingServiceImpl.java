/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.valetparking;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingService;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingServiceListener;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValetParkingServiceImpl
extends ValetParkingListenerAdapter
implements ValetParkingService {
    protected static int LIST_INITIAL_CAPACITY = 5;
    private IntObjectOptHashMap registeredListeners;

    public ValetParkingServiceImpl() {
        ASLSystemFactory.getSystemApi().getValetParkingService().addListener(this);
    }

    protected IntObjectOptHashMap getRegisteredHMIListeners() {
        if (this.registeredListeners == null) {
            this.registeredListeners = new IntObjectOptHashMap();
        }
        return this.registeredListeners;
    }

    @Override
    public void addValetParkingServiceListener(ValetParkingServiceListener valetParkingServiceListener, int[] nArray) {
        if (nArray != null) {
            IntObjectOptHashMap intObjectOptHashMap = this.getRegisteredHMIListeners();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                List list = (List)intObjectOptHashMap.get(nArray[i2]);
                if (list == null) {
                    ArrayList arrayList = new ArrayList(LIST_INITIAL_CAPACITY);
                    arrayList.add(valetParkingServiceListener);
                    intObjectOptHashMap.put(nArray[i2], arrayList);
                    continue;
                }
                if (list.contains(valetParkingServiceListener)) continue;
                list.add(valetParkingServiceListener);
            }
        }
    }

    @Override
    public void removeValetParkingServiceListener(ValetParkingServiceListener valetParkingServiceListener, int[] nArray) {
        if (nArray != null) {
            IntObjectOptHashMap intObjectOptHashMap = this.getRegisteredHMIListeners();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                List list = (List)intObjectOptHashMap.get(nArray[i2]);
                if (list == null) continue;
                list.remove(valetParkingServiceListener);
                if (!list.isEmpty()) continue;
                intObjectOptHashMap.remove(nArray[i2]);
            }
        }
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        this._notifyServiceDelegates(1);
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }

    @Override
    public boolean isValetParkingActive() {
        return ASLSystemFactory.getSystemApi().getValetParkingService().getCurrentValetParkingState();
    }

    private void _notifyServiceDelegates(int n) {
        List list = (List)this.getRegisteredHMIListeners().get(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ValetParkingServiceListener valetParkingServiceListener = (ValetParkingServiceListener)iterator.next();
                valetParkingServiceListener.updateValetParkingData(this, n);
            }
        }
    }
}

