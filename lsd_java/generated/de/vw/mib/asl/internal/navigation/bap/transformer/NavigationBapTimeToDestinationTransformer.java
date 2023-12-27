/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.bap.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTimeToDestinationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationBapTimeToDestinationTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_BAP_TIME_TO_DESTINATION_TIME_INFO_INTEGER;
    public static final int NAVIGATION_BAP_TIME_TO_DESTINATION_VALIDITY_BOOLEAN;
    public static final int NAVIGATION_BAP_TIME_TO_DESTINATION_TIME_FORMAT_INTEGER;
    public static final int NAVIGATION_BAP_TIME_TO_DESTINATION_MINUTE_INTEGER;
    public static final int NAVIGATION_BAP_TIME_TO_DESTINATION_HOUR_INTEGER;
    public static final int NAVIGATION_BAP_TIME_TO_DESTINATION_DAY_INTEGER;
    public static final int NAVIGATION_BAP_TIME_TO_DESTINATION_MONTH_INTEGER;
    public static final int NAVIGATION_BAP_TIME_TO_DESTINATION_YEAR_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[8];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(750);
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
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return new Integer(this.getInt(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationBapTimeToDestinationCollector navigationBapTimeToDestinationCollector = (NavigationBapTimeToDestinationCollector)object;
        switch (n) {
            case 7: {
                return navigationBapTimeToDestinationCollector.navigation_bap_time_to_destination_validity;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationBapTimeToDestinationCollector navigationBapTimeToDestinationCollector = (NavigationBapTimeToDestinationCollector)object;
        switch (n) {
            case 0: {
                return navigationBapTimeToDestinationCollector.navigation_bap_time_to_destination_time_info;
            }
            case 1: {
                return navigationBapTimeToDestinationCollector.navigation_bap_time_to_destination_time_format;
            }
            case 2: {
                return navigationBapTimeToDestinationCollector.navigation_bap_time_to_destination_minute;
            }
            case 3: {
                return navigationBapTimeToDestinationCollector.navigation_bap_time_to_destination_hour;
            }
            case 4: {
                return navigationBapTimeToDestinationCollector.navigation_bap_time_to_destination_day;
            }
            case 5: {
                return navigationBapTimeToDestinationCollector.navigation_bap_time_to_destination_month;
            }
            case 6: {
                return navigationBapTimeToDestinationCollector.navigation_bap_time_to_destination_year;
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

