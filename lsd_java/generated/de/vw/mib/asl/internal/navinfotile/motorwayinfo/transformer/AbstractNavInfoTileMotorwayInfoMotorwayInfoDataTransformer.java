/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile.motorwayinfo.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractNavInfoTileMotorwayInfoMotorwayInfoDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_EXIT_ICON_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_EXIT_NUMBER_STRING;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_EXIT_NAME_STRING;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON1_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON2_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON3_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON4_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON5_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_POI_ICON6_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_DISTANCE_INTEGER;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_RTTH_INTEGER;
    public static final int NAVINFOTILE_MOTORWAYINFO_MOTORWAY_INFO_DATA_RTTM_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(388913664);
    }

    @Override
    public int getColumnCount() {
        return 12;
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
            case 11: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 9: 
            case 10: 
            case 11: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: {
                return this.getString(n, object);
            }
            case 0: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
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

