/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileServiceListener;
import de.vw.mib.asl.internal.car.fpa.FPAStateWorkServices;
import de.vw.mib.asl.internal.car.fpa.HsmTargetFPA;
import de.vw.mib.asl.internal.car.fpa.service.FPACharismaProfileServiceImpl;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;

public class FPAMainController {
    private FPACharismaProfileServiceImpl fpaService;
    private FPAStateWorkServices stateWork;
    private HsmTargetFPA hsmTarget;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileServiceListener;

    public FPAMainController(FPAStateWorkServices fPAStateWorkServices, HsmTargetFPA hsmTargetFPA) {
        this.stateWork = fPAStateWorkServices;
        this.hsmTarget = hsmTargetFPA;
    }

    public void init() {
        this.fpaService = FPACharismaProfileServiceImpl.getInstance();
        this.fpaService.setMainController(this);
    }

    public boolean[] getAvailableProfiles() {
        return this.stateWork.getAvailableProfiles();
    }

    public FPACharismaProfileServiceListener getFpaServiceListener() {
        return (FPACharismaProfileServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileServiceListener == null ? (class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileServiceListener = FPAMainController.class$("de.vw.mib.asl.api.car.fpa.FPACharismaProfileServiceListener")) : class$de$vw$mib$asl$api$car$fpa$FPACharismaProfileServiceListener);
    }

    public void setFPAService(FPACharismaProfileServiceImpl fPACharismaProfileServiceImpl) {
        this.fpaService = fPACharismaProfileServiceImpl;
    }

    public void requestCharismaList(CharismaListUpdateInfo charismaListUpdateInfo) {
    }

    public void setActiveProfile(int n) {
        this.fpaService.setActiveProfile(n);
        this.getFpaServiceListener().updateActiveProfile(n);
    }

    public void changeActiveProfile(int n) {
        this.stateWork.changeActiveProfile(n);
    }

    public void changeCharismaSetupTableWithoutOptionMask(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    public void changeCharismaSetupTableWithOptionMask(int n, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    public void updateAvailableProfiles(boolean[] blArray) {
        this.getFpaServiceListener().updateAvailableProfiles(blArray);
    }

    public void updateActiveProfile(int n) {
        this.getFpaServiceListener().updateActiveProfile(n);
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaActiveProfile(int n, int n2) {
        this.getFpaServiceListener().updateActiveProfile(n);
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaListUpdateInfo(CharismaListUpdateInfo charismaListUpdateInfo, int n) {
        this.requestCharismaList(charismaListUpdateInfo);
    }

    public void dsiCarDrivingCharacteristicsResponseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    public void dsiCarDrivingCharacteristicsResponseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
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

