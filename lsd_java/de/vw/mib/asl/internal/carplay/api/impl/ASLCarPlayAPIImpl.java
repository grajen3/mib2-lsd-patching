/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.api.impl;

import de.vw.mib.asl.api.carplay.ASLCarPlayAPI;
import de.vw.mib.asl.api.carplay.ASLCarplayServices;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.carplay.api.impl.ASLCarplayServicesImpl;

public class ASLCarPlayAPIImpl
implements ASLCarPlayAPI {
    ASLCarplayServices services;

    @Override
    public ASLCarplayServices getServices() {
        if (this.services == null) {
            this.services = new ASLCarplayServicesImpl();
        }
        return this.services;
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(2, -755755264, 624962624);
        PreRegisteredIds.addServiceOrObserverToArray(2, -755755264, 658517056);
        PreRegisteredIds.addServiceOrObserverToArray(2, -755755264, 641739840);
        PreRegisteredIds.addServiceOrObserverToArray(2, -755755264, 692071488);
        PreRegisteredIds.addServiceOrObserverToArray(2, -755755264, 708848704);
        PreRegisteredIds.addServiceOrObserverToArray(2, -755755264, 725625920);
        PreRegisteredIds.addServiceOrObserverToArray(0, -755755264, -2121442560, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, -755755264, -2104665344);
        PreRegisteredIds.addServiceOrObserverToArray(1, -755755264, -2087888128);
        PreRegisteredIds.addServiceOrObserverToArray(2, -755755264, 675294272);
    }
}

