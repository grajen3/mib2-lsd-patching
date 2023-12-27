/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.radio;

import de.vw.mib.has.HASContextServices;
import generated.de.vw.mib.has.containers.RadioFrequencyContainer;
import generated.de.vw.mib.has.containers.RadioPresetIndexContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;

public interface RadioServices
extends HASContextServices {
    default public void tuneStation(int n, RadioStationInfoContainer radioStationInfoContainer) {
    }

    default public void tune(int n, RadioFrequencyContainer radioFrequencyContainer) {
    }

    default public void nextRadioStation(int n) {
    }

    default public void previousRadioStation(int n) {
    }

    default public void seekForward(int n) {
    }

    default public void seekBackward(int n) {
    }

    default public void increaseRadioFrequency(int n) {
    }

    default public void decreaseRadioFrequency(int n) {
    }

    default public void storePreset(int n, RadioPresetIndexContainer radioPresetIndexContainer) {
    }

    default public void deletePreset(int n, RadioPresetIndexContainer radioPresetIndexContainer) {
    }

    default public void getAvailableRadioBands() {
    }

    default public void getAvailableAMStations() {
    }

    default public void getAvailableFMStations() {
    }

    default public void getAvailableDABEnsembles() {
    }

    default public void getAvailableDABServices() {
    }

    default public void getAvailableDABServiceComponents() {
    }

    default public void getRadioAMPresets() {
    }

    default public void getRadioFMPresets() {
    }

    default public void getRadioDABPresets() {
    }

    default public void getRadioTuner() {
    }

    default public void getRadioFrequencyRanges() {
    }

    default public void getTrafficAnnouncement() {
    }

    default public void getRadioText() {
    }
}

