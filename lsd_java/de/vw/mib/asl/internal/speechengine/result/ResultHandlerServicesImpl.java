/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result;

import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultSession;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedResultRouter;
import de.vw.mib.asl.internal.speechengine.result.RecognizedResultPublisher;
import de.vw.mib.asl.internal.speechengine.result.ResultHandlerServicesImpl$1;
import de.vw.mib.asl.internal.speechengine.result.handling.ResultControllerRouterImpl;
import de.vw.mib.asl.internal.speechengine.result.handling.ResultItemHandlerImpl;
import de.vw.mib.asl.internal.speechengine.result.handling.ResultListHandlerImpl;
import de.vw.mib.asl.internal.speechengine.result.handling.ResultSessionFactoryImpl;
import de.vw.mib.asl.internal.speechengine.result.router.RecognizedResultRouterImpl;
import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerServices;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.Logger;

public class ResultHandlerServicesImpl
implements ResultHandlerServices {
    final ResultSessionFactoryImpl resultSessionFactory;
    final RecognizedResultRouterImpl recognizedResultRouter;
    final IntObjectMap clients = new IntObjectOptHashMap();
    final Logger logger;

    public ResultHandlerServicesImpl(Logger logger) {
        this.logger = logger;
        this.resultSessionFactory = new ResultSessionFactoryImpl();
        this.recognizedResultRouter = new RecognizedResultRouterImpl(logger);
    }

    @Override
    public RecognizedResultPublisher getRecognizedResultPublisher() {
        return this.recognizedResultRouter;
    }

    private RecognizedResultRouter getRecognizedResultRouter() {
        return this.recognizedResultRouter;
    }

    @Override
    public ResultHandler getResultHandler(int n) {
        ResultSession resultSession = this.resultSessionFactory.create();
        ResultListHandlerImpl resultListHandlerImpl = new ResultListHandlerImpl(resultSession);
        ResultItemHandlerImpl resultItemHandlerImpl = new ResultItemHandlerImpl(resultSession);
        if (!this.clients.containsKey(n)) {
            ResultControllerRouterImpl resultControllerRouterImpl = new ResultControllerRouterImpl(this.logger, n, resultSession);
            this.clients.put(n, new ResultHandlerServicesImpl$1(this, resultSession, resultControllerRouterImpl, resultListHandlerImpl, resultItemHandlerImpl));
            this.getRecognizedResultRouter().register(n, resultControllerRouterImpl);
        }
        return (ResultHandler)this.clients.get(n);
    }
}

