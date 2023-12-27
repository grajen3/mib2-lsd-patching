/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractNavigationGuidanceCalculatedRouteDetailsTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_GUIDANCE_CALCULATED_ROUTE_DETAILS_TTH_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATED_ROUTE_DETAILS_TTM_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATED_TOLL_COST_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATED_TOLL_COST_CURRENCY_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATED_LENGTH_ON_TOLL_ROADS_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATED_ROUTE_DETAILS_DISTANCE_TO_DESTINATION_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATED_ROUTE_DETAILS_CALCULATION_STATE_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATED_ROUTE_DETAILS_CALCULATION_PROGRESS_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATED_ROUTE_DETAILS_FIRST_MOTORWAY_ENTRY_NAME1_STRING;
    public static final int NAVIGATION_GUIDANCE_CALCULATED_ROUTE_DETAILS_LAST_MOTORWAY_ENTRY_EXIT1_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(822);
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
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 9: 
            case 10: 
            case 11: {
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
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 11: {
                return new Integer(this.getInt(n, object));
            }
            case 9: 
            case 10: {
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
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

