/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.traffic.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCMessageDetailCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationTrafficTMCMessageDetailTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_TRAFFIC_TMC_MESSAGE_DETAIL_DATE_STRING;
    public static final int NAVIGATION_TRAFFIC_TMC_MESSAGE_DETAIL_STATION_STRING;
    public static final int NAVIGATION_TRAFFIC_TMC_MESSAGE_DETAIL_TIME_STRING;
    public static final int NAVIGATION_TRAFFIC_TMC_MESSAGE_DETAIL_ID_INTEGER;
    public static final int NAVIGATION_TRAFFIC_TMC_MESSAGE_DETAIL_TEXT_STRING;
    public static final int NAVIGATION_TRAFFIC_TMC_MESSAGE_DETAIL_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_TRAFFIC_SELECTED_TMC_MESSAGE_DETAIL_ON_ROUTE_BOOLEAN;
    public static final int NAVIGATION_TRAFFIC_SELECTED_TMC_MESSAGE_DETAIL_MAP_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_TRAFFIC_TMC_MESSAGE_DETAIL_ADDRESS_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[9];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 20, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1016);
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 9: 
            case 16: 
            case 18: 
            case 19: 
            case 20: 
            case 21: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 19: 
            case 21: {
                return this.getBoolean(n, object);
            }
            case 9: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 16: {
                return this.getString(n, object);
            }
            case 18: {
                return this.getResourceLocator(n, object);
            }
            case 20: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationTrafficTMCMessageDetailCollector navigationTrafficTMCMessageDetailCollector = (NavigationTrafficTMCMessageDetailCollector)object;
        switch (n) {
            case 19: {
                return navigationTrafficTMCMessageDetailCollector.navigation_traffic_selected_tmc_message_detail_on_route;
            }
            case 21: {
                return navigationTrafficTMCMessageDetailCollector.navigation_traffic_selected_tmc_message_detail_map_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationTrafficTMCMessageDetailCollector navigationTrafficTMCMessageDetailCollector = (NavigationTrafficTMCMessageDetailCollector)object;
        switch (n) {
            case 9: {
                return navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_id;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationTrafficTMCMessageDetailCollector navigationTrafficTMCMessageDetailCollector = (NavigationTrafficTMCMessageDetailCollector)object;
        switch (n) {
            case 0: {
                return navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_date;
            }
            case 1: {
                return navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_station;
            }
            case 2: {
                return navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_time;
            }
            case 16: {
                return navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_text;
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
        NavigationTrafficTMCMessageDetailCollector navigationTrafficTMCMessageDetailCollector = (NavigationTrafficTMCMessageDetailCollector)object;
        switch (n) {
            case 18: {
                return navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_icon;
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
        NavigationTrafficTMCMessageDetailCollector navigationTrafficTMCMessageDetailCollector = (NavigationTrafficTMCMessageDetailCollector)object;
        switch (n) {
            case 20: {
                return navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_address_details_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

