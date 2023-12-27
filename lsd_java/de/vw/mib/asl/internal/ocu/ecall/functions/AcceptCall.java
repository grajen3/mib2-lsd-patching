/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;

public final class AcceptCall
extends ECallFunction
implements MethodListener {
    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 19;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public void result(BAPEntity bAPEntity, Method method) {
    }
}

