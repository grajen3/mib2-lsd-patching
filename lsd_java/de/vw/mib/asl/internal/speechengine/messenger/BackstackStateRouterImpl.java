/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger;

import de.vw.mib.asl.api.speechengine.messenger.backstack.BackstackStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.backstack.BackstackStateRouter;
import de.vw.mib.asl.internal.speechengine.messenger.BackstackStatePublisher;
import java.util.ArrayList;
import java.util.List;

public class BackstackStateRouterImpl
implements BackstackStatePublisher,
BackstackStateRouter {
    private final List backstackStateConsumer = new ArrayList();

    @Override
    public void register(BackstackStateConsumer backstackStateConsumer) {
        this.backstackStateConsumer.add(backstackStateConsumer);
    }

    @Override
    public void unregister(BackstackStateConsumer backstackStateConsumer) {
        this.backstackStateConsumer.remove(backstackStateConsumer);
    }

    @Override
    public void publishBackstackState(int n) {
        for (int i2 = 0; i2 < this.backstackStateConsumer.size(); ++i2) {
            BackstackStateConsumer backstackStateConsumer = (BackstackStateConsumer)this.backstackStateConsumer.get(i2);
            backstackStateConsumer.onBackstackStateChanged(n);
        }
    }
}

