/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.transformer;

import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.internal.car.seats.service.SeatMassageImpl;
import org.dsi.ifc.carseat.MassageData;

public class SeatServiceTransformer {
    public SeatMassage getSeatMassageFromDSIMassageData(int n, MassageData massageData) {
        return new SeatMassageImpl(n, massageData.program, massageData.intensity, massageData.speed);
    }

    public MassageData getDSIMassageDataFromSeatMassage(SeatMassage seatMassage) {
        return new MassageData(seatMassage.getSeatMassageProgram(), seatMassage.getSeatMassageIntensity(), seatMassage.getSeatMassageSpeed());
    }
}

