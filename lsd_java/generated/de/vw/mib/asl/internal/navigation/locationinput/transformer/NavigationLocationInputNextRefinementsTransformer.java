/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputNextRefinementsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationLocationInputNextRefinementsTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_POSTAL_CODE_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_CITY_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_STREET_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_STREET_DISAMBIGUATION_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_STREET_WITH_BN_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_HOUSENUMBER_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_HOUSENUMBER_ALTERNATIVE_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_HOUSENUMBER_MATCH_OR_ALTERNATIVE_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_CROSSING_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_STATE_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_STATE_NEEDED_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_PROVINCE_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_PROVINCE_NEEDED_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_PHONENUMBER_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_NEXT_REFINEMENTS_MAPCODE_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[15];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 16, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2829);
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
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 14: 
            case 15: 
            case 16: {
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
            case 5: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 14: 
            case 15: 
            case 16: {
                return this.getBoolean(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationLocationInputNextRefinementsCollector navigationLocationInputNextRefinementsCollector = (NavigationLocationInputNextRefinementsCollector)object;
        switch (n) {
            case 0: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_postal_code_available;
            }
            case 1: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_city_available;
            }
            case 2: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_street_available;
            }
            case 3: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_street_disambiguation_available;
            }
            case 14: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_street_with_bn_available;
            }
            case 4: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_housenumber_available;
            }
            case 5: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_housenumber_alternative_available;
            }
            case 8: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_housenumber_match_or_alternative_available;
            }
            case 7: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_crossing_available;
            }
            case 9: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_state_available;
            }
            case 10: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_state_needed;
            }
            case 11: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_province_available;
            }
            case 12: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_province_needed;
            }
            case 15: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_phonenumber_available;
            }
            case 16: {
                return navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_mapcode_available;
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

