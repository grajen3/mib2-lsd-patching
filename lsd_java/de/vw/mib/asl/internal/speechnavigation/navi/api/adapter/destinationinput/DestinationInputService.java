/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.CapabilitiesStartUpListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.CurrentLocationListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.GetValuePartMatchesListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;

public interface DestinationInputService {
    default public INavigationLocation getCurrentInput() {
    }

    default public Capabilities getCurrentInputSpeechCapabilities() {
    }

    default public void initializeDestinationInput(DestinationInputListener destinationInputListener) {
    }

    default public void selectCountryInput(DestinationInputListener destinationInputListener) {
    }

    default public void setCountry(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectStateInput(DestinationInputListener destinationInputListener) {
    }

    default public void setState(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectCityInput(DestinationInputListener destinationInputListener) {
    }

    default public void setCity(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectPostalCodeInput(DestinationInputListener destinationInputListener) {
    }

    default public void setPostalCode(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectStreetInput(DestinationInputListener destinationInputListener) {
    }

    default public void setStreet(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectHouseNumberInput(DestinationInputListener destinationInputListener) {
    }

    default public void setHouseNumber(DestinationInputListener destinationInputListener, HouseNumber houseNumber) {
    }

    default public void setHouseNumberLike(GetValuePartMatchesListener getValuePartMatchesListener, String string) {
    }

    default public void selectCrossingInput(DestinationInputListener destinationInputListener) {
    }

    default public void setCrossing(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectPrefectureInput(DestinationInputListener destinationInputListener) {
    }

    default public void setPrefecture(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectMunicipalityInput(DestinationInputListener destinationInputListener) {
    }

    default public void setMunicipality(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectWardInput(DestinationInputListener destinationInputListener) {
    }

    default public void setWard(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectPlaceInput(DestinationInputListener destinationInputListener) {
    }

    default public void setPlace(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public void selectChomeInput(DestinationInputListener destinationInputListener) {
    }

    default public void setChome(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
    }

    default public boolean isCountrySelected() {
    }

    default public boolean isCountryStateSelected() {
    }

    default public boolean isCitySelected() {
    }

    default public boolean isStreetSelected() {
    }

    default public boolean isHousenumberSelected() {
    }

    default public boolean isCountryAvailable() {
    }

    default public boolean isCityAvailable() {
    }

    default public boolean isZipAvailable() {
    }

    default public boolean isStreetAvailable() {
    }

    default public boolean isStreetDisambiguationAvailable() {
    }

    default public boolean isHouseNumberAvailable() {
    }

    default public boolean arePointLocationHouseNumbersAvailable() {
    }

    default public boolean isCrossingAvailable() {
    }

    default public boolean isCountryStateAvailable() {
    }

    default public boolean isPrefectureAvailable() {
    }

    default public boolean isPrefectureSelected() {
    }

    default public boolean isMunicipalityAvailable() {
    }

    default public boolean isMunicipalitySelected() {
    }

    default public boolean isWardAvailable() {
    }

    default public boolean isWardSelected() {
    }

    default public boolean isPlaceAvailable() {
    }

    default public boolean isPlaceSelected() {
    }

    default public boolean isChomeAvailable() {
    }

    default public boolean isChomeSelected() {
    }

    default public boolean isHouseNumberBySds() {
    }

    default public void registerOnCountryChanges(CurrentLocationListener currentLocationListener) {
    }

    default public void unregisterOnCountryChanges(CurrentLocationListener currentLocationListener) {
    }

    default public void requestCountryIcon(INavigationLocation iNavigationLocation) {
    }

    default public void registerOnStartUpCapabilities(CapabilitiesStartUpListener capabilitiesStartUpListener) {
    }

    default public void unregisterOnStartUpCapabilities(CapabilitiesStartUpListener capabilitiesStartUpListener) {
    }

    default public void release() {
    }
}

