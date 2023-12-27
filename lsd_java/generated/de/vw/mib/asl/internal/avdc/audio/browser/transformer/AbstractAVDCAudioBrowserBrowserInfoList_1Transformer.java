/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractAVDCAudioBrowserBrowserInfoList_1Transformer
extends ItemTransformerAdapter {
    public static final int AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST__IS_ACTIVE_BOOLEAN;
    public static final int AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST__IS_ENABLED_BOOLEAN;
    public static final int AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST__IS_REPEAT_ACTIVE_BOOLEAN;
    public static final int AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST__NAME_STRING;
    public static final int AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST__SELECTION_STATE_INTEGER;
    public static final int AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST__SHOW_ERROR_TEXT_BOOLEAN;
    public static final int AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST__STATE_INTEGER;
    public static final int AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST__TRACKNUMBER_INTEGER;
    public static final int AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST__TYPE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[9];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3649);
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
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: {
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
            case 5: {
                return this.getBoolean(n, object);
            }
            case 4: 
            case 6: 
            case 8: 
            case 10: {
                return new Integer(this.getInt(n, object));
            }
            case 9: {
                return this.getString(n, object);
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

