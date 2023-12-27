/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.arrays.vehiclestate;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.api.car.vehicle.VehicleServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.asl.internal.car.service.HsmTargetCarService;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateArrayElementAdapter;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateContext;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateController;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.has.containers.VehicleStateContainer;
import generated.de.vw.mib.has.containers.VehicleStatesContainer;
import generated.de.vw.mib.has.contexts.car.CarProperties;

final class VehicleStateListModelUpdater
implements ASGArrayListChangeNotifier {
    VehicleStateContext _context;
    private CarProperties _hasCarProperties;
    private static final int HAS_VEHICLE_LIST_MAX_NUMBER_OF_ELEMENTS;
    private static final int IC_MLB_511_UNIQUE_WARN_ID_PREFIX;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener;

    public VehicleStateListModelUpdater(VehicleStateContext vehicleStateContext) {
        this._context = vehicleStateContext;
    }

    private VehicleStateContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    private VehicleStateController getVehicleStateController() {
        return this.getContext().getVehicleStateController();
    }

    private CarProperties getHasCarProperties() {
        if (this._hasCarProperties == null) {
            HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
            HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Car");
            this._hasCarProperties = (CarProperties)hASContext.getPropertiesImpl();
        }
        return this._hasCarProperties;
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        if (!aSGArrayList.isLoading()) {
            this._updateClients(aSGArrayList);
        }
        this.getVehicleStateController().requestAlternativeTextIfNecessary(bAPArrayDataList);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        if (!aSGArrayList.isLoading()) {
            this._updateClients(aSGArrayList);
        }
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        if (!aSGArrayList.isLoading()) {
            this._updateClients(aSGArrayList);
        }
        this.getVehicleStateController().requestAlternativeTextIfNecessary(bAPArrayDataList);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        if (!aSGArrayList.isLoading()) {
            this._updateClients(aSGArrayList);
        }
        this.getVehicleStateController().requestAlternativeTextIfNecessary(null);
    }

    private void _updateClients(ASGArrayList aSGArrayList) {
        this._updateHmiModel(aSGArrayList);
        this._updateVehicleListToHas(aSGArrayList);
        this._updateAppAdapter(aSGArrayList);
    }

    private static int transformWarnIdForHmi(int n) {
        int n2 = ServiceManager.configManagerDiag.getClusterInstrumentType(0) ? n | 0x100 : n;
        return n2;
    }

    private VehicleServiceListener getVehicleServiceListener() {
        return (VehicleServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener == null ? (class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener = VehicleStateListModelUpdater.class$("de.vw.mib.asl.api.car.vehicle.VehicleServiceListener")) : class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener);
    }

    private void _updateHmiModel(ASGArrayList aSGArrayList) {
        if (this.getContextLoger().isTraceEnabled()) {
            this.getContextLoger().trace("[INFO] Car Kombi: informing HMI with new warning IDs");
        }
        Object[] objectArray = aSGArrayList.getAllElements().toArray();
        int[] nArray = new int[objectArray.length];
        int n = objectArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            int n2;
            VehicleStateArrayElementAdapter vehicleStateArrayElementAdapter = (VehicleStateArrayElementAdapter)objectArray[i2];
            vehicleStateArrayElementAdapter.warningId = n2 = VehicleStateListModelUpdater.transformWarnIdForHmi(vehicleStateArrayElementAdapter.warningId);
            nArray[i2] = n2;
        }
        ListManager.getGenericASLList(10271).updateList(objectArray);
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10264, nArray);
    }

    private void _updateVehicleListToHas(ASGArrayList aSGArrayList) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        int n = Math.min(50, aSGArrayList.size());
        VehicleStateContainer[] vehicleStateContainerArray = new VehicleStateContainer[n];
        for (int i2 = 0; i2 < n; ++i2) {
            VehicleStateContainer vehicleStateContainer = (VehicleStateContainer)hASFactory.createContainer(62);
            VehicleStateArrayElementAdapter vehicleStateArrayElementAdapter = (VehicleStateArrayElementAdapter)aSGArrayList.get(i2);
            vehicleStateContainer.setWarnId(vehicleStateArrayElementAdapter.getWarningID());
            vehicleStateContainer.setDynamicValue(vehicleStateArrayElementAdapter.getDynValue());
            vehicleStateContainer.setElementId(vehicleStateArrayElementAdapter.getPos());
            vehicleStateContainerArray[i2] = vehicleStateContainer;
        }
        VehicleStatesContainer vehicleStatesContainer = (VehicleStatesContainer)hASFactory.createContainer(63);
        vehicleStatesContainer.setStates(vehicleStateContainerArray);
        this.getHasCarProperties().updateVehicleStates(vehicleStatesContainer);
    }

    private void _updateAppAdapter(ASGArrayList aSGArrayList) {
        BAPArrayElement[] bAPArrayElementArray = aSGArrayList.getAllElements().toArray();
        ((HsmTargetCarService)this.getContext()).setWarningCount(bAPArrayElementArray.length);
        this.getVehicleServiceListener().updateWarningCount(((HsmTargetCarService)this.getContext()).getWarningCount());
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

