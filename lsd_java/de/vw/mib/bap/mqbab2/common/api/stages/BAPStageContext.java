/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;

public interface BAPStageContext
extends BAPFunctionControllerDelegate {
    default public void updateStages(BAPStage bAPStage, int[] nArray, Object object) {
    }

    default public BAPEntity dequeueBAPEntity(BAPStage bAPStage, Class clazz) {
    }

    default public int getLogicalControlUnitID() {
    }
}

