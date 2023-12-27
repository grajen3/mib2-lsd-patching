/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractNavInfoTileManeuverViewDataListTransformer
extends ItemTransformerAdapter {
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_TYPE_INTEGER;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_NAME_STRING;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_NAME_SIGN_POST_STRING;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_DISTANCE_TO_MANEUVER_INTEGER;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_RTTH_INTEGER;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_RTTM_INTEGER;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_MANEUVER_MAIN_ELEMENT_INTEGER;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_MANEUVER_DIRECTION_INTEGER;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_NUMBER_OF_POI_ICONS_INTEGER;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_POI_ICON1_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_POI_ICON2_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_POI_ICON3_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_POI_ICON4_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_POI_ICON5_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_TMC_ROAD_NAME_STRING;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_TMC_START_LOCATION_STRING;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_TMC_MESSAGE_TEXT_STRING;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_TMC_LIST_ICON_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MANEUVER_VIEW_DATA_LIST_MANEUVER_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[19];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 18, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(690903552);
    }

    @Override
    public int getColumnCount() {
        return 19;
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
            case 18: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 18: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: 
            case 14: 
            case 15: 
            case 16: {
                return this.getString(n, object);
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 17: {
                return this.getResourceLocator(n, object);
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

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

