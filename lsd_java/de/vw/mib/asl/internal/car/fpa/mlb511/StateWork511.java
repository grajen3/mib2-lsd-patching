/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa.mlb511;

import de.vw.mib.asl.internal.car.fpa.HsmTargetFPA;
import de.vw.mib.asl.internal.car.fpa.StateWork;
import de.vw.mib.asl.internal.car.fpa.transformer.CollectorFPASettings;
import de.vw.mib.asl.internal.car.transformer.CarFunctionCollector;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;

public class StateWork511
extends StateWork {
    public StateWork511(HsmTargetFPA hsmTargetFPA, Hsm hsm, String string, HsmState hsmState) {
        super(hsmTargetFPA, hsm, string, hsmState);
    }

    private static ArrayList computeHardcodedVwMlb511CharismaList() {
        ArrayList arrayList = new ArrayList();
        CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray = new CharismaSetupTableWithoutOptionMask[]{};
        CollectorFPASettings collectorFPASettings = new CollectorFPASettings(5, HsmTargetFPA.createEmptyFunctionListCollector(), charismaSetupTableWithoutOptionMaskArray);
        arrayList.add(collectorFPASettings);
        charismaSetupTableWithoutOptionMaskArray = new CharismaSetupTableWithoutOptionMask[]{};
        collectorFPASettings = new CollectorFPASettings(1, HsmTargetFPA.createEmptyFunctionListCollector(), charismaSetupTableWithoutOptionMaskArray);
        arrayList.add(collectorFPASettings);
        charismaSetupTableWithoutOptionMaskArray = new CharismaSetupTableWithoutOptionMask[]{};
        collectorFPASettings = new CollectorFPASettings(2, HsmTargetFPA.createEmptyFunctionListCollector(), charismaSetupTableWithoutOptionMaskArray);
        arrayList.add(collectorFPASettings);
        charismaSetupTableWithoutOptionMaskArray = new CharismaSetupTableWithoutOptionMask[]{};
        collectorFPASettings = new CollectorFPASettings(3, HsmTargetFPA.createEmptyFunctionListCollector(), charismaSetupTableWithoutOptionMaskArray);
        arrayList.add(collectorFPASettings);
        return arrayList;
    }

    public static void setupInitialCharismaList(ArrayList arrayList) {
        arrayList.clear();
        arrayList.addAll(StateWork511.computeHardcodedVwMlb511CharismaList());
    }

    @Override
    protected boolean requestProfileInformationNeeded(int n) {
        return n == 7 ? super.requestProfileInformationNeeded(n) : true;
    }

    @Override
    public void dsiCarDrivingCharacteristicsUpdateCharismaActiveProfile(int n, int n2) {
        super.dsiCarDrivingCharacteristicsUpdateCharismaActiveProfile(n, n2);
        super.setHmiReady(true);
    }

    @Override
    protected void setProfileAvailableState(CharismaViewOptions charismaViewOptions, CarFunctionCollector[] carFunctionCollectorArray, boolean[] blArray) {
        carFunctionCollectorArray[0] = new CarFunctionCollector(false, 0);
        blArray[0] = false;
        carFunctionCollectorArray[5] = new CarFunctionCollector(true, 0);
        blArray[5] = charismaViewOptions.getConfiguration().getProfilesAvailable().efficiency;
        carFunctionCollectorArray[1] = new CarFunctionCollector(true, 0);
        blArray[1] = charismaViewOptions.getConfiguration().getProfilesAvailable().comfort;
        carFunctionCollectorArray[2] = new CarFunctionCollector(true, 0);
        blArray[2] = charismaViewOptions.getConfiguration().getProfilesAvailable().autonormal;
        carFunctionCollectorArray[3] = new CarFunctionCollector(true, 0);
        blArray[3] = charismaViewOptions.getConfiguration().getProfilesAvailable().dynamic;
        carFunctionCollectorArray[7] = new CarFunctionCollector(true, 0);
        blArray[7] = charismaViewOptions.getConfiguration().getProfilesAvailable().individual;
    }

    @Override
    protected void mergeProfileSetupTable(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray, CollectorFPASettings collectorFPASettings) {
        for (int i2 = charismaSetupTableWithoutOptionMaskArray.length - 1; i2 >= 0; --i2) {
            for (int i3 = collectorFPASettings.setupTable.length - 1; i3 >= 0; --i3) {
                if (charismaSetupTableWithoutOptionMaskArray[i2].listPosition != collectorFPASettings.setupTable[i3].listPosition || charismaSetupTableWithoutOptionMaskArray[i2].functionID != collectorFPASettings.setupTable[i3].functionID) continue;
                collectorFPASettings.setupTable[i3].setupValue = charismaSetupTableWithoutOptionMaskArray[i2].setupValue;
            }
        }
    }

    @Override
    protected CharismaSetupTableWithoutOptionMask[] computeSetupTableRequestForChangedFunction(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray2 = null;
        for (int i2 = charismaSetupTableWithoutOptionMaskArray.length - 1; i2 >= 0; --i2) {
            if (charismaSetupTableWithoutOptionMaskArray[i2].functionID != n) continue;
            charismaSetupTableWithoutOptionMaskArray2 = new CharismaSetupTableWithoutOptionMask[]{charismaSetupTableWithoutOptionMaskArray[i2]};
            break;
        }
        return charismaSetupTableWithoutOptionMaskArray2 == null ? charismaSetupTableWithoutOptionMaskArray : charismaSetupTableWithoutOptionMaskArray2;
    }

    private static CharismaSetupTableWithoutOptionMask[] getSetupTableForProfile(int n, ArrayList arrayList) {
        CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray = new CharismaSetupTableWithoutOptionMask[]{};
        for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
            CollectorFPASettings collectorFPASettings = (CollectorFPASettings)arrayList.get(i2);
            if (n != collectorFPASettings.profileID) continue;
            charismaSetupTableWithoutOptionMaskArray = collectorFPASettings.setupTable;
            break;
        }
        return charismaSetupTableWithoutOptionMaskArray;
    }

    @Override
    protected void setCharismaSetFactoryDefault(DSICarDrivingCharacteristics dSICarDrivingCharacteristics, ArrayList arrayList) {
        CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray = StateWork511.getSetupTableForProfile(7, arrayList);
        if (charismaSetupTableWithoutOptionMaskArray.length > 0) {
            CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray2 = new CharismaSetupTableWithoutOptionMask[charismaSetupTableWithoutOptionMaskArray.length];
            for (int i2 = charismaSetupTableWithoutOptionMaskArray.length - 1; i2 >= 0; --i2) {
                charismaSetupTableWithoutOptionMaskArray2[i2] = new CharismaSetupTableWithoutOptionMask(charismaSetupTableWithoutOptionMaskArray[i2].listPosition, charismaSetupTableWithoutOptionMaskArray[i2].functionID, 2);
            }
            dSICarDrivingCharacteristics.requestCharismaProfileFunction(7, charismaSetupTableWithoutOptionMaskArray2);
        }
    }
}

