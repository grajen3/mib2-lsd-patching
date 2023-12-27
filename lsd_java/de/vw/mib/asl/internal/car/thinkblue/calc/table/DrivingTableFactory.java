/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc.table;

import de.vw.mib.asl.internal.car.thinkblue.calc.table.CombustionAsgActiveTiptronicTable;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.CombustionAsgInactiveTiptronicTable;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.CombustionMsgTable;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingTable;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.ElectricEngineTable;

public class DrivingTableFactory {
    public static DrivingTable createDrivingTable(int n) {
        if (n == 0) {
            return new CombustionMsgTable(0);
        }
        if (n == 1) {
            return new CombustionAsgActiveTiptronicTable(1);
        }
        if (n == 2) {
            return new CombustionAsgInactiveTiptronicTable(2);
        }
        if (n == 3) {
            return new ElectricEngineTable(3);
        }
        return null;
    }
}

