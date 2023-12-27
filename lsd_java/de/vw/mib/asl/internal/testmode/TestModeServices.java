/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.infotainmentrecorder.InfotainmentRecorderService;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;

public interface TestModeServices {
    default public Logger getLogger() {
    }

    default public ServiceRegister getServiceRegister() {
    }

    default public InfotainmentRecorderService getInfotainmentRecorderService() {
    }

    default public ASLListManager getAslListManager() {
    }

    default public DesktopManager getDesktopManager() {
    }

    default public ASLSystemAPI getSystemApi() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public ASLPropertyManager getAslPropertyManager() {
    }
}

