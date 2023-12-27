/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.sdars.SiriusSubscriptionState;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;

public class SiriusSubscriptionStateImpl
implements SiriusSubscriptionState {
    @Override
    public int getSiriusSubscriptionState() {
        int n = 0;
        try {
            boolean bl = ASLRadioFactory.getRadioApi().isWavebandAvailable(3);
            if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("SiriusSubscriptionStateImpl - getSiriusSubscriptionState() - sdarsBandAvailable - ").append(bl).append("null != SatDb.getInstance().getPool() - ").append(null != SatDb.getInstance().getPool()).log();
            }
            if (bl && null != SatDb.getInstance().getPool()) {
                n = SatDb.getInstance().getPool().getInt(2);
                if (ServiceManager.logger.isTraceEnabled(512)) {
                    ServiceManager.logger.trace(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("sdarsSubscriptionStatus - ").append(n).log();
                }
                return n;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return n;
    }
}

