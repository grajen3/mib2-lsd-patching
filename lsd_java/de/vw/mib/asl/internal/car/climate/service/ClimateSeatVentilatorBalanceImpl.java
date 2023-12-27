/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateSeatVentilatorBalance;

public class ClimateSeatVentilatorBalanceImpl
implements ClimateSeatVentilatorBalance {
    private final int seatVentilatorBalance;
    private final int zoneMember;

    public ClimateSeatVentilatorBalanceImpl(int n, int n2) {
        this.seatVentilatorBalance = n2;
        this.zoneMember = n;
    }

    @Override
    public int getSeatVentilationBalance() {
        return this.seatVentilatorBalance;
    }

    @Override
    public int getZoneMember() {
        return this.zoneMember;
    }

    @Override
    public ClimateSeatVentilatorBalance createSeatVentilatorBalance(int n) {
        ClimateSeatVentilatorBalanceImpl climateSeatVentilatorBalanceImpl = new ClimateSeatVentilatorBalanceImpl(this.zoneMember, n);
        return climateSeatVentilatorBalanceImpl;
    }

    @Override
    public ClimateSeatVentilatorBalance increaseSeatVentilatorBalance() {
        int n = this.seatVentilatorBalance + 1;
        if (n > 3) {
            n = this.seatVentilatorBalance;
        }
        return new ClimateSeatVentilatorBalanceImpl(this.zoneMember, n);
    }

    @Override
    public ClimateSeatVentilatorBalance decreaseSeatVentilatorBalance() {
        int n = this.seatVentilatorBalance - 1;
        if (n < -3) {
            n = this.seatVentilatorBalance;
        }
        return new ClimateSeatVentilatorBalanceImpl(this.zoneMember, n);
    }

    @Override
    public boolean isSeatVentilatorBalanceInDeviceRange() {
        boolean bl = false;
        if (this.seatVentilatorBalance >= -3 && this.seatVentilatorBalance <= 3) {
            bl = true;
        }
        return bl;
    }
}

