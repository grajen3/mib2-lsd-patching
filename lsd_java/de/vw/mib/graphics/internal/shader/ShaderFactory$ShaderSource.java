/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.shader;

import de.vw.mib.cache.Cacheable;

final class ShaderFactory$ShaderSource
implements Cacheable {
    public final String source;

    public ShaderFactory$ShaderSource(String string) {
        this.source = string;
    }

    @Override
    public int getByteSize() {
        return this.source.length() * 2;
    }
}

