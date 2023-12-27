/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;

public interface DSIAdbSetupListener
extends DSIListener {
    default public void updateAdbState(int n, int n2) {
    }

    default public void updateSortOrder(int n, int n2) {
    }

    default public void updatePictureVisibility(boolean bl, int n) {
    }

    default public void setLanguageResult(int n) {
    }

    default public void setSortOrderResult(int n) {
    }

    default public void setPublicProfileVisibilityResult(int n) {
    }

    default public void resetToFactorySettingsResult(int n) {
    }

    default public void resetTopDestinationResult(int n) {
    }

    default public void createBackupFileResult(int n, String string) {
    }

    default public void importBackupFileResult(int n, String string) {
    }

    default public void setPictureVisibilityResult(int n) {
    }

    default public void setContextSpecificVisibilityResult(int n) {
    }

    default public void updateContextSpecificVisibility(boolean bl, int n) {
    }
}

