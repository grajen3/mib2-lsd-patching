/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface ComponentPersistence
extends Persistable {
    default public int getEnsId() {
    }

    default public void setEnsId(int n) {
    }

    default public int getEnsEcc() {
    }

    default public void setEnsEcc(int n) {
    }

    default public long getSid() {
    }

    default public void setSid(long l) {
    }

    default public int getScidi() {
    }

    default public void setScidi(int n) {
    }

    default public String getFullName() {
    }

    default public void setFullName(String string) {
    }

    default public String getShortName() {
    }

    default public void setShortName(String string) {
    }

    default public boolean isPrimaryService() {
    }

    default public void setPrimaryService(boolean bl) {
    }
}

