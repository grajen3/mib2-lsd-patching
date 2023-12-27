/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSChannelVectorCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TestmodeSDARSChannelVectorTransformer
extends ItemTransformerAdapter {
    public static final int TESTMODE_SDARS_CHANNEL_VECTOR__ROW0_STRING;
    public static final int TESTMODE_SDARS_CHANNEL_VECTOR__ROW1_STRING;
    public static final int TESTMODE_SDARS_CHANNEL_VECTOR__ROW2_STRING;
    public static final int TESTMODE_SDARS_CHANNEL_VECTOR__ROW3_STRING;
    public static final int TESTMODE_SDARS_CHANNEL_VECTOR__ROW4_STRING;
    public static final int TESTMODE_SDARS_CHANNEL_VECTOR__ROW5_STRING;
    public static final int TESTMODE_SDARS_CHANNEL_VECTOR__ROW6_STRING;
    public static final int TESTMODE_SDARS_CHANNEL_VECTOR__ROW7_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[8];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2251);
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
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                return this.getString(n, object);
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
        TestmodeSDARSChannelVectorCollector testmodeSDARSChannelVectorCollector = (TestmodeSDARSChannelVectorCollector)object;
        switch (n) {
            case 0: {
                return testmodeSDARSChannelVectorCollector.testmode_sdars_channel_vector__row0;
            }
            case 1: {
                return testmodeSDARSChannelVectorCollector.testmode_sdars_channel_vector__row1;
            }
            case 2: {
                return testmodeSDARSChannelVectorCollector.testmode_sdars_channel_vector__row2;
            }
            case 3: {
                return testmodeSDARSChannelVectorCollector.testmode_sdars_channel_vector__row3;
            }
            case 4: {
                return testmodeSDARSChannelVectorCollector.testmode_sdars_channel_vector__row4;
            }
            case 5: {
                return testmodeSDARSChannelVectorCollector.testmode_sdars_channel_vector__row5;
            }
            case 6: {
                return testmodeSDARSChannelVectorCollector.testmode_sdars_channel_vector__row6;
            }
            case 7: {
                return testmodeSDARSChannelVectorCollector.testmode_sdars_channel_vector__row7;
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
        throw new IllegalArgumentException();
    }
}

