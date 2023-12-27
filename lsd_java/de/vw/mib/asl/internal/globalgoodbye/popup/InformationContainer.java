/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.popup;

public class InformationContainer {
    private boolean showPhoneSection = false;
    private boolean showOnlineSection = false;
    private String nameOfEnrolledUser = null;

    boolean isShowPhoneSection() {
        return this.showPhoneSection;
    }

    void setShowPhoneSection(boolean bl) {
        this.showPhoneSection = bl;
    }

    boolean isShowOnlineSection() {
        return this.showOnlineSection;
    }

    void setShowOnlineSection(boolean bl) {
        this.showOnlineSection = bl;
    }

    String getNameOfEnrolledUser() {
        return this.nameOfEnrolledUser;
    }

    void setNameOfEnrolledUser(String string) {
        this.nameOfEnrolledUser = string;
    }

    boolean isAtLeastOneSectionToBeDisplayed() {
        return this.showOnlineSection || this.showPhoneSection;
    }
}

