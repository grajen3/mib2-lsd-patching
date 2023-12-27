/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.Property;

public interface BAPFunctionRegistry {
    default public BAPFunction getBAPFunction(int n) {
    }

    default public Array getArray(int n) {
    }

    default public Method getMethod(int n) {
    }

    default public Property getProperty(int n) {
    }

    default public FSGOperationState getBapFSGOperationStateFunction() {
    }
}

