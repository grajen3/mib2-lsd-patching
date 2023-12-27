/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapCurrentStationIndicesCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoAMCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoDABCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoFMCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoSiriusCollector;
import org.dsi.ifc.global.ResourceLocator;

public class GuiBapApi {
    private long previousStationID = -1L;
    private long sdarsSid = 0L;
    private ResourceLocator PreviousFmHdLogo = null;

    public void updateBapCurrentStationIndices(int n, long l) {
        try {
            if (this.isStationGettingChanged(l)) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("GuiBapApi - updateBapCurrentStationIndices() - StationID changed, the previousStationID is :- ").append(this.previousStationID).append(" newStationID is :- ").append(l).log();
                }
                this.invalidateWavebandLogo(RadioCurrentWaveband.get());
                this.previousStationID = l;
            }
            RadioBapCurrentStationIndicesCollector radioBapCurrentStationIndicesCollector = new RadioBapCurrentStationIndicesCollector();
            radioBapCurrentStationIndicesCollector.radio_bap_current_station_indices__active_preset_bank_index = n;
            radioBapCurrentStationIndicesCollector.radio_bap_current_station_indices__active_station_id = l;
            if (3 == RadioCurrentWaveband.get()) {
                this.sdarsSid = l;
            }
            ListManager.getGenericASLList(2486).updateListItem(0, radioBapCurrentStationIndicesCollector);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("GuiBapApi - updateBapCurrentStationIndices() - StationID is :- ").append(l).append(" PresetIndex is :- ").append(n).log();
            }
            this.updatePresetLogoToKombi();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private boolean isStationGettingChanged(long l) {
        return l != -1L && this.previousStationID != l;
    }

    public void updatePresetLogoToKombi() {
        try {
            int n = RadioCurrentWaveband.get();
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("GuiBapApi - updatePresetLogoToKombi() - currentWaveBand is :- ").append(n).log();
            }
            switch (n) {
                case 0: {
                    RadioBapStationLogoAMCollector radioBapStationLogoAMCollector = new RadioBapStationLogoAMCollector();
                    radioBapStationLogoAMCollector.radio_bap_station_logo_am__image = AmFmPresetApi.getCurrentImage();
                    radioBapStationLogoAMCollector.radio_bap_station_logo_am__is_valid = true;
                    ListManager.getGenericASLList(1019618304).updateListItem(0, radioBapStationLogoAMCollector);
                    this.traceBapPresetStationLogoCollector(radioBapStationLogoAMCollector.radio_bap_station_logo_am__image, true);
                    break;
                }
                case 1: {
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                        this.PreviousFmHdLogo = AmFmFactory.getAslAmfmModelController().getAmFmStationArt(amFmStation);
                        this.updateFmHdLogoToKombi(this.PreviousFmHdLogo);
                        break;
                    }
                    RadioBapStationLogoFMCollector radioBapStationLogoFMCollector = new RadioBapStationLogoFMCollector();
                    radioBapStationLogoFMCollector.radio_bap_station_logo_fm__image = AmFmPresetApi.getCurrentImage();
                    radioBapStationLogoFMCollector.radio_bap_station_logo_fm__is_valid = true;
                    ListManager.getGenericASLList(1002841088).updateListItem(0, radioBapStationLogoFMCollector);
                    this.traceBapPresetStationLogoCollector(radioBapStationLogoFMCollector.radio_bap_station_logo_fm__image, true);
                    break;
                }
                case 2: {
                    RadioBapStationLogoDABCollector radioBapStationLogoDABCollector = new RadioBapStationLogoDABCollector();
                    radioBapStationLogoDABCollector.radio_bap_station_logo_dab__image = RadioData.getDabDatabase().dabPresetList.getCurrentImage();
                    radioBapStationLogoDABCollector.radio_bap_station_logo_dab__is_valid = true;
                    ListManager.getGenericASLList(1036395520).updateListItem(0, radioBapStationLogoDABCollector);
                    this.traceBapPresetStationLogoCollector(radioBapStationLogoDABCollector.radio_bap_station_logo_dab__image, true);
                    break;
                }
                case 3: {
                    RadioBapStationLogoSiriusCollector radioBapStationLogoSiriusCollector = new RadioBapStationLogoSiriusCollector();
                    radioBapStationLogoSiriusCollector.radio_bap_station_logo_sirius__image = SatDb.getInstance().getImageDb().getImage((int)this.sdarsSid);
                    radioBapStationLogoSiriusCollector.radio_bap_station_logo_sirius__is_valid = true;
                    ListManager.getGenericASLList(1053172736).updateListItem(0, radioBapStationLogoSiriusCollector);
                    this.traceBapPresetStationLogoCollector(radioBapStationLogoSiriusCollector.radio_bap_station_logo_sirius__image, true);
                    break;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateFmHdLogoToKombi(ResourceLocator resourceLocator) {
        RadioBapStationLogoFMCollector radioBapStationLogoFMCollector = new RadioBapStationLogoFMCollector();
        radioBapStationLogoFMCollector.radio_bap_station_logo_fm__image = resourceLocator;
        radioBapStationLogoFMCollector.radio_bap_station_logo_fm__is_valid = RadioCurrentWaveband.isFm();
        ListManager.getGenericASLList(1002841088).updateListItem(0, radioBapStationLogoFMCollector);
        this.traceBapPresetStationLogoCollector(radioBapStationLogoFMCollector.radio_bap_station_logo_fm__image, true);
    }

    public void changeInPresets() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("GuiBapApi - changeInPresets()").log();
            }
            this.invalidateWavebandLogo(RadioCurrentWaveband.get());
            this.updatePresetLogoToKombi();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void changeInFmHdStationLogosForKombi(ResourceLocator resourceLocator) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("GuiBapApi - changeInFMHDStationLogosForKombi()").log();
            }
            if (!RadioUtil.equals(resourceLocator, this.PreviousFmHdLogo)) {
                this.PreviousFmHdLogo = resourceLocator;
                this.invalidateWavebandLogo(1);
                this.updateFmHdLogoToKombi(resourceLocator);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void invalidateWavebandLogo(int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("GuiBapApi - updateCurrentLogoInvalid() - currentWaveBand is :- ").append(n).log();
            }
            switch (n) {
                case 0: {
                    Object[] objectArray = (RadioBapStationLogoAMCollector[])ListManager.getGenericASLList(1019618304).getDSIObjects();
                    if (objectArray == null) {
                        objectArray = new RadioBapStationLogoAMCollector[]{new RadioBapStationLogoAMCollector()};
                    }
                    objectArray[0].radio_bap_station_logo_am__is_valid = false;
                    ListManager.getGenericASLList(1019618304).updateList(objectArray);
                    this.traceBapPresetStationLogoCollector(((RadioBapStationLogoAMCollector)objectArray[0]).radio_bap_station_logo_am__image, false);
                    break;
                }
                case 1: {
                    Object[] objectArray = (RadioBapStationLogoFMCollector[])ListManager.getGenericASLList(1002841088).getDSIObjects();
                    if (objectArray == null) {
                        objectArray = new RadioBapStationLogoFMCollector[]{new RadioBapStationLogoFMCollector()};
                    }
                    objectArray[0].radio_bap_station_logo_fm__is_valid = false;
                    ListManager.getGenericASLList(1002841088).updateList(objectArray);
                    this.traceBapPresetStationLogoCollector(((RadioBapStationLogoFMCollector)objectArray[0]).radio_bap_station_logo_fm__image, false);
                    break;
                }
                case 2: {
                    Object[] objectArray = (RadioBapStationLogoDABCollector[])ListManager.getGenericASLList(1036395520).getDSIObjects();
                    if (objectArray == null) {
                        objectArray = new RadioBapStationLogoDABCollector[]{new RadioBapStationLogoDABCollector()};
                    }
                    objectArray[0].radio_bap_station_logo_dab__is_valid = false;
                    ListManager.getGenericASLList(1036395520).updateList(objectArray);
                    this.traceBapPresetStationLogoCollector(((RadioBapStationLogoDABCollector)objectArray[0]).radio_bap_station_logo_dab__image, false);
                    break;
                }
                case 3: {
                    Object[] objectArray = (RadioBapStationLogoSiriusCollector[])ListManager.getGenericASLList(1053172736).getDSIObjects();
                    if (objectArray == null) {
                        objectArray = new RadioBapStationLogoSiriusCollector[]{new RadioBapStationLogoSiriusCollector()};
                    }
                    objectArray[0].radio_bap_station_logo_sirius__is_valid = false;
                    ListManager.getGenericASLList(1053172736).updateList(objectArray);
                    this.traceBapPresetStationLogoCollector(((RadioBapStationLogoSiriusCollector)objectArray[0]).radio_bap_station_logo_sirius__image, false);
                    break;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void traceBapPresetStationLogoCollector(ResourceLocator resourceLocator, boolean bl) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                if (null != resourceLocator) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("GuiBapApi - traceBapPresetLogo() - preset logo is :- ").append(resourceLocator.toString()).append(" and the validity is :- ").append(bl).log();
                } else {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("GuiBapApi - traceBapPresetLogo() - preset logo is null").append(" and the validity is :- ").append(bl).log();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

