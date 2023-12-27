/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IServiceInstanceListener {
    default public void serviceRegistered(ServiceInstanceID serviceInstanceID, short s) {
    }

    default public void serviceUnregistered(ServiceInstanceID serviceInstanceID, short s) {
    }
}

