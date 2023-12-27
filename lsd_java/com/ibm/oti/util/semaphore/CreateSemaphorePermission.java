/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util.semaphore;

import java.security.BasicPermission;

public final class CreateSemaphorePermission
extends BasicPermission {
    static final CreateSemaphorePermission CreateSemaphorePermission = new CreateSemaphorePermission("createSemaphore");

    public CreateSemaphorePermission(String string) {
        super(string);
    }
}

