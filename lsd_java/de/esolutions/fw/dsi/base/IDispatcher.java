/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.dsi.diag.DispatcherInfo;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;

public interface IDispatcher {
    default public IReplyService getService() {
    }

    default public void addUnconfirmedNotificationListener(int n, DSIListener dSIListener) {
    }

    default public void addNotificationListener(int n, DSIListener dSIListener) {
    }

    default public void removeNotificationListener(int n, DSIListener dSIListener) {
    }

    default public void removeNotificationListener(DSIListener dSIListener) {
    }

    default public boolean hasNotificationListeners(int n) {
    }

    default public Iterator getNotificationListenerIterator(int n) {
    }

    default public Iterator getUnconfirmedNotificationListenerIterator(int n) {
    }

    default public void confirmNotificationListener(int n, DSIListener dSIListener) {
    }

    default public DispatcherInfo getDispatcherInfo(int n) {
    }

    default public void clearNotificationListeners() {
    }
}

