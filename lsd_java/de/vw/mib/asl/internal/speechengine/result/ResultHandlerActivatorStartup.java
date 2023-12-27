/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result;

import de.vw.mib.asl.internal.speechengine.result.ResultHandlerServicesImpl;
import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerActivator;
import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerCallback;
import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerParameters;

public class ResultHandlerActivatorStartup
implements ResultHandlerActivator {
    @Override
    public void activate(ResultHandlerCallback resultHandlerCallback, ResultHandlerParameters resultHandlerParameters) {
        ResultHandlerServicesImpl resultHandlerServicesImpl = new ResultHandlerServicesImpl(resultHandlerParameters.getSpeechLogger());
        resultHandlerCallback.onResultHandlerReady(resultHandlerServicesImpl);
    }
}

