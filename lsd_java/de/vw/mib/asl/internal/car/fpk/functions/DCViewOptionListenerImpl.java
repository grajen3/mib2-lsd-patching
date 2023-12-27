/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.functions;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.kombi.DCViewOptionsData;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.fpk.usecases.ServiceStateListener;
import de.vw.mib.asl.internal.car.fpk.usecases.ServiceStateListener$ServiceStateResult;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.srv.kombi.impl.DCViewOptionsWrapper;
import de.vw.mib.asl.internal.list.ASLListManager;
import org.dsi.ifc.carkombi.DCViewOptions;

public class DCViewOptionListenerImpl
implements ServiceStateListener {
    private MappingList mappingList = new MappingList(8);

    public DCViewOptionListenerImpl() {
        this.updateModel();
    }

    @Override
    public void updateServiceState(ServiceStateListener$ServiceStateResult serviceStateListener$ServiceStateResult) {
        DCViewOptions dCViewOptions = serviceStateListener$ServiceStateResult.getServiceViewOptions();
        if (null == dCViewOptions) {
            this.updateDCViewOptions(0);
            this.updateModel();
        } else {
            DCViewOptionsWrapper dCViewOptionsWrapper = new DCViewOptionsWrapper(dCViewOptions);
            this.updateDCViewOptions(dCViewOptionsWrapper, 0);
            this.updateModel();
        }
    }

    void updateModel() {
        ASLListManager aSLListManager = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLListManager();
        Object[] objectArray = this.mappingList.getFunctionStates();
        aSLListManager.getGenericASLList(10866).updateList(objectArray);
        aSLListManager.getGenericASLList(10867).updateList(objectArray);
        aSLListManager.getGenericASLList(10868).updateList(objectArray);
    }

    private void updateDCViewOptions(DCViewOptionsData dCViewOptionsData, int n) {
        this.addMapping(0, dCViewOptionsData.getElementContentSelectionList(), n);
        this.addMapping(1, dCViewOptionsData.getDisplay1Setup(), n);
        this.addMapping(2, dCViewOptionsData.getDisplay2Setup(), n);
        this.addMapping(3, dCViewOptionsData.setFactoryDefault(), n);
        this.addMapping(4, dCViewOptionsData.getDisplayPresetsList(), n);
        this.addMapping(5, dCViewOptionsData.getActiveDisplayPreset(), n);
        this.addMapping(6, dCViewOptionsData.getDisplayViewConfiguration(), n);
        this.addMapping(7, dCViewOptionsData.getDisplayDependency(), n);
    }

    private void updateDCViewOptions(int n) {
        this.addMapping(0, n);
        this.addMapping(1, n);
        this.addMapping(2, n);
        this.addMapping(3, n);
        this.addMapping(4, n);
        this.addMapping(5, n);
        this.addMapping(6, n);
        this.addMapping(7, n);
    }

    void addMapping(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingList.add(n, carFunctionState, n2);
    }

    void addMapping(int n, int n2) {
        this.mappingList.add(n, n2);
    }
}

