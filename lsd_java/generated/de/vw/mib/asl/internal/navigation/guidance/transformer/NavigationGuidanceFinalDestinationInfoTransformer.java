/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceFinalDestinationInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationGuidanceFinalDestinationInfoTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_GUIDANCE_FINAL_DESTINATION_INFO_CITY_STRING;
    public static final int NAVIGATION_GUIDANCE_FINAL_DESTINATION_INFO_STREET_STRING;
    public static final int NAVIGATION_GUIDANCE_FINAL_DESTINATION_INFO_HN_STRING;
    public static final int NAVIGATION_GUIDANCE_FINAL_DESTINATION_INFO_ETAD_INTEGER;
    public static final int NAVIGATION_GUIDANCE_FINAL_DESTINATION_INFO_ETAH_INTEGER;
    public static final int NAVIGATION_GUIDANCE_FINAL_DESTINATION_INFO_ETAM_INTEGER;
    public static final int NAVIGATION_GUIDANCE_FINAL_DESTINATION_INFO_NAME_STRING;
    public static final int NAVIGATION_GUIDANCE_FINAL_DESTINATION_INFO_ADDRESS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[8];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-101773312);
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
            case 1: 
            case 2: 
            case 3: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 4: 
            case 6: 
            case 7: {
                return this.getString(n, object);
            }
            case 5: {
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
        NavigationGuidanceFinalDestinationInfoCollector navigationGuidanceFinalDestinationInfoCollector = (NavigationGuidanceFinalDestinationInfoCollector)object;
        switch (n) {
            case 1: {
                return navigationGuidanceFinalDestinationInfoCollector.navigation_guidance_final_destination_info_etad;
            }
            case 2: {
                return navigationGuidanceFinalDestinationInfoCollector.navigation_guidance_final_destination_info_etah;
            }
            case 3: {
                return navigationGuidanceFinalDestinationInfoCollector.navigation_guidance_final_destination_info_etam;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationGuidanceFinalDestinationInfoCollector navigationGuidanceFinalDestinationInfoCollector = (NavigationGuidanceFinalDestinationInfoCollector)object;
        switch (n) {
            case 0: {
                return navigationGuidanceFinalDestinationInfoCollector.navigation_guidance_final_destination_info_city;
            }
            case 6: {
                return navigationGuidanceFinalDestinationInfoCollector.navigation_guidance_final_destination_info_street;
            }
            case 7: {
                return navigationGuidanceFinalDestinationInfoCollector.navigation_guidance_final_destination_info_hn;
            }
            case 4: {
                return navigationGuidanceFinalDestinationInfoCollector.navigation_guidance_final_destination_info_name;
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
        NavigationGuidanceFinalDestinationInfoCollector navigationGuidanceFinalDestinationInfoCollector = (NavigationGuidanceFinalDestinationInfoCollector)object;
        switch (n) {
            case 5: {
                return navigationGuidanceFinalDestinationInfoCollector.navigation_guidance_final_destination_info_address_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

