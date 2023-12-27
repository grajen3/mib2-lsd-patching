/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.shield.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldLocationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationShieldLocationTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_SHIELD_LOCATION_ADDRESS_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_SHIELD_LOCATION_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_SHIELD_LOCATION_GUIDABLE_BOOLEAN;
    public static final int NAVIGATION_SHIELD_LOCATION_PHONE_NUMBER_STRING;
    public static final int NAVIGATION_SHIELD_LOCATION_URL_STRING;
    public static final int NAVIGATION_SHIELD_LOCATION_ADDRESS_TYPE_INTEGER;
    public static final int NAVIGATION_SHIELD_LOCATION_DISTANCE_INTEGER;
    public static final int NAVIGATION_SHIELD_LOCATION_RESULT_SELECTED_DETAILS_PROVIDER_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_SHIELD_LOCATION_RESULT_SELECTED_DETAILS_PROVIDER_STRING;
    public static final int NAVIGATION_SHIELD_LOCATION_RESULT_SELECTED_DETAILS_PAYMENT_INTEGER;
    public static final int NAVIGATION_SHIELD_LOCATION_RESULT_SELECTED_DETAILS_SUBSCRIPTION_INTEGER;
    public static final int NAVIGATION_SHIELD_LOCATION_RESULT_SELECTED_DETAILS_ONSITEPAYMENT_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_SHIELD_LOCATION_RESULT_SELECTED_DETAILS_ONSITEPAYMENT__ENUM_INTEGER;
    public static final int NAVIGATION_SHIELD_LOCATION_RESULT_SELECTED_DETAILS_ACCESS_INTEGER;
    public static final int NAVIGATION_SHIELD_LOCATION_RESULT_SELECTED_DETAILS_OPEN24H_INTEGER;
    public static final int NAVIGATION_SHIELD_LOCATION_RESULT_SELECTED_DETAILS_CONNECTOR_COUNT_INTEGER;
    public static final int NAVIGATION_SHIELD_LOCATION_DIRECTION_ARROW_INDEX_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[17];
        int n = 0;
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 16, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1777340416);
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
            case 2: 
            case 7: 
            case 11: {
                return this.getBoolean(n, object);
            }
            case 4: 
            case 5: 
            case 9: 
            case 10: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: {
                return new Integer(this.getInt(n, object));
            }
            case 3: 
            case 6: 
            case 8: {
                return this.getString(n, object);
            }
            case 1: {
                return this.getResourceLocator(n, object);
            }
            case 0: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationShieldLocationCollector navigationShieldLocationCollector = (NavigationShieldLocationCollector)object;
        switch (n) {
            case 2: {
                return navigationShieldLocationCollector.navigation_shield_location_guidable;
            }
            case 7: {
                return navigationShieldLocationCollector.navigation_shield_location_result_selected_details_provider_available;
            }
            case 11: {
                return navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationShieldLocationCollector navigationShieldLocationCollector = (NavigationShieldLocationCollector)object;
        switch (n) {
            case 4: {
                return navigationShieldLocationCollector.navigation_shield_location_address_type;
            }
            case 5: {
                return navigationShieldLocationCollector.navigation_shield_location_distance;
            }
            case 9: {
                return navigationShieldLocationCollector.navigation_shield_location_result_selected_details_payment;
            }
            case 10: {
                return navigationShieldLocationCollector.navigation_shield_location_result_selected_details_subscription;
            }
            case 12: {
                return navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment__enum;
            }
            case 13: {
                return navigationShieldLocationCollector.navigation_shield_location_result_selected_details_access;
            }
            case 14: {
                return navigationShieldLocationCollector.navigation_shield_location_result_selected_details_open24h;
            }
            case 15: {
                return navigationShieldLocationCollector.navigation_shield_location_result_selected_details_connector_count;
            }
            case 16: {
                return navigationShieldLocationCollector.navigation_shield_location_direction_arrow_index;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationShieldLocationCollector navigationShieldLocationCollector = (NavigationShieldLocationCollector)object;
        switch (n) {
            case 3: {
                return navigationShieldLocationCollector.navigation_shield_location_phone_number;
            }
            case 6: {
                return navigationShieldLocationCollector.navigation_shield_location_url;
            }
            case 8: {
                return navigationShieldLocationCollector.navigation_shield_location_result_selected_details_provider;
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
        NavigationShieldLocationCollector navigationShieldLocationCollector = (NavigationShieldLocationCollector)object;
        switch (n) {
            case 1: {
                return navigationShieldLocationCollector.navigation_shield_location_icon;
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
        NavigationShieldLocationCollector navigationShieldLocationCollector = (NavigationShieldLocationCollector)object;
        switch (n) {
            case 0: {
                return navigationShieldLocationCollector.navigation_shield_location_address_details_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

