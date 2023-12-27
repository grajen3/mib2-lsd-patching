/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.bordcomputer;

import java.util.ArrayList;

public interface BordComputerServiceListener {
    default public void updateASTAServiceState(int n) {
    }

    default public void updatePrimaryEngineType(int n) {
    }

    default public void updateSecondaryEngineType(int n) {
    }

    default public void updateBCMenu1(ArrayList arrayList) {
    }

    default public void updateBCMenu2(ArrayList arrayList) {
    }

    default public void updateBCMenu3(ArrayList arrayList) {
    }

    default public void updateAvailableStatusRange(boolean bl) {
    }

    default public void updateAvailableStatusTripGeneral(boolean bl) {
    }

    default public void updateAvailableStatusTripAverageConsumption(boolean bl) {
    }
}

