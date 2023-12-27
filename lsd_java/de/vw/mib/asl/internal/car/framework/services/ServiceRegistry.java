/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.services;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.framework.services.ServiceClientRegistry;
import de.vw.mib.asl.internal.car.framework.services.ServiceProviderRegistry;
import de.vw.mib.collections.ObjectObjectOptHashMap;

class ServiceRegistry
implements ServiceClientRegistry,
ServiceProviderRegistry {
    private ObjectObjectOptHashMap serviceClientMap;
    private ObjectObjectOptHashMap serviceProviderMap;

    ServiceRegistry() {
    }

    public ObjectObjectOptHashMap getServiceProviderMap() {
        if (this.serviceProviderMap == null) {
            this.serviceProviderMap = new ObjectObjectOptHashMap();
        }
        return this.serviceProviderMap;
    }

    private ObjectObjectOptHashMap getServiceClientMap() {
        if (this.serviceClientMap == null) {
            this.serviceClientMap = new ObjectObjectOptHashMap();
        }
        return this.serviceClientMap;
    }

    @Override
    public void registerServiceClient(Class clazz, Object object) {
        this.getServiceClientMap().put(clazz, object);
    }

    @Override
    public void unregisterServiceClient(Class clazz, Object object) {
        this.getServiceClientMap().remove(clazz);
    }

    @Override
    public Object getServiceProvider(Class clazz) {
        return this.getServiceProviderMap().get(clazz);
    }

    @Override
    public void registerServiceProvider(Class clazz, Object object) {
        this.getServiceProviderMap().put(clazz, object);
        ((ServiceClient)((Object)ASLCarFactory.getCarApi())).informClientsThatProviderIsAvailable(clazz);
    }

    @Override
    public void unregisterServiceProvider(Class clazz, Object object) {
        this.getServiceProviderMap().remove(clazz);
    }

    @Override
    public Object getServiceListener(Class clazz) {
        return this.getServiceClientMap().get(clazz);
    }
}

