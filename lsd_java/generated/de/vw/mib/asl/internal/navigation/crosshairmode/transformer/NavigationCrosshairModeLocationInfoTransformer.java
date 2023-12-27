/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.crosshairmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.crosshairmode.transformer.NavigationCrosshairModeLocationInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationCrosshairModeLocationInfoTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_TMC_NAME_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_TMC_ROAD_NAME_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_TMC_STACK_COUNT_INTEGER;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_POI_NAME_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_POI_STACK_COUNT_INTEGER;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_FAVORITE_NAME_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_LANDMARK_NAME_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_COUNTRY_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_PROVINCE_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_STATE_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_CITY_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_STREET_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_CROSSING_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_HOUSENUMBER_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_POSTAL_CODE_STRING;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_CITY_CENTER_BOOLEAN;
    public static final int NAVIGATION_CROSSHAIRMODE_LOCATION_INFO_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[19];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 5, object);
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
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getDeprecatedFixFormatterFieldDataAsString(this, 18, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(938479616);
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
            case 17: {
                return this.getBoolean(n, object);
            }
            case 2: 
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 3: 
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
            case 16: {
                return this.getString(n, object);
            }
            case 18: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationCrosshairModeLocationInfoCollector navigationCrosshairModeLocationInfoCollector = (NavigationCrosshairModeLocationInfoCollector)object;
        switch (n) {
            case 17: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_city_center;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationCrosshairModeLocationInfoCollector navigationCrosshairModeLocationInfoCollector = (NavigationCrosshairModeLocationInfoCollector)object;
        switch (n) {
            case 2: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_tmc_stack_count;
            }
            case 4: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_poi_stack_count;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationCrosshairModeLocationInfoCollector navigationCrosshairModeLocationInfoCollector = (NavigationCrosshairModeLocationInfoCollector)object;
        switch (n) {
            case 0: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_tmc_name;
            }
            case 1: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_tmc_road_name;
            }
            case 3: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_poi_name;
            }
            case 5: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_favorite_name;
            }
            case 6: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_landmark_name;
            }
            case 7: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_country;
            }
            case 8: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_province;
            }
            case 9: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_state;
            }
            case 10: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_city;
            }
            case 11: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_city_refinement;
            }
            case 12: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_street;
            }
            case 13: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_street_refinement;
            }
            case 14: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_crossing;
            }
            case 15: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_housenumber;
            }
            case 16: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_postal_code;
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
        NavigationCrosshairModeLocationInfoCollector navigationCrosshairModeLocationInfoCollector = (NavigationCrosshairModeLocationInfoCollector)object;
        switch (n) {
            case 18: {
                return navigationCrosshairModeLocationInfoCollector.navigation_crosshairmode_location_info_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

