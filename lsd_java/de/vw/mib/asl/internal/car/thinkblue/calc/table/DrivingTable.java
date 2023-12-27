/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc.table;

import de.vw.mib.asl.framework.api.diagnosis.config.EcoHmi;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingState;

public abstract class DrivingTable {
    public static final int STATE_RECUP_BRAKE;
    public static final int STATE_RECUP_NO_BRAKE;
    public static final int STATE_FREE_WHEEL_D_BRAKE;
    public static final int STATE_FREE_WHEEL_D_NO_BRAKE;
    public static final int STATE_KICK_DOWN;
    public static final int STATE_FUEL_CUTOFF_BRAKE;
    public static final int STATE_FUEL_CUTOFF_NO_BRAKE;
    public static final int STATE_FREE_WHEEL_NO_CLUTCH_ACC_PEDAL;
    public static final int STATE_FREE_WHEEL_NO_CLUTCH_BRAKE;
    public static final int STATE_FREE_WHEEL_NO_CLUTCH_NO_BRAKE;
    public static final int STATE_FREE_WHEEL_ACC_PEDAL;
    public static final int STATE_FREE_WHEEL_BRAKE;
    public static final int STATE_FREE_WHEEL_NO_BRAKE;
    public static final int STATE_WRONG_GEAR;
    public static final int STATE_CORRECT_GEAR_LONG_TIME;
    public static final int STATE_CORRECT_GEAR;
    protected static final int DIAG_CONVERSION_FACTOR_1;
    private int tableId;
    public DrivingState[] drivingStates;

    public DrivingTable(int n) {
        this.tableId = n;
        this.createDrivingStates();
    }

    public DrivingTable() {
        this(0);
    }

    protected abstract void createDrivingStates() {
    }

    public abstract boolean evaluate(int n) {
    }

    public DrivingState getDrivingState(int n) {
        for (int i2 = 0; i2 < this.drivingStates.length; ++i2) {
            if (this.drivingStates[i2].getId() != n) continue;
            return this.drivingStates[i2];
        }
        return null;
    }

    public void setPersistentValues(EcoHmi ecoHmi) {
        for (int i2 = 0; i2 < this.drivingStates.length; ++i2) {
            int n = this.drivingStates[i2].getDataSetWeight();
            int n2 = this.drivingStates[i2].getDataSetRate();
            if (ecoHmi.contains(n)) {
                this.drivingStates[i2].setW1(ecoHmi.getValue(n) * 10);
            }
            if (!ecoHmi.contains(n2)) continue;
            this.drivingStates[i2].setRating(ecoHmi.getValue(n2) * 10);
        }
    }

    public int getTableId() {
        return this.tableId;
    }

    public void setTableId(int n) {
        this.tableId = n;
    }

    public int getStateIndexById(int n) {
        for (int i2 = 0; i2 < this.drivingStates.length; ++i2) {
            if (n != this.drivingStates[i2].getId()) continue;
            return i2;
        }
        return 1;
    }
}

