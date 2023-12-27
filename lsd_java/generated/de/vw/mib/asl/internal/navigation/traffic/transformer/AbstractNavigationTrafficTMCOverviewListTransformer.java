/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.traffic.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractNavigationTrafficTMCOverviewListTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_CHILD_MESSAGE_COUNT_INTEGER;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_CHILD_EXIST_BOOLEAN;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_FOLDER_HAS_ITEMS_ON_ROUTE_BOOLEAN;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_EVENT0_STRING;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_ROAD_NAME_STRING;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_ROAD_NUMBER_STRING;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_ITEM_ON_ROAD_BOOLEAN;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_LABELED_ICONS_LABELED_ICON;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_ELEMENT_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_LIST_ITEM_AREA_MESSAGE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[11];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getLabeledIconValueAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 15, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1017);
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 7: 
            case 8: 
            case 11: 
            case 13: 
            case 14: 
            case 15: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: 
            case 11: 
            case 14: 
            case 15: {
                return this.getBoolean(n, object);
            }
            case 0: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 4: 
            case 5: {
                return this.getString(n, object);
            }
            case 7: {
                return this.getResourceLocator(n, object);
            }
            case 8: {
                return this.getLabeledIconValue(n, object);
            }
            case 13: {
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
}

