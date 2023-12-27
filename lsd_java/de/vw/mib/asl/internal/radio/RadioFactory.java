/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmControllerJapan;
import de.vw.mib.asl.internal.radio.amfm.AmfmController;
import de.vw.mib.asl.internal.radio.amfm.AmfmControllerBase;
import de.vw.mib.asl.internal.radio.amfm.AmfmControllerNar;

public final class RadioFactory {
    private RadioFactory() {
    }

    public static AmfmController createAslAmfmDatabase() {
        AmfmControllerBase amfmControllerBase = null;
        if (null == ServiceManager.configManagerDiag) {
            return new AmfmControllerBase();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("RadioFactory - createAslAmfmDatabase - NAR").log();
            }
            amfmControllerBase = new AmfmControllerNar();
        } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(418) || ServiceManager.configManagerDiag.isFeatureFlagSet(423)) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("RadioFactory - createAslAmfmDatabase - JP").log();
            }
            amfmControllerBase = new AmFmControllerJapan();
        } else {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("RadioFactory - createAslAmfmDatabase - EU").log();
            }
            amfmControllerBase = new AmfmControllerBase();
        }
        return amfmControllerBase;
    }
}

