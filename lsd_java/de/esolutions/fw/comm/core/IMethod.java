/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IService;

public interface IMethod {
    default public void invoke() {
    }

    default public IService getService() {
    }

    default public short getMethodID() {
    }
}

