/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.config.util;

import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.EngineHashHelper;

final class EngineHelperInt
extends EngineHashHelper {
    private final int mKey;

    EngineHelperInt(Engine engine, int n) {
        super(engine);
        this.mKey = n;
    }

    @Override
    public int hashCode(int n) {
        return this.mEngine.hashCode(this.mKey, n);
    }

    @Override
    public boolean isKey(int n) {
        return this.mEngine.getInt(n) == this.mKey;
    }
}

