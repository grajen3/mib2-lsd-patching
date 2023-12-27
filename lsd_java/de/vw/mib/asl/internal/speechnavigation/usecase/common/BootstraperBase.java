/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common;

import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.genericevents.AbstractTarget;

public abstract class BootstraperBase {
    protected final AbstractTarget target;
    protected final ResultHandler resultHandler;

    public BootstraperBase(ResultHandler resultHandler) {
        this(null, resultHandler);
    }

    public BootstraperBase(AbstractTarget abstractTarget, ResultHandler resultHandler) {
        this.target = abstractTarget;
        this.resultHandler = resultHandler;
    }

    public abstract void initialize() {
    }
}

