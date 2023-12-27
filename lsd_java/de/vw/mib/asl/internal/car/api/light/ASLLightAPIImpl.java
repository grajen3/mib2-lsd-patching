/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.light;

import de.vw.mib.asl.api.car.light.ASLLightAPI;
import de.vw.mib.asl.api.car.light.LightService;
import de.vw.mib.asl.api.car.light.LightServiceListener;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.light.NotAvailableLightService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.HashSet;
import java.util.Iterator;

public class ASLLightAPIImpl
implements ASLLightAPI,
ServiceClient,
LightServiceListener {
    private HashSet registeredClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$light$LightService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$light$LightServiceListener;

    private HashSet getRegisteredClients() {
        if (this.registeredClients == null) {
            this.registeredClients = new HashSet();
        }
        return this.registeredClients;
    }

    @Override
    public void updateColorSRGB(String string) {
        Iterator iterator = this.getRegisteredClients().iterator();
        while (iterator.hasNext()) {
            LightServiceListener lightServiceListener = (LightServiceListener)iterator.next();
            lightServiceListener.updateColorSRGB(string);
        }
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$light$LightService == null ? (class$de$vw$mib$asl$api$car$light$LightService = ASLLightAPIImpl.class$("de.vw.mib.asl.api.car.light.LightService")) : class$de$vw$mib$asl$api$car$light$LightService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$light$LightServiceListener == null ? (class$de$vw$mib$asl$api$car$light$LightServiceListener = ASLLightAPIImpl.class$("de.vw.mib.asl.api.car.light.LightServiceListener")) : class$de$vw$mib$asl$api$car$light$LightServiceListener, this);
        }
    }

    @Override
    public LightService getLightService() {
        LightService lightService = (LightService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$light$LightService == null ? (class$de$vw$mib$asl$api$car$light$LightService = ASLLightAPIImpl.class$("de.vw.mib.asl.api.car.light.LightService")) : class$de$vw$mib$asl$api$car$light$LightService);
        if (lightService == null) {
            lightService = new NotAvailableLightService();
        }
        return lightService;
    }

    @Override
    public void addLightServiceListener(LightServiceListener lightServiceListener) {
        this.getRegisteredClients().add(lightServiceListener);
    }

    @Override
    public void removeLightServiceListener(LightServiceListener lightServiceListener) {
        this.getRegisteredClients().remove(lightServiceListener);
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

