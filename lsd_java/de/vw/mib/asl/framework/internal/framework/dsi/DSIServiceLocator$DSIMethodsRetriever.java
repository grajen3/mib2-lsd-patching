/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi;

import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.reflection.MethodsRetriever;
import java.lang.reflect.Method;

class DSIServiceLocator$DSIMethodsRetriever
extends MethodsRetriever {
    private static final Method[] DSI_BASE_MS = (DSIServiceLocator.class$org$dsi$ifc$base$DSIBase == null ? (DSIServiceLocator.class$org$dsi$ifc$base$DSIBase = DSIServiceLocator.class$("org.dsi.ifc.base.DSIBase")) : DSIServiceLocator.class$org$dsi$ifc$base$DSIBase).getDeclaredMethods();
    private static final Method[] DSI_LISTENER_MS = (DSIServiceLocator.class$org$dsi$ifc$base$DSIListener == null ? (DSIServiceLocator.class$org$dsi$ifc$base$DSIListener = DSIServiceLocator.class$("org.dsi.ifc.base.DSIListener")) : DSIServiceLocator.class$org$dsi$ifc$base$DSIListener).getDeclaredMethods();

    DSIServiceLocator$DSIMethodsRetriever() {
    }

    @Override
    public Method[] getMethods(Class clazz) {
        Method[] methodArray;
        if ((DSIServiceLocator.class$org$dsi$ifc$base$DSIBase == null ? (DSIServiceLocator.class$org$dsi$ifc$base$DSIBase = DSIServiceLocator.class$("org.dsi.ifc.base.DSIBase")) : DSIServiceLocator.class$org$dsi$ifc$base$DSIBase).isAssignableFrom(clazz)) {
            Method[] methodArray2 = clazz.getDeclaredMethods();
            methodArray = new Method[DSI_BASE_MS.length + methodArray2.length];
            System.arraycopy((Object)DSI_BASE_MS, 0, (Object)methodArray, 0, DSI_BASE_MS.length);
            System.arraycopy((Object)methodArray2, 0, (Object)methodArray, DSI_BASE_MS.length, methodArray2.length);
        } else if ((DSIServiceLocator.class$org$dsi$ifc$base$DSIListener == null ? (DSIServiceLocator.class$org$dsi$ifc$base$DSIListener = DSIServiceLocator.class$("org.dsi.ifc.base.DSIListener")) : DSIServiceLocator.class$org$dsi$ifc$base$DSIListener).isAssignableFrom(clazz)) {
            Method[] methodArray3 = clazz.getDeclaredMethods();
            methodArray = new Method[DSI_LISTENER_MS.length + methodArray3.length];
            System.arraycopy((Object)DSI_LISTENER_MS, 0, (Object)methodArray, 0, DSI_LISTENER_MS.length);
            System.arraycopy((Object)methodArray3, 0, (Object)methodArray, DSI_LISTENER_MS.length, methodArray3.length);
        } else {
            methodArray = null;
        }
        return methodArray;
    }
}

