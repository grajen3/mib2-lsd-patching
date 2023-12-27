/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.tvtuner.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerEWSMessageCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TVTunerEWSMessageTransformer
extends ItemTransformerAdapter {
    public static final int TVTUNER_EWS_MESSAGE_STATION_NAME_STRING;
    public static final int TVTUNER_EWS_MESSAGE_WARNING_TIME_HOUR_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_WARNING_TIME_MINUTE_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_WARNING_DATE_YEAR_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_WARNING_DATE_MONTH_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_WARNING_DATE_DAY_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_ISSUANCE_TIME_HOUR_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_ISSUANCE_TIME_MINUTE_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_ISSUANCE_DATE_YEAR_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_ISSUANCE_DATE_MONTH_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_ISSUANCE_DATE_DAY_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_TYPE_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_AFFECTED_AREA_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_SOURCE_CLASSIFICATION_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_WARNING_PRIO_INTEGER;
    public static final int TVTUNER_EWS_MESSAGE_SHORT_MESSAGE_TEXT_STRING;
    public static final int TVTUNER_EWS_MESSAGE_COUNTRY_OF_ORIGIN_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[17];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 18, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3231);
    }

    @Override
    public int getColumnCount() {
        return 17;
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
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: {
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
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 17: 
            case 18: {
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
        TVTunerEWSMessageCollector tVTunerEWSMessageCollector = (TVTunerEWSMessageCollector)object;
        switch (n) {
            case 1: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_warning_time_hour;
            }
            case 2: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_warning_time_minute;
            }
            case 9: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_warning_date_year;
            }
            case 10: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_warning_date_month;
            }
            case 11: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_warning_date_day;
            }
            case 12: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_issuance_time_hour;
            }
            case 13: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_issuance_time_minute;
            }
            case 14: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_issuance_date_year;
            }
            case 15: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_issuance_date_month;
            }
            case 16: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_issuance_date_day;
            }
            case 3: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_type;
            }
            case 4: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_affected_area;
            }
            case 5: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_source_classification;
            }
            case 6: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_warning_prio;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TVTunerEWSMessageCollector tVTunerEWSMessageCollector = (TVTunerEWSMessageCollector)object;
        switch (n) {
            case 0: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_station_name;
            }
            case 17: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_short_message_text;
            }
            case 18: {
                return tVTunerEWSMessageCollector.tvtuner_ews_message_country_of_origin;
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

