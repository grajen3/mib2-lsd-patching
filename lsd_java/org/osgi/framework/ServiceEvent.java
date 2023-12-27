/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.EventObject;
import org.osgi.framework.ServiceReference;

public class ServiceEvent
extends EventObject {
    private transient ServiceReference reference;
    private transient int type;
    public static final int REGISTERED;
    public static final int MODIFIED;
    public static final int UNREGISTERING;

    public ServiceEvent(int n, ServiceReference serviceReference) {
        super(serviceReference);
        this.reference = serviceReference;
        this.type = n;
    }

    public ServiceReference getServiceReference() {
        return this.reference;
    }

    public int getType() {
        return this.type;
    }
}

