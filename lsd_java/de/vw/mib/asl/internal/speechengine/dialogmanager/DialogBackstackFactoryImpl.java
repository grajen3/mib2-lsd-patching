/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstack;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogBackstackAdapter;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogBackstackFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class DialogBackstackFactoryImpl
implements DialogBackstackFactory {
    private IntObjectMap dialogBackstackAdapter;
    private final DialogManagerInternal dialogManagerInternal;

    public DialogBackstackFactoryImpl(DialogManagerInternal dialogManagerInternal) {
        this.dialogManagerInternal = dialogManagerInternal;
        this.dialogBackstackAdapter = new IntObjectOptHashMap();
    }

    @Override
    public DialogBackstack geDialogBackstack(int n) {
        Object object = this.dialogBackstackAdapter.get(n);
        if (object == null) {
            object = new DialogBackstackAdapter(this.dialogManagerInternal, n);
            this.dialogBackstackAdapter.put(n, object);
        }
        return (DialogBackstack)object;
    }
}

