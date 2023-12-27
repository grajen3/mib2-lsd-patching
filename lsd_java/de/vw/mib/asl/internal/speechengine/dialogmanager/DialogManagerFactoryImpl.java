/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerAdapter;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class DialogManagerFactoryImpl
implements DialogManagerFactory {
    private final DialogManagerInternal dialogManagerInternal;
    private IntObjectMap dialogManagerAdapter;

    public DialogManagerFactoryImpl(DialogManagerInternal dialogManagerInternal) {
        this.dialogManagerInternal = dialogManagerInternal;
        this.dialogManagerAdapter = new IntObjectOptHashMap();
    }

    @Override
    public DialogManager getDialogManager(int n) {
        Object object = this.dialogManagerAdapter.get(n);
        if (object == null) {
            object = new DialogManagerAdapter(this.dialogManagerInternal, n);
            this.dialogManagerAdapter.put(n, object);
        }
        return (DialogManager)object;
    }
}

