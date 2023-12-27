/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.destinput.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputCurrentDestDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationDestInputCurrentDestDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_CITY_STRING;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_COUNTRY_STRING;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_CROSS_STRING;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_HNO_STRING;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_STREET_STRING;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_ZIP_STRING;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_CITY_VALID_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_COUNTRY_VALID_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_CROSS_VALID_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_HNO_VALID_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_STREET_VALID_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_LON_SECONDS_INTEGER;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_LAT_SECONDS_INTEGER;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_TYPE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_ZIP_VALID_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_POSTAL_CODE_SPELLED_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_CURRENT_DEST_DATA_FULL_POSTAL_CODE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[23];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 22, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(783);
    }

    @Override
    public int getColumnCount() {
        return 23;
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
            case 22: 
            case 23: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 20: 
            case 22: 
            case 23: {
                return this.getBoolean(n, object);
            }
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationDestInputCurrentDestDataCollector navigationDestInputCurrentDestDataCollector = (NavigationDestInputCurrentDestDataCollector)object;
        switch (n) {
            case 8: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_city_valid;
            }
            case 9: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_country_valid;
            }
            case 10: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_cross_valid;
            }
            case 11: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_hno_valid;
            }
            case 12: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_street_valid;
            }
            case 20: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_zip_valid;
            }
            case 23: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_postal_code_spelled;
            }
            case 22: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_full_postal_code;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationDestInputCurrentDestDataCollector navigationDestInputCurrentDestDataCollector = (NavigationDestInputCurrentDestDataCollector)object;
        switch (n) {
            case 13: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_lon_degree;
            }
            case 14: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_lon_minutes;
            }
            case 15: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_lon_seconds;
            }
            case 16: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_lat_degree;
            }
            case 17: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_lat_minutes;
            }
            case 18: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_lat_seconds;
            }
            case 19: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_type;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationDestInputCurrentDestDataCollector navigationDestInputCurrentDestDataCollector = (NavigationDestInputCurrentDestDataCollector)object;
        switch (n) {
            case 0: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_city;
            }
            case 1: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_city_refinement;
            }
            case 2: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_country;
            }
            case 3: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_cross;
            }
            case 4: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_hno;
            }
            case 5: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_street;
            }
            case 6: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_street_refinement;
            }
            case 7: {
                return navigationDestInputCurrentDestDataCollector.navigation_destinput_current_dest_data_zip;
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

