/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.light.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.light.IntLightViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class IntLightViewOptionsCollector
implements IntLightViewOptionsData {
    private IntLightViewOptions vo;
    private CarFunctionState intLightDoorsFront = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightFootwellFront = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightCockpit = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightCenterConsole = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightRoofFront = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightAll = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightColour = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightFootwellFrontRear = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightFootwellRear = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightDoorsFrontRear = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightNotDoorsFootwellRear = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightRoofFrontRear = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightRoofRear = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightFront = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState intLightRGBColorList = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private boolean displayAmbienceSetupEntry = false;

    public IntLightViewOptionsCollector(IntLightViewOptions intLightViewOptions) {
        this.vo = intLightViewOptions;
    }

    @Override
    public CarFunctionState getIntLightDoorsFront() {
        return this.intLightDoorsFront;
    }

    @Override
    public CarFunctionState getIntLightFootwellFront() {
        return this.intLightFootwellFront;
    }

    @Override
    public CarFunctionState getIntLightCockpit() {
        return this.intLightCockpit;
    }

    @Override
    public CarFunctionState getIntLightCenterConsole() {
        return this.intLightCenterConsole;
    }

    @Override
    public CarFunctionState getIntLightRoofFront() {
        return this.intLightRoofFront;
    }

    @Override
    public CarFunctionState getIntLightAll() {
        return this.intLightAll;
    }

    @Override
    public CarFunctionState getIntLightColour() {
        return this.intLightColour;
    }

    @Override
    public CarFunctionState getIntLightFootwellFrontRear() {
        return this.intLightFootwellFrontRear;
    }

    @Override
    public CarFunctionState getIntLightFootwellRear() {
        return this.intLightFootwellRear;
    }

    @Override
    public CarFunctionState getIntLightDoorsFrontRear() {
        return this.intLightDoorsFrontRear;
    }

    @Override
    public CarFunctionState getIntLightNotDoorsFootwellRear() {
        return this.intLightNotDoorsFootwellRear;
    }

    @Override
    public CarFunctionState getIntLightRoofFrontRear() {
        return this.intLightRoofFrontRear;
    }

    @Override
    public CarFunctionState getIntLightRoofRear() {
        return this.intLightRoofRear;
    }

    @Override
    public CarFunctionState getIntLightFront() {
        return this.intLightFront;
    }

    @Override
    public CarFunctionState getIntLightRGBColorList() {
        return this.intLightRGBColorList;
    }

    public void setIntLightDoorsFront(CarViewOption carViewOption) {
        this.intLightDoorsFront = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightFootwellFront(CarViewOption carViewOption) {
        this.intLightFootwellFront = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightCockpit(CarViewOption carViewOption) {
        this.intLightCockpit = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightCenterConsole(CarViewOption carViewOption) {
        this.intLightCenterConsole = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightRoofFront(CarViewOption carViewOption) {
        this.intLightRoofFront = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightAll(CarViewOption carViewOption) {
        this.intLightAll = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightColour(CarViewOption carViewOption) {
        this.intLightColour = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightFootwellFrontRear(CarViewOption carViewOption) {
        this.intLightFootwellFrontRear = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightFootwellRear(CarViewOption carViewOption) {
        this.intLightFootwellRear = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightDoorsFrontRear(CarViewOption carViewOption) {
        this.intLightDoorsFrontRear = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightNotDoorsFootwellRear(CarViewOption carViewOption) {
        this.intLightNotDoorsFootwellRear = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightRoofFrontRear(CarViewOption carViewOption) {
        this.intLightRoofFrontRear = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightRoofRear(CarViewOption carViewOption) {
        this.intLightRoofRear = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightFront(CarViewOption carViewOption) {
        this.intLightFront = new CarViewOptionWrapper(carViewOption);
    }

    public void setIntLightRGBColorList(CarViewOption carViewOption) {
        this.intLightRGBColorList = new CarViewOptionWrapper(carViewOption);
    }

    @Override
    public CarFunctionState getIntLightBrigthness() {
        return new CarViewOptionWrapper(this.vo.getIntLightBrightness());
    }

    @Override
    public boolean getDisplayAmbienceSetupEntry() {
        return this.displayAmbienceSetupEntry;
    }

    public void setDisplayAmbienceSetupEntry(boolean bl) {
        this.displayAmbienceSetupEntry = bl;
    }

    @Override
    public CarFunctionState getIntLightState() {
        return new CarViewOptionWrapper(this.vo.getIntLightState());
    }
}

