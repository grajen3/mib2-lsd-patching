/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.online.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlDowPacCurDow1310032Collector;
import org.dsi.ifc.global.ResourceLocator;

public final class OnlineOnlDowPacCurDow1310032Transformer
extends ItemTransformerAdapter {
    public static final int ONLINE_ONLINE_DOWNLOAD_PACKAGE_CURRENTLY_DOWNLOADING_NAME_STRING;
    public static final int ONLINE_ONLINE_DOWNLOAD_PACKAGE_CURRENTLY_DOWNLOADING_PROGRESS_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[2];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1358762752);
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
            case 1: {
                return new Integer(this.getInt(n, object));
            }
            case 0: {
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
        OnlineOnlDowPacCurDow1310032Collector onlineOnlDowPacCurDow1310032Collector = (OnlineOnlDowPacCurDow1310032Collector)object;
        switch (n) {
            case 1: {
                return onlineOnlDowPacCurDow1310032Collector.online_online_download_package_currently_downloading_progress;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        OnlineOnlDowPacCurDow1310032Collector onlineOnlDowPacCurDow1310032Collector = (OnlineOnlDowPacCurDow1310032Collector)object;
        switch (n) {
            case 0: {
                return onlineOnlDowPacCurDow1310032Collector.online_online_download_package_currently_downloading_name;
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

