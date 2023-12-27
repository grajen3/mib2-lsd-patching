/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.settings.browser.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.phone.setup.settings.browser.transformer.PhoneSetupSettingsBrowserDisplayedFolderCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class PhoneSetupSettingsBrowserDisplayedFolderTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_SETUP_SETTINGS_BROWSER_DISPLAYED_FOLDER_LEVEL_INTEGER;
    public static final int PHONE_SETUP_SETTINGS_BROWSER_DISPLAYED_FOLDER_NAME_STRING;
    public static final int PHONE_SETUP_SETTINGS_BROWSER_DISPLAYED_FOLDER_TYPE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[3];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2623);
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
            case 2: {
                return new Integer(this.getInt(n, object));
            }
            case 1: {
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
        PhoneSetupSettingsBrowserDisplayedFolderCollector phoneSetupSettingsBrowserDisplayedFolderCollector = (PhoneSetupSettingsBrowserDisplayedFolderCollector)object;
        switch (n) {
            case 0: {
                return phoneSetupSettingsBrowserDisplayedFolderCollector.phone_setup_settings_browser_displayed_folder_level;
            }
            case 2: {
                return phoneSetupSettingsBrowserDisplayedFolderCollector.phone_setup_settings_browser_displayed_folder_type;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        PhoneSetupSettingsBrowserDisplayedFolderCollector phoneSetupSettingsBrowserDisplayedFolderCollector = (PhoneSetupSettingsBrowserDisplayedFolderCollector)object;
        switch (n) {
            case 1: {
                return phoneSetupSettingsBrowserDisplayedFolderCollector.phone_setup_settings_browser_displayed_folder_name;
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

