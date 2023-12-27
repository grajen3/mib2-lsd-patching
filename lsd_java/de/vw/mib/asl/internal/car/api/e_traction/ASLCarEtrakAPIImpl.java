/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.e_traction;

import de.vw.mib.asl.api.car.e_traction.ASLCarEtrakAPI;
import de.vw.mib.asl.api.car.e_traction.EtrakService;
import de.vw.mib.asl.api.car.e_traction.EtrakServiceListener;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.e_traction.NotAvailableEtrakService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.HashSet;
import java.util.Iterator;

public class ASLCarEtrakAPIImpl
implements ASLCarEtrakAPI,
EtrakServiceListener,
ServiceClient {
    private HashSet registeredCarClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$e_traction$EtrakService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$e_traction$EtrakServiceListener;

    private HashSet getRegisteredCarClients() {
        if (this.registeredCarClients == null) {
            this.registeredCarClients = new HashSet();
        }
        return this.registeredCarClients;
    }

    @Override
    public EtrakService getService() {
        EtrakService etrakService = (EtrakService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$e_traction$EtrakService == null ? (class$de$vw$mib$asl$api$car$e_traction$EtrakService = ASLCarEtrakAPIImpl.class$("de.vw.mib.asl.api.car.e_traction.EtrakService")) : class$de$vw$mib$asl$api$car$e_traction$EtrakService);
        if (etrakService == null) {
            etrakService = new NotAvailableEtrakService();
        }
        return etrakService;
    }

    @Override
    public void addServiceListener(EtrakServiceListener etrakServiceListener) {
        this.getRegisteredCarClients().add(etrakServiceListener);
    }

    @Override
    public void removeServiceListener(EtrakServiceListener etrakServiceListener) {
        this.getRegisteredCarClients().remove(etrakServiceListener);
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$e_traction$EtrakService == null ? (class$de$vw$mib$asl$api$car$e_traction$EtrakService = ASLCarEtrakAPIImpl.class$("de.vw.mib.asl.api.car.e_traction.EtrakService")) : class$de$vw$mib$asl$api$car$e_traction$EtrakService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$e_traction$EtrakServiceListener == null ? (class$de$vw$mib$asl$api$car$e_traction$EtrakServiceListener = ASLCarEtrakAPIImpl.class$("de.vw.mib.asl.api.car.e_traction.EtrakServiceListener")) : class$de$vw$mib$asl$api$car$e_traction$EtrakServiceListener, this);
        }
    }

    @Override
    public void updateEtrakAvailableStatus(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            EtrakServiceListener etrakServiceListener = (EtrakServiceListener)iterator.next();
            etrakServiceListener.updateEtrakAvailableStatus(bl);
        }
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

