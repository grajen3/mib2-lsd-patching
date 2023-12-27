/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import java.util.List;

public interface ServicePersistence
extends Persistable {
    default public int getEnsEcc() {
    }

    default public void setEnsEcc(int n) {
    }

    default public int getEnsId() {
    }

    default public void setEnsId(int n) {
    }

    default public long getServiceId() {
    }

    default public void setServiceId(long l) {
    }

    default public String getFullName() {
    }

    default public void setFullName(String string) {
    }

    default public String getShortName() {
    }

    default public void setShortName(String string) {
    }

    default public List getPtyCodes() {
    }

    default public boolean isTp() {
    }

    default public void setTp(boolean bl) {
    }
}

