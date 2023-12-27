/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa.service;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileFunctionAvailability;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileService;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileState;
import de.vw.mib.asl.internal.car.fpa.FPAMainController;
import de.vw.mib.asl.internal.car.fpa.service.FPACharismaProfileFunctionAvailabilityImpl;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.genericevents.GenericEventException;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public class FPACharismaProfileServiceImpl
implements FPACharismaProfileService {
    private static FPACharismaProfileServiceImpl instance = null;
    private FPAMainController mainController;
    private FPACharismaProfileFunctionAvailabilityImpl functionAvailability = new FPACharismaProfileFunctionAvailabilityImpl();
    private int profileActive = 0;
    private int fpaConfiguration = 0;
    private boolean isFpaExistent = false;
    private boolean[] availableProfiles;
    private CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMask;
    private CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMask;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService;

    public static FPACharismaProfileServiceImpl getInstance() {
        if (instance == null) {
            instance = new FPACharismaProfileServiceImpl();
        }
        return instance;
    }

    public void registerServiceProvider() {
        ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService == null ? (class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService = FPACharismaProfileServiceImpl.class$("de.vw.mib.asl.api.car.fpa.FPACharismaProfileService")) : class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileService, this);
    }

    public void setMainController(FPAMainController fPAMainController) {
        this.mainController = fPAMainController;
    }

    public void setActiveProfile(int n) {
        this.profileActive = n;
    }

    public void setFPAConfiguration(int n) {
        this.fpaConfiguration = n;
    }

    public void setAvailableProfiles(boolean[] blArray) {
        this.availableProfiles = blArray;
    }

    public void setCharismaSetupTableWithoutOptionMask(CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        this.charismaSetupTableWithoutOptionMask = charismaSetupTableWithoutOptionMaskArray;
    }

    public void setCharismaSetupTableWithOptionMask(CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        this.charismaSetupTableWithOptionMask = charismaSetupTableWithOptionMaskArray;
    }

    public void setFunctionStates(FPACharismaProfileState[] fPACharismaProfileStateArray) {
        this.functionAvailability.setFunctionStates(fPACharismaProfileStateArray);
    }

    public void setProfilesAvailable(boolean[] blArray) {
        this.functionAvailability.setProfilesAvailable(blArray);
    }

    public void setFpaExistent(boolean bl) {
        this.isFpaExistent = bl;
    }

    @Override
    public int getProfileActive() {
        return this.profileActive;
    }

    @Override
    public void changeProfileActive(int n) {
        try {
            this.mainController.changeActiveProfile(n);
        }
        catch (GenericEventException genericEventException) {
            // empty catch block
        }
    }

    @Override
    public int getFPAConfiguration() {
        return this.fpaConfiguration;
    }

    @Override
    public boolean isFPAExistent() {
        return this.isFpaExistent;
    }

    @Override
    public FPACharismaProfileFunctionAvailability getFPACharismaProfileFunctionAvailability() {
        return this.functionAvailability;
    }

    @Override
    public CharismaSetupTableWithoutOptionMask[] getCharismaSetupTableWithoutOptionMask() {
        return this.charismaSetupTableWithoutOptionMask;
    }

    @Override
    public void changeCharismaSetupTableWithoutOptionMask(CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        this.mainController.changeCharismaSetupTableWithoutOptionMask(this.profileActive, charismaSetupTableWithoutOptionMaskArray);
    }

    @Override
    public CharismaSetupTableWithOptionMask[] getCharismaTableWithOptionMask() {
        return this.charismaSetupTableWithOptionMask;
    }

    @Override
    public void changeCharismaTableWithOptionMask(CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        this.mainController.changeCharismaSetupTableWithOptionMask(this.profileActive, charismaSetupTableWithOptionMaskArray);
    }

    @Override
    public boolean[] getAvailableProfiles() {
        return this.mainController.getAvailableProfiles();
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

