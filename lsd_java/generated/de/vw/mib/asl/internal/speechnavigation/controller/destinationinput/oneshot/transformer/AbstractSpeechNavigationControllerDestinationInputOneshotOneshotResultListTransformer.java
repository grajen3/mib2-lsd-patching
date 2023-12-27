/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractSpeechNavigationControllerDestinationInputOneshotOneshotResultListTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_RESULT_LIST_SIZE_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_CITY_RESULT_LIST_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_CITY_RESULT_LIST_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_STREET_RESULT_LIST_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_STREET_RESULT_LIST_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_HOUSENUMBER_RESULT_LIST_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_HOUSENUMBER_RESULT_LIST_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_PREFECTURE_RESULT_LIST_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_PREFECTURE_RESULT_LIST_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_MUNICIPALITY_RESULT_LIST_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_MUNICIPALITY_RESULT_LIST_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_PLACE_RESULT_LIST_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_PLACE_RESULT_LIST_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_CHOME_RESULT_LIST_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_ONESHOT_ONESHOT_CHOME_RESULT_LIST_TITLE_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[15];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2064135168);
    }

    @Override
    public int getColumnCount() {
        return 15;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
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
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
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

