/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.parkassistence.ops.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.car.parkassistence.ops.transformer.CarParkAssistenceOPSDisplayContentCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class CarParkAssistenceOPSDisplayContentTransformer
extends ItemTransformerAdapter {
    public static final int CAR_PARKASSISTENCE_OPS_DISPLAY_CONTENT_SYSTEM_INTEGER;
    public static final int CAR_PARKASSISTENCE_OPS_DISPLAY_CONTENT_SCREEN_INTEGER;
    public static final int CAR_PARKASSISTENCE_OPS_DISPLAY_CONTENT_MODE_INTEGER;
    public static final int CAR_PARKASSISTENCE_OPS_DISPLAY_CONTENT_VIEW_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[4];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10198);
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
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
            case 2: 
            case 3: {
                return new Integer(this.getInt(n, object));
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
        CarParkAssistenceOPSDisplayContentCollector carParkAssistenceOPSDisplayContentCollector = (CarParkAssistenceOPSDisplayContentCollector)object;
        switch (n) {
            case 0: {
                return carParkAssistenceOPSDisplayContentCollector.car_parkassistence_ops_display_content_system;
            }
            case 1: {
                return carParkAssistenceOPSDisplayContentCollector.car_parkassistence_ops_display_content_screen;
            }
            case 2: {
                return carParkAssistenceOPSDisplayContentCollector.car_parkassistence_ops_display_content_mode;
            }
            case 3: {
                return carParkAssistenceOPSDisplayContentCollector.car_parkassistence_ops_display_content_view;
            }
        }
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

