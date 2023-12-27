/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.pnav.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavLikelyDestinationsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationPnavLikelyDestinationsTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_PNAV_CALCULATION_STATE_INTEGER;
    public static final int NAVIGATION_PNAV_CALCULATION_PROGRESS_INTEGER;
    public static final int NAVIGATION_PNAV_LIKELIHOOD_INTEGER;
    public static final int NAVIGATION_PNAV_DTD_INTEGER;
    public static final int NAVIGATION_PNAV_RTT_INTEGER;
    public static final int NAVIGATION_PNAV_TIME_DELAY_INTEGER;
    public static final int NAVIGATION_PNAV_ROUTE_COLOR_INTEGER;
    public static final int NAVIGATION_PNAV_ROUTE_COLOR_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_PNAV_STREET_STRING;
    public static final int NAVIGATION_PNAV_HOUSENUMBER_STRING;
    public static final int NAVIGATION_PNAV_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_PNAV_CITY_STRING;
    public static final int NAVIGATION_PNAV_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_PNAV_CROSS_STREET_STRING;
    public static final int NAVIGATION_PNAV_LATITUDE_INTEGER;
    public static final int NAVIGATION_PNAV_LONGITUDE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[16];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedResourceLocatorAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 15, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2012221440);
    }

    @Override
    public int getColumnCount() {
        return 16;
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
            case 15: {
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
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationPnavLikelyDestinationsCollector navigationPnavLikelyDestinationsCollector = (NavigationPnavLikelyDestinationsCollector)object;
        switch (n) {
            case 0: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_calculation_state;
            }
            case 1: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_calculation_progress;
            }
            case 2: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_likelihood;
            }
            case 3: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_dtd;
            }
            case 4: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_rtt;
            }
            case 5: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_time_delay;
            }
            case 6: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_route_color;
            }
            case 14: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_latitude;
            }
            case 15: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_longitude;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationPnavLikelyDestinationsCollector navigationPnavLikelyDestinationsCollector = (NavigationPnavLikelyDestinationsCollector)object;
        switch (n) {
            case 8: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_street;
            }
            case 9: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_housenumber;
            }
            case 10: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_street_refinement;
            }
            case 11: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_city;
            }
            case 12: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_city_refinement;
            }
            case 13: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_cross_street;
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
        NavigationPnavLikelyDestinationsCollector navigationPnavLikelyDestinationsCollector = (NavigationPnavLikelyDestinationsCollector)object;
        switch (n) {
            case 7: {
                return navigationPnavLikelyDestinationsCollector.navigation_pnav_route_color_icon;
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

