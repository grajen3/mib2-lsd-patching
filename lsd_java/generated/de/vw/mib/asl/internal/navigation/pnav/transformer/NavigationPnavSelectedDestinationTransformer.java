/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.pnav.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavSelectedDestinationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationPnavSelectedDestinationTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_CALCULATION_STATE_INTEGER;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_CALCULATION_PROGRESS_INTEGER;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_LIKELIHOOD_INTEGER;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_DTD_INTEGER;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_RTT_INTEGER;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_TIME_DELAY_INTEGER;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_ROUTE_COLOR_INTEGER;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_ROUTE_COLOR_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_STREET_STRING;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_HOUSENUMBER_STRING;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_CITY_STRING;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_CROSS_STREET_STRING;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_LATITUDE_INTEGER;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_LONGITUDE_INTEGER;
    public static final int NAVIGATION_PNAV_SELECTED_DESTINATION_ADDRESS_DATA_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[17];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 16, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2062553088);
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
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 14: 
            case 15: {
                return new Integer(this.getInt(n, object));
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                return this.getString(n, object);
            }
            case 7: {
                return this.getResourceLocator(n, object);
            }
            case 16: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationPnavSelectedDestinationCollector navigationPnavSelectedDestinationCollector = (NavigationPnavSelectedDestinationCollector)object;
        switch (n) {
            case 0: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_calculation_state;
            }
            case 1: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_calculation_progress;
            }
            case 2: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_likelihood;
            }
            case 3: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_dtd;
            }
            case 4: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_rtt;
            }
            case 5: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_time_delay;
            }
            case 6: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_route_color;
            }
            case 14: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_latitude;
            }
            case 15: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_longitude;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationPnavSelectedDestinationCollector navigationPnavSelectedDestinationCollector = (NavigationPnavSelectedDestinationCollector)object;
        switch (n) {
            case 8: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_street;
            }
            case 9: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_housenumber;
            }
            case 10: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_street_refinement;
            }
            case 11: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_city;
            }
            case 12: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_city_refinement;
            }
            case 13: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_cross_street;
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
        NavigationPnavSelectedDestinationCollector navigationPnavSelectedDestinationCollector = (NavigationPnavSelectedDestinationCollector)object;
        switch (n) {
            case 7: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_route_color_icon;
            }
        }
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
        NavigationPnavSelectedDestinationCollector navigationPnavSelectedDestinationCollector = (NavigationPnavSelectedDestinationCollector)object;
        switch (n) {
            case 16: {
                return navigationPnavSelectedDestinationCollector.navigation_pnav_selected_destination_address_data_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

