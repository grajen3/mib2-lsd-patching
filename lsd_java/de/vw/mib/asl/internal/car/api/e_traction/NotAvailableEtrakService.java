/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.e_traction;

import de.vw.mib.asl.api.car.e_traction.EtrakService;

public class NotAvailableEtrakService
implements EtrakService {
    @Override
    public boolean getEtrakAvailableStatus() {
        return false;
    }
}

