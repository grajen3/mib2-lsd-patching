/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.Property;

public interface BAPDisplayFunctionControllerDelegate {
    default public Array getArray(BAPFunctionController bAPFunctionController) {
    }

    default public Method getMethod(BAPFunctionController bAPFunctionController) {
    }

    default public Property getProperty(BAPFunctionController bAPFunctionController) {
    }
}

