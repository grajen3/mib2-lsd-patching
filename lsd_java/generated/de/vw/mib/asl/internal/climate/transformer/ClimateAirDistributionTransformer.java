/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.climate.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class ClimateAirDistributionTransformer
extends ItemTransformerAdapter {
    public static final int CLIMATE_AIR_DISTRIBUTION_AUTO_BOOLEAN;
    public static final int CLIMATE_AIR_DISTRIBUTION_INFO_INTEGER;
    public static final int CLIMATE_AIR_DISTRIBUTION_WINDOW_LEFT_INTEGER;
    public static final int CLIMATE_AIR_DISTRIBUTION_BODY_FRONT_LEFT_INTEGER;
    public static final int CLIMATE_AIR_DISTRIBUTION_FOOTWELL_FRONT_LEFT_INTEGER;
    public static final int CLIMATE_AIR_DISTRIBUTION_WINDOW_RIGHT_INTEGER;
    public static final int CLIMATE_AIR_DISTRIBUTION_BODY_FRONT_RIGHT_INTEGER;
    public static final int CLIMATE_AIR_DISTRIBUTION_FOOTWELL_FRONT_RIGHT_INTEGER;
    public static final int CLIMATE_AIR_DISTRIBUTION_BODY_REAR_INTEGER;
    public static final int CLIMATE_AIR_DISTRIBUTION_FOOTWELL_REAR_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(327);
    }

    @Override
    public int getColumnCount() {
        return 10;
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
            case 9: {
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
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return new Integer(this.getInt(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        ClimateAirDistributionCollector climateAirDistributionCollector = (ClimateAirDistributionCollector)object;
        switch (n) {
            case 0: {
                return climateAirDistributionCollector.climate_air_distribution_auto;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        ClimateAirDistributionCollector climateAirDistributionCollector = (ClimateAirDistributionCollector)object;
        switch (n) {
            case 9: {
                return climateAirDistributionCollector.climate_air_distribution_info;
            }
            case 1: {
                return climateAirDistributionCollector.climate_air_distribution_window_left;
            }
            case 2: {
                return climateAirDistributionCollector.climate_air_distribution_body_front_left;
            }
            case 3: {
                return climateAirDistributionCollector.climate_air_distribution_footwell_front_left;
            }
            case 4: {
                return climateAirDistributionCollector.climate_air_distribution_window_right;
            }
            case 5: {
                return climateAirDistributionCollector.climate_air_distribution_body_front_right;
            }
            case 6: {
                return climateAirDistributionCollector.climate_air_distribution_footwell_front_right;
            }
            case 7: {
                return climateAirDistributionCollector.climate_air_distribution_body_rear;
            }
            case 8: {
                return climateAirDistributionCollector.climate_air_distribution_footwell_rear;
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

