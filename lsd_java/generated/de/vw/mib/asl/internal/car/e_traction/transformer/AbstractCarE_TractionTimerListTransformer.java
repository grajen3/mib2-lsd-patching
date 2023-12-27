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

public abstract class AbstractCarE_TractionTimerListTransformer
extends ItemTransformerAdapter {
    public static final int CAR_E_TRACTION_TIMER_LIST__IS_ACTIVATED_BOOLEAN;
    public static final int CAR_E_TRACTION_TIMER_LIST__PROFILE_ID_INTEGER;
    public static final int CAR_E_TRACTION_TIMER_LIST__PROFILE_NAME_STRING;
    public static final int CAR_E_TRACTION_TIMER_LIST__GET_TIMER_MODE_INTEGER;
    public static final int CAR_E_TRACTION_TIMER_LIST__DEPARTURE_TIME_HOURS_INTEGER;
    public static final int CAR_E_TRACTION_TIMER_LIST__DEPARTURE_TIME_MINUTES_INTEGER;
    public static final int CAR_E_TRACTION_TIMER_LIST__DEPARTURE_TIME_WEEK_DAYS_FLAG_VECTOR;
    public static final int CAR_E_TRACTION_TIMER_LIST__DEPARTURE_TIME_WEEK_DAY_NEXT_INTEGER;
    public static final int CAR_E_TRACTION_CLIMATE_BOOLEAN;
    public static final int CAR_E_TRACTION_CHARGING_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getFlagVectorAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 10, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10375);
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: 
            case 9: 
            case 10: {
                return this.getBoolean(n, object);
            }
            case 1: 
            case 4: 
            case 5: 
            case 6: 
            case 8: {
                return new Integer(this.getInt(n, object));
            }
            case 2: {
                return this.getString(n, object);
            }
            case 7: {
                return this.getFlagVector(n, object);
            }
        }
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

