/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.services;

import de.vw.mib.asl.internal.globalgoodbye.services.GlobalGoodByeServices;
import de.vw.mib.asl.internal.globalgoodbye.services.GlobalGoodByeServicesImpl;

public class GlobalGoodByeServicesProvider {
    private static GlobalGoodByeServices globalGoodByeServices;

    public static GlobalGoodByeServices getGlobalGoodByeServices() {
        if (globalGoodByeServices == null) {
            globalGoodByeServices = new GlobalGoodByeServicesImpl();
        }
        return globalGoodByeServices;
    }

    public static void setGlobalGoodByeServicesMock(GlobalGoodByeServices globalGoodByeServices) {
        GlobalGoodByeServicesProvider.globalGoodByeServices = globalGoodByeServices;
    }
}

