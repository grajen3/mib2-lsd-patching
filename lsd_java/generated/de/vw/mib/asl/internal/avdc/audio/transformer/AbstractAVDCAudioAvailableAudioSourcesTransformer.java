/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractAVDCAudioAvailableAudioSourcesTransformer
extends ItemTransformerAdapter {
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__HAS_VIDEO_CAPABILITY_BOOLEAN;
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__ID_INTEGER;
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__IS_ACTIVE_BOOLEAN;
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__IS_ENABLED_BOOLEAN;
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__IS_PARTITIONED_BOOLEAN;
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__IS_SOURCE_BROWSERABLE_BOOLEAN;
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__MEDIA_FLAG_INTEGER;
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__MEDIA_TYPE_INTEGER;
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__OBJECT_ID_LONG;
    public static final int AVDC_AUDIO_AVAILABLE_AUDIO_SOURCES__SOURCE_NAME_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(56);
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
            case 1: 
            case 2: 
            case 7: 
            case 8: 
            case 9: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 4: 
            case 5: {
                return new Integer(this.getInt(n, object));
            }
            case 3: {
                return this.getString(n, object);
            }
            case 6: {
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
    public ResourceLocator getResourceLocator(int n, Object object) {
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
