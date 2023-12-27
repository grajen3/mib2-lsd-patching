/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber.transformer.NavigationLocationInputInputFieldPhonenumberListInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationLocationInputInputFieldPhonenumberListInfoTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_LOCATIONINPUT_INPUTFIELD_PHONENUMBER_LIST_INFO_SIZE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[1];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-923791360);
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: {
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
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationLocationInputInputFieldPhonenumberListInfoCollector navigationLocationInputInputFieldPhonenumberListInfoCollector = (NavigationLocationInputInputFieldPhonenumberListInfoCollector)object;
        switch (n) {
            case 0: {
                return navigationLocationInputInputFieldPhonenumberListInfoCollector.navigation_locationinput_inputfield_phonenumber_list_info_size;
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

