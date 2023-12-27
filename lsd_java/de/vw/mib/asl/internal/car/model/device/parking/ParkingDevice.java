/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.parking;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.drvass.DriverAssistanceViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.drvass.SWAViewOptionsData;
import de.vw.mib.asl.api.car.vo.parking.ParkingViewOptionData;
import de.vw.mib.asl.api.car.vo.parking.ParkingViewOptionListener;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.parking.ParkingDevice$1;
import generated.de.vw.mib.asl.internal.ListManager;

public class ParkingDevice
extends DriverAssistanceViewOptionAdapter
implements ParkingViewOptionListener {
    MappingList mappingList;
    private CarSetupMenu carSetupMenu;

    public ParkingDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(20);
        ASLCarFactory.getCarApi().getParkingViewOptionService().addListener(this);
        ASLCarFactory.getCarApi().getDriverAssistanceViewOptionService().addListener(this);
        ASLCarFactory.getCarApi().getComfortViewOptionService().addListener(new ParkingDevice$1(this));
        this.updateModel();
    }

    @Override
    public void updateParkingViewOptions(ParkingViewOptionData parkingViewOptionData, int n) {
        this.mappingList.add(1, parkingViewOptionData.getPdcSystemOnOff(), n);
        this.mappingList.add(2, parkingViewOptionData.getPdcAutoActivation(), n);
        this.mappingList.add(3, parkingViewOptionData.getPdcVolumeFront(), n);
        this.mappingList.add(4, parkingViewOptionData.getPdcFrequencyFront(), n);
        this.mappingList.add(5, parkingViewOptionData.getPdcVolumeRear(), n);
        this.mappingList.add(6, parkingViewOptionData.getPdcFrequencyRear(), n);
        this.mappingList.add(7, parkingViewOptionData.getPdcVolumeRear(), n);
        this.mappingList.add(9, parkingViewOptionData.getPdcParkboxVisualisation(), n);
        this.mappingList.add(11, parkingViewOptionData.getVpsExtCamConfig(), n);
        this.mappingList.add(12, parkingViewOptionData.getPdcManeuverAssistConfig(), n);
        this.mappingList.add(13, parkingViewOptionData.getPdcManeuverAssist(), n);
        this.mappingList.add(14, parkingViewOptionData.getPdcMute(), n);
        this.mappingList.add(15, parkingViewOptionData.getPdcOffroadMode(), n);
        this.mappingList.add(16, parkingViewOptionData.getVps3DBirdview(), n);
        this.mappingList.add(17, parkingViewOptionData.getExtCamInterior(), n);
        this.mappingList.add(18, parkingViewOptionData.getExtCamExterior(), n);
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10742).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10743).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10744).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(4, this.mappingList);
    }

    @Override
    public void updateSWAViewOptions(SWAViewOptionsData sWAViewOptionsData, int n) {
        this.mappingList.add(19, sWAViewOptionsData.getExitAssist(), n);
        this.mappingList.add(8, sWAViewOptionsData.getRcta(), n);
        this.updateModel();
    }

    @Override
    public void updateSWADevice(int n) {
        this.mappingList.add(19, n);
        this.mappingList.add(8, n);
        this.updateModel();
    }

    @Override
    public void updateParkingDevice(int n) {
        this.mappingList.add(1, n);
        this.mappingList.add(2, n);
        this.mappingList.add(3, n);
        this.mappingList.add(4, n);
        this.mappingList.add(5, n);
        this.mappingList.add(6, n);
        this.mappingList.add(7, n);
        this.mappingList.add(9, n);
        this.mappingList.add(11, n);
        this.mappingList.add(12, n);
        this.mappingList.add(14, n);
        this.mappingList.add(15, n);
        this.mappingList.add(16, n);
        this.mappingList.add(18, n);
        this.updateModel();
    }

    @Override
    public void updateParkingFifthCamCoded() {
        this.mappingList.add(17, 2);
    }
}

