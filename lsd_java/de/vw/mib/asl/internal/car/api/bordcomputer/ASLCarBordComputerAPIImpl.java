/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.bordcomputer;

import de.vw.mib.asl.api.car.bordcomputer.ASLCarBordComputerAPI;
import de.vw.mib.asl.api.car.bordcomputer.BordComputerService;
import de.vw.mib.asl.api.car.bordcomputer.BordComputerServiceListener;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.bordcomputer.NotAvailableBordComputerService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ASLCarBordComputerAPIImpl
implements ASLCarBordComputerAPI,
BordComputerServiceListener,
ServiceClient {
    private Set registeredCarClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$bordcomputer$BordComputerServiceListener;

    private Set getRegisteredCarClients() {
        if (this.registeredCarClients == null) {
            this.registeredCarClients = new HashSet();
        }
        return this.registeredCarClients;
    }

    Iterator getRegisteredCarClientsIterator() {
        return this.getRegisteredCarClients().iterator();
    }

    @Override
    public BordComputerService getService() {
        BordComputerService bordComputerService = (BordComputerService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService == null ? (class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService = ASLCarBordComputerAPIImpl.class$("de.vw.mib.asl.api.car.bordcomputer.BordComputerService")) : class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService);
        if (bordComputerService == null) {
            bordComputerService = new NotAvailableBordComputerService();
        }
        return bordComputerService;
    }

    @Override
    public void addServiceListener(BordComputerServiceListener bordComputerServiceListener) {
        this.getRegisteredCarClients().add(bordComputerServiceListener);
    }

    @Override
    public void removeServiceListener(BordComputerServiceListener bordComputerServiceListener) {
        this.getRegisteredCarClients().remove(bordComputerServiceListener);
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService == null ? (class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService = ASLCarBordComputerAPIImpl.class$("de.vw.mib.asl.api.car.bordcomputer.BordComputerService")) : class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$bordcomputer$BordComputerServiceListener == null ? (class$de$vw$mib$asl$api$car$bordcomputer$BordComputerServiceListener = ASLCarBordComputerAPIImpl.class$("de.vw.mib.asl.api.car.bordcomputer.BordComputerServiceListener")) : class$de$vw$mib$asl$api$car$bordcomputer$BordComputerServiceListener, this);
            this.updateASTAServiceState(this.getService().getASTAServiceState());
        }
    }

    @Override
    public void updateASTAServiceState(int n) {
        Iterator iterator = this.getRegisteredCarClientsIterator();
        while (iterator.hasNext()) {
            BordComputerServiceListener bordComputerServiceListener = (BordComputerServiceListener)iterator.next();
            bordComputerServiceListener.updateASTAServiceState(n);
        }
    }

    @Override
    public void updatePrimaryEngineType(int n) {
        Iterator iterator = this.getRegisteredCarClientsIterator();
        while (iterator.hasNext()) {
            BordComputerServiceListener bordComputerServiceListener = (BordComputerServiceListener)iterator.next();
            bordComputerServiceListener.updatePrimaryEngineType(n);
        }
    }

    @Override
    public void updateBCMenu1(ArrayList arrayList) {
        Iterator iterator = this.getRegisteredCarClientsIterator();
        while (iterator.hasNext()) {
            BordComputerServiceListener bordComputerServiceListener = (BordComputerServiceListener)iterator.next();
            bordComputerServiceListener.updateBCMenu1(arrayList);
        }
    }

    @Override
    public void updateBCMenu2(ArrayList arrayList) {
        Iterator iterator = this.getRegisteredCarClientsIterator();
        while (iterator.hasNext()) {
            BordComputerServiceListener bordComputerServiceListener = (BordComputerServiceListener)iterator.next();
            bordComputerServiceListener.updateBCMenu2(arrayList);
        }
    }

    @Override
    public void updateBCMenu3(ArrayList arrayList) {
        Iterator iterator = this.getRegisteredCarClientsIterator();
        while (iterator.hasNext()) {
            BordComputerServiceListener bordComputerServiceListener = (BordComputerServiceListener)iterator.next();
            bordComputerServiceListener.updateBCMenu3(arrayList);
        }
    }

    @Override
    public void updateAvailableStatusRange(boolean bl) {
        Iterator iterator = this.getRegisteredCarClientsIterator();
        while (iterator.hasNext()) {
            BordComputerServiceListener bordComputerServiceListener = (BordComputerServiceListener)iterator.next();
            bordComputerServiceListener.updateAvailableStatusRange(bl);
        }
    }

    @Override
    public void updateAvailableStatusTripGeneral(boolean bl) {
        Iterator iterator = this.getRegisteredCarClientsIterator();
        while (iterator.hasNext()) {
            BordComputerServiceListener bordComputerServiceListener = (BordComputerServiceListener)iterator.next();
            bordComputerServiceListener.updateAvailableStatusTripGeneral(bl);
        }
    }

    @Override
    public void updateAvailableStatusTripAverageConsumption(boolean bl) {
        Iterator iterator = this.getRegisteredCarClientsIterator();
        while (iterator.hasNext()) {
            BordComputerServiceListener bordComputerServiceListener = (BordComputerServiceListener)iterator.next();
            bordComputerServiceListener.updateAvailableStatusTripAverageConsumption(bl);
        }
    }

    @Override
    public void updateSecondaryEngineType(int n) {
        Iterator iterator = this.getRegisteredCarClientsIterator();
        while (iterator.hasNext()) {
            BordComputerServiceListener bordComputerServiceListener = (BordComputerServiceListener)iterator.next();
            bordComputerServiceListener.updateSecondaryEngineType(n);
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

