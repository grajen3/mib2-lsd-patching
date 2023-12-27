/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq;

import de.vw.mib.bap.mqbpq.PqServices;
import de.vw.mib.bap.mqbpq.PqServicesImpl;

public class PqServicesProvider {
    private static PqServices pqServices;

    private PqServicesProvider() {
    }

    public static PqServices getPqServices() {
        if (pqServices == null) {
            pqServices = new PqServicesImpl();
        }
        return pqServices;
    }

    public static void setPqServices(PqServices pqServices) {
        PqServicesProvider.pqServices = pqServices;
    }
}

