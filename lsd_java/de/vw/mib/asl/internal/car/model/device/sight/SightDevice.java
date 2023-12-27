/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.sight;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionService;
import de.vw.mib.asl.api.car.vo.comfort.MirrorViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.WiperViewOptionsData;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import generated.de.vw.mib.asl.internal.ListManager;

public class SightDevice
extends ComfortViewOptionAdapter {
    private MappingList mappingList;
    private ComfortViewOptionService sightService;
    private CarSetupMenu carSetupMenu;

    public SightDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(7);
        this.sightService = ASLCarFactory.getCarApi().getComfortViewOptionService();
        this.sightService.addListener(this);
        this.updateModel();
    }

    private void updateModel() {
        ListManager.getGenericASLList(10754).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10736).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10735).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(8, this.mappingList);
    }

    @Override
    public void updateMirrorViewOptions(MirrorViewOptionsData mirrorViewOptionsData, int n) {
        this.mappingList.add(0, mirrorViewOptionsData.getMirrorSyncAdjust(), n);
        this.mappingList.add(1, mirrorViewOptionsData.getMirrorLowering(), n);
        this.mappingList.add(2, mirrorViewOptionsData.getMirrorFolding(), n);
        this.mappingList.add(3, mirrorViewOptionsData.getMirrorHeating(), n);
        this.mappingList.add(4, mirrorViewOptionsData.getMirrorDimming(), n);
        this.updateModel();
    }

    @Override
    public void updateMirrorDevice(int n) {
        this.mappingList.add(0, n);
        this.mappingList.add(1, n);
        this.mappingList.add(2, n);
        this.mappingList.add(3, n);
        this.mappingList.add(4, n);
        this.updateModel();
    }

    @Override
    public void updateWiperViewOptions(WiperViewOptionsData wiperViewOptionsData, int n) {
        this.mappingList.add(5, wiperViewOptionsData.getWiperRainSensorOnOff(), n);
        this.mappingList.add(6, wiperViewOptionsData.getWiperRearWiping(), n);
        this.updateModel();
    }

    @Override
    public void updateWiperDevice(int n) {
        this.mappingList.add(5, n);
        this.mappingList.add(6, n);
        this.updateModel();
    }
}

