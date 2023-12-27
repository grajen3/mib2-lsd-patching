/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.api.testmode.valetparking.ValetParkingTestmodeListener;
import de.vw.mib.asl.internal.testmode.PropagatingValetParkingTestmodeService;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ValetParkingTestmodeServiceImpl
implements PropagatingValetParkingTestmodeService {
    private boolean currentValetParkingState = false;
    private Set listener = new HashSet();

    @Override
    public void addListener(ValetParkingTestmodeListener valetParkingTestmodeListener) {
        if (valetParkingTestmodeListener == null) {
            throw new IllegalArgumentException("A new listener must not be null.");
        }
        this.listener.add(valetParkingTestmodeListener);
    }

    @Override
    public void removeListener(ValetParkingTestmodeListener valetParkingTestmodeListener) {
        this.listener.remove(valetParkingTestmodeListener);
    }

    @Override
    public boolean isValetParkingActive() {
        return this.currentValetParkingState;
    }

    @Override
    public void onValetParkingChanged() {
        this.currentValetParkingState = !this.currentValetParkingState;
        Iterator iterator = this.listener.iterator();
        while (iterator.hasNext()) {
            ValetParkingTestmodeListener valetParkingTestmodeListener = (ValetParkingTestmodeListener)iterator.next();
            valetParkingTestmodeListener.notifyValetParkingTestmodeStateChanged(this.currentValetParkingState);
        }
    }
}

