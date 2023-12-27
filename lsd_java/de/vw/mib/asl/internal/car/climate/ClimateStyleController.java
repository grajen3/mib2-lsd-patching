/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate;

import de.vw.mib.asl.api.car.climate.ClimateServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.climate.ClimateTargetServices;
import de.vw.mib.asl.internal.car.climate.ProfileCollector;
import de.vw.mib.asl.internal.car.climate.service.ClimateServiceValueFactory;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import generated.de.vw.mib.asl.internal.ListManager;

public class ClimateStyleController {
    final int AIR_STYLE_NOT_SUPPORTED;
    ProfileCollector[] profileList = new ProfileCollector[]{new ProfileCollector(), new ProfileCollector()};
    private boolean[] profileExistenceArray = new boolean[2];
    boolean[] climateStyleExistencyArray = new boolean[4];
    private ClimateTargetServices targetServices;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$climate$ClimateServiceListener;

    public boolean[] getClimateStyleExistencyArray() {
        return this.climateStyleExistencyArray;
    }

    public ClimateStyleController(ClimateTargetServices climateTargetServices) {
        this.AIR_STYLE_NOT_SUPPORTED = 255;
        this.targetServices = climateTargetServices;
    }

    public void updateAirconClimateStyleZone2(int n, int n2) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
        }
        this.getClimateServiceListener().updateClimateAirFlowStyle(new ClimateServiceValueFactory().createAirFlowStyleValue(1, n));
        this.informProfileCollectorToModel();
    }

    public void updateAirconClimateStyleZone1(int n, int n2) {
        switch (n) {
            case 0: {
                this.profileList[0].profileStyle = 0;
                break;
            }
            case 1: {
                this.profileList[0].profileStyle = 1;
                break;
            }
            case 2: {
                this.profileList[0].profileStyle = 2;
                break;
            }
            case 255: {
                this.profileList[0].profileStyle = 255;
                break;
            }
        }
        this.getClimateServiceListener().updateClimateAirFlowStyle(new ClimateServiceValueFactory().createAirFlowStyleValue(0, n));
        this.evaluateProfileExistency();
        this.informProfileCollectorToModel();
    }

    public void updateAirconClimateStyleZone3(int n, int n2) {
        switch (n) {
            case 0: {
                this.profileList[1].profileStyle = 0;
                break;
            }
            case 1: {
                this.profileList[1].profileStyle = 1;
                break;
            }
            case 2: {
                this.profileList[1].profileStyle = 2;
                break;
            }
            case 255: {
                this.profileList[1].profileStyle = 255;
                break;
            }
        }
        this.evaluateProfileExistency();
        this.informProfileCollectorToModel();
    }

    public void informProfileCollectorToModel() {
        ListManager.getGenericASLList(-525532928).updateList(this.profileList);
    }

    public void evaluateProfileExistency() {
        if (this.climateStyleExistencyArray[0] && this.profileList[0].profileStyle != 255) {
            this.profileExistenceArray[0] = true;
            ServiceManager.aslPropertyManager.valueChangedBoolean(326, true);
            ServiceManager.aslPropertyManager.valueChangedBoolean(315, true);
            this.targetServices.writeToLog(0, "NewClimateView:Proflie DD Front available");
        } else {
            this.profileExistenceArray[0] = false;
            ServiceManager.aslPropertyManager.valueChangedBoolean(326, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(315, false);
            this.targetServices.writeToLog(0, "NewClimateView:Proflie DD Front NOT available");
        }
        if (this.climateStyleExistencyArray[2] && this.profileList[1].profileStyle != 255) {
            this.profileExistenceArray[1] = true;
            this.targetServices.writeToLog(0, "NewClimateView:Proflie DD Rear available");
        } else {
            this.profileExistenceArray[1] = false;
            this.targetServices.writeToLog(0, "NewClimateView:Proflie DD Rear NOT available");
        }
        this.updateProfileExistencyToModel();
        this.informProfileCollectorToModel();
    }

    public void updateProfileExistencyToModel() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-592641792, this.profileExistenceArray);
    }

    public ClimateServiceListener getClimateServiceListener() {
        return (ClimateServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$climate$ClimateServiceListener == null ? (class$de$vw$mib$asl$api$car$climate$ClimateServiceListener = ClimateStyleController.class$("de.vw.mib.asl.api.car.climate.ClimateServiceListener")) : class$de$vw$mib$asl$api$car$climate$ClimateServiceListener);
    }

    public boolean getStyle(int n) {
        boolean bl = false;
        if (n >= 0 && n <= this.climateStyleExistencyArray.length) {
            return this.climateStyleExistencyArray[n];
        }
        return bl;
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

