/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.venm.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.vicsetc.venm.transformer.VICSETCVENMVenmDetailsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class VICSETCVENMVenmDetailsTransformer
extends ItemTransformerAdapter {
    public static final int VICSETC_VENM_TITLE_TEXT_STRING;
    public static final int VICSETC_VENM_INFO_TEXT_STRING;
    public static final int VICSETC_VENM_EVENT_ICON_RL_RESOURCE_LOCATOR;
    public static final int VICSETC_VENM_MESSAGE_RECEPTION_TIME_STRING;
    public static final int VICSETC_VENM_VENM_MESSAGE_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1419400448);
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
            case 3: {
                return this.getString(n, object);
            }
            case 2: {
                return this.getResourceLocator(n, object);
            }
            case 4: {
                return this.getFixFormatterFieldData(n, object);
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
        VICSETCVENMVenmDetailsCollector vICSETCVENMVenmDetailsCollector = (VICSETCVENMVenmDetailsCollector)object;
        switch (n) {
            case 0: {
                return vICSETCVENMVenmDetailsCollector.vicsetc_venm_title_text;
            }
            case 1: {
                return vICSETCVENMVenmDetailsCollector.vicsetc_venm_info_text;
            }
            case 3: {
                return vICSETCVENMVenmDetailsCollector.vicsetc_venm_message_reception_time;
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
        VICSETCVENMVenmDetailsCollector vICSETCVENMVenmDetailsCollector = (VICSETCVENMVenmDetailsCollector)object;
        switch (n) {
            case 2: {
                return vICSETCVENMVenmDetailsCollector.vicsetc_venm_event_icon_rl;
            }
        }
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
        VICSETCVENMVenmDetailsCollector vICSETCVENMVenmDetailsCollector = (VICSETCVENMVenmDetailsCollector)object;
        switch (n) {
            case 4: {
                return vICSETCVENMVenmDetailsCollector.vicsetc_venm_venm_message_details_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

