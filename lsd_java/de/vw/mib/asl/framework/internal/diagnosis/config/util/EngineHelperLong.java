/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.config.util;

import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.EngineHashHelper;

final class EngineHelperLong
extends EngineHashHelper {
    private final long mKey;

    EngineHelperLong(Engine engine, long l) {
        super(engine);
        this.mKey = l;
    }

    @Override
    public int hashCode(int n) {
        return this.mEngine.hashCode(this.mKey, n);
    }

    @Override
    public boolean isKey(int n) {
        return this.mEngine.getLong(n) == this.mKey;
    }
}

