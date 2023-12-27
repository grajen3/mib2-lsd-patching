/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceCalculationProgressesCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationGuidanceCalculationProgressesTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_GUIDANCE_CALCULATION_PROGRESS_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATION_PROGRESS_ALTERNATE_ROUTE1_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATION_PROGRESS_ALTERNATE_ROUTE2_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATION_PROGRESS_ALTERNATE_ROUTE3_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CALCULATION_PROGRESS_ALTERNATE_ROUTE4_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(823);
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
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return new Integer(this.getInt(n, object));
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
        NavigationGuidanceCalculationProgressesCollector navigationGuidanceCalculationProgressesCollector = (NavigationGuidanceCalculationProgressesCollector)object;
        switch (n) {
            case 0: {
                return navigationGuidanceCalculationProgressesCollector.navigation_guidance_calculation_progress;
            }
            case 1: {
                return navigationGuidanceCalculationProgressesCollector.navigation_guidance_calculation_progress_alternate_route1;
            }
            case 2: {
                return navigationGuidanceCalculationProgressesCollector.navigation_guidance_calculation_progress_alternate_route2;
            }
            case 3: {
                return navigationGuidanceCalculationProgressesCollector.navigation_guidance_calculation_progress_alternate_route3;
            }
            case 4: {
                return navigationGuidanceCalculationProgressesCollector.navigation_guidance_calculation_progress_alternate_route4;
            }
        }
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

