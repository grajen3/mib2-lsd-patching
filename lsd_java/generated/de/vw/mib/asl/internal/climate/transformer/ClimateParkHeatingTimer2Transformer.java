/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.climate.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer2Collector;
import org.dsi.ifc.global.ResourceLocator;

public final class ClimateParkHeatingTimer2Transformer
extends ItemTransformerAdapter {
    public static final int CLIMATE_PARK_HEATING_TIMER2SET_BOOLEAN;
    public static final int CLIMATE_PARK_HEATING_TIMER2DAY_INTEGER;
    public static final int CLIMATE_PARK_HEATING_TIMER2HOUR_INTEGER;
    public static final int CLIMATE_PARK_HEATING_TIMER2MINUTE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[4];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(329);
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
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
            case 2: 
            case 3: {
                return new Integer(this.getInt(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        ClimateParkHeatingTimer2Collector climateParkHeatingTimer2Collector = (ClimateParkHeatingTimer2Collector)object;
        switch (n) {
            case 0: {
                return climateParkHeatingTimer2Collector.climate_park_heating_timer2set;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        ClimateParkHeatingTimer2Collector climateParkHeatingTimer2Collector = (ClimateParkHeatingTimer2Collector)object;
        switch (n) {
            case 1: {
                return climateParkHeatingTimer2Collector.climate_park_heating_timer2day;
            }
            case 2: {
                return climateParkHeatingTimer2Collector.climate_park_heating_timer2hour;
            }
            case 3: {
                return climateParkHeatingTimer2Collector.climate_park_heating_timer2minute;
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

