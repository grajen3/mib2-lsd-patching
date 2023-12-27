/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.service;

import de.vw.mib.asl.api.car.seat.SeatMassage;

public class SeatMassageImpl
implements SeatMassage {
    int massageProgram;
    int massageIntensity;
    int massageSpeed;
    int zone;

    public SeatMassageImpl(int n, int n2, int n3, int n4) {
        this.massageProgram = n2;
        this.massageIntensity = n3;
        this.massageSpeed = n4;
        this.zone = n;
    }

    @Override
    public int getSeatMassageZone() {
        return this.zone;
    }

    @Override
    public int getSeatMassageProgram() {
        return this.massageProgram;
    }

    @Override
    public int getSeatMassageIntensity() {
        return this.massageIntensity;
    }

    @Override
    public int getSeatMassageSpeed() {
        return this.massageSpeed;
    }

    @Override
    public SeatMassage increaseMassageIntensity() {
        int n = this.massageIntensity + 1;
        if (n > 5) {
            n = this.massageIntensity;
        }
        return this.modifySeatMassageIntensity(n);
    }

    @Override
    public SeatMassage decreaseMassageIntensity() {
        int n = this.massageIntensity - 1;
        if (n < 1) {
            n = this.massageIntensity;
        }
        return this.modifySeatMassageIntensity(n);
    }

    @Override
    public SeatMassage increaseMassageSpeed() {
        int n = this.massageSpeed + 1;
        if (n > 5) {
            n = this.massageSpeed;
        }
        return this.modifySeatMassageSpeed(n);
    }

    @Override
    public SeatMassage decreaseMassageSpeed() {
        int n = this.massageSpeed - 1;
        if (n < 0) {
            n = this.massageSpeed;
        }
        return this.modifySeatMassageSpeed(n);
    }

    @Override
    public SeatMassage modifySeatMassageProgram(int n) {
        return new SeatMassageImpl(this.zone, n, this.massageIntensity, this.massageSpeed);
    }

    @Override
    public SeatMassage modifySeatMassageIntensity(int n) {
        return new SeatMassageImpl(this.zone, this.massageProgram, n, this.massageSpeed);
    }

    @Override
    public SeatMassage modifySeatMassageSpeed(int n) {
        return new SeatMassageImpl(this.zone, this.massageProgram, this.massageIntensity, n);
    }
}

