/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.handler.DefaultAsiaStateProxy$AsiaStateCollector;
import de.vw.mib.widgets.speller.asia.handler.DefaultAsiaStateProxy$AsiaStateProxyHolder;
import edu.emory.mathcs.backport.java.util.ArrayDeque;
import java.util.Iterator;
import org.dsi.ifc.asiainput.UserDefinedEntry;

public final class DefaultAsiaStateProxy
implements AsiaStateProxy {
    private static final int STATE_REQUESTS_PRIORITIZED;
    private static final int STATE_REQUESTS_DEFAULT;
    private static final int STATE_REQUESTS_FOLLOWING;
    protected static final Logger LOGGER;
    protected AsiaDatabase asia;
    private int currentStateRequestQueue = 1;
    private CowList stateHandlerRegistry;
    private final ArrayDeque[] stateRequestQueues = new ArrayDeque[]{new ArrayDeque(), new ArrayDeque(), new ArrayDeque()};
    private DefaultAsiaStateProxy$AsiaStateCollector stateRequestExecuted;
    private boolean stateRequestInProgress;
    private long totalStateRequestTimeStart;
    private long singleStateRequestTimeStart;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$org$dsi$ifc$asiainput$UserDefinedEntry;

    public static DefaultAsiaStateProxy getProxy(AsiaDatabase asiaDatabase) {
        DefaultAsiaStateProxy defaultAsiaStateProxy = DefaultAsiaStateProxy$AsiaStateProxyHolder.PROXY.setAsia(asiaDatabase);
        return defaultAsiaStateProxy;
    }

    protected DefaultAsiaStateProxy() {
        this.stateHandlerRegistry = CowList.EMPTY;
    }

    @Override
    public AsiaDatabase getAsia() {
        return this.asia;
    }

    public DefaultAsiaStateProxy setAsia(AsiaDatabase asiaDatabase) {
        AsiaDatabase asiaDatabase2 = this.asia;
        if (asiaDatabase2 != asiaDatabase || !asiaDatabase.isInitialized()) {
            this.asia = asiaDatabase;
            this.asiaChanged(asiaDatabase2, asiaDatabase);
        }
        return this;
    }

    protected void asiaChanged(AsiaDatabase asiaDatabase, AsiaDatabase asiaDatabase2) {
        this.stateHandlerRegistry = CowList.EMPTY;
        this.clearQueuedStateRequests();
    }

    @Override
    public void getState(int n, AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.getState(n, null, abstractAsiaStateHandler);
    }

    @Override
    public void getState(int n, IntObjectMap intObjectMap, AbstractAsiaStateHandler abstractAsiaStateHandler) {
        if (this.stateHandlerRegistry.contains(abstractAsiaStateHandler)) {
            AbstractAsiaStateHandler abstractAsiaStateHandler2 = abstractAsiaStateHandler;
            try {
                abstractAsiaStateHandler2 = (AbstractAsiaStateHandler)abstractAsiaStateHandler.clone();
                abstractAsiaStateHandler.reset();
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                this.warn(new StringBuffer().append("Unable to clone state handler '").append(super.getClass().getName()).append("'!").toString());
            }
            abstractAsiaStateHandler2.setRequestedStates(n);
            DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector = new DefaultAsiaStateProxy$AsiaStateCollector(this, n, abstractAsiaStateHandler2.stateParameters, this.asia, abstractAsiaStateHandler2);
            this.checkStateRequest(defaultAsiaStateProxy$AsiaStateCollector);
            if (!this.queuePrioritizedStateRequest(defaultAsiaStateProxy$AsiaStateCollector)) {
                this.queueStateRequest(defaultAsiaStateProxy$AsiaStateCollector);
            }
        } else {
            this.trace(new StringBuffer().append("getState ( ").append(this.traceStates(n)).append(" ) [SKIPPED] - ").append(abstractAsiaStateHandler).toString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onStateRequestFinished(DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector, AsiaDatabase asiaDatabase, AsiaDatabaseState asiaDatabaseState, AbstractAsiaStateHandler abstractAsiaStateHandler, int n) {
        boolean bl = defaultAsiaStateProxy$AsiaStateCollector.isCancelled();
        boolean bl2 = defaultAsiaStateProxy$AsiaStateCollector.isObsolete();
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("onStateRequestFinished: Duration: ( ").append(this.traceStates(n)).append(" ) [").append(ServiceManager.timerManager.getSystemTimeMillis() - this.totalStateRequestTimeStart).append("ms]").append(bl ? " [CANCELLED]" : "").append(bl2 ? " [OBSOLETE]" : "").append(" - ").append(defaultAsiaStateProxy$AsiaStateCollector.getStateHandler()).toString());
        }
        asiaDatabase.removeAsiaListener(defaultAsiaStateProxy$AsiaStateCollector);
        boolean bl3 = false;
        this.enableStateRequestQueue(2);
        try {
            if (this.stateRequestInProgress && !bl) {
                if (!bl2) {
                    abstractAsiaStateHandler.asiaReceivedAsiaDatabaseState(asiaDatabaseState);
                } else {
                    defaultAsiaStateProxy$AsiaStateCollector.reset();
                    if (this.stateRequestQueues[0].isEmpty()) {
                        bl3 = true;
                    } else {
                        this.queueStateRequest(defaultAsiaStateProxy$AsiaStateCollector);
                    }
                }
            }
        }
        finally {
            this.enableStateRequestQueue(1);
            this.stateRequestInProgress = false;
            this.stateRequestExecuted = null;
            if (bl3) {
                this.executeStateRequest(defaultAsiaStateProxy$AsiaStateCollector);
            } else {
                this.executeNextQueuedStateRequest();
            }
        }
    }

    protected void onStateRequestPartlyFinished(DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector, AsiaDatabase asiaDatabase, AsiaDatabaseState asiaDatabaseState, AbstractAsiaStateHandler abstractAsiaStateHandler, int n) {
        if (this.isTraceEnabled()) {
            long l = ServiceManager.timerManager.getSystemTimeMillis();
            this.trace(new StringBuffer().append("onStateRequestPartlyFinished: Duration ( ").append(this.traceStates(n)).append(" ) [").append(l - this.singleStateRequestTimeStart).append("ms] - ").append(defaultAsiaStateProxy$AsiaStateCollector.getStateHandler()).toString());
            this.singleStateRequestTimeStart = l;
        }
    }

    private void cancelQueuedStateRequest(int n, int n2) {
        ArrayDeque arrayDeque = this.stateRequestQueues[n];
        Iterator iterator = arrayDeque.iterator();
        while (iterator.hasNext()) {
            DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector = (DefaultAsiaStateProxy$AsiaStateCollector)iterator.next();
            int n3 = defaultAsiaStateProxy$AsiaStateCollector.getStates();
            if ((n3 & n2) <= 0) continue;
            defaultAsiaStateProxy$AsiaStateCollector.cancel();
        }
    }

    private void cancelQueuedStateRequests() {
        if (this.stateRequestQueues != null) {
            for (int i2 = 0; i2 < this.stateRequestQueues.length; ++i2) {
                ArrayDeque arrayDeque = this.stateRequestQueues[i2];
                if (arrayDeque == null) continue;
                Iterator iterator = arrayDeque.iterator();
                while (iterator.hasNext()) {
                    DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector = (DefaultAsiaStateProxy$AsiaStateCollector)iterator.next();
                    defaultAsiaStateProxy$AsiaStateCollector.cancel();
                }
            }
        }
    }

    private void clearQueuedStateRequests() {
        for (int i2 = 0; i2 < this.stateRequestQueues.length; ++i2) {
            ArrayDeque arrayDeque = this.stateRequestQueues[i2];
            if (arrayDeque == null) continue;
            arrayDeque.clear();
        }
        this.stateRequestInProgress = false;
    }

    private void checkStateRequest(DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector) {
        int n = defaultAsiaStateProxy$AsiaStateCollector.getStates();
        if ((n & 0x100) > 0) {
            if (this.stateRequestInProgress && this.stateRequestExecuted != null) {
                this.stateRequestExecuted.cancel();
            }
            this.cancelQueuedStateRequests();
        } else if ((n & 0x1000) > 0 && this.stateRequestInProgress && this.stateRequestExecuted != null) {
            int n2 = this.stateRequestExecuted.getStates();
            if ((n2 & 4) > 0 || (n2 & 0x800) > 0 || (n2 & 0x40) > 0 || (n2 & 0x80) > 0) {
                this.stateRequestExecuted.obsolete();
            }
            this.cancelQueuedStateRequest(0, 4096);
        }
    }

    @Override
    public void deregisterStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.stateHandlerRegistry = this.stateHandlerRegistry.remove(abstractAsiaStateHandler);
    }

    private void enableStateRequestQueue(int n) {
        this.currentStateRequestQueue = n;
    }

    private void executeNextQueuedStateRequest() {
        DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector = this.getNextQueuedStateRequest();
        this.executeStateRequest(defaultAsiaStateProxy$AsiaStateCollector);
    }

    private void executeStateRequest(DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector) {
        if (defaultAsiaStateProxy$AsiaStateCollector != null) {
            int n = defaultAsiaStateProxy$AsiaStateCollector.getStates();
            if (defaultAsiaStateProxy$AsiaStateCollector.isCancelled()) {
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("executeStateRequest( ").append(this.traceStates(n)).append(" ) [CANCELLED] - ").append(defaultAsiaStateProxy$AsiaStateCollector.getStateHandler()).toString());
                    this.traceQueues();
                }
                this.executeNextQueuedStateRequest();
                return;
            }
            if (this.isTraceEnabled()) {
                this.totalStateRequestTimeStart = this.singleStateRequestTimeStart = ServiceManager.timerManager.getSystemTimeMillis();
                this.trace(new StringBuffer().append("executeStateRequest( ").append(this.traceStates(n)).append(" ) - ").append(defaultAsiaStateProxy$AsiaStateCollector.getStateHandler()).toString());
                this.traceQueues();
            }
            this.stateRequestInProgress = true;
            this.stateRequestExecuted = defaultAsiaStateProxy$AsiaStateCollector;
            if ((n & 0x400) > 0) {
                Object object = defaultAsiaStateProxy$AsiaStateCollector.getParameter(0);
                if (object != null && object.getClass() == (class$java$lang$String == null ? (class$java$lang$String = DefaultAsiaStateProxy.class$("java.lang.String")) : class$java$lang$String)) {
                    String string = (String)object;
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(1024);
                    for (int i2 = 0; i2 < string.length(); ++i2) {
                        this.asia.addSymbol(string.charAt(i2));
                    }
                }
                this.onStateRequestFinished(defaultAsiaStateProxy$AsiaStateCollector, this.asia, AsiaDatabaseState.EMPTY_STATE, defaultAsiaStateProxy$AsiaStateCollector.getStateHandler(), n);
            } else if ((n & 0x10) > 0 || (n & 2) > 0 || (n & 1) > 0) {
                this.asia.addAsiaListener(defaultAsiaStateProxy$AsiaStateCollector);
                if ((n & 0x10) > 0 && (n & 4) > 0 && (n & 8) > 0) {
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(4);
                    this.asia.getPhrases();
                } else {
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(16);
                    this.asia.buildCandidates();
                }
            } else if ((n & 2) > 0) {
                this.asia.addAsiaListener(defaultAsiaStateProxy$AsiaStateCollector);
                defaultAsiaStateProxy$AsiaStateCollector.setNextState(2);
                this.asia.getSpelling();
            } else if ((n & 4) > 0) {
                this.asia.addAsiaListener(defaultAsiaStateProxy$AsiaStateCollector);
                defaultAsiaStateProxy$AsiaStateCollector.setNextState(4);
                this.asia.getPhrases();
            } else if ((n & 8) > 0) {
                this.asia.addAsiaListener(defaultAsiaStateProxy$AsiaStateCollector);
                defaultAsiaStateProxy$AsiaStateCollector.setNextState(8);
                this.asia.getCursorPosition();
            } else if ((n & 0x20) > 0) {
                Object object = defaultAsiaStateProxy$AsiaStateCollector.getParameter(0);
                Object object2 = defaultAsiaStateProxy$AsiaStateCollector.getParameter(100);
                if (object != null && object.getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = DefaultAsiaStateProxy.class$("java.lang.Integer")) : class$java$lang$Integer)) {
                    this.asia.addAsiaListener(defaultAsiaStateProxy$AsiaStateCollector);
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(32);
                    this.asia.selectCandidate((Integer)object);
                } else if (object2 != null && object2.getClass() == (class$java$lang$String == null ? (class$java$lang$String = DefaultAsiaStateProxy.class$("java.lang.String")) : class$java$lang$String)) {
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(32);
                    this.asia.selectCandidate((String)object2);
                    this.onStateRequestFinished(defaultAsiaStateProxy$AsiaStateCollector, this.asia, AsiaDatabaseState.EMPTY_STATE, defaultAsiaStateProxy$AsiaStateCollector.getStateHandler(), n);
                } else {
                    this.onStateRequestFinished(defaultAsiaStateProxy$AsiaStateCollector, this.asia, AsiaDatabaseState.EMPTY_STATE, defaultAsiaStateProxy$AsiaStateCollector.getStateHandler(), n);
                }
            } else if ((n & 0x40) > 0) {
                this.asia.addAsiaListener(defaultAsiaStateProxy$AsiaStateCollector);
                Object object = defaultAsiaStateProxy$AsiaStateCollector.getParameter(0);
                if (object != null && object.getClass() == (class$java$lang$String == null ? (class$java$lang$String = DefaultAsiaStateProxy.class$("java.lang.String")) : class$java$lang$String)) {
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(64);
                    this.asia.getSegmentation((String)object);
                } else {
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(4);
                    this.asia.getPhrases();
                }
            } else if ((n & 0x80) > 0) {
                Object object = defaultAsiaStateProxy$AsiaStateCollector.getParameter(0);
                if (object != null && object.getClass() == (class$org$dsi$ifc$asiainput$UserDefinedEntry == null ? (class$org$dsi$ifc$asiainput$UserDefinedEntry = DefaultAsiaStateProxy.class$("org.dsi.ifc.asiainput.UserDefinedEntry")) : class$org$dsi$ifc$asiainput$UserDefinedEntry)) {
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(128);
                    this.asia.addUserDefinedEntry((UserDefinedEntry)object);
                    this.onStateRequestFinished(defaultAsiaStateProxy$AsiaStateCollector, this.asia, AsiaDatabaseState.EMPTY_STATE, defaultAsiaStateProxy$AsiaStateCollector.getStateHandler(), n);
                } else {
                    this.asia.addAsiaListener(defaultAsiaStateProxy$AsiaStateCollector);
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(4);
                    this.asia.getPhrases();
                }
            } else if ((n & 0x100) > 0) {
                defaultAsiaStateProxy$AsiaStateCollector.setNextState(256);
                this.asia.clear();
                this.onStateRequestFinished(defaultAsiaStateProxy$AsiaStateCollector, this.asia, AsiaDatabaseState.EMPTY_STATE, defaultAsiaStateProxy$AsiaStateCollector.getStateHandler(), n);
            } else if ((n & 0x200) > 0) {
                defaultAsiaStateProxy$AsiaStateCollector.setNextState(512);
                this.asia.initialize();
                this.onStateRequestFinished(defaultAsiaStateProxy$AsiaStateCollector, this.asia, AsiaDatabaseState.EMPTY_STATE, defaultAsiaStateProxy$AsiaStateCollector.getStateHandler(), n);
            } else if ((n & 0x800) > 0) {
                this.asia.addAsiaListener(defaultAsiaStateProxy$AsiaStateCollector);
                defaultAsiaStateProxy$AsiaStateCollector.setNextState(2048);
                this.asia.getPredictionContext();
            } else if ((n & 0x1000) > 0) {
                Object object = defaultAsiaStateProxy$AsiaStateCollector.getParameter(0);
                Object object3 = defaultAsiaStateProxy$AsiaStateCollector.getParameter(1);
                if (object != null && object.getClass() == (class$java$lang$String == null ? (class$java$lang$String = DefaultAsiaStateProxy.class$("java.lang.String")) : class$java$lang$String)) {
                    defaultAsiaStateProxy$AsiaStateCollector.setNextState(4096);
                    this.asia.setPhrases((String)object);
                    if (object3 != null && object3.getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = DefaultAsiaStateProxy.class$("java.lang.Integer")) : class$java$lang$Integer)) {
                        this.asia.setCursorPosition((Integer)object3);
                    }
                    this.onStateRequestFinished(defaultAsiaStateProxy$AsiaStateCollector, this.asia, AsiaDatabaseState.EMPTY_STATE, defaultAsiaStateProxy$AsiaStateCollector.getStateHandler(), n);
                } else {
                    this.onStateRequestFinished(defaultAsiaStateProxy$AsiaStateCollector, this.asia, AsiaDatabaseState.EMPTY_STATE, defaultAsiaStateProxy$AsiaStateCollector.getStateHandler(), n);
                }
            } else {
                this.onStateRequestFinished(defaultAsiaStateProxy$AsiaStateCollector, this.asia, AsiaDatabaseState.EMPTY_STATE, defaultAsiaStateProxy$AsiaStateCollector.getStateHandler(), 64);
            }
        }
    }

    private DefaultAsiaStateProxy$AsiaStateCollector getNextQueuedStateRequest() {
        DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector = null;
        ArrayDeque arrayDeque = this.stateRequestQueues[0];
        if (!arrayDeque.isEmpty()) {
            defaultAsiaStateProxy$AsiaStateCollector = (DefaultAsiaStateProxy$AsiaStateCollector)arrayDeque.pollFirst();
        } else {
            arrayDeque = this.stateRequestQueues[2];
            if (!arrayDeque.isEmpty()) {
                defaultAsiaStateProxy$AsiaStateCollector = (DefaultAsiaStateProxy$AsiaStateCollector)arrayDeque.pollFirst();
            } else {
                arrayDeque = this.stateRequestQueues[1];
                defaultAsiaStateProxy$AsiaStateCollector = (DefaultAsiaStateProxy$AsiaStateCollector)arrayDeque.pollFirst();
            }
        }
        return defaultAsiaStateProxy$AsiaStateCollector;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean queuePrioritizedStateRequest(DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector) {
        int n = defaultAsiaStateProxy$AsiaStateCollector.getStates();
        int n2 = this.currentStateRequestQueue;
        boolean bl = false;
        if ((n & 0x1000) > 0) {
            bl |= true;
        }
        if (bl) {
            this.enableStateRequestQueue(0);
            try {
                this.queueStateRequest(defaultAsiaStateProxy$AsiaStateCollector);
            }
            finally {
                this.enableStateRequestQueue(n2);
            }
        }
        return bl;
    }

    private void queueStateRequest(DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector) {
        ArrayDeque arrayDeque = this.stateRequestQueues[this.currentStateRequestQueue];
        arrayDeque.addLast(defaultAsiaStateProxy$AsiaStateCollector);
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("queueStateRequest: ( ").append(this.traceStates(defaultAsiaStateProxy$AsiaStateCollector.getStates())).append(" ) - ").append(defaultAsiaStateProxy$AsiaStateCollector.getStateHandler()).toString());
            this.traceQueues();
        }
        if (!this.stateRequestInProgress) {
            this.executeNextQueuedStateRequest();
        }
    }

    @Override
    public void registerStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.stateHandlerRegistry = this.stateHandlerRegistry.addIfAbsent(abstractAsiaStateHandler);
    }

    protected boolean isTraceEnabled() {
        return LOGGER.isTraceEnabled(64);
    }

    protected void trace(Object object) {
        if (this.isTraceEnabled()) {
            LOGGER.trace(64).append("[DefaultAsiaStateProxy]: ").append(object).log();
        }
    }

    protected void traceQueues() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < this.stateRequestQueues.length; ++i2) {
            Iterator iterator = this.stateRequestQueues[i2].iterator();
            stringBuilder.append(" {").append(i2).append("} ");
            while (iterator.hasNext()) {
                DefaultAsiaStateProxy$AsiaStateCollector defaultAsiaStateProxy$AsiaStateCollector = (DefaultAsiaStateProxy$AsiaStateCollector)iterator.next();
                stringBuilder.append("[");
                stringBuilder.append(this.traceStates(defaultAsiaStateProxy$AsiaStateCollector.getStates()));
                stringBuilder.append("]");
                if (!iterator.hasNext()) continue;
                stringBuilder.append("->");
            }
        }
        this.trace(new StringBuffer().append("Queues:").append(stringBuilder.toString()).toString());
    }

    protected String traceStates(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((n & 0x40) > 0) {
            stringBuilder.append("NONE");
        }
        if ((n & 0x10) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("BUILD");
        }
        if ((n & 1) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("CANDIDATES");
        }
        if ((n & 2) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("SPELLING");
        }
        if ((n & 4) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("PHRASES");
        }
        if ((n & 8) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("CURSORPOSITION");
        }
        if ((n & 0x20) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("SELECT");
        }
        if ((n & 0x40) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("SEGMENTATION");
        }
        if ((n & 0x80) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("USERDEFINEDENTRY");
        }
        if ((n & 0x100) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("CLEAR");
        }
        if ((n & 0x200) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("INIT");
        }
        if ((n & 0x400) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("ADDSYMBOL");
        }
        if ((n & 0x800) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("PREDICTION");
        }
        if ((n & 0x1000) > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append("SETPHRASES");
        }
        return stringBuilder.toString();
    }

    protected void warn(Object object) {
        LOGGER.warn(64).append("[DefaultAsiaStateProxy]: ").append(object).log();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    }
}

