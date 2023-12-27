/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.notification;

import de.esolutions.fw.comm.agent.notification.NotificationCenter;
import de.esolutions.fw.comm.core.IServiceInstanceListener;
import de.esolutions.fw.comm.core.ServiceInstanceID;

class NotificationCenter$ServiceInstanceListenerEntry {
    public final IServiceInstanceListener listener;
    public final ServiceInstanceID instanceID;
    private final /* synthetic */ NotificationCenter this$0;

    public NotificationCenter$ServiceInstanceListenerEntry(NotificationCenter notificationCenter, IServiceInstanceListener iServiceInstanceListener, ServiceInstanceID serviceInstanceID) {
        this.this$0 = notificationCenter;
        this.listener = iServiceInstanceListener;
        this.instanceID = serviceInstanceID;
    }

    public boolean equals(Object object) {
        if (!(object instanceof NotificationCenter$ServiceInstanceListenerEntry)) {
            return false;
        }
        NotificationCenter$ServiceInstanceListenerEntry notificationCenter$ServiceInstanceListenerEntry = (NotificationCenter$ServiceInstanceListenerEntry)object;
        return notificationCenter$ServiceInstanceListenerEntry.listener == this.listener && notificationCenter$ServiceInstanceListenerEntry.instanceID.equals(this.instanceID);
    }

    public int hashCode() {
        int n = 1;
        n += 7 * this.listener.hashCode();
        return n += 41 * this.instanceID.hashCode();
    }
}

