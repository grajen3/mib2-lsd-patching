/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.viewoption;

import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.viewoption.FunctionIds;
import de.vw.mib.asl.internal.car.viewoption.HsmTargetCarViewOption;
import de.vw.mib.asl.internal.car.viewoption.StateWork;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.carcomfort.WiperViewOptions;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.carlight.IntLightMembersIlluminationSet;
import org.dsi.ifc.carlight.IntLightMembersMultiColor;
import org.dsi.ifc.global.CarViewOption;

public class StateWorkMLB
extends StateWork {
    public StateWorkMLB(HsmTargetCarViewOption hsmTargetCarViewOption, Hsm hsm, String string, HsmState hsmState) {
        super(hsmTargetCarViewOption, hsm, string, hsmState);
    }

    @Override
    protected void carMenuAvailability() {
        super.carMenuAvailability();
        this.existentState(36, FunctionIds.EXISTENT_NV, this.configManPersCarFuncAdapImpl.getBoolean(320), this.configManPersCarFuncAdapImpl.getBoolean(322), this.configManPersCarFuncAdapImpl.getBoolean(323), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
        this.existentState(37, FunctionIds.EXISTENT_AIR_SUSPENSION, this.configManPersCarFuncAdapImpl.getBoolean(295), this.configManPersCarFuncAdapImpl.getBoolean(297), this.configManPersCarFuncAdapImpl.getBoolean(298), 18, FunctionIds.CHILD_SERVICE);
    }

    @Override
    protected void resettingAllSettings() {
        this.myTarget.dsiCarParkingSystem.setPdcSetFactoryDefault();
        this.myTarget.dsiCarParkingSystem.setVpsSetFactoryDefault();
        this.myTarget.dsiCarLight.setIntLightSetFactoryDefault();
        this.myTarget.dsiCarLight.setExtLightSetFactoryDefault();
        this.myTarget.dsiCarComfort.setMirrorSetFactoryDefault();
        this.myTarget.dsiCarComfort.setWiperSetFactoryDefault();
        this.myTarget.dsiCarComfort.setDoorLockingSetFactoryDefault();
        this.myTarget.dsiCarComfort.setRgsSetFactoryDefault();
        this.myTarget.dsiCarSeat.setSeatSetFactoryDefault();
        this.myTarget.dsiCarKombi.setBcSetFactoryDefault();
        this.myTarget.dsiCarAuxHeaterCooler.setAuxHeaterSetFactoryDefault();
        this.myTarget.dsiCarAirCondition.setAirconSetFactoryDefaultMaster();
        this.myTarget.dsiCarEco.setEASetFactoryDefault();
        this.myTarget.dsiCarKombi.setHUDSetFactoryDefault();
        this.myTarget.dsiCarComfort.setRDKSetFactoryDefault();
    }

    public void dsiCarDriverAssistanceUpdateNVViewOptions(NVViewOptions nVViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: nvViewOptions: ").append(nVViewOptions.toString()).log();
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(nVViewOptions.getObjectDetection().getState(), 205, nVViewOptions.getObjectDetection().getReason());
        this.evaluateViewOptions(nVViewOptions.getContrast().getState(), 206, nVViewOptions.getContrast().getReason());
    }

    public void dsiCarDrivingCharacteristicsUpdateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: suspensionControlViewOptions: ").append(suspensionControlViewOptions.toString()).log();
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(suspensionControlViewOptions.getCarJackMode().getState(), 207, suspensionControlViewOptions.getCarJackMode().getReason());
    }

    @Override
    public void dsiCarComfortUpdateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        this.evaluateViewOptions(wiperViewOptions.getEasyEntrySteeringColumn().getState(), 208, wiperViewOptions.getEasyEntrySteeringColumn().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_OPENCLOSE, 13, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    @Override
    void illuminationSet(int n, CarViewOption carViewOption, int n2, IntLightMembersIlluminationSet intLightMembersIlluminationSet, IntLightMembersMultiColor intLightMembersMultiColor) {
        super.illuminationSet(n, carViewOption, n2, intLightMembersIlluminationSet, intLightMembersMultiColor);
        switch (n) {
            case 5: {
                ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT_REAR = n2;
                this.evaluateViewOptions(carViewOption.getState(), 59, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(StateWork.AMBIENCE_LIGHT_FEATURE_FOOTWELL, intLightMembersIlluminationSet.isFrontFootwellLighting() ? 1 : 0, intLightMembersMultiColor.isFrontFootwellLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_FOOTWELL, intLightMembersIlluminationSet.isRearFootwellLighting() ? 1 : 0, intLightMembersMultiColor.isRearFootwellLighting(), n2);
                this.featureMapping(5, intLightMembersIlluminationSet);
                break;
            }
            case 7: {
                ASLCarContainer.DP_ILLUMINATION_DOORS_FRONT_REAR = n2;
                this.evaluateViewOptions(carViewOption.getState(), 58, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_DOORS, intLightMembersIlluminationSet.isFrontDoorsStripLighting() ? 1 : 0, intLightMembersMultiColor.isFrontDoorsStripLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_HANDLE, intLightMembersIlluminationSet.isFrontDoorsLighting() ? 1 : 0, intLightMembersMultiColor.isFrontDoorsLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_RECTANGLE, intLightMembersIlluminationSet.isFrontDoorsWarningLighting() ? 1 : 0, intLightMembersMultiColor.isFrontDoorsWarningLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_STRIP, intLightMembersIlluminationSet.isRearDoorsStripLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsStripLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS, intLightMembersIlluminationSet.isRearDoorsLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_WARNING, intLightMembersIlluminationSet.isRearDoorsWarningLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsWarningLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOOR_POCKET, intLightMembersIlluminationSet.isRearDoorPocketLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorPocketLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_ENTRANCE, intLightMembersIlluminationSet.isRearDoorsEntranceLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsEntranceLighting(), n2);
                this.featureMapping(7, intLightMembersIlluminationSet);
                break;
            }
            case 12: {
                ASLCarContainer.DP_ILLUMINATION_FRONT = n2;
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.featureMapping(11, intLightMembersIlluminationSet);
                break;
            }
        }
    }
}

