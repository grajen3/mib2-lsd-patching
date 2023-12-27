/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceSavedGuidanceInfoDetailCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationGuidanceSavedGuidanceInfoDetailTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_CITY_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_ZIP_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_STREET_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_HN_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_CROSSING_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_FINAL_DEST_CITY_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_FINAL_DEST_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_FINAL_DEST_ZIP_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_FINAL_DEST_STREET_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_FINAL_DEST_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_FINAL_DEST_HN_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_FINAL_DEST_CROSSING_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_FINAL_DEST_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_GUIDANCE_SAVED_GUIDANCE_INFO_DETAIL_FINAL_DEST_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[18];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 17, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(828);
    }

    @Override
    public int getColumnCount() {
        return 18;
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
            case 16: 
            case 17: {
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
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return this.getString(n, object);
            }
            case 16: 
            case 17: {
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
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationGuidanceSavedGuidanceInfoDetailCollector navigationGuidanceSavedGuidanceInfoDetailCollector = (NavigationGuidanceSavedGuidanceInfoDetailCollector)object;
        switch (n) {
            case 0: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_city;
            }
            case 1: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_city_refinement;
            }
            case 2: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_zip;
            }
            case 3: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_street;
            }
            case 4: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_street_refinement;
            }
            case 5: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_hn;
            }
            case 6: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_crossing;
            }
            case 7: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_country_code;
            }
            case 8: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_city;
            }
            case 9: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_city_refinement;
            }
            case 10: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_zip;
            }
            case 11: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_street;
            }
            case 12: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_street_refinement;
            }
            case 13: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_hn;
            }
            case 14: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_crossing;
            }
            case 15: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_country_code;
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
        NavigationGuidanceSavedGuidanceInfoDetailCollector navigationGuidanceSavedGuidanceInfoDetailCollector = (NavigationGuidanceSavedGuidanceInfoDetailCollector)object;
        switch (n) {
            case 16: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_for_fix_formatter;
            }
            case 17: {
                return navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

