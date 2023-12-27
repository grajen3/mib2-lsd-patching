/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tollcollect;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public interface DSITollCollectListener
extends DSIListener {
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
}

