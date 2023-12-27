/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroup3Collector;
import org.dsi.ifc.global.ResourceLocator;

public final class TestmodeAMFMGroup3Transformer
extends ItemTransformerAdapter {
    public static final int TESTMODE_TUNER_DIV_STRING;
    public static final int TESTMODE_TUNER_CS_STRING;
    public static final int TESTMODE_TUNER_HC_STRING;
    public static final int TESTMODE_TUNER_AF_STRING;
    public static final int TESTMODE_TUNER_ANT_STRING;
    public static final int TESTMODE_TUNER_TARGET_PI_STRING;
    public static final int TESTMODE_TUNERSRC_PS_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2278);
    }

    @Override
    public int getColumnCount() {
        return 7;
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
            case 6: {
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
            case 6: {
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
        TestmodeAMFMGroup3Collector testmodeAMFMGroup3Collector = (TestmodeAMFMGroup3Collector)object;
        switch (n) {
            case 0: {
                return testmodeAMFMGroup3Collector.testmode_tuner_div;
            }
            case 1: {
                return testmodeAMFMGroup3Collector.testmode_tuner_cs;
            }
            case 2: {
                return testmodeAMFMGroup3Collector.testmode_tuner_hc;
            }
            case 3: {
                return testmodeAMFMGroup3Collector.testmode_tuner_af;
            }
            case 4: {
                return testmodeAMFMGroup3Collector.testmode_tuner_ant;
            }
            case 5: {
                return testmodeAMFMGroup3Collector.testmode_tuner_target_pi;
            }
            case 6: {
                return testmodeAMFMGroup3Collector.testmode_tunersrc_ps;
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

