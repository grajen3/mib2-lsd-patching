/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.internal.system.keypanel.lock.components.AbstractLockStateComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.ValetParkingComponent$1;
import de.vw.mib.asl.internal.system.util.Preconditions;

public class ValetParkingComponent
extends AbstractLockStateComponent {
    private static final boolean SUCCESSFUL_RESULT;

    public ValetParkingComponent(ValetParkingService valetParkingService) {
        Preconditions.checkArgumentNotNull(valetParkingService);
        valetParkingService.addListener(this.createValetParkingListener());
        boolean bl = valetParkingService.getCurrentValetParkingState();
        this.setLocked(bl);
    }

    @Override
    protected boolean checkIsKeyApplicable(int n, int n2) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                return n2 != 6;
            }
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                return true;
            }
        }
        return false;
    }

    private ValetParkingListener createValetParkingListener() {
        return new ValetParkingComponent$1(this);
    }
}

