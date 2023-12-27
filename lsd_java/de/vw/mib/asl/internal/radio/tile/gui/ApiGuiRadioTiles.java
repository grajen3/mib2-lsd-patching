/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.tile.gui;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.transformer.TileListCollector;
import generated.de.vw.mib.asl.internal.ListManager;

public final class ApiGuiRadioTiles {
    String tileRadioText = "";
    String hdStationRadioText = "";
    String radioPlusTextNar = "";
    String radioTextNar = "";

    public String getTileRadioText() {
        return this.tileRadioText;
    }

    public void updateHDStationRadioText(String string, String string2) {
        if (null != string && null != string2) {
            this.hdStationRadioText = string.equals("") || string2.equals("") ? new StringBuffer().append(string).append(string2).toString() : new StringBuffer().append(string).append(" - ").append(string2).toString();
            this.updateTileRadioTextNar();
        } else {
            this.hdStationRadioText = "";
        }
    }

    public void updateRadioPlusTextNar(String string, String string2) {
        if (null != string && null != string2) {
            this.radioPlusTextNar = string.equals("") || string2.equals("") ? new StringBuffer().append(string).append(string2).toString() : new StringBuffer().append(string).append(" - ").append(string2).toString();
            this.updateTileRadioTextNar();
        } else {
            this.radioPlusTextNar = "";
        }
    }

    public void updateRadioTextNar(String string) {
        this.radioTextNar = string;
        this.updateTileRadioTextNar();
    }

    public void updateTileRadioTextNar() {
        String string = "";
        string = !this.hdStationRadioText.equals("") ? this.hdStationRadioText : (!this.radioPlusTextNar.equals("") ? this.radioPlusTextNar : this.radioTextNar);
        this.tileRadioText = string;
        if (RadioCurrentWaveband.isFm() && !RadioData.getAmfmDatabase().getSettingsPersistable().getRadioTextOption() && this.hdStationRadioText.equals("")) {
            string = "";
        }
        this.updateRadioTextGetters(string);
    }

    public void updateRadioText(String string) {
        try {
            if (RadioCodingAdapter.isRadioTileFeatureActivated() && null != ServiceManager.aslPropertyManager && null != string) {
                this.tileRadioText = string;
                if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("updateRadioText - RadioText:").append(string).log();
                }
                if (!RadioData.getAmfmDatabase().getSettingsPersistable().getRadioTextOption()) {
                    this.updateRadioTextGetters("");
                } else {
                    this.updateRadioTextGetters(this.tileRadioText);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateRadioTextGetters(String string) {
        try {
            string = string.trim();
            if (RadioCodingAdapter.isRadioTileFeatureActivated() && null != ServiceManager.aslPropertyManager && null != string) {
                if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("updateRadioTextGetters - RadioText:").append(string).log();
                }
                ServiceManager.aslPropertyManager.valueChangedString(1120281600, string);
                ServiceManager.aslPropertyManager.valueChangedString(1137058816, string);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateTileLists(TileListCollector[] tileListCollectorArray, int n) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - updateTileLists()").log();
            }
            if (null != tileListCollectorArray) {
                if (n < 0 || n >= tileListCollectorArray.length) {
                    n = 0;
                }
                if (tileListCollectorArray.length < 1) {
                    n = -1;
                }
                ListManager.getGenericASLList(1170613248).updateList(tileListCollectorArray);
                ListManager.getGenericASLList(1153836032).updateList(tileListCollectorArray);
                this.updateIndexOfTileLists(n);
                this.updateLoadStatusOfTileS(true);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateIndexOfTileLists(int n) {
        ListManager.getGenericASLList(1170613248).setActiveIndex(n);
        this.updateActiveIndexOfTileS(n);
        ListManager.getGenericASLList(1153836032).setActiveIndex(n);
        this.updateActiveIndexOfTileL(n);
    }

    public void updateActiveIndexOfTileS(int n) {
        if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("TileS - active index:").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(1204167680, n);
    }

    public void updateActiveIndexOfTileL(int n) {
        if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("TileL - active index:").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(1220944896, n);
    }

    public void updateLoadStatusOfTileS(boolean bl) {
        if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("TileS - loaded status:").append(bl).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1942365184, bl);
    }

    public void updateFollowModeInTile(boolean bl) {
        if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("TileL - follow mode:").append(bl).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1925587968, bl);
    }

    public void clearRadioText() {
        this.tileRadioText = "";
        this.hdStationRadioText = "";
        this.radioPlusTextNar = "";
        this.radioTextNar = "";
        this.updateRadioTextGetters("");
    }
}

