/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.homedestinput.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.homedestinput.transformer.NavigationHomeDestInputHomeDestinationDetailCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationHomeDestInputHomeDestinationDetailTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_CITY_STRING;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_CROSS_STRING;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_HNO_STRING;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_STREET_STRING;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_ZIP_STRING;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_LON_SECONDS_INTEGER;
    public static final int NAVIGATION_HOMEDESTINPUT_CURRENT_DEST_DATA_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_HOMEDESTINPUT_CURRENT_DEST_DATA_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_LAT_SECONDS_INTEGER;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_POSTAL_CODE_SPELLED_BOOLEAN;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_FULL_POSTAL_CODE_BOOLEAN;
    public static final int NAVIGATION_HOMEDESTINPUT_HOME_DESTINATION_DETAIL_ADDRESS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[17];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 16, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(837);
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
            case 14: 
            case 15: {
                return this.getBoolean(n, object);
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
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
            case 16: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationHomeDestInputHomeDestinationDetailCollector navigationHomeDestInputHomeDestinationDetailCollector = (NavigationHomeDestInputHomeDestinationDetailCollector)object;
        switch (n) {
            case 14: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_postal_code_spelled;
            }
            case 15: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_full_postal_code;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationHomeDestInputHomeDestinationDetailCollector navigationHomeDestInputHomeDestinationDetailCollector = (NavigationHomeDestInputHomeDestinationDetailCollector)object;
        switch (n) {
            case 8: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lon_degree;
            }
            case 9: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lon_minutes;
            }
            case 10: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lon_seconds;
            }
            case 11: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_current_dest_data_lat_degree;
            }
            case 12: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_current_dest_data_lat_minutes;
            }
            case 13: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lat_seconds;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationHomeDestInputHomeDestinationDetailCollector navigationHomeDestInputHomeDestinationDetailCollector = (NavigationHomeDestInputHomeDestinationDetailCollector)object;
        switch (n) {
            case 0: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_city;
            }
            case 1: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_city_refinement;
            }
            case 2: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_country_code;
            }
            case 3: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_cross;
            }
            case 4: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_hno;
            }
            case 5: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_street;
            }
            case 6: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_street_refinement;
            }
            case 7: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_zip;
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
        NavigationHomeDestInputHomeDestinationDetailCollector navigationHomeDestInputHomeDestinationDetailCollector = (NavigationHomeDestInputHomeDestinationDetailCollector)object;
        switch (n) {
            case 16: {
                return navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_address_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

