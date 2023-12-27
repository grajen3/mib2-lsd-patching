/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.destinput.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputMapInputDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationDestInputMapInputDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_IS_MATCHING_HOUSE_NUMBER_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_IS_MATCHING_JUNCTION_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_IS_MATCHING_STREET_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_IS_MATCHING_CITY_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_IS_MATCHING_ZIP_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_IS_MATCHING_COUNTRY_CODE_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_CITY_STRING;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_ZIP_STRING;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_STREET_STRING;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_HOUSE_NUMBER_STRING;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_JUNCTION_STRING;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_LAT_SECONDS_INTEGER;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_DESTINPUT_MAP_INPUT_DATA_LON_SECONDS_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[20];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 20, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(787);
    }

    @Override
    public int getColumnCount() {
        return 20;
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
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return this.getBoolean(n, object);
            }
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: {
                return new Integer(this.getInt(n, object));
            }
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationDestInputMapInputDataCollector navigationDestInputMapInputDataCollector = (NavigationDestInputMapInputDataCollector)object;
        switch (n) {
            case 1: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_is_matching_house_number;
            }
            case 2: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_is_matching_junction;
            }
            case 3: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_is_matching_street;
            }
            case 4: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_is_matching_city;
            }
            case 5: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_is_matching_zip;
            }
            case 6: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_is_matching_country_code;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationDestInputMapInputDataCollector navigationDestInputMapInputDataCollector = (NavigationDestInputMapInputDataCollector)object;
        switch (n) {
            case 15: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_lat_degree;
            }
            case 16: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_lat_minutes;
            }
            case 17: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_lat_seconds;
            }
            case 18: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_lon_degree;
            }
            case 19: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_lon_minutes;
            }
            case 20: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_lon_seconds;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationDestInputMapInputDataCollector navigationDestInputMapInputDataCollector = (NavigationDestInputMapInputDataCollector)object;
        switch (n) {
            case 7: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_country_code;
            }
            case 8: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_city;
            }
            case 9: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_city_refinement;
            }
            case 10: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_zip;
            }
            case 11: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_street;
            }
            case 12: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_street_refinement;
            }
            case 13: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_house_number;
            }
            case 14: {
                return navigationDestInputMapInputDataCollector.navigation_destinput_map_input_data_junction;
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

