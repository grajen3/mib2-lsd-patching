/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface StationInfoPersistence
extends Persistable {
    default public int getCategoryNumber() {
    }

    default public void setCategoryNumber(int n) {
    }

    default public int getSubscription() {
    }

    default public void setSubscription(int n) {
    }

    default public int getSid() {
    }

    default public void setSid(int n) {
    }

    default public int getStationNumber() {
    }

    default public void setStationNumber(int n) {
    }

    default public String getShortLabel() {
    }

    default public void setShortLabel(String string) {
    }

    default public String getFullLabel() {
    }

    default public void setFullLabel(String string) {
    }

    default public boolean isMature() {
    }

    default public void setMature(boolean bl) {
    }
}

