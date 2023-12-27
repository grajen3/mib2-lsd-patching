/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface EnsemblePersistence
extends Persistable {
    default public int getEnsEcc() {
    }

    default public void setEnsEcc(int n) {
    }

    default public int getEnsId() {
    }

    default public void setEnsId(int n) {
    }

    default public String getFrequencyLabel() {
    }

    default public void setFrequencyLabel(String string) {
    }

    default public int getFrequencyValue() {
    }

    default public void setFrequencyValue(int n) {
    }

    default public String getFullName() {
    }

    default public void setFullName(String string) {
    }

    default public boolean isPotentiallyReceivable() {
    }

    default public void setPotentiallyReceivable(boolean bl) {
    }

    default public String getShortName() {
    }

    default public void setShortName(String string) {
    }

    default public boolean isTp() {
    }

    default public void setTp(boolean bl) {
    }
}

