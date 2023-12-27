/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tollcollect;

import org.dsi.ifc.base.DSIBase;

public interface DSITollCollect
extends DSIBase {
    public static final String VERSION;
    public static final int RP_REQUESTPAYMENTHISTORYLISTRESULT;
    public static final int RP_REQUESTPAYMENTHISTORYDETAILSRESULT;
    public static final int RP_SETLANGUAGERESPONSE;
    public static final int ATTR_CARDSTATE;
    public static final int ATTR_CARDERROR;
    public static final int ATTR_CARDDATEINFORMATION;
    public static final int ATTR_HARDWAREINFORMATION;
    public static final int ATTR_CURRENTTOLLPAYMENT;
    public static final int RT_REQUESTPAYMENTHISTORYLIST;
    public static final int RT_REQUESTPAYMENTHISTORYDETAILS;
    public static final int RT_SETLANGUAGE;
    public static final int CARDSTATE_UNKNOWN;
    public static final int CARDSTATE_NO_CARD_INSERTED;
    public static final int CARDSTATE_CARD_OK;
    public static final int CARDSTATE_CARD_ERROR;
    public static final int CARDSTATE_SETUP_OK;
    public static final int CARDERROR_UNKNOWN;
    public static final int CARDERROR_NO_ERROR;
    public static final int CARDERROR_ETC_NOT_REGISTERED;
    public static final int CARDERROR_INFRASTRUCTURE_COMMUNICATION_ERROR;
    public static final int CARDERROR_TCCARD_DEFECT;
    public static final int CARDERROR_TCCARD_NOT_INSERTED;
    public static final int CARDERROR_READ_ERROR;
    public static final int CARDERROR_WRITE_ERROR;
    public static final int CARDERROR_ETC_GATE_COMMUNICATION_ERROR;
    public static final int CARDERROR_ETC_GATE_NOT_USABLE;
    public static final int CARDERROR_DANGER_ETC_GATE_NOT_USABLE;
    public static final int CARDERROR_TC_CARD_EXPIRED;
    public static final int CARDERROR_TC_UNIT_ERROR;
    public static final int CARDERROR_TC_SYSTEM_FAILURE;
    public static final int CARDERROR_ETC_READER_NOT_REGISTERED;
    public static final int HWINFO_MODEL_NAME;
    public static final int HWINFO_MANUFACTURE_NAME;
    public static final int HWINFO_IDENTIFICATION_NUMBER;
    public static final int HWINFO_REG_MODEL_NAME;
    public static final int HWINFO_SERIAL_PRODUCT_NUMBER;

    default public void requestPaymentHistoryList() {
    }

    default public void requestPaymentHistoryDetails(int n) {
    }

    default public void setLanguage(String string) {
    }
}

