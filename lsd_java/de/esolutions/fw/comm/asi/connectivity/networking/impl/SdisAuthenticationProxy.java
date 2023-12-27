/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.SdisAuthentication;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SdisAuthenticationProxy
implements SdisAuthentication {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.SdisAuthentication");
    private Proxy proxy;

    public SdisAuthenticationProxy(int n) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4403e802-2d1f-11e4-8e5e-9b52416440fb", n, "a7fca16c-045c-5224-a8af-1013489e690d", "asi.connectivity.networking.SdisAuthentication");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void sdisAuthenticationSuccessful(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)0, genericSerializable);
    }
}

