/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultSession;
import de.vw.mib.asl.internal.speechengine.result.handling.ResultSessionFactory;
import de.vw.mib.asl.internal.speechengine.result.handling.ResultSessionImpl;

public class ResultSessionFactoryImpl
implements ResultSessionFactory {
    @Override
    public ResultSession create() {
        return new ResultSessionImpl();
    }
}

