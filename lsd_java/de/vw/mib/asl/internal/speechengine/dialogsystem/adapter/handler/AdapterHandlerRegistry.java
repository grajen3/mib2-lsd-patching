/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class AdapterHandlerRegistry {
    private HashMap registry = new HashMap();
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler;

    public void addHandler(Class clazz, Object object) {
        if (object != null && clazz != null) {
            LinkedList linkedList = (LinkedList)this.registry.get(clazz);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.registry.put(clazz, linkedList);
            }
            linkedList.add(object);
        }
    }

    public void removeHandler(Class clazz, Object object) {
        LinkedList linkedList = (LinkedList)this.registry.get(clazz);
        if (linkedList != null && object != null) {
            linkedList.remove(object);
        }
    }

    protected List getHandlerList(Class clazz) {
        LinkedList linkedList = (LinkedList)this.registry.get(clazz);
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        return (List)linkedList.clone();
    }

    public void asyncException(int n, String string, int n2) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = AdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((AsyncExceptionHandler)list.get(i2)).asyncException(n, string, n2);
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

