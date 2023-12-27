/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import java.util.ArrayList;

public final class EntertainmentManagerListeners {
    private final ArrayList listeners = new ArrayList(1);
    private static EntertainmentManagerListeners instance = null;

    private EntertainmentManagerListeners() {
    }

    public static EntertainmentManagerListeners getInstance() {
        if (instance == null) {
            instance = new EntertainmentManagerListeners();
        }
        return instance;
    }

    public void register(EntertainmentManagerListener entertainmentManagerListener) {
        this.listeners.add(entertainmentManagerListener);
    }

    public void deregister(EntertainmentManagerListener entertainmentManagerListener) {
        this.listeners.remove(entertainmentManagerListener);
    }

    void updateEntertainmentSource(int n) {
        for (int i2 = this.listeners.size() - 1; i2 >= 0; --i2) {
            try {
                if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.trace(16).append("Sending update to source ").append(n).append(" to ").append(this.listeners.get(i2).toString()).append(" via EntertainmentManagerListener.").log();
                }
                ((EntertainmentManagerListener)this.listeners.get(i2)).updateEntertainmentSource(n);
                continue;
            }
            catch (Exception exception) {
                ServiceManager.logger2.error(16, new StringBuffer().append("Exception in EntertainmentManagerListener ").append(this.listeners.get(i2).toString()).toString(), exception);
            }
        }
    }
}

