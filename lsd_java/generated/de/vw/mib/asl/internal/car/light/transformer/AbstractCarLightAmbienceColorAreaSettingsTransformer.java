/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.light.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractCarLightAmbienceColorAreaSettingsTransformer
extends ItemTransformerAdapter {
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_AVAILABILITY_INTEGER;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_MODE_BOOLEAN;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_BRIGHTNESS_VALUE_INTEGER;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_AVAILABILITY__1_INTEGER_ARRAY;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_MODE__1_FLAG_VECTOR;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_BRIGHTNESS_VALUE__1_INTEGER_ARRAY;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_AVAILABILITY__2_INTEGER_ARRAY;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_MODE__2_FLAG_VECTOR;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_BRIGHTNESS_VALUE__2_INTEGER_ARRAY;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_AVAILABILITY__3_INTEGER_ARRAY;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_MODE__3_FLAG_VECTOR;
    public static final int CAR_LIGHT_AMBIENCE_COLOR_AREA_BRIGHTNESS_VALUE__3_INTEGER_ARRAY;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntegerVectorAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedFlagVectorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntegerVectorAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntegerVectorAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedFlagVectorAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntegerVectorAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntegerVectorAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedFlagVectorAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntegerVectorAsString(this, 12, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10464);
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: {
                return this.getBoolean(n, object);
            }
            case 2: 
            case 3: {
                return new Integer(this.getInt(n, object));
            }
            case 5: 
            case 8: 
            case 11: {
                return this.getFlagVector(n, object);
            }
            case 4: 
            case 6: 
            case 7: 
            case 9: 
            case 10: 
            case 12: {
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

