/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging;

public interface DSIMessagingServiceConfigurationC {
    default public void setPhoneSystemRingingVolumeRequest(int n) {
    }

    default public void setPhoneSystemRingingTypeRequest(int n) {
    }

    default public void setSMSCNumberRequest(String string) {
    }

    default public void activateSmsDeliveryReportRequest(boolean bl) {
    }

    default public void activateStoreSmsOnSentRequest(boolean bl) {
    }

    default public void setShortMessageValidityPeriodRequest(int n) {
    }

    default public void activateEmailIncludeOldMailInReplyRequest(boolean bl) {
    }

    default public void activateEmailEmptySubjectNotificationRequest(boolean bl) {
    }

    default public void changeFolderViewModeRequest(int n) {
    }

    default public void restoreFactorySettingsRequest() {
    }

    default public void setAccountPreferences(int n, String string) {
    }

    default public void requestSetSmsIndications(boolean bl) {
    }

    default public void requestSetEmailIndications(boolean bl) {
    }

    default public void requestSetPushSms(boolean bl) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

