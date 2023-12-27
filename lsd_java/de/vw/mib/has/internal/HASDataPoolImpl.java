/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.has.HASClock;
import de.vw.mib.has.HASClockConsumer;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASDatapool;
import de.vw.mib.has.HASException;
import de.vw.mib.has.HASPropertyObserver;
import de.vw.mib.has.HASRegistry;
import de.vw.mib.has.internal.HASConfig;
import de.vw.mib.has.internal.HASContainerBuilder;
import de.vw.mib.has.internal.HASLog;
import de.vw.mib.has.internal.containers.AbstractBaseContainer;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.has.HASDataContainer;

final class HASDataPoolImpl
implements HASDatapool,
HASClockConsumer {
    private static final String LOG_PREFIX;
    private final HASContainerBuilder builder;
    private final HASRegistry registry;
    private final IntObjectOptHashMap properties = new IntObjectOptHashMap();
    private final IntOptHashSet dirtyFlags = new IntOptHashSet();
    private final IntObjectOptHashMap dsiProperties = new IntObjectOptHashMap();
    private final CowArray observers = new CowArray();
    private int updateTime = HASConfig.getPropertyUpdateInterval();

    HASDataPoolImpl(HASContainerBuilder hASContainerBuilder, HASRegistry hASRegistry) {
        this.builder = hASContainerBuilder;
        this.registry = hASRegistry;
    }

    void addObserver(HASPropertyObserver hASPropertyObserver) {
        this.observers.addIfNotAlreadyIn(hASPropertyObserver);
    }

    void removeObserver(HASPropertyObserver hASPropertyObserver) {
        this.observers.remove(hASPropertyObserver);
    }

    @Override
    public synchronized void updateProperty(int n, HASContainer hASContainer) {
        this.updateProperty(n, hASContainer, this.registry.isImmediateProperty(n));
    }

    private void updateProperty(int n, HASContainer hASContainer, boolean bl) {
        HASContainer hASContainer2;
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASDataPoolImpl", "updateProperty", true);
            HASLog.appendPropertyId(logMessage, n, false);
            HASLog.appendBooleanProperty(logMessage, "immediate", bl, true).log();
        }
        if ((hASContainer2 = null != hASContainer ? (HASContainer)this.properties.put(n, hASContainer) : (HASContainer)this.properties.remove(n)) instanceof AbstractBaseContainer) {
            ((AbstractBaseContainer)hASContainer2).release();
        }
        this.dsiProperties.remove(n);
        if (bl) {
            this.notifyObservers(this.observers.getArray(), n);
        } else {
            this.dirtyFlags.add(n);
            this.notifyRequestingObservers(this.observers.getArray(), n);
        }
    }

    @Override
    public synchronized void onClock(HASClock hASClock) {
        this.updateTime -= hASClock.getInterval();
        if (0 >= this.updateTime) {
            this.updateTime = HASConfig.getPropertyUpdateInterval();
            if (!this.dirtyFlags.isEmpty()) {
                Object[] objectArray = this.observers.getArray();
                if (0 < objectArray.length) {
                    IntIterator intIterator = this.dirtyFlags.iterator();
                    while (intIterator.hasNext()) {
                        int n = intIterator.next();
                        this.notifyObservers(objectArray, n);
                    }
                }
                this.dirtyFlags.clear();
            }
        }
    }

    synchronized HASDataContainer[] getDSIProperty(int n) {
        return this.provideDSIProperty(n);
    }

    private HASDataContainer[] provideDSIProperty(int n) {
        HASContainer hASContainer;
        HASDataContainer[] hASDataContainerArray = (HASDataContainer[])this.dsiProperties.get(n);
        if (null == hASDataContainerArray && null != (hASContainer = (HASContainer)this.properties.get(n))) {
            hASDataContainerArray = this.builder.build(hASContainer);
            this.dsiProperties.put(n, hASDataContainerArray);
        }
        return hASDataContainerArray;
    }

    private void notifyObservers(Object[] objectArray, int n) {
        block4: {
            try {
                HASDataContainer[] hASDataContainerArray = null;
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    if (null == hASDataContainerArray) {
                        hASDataContainerArray = this.provideDSIProperty(n);
                    }
                    ((HASPropertyObserver)objectArray[i2]).propertyUpdated(n, hASDataContainerArray);
                }
            }
            catch (HASException hASException) {
                LogMessage logMessage = HASLog.error();
                if (null == logMessage) break block4;
                HASLog.appendPrefixAndMethod(logMessage, "HASDataPoolImpl", "notifyObservers", true);
                logMessage.append("Error building DSI data containers: ").append(hASException.getMessage());
                logMessage.attachThrowable(hASException).log();
            }
        }
    }

    private void notifyRequestingObservers(Object[] objectArray, int n) {
        block4: {
            try {
                HASDataContainer[] hASDataContainerArray = null;
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    HASPropertyObserver hASPropertyObserver = (HASPropertyObserver)objectArray[i2];
                    if (!hASPropertyObserver.isPropertyRequested(n)) continue;
                    if (null == hASDataContainerArray) {
                        hASDataContainerArray = this.provideDSIProperty(n);
                    }
                    hASPropertyObserver.propertyUpdated(n, hASDataContainerArray);
                }
            }
            catch (HASException hASException) {
                LogMessage logMessage = HASLog.error();
                if (null == logMessage) break block4;
                HASLog.appendPrefixAndMethod(logMessage, "HASDataPoolImpl", "notifyRequestingObservers", true);
                logMessage.append("Error building DSI data containers: ").append(hASException.getMessage());
                logMessage.attachThrowable(hASException).log();
            }
        }
    }
}

