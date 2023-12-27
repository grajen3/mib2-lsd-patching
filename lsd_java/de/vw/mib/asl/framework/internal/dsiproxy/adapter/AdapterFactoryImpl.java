/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.adapter;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.internal.dsiproxy.adapter.DSITypePrefixMethodResolver;
import de.vw.mib.asl.framework.internal.dsiproxy.adapter.HsmMethodAdapter;
import de.vw.mib.asl.framework.internal.dsiproxy.adapter.MethodResolver;
import de.vw.mib.asl.framework.internal.dsiproxy.adapter.SimpleMethodAdapter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Constants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import org.dsi.ifc.base.DSIListener;

public final class AdapterFactoryImpl
implements DSIProxyAdapterFactory {
    private static final MethodResolver DSI_TYPE_METHOD_RESOLVER = new DSITypePrefixMethodResolver();

    @Override
    public DSIListener createDSIListenerMethodAdapter(Target target, Class clazz) {
        Utils.checkDSIListenerType(clazz);
        MultipleMethodAccessibleObject multipleMethodAccessibleObject = ServiceManager.reflectionFactory.getTargetsMmao(super.getClass().getName());
        SimpleMethodAdapter simpleMethodAdapter = new SimpleMethodAdapter(target, DSI_TYPE_METHOD_RESOLVER, clazz, multipleMethodAccessibleObject);
        int n = Utils.getTypeIndex(clazz);
        return ServiceManager.reflectionFactory.newListenersProxy(n, Constants.PROXY_OAP, simpleMethodAdapter);
    }

    @Override
    public DSIListener createDSIListenerMethodAdapter(Hsm hsm, Class clazz) {
        Utils.checkDSIListenerType(clazz);
        HsmMethodAdapter hsmMethodAdapter = new HsmMethodAdapter(hsm, DSI_TYPE_METHOD_RESOLVER, clazz);
        int n = Utils.getTypeIndex(clazz);
        return ServiceManager.reflectionFactory.newListenersProxy(n, Constants.PROXY_OAP, hsmMethodAdapter);
    }
}

