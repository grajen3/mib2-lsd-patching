/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.transformer;

import de.vw.mib.asl.internal.car.light.transformer.AmbienceLightAreaCollector;
import generated.de.vw.mib.asl.internal.car.light.transformer.CarLightAmbienceColorAreaSettings_1Collector;

public class CarLightAmbienceColorAreaSettings_1CollectorFactory {
    private static final int LIGHT_AREA_AVAILABILITY_INVISIBLE;

    public static CarLightAmbienceColorAreaSettings_1Collector[] createCarLightAmbienceColorAreaSettings_1Collector(AmbienceLightAreaCollector[] ambienceLightAreaCollectorArray, int n, boolean bl) {
        CarLightAmbienceColorAreaSettings_1Collector carLightAmbienceColorAreaSettings_1Collector = new CarLightAmbienceColorAreaSettings_1Collector();
        for (int i2 = 0; i2 < ambienceLightAreaCollectorArray.length; ++i2) {
            carLightAmbienceColorAreaSettings_1Collector.car_light_ambience_color_area_availability__4[i2] = n == 0 ? 0 : ambienceLightAreaCollectorArray[i2].getColorAreaAvailability();
            carLightAmbienceColorAreaSettings_1Collector.car_light_ambience_color_area_brightness_value__4[i2] = ambienceLightAreaCollectorArray[i2].getBrightnessValue();
            carLightAmbienceColorAreaSettings_1Collector.car_light_ambience_color_area_mode__4[i2] = bl ? false : ambienceLightAreaCollectorArray[i2].isColorAreaMode();
        }
        return new CarLightAmbienceColorAreaSettings_1Collector[]{carLightAmbienceColorAreaSettings_1Collector};
    }
}

