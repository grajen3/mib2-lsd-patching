/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.arrays.vehiclestate;

import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateArrayElementAdapter;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateContext;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateDsiListener;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;

final class VehicleStateListDsiAdapter
implements VehicleStateDsiListener {
    private int _totalNumberOfElements;
    private ASGArrayList _vehicleStateArrayList;

    public VehicleStateListDsiAdapter(VehicleStateContext vehicleStateContext, ASGArrayList aSGArrayList) {
        this._vehicleStateArrayList = aSGArrayList;
    }

    private void setTotalNumberOfElements(int n) {
        this._totalNumberOfElements = n;
    }

    private int getTotalNumberOfElements() {
        return this._totalNumberOfElements;
    }

    private ASGArrayList getVehicleStateArrayList() {
        return this._vehicleStateArrayList;
    }

    private BAPStatusArray convertToStatusArrayHeader(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
        return BapArrayFactory.getInstance().getBAPArrayConverter().convertStatusArrayResponse(bCVehicleStateUpdateInfoAH.getStartElement(), bCVehicleStateUpdateInfoAH.getNumOfElements(), bCVehicleStateUpdateInfoAH.getArrayContent(), bCVehicleStateUpdateInfoAH.getRecordContent(), bCVehicleStateUpdateInfoAH.getTransactionID(), bCVehicleStateUpdateInfoAH.getAsgID(), this.getTotalNumberOfElements());
    }

    @Override
    public void dsiCarKombiResponseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        int n = nArray != null ? nArray.length : 0;
        BAPChangedArray bAPChangedArray = BapArrayFactory.getInstance().getBAPArrayConverter().convertChangedArrayUpdateInfo(bCVehicleStateUpdateInfoAH.startElement, bCVehicleStateUpdateInfoAH.getNumOfElements(), bCVehicleStateUpdateInfoAH.getArrayContent(), bCVehicleStateUpdateInfoAH.getRecordContent(), n > 0);
        if (nArray != null) {
            int n2 = nArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                VehicleStateArrayElementAdapter vehicleStateArrayElementAdapter = new VehicleStateArrayElementAdapter(bAPChangedArray.getArrayHeader());
                vehicleStateArrayElementAdapter.setPos(nArray[i2]);
                bAPChangedArray.getArrayData().add(vehicleStateArrayElementAdapter);
            }
        }
        this.getVehicleStateArrayList().changedArray(bAPChangedArray);
    }

    @Override
    public void dsiCarKombiUpdateBCVehicleStateListTotalNumberOfElements(int n, int n2) {
        this.setTotalNumberOfElements(n);
        if (n == 0) {
            this.getVehicleStateArrayList().clearList();
        }
    }

    @Override
    public void dsiCarKombiResponseVehicleStateListPos(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        this.dsiCarKombiResponseVehicleStateUpdateInfo(bCVehicleStateUpdateInfoAH, nArray);
    }

    @Override
    public void dsiCarKombiResponseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, int n2, String string, String string2) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(bCVehicleStateUpdateInfoAH);
        bAPStatusArray.getArrayData().add(new VehicleStateArrayElementAdapter(bAPStatusArray.getArrayHeader(), n, n2, string, string2));
        this.getVehicleStateArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarKombiResponseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(bCVehicleStateUpdateInfoAH);
        int n = listWarningIDsDynValuesArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            bAPStatusArray.getArrayData().add(new VehicleStateArrayElementAdapter(bAPStatusArray.getArrayHeader(), listWarningIDsDynValuesArray[i2]));
        }
        this.getVehicleStateArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarKombiResponseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListDynValues[] listDynValuesArray) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(bCVehicleStateUpdateInfoAH);
        int n = listDynValuesArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            bAPStatusArray.getArrayData().add(new VehicleStateArrayElementAdapter(bAPStatusArray.getArrayHeader(), listDynValuesArray[i2]));
        }
        this.getVehicleStateArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarKombiResponseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, String string) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(bCVehicleStateUpdateInfoAH);
        bAPStatusArray.getArrayData().add(new VehicleStateArrayElementAdapter(bAPStatusArray.getArrayHeader(), n, string));
        this.getVehicleStateArrayList().statusArray(bAPStatusArray);
    }
}

