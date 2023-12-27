/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.extern;

import de.vw.mib.collections.ints.IntIntOptHashMap;

public final class ParkingPropertyMappings {
    private static IntIntOptHashMap intPropertyMappings;
    private static IntIntOptHashMap boolPropertyMappings;
    private static IntIntOptHashMap listPropertyMappings;
    private static IntIntOptHashMap arrayPropertyMappings;

    public static IntIntOptHashMap getIntPropertyMappings() {
        if (intPropertyMappings == null) {
            intPropertyMappings = new IntIntOptHashMap(10);
            ParkingPropertyMappings.initIntMappings();
        }
        return intPropertyMappings;
    }

    public static IntIntOptHashMap getBoolPropertyMappings() {
        if (boolPropertyMappings == null) {
            boolPropertyMappings = new IntIntOptHashMap(10);
            ParkingPropertyMappings.initBoolMappings();
        }
        return boolPropertyMappings;
    }

    public static IntIntOptHashMap getListPropertyMappings() {
        if (listPropertyMappings == null) {
            listPropertyMappings = new IntIntOptHashMap(10);
            ParkingPropertyMappings.initListMappings();
        }
        return listPropertyMappings;
    }

    public static IntIntOptHashMap getArrayPropertyMappings() {
        if (arrayPropertyMappings == null) {
            arrayPropertyMappings = new IntIntOptHashMap();
            ParkingPropertyMappings.initArrayMappings();
        }
        return arrayPropertyMappings;
    }

    private static void initBoolMappings() {
    }

    private static void initListMappings() {
    }

    private static void initArrayMappings() {
    }

    private static void initIntMappings() {
    }
}

