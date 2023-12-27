/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface AmFmStationPersistence
extends Persistable {
    default public String getStationName() {
    }

    default public void setStationName(String string) {
    }

    default public long getStationFrequency() {
    }

    default public void setStationFrequency(long l) {
    }

    default public int getStationPi() {
    }

    default public void setStationPi(int n) {
    }

    default public int getStationReceptionQuality() {
    }

    default public void setStationReceptionQuality(int n) {
    }

    default public int getStationPtyCode() {
    }

    default public void setStationPtyCode(int n) {
    }

    default public int getStationWaveband() {
    }

    default public void setStationWaveband(int n) {
    }

    default public boolean isStationRds() {
    }

    default public void setStationRds(boolean bl) {
    }

    default public boolean isStationTp() {
    }

    default public void setStationTp(boolean bl) {
    }

    default public boolean isStationTa() {
    }

    default public void setStationTa(boolean bl) {
    }

    default public boolean isStationTmc() {
    }

    default public void setStationTmc(boolean bl) {
    }

    default public boolean isStationScrollingPs() {
    }

    default public void setStationScrollingPs(boolean bl) {
    }

    default public boolean isStationRadioText() {
    }

    default public void setStationRadioText(boolean bl) {
    }

    default public String getStationRealPs() {
    }

    default public void setStationRealPs(String string) {
    }

    default public boolean isStationHd() {
    }

    default public void setStationHd(boolean bl) {
    }

    default public String getStationShortNameHd() {
    }

    default public void setStationShortNameHd(String string) {
    }

    default public String getStationLongNameHd() {
    }

    default public void setStationLongNameHd(String string) {
    }

    default public boolean isStationFullDigital() {
    }

    default public void setStationFullDigital(boolean bl) {
    }

    default public int getStationServiceId() {
    }

    default public void setStationServiceId(int n) {
    }

    default public int getStationSubscription() {
    }

    default public void setStationSubscription(int n) {
    }

    default public boolean isStationEon() {
    }

    default public void setStationEon(boolean bl) {
    }

    default public boolean isStationCoChannel() {
    }

    default public void setStationCoChannel(boolean bl) {
    }

    default public String getRealName() {
    }

    default public void setRealName(String string) {
    }

    default public String getRegString() {
    }

    default public void setRegString(String string) {
    }

    default public int getHdStatus() {
    }

    default public void setHdStatus(int n) {
    }

    default public int getSubChannelCount() {
    }

    default public void setSubChannelCount(int n) {
    }

    default public int getChannelMask() {
    }

    default public void setChannelMask(int n) {
    }

    default public long getUniqueId() {
    }

    default public void setUniqueId(long l) {
    }

    default public boolean isMpsWithSPSAlreadyStored() {
    }

    default public void setMpsWithSPSAlreadyStored(boolean bl) {
    }

    default public boolean isMpsWithoutSPSAlreadyStored() {
    }

    default public void setMpsWithoutSPSAlreadyStored(boolean bl) {
    }

    default public ResourceLocatorPersistence getStationImage() {
    }

    default public void setStationImage(ResourceLocatorPersistence resourceLocatorPersistence) {
    }
}

