/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.requests;

import de.vw.mib.bap.datatypes.BAPMethod;

public interface ResultMethod
extends BAPMethod {
    default public int getResultCode() {
    }
}

