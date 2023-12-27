/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IReplyService
extends IService {
    default public void setInstanceID(ServiceInstanceID serviceInstanceID) {
    }
}

