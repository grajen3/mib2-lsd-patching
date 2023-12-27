/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.PropertyListener;

public interface BAPFunctionControllerDelegate {
    default public ArrayListener getArrayListener(BAPFunctionController bAPFunctionController) {
    }

    default public MethodListener getMethodListener(BAPFunctionController bAPFunctionController) {
    }

    default public PropertyListener getPropertyListener(BAPFunctionController bAPFunctionController) {
    }
}

