/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.avdc.audio.transformer.AVDCAudioCurrentTrackInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class AVDCAudioCurrentTrackInfoTransformer
extends ItemTransformerAdapter {
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__ALBUM_STRING;
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__ARTIST_STRING;
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__COVER_RESOURCE_LOCATOR;
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__FILENAME_STRING;
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__IS_COVER_AVAILABLE_BOOLEAN;
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__IS_VBR_CODED_BOOLEAN;
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__IS_VIDEO_PODCAST_BOOLEAN;
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__TITLE_STRING;
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__TOTAL_TIME_INTEGER;
    public static final int AVDC_AUDIO_CURRENT_TRACK_INFO__TRACKNUMBER_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(58);
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
            case 3: 
            case 4: 
            case 9: {
                return this.getBoolean(n, object);
            }
            case 6: 
            case 7: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 5: 
            case 8: {
                return this.getString(n, object);
            }
            case 2: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        AVDCAudioCurrentTrackInfoCollector aVDCAudioCurrentTrackInfoCollector = (AVDCAudioCurrentTrackInfoCollector)object;
        switch (n) {
            case 3: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__is_cover_available;
            }
            case 9: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__is_vbr_coded;
            }
            case 4: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__is_video_podcast;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        AVDCAudioCurrentTrackInfoCollector aVDCAudioCurrentTrackInfoCollector = (AVDCAudioCurrentTrackInfoCollector)object;
        switch (n) {
            case 6: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__total_time;
            }
            case 7: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__tracknumber;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        AVDCAudioCurrentTrackInfoCollector aVDCAudioCurrentTrackInfoCollector = (AVDCAudioCurrentTrackInfoCollector)object;
        switch (n) {
            case 0: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__album;
            }
            case 1: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__artist;
            }
            case 8: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__filename;
            }
            case 5: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__title;
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
        AVDCAudioCurrentTrackInfoCollector aVDCAudioCurrentTrackInfoCollector = (AVDCAudioCurrentTrackInfoCollector)object;
        switch (n) {
            case 2: {
                return aVDCAudioCurrentTrackInfoCollector.avdc_audio_current_track_info__cover;
            }
        }
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

