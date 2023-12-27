/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.widgets.models.AbstractCarSpecificModel;

public interface EnergyFlowModel
extends AbstractCarSpecificModel {
    public static final int PID_BASE;
    public static final int PID_BATTERY_STATE_OF_CHARGE;
    public static final int PID_BATTERY_STATE;
    public static final int PID_ENERGY_FLOW_COLORS;
    public static final int PID_ENERGY_STATE;
    public static final int PID_FEATURE_STATES;
    public static final int PID_MOTION_STATE;
    public static final int PID_POWER_DRIVE_CONCEPT;
    public static final int PID_CAR_TYPE;
    public static final int PID_COUNT_ENERGY_FLOW;
    public static final int EASING_INDEX_BASE_ENERGY_FLOW;
    public static final int EASING_INDEX_SHIFT_FLOW_GROUND;
    public static final int EASING_INDEX_SHIFT_FLOW_BATTERY;
    public static final int EASING_INDEX_ROTATE_WHEEL;
    public static final int EASING_INDEX_COUNT_ENERGY_FLOW;
    public static final int BATTERY_STATE_NO_FLOW;
    public static final int BATTERY_STATE_CHARGED;
    public static final int BATTERY_STATE_DISCHARGED;
    public static final int CAR_TYPE_BEV;
    public static final int CAR_TYPE_PHEV;
    public static final int CAR_TYPE_COUNT;
    public static final int COLOR_ENGINE_DRIVEN;
    public static final int COLOR_ELECTRIC_MOTOR_DRIVEN;
    public static final int COLOR_RECUPERATION;
    public static final int ENERGY_STATE_NONE;
    public static final int ENERGY_STATE_ELECTRIC_MOTOR_DRIVEN;
    public static final int ENERGY_STATE_ENGINE_DRIVEN;
    public static final int ENERGY_STATE_RECUPERATION;
    public static final int ENERGY_STATE_BOOST;
    public static final int ENERGY_STATE_SAILING;
    public static final int FEATURE_BATTERY;
    public static final int FEATURE_INTERNAL_COMBUSTION_ENGINE;
    public static final int FEATURE_ELECTIRC_MOTOR;
    public static final int FEATURE_AIR_CONDITION_DEVICE;
    public static final int FEATURE_STATE_NOT_AVAILABLE;
    public static final int FEATURE_STATE_INACTIVE;
    public static final int FEATURE_STATE_ACTIVE;
    public static final int MOTION_STATE_STANDSTILL;
    public static final int MOTION_STATE_FORWARD;
    public static final int MOTION_STATE_REVERSE;
    public static final int POWER_DRIVE_FRONT;
    public static final int POWER_DRIVE_REAR;
    public static final int POWER_DRIVE_ALL;

    default public int get_batteryState() {
    }

    default public void set_batteryState(int n) {
    }

    default public int get_batteryStateOfCharge() {
    }

    default public void set_batteryStateOfCharge(int n) {
    }

    default public int get_carType() {
    }

    default public void set_carType(int n) {
    }

    default public Color[] get_energyFlowColors() {
    }

    default public void set_energyFlowColors(Color[] colorArray) {
    }

    default public int get_energyState() {
    }

    default public void set_energyState(int n) {
    }

    default public int[] get_featureStates() {
    }

    default public void set_featureStates(int[] nArray) {
    }

    default public int get_motionState() {
    }

    default public void set_motionState(int n) {
    }

    default public int get_powerDriveConcept() {
    }

    default public void set_powerDriveConcept(int n) {
    }

    default public float getPosXFlowBattery() {
    }

    default public float getPosXFlowWheels() {
    }

    default public int getCurrentSequenceIndex() {
    }

    default public Color4b[] getCurrentColor(Color4b[] color4bArray) {
    }

    default public Color4b[] getEMotorColors(Color4b[] color4bArray) {
    }

    default public Color4b[] getEngineColors(Color4b[] color4bArray) {
    }
}

