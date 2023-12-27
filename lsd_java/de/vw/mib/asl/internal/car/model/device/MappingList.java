/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.internal.car.model.FunctionState;
import de.vw.mib.asl.internal.car.model.MappingTable;
import de.vw.mib.asl.internal.car.model.device.MappingList$1;
import org.dsi.ifc.global.CarViewOption;

public class MappingList {
    private static final int MAX_FUNCTIONS;
    FunctionState[] funcStateArray = new FunctionState[40];
    private final int capacity;

    public MappingList(int n) {
        this.funcStateArray = new FunctionState[n];
        for (int i2 = 0; i2 < this.funcStateArray.length; ++i2) {
            this.funcStateArray[i2] = new FunctionState(0, 0);
        }
        this.capacity = n;
    }

    public MappingList() {
        this(40);
    }

    public void add(int n, CarFunctionState carFunctionState, int n2) {
        if (n < 0 || n >= this.capacity) {
            return;
        }
        FunctionState functionState = this.funcStateArray[n];
        if (n2 == 0) {
            functionState.setFunctionState(carFunctionState.getState(), MappingTable.getModelValue(carFunctionState.getAvailableReason()));
        } else if (functionState.isExistence()) {
            functionState.setFunctionState(1, MappingTable.getModelValue(n2));
        }
        this.funcStateArray[n] = functionState;
    }

    public void add(int n, FunctionState functionState) {
        if (n < 0 || n >= this.capacity) {
            return;
        }
        this.funcStateArray[n] = functionState;
    }

    public void add(int n, CarViewOption carViewOption) {
        this.add(n, new MappingList$1(this, carViewOption), 0);
    }

    public void add(int n, int n2) {
        int n3 = MappingTable.getModelValue(n2);
        this.funcStateArray[n].setFunctionState(1, n3);
    }

    public FunctionState[] getFunctionStates() {
        return (FunctionState[])this.funcStateArray.clone();
    }

    public FunctionState getListFunctionState() {
        int n = 0;
        int n2 = 0;
        boolean bl = false;
        boolean bl2 = false;
        for (int i2 = 0; i2 < this.funcStateArray.length; ++i2) {
            if (this.funcStateArray[i2].getFunctionState() == 2) {
                bl = true;
                break;
            }
            if (this.funcStateArray[i2].getFunctionState() != 1) continue;
            bl2 = true;
        }
        if (bl) {
            n = 2;
        } else if (bl2) {
            n = 1;
            n2 = this.mainReason(this.funcStateArray);
        }
        return new FunctionState(n, n2);
    }

    private int mainReason(FunctionState[] functionStateArray) {
        int n;
        int[] nArray = new int[6];
        block8: for (n = functionStateArray.length - 1; n >= 0; --n) {
            if (functionStateArray[n].getFunctionState() != 1) continue;
            switch (functionStateArray[n].getFunctionAvailableReason()) {
                case 2: {
                    return 2;
                }
                case 7: {
                    nArray[0] = 7;
                    continue block8;
                }
                case 3: {
                    nArray[1] = 3;
                    continue block8;
                }
                case 4: {
                    nArray[2] = 4;
                    continue block8;
                }
                case 5: {
                    nArray[3] = 5;
                    continue block8;
                }
                case 1: {
                    nArray[4] = 1;
                    continue block8;
                }
                default: {
                    nArray[5] = 6;
                }
            }
        }
        n = 6;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 0) continue;
            n = nArray[i2];
            break;
        }
        return n;
    }
}

