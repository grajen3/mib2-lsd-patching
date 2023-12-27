/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractNavInfoTileManeuverViewTenItemsManeuverViewDataListTransformer
extends ItemTransformerAdapter {
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_LIST_MANEUVER_TYPE_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_NAME_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_EXIT_NUMBER_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_ADDRESS_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_NAME_SIGN_POST_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_DISTANCE_TO_MANEUVER_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_RTTH_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_RTTM_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_MANEUVER_MAIN_ELEMENT_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_MANEUVER_DIRECTION_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_NUMBER_OF_POI_ICONS_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_POI_ICON1_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_POI_ICON2_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_POI_ICON3_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_POI_ICON4_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_POI_ICON5_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_POI_ICON6_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_POI_ICON7_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TMC_ROAD_NAME_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TMC_ROAD_NUMBER_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TMC_START_LOCATION_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TMC_END_LOCATION_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TMC_MESSAGE_TEXT_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TMC_LIST_ICON_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TMC_DELAY_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TOLL_GATE_DIRECTIONS_INTEGER_ARRAY;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TOLL_GATE_INFOS_INTEGER_ARRAY;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TOLL_GATE_MARKINGS_LEFT_INTEGER_ARRAY;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TOLL_GATE_MARKINGS_RIGHT_INTEGER_ARRAY;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_COLOR_INDICATOR_ICON_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TRAFFIC_LIGHT_ICON_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TRAFFIC_LIGHT_ICON_VISIBILITY_BOOLEAN;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_LANE_DIRECTIONS_INTEGER_ARRAY;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_LANE_INFOS_INTEGER_ARRAY;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_LANE_MARKINGS_LEFT_INTEGER_ARRAY;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_LANE_MARKINGS_RIGHT_INTEGER_ARRAY;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_LANE_NUMBER_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_ROAD_SIGN_LABELED_ICON_LABELED_ICON;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_ROAD_SIGN_LABELED_ICON_TEXT_STRING;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TOLL_GATE_COST_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_TOLL_GATE_COST_CURRENCY_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_LENGTH_INTEGER;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_STOPOVER_FLAG_ICON_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_ADDRESS_INFO_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVINFOTILE_MANEUVERVIEWTENITEMS_MANEUVER_VIEW_DATA_LIST_MANEUVER_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[45];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 25, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 26, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 27, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 28, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 29, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 30, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 31, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 32, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 33, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 34, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 35, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 36, object);
        stringArray[n++] = TransformerUtil.getLabeledIconValueAsString(this, 37, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 38, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 39, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 40, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 41, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 42, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 43, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 44, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(707680768);
    }

    @Override
    public int getColumnCount() {
        return 45;
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
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 31: 
            case 44: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 24: 
            case 36: 
            case 39: 
            case 40: 
            case 41: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 38: {
                return this.getString(n, object);
            }
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 32: 
            case 33: 
            case 34: 
            case 35: {
                return this.getIntegerVector(n, object);
            }
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 23: 
            case 29: 
            case 30: 
            case 42: {
                return this.getResourceLocator(n, object);
            }
            case 37: {
                return this.getLabeledIconValue(n, object);
            }
            case 43: {
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
    public String[] getStringVector(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

