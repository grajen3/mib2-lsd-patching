/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.tourmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourModeLocationPOIDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationTourModeTourModeLocationPOIDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_TOURMODE_TOUR_MODE_LOCATION_POI_DATA_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_TOURMODE_TOUR_MODE_LOCATION_POI_DATA_NAME_STRING;
    public static final int NAVIGATION_TOURMODE_TOUR_MODE_LOCATION_POI_DATA_CATEGORY_STRING;
    public static final int NAVIGATION_TOURMODE_TOUR_MODE_LOCATION_POI_DATA_PHONE_NUMBER_STRING;
    public static final int NAVIGATION_TOURMODE_TOUR_MODE_LOCATION_POI_DATA_URL_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1110016);
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
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
            case 4: {
                return this.getString(n, object);
            }
            case 0: {
                return this.getResourceLocator(n, object);
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
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationTourModeTourModeLocationPOIDataCollector navigationTourModeTourModeLocationPOIDataCollector = (NavigationTourModeTourModeLocationPOIDataCollector)object;
        switch (n) {
            case 1: {
                return navigationTourModeTourModeLocationPOIDataCollector.navigation_tourmode_tour_mode_location_poi_data_name;
            }
            case 2: {
                return navigationTourModeTourModeLocationPOIDataCollector.navigation_tourmode_tour_mode_location_poi_data_category;
            }
            case 3: {
                return navigationTourModeTourModeLocationPOIDataCollector.navigation_tourmode_tour_mode_location_poi_data_phone_number;
            }
            case 4: {
                return navigationTourModeTourModeLocationPOIDataCollector.navigation_tourmode_tour_mode_location_poi_data_url;
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
        NavigationTourModeTourModeLocationPOIDataCollector navigationTourModeTourModeLocationPOIDataCollector = (NavigationTourModeTourModeLocationPOIDataCollector)object;
        switch (n) {
            case 0: {
                return navigationTourModeTourModeLocationPOIDataCollector.navigation_tourmode_tour_mode_location_poi_data_icon;
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
        throw new IllegalArgumentException();
    }
}

