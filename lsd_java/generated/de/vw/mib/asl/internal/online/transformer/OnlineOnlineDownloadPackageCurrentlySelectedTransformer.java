/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.online.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineDownloadPackageCurrentlySelectedCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class OnlineOnlineDownloadPackageCurrentlySelectedTransformer
extends ItemTransformerAdapter {
    public static final int ONLINE_ONLINE_DOWNLOAD_PACKAGE_CURRENTLY_SELECTED_AMOUNT_INTEGER;
    public static final int ONLINE_ONLINE_DOWNLOAD_PACKAGE_CURRENTLY_SELECTED_SIZE_LONG;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[2];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 1, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1375539968);
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
            case 0: {
                return new Integer(this.getInt(n, object));
            }
            case 1: {
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
    public int getInt(int n, Object object) {
        OnlineOnlineDownloadPackageCurrentlySelectedCollector onlineOnlineDownloadPackageCurrentlySelectedCollector = (OnlineOnlineDownloadPackageCurrentlySelectedCollector)object;
        switch (n) {
            case 0: {
                return onlineOnlineDownloadPackageCurrentlySelectedCollector.online_online_download_package_currently_selected_amount;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
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
        OnlineOnlineDownloadPackageCurrentlySelectedCollector onlineOnlineDownloadPackageCurrentlySelectedCollector = (OnlineOnlineDownloadPackageCurrentlySelectedCollector)object;
        switch (n) {
            case 1: {
                return onlineOnlineDownloadPackageCurrentlySelectedCollector.online_online_download_package_currently_selected_size;
            }
        }
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
