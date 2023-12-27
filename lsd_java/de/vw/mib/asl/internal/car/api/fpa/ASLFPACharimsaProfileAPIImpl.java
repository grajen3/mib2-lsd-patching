/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.fpa;

import de.vw.mib.asl.api.car.fpa.ASLFPACharismaProfileAPI;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileFunctionAvailability;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileService;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileServiceListener;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.fpa.NotAvailableFPACharismaProfileService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.HashSet;
import java.util.Iterator;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public class ASLFPACharimsaProfileAPIImpl
implements ASLFPACharismaProfileAPI,
ServiceClient,
FPACharismaProfileServiceListener {
    private HashSet registeredCarClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileServiceListener;

    public HashSet getRegisteredCarClients() {
        if (this.registeredCarClients == null) {
            this.registeredCarClients = new HashSet();
        }
        return this.registeredCarClients;
    }

    @Override
    public void addFPAServiceListener(FPACharismaProfileServiceListener fPACharismaProfileServiceListener) {
        this.getRegisteredCarClients().add(fPACharismaProfileServiceListener);
    }

    @Override
    public void removeFPAServiceListener(FPACharismaProfileServiceListener fPACharismaProfileServiceListener) {
        this.getRegisteredCarClients().remove(fPACharismaProfileServiceListener);
    }

    @Override
    public FPACharismaProfileService getFPACharismaProfileService() {
        FPACharismaProfileService fPACharismaProfileService = (FPACharismaProfileService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService == null ? (class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService = ASLFPACharimsaProfileAPIImpl.class$("de.vw.mib.asl.api.car.fpa.FPACharismaProfileService")) : class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService);
        if (fPACharismaProfileService == null) {
            fPACharismaProfileService = new NotAvailableFPACharismaProfileService();
        }
        return fPACharismaProfileService;
    }

    @Override
    public void updateActiveProfile(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            FPACharismaProfileServiceListener fPACharismaProfileServiceListener = (FPACharismaProfileServiceListener)iterator.next();
            fPACharismaProfileServiceListener.updateActiveProfile(n);
        }
    }

    @Override
    public void updateFPAConfiguration(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            FPACharismaProfileServiceListener fPACharismaProfileServiceListener = (FPACharismaProfileServiceListener)iterator.next();
            fPACharismaProfileServiceListener.updateFPAConfiguration(n);
        }
    }

    @Override
    public void updateFPAisExistent(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            FPACharismaProfileServiceListener fPACharismaProfileServiceListener = (FPACharismaProfileServiceListener)iterator.next();
            fPACharismaProfileServiceListener.updateFPAServiceExisting(bl);
        }
    }

    @Override
    public void updateCharismaSetupTableWithoutOptionMask(CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            FPACharismaProfileServiceListener fPACharismaProfileServiceListener = (FPACharismaProfileServiceListener)iterator.next();
            fPACharismaProfileServiceListener.updateCharismaSetupTableWithoutOptionMask(charismaSetupTableWithoutOptionMaskArray);
        }
    }

    @Override
    public void updateCharismaSetupTableWithOptionMask(CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            FPACharismaProfileServiceListener fPACharismaProfileServiceListener = (FPACharismaProfileServiceListener)iterator.next();
            fPACharismaProfileServiceListener.updateCharismaSetupTableWithOptionMask(charismaSetupTableWithOptionMaskArray);
        }
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService == null ? (class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService = ASLFPACharimsaProfileAPIImpl.class$("de.vw.mib.asl.api.car.fpa.FPACharismaProfileService")) : class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileServiceListener == null ? (class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileServiceListener = ASLFPACharimsaProfileAPIImpl.class$("de.vw.mib.asl.api.car.fpa.FPACharismaProfileServiceListener")) : class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileServiceListener, this);
            this.updateFPAServiceExisting(true);
        }
    }

    @Override
    public void updateFPAServiceExisting(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            FPACharismaProfileServiceListener fPACharismaProfileServiceListener = (FPACharismaProfileServiceListener)iterator.next();
            fPACharismaProfileServiceListener.updateFPAServiceExisting(bl);
        }
    }

    @Override
    public void updateFPAFunctionAvailability(FPACharismaProfileFunctionAvailability fPACharismaProfileFunctionAvailability) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            FPACharismaProfileServiceListener fPACharismaProfileServiceListener = (FPACharismaProfileServiceListener)iterator.next();
            fPACharismaProfileServiceListener.updateFPAFunctionAvailability(fPACharismaProfileFunctionAvailability);
        }
    }

    @Override
    public void updateAvailableProfiles(boolean[] blArray) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            FPACharismaProfileServiceListener fPACharismaProfileServiceListener = (FPACharismaProfileServiceListener)iterator.next();
            fPACharismaProfileServiceListener.updateAvailableProfiles(blArray);
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

