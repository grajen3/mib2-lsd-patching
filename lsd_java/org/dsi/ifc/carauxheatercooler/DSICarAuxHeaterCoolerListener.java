/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carauxheatercooler;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.global.CarBCTemperature;

public interface DSICarAuxHeaterCoolerListener
extends DSIListener {
    default public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions, int n) {
    }

    default public void updateAuxHeaterCoolerCurrentHeaterState(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
    }

    default public void updateAuxHeaterCoolerErrorReason(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
    }

    default public void updateAuxHeaterCoolerState(int n, int n2) {
    }

    default public void updateAuxHeaterCoolerOnOff(boolean bl, int n) {
    }

    default public void updateAuxHeaterCoolerRemainingTime(short s, int n) {
    }

    default public void updateAuxHeaterCoolerRunningTime(short s, int n) {
    }

    default public void updateAuxHeaterCoolerMode(int n, int n2) {
    }

    default public void updateAuxHeaterCoolerDefaultStartMode(int n, int n2) {
    }

    default public void updateAuxHeaterCoolerEngineHeater(boolean bl, int n) {
    }

    default public void updateAuxHeaterCoolerActiveTimer(int n, int n2) {
    }

    default public void updateAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
    }

    default public void updateAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
    }

    default public void updateAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
    }

    default public void acknowledgeAuxHeaterSetFactoryDefault(boolean bl) {
    }

    default public void updateAuxHeaterCoolerPopup(int n, int n2) {
    }

    default public void updateAuxHeaterCoolerMode2(AuxHeaterCoolerMode auxHeaterCoolerMode, int n) {
    }

    default public void updateAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning2, int n) {
    }

    default public void updateAuxHeaterCoolerWindowHeating(boolean bl, boolean bl2, int n) {
    }

    default public void updateAuxHeaterCoolerUnlockClimating(int n, int n2) {
    }

    default public void updateAuxHeaterCoolerTargetTemperature(CarBCTemperature carBCTemperature, int n) {
    }

    default public void updateAuxHeaterCoolerAirQuality(boolean bl, boolean bl2, int n) {
    }
}

