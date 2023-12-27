/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceRouteListDetailsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationGuidanceRouteListDetailsTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_MN_ID_INTEGER;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_MN_FROM_STRING;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_MN_TO_STRING;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_MN_DTM_INTEGER;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_MN_ETAD_INTEGER;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_MN_ETAH_INTEGER;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_MN_ETAM_INTEGER;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_ICON_ID_INTEGER;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_NAME_STRING;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAIL_SELECTED_ITEM_TYPE_INTEGER;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_SOUTH_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_LABELED_SOUTH_ICON_LABELED_ICON;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAIL_TIME_TO_MANEUVRE_HOURS_INTEGER;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAIL_TIME_TO_MANEUVRE_MINUTES_INTEGER;
    public static final int NAVIGATION_GUIDANCE_ROUTE_LIST_DETAILS_DESCRIPTION_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[15];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedResourceLocatorAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedLabeledIconValueAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 14, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(831);
    }

    @Override
    public int getColumnCount() {
        return 15;
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
            case 14: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 9: 
            case 12: 
            case 13: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: 
            case 8: 
            case 14: {
                return this.getString(n, object);
            }
            case 10: {
                return this.getResourceLocator(n, object);
            }
            case 11: {
                return this.getLabeledIconValue(n, object);
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
        NavigationGuidanceRouteListDetailsCollector navigationGuidanceRouteListDetailsCollector = (NavigationGuidanceRouteListDetailsCollector)object;
        switch (n) {
            case 0: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_mn_id;
            }
            case 3: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_mn_dtm;
            }
            case 4: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_mn_etad;
            }
            case 5: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_mn_etah;
            }
            case 6: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_mn_etam;
            }
            case 7: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_icon_id;
            }
            case 9: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_detail_selected_item_type;
            }
            case 12: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_detail_time_to_maneuvre_hours;
            }
            case 13: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_detail_time_to_maneuvre_minutes;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationGuidanceRouteListDetailsCollector navigationGuidanceRouteListDetailsCollector = (NavigationGuidanceRouteListDetailsCollector)object;
        switch (n) {
            case 1: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_mn_from;
            }
            case 2: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_mn_to;
            }
            case 8: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_name;
            }
            case 14: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_description;
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
        NavigationGuidanceRouteListDetailsCollector navigationGuidanceRouteListDetailsCollector = (NavigationGuidanceRouteListDetailsCollector)object;
        switch (n) {
            case 10: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_south_icon;
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
        NavigationGuidanceRouteListDetailsCollector navigationGuidanceRouteListDetailsCollector = (NavigationGuidanceRouteListDetailsCollector)object;
        switch (n) {
            case 11: {
                return navigationGuidanceRouteListDetailsCollector.navigation_guidance_route_list_details_labeled_south_icon;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

