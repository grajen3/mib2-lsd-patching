/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractSpeechNavigationControllerOnboardPOIsSelectedOnboardPOITransformer
extends ItemTransformerAdapter {
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_SELECTED_ONBOARD_POI_ID_LONG;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_SELECTED_ONBOARD_POI_INDEX_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_SELECTED_ONBOARD_POI_ICON_RESOURCE_LOCATOR;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_SELECTED_ONBOARD_POI_NAME_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_SELECTED_ONBOARD_POI_DISTANCE_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_SELECTED_ONBOARD_POI_DIRECTION_ARROW_INDEX_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_SELECTED_ONBOARD_POI_INSIDE_RANGE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getLongAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1997026304);
    }

    @Override
    public int getColumnCount() {
        return 7;
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
            case 6: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 5: {
                return this.getBoolean(n, object);
            }
            case 3: 
            case 4: 
            case 6: {
                return new Integer(this.getInt(n, object));
            }
            case 2: {
                return this.getString(n, object);
            }
            case 1: {
                return this.getResourceLocator(n, object);
            }
            case 0: {
                return new Long(this.getLong(n, object));
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
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

