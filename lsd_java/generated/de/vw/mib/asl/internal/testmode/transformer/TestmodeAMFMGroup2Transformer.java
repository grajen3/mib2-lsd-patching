/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroup2Collector;
import org.dsi.ifc.global.ResourceLocator;

public final class TestmodeAMFMGroup2Transformer
extends ItemTransformerAdapter {
    public static final int TESTMODE_TUNER_NK__TUNER0_STRING;
    public static final int TESTMODE_TUNER_CO__TUNER0_STRING;
    public static final int TESTMODE_TUNER_DV__TUNER0_STRING;
    public static final int TESTMODE_TUNER_RDV__TUNER0_STRING;
    public static final int TESTMODE_TUNER_PTD__TUNER0_STRING;
    public static final int TESTMODE_TUNER_IFD__TUNER0_STRING;
    public static final int TESTMODE_TUNER_IB__TUNER0_STRING;
    public static final int TESTMODE_TUNER_AGCV__TUNER0_STRING;
    public static final int TESTMODE_TUNER_TP__TUNER0_STRING;
    public static final int TESTMODE_TUNER_TA__TUNER0_STRING;
    public static final int TESTMODE_TUNER_TMC__TUNER0_STRING;
    public static final int TESTMODE_TUNER_OIF__TUNER0_STRING;
    public static final int TESTMODE_TUNER_NK__TUNER1_STRING;
    public static final int TESTMODE_TUNER_CO__TUNER1_STRING;
    public static final int TESTMODE_TUNER_DV__TUNER1_STRING;
    public static final int TESTMODE_TUNER_RDV__TUNER1_STRING;
    public static final int TESTMODE_TUNER_PTD__TUNER1_STRING;
    public static final int TESTMODE_TUNER_IFD__TUNER1_STRING;
    public static final int TESTMODE_TUNER_IB__TUNER1_STRING;
    public static final int TESTMODE_TUNER_AGC__TUNER1_STRING;
    public static final int TESTMODE_TUNER_TP__TUNER1_STRING;
    public static final int TESTMODE_TUNER_TA__TUNER1_STRING;
    public static final int TESTMODE_TUNER_TMC__TUNER1_STRING;
    public static final int TESTMODE_TUNER_OIF__TUNER1_STRING;
    public static final int TESTMODE_TUNER_NK__TUNER2_STRING;
    public static final int TESTMODE_TUNER_CO__TUNER2_STRING;
    public static final int TESTMODE_TUNER_RDV__TUNER2_STRING;
    public static final int TESTMODE_TUNER_IB__TUNER2_STRING;
    public static final int TESTMODE_TUNER_TP__TUNER2_STRING;
    public static final int TESTMODE_TUNER_TA__TUNER2_STRING;
    public static final int TESTMODE_TUNER_TMC__TUNER2_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[31];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 25, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 26, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 27, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 28, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 29, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 30, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2277);
    }

    @Override
    public int getColumnCount() {
        return 31;
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
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: {
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
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: {
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
        TestmodeAMFMGroup2Collector testmodeAMFMGroup2Collector = (TestmodeAMFMGroup2Collector)object;
        switch (n) {
            case 0: {
                return testmodeAMFMGroup2Collector.testmode_tuner_nk__tuner0;
            }
            case 1: {
                return testmodeAMFMGroup2Collector.testmode_tuner_co__tuner0;
            }
            case 2: {
                return testmodeAMFMGroup2Collector.testmode_tuner_dv__tuner0;
            }
            case 3: {
                return testmodeAMFMGroup2Collector.testmode_tuner_rdv__tuner0;
            }
            case 4: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ptd__tuner0;
            }
            case 5: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ifd__tuner0;
            }
            case 6: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ib__tuner0;
            }
            case 7: {
                return testmodeAMFMGroup2Collector.testmode_tuner_agcv__tuner0;
            }
            case 8: {
                return testmodeAMFMGroup2Collector.testmode_tuner_tp__tuner0;
            }
            case 9: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ta__tuner0;
            }
            case 10: {
                return testmodeAMFMGroup2Collector.testmode_tuner_tmc__tuner0;
            }
            case 11: {
                return testmodeAMFMGroup2Collector.testmode_tuner_oif__tuner0;
            }
            case 12: {
                return testmodeAMFMGroup2Collector.testmode_tuner_nk__tuner1;
            }
            case 13: {
                return testmodeAMFMGroup2Collector.testmode_tuner_co__tuner1;
            }
            case 14: {
                return testmodeAMFMGroup2Collector.testmode_tuner_dv__tuner1;
            }
            case 15: {
                return testmodeAMFMGroup2Collector.testmode_tuner_rdv__tuner1;
            }
            case 16: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ptd__tuner1;
            }
            case 17: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ifd__tuner1;
            }
            case 18: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ib__tuner1;
            }
            case 19: {
                return testmodeAMFMGroup2Collector.testmode_tuner_agc__tuner1;
            }
            case 20: {
                return testmodeAMFMGroup2Collector.testmode_tuner_tp__tuner1;
            }
            case 21: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ta__tuner1;
            }
            case 22: {
                return testmodeAMFMGroup2Collector.testmode_tuner_tmc__tuner1;
            }
            case 23: {
                return testmodeAMFMGroup2Collector.testmode_tuner_oif__tuner1;
            }
            case 24: {
                return testmodeAMFMGroup2Collector.testmode_tuner_nk__tuner2;
            }
            case 25: {
                return testmodeAMFMGroup2Collector.testmode_tuner_co__tuner2;
            }
            case 26: {
                return testmodeAMFMGroup2Collector.testmode_tuner_rdv__tuner2;
            }
            case 27: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ib__tuner2;
            }
            case 28: {
                return testmodeAMFMGroup2Collector.testmode_tuner_tp__tuner2;
            }
            case 29: {
                return testmodeAMFMGroup2Collector.testmode_tuner_ta__tuner2;
            }
            case 30: {
                return testmodeAMFMGroup2Collector.testmode_tuner_tmc__tuner2;
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

