/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc.table;

import de.vw.mib.asl.internal.car.thinkblue.calc.table.ConditionsContainer;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingState;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingState$Builder;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingTable;

public class CombustionAsgActiveTiptronicTable
extends DrivingTable {
    public CombustionAsgActiveTiptronicTable(int n) {
        super(n);
    }

    @Override
    protected void createDrivingStates() {
        this.drivingStates = new DrivingState[]{new DrivingState$Builder(1, "CORRECT_GEAR_LONG_TIME_STATE").weight(10, 100).dataSet(764, 748).build(), new DrivingState$Builder(11, "STATE_KICK_DOWN").weight(100, 0).dataSet(774, 758).build(), new DrivingState$Builder(0, "STATE_CORRECT_GEAR").weight(10, 100).dataSet(763, 747).build(), new DrivingState$Builder(2, "STATE_WRONG_GEAR").weight(90, 10).dataSet(765, 749).build(), new DrivingState$Builder(9, "STATE_FUEL_CUTOFF_NO_BRAKE").weight(10, 100).dataSet(772, 756).build(), new DrivingState$Builder(10, "STATE_FUEL_CUTOFF_BRAKE").weight(10, 100).dataSet(773, 757).build()};
    }

    @Override
    public boolean evaluate(int n) {
        ConditionsContainer conditionsContainer = ConditionsContainer.getInstance();
        switch (n) {
            case 1: {
                return conditionsContainer.conditions[1] && (conditionsContainer.conditions[19] || conditionsContainer.conditions[20]) && conditionsContainer.conditions[7] && conditionsContainer.conditions[8] && conditionsContainer.conditions[10] && conditionsContainer.conditions[12];
            }
            case 11: {
                return conditionsContainer.conditions[11] && conditionsContainer.conditions[7];
            }
            case 0: {
                return conditionsContainer.conditions[1] && (conditionsContainer.conditions[19] || conditionsContainer.conditions[20]) && conditionsContainer.conditions[7] && conditionsContainer.conditions[8] && conditionsContainer.conditions[10];
            }
            case 2: {
                return conditionsContainer.conditions[2] && (conditionsContainer.conditions[19] || conditionsContainer.conditions[20]) && conditionsContainer.conditions[7] && conditionsContainer.conditions[8] && conditionsContainer.conditions[10];
            }
            case 9: {
                return (!conditionsContainer.conditions[19] || !conditionsContainer.conditions[20]) && conditionsContainer.conditions[14] && conditionsContainer.conditions[8] && conditionsContainer.conditions[7];
            }
            case 10: {
                return (!conditionsContainer.conditions[19] || !conditionsContainer.conditions[20]) && conditionsContainer.conditions[14] && conditionsContainer.conditions[9] && conditionsContainer.conditions[7];
            }
        }
        return false;
    }
}

