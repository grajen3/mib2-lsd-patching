/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.traffic.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCXUrgentMessageCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationTrafficTMCXUrgentMessageTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_DATE_STRING;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_DIRECTION1_STRING;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_DIRECTION2_STRING;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_END_LOCATION_STRING;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_ID_INTEGER;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_IS_ON_ROUTE_BOOLEAN;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_ROAD_NAME_STRING;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_START_LOCATION_STRING;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_STATION_STRING;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_SUBTYPE_STRING;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_TIME_STRING;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_TYPE_INTEGER;
    public static final int NAVIGATION_TRAFFIC_TMCX_URGENT_MESSAGE_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[13];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 12, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2471);
    }

    @Override
    public int getColumnCount() {
        return 13;
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
            case 12: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 5: {
                return this.getBoolean(n, object);
            }
            case 4: 
            case 11: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return this.getString(n, object);
            }
            case 12: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationTrafficTMCXUrgentMessageCollector navigationTrafficTMCXUrgentMessageCollector = (NavigationTrafficTMCXUrgentMessageCollector)object;
        switch (n) {
            case 5: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_is_on_route;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationTrafficTMCXUrgentMessageCollector navigationTrafficTMCXUrgentMessageCollector = (NavigationTrafficTMCXUrgentMessageCollector)object;
        switch (n) {
            case 4: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_id;
            }
            case 11: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_type;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationTrafficTMCXUrgentMessageCollector navigationTrafficTMCXUrgentMessageCollector = (NavigationTrafficTMCXUrgentMessageCollector)object;
        switch (n) {
            case 0: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_date;
            }
            case 1: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_direction1;
            }
            case 2: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_direction2;
            }
            case 3: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_end_location;
            }
            case 6: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_road_name;
            }
            case 7: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_start_location;
            }
            case 8: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_station;
            }
            case 9: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_subtype;
            }
            case 10: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_time;
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
        NavigationTrafficTMCXUrgentMessageCollector navigationTrafficTMCXUrgentMessageCollector = (NavigationTrafficTMCXUrgentMessageCollector)object;
        switch (n) {
            case 12: {
                return navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_details_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

