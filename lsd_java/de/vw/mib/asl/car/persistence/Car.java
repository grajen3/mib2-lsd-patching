/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.CarOffroad;
import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface Car
extends Persistable {
    default public boolean isFrontWindowHeater() {
    }

    default public void setFrontWindowHeater(boolean bl) {
    }

    default public boolean isSteeringWheelheater() {
    }

    default public void setSteeringWheelheater(boolean bl) {
    }

    default public boolean isFifthCamera() {
    }

    default public void setFifthCamera(boolean bl) {
    }

    default public boolean isHDC() {
    }

    default public void setHDC(boolean bl) {
    }

    default public boolean isAmbientLight() {
    }

    default public void setAmbientLight(boolean bl) {
    }

    default public int getIntLightColor() {
    }

    default public void setIntLightColor(int n) {
    }

    default public boolean isPersonalization() {
    }

    default public void setPersonalization(boolean bl) {
    }

    default public boolean isTurboCharger() {
    }

    default public void setTurboCharger(boolean bl) {
    }

    default public boolean isPowerInstrument() {
    }

    default public void setPowerInstrument(boolean bl) {
    }

    default public boolean isClimateSetupButton() {
    }

    default public void setClimateSetupButton(boolean bl) {
    }

    default public int getRDKSystem() {
    }

    default public void setRDKSystem(int n) {
    }

    default public int getRDKLoadChange() {
    }

    default public void setRDKLoadChange(int n) {
    }

    default public int getSportLeftTube() {
    }

    default public void setSportLeftTube(int n) {
    }

    default public int getSportMiddleTube() {
    }

    default public void setSportMiddleTube(int n) {
    }

    default public int getSportRightTube() {
    }

    default public void setSportRightTube(int n) {
    }

    default public int getOffroadLeftTube() {
    }

    default public void setOffroadLeftTube(int n) {
    }

    default public int getOffroadMiddleTube() {
    }

    default public void setOffroadMiddleTube(int n) {
    }

    default public int getOffroadRightTube() {
    }

    default public void setOffroadRightTube(int n) {
    }

    default public boolean isTrailerModeRouteCalculation() {
    }

    default public void setTrailerModeRouteCalculation(boolean bl) {
    }

    default public boolean isButtonStartStopNoticeHighlighted() {
    }

    default public void setButtonStartStopNoticeHighlighted(boolean bl) {
    }

    default public CarOffroad getCarOffroad() {
    }

    default public void setCarOffroad(CarOffroad carOffroad) {
    }
}

