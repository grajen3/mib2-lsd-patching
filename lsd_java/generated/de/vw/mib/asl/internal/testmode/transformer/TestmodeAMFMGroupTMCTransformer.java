/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroupTMCCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TestmodeAMFMGroupTMCTransformer
extends ItemTransformerAdapter {
    public static final int TESTMODE_TMC_STATION_COUNTRY_CODE_STRING;
    public static final int TESTMODE_TMC_STATION_SID_STRING;
    public static final int TESTMODE_TMC_STATION_SPN_STRING;
    public static final int TESTMODE_TMC_STATION_LTN_STRING;
    public static final int TESTMODE_TMC_STATION_MGS_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2279);
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
        TestmodeAMFMGroupTMCCollector testmodeAMFMGroupTMCCollector = (TestmodeAMFMGroupTMCCollector)object;
        switch (n) {
            case 0: {
                return testmodeAMFMGroupTMCCollector.testmode_tmc_station_country_code;
            }
            case 1: {
                return testmodeAMFMGroupTMCCollector.testmode_tmc_station_sid;
            }
            case 2: {
                return testmodeAMFMGroupTMCCollector.testmode_tmc_station_spn;
            }
            case 3: {
                return testmodeAMFMGroupTMCCollector.testmode_tmc_station_ltn;
            }
            case 4: {
                return testmodeAMFMGroupTMCCollector.testmode_tmc_station_mgs;
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

