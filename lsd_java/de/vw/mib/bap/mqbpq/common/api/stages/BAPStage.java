/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;

public interface BAPStage
extends BAPFunctionController {
    public static final int BAP_STAGE_UPDATE_ID_UNKNOWN;

    default public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
    }

    default public void setDelegate(BAPStageContext bAPStageContext) {
    }

    default public void process(int n) {
    }

    default public boolean hmiEvent(int n) {
    }

    default public void setFunctionData(BAPStage bAPStage, Object object) {
    }
}

