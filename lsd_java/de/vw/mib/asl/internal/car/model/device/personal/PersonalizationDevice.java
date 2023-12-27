/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.personal;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionService;
import de.vw.mib.asl.api.car.vo.comfort.DoorLockingViewOptionsData;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import generated.de.vw.mib.asl.internal.ListManager;

public class PersonalizationDevice
extends ComfortViewOptionAdapter {
    private MappingList mappingList;
    private ComfortViewOptionService psoService;
    private CarSetupMenu carSetupMenu;
    private boolean isconfigured;

    public PersonalizationDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(3);
        this.psoService = ASLCarFactory.getCarApi().getComfortViewOptionService();
        this.psoService.addListener(this);
        this.updateModel();
    }

    @Override
    public void updatePersonalizationConfiguration(boolean bl) {
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "Pers.notifyPso3");
        this.isconfigured = bl;
        if (bl) {
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "Pers.notifyPso4");
            this.mappingList.add(0, 2);
            this.mappingList.add(1, 2);
            this.mappingList.add(2, 2);
            this.updateModel();
        }
    }

    @Override
    public void updateDoorLockingViewOptions(DoorLockingViewOptionsData doorLockingViewOptionsData, int n) {
        this.mappingList.add(0, doorLockingViewOptionsData.getUserProfileOnOff(), n);
        this.mappingList.add(1, doorLockingViewOptionsData.getUserList(), n);
        this.mappingList.add(2, doorLockingViewOptionsData.getUserProfileControl(), n);
        this.updateModel();
    }

    @Override
    public void updateDoorLockingDevice(int n) {
        if (this.isconfigured) {
            this.mappingList.add(0, n);
            this.mappingList.add(1, n);
            this.mappingList.add(2, n);
            this.updateModel();
        }
    }

    private void updateModel() {
        this.carSetupMenu.updateMenu(14, this.mappingList);
        ListManager.getGenericASLList(10764).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10765).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10766).updateList(this.mappingList.getFunctionStates());
    }
}

