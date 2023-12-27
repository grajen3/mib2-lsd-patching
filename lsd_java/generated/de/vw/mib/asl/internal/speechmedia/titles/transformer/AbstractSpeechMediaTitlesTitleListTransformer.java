/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechmedia.titles.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractSpeechMediaTitlesTitleListTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHMEDIA_TITLES_OBJECT_ID_LONG;
    public static final int SPEECHMEDIA_TITLES_TITLE_NAME_STRING;
    public static final int SPEECHMEDIA_TITLES_TITLE_TYPE_INTEGER;
    public static final int SPEECHMEDIA_TITLES_ALBUM_NAME_STRING;
    public static final int SPEECHMEDIA_TITLES_ALBUM_TYPE_INTEGER;
    public static final int SPEECHMEDIA_TITLES_ARTIST_NAME_STRING;
    public static final int SPEECHMEDIA_TITLES_ARTIST_TYPE_INTEGER;
    public static final int SPEECHMEDIA_TITLES_COVER_RESOURCE_LOCATOR;
    public static final int SPEECHMEDIA_TITLES_VALUE_NAME_STRING;
    public static final int SPEECHMEDIA_TITLES_GENRE_STRING;
    public static final int SPEECHMEDIA_TITLES_GENRE_TYPE_INTEGER;
    public static final int SPEECHMEDIA_TITLES_NUMBER_OF_SUBITEMS_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getLongAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-998166016);
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 11: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: 
            case 7: 
            case 9: 
            case 10: {
                return this.getString(n, object);
            }
            case 12: {
                return this.getResourceLocator(n, object);
            }
            case 0: {
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

