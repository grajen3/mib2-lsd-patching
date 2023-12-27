/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface StoredPicture
extends Persistable {
    default public int getIdentification() {
    }

    default public void setIdentification(int n) {
    }

    default public String getUrl() {
    }

    default public void setUrl(String string) {
    }

    default public int getBitfieldOfUsers() {
    }

    default public void setBitfieldOfUsers(int n) {
    }

    default public int getCtxId() {
    }

    default public void setCtxId(int n) {
    }
}

