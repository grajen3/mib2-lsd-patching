/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlProfileCollector;
import generated.de.vw.mib.asl.internal.car.e_traction.transformer.AbstractCarE_TractionProfileListTransformer;

public class CarE_TractionProfileListTransformer
extends AbstractCarE_TractionProfileListTransformer {
    private static final int MAX_CURRENT_DSI_VALUE_5;
    private static final int MAX_CURRENT_DSI_VALUE_10;
    private static final int MAX_CURRENT_DSI_VALUE_13;
    private static final int MAX_CURRENT_DSI_VALUE_16;
    private static final int MAX_CURRENT_DSI_VALUE_32;

    public static int maxCurrentProfileHmi(int n) {
        switch (n) {
            case 5: {
                return 0;
            }
            case 10: {
                return 1;
            }
            case 13: {
                return 2;
            }
            case 16: {
                return 3;
            }
            case 32: {
                return 4;
            }
        }
        return 1;
    }

    public static int charginCurrentMaxReduProfileHmi(int n) {
        switch (n) {
            case 5: 
            case 10: 
            case 13: 
            case 16: {
                return 1;
            }
            case 32: {
                return 0;
            }
        }
        return 1;
    }

    public static int maxCurrentProfileDSI(int n) {
        switch (n) {
            case 0: {
                return 5;
            }
            case 1: {
                return 10;
            }
            case 2: {
                return 13;
            }
            case 3: {
                return 16;
            }
            case 4: {
                return 32;
            }
        }
        return 10;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 4: {
                return ((BatteryControlProfileCollector)object).isAirConditioning;
            }
            case 2: {
                return ((BatteryControlProfileCollector)object).isCharing;
            }
            case 7: {
                return ((BatteryControlProfileCollector)object).isUsedByTimer();
            }
            case 9: {
                return ((BatteryControlProfileCollector)object).isNightRate();
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((BatteryControlProfileCollector)object).posId;
            }
            case 8: {
                return CarE_TractionProfileListTransformer.maxCurrentProfileHmi(((BatteryControlProfileCollector)object).maxCurrent);
            }
            case 12: {
                return ((BatteryControlProfileCollector)object).getNR_EndHour();
            }
            case 13: {
                return ((BatteryControlProfileCollector)object).getNR_EndMinutes();
            }
            case 10: {
                return ((BatteryControlProfileCollector)object).getNR_StartHour();
            }
            case 11: {
                return ((BatteryControlProfileCollector)object).getNR_StartMinutes();
            }
            case 3: {
                return ((BatteryControlProfileCollector)object).targetChargeLevel;
            }
            case 6: {
                return ((BatteryControlProfileCollector)object).temperatureUnit;
            }
            case 5: {
                return ((BatteryControlProfileCollector)object).temperatureValue;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain integer values.");
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 1: {
                return ((BatteryControlProfileCollector)object).profileName;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain String values.");
    }
}

