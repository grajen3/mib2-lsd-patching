/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.radio;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioFrequencyContainer;
import generated.de.vw.mib.has.containers.RadioPresetIndexContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.contexts.radio.RadioServices;

public class RadioServicesAdapter
implements RadioServices {
    @Override
    public void actionRequest(int n, int n2, HASContainer hASContainer) {
        switch (n2) {
            case 21: {
                this.tuneStation(n, (RadioStationInfoContainer)hASContainer);
                break;
            }
            case 22: {
                this.tune(n, (RadioFrequencyContainer)hASContainer);
                break;
            }
            case 23: {
                this.nextRadioStation(n);
                break;
            }
            case 24: {
                this.previousRadioStation(n);
                break;
            }
            case 25: {
                this.seekForward(n);
                break;
            }
            case 26: {
                this.seekBackward(n);
                break;
            }
            case 27: {
                this.increaseRadioFrequency(n);
                break;
            }
            case 28: {
                this.decreaseRadioFrequency(n);
                break;
            }
            case 30: {
                this.storePreset(n, (RadioPresetIndexContainer)hASContainer);
                break;
            }
            case 31: {
                this.deletePreset(n, (RadioPresetIndexContainer)hASContainer);
                break;
            }
            default: {
                throw HASException.invalidActionRequest(n2);
            }
        }
    }

    @Override
    public void propertyRequest(int n) {
        switch (n) {
            case 28: {
                this.getAvailableRadioBands();
                break;
            }
            case 31: {
                this.getAvailableAMStations();
                break;
            }
            case 32: {
                this.getAvailableFMStations();
                break;
            }
            case 33: {
                this.getAvailableDABEnsembles();
                break;
            }
            case 34: {
                this.getAvailableDABServices();
                break;
            }
            case 35: {
                this.getAvailableDABServiceComponents();
                break;
            }
            case 36: {
                this.getRadioAMPresets();
                break;
            }
            case 37: {
                this.getRadioFMPresets();
                break;
            }
            case 38: {
                this.getRadioDABPresets();
                break;
            }
            case 39: {
                this.getRadioTuner();
                break;
            }
            case 40: {
                this.getRadioFrequencyRanges();
                break;
            }
            case 48: {
                this.getTrafficAnnouncement();
                break;
            }
            case 49: {
                this.getRadioText();
                break;
            }
            default: {
                throw HASException.invalidPropertyRequest(n);
            }
        }
    }

    @Override
    public void tuneStation(int n, RadioStationInfoContainer radioStationInfoContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void tune(int n, RadioFrequencyContainer radioFrequencyContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nextRadioStation(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void previousRadioStation(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void seekForward(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void seekBackward(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void increaseRadioFrequency(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void decreaseRadioFrequency(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void storePreset(int n, RadioPresetIndexContainer radioPresetIndexContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deletePreset(int n, RadioPresetIndexContainer radioPresetIndexContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getAvailableRadioBands() {
    }

    @Override
    public void getAvailableAMStations() {
    }

    @Override
    public void getAvailableFMStations() {
    }

    @Override
    public void getAvailableDABEnsembles() {
    }

    @Override
    public void getAvailableDABServices() {
    }

    @Override
    public void getAvailableDABServiceComponents() {
    }

    @Override
    public void getRadioAMPresets() {
    }

    @Override
    public void getRadioFMPresets() {
    }

    @Override
    public void getRadioDABPresets() {
    }

    @Override
    public void getRadioTuner() {
    }

    @Override
    public void getRadioFrequencyRanges() {
    }

    @Override
    public void getTrafficAnnouncement() {
    }

    @Override
    public void getRadioText() {
    }
}

