/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.arrays.vehiclestate;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateArrayElementAdapter;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateContext;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateDsiListener;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateListDsiAdapter;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateListModelUpdater;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.util.Util;
import java.util.Iterator;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;

public class VehicleStateController
implements ASGArrayListFactory,
ASGArrayListDelegate,
Logger {
    private VehicleStateContext _context;
    private ASGArrayList _vehicleStateArrayList;
    private VehicleStateDsiListener _vehicleStateDsiListener;
    private boolean _listAvailable;
    private static final int MAX_NUMBER_TO_REQUEST_VEHICLE_STATUS;
    private static final int MAX_NUMBER_TO_REQUEST_VEHICLE_STATUS_ALTERNATIVE_TEXT;
    private static final int HIGH_LEVEL_RETRY_NUMBER_OF_RETRIES;
    private static final long HIGH_LEVEL_RETRY_RETRY_TIME;

    public VehicleStateController(VehicleStateContext vehicleStateContext) {
        this._context = vehicleStateContext;
    }

    private VehicleStateContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    private ASGArrayList getVehicleStateArrayList() {
        if (this._vehicleStateArrayList == null) {
            this._vehicleStateArrayList = new ArrayListFactory().createCompleteArrayList(this, new VehicleStateListModelUpdater(this.getContext()), this, 1, 0, true, 4, 0);
        }
        return this._vehicleStateArrayList;
    }

    public VehicleStateDsiListener getVehicleStateDsiListener() {
        if (this._vehicleStateDsiListener == null) {
            this._vehicleStateDsiListener = new VehicleStateListDsiAdapter(this.getContext(), this.getVehicleStateArrayList());
        }
        return this._vehicleStateDsiListener;
    }

    public void setListAvailable(boolean bl) {
        if (this._listAvailable != bl) {
            this._listAvailable = bl;
            if (bl) {
                this.vehicleArrayListBecomesAvailable();
            } else {
                this.vehicleArrayListBecomesUnavailable();
            }
        }
    }

    public boolean getListAvailable() {
        return this._listAvailable;
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return null;
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new VehicleStateArrayElementAdapter();
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        VehicleStateArrayElementAdapter vehicleStateArrayElementAdapter = new VehicleStateArrayElementAdapter((VehicleStateArrayElementAdapter)bAPArrayElement);
        VehicleStateArrayElementAdapter vehicleStateArrayElementAdapter2 = (VehicleStateArrayElementAdapter)bAPArrayElement2;
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                vehicleStateArrayElementAdapter.setAlternativeText(vehicleStateArrayElementAdapter2.getAlternativeText());
                break;
            }
            case 2: {
                vehicleStateArrayElementAdapter.setDynValue(vehicleStateArrayElementAdapter2.getDynValue());
                vehicleStateArrayElementAdapter.setWarningID(vehicleStateArrayElementAdapter2.getWarningID());
                break;
            }
            case 3: {
                vehicleStateArrayElementAdapter.setWarningID(vehicleStateArrayElementAdapter2.getWarningID());
                vehicleStateArrayElementAdapter.setAlternativeText(vehicleStateArrayElementAdapter2.getAlternativeText());
                break;
            }
            default: {
                this.getContextLoger().error("VehicleStatus: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return vehicleStateArrayElementAdapter;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return BapArrayFactory.getInstance().createBapArrayTimer(timerNotifier, l);
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        int n = BapArrayFactory.getInstance().getBAPArrayConverter().toArrayContent(bAPGetArray);
        ArrayHeader arrayHeader = bAPGetArray.getArrayHeader();
        BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH = new BCVehicleStateUpdateInfoAH(n, arrayHeader.getRecordAddress(), arrayHeader.start, arrayHeader.elements, bAPGetArray.getTransactionId(), bAPGetArray.getAsgId());
        this.getContext().getDsiVehicleState().requestVehicleStateList(bCVehicleStateUpdateInfoAH);
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        this.getContextLoger().error("VehicleStatus: Request time out for vehicle status");
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        int n2;
        switch (n) {
            case 0: 
            case 2: {
                n2 = 1;
                break;
            }
            case 1: 
            case 3: 
            case 15: {
                n2 = 5;
                break;
            }
            default: {
                this.getContextLoger().error("Wrong recordAddress given in getMaxRequestableElements");
                n2 = 5;
            }
        }
        return n2;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 1;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = new StringBuffer().append("VehicleStatus: ").append(string).toString();
        switch (n) {
            case 1: {
                this.getContextLoger().fatal(string2);
                break;
            }
            case 2: {
                this.getContextLoger().error(string2);
                break;
            }
            case 4: {
                this.getContextLoger().warn(string2);
                break;
            }
            case 8: {
                this.getContextLoger().info(string2);
                break;
            }
            case 12: {
                this.getContextLoger().normal(string2);
                break;
            }
            case 16: {
                if (!this.getContextLoger().isTraceEnabled()) break;
                this.getContextLoger().trace(string2);
                break;
            }
            default: {
                this.getContextLoger().error("VehicleStatus: Unknown log message called");
            }
        }
    }

    void requestAlternativeTextIfNecessary(BAPArrayDataList bAPArrayDataList) {
        Iterator iterator;
        ASGArrayList aSGArrayList = this.getVehicleStateArrayList();
        Iterator iterator2 = iterator = bAPArrayDataList != null ? bAPArrayDataList.getIterator() : aSGArrayList.getAllElements().getIterator();
        while (iterator.hasNext()) {
            VehicleStateArrayElementAdapter vehicleStateArrayElementAdapter = (VehicleStateArrayElementAdapter)iterator.next();
            boolean bl = Util.isNullOrEmpty(vehicleStateArrayElementAdapter.alternativeText) && !ServiceManager.configManagerDiag.isVehicleStatusWarningIdAvailable(vehicleStateArrayElementAdapter.getWarningID()) && !ServiceManager.configManagerDiag.isArabicReplacementActive();
            if (!bl) continue;
            if (this.getContextLoger().isTraceEnabled()) {
                this.getContextLoger().trace("[INFO] Car Kombi vehicleList: Request alternative text");
            }
            aSGArrayList.refreshElements(vehicleStateArrayElementAdapter, 1, 2);
        }
    }

    private void vehicleArrayListBecomesAvailable() {
        this.getVehicleStateArrayList().reloadData();
    }

    private void vehicleArrayListBecomesUnavailable() {
        this.getVehicleStateArrayList().clearList();
    }
}

