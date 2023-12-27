/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.mirrorlink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkAppNotificationPopupInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class MirrorlinkAppNotificationPopupInfoTransformer
extends ItemTransformerAdapter {
    public static final int MIRRORLINK_HEADERTEXT_STRING;
    public static final int MIRRORLINK_INFO_TEXT_STRING;
    public static final int MIRRORLINK_AVAILABLE_ACTION1_BOOLEAN;
    public static final int MIRRORLINK_TEXT_ACTION1_STRING;
    public static final int MIRRORLINK_AVAILABLE_ACTION2_BOOLEAN;
    public static final int MIRRORLINK_TEXT_ACTION2_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1550388992);
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
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
            case 5: 
            case 7: {
                return this.getBoolean(n, object);
            }
            case 3: 
            case 4: 
            case 6: 
            case 8: {
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        MirrorlinkAppNotificationPopupInfoCollector mirrorlinkAppNotificationPopupInfoCollector = (MirrorlinkAppNotificationPopupInfoCollector)object;
        switch (n) {
            case 5: {
                return mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_available_action1;
            }
            case 7: {
                return mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_available_action2;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        MirrorlinkAppNotificationPopupInfoCollector mirrorlinkAppNotificationPopupInfoCollector = (MirrorlinkAppNotificationPopupInfoCollector)object;
        switch (n) {
            case 3: {
                return mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_headertext;
            }
            case 4: {
                return mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_info_text;
            }
            case 6: {
                return mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_text_action1;
            }
            case 8: {
                return mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_text_action2;
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

