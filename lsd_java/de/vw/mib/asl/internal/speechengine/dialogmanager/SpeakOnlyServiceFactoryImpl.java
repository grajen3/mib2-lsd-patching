/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.speakonly.SpeakOnlyService;
import de.vw.mib.asl.internal.speechengine.dialogmanager.SpeakOnlyServiceAdapter;
import de.vw.mib.asl.internal.speechengine.dialogmanager.SpeakOnlyServiceFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class SpeakOnlyServiceFactoryImpl
implements SpeakOnlyServiceFactory {
    private final DialogManagerInternal dialogManagerInternal;
    private IntObjectMap speakOnlyServiceAdapter;

    public SpeakOnlyServiceFactoryImpl(DialogManagerInternal dialogManagerInternal) {
        this.dialogManagerInternal = dialogManagerInternal;
        this.speakOnlyServiceAdapter = new IntObjectOptHashMap();
    }

    @Override
    public SpeakOnlyService getSpeakOnlyService(int n) {
        Object object = this.speakOnlyServiceAdapter.get(n);
        if (object == null) {
            object = new SpeakOnlyServiceAdapter(this.dialogManagerInternal, n);
            this.speakOnlyServiceAdapter.put(n, object);
        }
        return (SpeakOnlyService)object;
    }
}

