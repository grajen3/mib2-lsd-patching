/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$AdditionalWordDatabasesHandler;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$AsiaInputConfigurator;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$Builder;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$InitializeHandler;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$IntParameterHandler;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$UserDatabaseStateHandler;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;
import edu.emory.mathcs.backport.java.util.ArrayDeque;
import java.util.Iterator;

public abstract class AbstractAsiaInputInitializer
implements AsiaInputInitializer {
    private static final int LOG_CLASSIFIER;
    private static final String LOG_PREFIX;
    protected static Logger LOGGER;
    private AsiaInput asiaInput;
    private ArrayDeque callbacks;
    private boolean initialized;
    private boolean initializing;
    private ArrayDeque asiaInputConfigurators;
    protected int inputMode;
    protected String inputModeName;
    protected int type;
    protected String typeName;
    protected boolean userDatabase;
    protected String[] wordDatabaseNames;

    protected AbstractAsiaInputInitializer(AbstractAsiaInputInitializer$Builder abstractAsiaInputInitializer$Builder) {
        this.inputMode = abstractAsiaInputInitializer$Builder.inputMode;
        this.inputModeName = abstractAsiaInputInitializer$Builder.inputModeName;
        this.type = abstractAsiaInputInitializer$Builder.type;
        this.typeName = abstractAsiaInputInitializer$Builder.typeName;
        this.userDatabase = abstractAsiaInputInitializer$Builder.userDatabase;
        this.wordDatabaseNames = abstractAsiaInputInitializer$Builder.wordDatabaseNames;
    }

    public final AsiaInput getAsiaInput() {
        return this.asiaInput;
    }

    @Override
    public final void initialize(AsiaInput asiaInput, AsiaInputInitializer$Callback asiaInputInitializer$Callback) {
        if (asiaInput != null && !this.initializing && !this.isInitialized()) {
            this.initializing = true;
            asiaInput.addAsiaListener(new AbstractAsiaInputInitializer$InitializeHandler(this));
            this.setAsiaInput(asiaInput);
            this.queueCallback(asiaInputInitializer$Callback);
            this.initializeInternal(asiaInput);
        } else if (this.initializing) {
            this.queueCallback(asiaInputInitializer$Callback);
        }
    }

    protected abstract void initializeInternal(AsiaInput asiaInput) {
    }

    @Override
    public final boolean isInitialized() {
        return this.initialized;
    }

    protected final void setAsiaInput(AsiaInput asiaInput) {
        AsiaInput asiaInput2 = this.asiaInput;
        if (asiaInput2 != asiaInput) {
            this.asiaInput = asiaInput;
            this.asiaInputChanged(asiaInput2, this.asiaInput);
        }
    }

    protected final void setInitialized(boolean bl) {
        boolean bl2 = this.initialized;
        if (bl2 != bl) {
            this.initialized = bl;
            this.initializedChanged(bl2, this.initialized);
        }
    }

    protected void asiaInputChanged(AsiaInput asiaInput, AsiaInput asiaInput2) {
    }

    protected final void dropQueuedAsiaInputConfigurators() {
        if (this.asiaInputConfigurators != null) {
            Iterator iterator = this.asiaInputConfigurators.iterator();
            while (iterator.hasNext()) {
                AbstractAsiaInputInitializer$AsiaInputConfigurator abstractAsiaInputInitializer$AsiaInputConfigurator = (AbstractAsiaInputInitializer$AsiaInputConfigurator)iterator.next();
                if (this.isTraceEnabled()) {
                    this.trace().append("Dropping queued configurator: ").append(abstractAsiaInputInitializer$AsiaInputConfigurator).log();
                }
                iterator.remove();
            }
            this.asiaInputConfigurators = null;
        }
    }

    protected final void dropQueuedCallbacks() {
        if (this.callbacks != null) {
            Iterator iterator = this.callbacks.iterator();
            while (iterator.hasNext()) {
                AsiaInputInitializer$Callback asiaInputInitializer$Callback = (AsiaInputInitializer$Callback)iterator.next();
                if (this.isTraceEnabled()) {
                    this.trace().append("Dropping queued callback: ").append(asiaInputInitializer$Callback).log();
                }
                iterator.remove();
            }
            this.callbacks = null;
        }
    }

    protected final void executeNextQueuedAsiaInputConfigurators() {
        if (this.asiaInputConfigurators != null) {
            AbstractAsiaInputInitializer$AsiaInputConfigurator abstractAsiaInputInitializer$AsiaInputConfigurator = (AbstractAsiaInputInitializer$AsiaInputConfigurator)this.asiaInputConfigurators.pollFirst();
            abstractAsiaInputInitializer$AsiaInputConfigurator.configure(this.getAsiaInput());
        }
    }

    protected final void executeQueuedCallbacks() {
        if (this.callbacks != null) {
            Iterator iterator = this.callbacks.iterator();
            while (iterator.hasNext()) {
                AsiaInputInitializer$Callback asiaInputInitializer$Callback = (AsiaInputInitializer$Callback)iterator.next();
                if (this.isTraceEnabled()) {
                    this.trace().append("Executing queued callback: ").append(asiaInputInitializer$Callback).log();
                }
                asiaInputInitializer$Callback.onInitialized();
                iterator.remove();
            }
            this.callbacks = null;
        }
    }

    protected final boolean hasNextQueuedAsiaInputConfigurators() {
        if (this.asiaInputConfigurators != null) {
            return !this.asiaInputConfigurators.isEmpty();
        }
        return false;
    }

    protected void initializedChanged(boolean bl, boolean bl2) {
        if (bl2) {
            this.initializing = false;
        }
    }

    protected final void onInitialized() {
        if (this.type > -1) {
            this.queueAsiaInputConfigurator(new AbstractAsiaInputInitializer$IntParameterHandler(this, "TYPE", 4, this.typeName, this.type, false));
        }
        if (this.inputMode > -1) {
            this.queueAsiaInputConfigurator(new AbstractAsiaInputInitializer$IntParameterHandler(this, "INPUTMODE", 1, this.inputModeName, this.inputMode));
        }
        this.onQueueAsiaInputConfigurators();
        if (this.userDatabase) {
            this.queueAsiaInputConfigurator(new AbstractAsiaInputInitializer$UserDatabaseStateHandler(this, 0, "UDBSTATE_ON", 1));
        }
        if (this.wordDatabaseNames != null && this.wordDatabaseNames.length > 0) {
            this.queueAsiaInputConfigurator(new AbstractAsiaInputInitializer$AdditionalWordDatabasesHandler(this, this.wordDatabaseNames));
        }
        if (this.hasNextQueuedAsiaInputConfigurators()) {
            this.executeNextQueuedAsiaInputConfigurators();
        } else {
            this.setInitialized(true);
            this.executeQueuedCallbacks();
        }
    }

    protected final void onParameterSet() {
        if (this.hasNextQueuedAsiaInputConfigurators()) {
            this.executeNextQueuedAsiaInputConfigurators();
        } else {
            this.setInitialized(true);
            this.executeQueuedCallbacks();
        }
    }

    protected final void onParameterSetFailed(boolean bl) {
        if (!bl && this.hasNextQueuedAsiaInputConfigurators()) {
            this.executeNextQueuedAsiaInputConfigurators();
        } else {
            this.dropQueuedAsiaInputConfigurators();
            this.dropQueuedCallbacks();
            this.setInitialized(false);
        }
    }

    protected void onQueueAsiaInputConfigurators() {
    }

    protected void onReset() {
        this.dropQueuedCallbacks();
    }

    protected final void queueAsiaInputConfigurator(AbstractAsiaInputInitializer$AsiaInputConfigurator abstractAsiaInputInitializer$AsiaInputConfigurator) {
        if (this.asiaInputConfigurators == null) {
            this.asiaInputConfigurators = new ArrayDeque();
        }
        this.asiaInputConfigurators.add(abstractAsiaInputInitializer$AsiaInputConfigurator);
    }

    private void queueCallback(AsiaInputInitializer$Callback asiaInputInitializer$Callback) {
        if (this.callbacks == null) {
            this.callbacks = new ArrayDeque();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("Queue callback: ").append(asiaInputInitializer$Callback).log();
        }
        this.callbacks.add(asiaInputInitializer$Callback);
    }

    @Override
    public final void reset() {
        this.setInitialized(false);
        this.onReset();
    }

    protected boolean isTraceEnabled() {
        return LOGGER.isTraceEnabled(64);
    }

    protected LogMessage trace() {
        return this.trace("[AbstractAsiaInputInitializer]: ");
    }

    protected final LogMessage trace(String string) {
        return LOGGER.trace(64).append(string);
    }

    protected LogMessage warn() {
        return this.warn("[AbstractAsiaInputInitializer]: ");
    }

    protected final LogMessage warn(String string) {
        return LOGGER.warn(64).append(string);
    }

    static {
        LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    }
}

