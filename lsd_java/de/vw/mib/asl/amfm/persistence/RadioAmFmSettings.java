/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface RadioAmFmSettings
extends Persistable {
    default public boolean isRadiotextOption() {
    }

    default public void setRadiotextOption(boolean bl) {
    }

    default public boolean isTpOption() {
    }

    default public void setTpOption(boolean bl) {
    }

    default public boolean isRdsOption() {
    }

    default public void setRdsOption(boolean bl) {
    }

    default public boolean isRdsValueInCoding() {
    }

    default public void setRdsValueInCoding(boolean bl) {
    }

    default public boolean isAfOption() {
    }

    default public void setAfOption(boolean bl) {
    }

    default public boolean isAfValueInCoding() {
    }

    default public void setAfValueInCoding(boolean bl) {
    }

    default public int getRegOption() {
    }

    default public void setRegOption(int n) {
    }

    default public int getAmRangeOption() {
    }

    default public void setAmRangeOption(int n) {
    }

    default public int getScopeOfArrowButton() {
    }

    default public void setScopeOfArrowButton(int n) {
    }

    default public int getWaveBand() {
    }

    default public void setWaveBand(int n) {
    }

    default public boolean isPty31Option() {
    }

    default public void setPty31Option(boolean bl) {
    }

    default public int getFmRange() {
    }

    default public void setFmRange(int n) {
    }

    default public int getFmViewState() {
    }

    default public void setFmViewState(int n) {
    }

    default public int getAmViewState() {
    }

    default public void setAmViewState(int n) {
    }

    default public boolean isAmHdOption() {
    }

    default public void setAmHdOption(boolean bl) {
    }

    default public boolean isRadioTextPlusOption() {
    }

    default public void setRadioTextPlusOption(boolean bl) {
    }

    default public int getFmStationListSortOrder() {
    }

    default public void setFmStationListSortOrder(int n) {
    }

    default public boolean isAutoStoreStationLogosActive() {
    }

    default public void setAutoStoreStationLogosActive(boolean bl) {
    }

    default public boolean isAutoStoreStationLogosActiveChangedByUser() {
    }

    default public void setAutoStoreStationLogosActiveChangedByUser(boolean bl) {
    }

    default public boolean isAfOnBeforeRdsOff() {
    }

    default public void setAfOnBeforeRdsOff(boolean bl) {
    }

    default public boolean isRegFixBeforeRdsOff() {
    }

    default public void setRegFixBeforeRdsOff(boolean bl) {
    }

    default public boolean isRadiotextOnBeforeRdsOff() {
    }

    default public void setRadiotextOnBeforeRdsOff(boolean bl) {
    }

    default public boolean isTpOnBeforeRdsOff() {
    }

    default public void setTpOnBeforeRdsOff(boolean bl) {
    }

    default public boolean isAutoStoreStationLogosActiveBeforeRdsOff() {
    }

    default public void setAutoStoreStationLogosActiveBeforeRdsOff(boolean bl) {
    }

    default public boolean isEnhancedRadioTextActive() {
    }

    default public void setEnhancedRadioTextActive(boolean bl) {
    }

    default public boolean isEnhancedRadioTextActiveBeforeRdsOff() {
    }

    default public void setEnhancedRadioTextActiveBeforeRdsOff(boolean bl) {
    }

    default public boolean isHomeCountryAutoSelectionActive() {
    }

    default public void setHomeCountryAutoSelectionActive(boolean bl) {
    }

    default public boolean isFmHdOption() {
    }

    default public void setFmHdOption(boolean bl) {
    }

    default public boolean isFmHdFilter() {
    }

    default public void setFmHdFilter(boolean bl) {
    }

    default public boolean isAmHdFilter() {
    }

    default public void setAmHdFilter(boolean bl) {
    }

    default public AmFmStationPersistence getCurrentFmStation() {
    }

    default public void setCurrentFmStation(AmFmStationPersistence amFmStationPersistence) {
    }

    default public AmFmStationPersistence getCurrentAmStation() {
    }

    default public void setCurrentAmStation(AmFmStationPersistence amFmStationPersistence) {
    }

    default public int getJapanTiFrequency() {
    }

    default public void setJapanTiFrequency(int n) {
    }

    default public int getUserSelectedHomeCountry() {
    }

    default public void setUserSelectedHomeCountry(int n) {
    }

    default public int getCalculatedHomeCountry() {
    }

    default public void setCalculatedHomeCountry(int n) {
    }

    default public int getDatabaseVersionMajor() {
    }

    default public void setDatabaseVersionMajor(int n) {
    }

    default public int getDatabaseVersionMinor() {
    }

    default public void setDatabaseVersionMinor(int n) {
    }

    default public int getDatabaseVersionRevision() {
    }

    default public void setDatabaseVersionRevision(int n) {
    }

    default public int getAmFmNoOfPresets() {
    }

    default public void setAmFmNoOfPresets(int n) {
    }

    default public int getDabNoOfPresets() {
    }

    default public void setDabNoOfPresets(int n) {
    }
}

