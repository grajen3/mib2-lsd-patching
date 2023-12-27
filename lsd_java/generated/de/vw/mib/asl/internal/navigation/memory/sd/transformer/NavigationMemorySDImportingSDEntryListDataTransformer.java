/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDImportingSDEntryListDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationMemorySDImportingSDEntryListDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_MEMORY_SD_IMPORTING_SD_ENTRY_LIST_DATA_PROCEED_ELEMENT_INTEGER;
    public static final int NAVIGATION_MEMORY_SD_IMPORTING_SD_ENTRY_LIST_DATA_PROGRESS_INTEGER;
    public static final int NAVIGATION_MEMORY_SD_IMPORTING_SD_ENTRY_LIST_DATA_STATE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[3];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(924);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
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
            case 2: {
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
        NavigationMemorySDImportingSDEntryListDataCollector navigationMemorySDImportingSDEntryListDataCollector = (NavigationMemorySDImportingSDEntryListDataCollector)object;
        switch (n) {
            case 0: {
                return navigationMemorySDImportingSDEntryListDataCollector.navigation_memory_sd_importing_sd_entry_list_data_proceed_element;
            }
            case 1: {
                return navigationMemorySDImportingSDEntryListDataCollector.navigation_memory_sd_importing_sd_entry_list_data_progress;
            }
            case 2: {
                return navigationMemorySDImportingSDEntryListDataCollector.navigation_memory_sd_importing_sd_entry_list_data_state;
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

