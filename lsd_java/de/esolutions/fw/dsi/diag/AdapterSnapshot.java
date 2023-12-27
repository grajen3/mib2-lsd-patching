/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.base.IDispatcher;
import de.esolutions.fw.dsi.base.IProvider;
import de.esolutions.fw.dsi.diag.DispatcherInfo;
import de.esolutions.fw.dsi.diag.IAdapterSnapshot;
import de.esolutions.fw.dsi.diag.ProviderInfo;
import java.util.Iterator;
import java.util.List;

public class AdapterSnapshot
implements IAdapterSnapshot {
    private ProviderInfo[] providers;
    private DispatcherInfo[] dispatchers;
    private long timestamp;

    public AdapterSnapshot(DSIAdmin dSIAdmin) {
        Object object;
        Object object2;
        List list = dSIAdmin.getProviderList();
        List list2 = dSIAdmin.getDispatcherList();
        this.providers = new ProviderInfo[list.size()];
        int n = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            object2 = (IProvider)iterator.next();
            object = object2.getProviderInfo(n);
            this.providers[n++] = object;
        }
        this.dispatchers = new DispatcherInfo[list2.size()];
        n = 0;
        object2 = list2.iterator();
        while (object2.hasNext()) {
            object = (IDispatcher)object2.next();
            DispatcherInfo dispatcherInfo = object.getDispatcherInfo(n);
            this.dispatchers[n++] = dispatcherInfo;
        }
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public ProviderInfo[] getAllProviders() {
        return this.providers;
    }

    @Override
    public DispatcherInfo[] getAllDispatchers() {
        return this.dispatchers;
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }
}

