/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceLaneGuidanceCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationGuidanceLaneGuidanceTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_GUIDANCE_LANE_GUIDANCE_DIRECTION_INTEGER_ARRAY;
    public static final int NAVIGATION_GUIDANCE_LANE_GUIDANCE_LANE_MARKING_LEFT_INTEGER_ARRAY;
    public static final int NAVIGATION_GUIDANCE_LANE_GUIDANCE_LANE_MARKING_RIGHT_INTEGER_ARRAY;
    public static final int NAVIGATION_GUIDANCE_LANE_GUIDANCE_INFO_INTEGER_ARRAY;
    public static final int NAVIGATION_GUIDANCE_LANE_GUIDANCE_IS_DATA_VALID_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntegerVectorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(829);
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
            case 4: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                return this.getIntegerVector(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationGuidanceLaneGuidanceCollector navigationGuidanceLaneGuidanceCollector = (NavigationGuidanceLaneGuidanceCollector)object;
        switch (n) {
            case 4: {
                return navigationGuidanceLaneGuidanceCollector.navigation_guidance_lane_guidance_is_data_valid;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean[] getFlagVector(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        NavigationGuidanceLaneGuidanceCollector navigationGuidanceLaneGuidanceCollector = (NavigationGuidanceLaneGuidanceCollector)object;
        switch (n) {
            case 0: {
                return navigationGuidanceLaneGuidanceCollector.navigation_guidance_lane_guidance_direction;
            }
            case 1: {
                return navigationGuidanceLaneGuidanceCollector.navigation_guidance_lane_guidance_lane_marking_left;
            }
            case 2: {
                return navigationGuidanceLaneGuidanceCollector.navigation_guidance_lane_guidance_lane_marking_right;
            }
            case 3: {
                return navigationGuidanceLaneGuidanceCollector.navigation_guidance_lane_guidance_info;
            }
        }
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
        throw new IllegalArgumentException();
    }
}

