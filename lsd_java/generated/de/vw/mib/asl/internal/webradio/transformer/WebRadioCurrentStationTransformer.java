/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.webradio.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.webradio.transformer.WebRadioCurrentStationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class WebRadioCurrentStationTransformer
extends ItemTransformerAdapter {
    public static final int WEBRADIO_CURRENT_STATION__NAME_STRING;
    public static final int WEBRADIO_CURRENT_STATION__LOCATION_STRING;
    public static final int WEBRADIO_CURRENT_STATION__ARTIST_TITLE_STRING;
    public static final int WEBRADIO_CURRENT_STATION__GENRE_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[4];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1816896768);
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
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        WebRadioCurrentStationCollector webRadioCurrentStationCollector = (WebRadioCurrentStationCollector)object;
        switch (n) {
            case 0: {
                return webRadioCurrentStationCollector.webradio_current_station__name;
            }
            case 1: {
                return webRadioCurrentStationCollector.webradio_current_station__location;
            }
            case 2: {
                return webRadioCurrentStationCollector.webradio_current_station__artist_title;
            }
            case 3: {
                return webRadioCurrentStationCollector.webradio_current_station__genre;
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

