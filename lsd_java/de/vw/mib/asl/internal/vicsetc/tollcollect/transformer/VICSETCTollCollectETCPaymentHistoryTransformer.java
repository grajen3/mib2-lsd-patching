/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.tollcollect.transformer;

import de.vw.mib.asl.internal.vicsetc.tollcollect.transformer.VICSETCTollCollectETCPaymentHistoryCollector;
import generated.de.vw.mib.asl.internal.vicsetc.tollcollect.transformer.AbstractVICSETCTollCollectETCPaymentHistoryTransformer;

public class VICSETCTollCollectETCPaymentHistoryTransformer
extends AbstractVICSETCTollCollectETCPaymentHistoryTransformer {
    @Override
    public int getInt(int n, Object object) {
        VICSETCTollCollectETCPaymentHistoryCollector vICSETCTollCollectETCPaymentHistoryCollector = (VICSETCTollCollectETCPaymentHistoryCollector)object;
        switch (n) {
            case 0: {
                return vICSETCTollCollectETCPaymentHistoryCollector.getDay();
            }
            case 5: {
                return vICSETCTollCollectETCPaymentHistoryCollector.getGateCost();
            }
            case 4: {
                return vICSETCTollCollectETCPaymentHistoryCollector.getHour();
            }
            case 3: {
                return vICSETCTollCollectETCPaymentHistoryCollector.getMinute();
            }
            case 1: {
                return vICSETCTollCollectETCPaymentHistoryCollector.getMonth();
            }
            case 2: {
                return vICSETCTollCollectETCPaymentHistoryCollector.getYear();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        VICSETCTollCollectETCPaymentHistoryCollector vICSETCTollCollectETCPaymentHistoryCollector = (VICSETCTollCollectETCPaymentHistoryCollector)object;
        switch (n) {
            case 6: {
                return vICSETCTollCollectETCPaymentHistoryCollector.getEntranceIC();
            }
            case 7: {
                return vICSETCTollCollectETCPaymentHistoryCollector.getExitIC();
            }
            case 8: {
                return vICSETCTollCollectETCPaymentHistoryCollector.getInformationGateCost();
            }
        }
        throw new IllegalArgumentException();
    }
}

