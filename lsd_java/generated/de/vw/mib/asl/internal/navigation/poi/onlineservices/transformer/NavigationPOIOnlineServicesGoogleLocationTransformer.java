/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.NavigationPOIOnlineServicesGoogleLocationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationPOIOnlineServicesGoogleLocationTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_POI_ONLINESERVICES_GOOGLE_LOCATION_PHONENUMBER_STRING;
    public static final int NAVIGATION_POI_ONLINESERVICES_GOOGLE_LOCATION_NAME_STRING;
    public static final int NAVIGATION_POI_ONLINESERVICES_GOOGLE_LOCATION_DIRECTION_INTEGER;
    public static final int NAVIGATION_POI_ONLINESERVICES_GOOGLE_LOCATION_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_POI_ONLINESERVICES_GOOGLE_LOCATION_DISTANCE_INTEGER;
    public static final int NAVIGATION_POI_ONLINESERVICES_GOOGLE_LOCATION_CITY_STRING;
    public static final int NAVIGATION_POI_ONLINESERVICES_GOOGLE_LOCATION_ADDRESS_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_POI_ONLINESERVICES_GOOGLE_LOCATION_IS_NAVIGATEABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[8];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3760);
    }

    @Override
    public int getColumnCount() {
        return 8;
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
            case 7: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 7: {
                return this.getBoolean(n, object);
            }
            case 2: 
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 5: {
                return this.getString(n, object);
            }
            case 3: {
                return this.getResourceLocator(n, object);
            }
            case 6: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationPOIOnlineServicesGoogleLocationCollector navigationPOIOnlineServicesGoogleLocationCollector = (NavigationPOIOnlineServicesGoogleLocationCollector)object;
        switch (n) {
            case 7: {
                return navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_is_navigateable;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationPOIOnlineServicesGoogleLocationCollector navigationPOIOnlineServicesGoogleLocationCollector = (NavigationPOIOnlineServicesGoogleLocationCollector)object;
        switch (n) {
            case 2: {
                return navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_direction;
            }
            case 4: {
                return navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_distance;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationPOIOnlineServicesGoogleLocationCollector navigationPOIOnlineServicesGoogleLocationCollector = (NavigationPOIOnlineServicesGoogleLocationCollector)object;
        switch (n) {
            case 0: {
                return navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_phonenumber;
            }
            case 1: {
                return navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_name;
            }
            case 5: {
                return navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_city;
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
        NavigationPOIOnlineServicesGoogleLocationCollector navigationPOIOnlineServicesGoogleLocationCollector = (NavigationPOIOnlineServicesGoogleLocationCollector)object;
        switch (n) {
            case 3: {
                return navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_icon;
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
        NavigationPOIOnlineServicesGoogleLocationCollector navigationPOIOnlineServicesGoogleLocationCollector = (NavigationPOIOnlineServicesGoogleLocationCollector)object;
        switch (n) {
            case 6: {
                return navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_address_details_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

