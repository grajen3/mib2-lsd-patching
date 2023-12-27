/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroup1Collector;
import org.dsi.ifc.global.ResourceLocator;

public final class TestmodeAMFMGroup1Transformer
extends ItemTransformerAdapter {
    public static final int TESTMODE_TUNER_FREQUENCY__TUNER0_STRING;
    public static final int TESTMODE_TUNER_PI__TUNER0_STRING;
    public static final int TESTMODE_TUNER_PS__TUNER0_STRING;
    public static final int TESTMODE_TUNER_SIGNAL_QUALITY__TUNER0_STRING;
    public static final int TESTMODE_TUNER_FS__TUNER0_STRING;
    public static final int TESTMODE_TUNER_RDQ__TUNER0_STRING;
    public static final int TESTMODE_TUNER_MP__TUNER0_STRING;
    public static final int TESTMODE_TUNER_AP__TUNER0_STRING;
    public static final int TESTMODE_TUNER_BAND__TUNER0_STRING;
    public static final int TESTMODE_TUNER_FREQUENCY__TUNER1_STRING;
    public static final int TESTMODE_TUNER_PI__TUNER1_STRING;
    public static final int TESTMODE_TUNER_PS__TUNER1_STRING;
    public static final int TESTMODE_TUNER_SIGNAL_QUALITY__TUNER1_STRING;
    public static final int TESTMODE_TUNER_FS__TUNER1_STRING;
    public static final int TESTMODE_TUNER_RDQ__TUNER1_STRING;
    public static final int TESTMODE_TUNER_MP__TUNER1_STRING;
    public static final int TESTMODE_TUNER_AP__TUNER1_STRING;
    public static final int TESTMODE_TUNER_BAND__TUNER1_STRING;
    public static final int TESTMODE_TUNER_FREQUENCY__TUNER2_STRING;
    public static final int TESTMODE_TUNER_PI__TUNER2_STRING;
    public static final int TESTMODE_TUNER_PS__TUNER2_STRING;
    public static final int TESTMODE_TUNER_SIGNAL_QUALITY__TUNER2_STRING;
    public static final int TESTMODE_TUNER_FS__TUNER2_STRING;
    public static final int TESTMODE_TUNER_RDQ__TUNER2_STRING;
    public static final int TESTMODE_TUNER_MP__TUNER2_STRING;
    public static final int TESTMODE_TUNER_AP__TUNER2_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[26];
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
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2276);
    }

    @Override
    public int getColumnCount() {
        return 26;
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
            case 25: {
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
            case 25: {
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
        TestmodeAMFMGroup1Collector testmodeAMFMGroup1Collector = (TestmodeAMFMGroup1Collector)object;
        switch (n) {
            case 0: {
                return testmodeAMFMGroup1Collector.testmode_tuner_frequency__tuner0;
            }
            case 1: {
                return testmodeAMFMGroup1Collector.testmode_tuner_pi__tuner0;
            }
            case 2: {
                return testmodeAMFMGroup1Collector.testmode_tuner_ps__tuner0;
            }
            case 3: {
                return testmodeAMFMGroup1Collector.testmode_tuner_signal_quality__tuner0;
            }
            case 4: {
                return testmodeAMFMGroup1Collector.testmode_tuner_fs__tuner0;
            }
            case 5: {
                return testmodeAMFMGroup1Collector.testmode_tuner_rdq__tuner0;
            }
            case 6: {
                return testmodeAMFMGroup1Collector.testmode_tuner_mp__tuner0;
            }
            case 7: {
                return testmodeAMFMGroup1Collector.testmode_tuner_ap__tuner0;
            }
            case 8: {
                return testmodeAMFMGroup1Collector.testmode_tuner_band__tuner0;
            }
            case 9: {
                return testmodeAMFMGroup1Collector.testmode_tuner_frequency__tuner1;
            }
            case 10: {
                return testmodeAMFMGroup1Collector.testmode_tuner_pi__tuner1;
            }
            case 11: {
                return testmodeAMFMGroup1Collector.testmode_tuner_ps__tuner1;
            }
            case 12: {
                return testmodeAMFMGroup1Collector.testmode_tuner_signal_quality__tuner1;
            }
            case 13: {
                return testmodeAMFMGroup1Collector.testmode_tuner_fs__tuner1;
            }
            case 14: {
                return testmodeAMFMGroup1Collector.testmode_tuner_rdq__tuner1;
            }
            case 15: {
                return testmodeAMFMGroup1Collector.testmode_tuner_mp__tuner1;
            }
            case 16: {
                return testmodeAMFMGroup1Collector.testmode_tuner_ap__tuner1;
            }
            case 17: {
                return testmodeAMFMGroup1Collector.testmode_tuner_band__tuner1;
            }
            case 18: {
                return testmodeAMFMGroup1Collector.testmode_tuner_frequency__tuner2;
            }
            case 19: {
                return testmodeAMFMGroup1Collector.testmode_tuner_pi__tuner2;
            }
            case 20: {
                return testmodeAMFMGroup1Collector.testmode_tuner_ps__tuner2;
            }
            case 21: {
                return testmodeAMFMGroup1Collector.testmode_tuner_signal_quality__tuner2;
            }
            case 22: {
                return testmodeAMFMGroup1Collector.testmode_tuner_fs__tuner2;
            }
            case 23: {
                return testmodeAMFMGroup1Collector.testmode_tuner_rdq__tuner2;
            }
            case 24: {
                return testmodeAMFMGroup1Collector.testmode_tuner_mp__tuner2;
            }
            case 25: {
                return testmodeAMFMGroup1Collector.testmode_tuner_ap__tuner2;
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

