/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.bap.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapRemainingTravelTimeCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationBapRemainingTravelTimeTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_BAP_REMAINING_TRAVEL_TIME_VALIDITY_BOOLEAN;
    public static final int NAVIGATION_BAP_REMAINING_TRAVEL_TIME_MINUTE_INTEGER;
    public static final int NAVIGATION_BAP_REMAINING_TRAVEL_TIME_HOUR_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[3];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(753930240);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: {
                return this.getBoolean(n, object);
            }
            case 1: 
            case 2: {
                return new Integer(this.getInt(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationBapRemainingTravelTimeCollector navigationBapRemainingTravelTimeCollector = (NavigationBapRemainingTravelTimeCollector)object;
        switch (n) {
            case 0: {
                return navigationBapRemainingTravelTimeCollector.navigation_bap_remaining_travel_time_validity;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationBapRemainingTravelTimeCollector navigationBapRemainingTravelTimeCollector = (NavigationBapRemainingTravelTimeCollector)object;
        switch (n) {
            case 1: {
                return navigationBapRemainingTravelTimeCollector.navigation_bap_remaining_travel_time_minute;
            }
            case 2: {
                return navigationBapRemainingTravelTimeCollector.navigation_bap_remaining_travel_time_hour;
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

