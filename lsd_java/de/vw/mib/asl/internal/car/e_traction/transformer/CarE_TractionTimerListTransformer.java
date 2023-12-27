/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlTimerCollector;
import generated.de.vw.mib.asl.internal.car.e_traction.transformer.AbstractCarE_TractionTimerListTransformer;

public class CarE_TractionTimerListTransformer
extends AbstractCarE_TractionTimerListTransformer {
    int getWeekDayHmi(int n) {
        switch (n) {
            case 1: {
                return 6;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 6: {
                return 4;
            }
            case 7: {
                return 5;
            }
        }
        return -1;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 0: {
                return ((BatteryControlTimerCollector)object).isActivated;
            }
            case 9: {
                return ((BatteryControlTimerCollector)object).isClimate();
            }
            case 10: {
                return ((BatteryControlTimerCollector)object).isCharging();
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }

    @Override
    public boolean[] getFlagVector(int n, Object object) {
        switch (n) {
            case 7: {
                return ((BatteryControlTimerCollector)object).timeWeekDays;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean-array values.");
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 5: {
                return ((BatteryControlTimerCollector)object).timeHours;
            }
            case 6: {
                return ((BatteryControlTimerCollector)object).timeMinutes;
            }
            case 8: {
                return ((BatteryControlTimerCollector)object).timeNextWeekDay;
            }
            case 1: {
                return ((BatteryControlTimerCollector)object).profileListIndex;
            }
            case 4: {
                return ((BatteryControlTimerCollector)object).isCycle;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain integer values.");
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 2: {
                return ((BatteryControlTimerCollector)object).getProfileName();
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain String values.");
    }
}

