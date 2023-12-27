/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.component;

import de.vw.mib.asl.framework.api.framework.component.ASLComponent;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.collections.copyonwrite.CowArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ASLComponentRegistryImpl
implements ASLComponentRegistry {
    private final Map components = Collections.synchronizedMap(new HashMap());
    private final Map apis = new HashMap();
    private final Map requests = new HashMap();

    @Override
    public void registerASLComponent(ASLComponent aSLComponent) {
        this.components.put(aSLComponent.getName(), aSLComponent);
    }

    @Override
    public ASLComponent getASLComponent(String string) {
        return (ASLComponent)this.components.get(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerAPI(Class clazz, Object object) {
        Object[] objectArray;
        Map map = this.apis;
        synchronized (map) {
            this.apis.put(clazz, object);
            CowArray cowArray = (CowArray)this.requests.get(clazz);
            if (null != cowArray) {
                objectArray = cowArray.getArray();
                this.requests.remove(clazz);
            } else {
                objectArray = null;
            }
        }
        if (null != objectArray) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    ((ASLComponentAPICallback)objectArray[i2]).registered(clazz, object);
                    continue;
                }
                catch (RuntimeException runtimeException) {
                    ServiceManager.loggerFWCore.error().append("ASLComponentAPICallback failed").attachThrowable(runtimeException).log();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object getAPIInstance(Class clazz) {
        Map map = this.apis;
        synchronized (map) {
            return this.apis.get(clazz);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestAPI(Class clazz, ASLComponentAPICallback aSLComponentAPICallback) {
        Object object;
        Map map = this.apis;
        synchronized (map) {
            object = this.apis.get(clazz);
            if (null == object) {
                CowArray cowArray = (CowArray)this.requests.get(clazz);
                if (null == cowArray) {
                    cowArray = new CowArray();
                    this.requests.put(clazz, cowArray);
                }
                cowArray.addIfNotAlreadyIn(aSLComponentAPICallback);
            }
        }
        if (null != object) {
            aSLComponentAPICallback.registered(clazz, object);
        }
    }
}

