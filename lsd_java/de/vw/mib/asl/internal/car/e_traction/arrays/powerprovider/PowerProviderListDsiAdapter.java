/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider;

import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListArrayElementAdapter;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListContext;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListDsiListener;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;

class PowerProviderListDsiAdapter
implements PowerProviderListDsiListener {
    private int _totalNumberOfElements;
    private ASGArrayList _PowerProviderListArrayList;

    private void setTotalNumberOfElements(int n) {
        this._totalNumberOfElements = n;
    }

    private int getTotalNumberOfElements() {
        return this._totalNumberOfElements;
    }

    private ASGArrayList getProfileArrayList() {
        return this._PowerProviderListArrayList;
    }

    private BAPStatusArray convertToStatusArrayHeader(BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
        return BapArrayFactory.getInstance().getBAPArrayConverter().convertStatusArrayResponse(batteryControlPowerProviderAH.getStartElement(), batteryControlPowerProviderAH.getNumOfElements(), batteryControlPowerProviderAH.getArrayContent(), batteryControlPowerProviderAH.getRecordContent(), batteryControlPowerProviderAH.getTransactionID(), batteryControlPowerProviderAH.getAsgID(), this.getTotalNumberOfElements());
    }

    public PowerProviderListDsiAdapter(PowerProviderListContext powerProviderListContext, ASGArrayList aSGArrayList) {
        this._PowerProviderListArrayList = aSGArrayList;
    }

    @Override
    public void dsiCarHybridUpdateBatteryControlTotalNumberOfPowerProvider(int n, int n2) {
        this.setTotalNumberOfElements(n);
    }

    @Override
    public void dsiCarHybridResponsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlPowerProviderAH);
        for (BatteryControlPowerProviderRA0 batteryControlPowerProviderRA0 : batteryControlPowerProviderRA0Array) {
            bAPStatusArray.getArrayData().add(new PowerProviderListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlPowerProviderRA0));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlPowerProviderAH);
        for (BatteryControlPowerProviderRA1 batteryControlPowerProviderRA1 : batteryControlPowerProviderRA1Array) {
            bAPStatusArray.getArrayData().add(new PowerProviderListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlPowerProviderRA1));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlPowerProviderAH);
        for (BatteryControlPowerProviderRA2 batteryControlPowerProviderRA2 : batteryControlPowerProviderRA2Array) {
            bAPStatusArray.getArrayData().add(new PowerProviderListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlPowerProviderRA2));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlPowerProviderAH);
        for (BatteryControlPowerProviderRAE batteryControlPowerProviderRAE : batteryControlPowerProviderRAEArray) {
            bAPStatusArray.getArrayData().add(new PowerProviderListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlPowerProviderRAE));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponsePowerProviderListRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlPowerProviderAH);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            PowerProviderListArrayElementAdapter powerProviderListArrayElementAdapter = new PowerProviderListArrayElementAdapter(bAPStatusArray.getArrayHeader());
            powerProviderListArrayElementAdapter.setPos(nArray[i2]);
            bAPStatusArray.getArrayData().add(powerProviderListArrayElementAdapter);
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridUpdateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray, int n) {
        int n2 = nArray != null ? nArray.length : 0;
        BAPChangedArray bAPChangedArray = BapArrayFactory.getInstance().getBAPArrayConverter().convertChangedArrayUpdateInfo(batteryControlPowerProviderAH.startElement, batteryControlPowerProviderAH.getNumOfElements(), batteryControlPowerProviderAH.getArrayContent(), batteryControlPowerProviderAH.getRecordContent(), n2 > 0);
        if (nArray != null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                PowerProviderListArrayElementAdapter powerProviderListArrayElementAdapter = new PowerProviderListArrayElementAdapter(bAPChangedArray.getArrayHeader());
                powerProviderListArrayElementAdapter.setPos(nArray[i2]);
                bAPChangedArray.getArrayData().add(powerProviderListArrayElementAdapter);
            }
        }
        this.getProfileArrayList().changedArray(bAPChangedArray);
    }
}

