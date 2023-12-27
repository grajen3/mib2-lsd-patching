/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache.policies;

import de.vw.mib.cache.policies.MaximumObjectCountCachingPolicy;

public class ZeroObjectCachingPolicy
extends MaximumObjectCountCachingPolicy {
    public ZeroObjectCachingPolicy() {
        super(0);
    }
}

