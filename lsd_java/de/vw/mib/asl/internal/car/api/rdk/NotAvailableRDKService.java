/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.rdk;

import de.vw.mib.asl.api.car.rdk.RDKService;

public class NotAvailableRDKService
implements RDKService {
    @Override
    public int[] getRDKSTires() {
        return null;
    }

    @Override
    public Boolean[] getRKA_RDKS_States() {
        return null;
    }

    @Override
    public boolean isRDKSFSGControlOn() {
        return false;
    }

    @Override
    public int getRDKSystem() {
        return 0;
    }
}

