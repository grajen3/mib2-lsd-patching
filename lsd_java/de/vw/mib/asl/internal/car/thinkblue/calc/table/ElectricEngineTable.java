/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc.table;

import de.vw.mib.asl.internal.car.thinkblue.calc.table.ConditionsContainer;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingState;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingState$Builder;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingTable;

public class ElectricEngineTable
extends DrivingTable {
    public ElectricEngineTable(int n) {
        super(n);
    }

    @Override
    protected void createDrivingStates() {
        this.drivingStates = new DrivingState[]{new DrivingState$Builder(1, "CORRECT_GEAR_LONG_TIME_STATE").weight(10, 100).dataSet(764, 748).build(), new DrivingState$Builder(11, "STATE_KICK_DOWN").weight(100, 0).dataSet(774, 758).build(), new DrivingState$Builder(0, "STATE_CORRECT_GEAR").weight(10, 100).dataSet(763, 747).build(), new DrivingState$Builder(3, "STATE_FREE_WHEEL_NO_BRAKE").weight(10, 100).dataSet(766, 750).build(), new DrivingState$Builder(4, "STATE_FREE_WHEEL_BRAKE").weight(10, 100).dataSet(767, 751).build(), new DrivingState$Builder(14, "STATE_RECUP_NO_BRAKE").weight(10, 100).dataSet(775, 759).build(), new DrivingState$Builder(15, "STATE_RECUP_BRAKE").weight(10, 100).dataSet(776, 760).build(), new DrivingState$Builder(12, "STATE_FREE_WHEEL_D_NO_BRAKE").weight(100, 100).dataSet(777, 761).build(), new DrivingState$Builder(13, "STATE_FREE_WHEEL_D_BRAKE").weight(80, 30).dataSet(778, 762).build()};
    }

    @Override
    public boolean evaluate(int n) {
        ConditionsContainer conditionsContainer = ConditionsContainer.getInstance();
        switch (n) {
            case 1: {
                return !(!conditionsContainer.conditions[16] && !conditionsContainer.conditions[18] && !conditionsContainer.conditions[25] && !conditionsContainer.conditions[24] || !conditionsContainer.conditions[19] && !conditionsContainer.conditions[20] || !conditionsContainer.conditions[7] || !conditionsContainer.conditions[8] || !conditionsContainer.conditions[10] || !conditionsContainer.conditions[12]);
            }
            case 11: {
                return conditionsContainer.conditions[11] && conditionsContainer.conditions[7];
            }
            case 0: {
                return !(!conditionsContainer.conditions[16] && !conditionsContainer.conditions[18] && !conditionsContainer.conditions[25] && !conditionsContainer.conditions[24] || !conditionsContainer.conditions[19] && !conditionsContainer.conditions[20] || !conditionsContainer.conditions[7] || !conditionsContainer.conditions[8] || !conditionsContainer.conditions[10]);
            }
            case 3: {
                return conditionsContainer.conditions[22] && conditionsContainer.conditions[6] && conditionsContainer.conditions[8] && conditionsContainer.conditions[7];
            }
            case 4: {
                return conditionsContainer.conditions[22] && conditionsContainer.conditions[6] && conditionsContainer.conditions[9] && conditionsContainer.conditions[7];
            }
            case 14: {
                return !(!conditionsContainer.conditions[16] && (!conditionsContainer.conditions[18] && !conditionsContainer.conditions[25] && !conditionsContainer.conditions[24] || !conditionsContainer.conditions[17]) || !conditionsContainer.conditions[8] || conditionsContainer.conditions[19] && conditionsContainer.conditions[20]);
            }
            case 15: {
                return !(!conditionsContainer.conditions[16] && (!conditionsContainer.conditions[18] && !conditionsContainer.conditions[25] && !conditionsContainer.conditions[24] || !conditionsContainer.conditions[17]) || !conditionsContainer.conditions[9] || conditionsContainer.conditions[19] && conditionsContainer.conditions[20]);
            }
            case 12: {
                return !(!conditionsContainer.conditions[18] && !conditionsContainer.conditions[25] && !conditionsContainer.conditions[24] || conditionsContainer.conditions[17] || !conditionsContainer.conditions[8] || conditionsContainer.conditions[19] && conditionsContainer.conditions[20] || !conditionsContainer.conditions[7]);
            }
            case 13: {
                return !(!conditionsContainer.conditions[18] && !conditionsContainer.conditions[25] && !conditionsContainer.conditions[24] || conditionsContainer.conditions[17] || !conditionsContainer.conditions[9] || conditionsContainer.conditions[19] && conditionsContainer.conditions[20] || !conditionsContainer.conditions[7]);
            }
        }
        return false;
    }
}

