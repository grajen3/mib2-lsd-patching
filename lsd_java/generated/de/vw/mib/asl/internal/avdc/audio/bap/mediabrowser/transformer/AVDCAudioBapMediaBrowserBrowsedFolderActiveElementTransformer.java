/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class AVDCAudioBapMediaBrowserBrowsedFolderActiveElementTransformer
extends ItemTransformerAdapter {
    public static final int AVDC_AUDIO_BAP_MEDIABROWSER_ENTRY_ID_LONG;
    public static final int AVDC_AUDIO_BAP_MEDIABROWSER_CONTENT_TYPE_INTEGER;
    public static final int AVDC_AUDIO_BAP_MEDIABROWSER_ABS_POS_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[3];
        int n = 0;
        stringArray[n++] = TransformerUtil.getLongAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(509348864);
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
            case 1: 
            case 2: {
                return new Integer(this.getInt(n, object));
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
    public int getInt(int n, Object object) {
        AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector aVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector = (AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector)object;
        switch (n) {
            case 1: {
                return aVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector.avdc_audio_bap_mediabrowser_content_type;
            }
            case 2: {
                return aVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector.avdc_audio_bap_mediabrowser_abs_pos;
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
        AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector aVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector = (AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector)object;
        switch (n) {
            case 0: {
                return aVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector.avdc_audio_bap_mediabrowser_entry_id;
            }
        }
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

