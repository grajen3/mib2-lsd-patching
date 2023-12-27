/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public class FoDState
extends ENIFunction
implements PropertyListener {
    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 32;
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }
}

