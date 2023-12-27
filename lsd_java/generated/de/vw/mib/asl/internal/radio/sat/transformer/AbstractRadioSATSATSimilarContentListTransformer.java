/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractRadioSATSATSimilarContentListTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__ARTIST_NAME_STRING;
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__CHANNELT_NAME_STRING;
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__CHANNELT_NUMBER_STRING;
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__IMAGE_URL_RESOURCE_LOCATOR;
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__SCORE_TEAM_A_STRING;
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__SCORE_TEAM_B_STRING;
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__SONG_NAME_STRING;
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__TEAM_A_STRING;
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__TEAM_B_STRING;
    public static final int RADIO_SAT_SAT_SIMILAR_CONTENT_LIST__SPORT_PROGRAM_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3340);
    }

    @Override
    public int getColumnCount() {
        return 10;
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
            case 9: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 9: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return this.getString(n, object);
            }
            case 3: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
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

