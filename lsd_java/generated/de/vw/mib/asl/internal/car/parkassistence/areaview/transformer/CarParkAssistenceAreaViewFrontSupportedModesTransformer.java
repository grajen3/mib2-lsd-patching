/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewFrontSupportedModesCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class CarParkAssistenceAreaViewFrontSupportedModesTransformer
extends ItemTransformerAdapter {
    public static final int CAR_PARKASSISTENCE_AREAVIEW_FRONT_SUPPORTED_MODES__IS_PARKBOX_MODE_BOOLEAN;
    public static final int CAR_PARKASSISTENCE_AREAVIEW_FRONT_SUPPORTED_MODES__IS_CROSSING_MODE_BOOLEAN;
    public static final int CAR_PARKASSISTENCE_AREAVIEW_FRONT_SUPPORTED_MODES__IS_TOP_MODE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[3];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10452);
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
            case 0: 
            case 1: 
            case 2: {
                return this.getBoolean(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        CarParkAssistenceAreaViewFrontSupportedModesCollector carParkAssistenceAreaViewFrontSupportedModesCollector = (CarParkAssistenceAreaViewFrontSupportedModesCollector)object;
        switch (n) {
            case 0: {
                return carParkAssistenceAreaViewFrontSupportedModesCollector.car_parkassistence_areaview_front_supported_modes__is_parkbox_mode;
            }
            case 1: {
                return carParkAssistenceAreaViewFrontSupportedModesCollector.car_parkassistence_areaview_front_supported_modes__is_crossing_mode;
            }
            case 2: {
                return carParkAssistenceAreaViewFrontSupportedModesCollector.car_parkassistence_areaview_front_supported_modes__is_top_mode;
            }
        }
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
        throw new IllegalArgumentException();
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
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

