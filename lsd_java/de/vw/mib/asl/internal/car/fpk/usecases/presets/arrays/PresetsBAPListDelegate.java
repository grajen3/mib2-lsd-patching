/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPElement;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class PresetsBAPListDelegate
implements ASGArrayListDelegate {
    private final Logger bapLogger;
    private final DSICarKombi dsiCarKombi;
    private static final int MAX_ELEMENTS_PER_REQUEST;

    public PresetsBAPListDelegate(Logger logger, DSICarKombi dSICarKombi) {
        this.bapLogger = logger;
        this.dsiCarKombi = dSICarKombi;
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        this.dsiCarKombi.requestDCDisplayPresetsList(PresetsBAPListDelegate.toArrayHeader(bAPGetArray));
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
        BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
        DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray = new DCDisplayPresetsListRecord[bAPArrayElementArray.length];
        int n = bAPArrayElementArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            PresetsBAPElement presetsBAPElement = (PresetsBAPElement)bAPArrayElementArray[i2];
            dCDisplayPresetsListRecordArray[i2] = presetsBAPElement.getModel();
        }
        this.dsiCarKombi.setDCDisplayPresetsList(PresetsBAPListDelegate.toArrayHeader(bAPSetGetArray), dCDisplayPresetsListRecordArray);
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        AppLogger.error(this, new StringBuffer().append(".requestTimeout( arrayList = ['DCDisplayPresetsList' AsgId = ").append(aSGArrayList.getAsgId()).append(", ListId = ").append(aSGArrayList.getListId()).append("]").append(", counter = ").append(n).append(", finished = ").append(bl).append(" ), request time out for display presets").toString());
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        return 5;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 2;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this.bapLogger;
    }

    private static CarArrayListUpdateInfo toArrayHeader(BAPGetArray bAPGetArray) {
        int n = ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().toArrayContent(bAPGetArray);
        CarArrayListUpdateInfo carArrayListUpdateInfo = new CarArrayListUpdateInfo(bAPGetArray.getAsgId(), bAPGetArray.getTransactionId(), bAPGetArray.getArrayHeader().getRecordAddress(), n, bAPGetArray.getArrayHeader().start, bAPGetArray.getArrayHeader().elements);
        return carArrayListUpdateInfo;
    }
}

