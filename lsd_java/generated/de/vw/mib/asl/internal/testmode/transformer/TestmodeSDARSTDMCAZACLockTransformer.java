/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMCAZACLockCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TestmodeSDARSTDMCAZACLockTransformer
extends ItemTransformerAdapter {
    public static final int TESTMODE_SDARSTDMCAZAC_LOCK__S1_STRING;
    public static final int TESTMODE_SDARSTDMCAZAC_LOCK__S2_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[2];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2255);
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: 
            case 1: {
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
        TestmodeSDARSTDMCAZACLockCollector testmodeSDARSTDMCAZACLockCollector = (TestmodeSDARSTDMCAZACLockCollector)object;
        switch (n) {
            case 0: {
                return testmodeSDARSTDMCAZACLockCollector.testmode_sdarstdmcazac_lock__s1;
            }
            case 1: {
                return testmodeSDARSTDMCAZACLockCollector.testmode_sdarstdmcazac_lock__s2;
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

