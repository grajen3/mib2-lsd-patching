/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect;

import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public interface DSITollCollectReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateCardState(int n, int n2) {
    }

    default public void updateCardError(TCCardError tCCardError, int n) {
    }

    default public void updateCardDateInformation(TCCardDateInformation tCCardDateInformation, int n) {
    }

    default public void updateHardwareInformation(TCHardwareInformation[] tCHardwareInformationArray, int n) {
    }

    default public void updateCurrentTollPayment(NavPriceInfo navPriceInfo, int n) {
    }

    default public void requestPaymentHistoryListResult(TCPaymentInfo[] tCPaymentInfoArray) {
    }

    default public void requestPaymentHistoryDetailsResult(int n, TCPaymentInfoDetails tCPaymentInfoDetails) {
    }

    default public void setLanguageResponse(boolean bl) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

