/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling;

import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public final class ClientRegistry {
    private final ArrayList clients = new ArrayList();
    private final Devices devices;

    ClientRegistry(Devices devices) {
        this.devices = devices;
    }

    public void addAll(Collection collection) {
        this.clients.addAll(collection);
        if (this.devices.isInitialized()) {
            ClientRegistry.triggerClients(this.devices, collection);
        }
    }

    public boolean deregister(MediaListObserver mediaListObserver) {
        return this.clients.remove(mediaListObserver);
    }

    private static void triggerClients(Devices devices, Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            MediaListObserver mediaListObserver = (MediaListObserver)iterator.next();
            try {
                if (ServiceManager.logger2.isTraceEnabled(1)) {
                    ServiceManager.logger2.trace(1).append("triggering MediaListObserver '").append(mediaListObserver).append('\'').log();
                }
                mediaListObserver.onUpdate(devices);
            }
            catch (Exception exception) {
                ServiceManager.logger2.error(1).append("MediaListObserver '").append(mediaListObserver).append("' failed.").attachThrowable(exception).log();
            }
        }
    }

    ListIterator getIterator() {
        return this.clients.listIterator();
    }

    void triggerClients() {
        ClientRegistry.triggerClients(this.devices, this.clients);
    }
}

