/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.router;

import de.vw.mib.asl.api.speechengine.result.router.RecognizedResultConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedResultRouter;
import de.vw.mib.asl.internal.speechengine.result.RecognizedResultPublisher;
import de.vw.mib.asl.internal.speechengine.result.model.ResultCollectionImpl;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.speechrec.NBestList;

public class RecognizedResultRouterImpl
implements RecognizedResultRouter,
RecognizedResultPublisher {
    private Logger logger;
    private IntObjectMap registeredConsumers;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$result$router$RecognizedResultRouterImpl;

    public RecognizedResultRouterImpl(Logger logger) {
        this.logger = logger;
        this.registeredConsumers = new IntObjectOptHashMap();
    }

    @Override
    public void register(int n, RecognizedResultConsumer recognizedResultConsumer) {
        if (!this.registeredConsumers.containsKey(n)) {
            this.registeredConsumers.put(n, new ArrayList());
        }
        ((List)this.registeredConsumers.get(n)).add(recognizedResultConsumer);
    }

    @Override
    public void unregister(int n, RecognizedResultConsumer recognizedResultConsumer) {
        if (this.registeredConsumers.containsKey(n)) {
            ((List)this.registeredConsumers.get(n)).remove(recognizedResultConsumer);
        }
    }

    @Override
    public void register(RecognizedResultConsumer recognizedResultConsumer) {
        this.register(0, recognizedResultConsumer);
    }

    @Override
    public void unregister(RecognizedResultConsumer recognizedResultConsumer) {
        IntIterator intIterator = this.registeredConsumers.keySet().iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            this.unregister(n, recognizedResultConsumer);
        }
    }

    @Override
    public void publish(int n, int n2, NBestList nBestList) {
        ArrayList arrayList = new ArrayList();
        List list = (List)this.registeredConsumers.get(0);
        List list2 = (List)this.registeredConsumers.get(n);
        if (list != null) {
            arrayList.addAll(list);
        }
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        if (arrayList.isEmpty()) {
            this.logger.warn(8, this.toError(n, n2, nBestList));
        } else {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                RecognizedResultConsumer recognizedResultConsumer = (RecognizedResultConsumer)arrayList.get(i2);
                if (recognizedResultConsumer == null) continue;
                recognizedResultConsumer.onRecognizedResult(n, new ResultCollectionImpl(n2, nBestList));
            }
        }
    }

    private String toError(int n, int n2, NBestList nBestList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append((class$de$vw$mib$asl$internal$speechengine$result$router$RecognizedResultRouterImpl == null ? (class$de$vw$mib$asl$internal$speechengine$result$router$RecognizedResultRouterImpl = RecognizedResultRouterImpl.class$("de.vw.mib.asl.internal.speechengine.result.router.RecognizedResultRouterImpl")) : class$de$vw$mib$asl$internal$speechengine$result$router$RecognizedResultRouterImpl).getName()).append("]").append(", ");
        stringBuilder.append("no client registered, to handle the recognized result:").append("{");
        stringBuilder.append("context id: ").append(n).append(", ");
        stringBuilder.append("recognized event id: ").append(n2).append(", ");
        stringBuilder.append("recognized result: ").append(nBestList.toString()).append("}");
        return stringBuilder.toString();
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

