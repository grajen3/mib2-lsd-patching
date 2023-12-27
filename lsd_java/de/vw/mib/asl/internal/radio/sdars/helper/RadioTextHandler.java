/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.categories.CategoryHandler;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATRadioTextCollector;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public final class RadioTextHandler
implements IAslPoolListener {
    private final SatDb mDb;
    private final IAslPool mPool;
    private final IntObjectMap mRadioTextMap = new IntObjectOptHashMap(999);

    public RadioTextHandler(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mPool.addListener(13, (IAslPoolListener)this);
        this.mPool.addListener(14, (IAslPoolListener)this);
        this.mPool.addListener(50, (IAslPoolListener)this);
        this.mPool.addListener(15, (IAslPoolListener)this);
    }

    public boolean isRadioTextEmpty(RadioText radioText) {
        if (radioText == null) {
            return true;
        }
        return StringUtil.isEmpty(radioText.longArtistName) && StringUtil.isEmpty(radioText.longProgramTitle);
    }

    public RadioText get(int n) {
        RadioText radioText = (RadioText)this.mRadioTextMap.get(n);
        return radioText;
    }

    public void put(RadioText radioText) {
        short s = 0;
        if (radioText != null) {
            s = radioText.getSID();
        }
        if (s >= 0) {
            if (radioText == null) {
                this.remove(s);
            } else {
                this.mRadioTextMap.put(s, radioText);
            }
        }
    }

    public void remove(short s) {
        this.mRadioTextMap.remove(s);
    }

    public int getCount() {
        return this.mRadioTextMap.size();
    }

    public void updatePDT() {
        StationInfo stationInfo = this.mPool.getChannel(15);
        if (stationInfo != null) {
            Object object;
            Object object2;
            short s = stationInfo.getCategoryNumber();
            int n = stationInfo.getSID();
            String string = this.mPool.getString(188);
            String string2 = this.mPool.getString(189);
            RadioSATRadioTextCollector[] radioSATRadioTextCollectorArray = new RadioSATRadioTextCollector[]{new RadioSATRadioTextCollector()};
            radioSATRadioTextCollectorArray[0].radio_sat_radio_text__album_name = "";
            radioSATRadioTextCollectorArray[0].radio_sat_radio_text__score_team_a = "";
            radioSATRadioTextCollectorArray[0].radio_sat_radio_text__score_team_b = "";
            radioSATRadioTextCollectorArray[0].radio_sat_radio_text__short_team_a = "";
            radioSATRadioTextCollectorArray[0].radio_sat_radio_text__short_team_b = "";
            radioSATRadioTextCollectorArray[0].radio_sat_radio_text__sport_event = false;
            radioSATRadioTextCollectorArray[0].radio_sat_radio_text__team_a = "";
            radioSATRadioTextCollectorArray[0].radio_sat_radio_text__team_b = "";
            if (stationInfo.getSID() == 0) {
                object2 = this.mPool.getString(47);
                object = this.mPool.getString(162);
                radioSATRadioTextCollectorArray[0].radio_sat_radio_text__artist_name = object;
                radioSATRadioTextCollectorArray[0].radio_sat_radio_text__title_name = object2;
            } else {
                object2 = this.get(n);
                boolean bl = this.mPool.getBoolean(50);
                if (object2 == null || bl) {
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__artist_name = "";
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__short_artist_name = "";
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__title_name = "";
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__short_title_name = "";
                } else {
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__artist_name = ((RadioText)object2).longArtistName;
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__short_artist_name = ((RadioText)object2).shortArtistName;
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__title_name = ((RadioText)object2).longProgramTitle;
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__short_title_name = ((RadioText)object2).shortProgramTitle;
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__short_team_a = string;
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__team_a = string;
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__short_team_b = string2;
                    radioSATRadioTextCollectorArray[0].radio_sat_radio_text__team_b = string2;
                }
                CategoryHandler categoryHandler = this.mDb.getCategories();
                radioSATRadioTextCollectorArray[0].radio_sat_radio_text__category_name = categoryHandler != null ? categoryHandler.getLabel(s) : "";
            }
            object2 = this.mDb.getLogHandler().getLogMsg();
            if (object2 != null) {
                object2.append("ModelListRadioText: artist=").append(radioSATRadioTextCollectorArray[0].radio_sat_radio_text__artist_name);
                object2.append(", title=").append(radioSATRadioTextCollectorArray[0].radio_sat_radio_text__title_name);
                object2.append(", category=").append(radioSATRadioTextCollectorArray[0].radio_sat_radio_text__category_name);
                object2.log();
            }
            if (RadioCurrentWaveband.isSdars() && RadioCodingAdapter.isRadioTileFeatureActivated()) {
                object = null;
                object = radioSATRadioTextCollectorArray[0].radio_sat_radio_text__artist_name.equals("") || radioSATRadioTextCollectorArray[0].radio_sat_radio_text__title_name.equals("") ? new StringBuffer().append(radioSATRadioTextCollectorArray[0].radio_sat_radio_text__artist_name).append(radioSATRadioTextCollectorArray[0].radio_sat_radio_text__title_name).toString() : new StringBuffer().append(radioSATRadioTextCollectorArray[0].radio_sat_radio_text__artist_name).append(" - ").append(radioSATRadioTextCollectorArray[0].radio_sat_radio_text__title_name).toString();
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateRadioTextGetters((String)object);
            }
            object = this.mDb.getModelApi();
            ((SatModelApi)object).updatePDT(radioSATRadioTextCollectorArray);
        }
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 13: {
                RadioText radioText = iAslPoolRecord.getRadioText();
                this.put(radioText);
                iAslPool.setRadioText(85, radioText);
                break;
            }
            case 14: {
                boolean bl = this.mPool.getBoolean(61);
                if (bl) break;
                this.updatePDT();
                break;
            }
            case 15: 
            case 50: {
                this.updatePDT();
                break;
            }
        }
    }
}

