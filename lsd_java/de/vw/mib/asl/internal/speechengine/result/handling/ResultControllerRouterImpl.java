/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultSession;
import de.vw.mib.asl.api.speechengine.result.model.ResultCollection;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;

public final class ResultControllerRouterImpl
implements ResultControllerRouter {
    private final ResultSession session;
    private final IntObjectMap modelControllers = new IntObjectOptHashMap();
    private final IntObjectMap recognitionControllers = new IntObjectOptHashMap();
    private final IntIntMap routingStrategies = new IntIntOptHashMap();
    private final Logger logger;
    private final int clientId;
    private int activeController = -1;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$result$handling$ResultControllerRouterImpl;

    public ResultControllerRouterImpl(Logger logger, int n, ResultSession resultSession) {
        this.logger = logger;
        this.clientId = n;
        this.session = resultSession;
    }

    @Override
    public void register(ModelEventConsumer modelEventConsumer, int n) {
        this.register(modelEventConsumer, n, 1);
    }

    @Override
    public void register(RecognizedEventConsumer recognizedEventConsumer, int n) {
        this.register(recognizedEventConsumer, n, 1);
    }

    @Override
    public void register(ModelEventConsumer modelEventConsumer, int n, int n2) {
        if (this.modelControllers.containsKey(n)) {
            this.logger.error(8, this.getMessage(modelEventConsumer, n));
            return;
        }
        this.modelControllers.put(n, modelEventConsumer);
        this.routingStrategies.put(n, n2);
    }

    @Override
    public void register(RecognizedEventConsumer recognizedEventConsumer, int n, int n2) {
        if (this.recognitionControllers.containsKey(n)) {
            this.logger.error(8, this.getMessage(recognizedEventConsumer, n));
            return;
        }
        this.recognitionControllers.put(n, recognizedEventConsumer);
        this.routingStrategies.put(n, n2);
    }

    @Override
    public void onRecognizedResult(int n, ResultCollection resultCollection) {
        this.session.add(resultCollection);
        int n2 = resultCollection.getEventId();
        RecognizedEventConsumer recognizedEventConsumer = (RecognizedEventConsumer)this.recognitionControllers.get(n2);
        if (recognizedEventConsumer != null) {
            this.evaluateActivationStrategy(n2);
            this.routeEvent(recognizedEventConsumer, n2);
        } else if (this.activeController != -1) {
            RecognizedEventConsumer recognizedEventConsumer2 = (RecognizedEventConsumer)this.recognitionControllers.get(this.activeController);
            if (recognizedEventConsumer2 != null) {
                this.routeEvent(recognizedEventConsumer2, n2);
            } else {
                ModelEventConsumer modelEventConsumer = (ModelEventConsumer)this.modelControllers.get(this.activeController);
                if (modelEventConsumer != null && modelEventConsumer instanceof RecognizedEventConsumer) {
                    ((RecognizedEventConsumer)((Object)modelEventConsumer)).onRecognizedEvent(n2);
                }
            }
        } else {
            this.handleError(n2);
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        ModelEventConsumer modelEventConsumer = (ModelEventConsumer)this.modelControllers.get(n);
        if (modelEventConsumer != null) {
            this.evaluateActivationStrategy(n);
            this.routeEvent(modelEventConsumer, eventGeneric);
        } else if (this.activeController != -1) {
            ModelEventConsumer modelEventConsumer2 = (ModelEventConsumer)this.modelControllers.get(this.activeController);
            if (modelEventConsumer2 != null) {
                modelEventConsumer2.onEvent(eventGeneric);
            } else {
                RecognizedEventConsumer recognizedEventConsumer = (RecognizedEventConsumer)this.recognitionControllers.get(this.activeController);
                if (recognizedEventConsumer != null && recognizedEventConsumer instanceof ModelEventConsumer) {
                    ((ModelEventConsumer)((Object)recognizedEventConsumer)).onEvent(eventGeneric);
                }
            }
        } else {
            this.handleError(eventGeneric);
        }
    }

    public int getActiveController() {
        return this.activeController;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(new StringBuffer().append("activeController = ").append(this.activeController).toString()).append("; ");
        stringBuilder.append("recognitionControllers = ").append(this.recognitionControllers.toString()).append("; ");
        stringBuilder.append("modelControllers = ").append(this.modelControllers.toString()).append("; ");
        stringBuilder.append("routingStrategies = ").append(this.routingStrategies.toString()).append("; ");
        return stringBuilder.toString();
    }

    private void routeEvent(RecognizedEventConsumer recognizedEventConsumer, int n) {
        recognizedEventConsumer.onRecognizedEvent(n);
    }

    private void routeEvent(ModelEventConsumer modelEventConsumer, EventGeneric eventGeneric) {
        modelEventConsumer.onEvent(eventGeneric);
    }

    private void handleError(int n) {
        RecognizedEventConsumer recognizedEventConsumer = (RecognizedEventConsumer)this.recognitionControllers.get(-1);
        if (recognizedEventConsumer != null) {
            recognizedEventConsumer.onRecognizedEvent(n);
        }
    }

    private void handleError(EventGeneric eventGeneric) {
        ModelEventConsumer modelEventConsumer = (ModelEventConsumer)this.modelControllers.get(-1);
        if (modelEventConsumer != null) {
            modelEventConsumer.onEvent(eventGeneric);
        }
    }

    private String getMessage(Object object, int n) {
        String string = new StringBuffer().append((class$de$vw$mib$asl$internal$speechengine$result$handling$ResultControllerRouterImpl == null ? (class$de$vw$mib$asl$internal$speechengine$result$handling$ResultControllerRouterImpl = ResultControllerRouterImpl.class$("de.vw.mib.asl.internal.speechengine.result.handling.ResultControllerRouterImpl")) : class$de$vw$mib$asl$internal$speechengine$result$handling$ResultControllerRouterImpl).getName()).append(", clash detected on controllers routing table for client id: ").append(this.clientId).append(". The event id '").append(n).append("' has been already registered for controller ").append(object.getClass().getName()).append(", hashcode: ").append(object.hashCode()).toString();
        return string;
    }

    private void evaluateActivationStrategy(int n) {
        if (this.routingStrategies.containsKey(n) && this.routingStrategies.get(n) == 1) {
            this.activeController = n;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

