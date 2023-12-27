/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.usl.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.radio.usl.transformer.RadioUSLCurrentStationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class RadioUSLCurrentStationTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_USL_CURRENT_STATION__NAME_STRING;
    public static final int RADIO_USL_CURRENT_STATION__SHORT_NAME_STRING;
    public static final int RADIO_USL_CURRENT_STATION__SOURCE_INTEGER;
    public static final int RADIO_USL_CURRENT_STATION__FREQUENCY_LONG;
    public static final int RADIO_USL_CURRENT_STATION__IS_NAME_EQUAL_TO_FREQUENCY_BOOLEAN;
    public static final int RADIO_USL_CURRENT_STATION__IS_FM_STATION_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1288053760);
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 4: 
            case 5: {
                return this.getBoolean(n, object);
            }
            case 2: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: {
                return this.getString(n, object);
            }
            case 3: {
                return new Long(this.getLong(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        RadioUSLCurrentStationCollector radioUSLCurrentStationCollector = (RadioUSLCurrentStationCollector)object;
        switch (n) {
            case 4: {
                return radioUSLCurrentStationCollector.radio_usl_current_station__is_name_equal_to_frequency;
            }
            case 5: {
                return radioUSLCurrentStationCollector.radio_usl_current_station__is_fm_station;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        RadioUSLCurrentStationCollector radioUSLCurrentStationCollector = (RadioUSLCurrentStationCollector)object;
        switch (n) {
            case 2: {
                return radioUSLCurrentStationCollector.radio_usl_current_station__source;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        RadioUSLCurrentStationCollector radioUSLCurrentStationCollector = (RadioUSLCurrentStationCollector)object;
        switch (n) {
            case 0: {
                return radioUSLCurrentStationCollector.radio_usl_current_station__name;
            }
            case 1: {
                return radioUSLCurrentStationCollector.radio_usl_current_station__short_name;
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
        RadioUSLCurrentStationCollector radioUSLCurrentStationCollector = (RadioUSLCurrentStationCollector)object;
        switch (n) {
            case 3: {
                return radioUSLCurrentStationCollector.radio_usl_current_station__frequency;
            }
        }
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

