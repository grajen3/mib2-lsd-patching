/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateSeatHeaterBalance;

public class ClimateSeatHeaterBalanceImpl
implements ClimateSeatHeaterBalance {
    private final int seatHeaterBalance;
    private final int zoneMember;

    public ClimateSeatHeaterBalanceImpl(int n, int n2) {
        this.seatHeaterBalance = n2;
        this.zoneMember = n;
    }

    @Override
    public int getSeatHeatingBalance() {
        return this.seatHeaterBalance;
    }

    @Override
    public int getZoneMember() {
        return this.zoneMember;
    }

    @Override
    public ClimateSeatHeaterBalance createSeatHeaterBalance(int n) {
        ClimateSeatHeaterBalanceImpl climateSeatHeaterBalanceImpl = new ClimateSeatHeaterBalanceImpl(this.zoneMember, n);
        return climateSeatHeaterBalanceImpl;
    }

    @Override
    public ClimateSeatHeaterBalance increaseSeatHeaterBalance() {
        int n = this.seatHeaterBalance + 1;
        if (n > 3) {
            n = this.seatHeaterBalance;
        }
        return new ClimateSeatHeaterBalanceImpl(this.zoneMember, n);
    }

    @Override
    public ClimateSeatHeaterBalance decreaseSeatHeaterBalance() {
        int n = this.seatHeaterBalance - 1;
        if (n < -3) {
            n = this.seatHeaterBalance;
        }
        return new ClimateSeatHeaterBalanceImpl(this.zoneMember, n);
    }

    @Override
    public boolean isSeatHeatingBalanceInDeviceRange() {
        boolean bl = false;
        if (this.seatHeaterBalance >= -3 && this.seatHeaterBalance <= 3) {
            bl = true;
        }
        return bl;
    }
}

