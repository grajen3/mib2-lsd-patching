/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.motorwayinfo.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractNavigationMotorwayInfoMotorwayInfoDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_EXIT_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_EXIT_NUMBER_STRING;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_EXIT_NAME_STRING;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON1_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON2_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON3_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON4_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON5_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON6_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_DISTANCE_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_RTTH_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_RTTM_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_TMC_ICON1_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_TMC_ICON2_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_TMC_ICON3_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_SPEED_FLOW_SEGMENT1_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_SPEED_FLOW_SEGMENT2_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_SPEED_FLOW_SEGMENT3_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_SPEED_FLOW_SEGMENT4_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_SPEED_FLOW_SEGMENT_ONE_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_SPEED_FLOW_SEGMENT_TWO_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_SPEED_FLOW_SEGMENT_THREE_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_SPEED_FLOW_SEGMENT_FOUR_INTEGER;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_TMC_ICON1VISIBILITY_BOOLEAN;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_TMC_ICON2VISIBILITY_BOOLEAN;
    public static final int NAVIGATION_MOTORWAYINFO_MOTORWAY_INFO_DATA_TMC_ICON3VISIBILITY_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[26];
        int n = 0;
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 25, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(720375808);
    }

    @Override
    public int getColumnCount() {
        return 26;
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
            case 25: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 23: 
            case 24: 
            case 25: {
                return this.getBoolean(n, object);
            }
            case 9: 
            case 10: 
            case 11: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: {
                return this.getString(n, object);
            }
            case 0: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 12: 
            case 13: 
            case 14: {
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

