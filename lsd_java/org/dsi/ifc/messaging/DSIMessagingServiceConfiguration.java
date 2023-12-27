/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.base.DSIBase;

public interface DSIMessagingServiceConfiguration
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETSMSCNUMBERREQUEST;
    public static final int RT_ACTIVATESMSDELIVERYREPORTREQUEST;
    public static final int RT_ACTIVATESTORESMSONSENTREQUEST;
    public static final int RT_SETSHORTMESSAGEVALIDITYPERIODREQUEST;
    public static final int RT_SETPHONESYSTEMRINGINGVOLUMEREQUEST;
    public static final int RT_SETPHONESYSTEMRINGINGTYPEREQUEST;
    public static final int RT_ACTIVATEEMAILINCLUDEOLDMAILINREPLYREQUEST;
    public static final int RT_ACTIVATEEMAILEMPTYSUBJECTNOTIFICATIONREQUEST;
    public static final int RT_CHANGEFOLDERVIEWMODEREQUEST;
    public static final int RT_RESTOREFACTORYSETTINGSREQUEST;
    public static final int RT_SETACCOUNTPREFERENCES;
    public static final int RT_REQUESTSETSMSINDICATIONS;
    public static final int RT_REQUESTSETEMAILINDICATIONS;
    public static final int RT_REQUESTSETPUSHSMS;
    public static final int ATTR_SMSCNUMBER;
    public static final int ATTR_SMSDELIVERYREPORT;
    public static final int ATTR_STORESMSONSENT;
    public static final int ATTR_SHORTMESSAGEVALIDITYPERIOD;
    public static final int ATTR_PHONESYSTEMRINGINGVOLUME;
    public static final int ATTR_PHONESYSTEMRINGINGTYPE;
    public static final int ATTR_EMAILINCLUDEOLDMAILINREPLY;
    public static final int ATTR_EMAILEMPTYSUBJECTNOTIFICATION;
    public static final int ATTR_FOLDERVIEWMODE;
    public static final int ATTR_ACCOUNTPREFERENCES;
    public static final int ATTR_SMSINDICATIONS;
    public static final int ATTR_EMAILINDICATIONS;
    public static final int ATTR_PUSHSMS;
    public static final int RP_SETSMSCNUMBERRESPONSE;
    public static final int RP_ACTIVATESMSDELIVERYREPORTRESPONSE;
    public static final int RP_ACTIVATESTORESMSONSENTRESPONSE;
    public static final int RP_SETSHORTMESSAGEVALIDITYPERIODRESPONSE;
    public static final int RP_SETPHONESYSTEMRINGINGVOLUMERESPONSE;
    public static final int RP_SETPHONESYSTEMRINGINGTYPERESPONSE;
    public static final int RP_ACTIVATEEMAILINCLUDEOLDMAILINREPLYRESPONSE;
    public static final int RP_ACTIVATEEMAILEMPTYSUBJECTNOTIFICATIONRESPONSE;
    public static final int RP_CHANGEFOLDERVIEWMODERESPONSE;
    public static final int RP_RESTOREFACTORYSETTINGSRESPONSE;
    public static final int RP_RESPONSESETSMSINDICATIONS;
    public static final int RP_RESPONSESETEMAILINDICATIONS;
    public static final int RP_RESPONSESETPUSHSMS;

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
}

