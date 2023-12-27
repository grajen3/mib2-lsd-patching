/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.tvtuner.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerKeyPanelListCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TVTunerKeyPanelListTransformer
extends ItemTransformerAdapter {
    public static final int TVTUNER_KEY_PANEL_BUTTON_YELLOW_INTEGER;
    public static final int TVTUNER_KEY_PANEL_BUTTON_GREEN_INTEGER;
    public static final int TVTUNER_KEY_PANEL_BUTTON_RED_INTEGER;
    public static final int TVTUNER_KEY_PANEL_BUTTON_BLUE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[4];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1119083008);
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
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
            case 3: {
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
        TVTunerKeyPanelListCollector tVTunerKeyPanelListCollector = (TVTunerKeyPanelListCollector)object;
        switch (n) {
            case 0: {
                return tVTunerKeyPanelListCollector.tvtuner_key_panel_button_yellow;
            }
            case 1: {
                return tVTunerKeyPanelListCollector.tvtuner_key_panel_button_green;
            }
            case 2: {
                return tVTunerKeyPanelListCollector.tvtuner_key_panel_button_red;
            }
            case 3: {
                return tVTunerKeyPanelListCollector.tvtuner_key_panel_button_blue;
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

