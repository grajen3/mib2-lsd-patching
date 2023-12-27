/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa.transformer;

import de.vw.mib.asl.internal.car.fpa.transformer.CarFpaFunctionListCollector;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public class CollectorFPASettings {
    public int profileID;
    public CharismaSetupTableWithoutOptionMask[] setupTable;
    public CarFpaFunctionListCollector[] functionList;

    public CollectorFPASettings(int n, CarFpaFunctionListCollector[] carFpaFunctionListCollectorArray, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        this.profileID = n;
        this.setupTable = charismaSetupTableWithoutOptionMaskArray;
        this.functionList = carFpaFunctionListCollectorArray;
    }
}

