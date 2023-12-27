/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.bap.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractRadioBapReceptionListAmTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_BAP_RECEPTION_LIST_AM_UNIQUE_ID_LONG;
    public static final int RADIO_BAP_RECEPTION_LIST_AM_TYPE_INTEGER;
    public static final int RADIO_BAP_RECEPTION_LIST_AM_ATTRIBUTES_INTEGER;
    public static final int RADIO_BAP_RECEPTION_LIST_AM_PRESET_ID_INTEGER;
    public static final int RADIO_BAP_RECEPTION_LIST_AM_FM_REG_CODE_INTEGER;
    public static final int RADIO_BAP_RECEPTION_LIST_AM_CATEGORY_INTEGER;
    public static final int RADIO_BAP_RECEPTION_LIST_AM_NAME_STRING;
    public static final int RADIO_BAP_RECEPTION_LIST_AM_SHORT_NAME_STRING;
    public static final int RADIO_BAP_RECEPTION_LIST_AM_FREQUENCY_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[9];
        int n = 0;
        stringArray[n++] = TransformerUtil.getLongAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3900);
    }

    @Override
    public int getColumnCount() {
        return 9;
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
            case 8: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 8: {
                return new Integer(this.getInt(n, object));
            }
            case 6: 
            case 7: {
                return this.getString(n, object);
            }
            case 0: {
                return new Long(this.getLong(n, object));
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
    public ResourceLocator getResourceLocator(int n, Object object) {
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

