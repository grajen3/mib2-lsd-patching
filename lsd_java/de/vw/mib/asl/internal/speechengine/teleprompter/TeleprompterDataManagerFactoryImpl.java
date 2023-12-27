/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerAdapter;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerFactory;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerImpl;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerLogger;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.Logger;

public class TeleprompterDataManagerFactoryImpl
implements TeleprompterDataManagerFactory {
    private final TeleprompterDataManagerImpl teleprompterDataManagerImpl;
    private IntObjectMap teleprompterDataManagerAdapter;

    public TeleprompterDataManagerFactoryImpl(DialogManagerInternal dialogManagerInternal, Logger logger) {
        TeleprompterDataManagerLogger.setStaticLogger(logger);
        this.teleprompterDataManagerImpl = new TeleprompterDataManagerImpl(dialogManagerInternal);
        this.teleprompterDataManagerAdapter = new IntObjectOptHashMap();
    }

    @Override
    public TeleprompterDataManager getTeleprompterDataManager(int n) {
        Object object = this.teleprompterDataManagerAdapter.get(n);
        if (object == null) {
            object = new TeleprompterDataManagerAdapter(this.teleprompterDataManagerImpl, n);
            this.teleprompterDataManagerAdapter.put(n, object);
        }
        return (TeleprompterDataManager)object;
    }
}

