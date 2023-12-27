/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.config.util;

import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.EngineHelperInt;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.EngineHelperLong;

abstract class EngineHashHelper {
    protected final Engine mEngine;

    EngineHashHelper(Engine engine) {
        this.mEngine = engine;
    }

    static EngineHashHelper assemble(Engine engine, int n) {
        return new EngineHelperInt(engine, n);
    }

    static EngineHashHelper assemble(Engine engine, long l) {
        return new EngineHelperLong(engine, l);
    }

    abstract int hashCode(int n) {
    }

    abstract boolean isKey(int n) {
    }
}

