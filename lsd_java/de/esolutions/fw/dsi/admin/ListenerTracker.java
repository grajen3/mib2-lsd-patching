/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.admin.IListenerTracker;
import de.esolutions.fw.dsi.admin.ListenerTrackerLocal;
import de.esolutions.fw.dsi.admin.ListenerTrackerOSGi;
import de.esolutions.fw.dsi.config.AdapterConfig;
import de.esolutions.fw.dsi.tracing.Channels;

public class ListenerTracker
implements IListenerTracker {
    private static ListenerTracker listenerTracker;
    private IListenerTracker instance;

    private ListenerTracker() {
        if (AdapterConfig.getInstance().useLocalListenerList()) {
            this.instance = new ListenerTrackerLocal();
        } else {
            this.instance = new ListenerTrackerOSGi();
            Channels.DSI_ADMIN.log((short)3, "You are using the deprecated ListenerTrackerOSGI, please use ListenerTrackerLocal, check your dsiadmin.json!");
        }
    }

    public static ListenerTracker getInstance() {
        if (listenerTracker == null) {
            listenerTracker = new ListenerTracker();
        }
        return listenerTracker;
    }

    @Override
    public Object[] getDSIListener(String string, int n) {
        return this.instance.getDSIListener(string, n);
    }

    @Override
    public void setDSIAdmin(DSIAdmin dSIAdmin) {
        this.instance.setDSIAdmin(dSIAdmin);
    }

    @Override
    public void open() {
        this.instance.open();
    }

    @Override
    public void close() {
        this.instance.close();
    }
}

