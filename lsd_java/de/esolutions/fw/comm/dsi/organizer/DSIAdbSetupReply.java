/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

public interface DSIAdbSetupReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

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

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

