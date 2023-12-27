/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSoundsettingsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TestmodeSoundsettingsTransformer
extends ItemTransformerAdapter {
    public static final int TESTMODE_MID_STRING;
    public static final int TESTMODE_TREBBLE_STRING;
    public static final int TESTMODE_AUDIO_GALA_GAIN_STRING;
    public static final int TESTMODE_AUDIO_GDAK_GAIN_STRING;
    public static final int TESTMODE_AUDIO_VNC_GAIN_STRING;
    public static final int TESTMODE_FADER_STRING;
    public static final int TESTMODE_BALANCE_STRING;
    public static final int TESTMODE_BASS_STRING;
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
        return ASLListColumns.getColumnsForASLList(2283);
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
        TestmodeSoundsettingsCollector testmodeSoundsettingsCollector = (TestmodeSoundsettingsCollector)object;
        switch (n) {
            case 0: {
                return testmodeSoundsettingsCollector.testmode_mid;
            }
            case 1: {
                return testmodeSoundsettingsCollector.testmode_trebble;
            }
            case 2: {
                return testmodeSoundsettingsCollector.testmode_audio_gala_gain;
            }
            case 3: {
                return testmodeSoundsettingsCollector.testmode_audio_gdak_gain;
            }
            case 4: {
                return testmodeSoundsettingsCollector.testmode_audio_vnc_gain;
            }
            case 5: {
                return testmodeSoundsettingsCollector.testmode_fader;
            }
            case 6: {
                return testmodeSoundsettingsCollector.testmode_balance;
            }
            case 7: {
                return testmodeSoundsettingsCollector.testmode_bass;
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

