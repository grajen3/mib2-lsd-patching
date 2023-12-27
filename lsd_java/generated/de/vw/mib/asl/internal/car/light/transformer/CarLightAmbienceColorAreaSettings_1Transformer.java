/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.light.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.car.light.transformer.CarLightAmbienceColorAreaSettings_1Collector;
import org.dsi.ifc.global.ResourceLocator;

public final class CarLightAmbienceColorAreaSettings_1Transformer
extends ItemTransformerAdapter {
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_AVAILABILITY__4_INTEGER_ARRAY;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_MODE__4_FLAG_VECTOR;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_BRIGHTNESS_VALUE__4_INTEGER_ARRAY;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[3];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getFlagVectorAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 2, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10599);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: {
                return this.getFlagVector(n, object);
            }
            case 0: 
            case 2: {
                return this.getIntegerVector(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean[] getFlagVector(int n, Object object) {
        CarLightAmbienceColorAreaSettings_1Collector carLightAmbienceColorAreaSettings_1Collector = (CarLightAmbienceColorAreaSettings_1Collector)object;
        switch (n) {
            case 1: {
                return carLightAmbienceColorAreaSettings_1Collector.car_light_ambience_color_area_mode__4;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        CarLightAmbienceColorAreaSettings_1Collector carLightAmbienceColorAreaSettings_1Collector = (CarLightAmbienceColorAreaSettings_1Collector)object;
        switch (n) {
            case 0: {
                return carLightAmbienceColorAreaSettings_1Collector.car_light_ambience_color_area_availability__4;
            }
            case 2: {
                return carLightAmbienceColorAreaSettings_1Collector.car_light_ambience_color_area_brightness_value__4;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String[] getStringVector(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

