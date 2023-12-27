/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.Car;
import de.vw.mib.asl.car.persistence.CarOffroad;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class CarImpl
extends AbstractPersistable
implements Car {
    private final PersistenceModule module;
    private boolean frontWindowHeater;
    private boolean steeringWheelheater;
    private boolean fifthCamera;
    private boolean hDC;
    private boolean ambientLight;
    private int intLightColor;
    private boolean personalization;
    private boolean turboCharger;
    private boolean powerInstrument;
    private boolean climateSetupButton;
    private int rDKSystem;
    private int rDKLoadChange;
    private int sportLeftTube;
    private int sportMiddleTube;
    private int sportRightTube;
    private int offroadLeftTube;
    private int offroadMiddleTube;
    private int offroadRightTube;
    private boolean trailerModeRouteCalculation;
    private boolean buttonStartStopNoticeHighlighted;
    private CarOffroad carOffroad;

    CarImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        if (this.getCarOffroad() != null) {
            this.getCarOffroad().updateRootPersistable(persistable);
        }
    }

    @Override
    public boolean isFrontWindowHeater() {
        return this.frontWindowHeater;
    }

    @Override
    public void setFrontWindowHeater(boolean bl) {
        this.frontWindowHeater = bl;
        this.markDirty();
    }

    @Override
    public boolean isSteeringWheelheater() {
        return this.steeringWheelheater;
    }

    @Override
    public void setSteeringWheelheater(boolean bl) {
        this.steeringWheelheater = bl;
        this.markDirty();
    }

    @Override
    public boolean isFifthCamera() {
        return this.fifthCamera;
    }

    @Override
    public void setFifthCamera(boolean bl) {
        this.fifthCamera = bl;
        this.markDirty();
    }

    @Override
    public boolean isHDC() {
        return this.hDC;
    }

    @Override
    public void setHDC(boolean bl) {
        this.hDC = bl;
        this.markDirty();
    }

    @Override
    public boolean isAmbientLight() {
        return this.ambientLight;
    }

    @Override
    public void setAmbientLight(boolean bl) {
        this.ambientLight = bl;
        this.markDirty();
    }

    @Override
    public int getIntLightColor() {
        return this.intLightColor;
    }

    @Override
    public void setIntLightColor(int n) {
        this.intLightColor = n;
        this.markDirty();
    }

    @Override
    public boolean isPersonalization() {
        return this.personalization;
    }

    @Override
    public void setPersonalization(boolean bl) {
        this.personalization = bl;
        this.markDirty();
    }

    @Override
    public boolean isTurboCharger() {
        return this.turboCharger;
    }

    @Override
    public void setTurboCharger(boolean bl) {
        this.turboCharger = bl;
        this.markDirty();
    }

    @Override
    public boolean isPowerInstrument() {
        return this.powerInstrument;
    }

    @Override
    public void setPowerInstrument(boolean bl) {
        this.powerInstrument = bl;
        this.markDirty();
    }

    @Override
    public boolean isClimateSetupButton() {
        return this.climateSetupButton;
    }

    @Override
    public void setClimateSetupButton(boolean bl) {
        this.climateSetupButton = bl;
        this.markDirty();
    }

    @Override
    public int getRDKSystem() {
        return this.rDKSystem;
    }

    @Override
    public void setRDKSystem(int n) {
        this.rDKSystem = n;
        this.markDirty();
    }

    @Override
    public int getRDKLoadChange() {
        return this.rDKLoadChange;
    }

    @Override
    public void setRDKLoadChange(int n) {
        this.rDKLoadChange = n;
        this.markDirty();
    }

    @Override
    public int getSportLeftTube() {
        return this.sportLeftTube;
    }

    @Override
    public void setSportLeftTube(int n) {
        this.sportLeftTube = n;
        this.markDirty();
    }

    @Override
    public int getSportMiddleTube() {
        return this.sportMiddleTube;
    }

    @Override
    public void setSportMiddleTube(int n) {
        this.sportMiddleTube = n;
        this.markDirty();
    }

    @Override
    public int getSportRightTube() {
        return this.sportRightTube;
    }

    @Override
    public void setSportRightTube(int n) {
        this.sportRightTube = n;
        this.markDirty();
    }

    @Override
    public int getOffroadLeftTube() {
        return this.offroadLeftTube;
    }

    @Override
    public void setOffroadLeftTube(int n) {
        this.offroadLeftTube = n;
        this.markDirty();
    }

    @Override
    public int getOffroadMiddleTube() {
        return this.offroadMiddleTube;
    }

    @Override
    public void setOffroadMiddleTube(int n) {
        this.offroadMiddleTube = n;
        this.markDirty();
    }

    @Override
    public int getOffroadRightTube() {
        return this.offroadRightTube;
    }

    @Override
    public void setOffroadRightTube(int n) {
        this.offroadRightTube = n;
        this.markDirty();
    }

    @Override
    public boolean isTrailerModeRouteCalculation() {
        return this.trailerModeRouteCalculation;
    }

    @Override
    public void setTrailerModeRouteCalculation(boolean bl) {
        this.trailerModeRouteCalculation = bl;
        this.markDirty();
    }

    @Override
    public boolean isButtonStartStopNoticeHighlighted() {
        return this.buttonStartStopNoticeHighlighted;
    }

    @Override
    public void setButtonStartStopNoticeHighlighted(boolean bl) {
        this.buttonStartStopNoticeHighlighted = bl;
        this.markDirty();
    }

    @Override
    public CarOffroad getCarOffroad() {
        return this.carOffroad;
    }

    @Override
    public void setCarOffroad(CarOffroad carOffroad) {
        this.carOffroad = carOffroad;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

