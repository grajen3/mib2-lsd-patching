/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.shader;

import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.shader.Shader;
import java.util.List;

public final class ShaderCache
extends LRUCache {
    private final HashCodeBuilder hcb = new HashCodeBuilder();

    public ShaderCache() {
        super(new UnlimitedCachingPolicy(), true);
    }

    public int getMaximumCacheSizeBytes() {
        return 0;
    }

    public Shader get(int n, int n2, List list) {
        this.hcb.reset();
        this.hcb.append(n);
        this.hcb.append(n2);
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            this.hcb.append((String)list.get(i2));
        }
        long l = this.hcb.longHashCode();
        return (Shader)this.get(l);
    }

    public void put(int n, int n2, List list, Shader shader) {
        this.hcb.reset();
        this.hcb.append(n);
        this.hcb.append(n2);
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            this.hcb.append((String)list.get(i2));
        }
        long l = this.hcb.longHashCode();
        this.put(l, shader);
    }
}

