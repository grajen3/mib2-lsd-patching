/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractNavigationPOIResultListTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_POI_RESULT_LIST_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_POI_RESULT_LIST_NAME_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_SUB_ITEM_EXIST_BOOLEAN;
    public static final int NAVIGATION_POI_RESULT_LIST_DISTANCE_INTEGER;
    public static final int NAVIGATION_POI_RESULT_LIST_DIRECTION_ARROW_INDEX_INTEGER;
    public static final int NAVIGATION_POI_RESULT_LIST_INSIDE_RANGE_BOOLEAN;
    public static final int NAVIGATION_POI_RESULT_LIST_POI_CATEGORY_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_COUNTRY_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_HOUSE_NUMBER_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_STREET_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_CITY_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_ZIP_CODE_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_WARD_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_CHOME_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_PROVINCE_STRING;
    public static final int NAVIGATION_POI_RESULT_LIST_DATA_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_POI_RESULT_LIST_ADDRESS_TYPE_INTEGER;
    public static final int NAVIGATION_POI_RESULT_LIST_FIX_FORMATTER_DATA_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[20];
        int n = 0;
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getDeprecatedFixFormatterFieldDataAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 19, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(946);
    }

    @Override
    public int getColumnCount() {
        return 20;
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
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 2: 
            case 5: {
                return this.getBoolean(n, object);
            }
            case 3: 
            case 4: 
            case 18: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: {
                return this.getString(n, object);
            }
            case 0: {
                return this.getResourceLocator(n, object);
            }
            case 17: 
            case 19: {
                return this.getFixFormatterFieldData(n, object);
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
    public long getLong(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

