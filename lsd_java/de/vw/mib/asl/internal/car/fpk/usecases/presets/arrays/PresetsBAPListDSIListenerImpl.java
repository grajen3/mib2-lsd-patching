/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPElement;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPListDSIListener;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class PresetsBAPListDSIListenerImpl
implements PresetsBAPListDSIListener {
    private boolean isBapListAvailable;
    private int bapListElementsCount;
    private final ASGArrayList bapList;

    public PresetsBAPListDSIListenerImpl(ASGArrayList aSGArrayList) {
        this.bapList = aSGArrayList;
    }

    public ASGArrayList getList() {
        return this.bapList;
    }

    @Override
    public void onServiceStateChanged(boolean bl) {
        if (this.isBapListAvailable != bl) {
            this.isBapListAvailable = bl;
            if (!bl) {
                this.bapList.clearList();
            }
        }
    }

    @Override
    public void dsiCarKombiUpdateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray, int n) {
        int n2 = dCDisplayPresetsListRecordArray != null ? dCDisplayPresetsListRecordArray.length : 0;
        BAPChangedArray bAPChangedArray = ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().convertChangedArrayUpdateInfo(carArrayListUpdateInfo.getStartElement(), carArrayListUpdateInfo.getNumOfElements(), carArrayListUpdateInfo.getArrayContent(), carArrayListUpdateInfo.getRecordContent(), n2 > 0);
        if (dCDisplayPresetsListRecordArray != null) {
            int n3 = dCDisplayPresetsListRecordArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                PresetsBAPElement presetsBAPElement = new PresetsBAPElement(bAPChangedArray.getArrayHeader(), dCDisplayPresetsListRecordArray[i2]);
                bAPChangedArray.getArrayData().add(presetsBAPElement);
            }
        }
        this.bapList.changedArray(bAPChangedArray);
    }

    @Override
    public void dsiCarKombiUpdateDCDisplayPresetsListTotalNumberOfElements(int n, int n2) {
        this.bapListElementsCount = n;
    }

    @Override
    public void dsiCarKombiResponseDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        BAPStatusArray bAPStatusArray = ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().convertStatusArrayResponse(carArrayListUpdateInfo.getStartElement(), carArrayListUpdateInfo.getNumOfElements(), carArrayListUpdateInfo.getArrayContent(), carArrayListUpdateInfo.getRecordContent(), carArrayListUpdateInfo.getTransactionID(), carArrayListUpdateInfo.getAsgID(), this.bapListElementsCount);
        for (DCDisplayPresetsListRecord dCDisplayPresetsListRecord : dCDisplayPresetsListRecordArray) {
            bAPStatusArray.getArrayData().add(new PresetsBAPElement(bAPStatusArray.getArrayHeader(), dCDisplayPresetsListRecord));
        }
        this.bapList.statusArray(bAPStatusArray);
    }
}

