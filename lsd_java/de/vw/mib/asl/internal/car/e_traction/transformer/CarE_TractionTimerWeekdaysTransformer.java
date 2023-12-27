/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

import generated.de.vw.mib.asl.internal.car.e_traction.transformer.AbstractCarE_TractionTimerWeekdaysTransformer;

public class CarE_TractionTimerWeekdaysTransformer
extends AbstractCarE_TractionTimerWeekdaysTransformer {
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

    int calendarWeekDay(int n) {
        switch (n) {
            case 0: {
                return 2;
            }
            case 1: {
                return 3;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 5;
            }
            case 4: {
                return 6;
            }
            case 5: {
                return 7;
            }
            case 6: {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 0: {
                return (Boolean)object;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }
}

