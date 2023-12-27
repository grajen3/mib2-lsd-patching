/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.bordcomputer;

import de.vw.mib.asl.api.car.bordcomputer.BordComputerService;
import java.util.ArrayList;

public class NotAvailableBordComputerService
implements BordComputerService {
    @Override
    public int getASTAServiceState() {
        return 0;
    }

    @Override
    public int getPrimaryEngineType() {
        return 0;
    }

    @Override
    public ArrayList getBCMenu1() {
        return null;
    }

    @Override
    public ArrayList getBCMenu2() {
        return null;
    }

    @Override
    public ArrayList getBCMenu3() {
        return null;
    }

    @Override
    public boolean getAvailableStatusRange() {
        return false;
    }

    @Override
    public boolean getAvailableStatusTripGeneral() {
        return false;
    }

    @Override
    public boolean getAvailableStatusTripAverageConsumption() {
        return false;
    }

    @Override
    public int getSecondaryEngineType() {
        return 0;
    }
}

