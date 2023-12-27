/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.amFm.FmFrequencyScale;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;

public class FmFrequencyScaleImpl
implements FmFrequencyScale {
    @Override
    public int getFmFrequencyScale() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("FmFrequencyScaleImpl - getFmFrequencyScale()").log();
        }
        if (null != RadioData.getAmfmDatabase() && ASLRadioFactory.getRadioApi().isWavebandAvailable(1)) {
            return RadioData.getAmfmDatabase().getSettingsPersistable().getFmRangeOption();
        }
        return 0;
    }
}

