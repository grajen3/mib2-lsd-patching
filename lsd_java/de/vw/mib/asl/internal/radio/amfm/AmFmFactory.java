/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmPropertyManager;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmUIStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmUIStationListBase;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmUIStationListNar;
import de.vw.mib.asl.internal.radio.amfm.model.AmFmModelController;
import de.vw.mib.asl.internal.radio.amfm.model.AmFmModelControllerBase;
import de.vw.mib.asl.internal.radio.amfm.model.AmFmModelControllerJapan;
import de.vw.mib.asl.internal.radio.amfm.model.AmFmModelControllerNar;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetList;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetListBase;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetModel;

public final class AmFmFactory {
    private static AmFmUIStationList instanceListViewWalker = null;
    private static AmFmModelController amFmModelController = null;
    private static AmFmPropertyManager amFmPropertyManager = null;

    private AmFmFactory() {
    }

    public static AmFmUIStationList getInstanceEUStationListViewWalker() {
        if (instanceListViewWalker == null) {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmFactory - instanceListViewWalker - NAR").log();
                }
                instanceListViewWalker = new AmFmUIStationListNar();
            } else {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmFactory - instanceListViewWalker - Base").log();
                }
                instanceListViewWalker = new AmFmUIStationListBase();
            }
        }
        return instanceListViewWalker;
    }

    public static AmFmModelController getAslAmfmModelController() {
        if (amFmModelController == null) {
            if (null == ServiceManager.configManagerDiag) {
                if (null != ServiceManager.logger) {
                    ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmFactory - getAslAmfmModelController() - null == ServiceManager.configManagerDiag").log();
                }
                amFmModelController = new AmFmModelControllerBase();
                return amFmModelController;
            }
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmFactory - amFmModelController - NAR").log();
                }
                amFmModelController = new AmFmModelControllerNar();
            } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(418) || ServiceManager.configManagerDiag.isFeatureFlagSet(423)) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmFactory - amFmModelController - Japan").log();
                }
                amFmModelController = new AmFmModelControllerJapan();
            } else {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmFactory - amFmModelController - Base").log();
                }
                amFmModelController = new AmFmModelControllerBase();
            }
        }
        return amFmModelController;
    }

    public static AmFmPropertyManager getAslAmfmPropertyManager() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmFactory - amFmPropertyManager").log();
        }
        if (amFmPropertyManager == null) {
            amFmPropertyManager = new AmFmPropertyManager();
        }
        return amFmPropertyManager;
    }

    public static AmFmPresetList getAmFmPresetList(AmFmPresetModel amFmPresetModel, int n, int n2) {
        AmFmPresetListBase amFmPresetListBase = null;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmFactory - amFmPresetList - Base").log();
        }
        amFmPresetListBase = new AmFmPresetListBase(amFmPresetModel, n, n2);
        return amFmPresetListBase;
    }
}

