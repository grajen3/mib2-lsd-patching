/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterData;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataConsumer;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerImpl;

public class TeleprompterDataManagerAdapter
implements TeleprompterDataManager {
    protected static DialogManagerLogger logger = new DialogManagerLogger("[TeleprompterDataManagerAdapter] ");
    private final TeleprompterDataManagerImpl teleprompterDataManagerImpl;
    private final int clientId;

    public TeleprompterDataManagerAdapter(TeleprompterDataManagerImpl teleprompterDataManagerImpl, int n) {
        this.teleprompterDataManagerImpl = teleprompterDataManagerImpl;
        this.clientId = n;
    }

    @Override
    public void register(TeleprompterDataConsumer teleprompterDataConsumer) {
        if (logger.isTraceEnabled()) {
            this.trace("register()");
        }
        this.teleprompterDataManagerImpl.register(teleprompterDataConsumer);
    }

    @Override
    public void unregister(TeleprompterDataConsumer teleprompterDataConsumer) {
        if (logger.isTraceEnabled()) {
            this.trace("unregister()");
        }
        this.teleprompterDataManagerImpl.unregister(teleprompterDataConsumer);
    }

    @Override
    public TeleprompterData getTeleprompterData() {
        if (logger.isTraceEnabled()) {
            this.trace("getTeleprompterData()");
        }
        return this.teleprompterDataManagerImpl.getTeleprompterData();
    }

    private void trace(String string) {
        logger.trace().append("triggered ").append(string).append(" from client: ").append(SpeechClientIdentifiersUtil.toString(this.clientId)).log();
    }
}

