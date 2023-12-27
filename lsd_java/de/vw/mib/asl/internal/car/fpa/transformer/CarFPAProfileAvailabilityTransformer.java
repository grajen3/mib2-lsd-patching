/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa.transformer;

import de.vw.mib.asl.internal.car.transformer.CarFunctionCollector;
import generated.de.vw.mib.asl.internal.car.fpa.transformer.AbstractCarFPAProfileAvailabilityTransformer;

public class CarFPAProfileAvailabilityTransformer
extends AbstractCarFPAProfileAvailabilityTransformer {
    public static final int PROFILE_COMFORT;
    public static final int PROFILE_ECO;
    public static final int PROFILE_INDIVIDUAL;
    public static final int PROFILE_NONE;
    public static final int PROFILE_NORMAL;
    public static final int PROFILE_OFFROAD;
    public static final int PROFILE_OFFROAD_AUTO;
    public static final int PROFILE_OFFROAD_INDIVIDUAL;
    public static final int PROFILE_RACE;
    public static final int PROFILE_RANGE;
    public static final int PROFILE_SNOW;
    public static final int PROFILE_SPORT;

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 0: {
                return ((CarFunctionCollector)object).functionAvailable;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 1: {
                return ((CarFunctionCollector)object).functionReason;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain int values.");
    }
}

