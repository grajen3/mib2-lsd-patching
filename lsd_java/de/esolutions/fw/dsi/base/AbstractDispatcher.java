/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.dsi.admin.ListenerTracker;
import de.esolutions.fw.dsi.base.IDispatcher;
import de.esolutions.fw.dsi.base.ListenerMap;
import de.esolutions.fw.dsi.diag.DispatcherInfo;
import de.esolutions.fw.dsi.diag.IAdapterErrorLog;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.tracing.TraceChannel;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;

public abstract class AbstractDispatcher
implements IDispatcher {
    protected static final int CONFIRMATION_FLAG;
    protected int instance;
    protected String listenerClassName;
    protected TraceChannel tracer;
    protected boolean isShortNoSuchMethodTrace = false;
    private ListenerMap confirmedListeners;
    private ListenerMap unconfirmedListeners;
    private IAdapterErrorLog errorLog;

    public void setErrorLog(IAdapterErrorLog iAdapterErrorLog) {
        this.errorLog = iAdapterErrorLog;
    }

    public AbstractDispatcher(int n, String string) {
        this.instance = n;
        this.listenerClassName = string;
        this.tracer = Channels.DSI_DISPATCHER;
        this.confirmedListeners = new ListenerMap();
        this.unconfirmedListeners = new ListenerMap();
        if (System.getProperty("ipl.shorttrace.nosuchmethod") != null) {
            this.isShortNoSuchMethodTrace = true;
        }
    }

    public synchronized Object[] getResponseListenerList() {
        return ListenerTracker.getInstance().getDSIListener(this.listenerClassName, this.instance);
    }

    @Override
    public synchronized void addUnconfirmedNotificationListener(int n, DSIListener dSIListener) {
        this.unconfirmedListeners.add(n, dSIListener);
        this.tracer.log((short)1, "Unconfirmed notification listener added: attribute=%1, listener=%2", (Object)Integer.toString(n), (Object)super.getClass().getName());
    }

    @Override
    public synchronized void addNotificationListener(int n, DSIListener dSIListener) {
        this.confirmedListeners.add(n, dSIListener);
        this.tracer.log((short)1, "Notification listener added: attribute=%1, listener=%2", (Object)Integer.toString(n), (Object)super.getClass().getName());
    }

    @Override
    public synchronized void removeNotificationListener(int n, DSIListener dSIListener) {
        this.confirmedListeners.remove(n, dSIListener);
        this.unconfirmedListeners.remove(n, dSIListener);
        this.tracer.log((short)1, "Notification listener removed: attribute=%1, listener=%2", (Object)Integer.toString(n), (Object)super.getClass().getName());
    }

    @Override
    public synchronized void clearNotificationListeners() {
        this.confirmedListeners.clear();
        this.unconfirmedListeners.clear();
    }

    @Override
    public synchronized boolean hasNotificationListeners(int n) {
        return this.confirmedListeners.has(n) || this.unconfirmedListeners.has(n);
    }

    @Override
    public synchronized Iterator getNotificationListenerIterator(int n) {
        return this.confirmedListeners.iterate(n);
    }

    @Override
    public synchronized Iterator getUnconfirmedNotificationListenerIterator(int n) {
        return this.unconfirmedListeners.iterate(n);
    }

    @Override
    public synchronized void confirmNotificationListener(int n, DSIListener dSIListener) {
        this.unconfirmedListeners.remove(n, dSIListener);
        this.confirmedListeners.add(n, dSIListener);
        this.tracer.log((short)1, "Notification listener confirmed: attribute=%1, listener=%2", (Object)Integer.toString(n), (Object)super.getClass().getName());
    }

    @Override
    public synchronized void removeNotificationListener(DSIListener dSIListener) {
        this.unconfirmedListeners.remove(dSIListener);
        this.confirmedListeners.remove(dSIListener);
    }

    protected void traceException(Exception exception) {
        if (exception instanceof NoSuchMethodException && this.isShortNoSuchMethodTrace) {
            this.tracer.log((short)4, "Dispatcher Failed: class=%1 exception=%2 ", (Object)super.getClass().getName(), (Object)exception.getMessage());
        } else {
            this.tracer.log((short)4, "Dispatcher Failed: class=%1 exception=%2", (Object)super.getClass().getName(), (Object)exception);
        }
        this.addDispatcherError(new StringBuffer().append("DispatcherFailed class=").append(super.getClass().getName()).append(" exception=").append(exception.getMessage()).toString());
    }

    @Override
    public DispatcherInfo getDispatcherInfo(int n) {
        return this.createDispatcherInfo(n, null);
    }

    private DispatcherInfo createDispatcherInfo(int n, String string) {
        return new DispatcherInfo(n, this, this.instance, this.listenerClassName, string);
    }

    private void addDispatcherError(String string) {
        if (this.errorLog != null) {
            int n = this.errorLog.getAbsoluteDispatcherErrors();
            DispatcherInfo dispatcherInfo = this.createDispatcherInfo(n, string);
            this.errorLog.addDispatcherError(dispatcherInfo);
        }
    }
}

