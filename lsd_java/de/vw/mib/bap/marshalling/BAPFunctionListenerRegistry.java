/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPConfigVersionCheck;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.BAPFunctionList;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.BAPOperationState;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.PropertyListener;

public interface BAPFunctionListenerRegistry {
    default public BAPFunctionListener getBAPFunctionListener(int n) {
    }

    default public ArrayListener getArrayListener(int n) {
    }

    default public MethodListener getMethodListener(int n) {
    }

    default public PropertyListener getPropertyListener(int n) {
    }

    default public BAPFunctionController getFunctionController(int n) {
    }

    default public BAPConfigVersionCheck getBapConfigVersionCheckFunction() {
    }

    default public BAPFunctionList getFunctionList() {
    }

    default public BAPOperationState getOperationState() {
    }
}

