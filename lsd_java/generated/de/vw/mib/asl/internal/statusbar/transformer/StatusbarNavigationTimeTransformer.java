/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.statusbar.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarNavigationTimeCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class StatusbarNavigationTimeTransformer
extends ItemTransformerAdapter {
    public static final int STATUSBAR_NAVIGATION_TIME_MODE_INTEGER;
    public static final int STATUSBAR_NAVIGATION_TIME_ETAD_INTEGER;
    public static final int STATUSBAR_NAVIGATION_TIME_ETAH_INTEGER;
    public static final int STATUSBAR_NAVIGATION_TIME_ETAM_INTEGER;
    public static final int STATUSBAR_NAVIGATION_TIME_RTTH_INTEGER;
    public static final int STATUSBAR_NAVIGATION_TIME_RTTM_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-168276736);
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
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
            case 5: {
                return new Integer(this.getInt(n, object));
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
        StatusbarNavigationTimeCollector statusbarNavigationTimeCollector = (StatusbarNavigationTimeCollector)object;
        switch (n) {
            case 0: {
                return statusbarNavigationTimeCollector.statusbar_navigation_time_mode;
            }
            case 1: {
                return statusbarNavigationTimeCollector.statusbar_navigation_time_etad;
            }
            case 2: {
                return statusbarNavigationTimeCollector.statusbar_navigation_time_etah;
            }
            case 3: {
                return statusbarNavigationTimeCollector.statusbar_navigation_time_etam;
            }
            case 4: {
                return statusbarNavigationTimeCollector.statusbar_navigation_time_rtth;
            }
            case 5: {
                return statusbarNavigationTimeCollector.statusbar_navigation_time_rttm;
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

