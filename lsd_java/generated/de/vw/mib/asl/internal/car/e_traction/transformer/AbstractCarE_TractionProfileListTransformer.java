/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.e_traction.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractCarE_TractionProfileListTransformer
extends ItemTransformerAdapter {
    public static final int CAR_E_TRACTION_PROFILE_LIST__ID_INTEGER;
    public static final int CAR_E_TRACTION_PROFILE_LIST__NAME_STRING;
    public static final int CAR_E_TRACTION_PROFILE_LIST__IS_CHARGING_BOOLEAN;
    public static final int CAR_E_TRACTION_PROFILE_LIST__SOC_INTEGER;
    public static final int CAR_E_TRACTION_PROFILE_LIST__IS_AIR_CONDITIONING_BOOLEAN;
    public static final int CAR_E_TRACTION_PROFILE_LIST__TEMPERATURE_VALUE_INTEGER;
    public static final int CAR_E_TRACTION_PROFILE_LIST__TEMPERATURE_UNIT_INTEGER;
    public static final int CAR_E_TRACTION_PROFILE_LIST__IS_USED_BY_TIMER_BOOLEAN;
    public static final int CAR_E_TRACTION_PROFILE_LIST__MAX_CURRENT_INTEGER;
    public static final int CAR_E_TRACTION_PROFILE_LIST__IS_NIGHT_RATE_BOOLEAN;
    public static final int CAR_E_TRACTION_PROFILE_LIST__NIGHT_RATE_START_HOURS_INTEGER;
    public static final int CAR_E_TRACTION_PROFILE_LIST__NIGHT_RATE_START_MINUTES_INTEGER;
    public static final int CAR_E_TRACTION_PROFILE_LIST__NIGHT_RATE_END_HOURS_INTEGER;
    public static final int CAR_E_TRACTION_PROFILE_LIST__NIGHT_RATE_END_MINUTES_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[14];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10374);
    }

    @Override
    public int getColumnCount() {
        return 14;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
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
            case 12: 
            case 13: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 2: 
            case 4: 
            case 7: 
            case 9: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                return new Integer(this.getInt(n, object));
            }
            case 1: {
                return this.getString(n, object);
            }
        }
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

