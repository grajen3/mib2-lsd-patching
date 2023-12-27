/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.connectivity.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.connectivity.transformer.ConnectivityCurrentConnectionDetailsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class ConnectivityCurrentConnectionDetailsTransformer
extends ItemTransformerAdapter {
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_NAME_STRING;
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_CONN_AVAILABLE_BOOLEAN;
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_SIGNAL_STRENGTH_INTEGER;
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_DURATION_MINUTES_INTEGER;
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_DURATION_HOURS_INTEGER;
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_TRAFFIC_INTEGER;
    public static final int CONNECTIVITY_CONNECTION_DETAILS_TRAFFIC_SINCE_LAST_RESET_INTEGER;
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_TRAFFIC_UPLINK_LONG;
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_TRAFFIC_DOWNLINK_LONG;
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_TRAFFIC__SINCE_LAST_RESET_LONG;
    public static final int CONNECTIVITY_CURRENT_CONNECTION_DETAILS_TRAFFIC__CURRENT_SESSION_LONG;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[11];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 12, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(365);
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 15: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: {
                return this.getBoolean(n, object);
            }
            case 2: 
            case 3: 
            case 4: 
            case 13: 
            case 15: {
                return new Integer(this.getInt(n, object));
            }
            case 0: {
                return this.getString(n, object);
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                return new Long(this.getLong(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        ConnectivityCurrentConnectionDetailsCollector connectivityCurrentConnectionDetailsCollector = (ConnectivityCurrentConnectionDetailsCollector)object;
        switch (n) {
            case 1: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_conn_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        ConnectivityCurrentConnectionDetailsCollector connectivityCurrentConnectionDetailsCollector = (ConnectivityCurrentConnectionDetailsCollector)object;
        switch (n) {
            case 2: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_signal_strength;
            }
            case 3: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_duration_minutes;
            }
            case 4: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_duration_hours;
            }
            case 13: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic;
            }
            case 15: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_connection_details_traffic_since_last_reset;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        ConnectivityCurrentConnectionDetailsCollector connectivityCurrentConnectionDetailsCollector = (ConnectivityCurrentConnectionDetailsCollector)object;
        switch (n) {
            case 0: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_name;
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
        ConnectivityCurrentConnectionDetailsCollector connectivityCurrentConnectionDetailsCollector = (ConnectivityCurrentConnectionDetailsCollector)object;
        switch (n) {
            case 9: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic_uplink;
            }
            case 10: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic_downlink;
            }
            case 11: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic__since_last_reset;
            }
            case 12: {
                return connectivityCurrentConnectionDetailsCollector.connectivity_current_connection_details_traffic__current_session;
            }
        }
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

