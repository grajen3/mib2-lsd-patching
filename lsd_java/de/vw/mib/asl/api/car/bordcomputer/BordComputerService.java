/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.bordcomputer;

import java.util.ArrayList;

public interface BordComputerService {
    public static final int SERVICE_STATE_UNKNOWN;
    public static final int SERVICE_STATE_NOT_EXISTING;
    public static final int SERVICE_STATE_NOT_AVAILABLE;
    public static final int SERVICE_STATE_AVAILABLE;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_NONE;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_GASOLINE_DIESEL;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_CNG;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_ELECTRO;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_LPG;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_NONE;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_GASOLINE_DIESEL;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_CNG;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_ELECTRO;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_LPG;

    default public int getPrimaryEngineType() {
    }

    default public int getASTAServiceState() {
    }

    default public int getSecondaryEngineType() {
    }

    default public ArrayList getBCMenu1() {
    }

    default public ArrayList getBCMenu2() {
    }

    default public ArrayList getBCMenu3() {
    }

    default public boolean getAvailableStatusRange() {
    }

    default public boolean getAvailableStatusTripGeneral() {
    }

    default public boolean getAvailableStatusTripAverageConsumption() {
    }
}

