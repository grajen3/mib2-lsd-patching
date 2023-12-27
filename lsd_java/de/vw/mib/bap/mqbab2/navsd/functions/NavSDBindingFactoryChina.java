/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.navsd.functions.FunctionListChina;
import de.vw.mib.bap.mqbab2.navsd.functions.NavSDBindingFactoryAll;

public class NavSDBindingFactoryChina
extends NavSDBindingFactoryAll {
    @Override
    public BAPStage createNewFunctionListStage() {
        return new FunctionListChina();
    }

    @Override
    public BAPStage createNewAltitudeStage() {
        return null;
    }
}

