/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.service.ServiceHandler;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IServiceFinder {
    default public ServiceHandler findService(ServiceInstanceID serviceInstanceID) {
    }
}

