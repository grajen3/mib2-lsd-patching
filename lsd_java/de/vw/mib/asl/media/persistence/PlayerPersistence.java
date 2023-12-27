/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.collections.ints.IntObjectMap;

public interface PlayerPersistence
extends Persistable {
    default public boolean isIncludeSubfolder() {
    }

    default public void setIncludeSubfolder(boolean bl) {
    }

    default public int getVideoFormat() {
    }

    default public void setVideoFormat(int n) {
    }

    default public IntObjectMap getSelections() {
    }

    default public boolean isVideoMaximized() {
    }

    default public void setVideoMaximized(boolean bl) {
    }

    default public String getParentalManagementPin() {
    }

    default public void setParentalManagementPin(String string) {
    }

    default public int getParentalManagementLevel() {
    }

    default public void setParentalManagementLevel(int n) {
    }
}

