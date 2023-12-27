/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.functions;

import de.vw.mib.asl.internal.ocu.common.functions.BAPOcuFunctionControllerDelegate;
import de.vw.mib.bap.functions.BAPFunctionController;

public interface BAPOcuFunctionController
extends BAPFunctionController {
    default public void setDelegate(BAPOcuFunctionControllerDelegate bAPOcuFunctionControllerDelegate) {
    }
}

