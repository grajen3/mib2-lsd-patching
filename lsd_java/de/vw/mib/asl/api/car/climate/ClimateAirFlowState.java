/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateAirFlowState {
    public static final int AIRFLOW_STATE_PASSIVE_COOLING;
    public static final int AIRFLOW_STATE_PASSIVE_VENTING;
    public static final int AIRFLOW_STATE_PASSIVE_HEATING;
    public static final int AIRFLOW_STATE_COOLING;
    public static final int AIRFLOW_STATE_VENTING;
    public static final int AIRFLOW_STATE_HEATING;
    public static final int AIRFLOW_STATE_UNKNOWN;

    default public int getAirFlowState() {
    }

    default public int getAirFlowMemberZone() {
    }

    default public ClimateAirFlowState createAirFlowState(int n) {
    }
}

