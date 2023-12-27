/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.api.online.services.statusbar.OnlineStatusListener;
import de.vw.mib.asl.api.online.services.statusbar.OnlineStatusService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import java.util.Iterator;

public class OnlineStatusServiceImpl
implements OnlineStatusService {
    private final Services services;
    private final ObjectObjectOptHashMap listeners = new ObjectObjectOptHashMap(1);
    private boolean initialized = false;
    private int lastStatus;
    static /* synthetic */ Class class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService;

    public OnlineStatusServiceImpl() {
        this.services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
    }

    @Override
    public void registerOnlineStatusListener(OnlineStatusListener onlineStatusListener) {
        OnlineStatusListener onlineStatusListener2 = (OnlineStatusListener)this.services.getASLAsyncServiceFactory().create(onlineStatusListener);
        if (this.initialized) {
            onlineStatusListener2.updateOnlineStatus(this.lastStatus);
        }
        this.listeners.put(onlineStatusListener, onlineStatusListener2);
    }

    @Override
    public void unregisterOnlineStatusListener(OnlineStatusListener onlineStatusListener) {
        this.listeners.remove(onlineStatusListener);
    }

    public void updateOnlineStatus(int n) {
        this.lastStatus = n;
        if (!this.initialized) {
            this.services.getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService == null ? (class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService = OnlineStatusServiceImpl.class$("de.vw.mib.asl.api.online.services.statusbar.OnlineStatusService")) : class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService, this);
            this.initialized = true;
        }
        Iterator iterator = this.listeners.valueIterator();
        while (iterator.hasNext()) {
            OnlineStatusListener onlineStatusListener = (OnlineStatusListener)iterator.next();
            onlineStatusListener.updateOnlineStatus(this.lastStatus);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

