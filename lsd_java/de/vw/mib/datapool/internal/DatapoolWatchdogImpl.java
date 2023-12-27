/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.internal.AbstractDatapool;
import de.vw.mib.datapool.internal.DatapoolWatchdog;
import de.vw.mib.datapool.internal.DatapoolWatchdogHandler;
import de.vw.mib.datapool.internal.DatapoolWatchdogImpl$DefaultDatapoolWatchdogHandler;
import de.vw.mib.datapool.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.SpellerData;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;

final class DatapoolWatchdogImpl
implements DatapoolWatchdog,
Runnable {
    static Logger logger = ServiceManager.loggerFactory.getLogger(8);
    private static final int NO_HASH;
    final IntObjectMap objectSetterStacktraces = new IntObjectOptHashMap();
    private final long interval;
    private final IntIntMap objectHashes = new IntIntOptHashMap();
    private final IntObjectMap objectValues;
    private Thread thread;
    private final DatapoolWatchdogHandler watchdogHandler;

    DatapoolWatchdogImpl(AbstractDatapool abstractDatapool, long l) {
        this(abstractDatapool, l, null);
    }

    DatapoolWatchdogImpl(AbstractDatapool abstractDatapool, long l, DatapoolWatchdogHandler datapoolWatchdogHandler) {
        this.interval = l;
        this.watchdogHandler = datapoolWatchdogHandler != null ? datapoolWatchdogHandler : new DatapoolWatchdogImpl$DefaultDatapoolWatchdogHandler(this);
        this.objectValues = abstractDatapool.getObjectValues();
        this.computeHashes();
        abstractDatapool.registerDatapoolWatchdog(this);
    }

    @Override
    public void run() {
        int n = 0;
        Thread thread = Thread.currentThread();
        while (this.thread == thread) {
            try {
                Thread.sleep(this.interval);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            if (this.thread != thread || this.checkDatapoolValues() || ++n != 20) continue;
            return;
        }
    }

    @Override
    public void checkNewDatapoolValue(int n, Object object) {
        this.storeStacktrace(n, object);
        if (!this.isSameHash(n, object, true) && this.isSameObject(n, object)) {
            this.watchdogHandler.onSetPropertyWithSameObject(n, object);
        }
    }

    void startWatchdog() {
        if (this.interval < 0) {
            return;
        }
        if (this.thread != null) {
            return;
        }
        this.thread = new Thread(this, "Datapool-Watchdog");
        this.thread.start();
    }

    void stopWatchdog() {
        Thread thread = this.thread;
        this.thread = null;
        if (thread != null) {
            thread.interrupt();
        }
    }

    private boolean checkDatapoolValues() {
        logger.info(32, "checking datapool values ...");
        try {
            Iterator iterator = this.objectValues.entryIterator();
            while (iterator.hasNext()) {
                Object object;
                IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
                int n = intObjectMap$Entry.getKey();
                if (this.isSameHash(n, object = intObjectMap$Entry.getValue(), false)) continue;
                this.watchdogHandler.onPropertyObjectHasChanged(n, object);
            }
        }
        catch (Exception exception) {
            logger.error(32, "error while checking datapool!", exception);
            return false;
        }
        logger.info(32, "checking datapool finished!");
        return true;
    }

    private int computeHash(Object object) {
        if (object == null) {
            return 128;
        }
        if (object instanceof FixFormatterFieldData) {
            return this.computeHash((FixFormatterFieldData)object);
        }
        if (object instanceof LabeledIconValue) {
            return this.computeHash((LabeledIconValue)object);
        }
        if (object instanceof ResourceLocator) {
            return this.computeHash((ResourceLocator)object);
        }
        if (object instanceof SpellerData) {
            return this.computeHash((SpellerData)object);
        }
        if (object.getClass().isArray()) {
            Class clazz = object.getClass().getComponentType();
            if (clazz.isPrimitive()) {
                if (clazz == Boolean.TYPE) {
                    return Arrays.hashCode((boolean[])object);
                }
                if (clazz == Integer.TYPE) {
                    return Arrays.hashCode((int[])object);
                }
            } else {
                return Arrays.deepHashCode((Object[])object);
            }
        }
        return object.hashCode();
    }

    private int computeHash(FixFormatterFieldData fixFormatterFieldData) {
        int n = fixFormatterFieldData.hashCode();
        Iterator iterator = fixFormatterFieldData.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            n += this.computeHash(fixFormatterFieldData.getString(string));
        }
        return n;
    }

    private int computeHash(LabeledIconValue labeledIconValue) {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (labeledIconValue.getResourceLocator() == null ? 0 : this.computeHash(labeledIconValue.getResourceLocator()));
        n2 = 31 * n2 + (labeledIconValue.getText() == null ? 0 : labeledIconValue.getText().hashCode());
        n2 = 31 * n2 + (labeledIconValue.getTextRenderingInfo() == null ? 0 : labeledIconValue.getTextRenderingInfo().toString().hashCode());
        return n2;
    }

    private int computeHash(ResourceLocator resourceLocator) {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + resourceLocator.id;
        n2 = 31 * n2 + (resourceLocator.url == null ? 0 : resourceLocator.url.hashCode());
        return n2;
    }

    private int computeHash(SpellerData spellerData) {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (spellerData.getAvailableCharacters() == null ? 0 : spellerData.getAvailableCharacters().hashCode());
        n2 = 31 * n2 + spellerData.getCursorPosition();
        n2 = 31 * n2 + (spellerData.getEnteredText() == null ? 0 : spellerData.getEnteredText().hashCode());
        n2 = 31 * n2 + (spellerData.getMatchCompletion() == null ? 0 : spellerData.getMatchCompletion().hashCode());
        n2 = 31 * n2 + spellerData.getMatchCount();
        n2 = 31 * n2 + (spellerData.getMatchText() == null ? 0 : spellerData.getMatchText().hashCode());
        n2 = 31 * n2 + spellerData.getSelectionEnd();
        n2 = 31 * n2 + spellerData.getSelectionStart();
        n2 = 31 * n2 + (spellerData.getUnavailableCharacters() == null ? 0 : spellerData.getUnavailableCharacters().hashCode());
        n2 = 31 * n2 + Arrays.hashCode(spellerData.getWordDatabaseNames());
        return n2;
    }

    private void computeHashes() {
        Iterator iterator = this.objectValues.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = this.computeHash(intObjectMap$Entry.getValue());
            this.objectHashes.put(intObjectMap$Entry.getKey(), n);
        }
    }

    private boolean isSameHash(int n, Object object, boolean bl) {
        int n2 = this.computeHash(object);
        int n3 = this.objectHashes.get(n);
        if (bl) {
            this.objectHashes.put(n, n2);
        }
        return n2 == n3;
    }

    private boolean isSameObject(int n, Object object) {
        return this.objectValues.get(n) == object;
    }

    private void storeStacktrace(int n, Object object) {
        String string = new StringBuffer().append("").append(object).toString();
        if (object != null && object.getClass().isArray()) {
            Class clazz = object.getClass().getComponentType();
            if (clazz.isPrimitive()) {
                if (clazz == Boolean.TYPE) {
                    string = Arrays.toString((boolean[])object);
                }
                if (clazz == Integer.TYPE) {
                    string = Arrays.toString((int[])object);
                }
            } else {
                string = Arrays.toString((Object[])object);
            }
        }
        this.objectSetterStacktraces.put(n, new Exception(new StringBuffer().append("set datapool property '").append(n).append("': ").append(string).toString()));
    }
}

