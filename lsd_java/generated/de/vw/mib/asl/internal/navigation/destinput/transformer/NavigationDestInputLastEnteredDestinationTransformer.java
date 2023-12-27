/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.destinput.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputLastEnteredDestinationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationDestInputLastEnteredDestinationTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_CITY_STRING;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_COUNTRY_STRING;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_STREET_STRING;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_ZIP_STRING;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_HOUSE_NUMBER_STRING;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_JUNCTION_STRING;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_INPUT_DATA_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_INPUT_DATA_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_INPUT_DATA_LAT_SECONDS_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_INPUT_DATA_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_INPUT_DATA_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_INPUT_DATA_LON_SECONDS_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_POSTAL_CODE_SPELLED_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LAST_ENTERED_FULL_POSTAL_CODE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[17];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 16, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(791);
    }

    @Override
    public int getColumnCount() {
        return 17;
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
            case 16: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 15: 
            case 16: {
                return this.getBoolean(n, object);
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationDestInputLastEnteredDestinationCollector navigationDestInputLastEnteredDestinationCollector = (NavigationDestInputLastEnteredDestinationCollector)object;
        switch (n) {
            case 15: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_postal_code_spelled;
            }
            case 16: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_full_postal_code;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationDestInputLastEnteredDestinationCollector navigationDestInputLastEnteredDestinationCollector = (NavigationDestInputLastEnteredDestinationCollector)object;
        switch (n) {
            case 9: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_input_data_lat_degree;
            }
            case 10: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_input_data_lat_minutes;
            }
            case 11: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_input_data_lat_seconds;
            }
            case 12: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_input_data_lon_degree;
            }
            case 13: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_input_data_lon_minutes;
            }
            case 14: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_input_data_lon_seconds;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationDestInputLastEnteredDestinationCollector navigationDestInputLastEnteredDestinationCollector = (NavigationDestInputLastEnteredDestinationCollector)object;
        switch (n) {
            case 0: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_city;
            }
            case 1: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_city_refinement;
            }
            case 2: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_country;
            }
            case 3: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_country_code;
            }
            case 4: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_street;
            }
            case 5: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_street_refinement;
            }
            case 6: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_zip;
            }
            case 7: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_house_number;
            }
            case 8: {
                return navigationDestInputLastEnteredDestinationCollector.navigation_destinput_last_entered_junction;
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

