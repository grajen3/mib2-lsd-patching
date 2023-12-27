/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.ServiceProvider;

public class ServiceProviderSerializer {
    public static void putOptionalServiceProvider(ISerializer iSerializer, ServiceProvider serviceProvider) {
        boolean bl = serviceProvider == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = serviceProvider.isDisplayConditionProviderName();
            iSerializer.putBool(bl2);
            boolean bl3 = serviceProvider.isDisplayConditionServiceProviderName();
            iSerializer.putBool(bl3);
            String string = serviceProvider.getTelServiceProviderName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalServiceProviderVarArray(ISerializer iSerializer, ServiceProvider[] serviceProviderArray) {
        boolean bl = serviceProviderArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(serviceProviderArray.length);
            for (int i2 = 0; i2 < serviceProviderArray.length; ++i2) {
                ServiceProviderSerializer.putOptionalServiceProvider(iSerializer, serviceProviderArray[i2]);
            }
        }
    }

    public static ServiceProvider getOptionalServiceProvider(IDeserializer iDeserializer) {
        ServiceProvider serviceProvider = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            boolean bl2;
            boolean bl3;
            serviceProvider = new ServiceProvider();
            serviceProvider.displayConditionProviderName = bl3 = iDeserializer.getBool();
            serviceProvider.displayConditionServiceProviderName = bl2 = iDeserializer.getBool();
            serviceProvider.telServiceProviderName = string = iDeserializer.getOptionalString();
        }
        return serviceProvider;
    }

    public static ServiceProvider[] getOptionalServiceProviderVarArray(IDeserializer iDeserializer) {
        ServiceProvider[] serviceProviderArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            serviceProviderArray = new ServiceProvider[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceProviderArray[i2] = ServiceProviderSerializer.getOptionalServiceProvider(iDeserializer);
            }
        }
        return serviceProviderArray;
    }
}

