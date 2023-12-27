/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.base.DSIListener;

public interface DSIMessagingServiceConfigurationListener
extends DSIListener {
    default public void setSMSCNumberResponse(int n) {
    }

    default public void activateStoreSmsOnSentResponse(int n) {
    }

    default public void setShortMessageValidityPeriodResponse(int n) {
    }

    default public void activateSMSDeliveryReportResponse(int n) {
    }

    default public void updateSMSCNumber(String string, int n) {
    }

    default public void setPhoneSystemRingingVolumeResponse(int n) {
    }

    default public void setPhoneSystemRingingTypeResponse(int n) {
    }

    default public void activateEmailIncludeOldMailInReplyResponse(int n) {
    }

    default public void activateEmailEmptySubjectNotificationResponse(int n) {
    }

    default public void changeFolderViewModeResponse(int n) {
    }

    default public void restoreFactorySettingsResponse(int n) {
    }

    default public void responseSetSmsIndications(int n) {
    }

    default public void responseSetEmailIndications(int n) {
    }

    default public void responseSetPushSms(int n) {
    }

    default public void updateSmsDeliveryReport(boolean bl, int n) {
    }

    default public void updateStoreSmsOnSent(boolean bl, int n) {
    }

    default public void updateShortMessageValidityPeriod(int n, int n2) {
    }

    default public void updatePhoneSystemRingingVolume(int n, int n2) {
    }

    default public void updatePhoneSystemRingingType(int n, int n2) {
    }

    default public void updateEmailIncludeOldMailInReply(boolean bl, int n) {
    }

    default public void updateEmailEmptySubjectNotification(boolean bl, int n) {
    }

    default public void updateFolderViewMode(int n, int n2) {
    }

    default public void updateAccountPreferences(int n, String string, int n2) {
    }

    default public void updateSmsIndications(boolean bl, int n) {
    }

    default public void updateEmailIndications(boolean bl, int n) {
    }

    default public void updatePushSms(boolean bl, int n) {
    }
}

