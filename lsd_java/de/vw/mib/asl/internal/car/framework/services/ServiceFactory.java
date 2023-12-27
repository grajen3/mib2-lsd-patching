/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.services;

import de.vw.mib.asl.internal.car.framework.services.ServiceClientRegistry;
import de.vw.mib.asl.internal.car.framework.services.ServiceProviderRegistry;
import de.vw.mib.asl.internal.car.framework.services.ServiceRegistry;

public final class ServiceFactory {
    private ServiceRegistry serviceRegistry;
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public ServiceClientRegistry getServiceClientRegistry() {
        return this.getServiceRegistry();
    }

    private ServiceRegistry getServiceRegistry() {
        if (this.serviceRegistry == null) {
            this.serviceRegistry = new ServiceRegistry();
        }
        return this.serviceRegistry;
    }

    public ServiceProviderRegistry getServiceProviderRegistry() {
        return this.getServiceRegistry();
    }
}

