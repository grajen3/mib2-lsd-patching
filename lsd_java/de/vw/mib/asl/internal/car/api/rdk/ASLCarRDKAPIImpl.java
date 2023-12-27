/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.rdk;

import de.vw.mib.asl.api.car.rdk.ASLCarRDKAPI;
import de.vw.mib.asl.api.car.rdk.RDKService;
import de.vw.mib.asl.api.car.rdk.RDKServiceListener;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.rdk.NotAvailableRDKService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.HashSet;
import java.util.Iterator;

public class ASLCarRDKAPIImpl
implements ASLCarRDKAPI,
ServiceClient,
RDKServiceListener {
    private HashSet registeredCarClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$rdk$RDKService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$rdk$RDKServiceListener;

    private HashSet getRegisteredCarClients() {
        if (this.registeredCarClients == null) {
            this.registeredCarClients = new HashSet();
        }
        return this.registeredCarClients;
    }

    @Override
    public RDKService getRDKService() {
        RDKService rDKService = (RDKService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$rdk$RDKService == null ? (class$de$vw$mib$asl$api$car$rdk$RDKService = ASLCarRDKAPIImpl.class$("de.vw.mib.asl.api.car.rdk.RDKService")) : class$de$vw$mib$asl$api$car$rdk$RDKService);
        if (rDKService == null) {
            rDKService = new NotAvailableRDKService();
        }
        return rDKService;
    }

    @Override
    public void addRDKServiceListener(RDKServiceListener rDKServiceListener) {
        this.getRegisteredCarClients().add(rDKServiceListener);
    }

    @Override
    public void removeRDKServiceListener(RDKServiceListener rDKServiceListener) {
        this.getRegisteredCarClients().remove(rDKServiceListener);
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$rdk$RDKService == null ? (class$de$vw$mib$asl$api$car$rdk$RDKService = ASLCarRDKAPIImpl.class$("de.vw.mib.asl.api.car.rdk.RDKService")) : class$de$vw$mib$asl$api$car$rdk$RDKService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$rdk$RDKServiceListener == null ? (class$de$vw$mib$asl$api$car$rdk$RDKServiceListener = ASLCarRDKAPIImpl.class$("de.vw.mib.asl.api.car.rdk.RDKServiceListener")) : class$de$vw$mib$asl$api$car$rdk$RDKServiceListener, this);
        }
    }

    @Override
    public void updateRKA_RDKS_States(Boolean[] booleanArray) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            RDKServiceListener rDKServiceListener = (RDKServiceListener)iterator.next();
            rDKServiceListener.updateRKA_RDKS_States(booleanArray);
        }
    }

    @Override
    public void updateRDKSTires(int[] nArray) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            RDKServiceListener rDKServiceListener = (RDKServiceListener)iterator.next();
            rDKServiceListener.updateRDKSTires(nArray);
        }
    }

    @Override
    public void updateIsRDKSFSGControlOn(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            RDKServiceListener rDKServiceListener = (RDKServiceListener)iterator.next();
            rDKServiceListener.updateIsRDKSFSGControlOn(bl);
        }
    }

    @Override
    public void updateRDKSystem(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            RDKServiceListener rDKServiceListener = (RDKServiceListener)iterator.next();
            rDKServiceListener.updateRDKSystem(n);
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

