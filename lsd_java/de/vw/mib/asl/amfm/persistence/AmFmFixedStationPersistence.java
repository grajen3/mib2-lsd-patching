/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface AmFmFixedStationPersistence
extends Persistable {
    default public int getFrequency() {
    }

    default public void setFrequency(int n) {
    }

    default public int getPi() {
    }

    default public void setPi(int n) {
    }

    default public String getName() {
    }

    default public void setName(String string) {
    }

    default public String getShortName() {
    }

    default public void setShortName(String string) {
    }

    default public int getSubChannel() {
    }

    default public void setSubChannel(int n) {
    }

    default public short getRatingCounter() {
    }

    default public void setRatingCounter(short s) {
    }
}

