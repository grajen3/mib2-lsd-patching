/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common;

import de.vw.mib.bap.mqbpq.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbpq.common.api.FSGService;
import de.vw.mib.bap.mqbpq.common.api.FSGServiceProxy;
import de.vw.mib.log4mib.Logger;

public interface HsmContextDelegate {
    default public Logger getLogger() {
    }

    default public int getSubClassifier() {
    }

    default public BAPFunctionControlUnitExt getLogicalControlUnit() {
    }

    default public FSGServiceProxy getFsgServiceProxy() {
    }

    default public FSGService getFsgService() {
    }
}

