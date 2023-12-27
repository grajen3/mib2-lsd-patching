/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import java.util.List;

public interface AmFmPresetSettings
extends Persistable {
    default public List getAmPresets() {
    }

    default public List getFmPresets() {
    }

    default public int getCurrentBankIndexAm() {
    }

    default public void setCurrentBankIndexAm(int n) {
    }

    default public int getCurrentBankIndexFm() {
    }

    default public void setCurrentBankIndexFm(int n) {
    }

    default public int getCurrentIndexAm() {
    }

    default public void setCurrentIndexAm(int n) {
    }

    default public int getCurrentIndexFm() {
    }

    default public void setCurrentIndexFm(int n) {
    }
}

