/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.debug.spi.DebugListener;
import de.vw.mib.debugmanager.internal.CallbackMessageDecoder;
import de.vw.mib.debugmanager.internal.CallbackMessageDecoder$CallbackDecoderListener;
import de.vw.mib.debugmanager.performance.PerformanceIndicatorListener;
import de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.backend.ConfigurationChangeListener;

final class CallbackManager
implements CallbackMessageDecoder$CallbackDecoderListener,
DebugListener {
    private final boolean mlp_enabled;
    private final CallbackMessageDecoder callbackDecoder;
    private final CowArray performanceIndicatorListeners = new CowArray();
    private final IntObjectMap unifiedLoggingCallbackListeners = new IntObjectOptHashMap();
    private final CowArray unifiedLoggingScopeListeners = new CowArray();
    private final Logger logger;

    CallbackManager(Logger logger, CallbackMessageDecoder callbackMessageDecoder, boolean bl) {
        this.callbackDecoder = callbackMessageDecoder;
        this.callbackDecoder.register(this);
        this.mlp_enabled = bl;
        this.logger = logger;
    }

    @Override
    public void callbackMessageDecoded(short s, byte[] byArray, int n, int n2) {
        CowArray cowArray = (CowArray)this.unifiedLoggingCallbackListeners.get(s);
        if (cowArray == null) {
            return;
        }
        Object[] objectArray = cowArray.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            try {
                ((UnifiedLoggingCallbackListener)objectArray[i2]).onBinaryMessageReceived(s, byArray, n, n2);
                continue;
            }
            catch (Exception exception) {
                this.logger.error(2).append("Error while receiving message.").append(exception).log();
            }
        }
    }

    @Override
    public void logLevelChange(int n, int[] nArray, int[] nArray2) {
        Object[] objectArray = this.unifiedLoggingScopeListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((ConfigurationChangeListener)objectArray[i2]).onLogLevelChanged(n, nArray, nArray2);
        }
    }

    @Override
    public void logSinkStateChange(int n, boolean bl) {
        Object[] objectArray = this.unifiedLoggingScopeListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((ConfigurationChangeListener)objectArray[i2]).onLogSinkStateChanged(n, bl);
        }
    }

    @Override
    public void performanceIndicatorsChange() {
        Object[] objectArray = this.performanceIndicatorListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((PerformanceIndicatorListener)objectArray[i2]).performanceIndicatorsChange();
        }
    }

    @Override
    public void readBinaryMessage(long l, byte[] byArray) {
        if (!this.mlp_enabled) {
            return;
        }
        this.callbackDecoder.decodeCallbackMessage(byArray);
    }

    @Override
    public void updateLogConfig(byte[] byArray) {
        if (this.mlp_enabled) {
            return;
        }
        this.callbackDecoder.decodeCallbackMessage(byArray);
    }

    void registerPerformanceIndicatorListener(PerformanceIndicatorListener performanceIndicatorListener) {
        this.performanceIndicatorListeners.addIfNotAlreadyIn(performanceIndicatorListener);
    }

    void registerUnifiedLoggingCallbackListener(short s, UnifiedLoggingCallbackListener unifiedLoggingCallbackListener) {
        CowArray cowArray = (CowArray)this.unifiedLoggingCallbackListeners.get(s);
        if (cowArray == null) {
            cowArray = new CowArray();
            this.unifiedLoggingCallbackListeners.put(s, cowArray);
        }
        cowArray.addIfNotAlreadyIn(unifiedLoggingCallbackListener);
    }

    void registerUnifiedLoggingScopeListener(ConfigurationChangeListener configurationChangeListener) {
        this.unifiedLoggingScopeListeners.addIfNotAlreadyIn(configurationChangeListener);
    }

    void unregisterPerformanceIndicatorListener(PerformanceIndicatorListener performanceIndicatorListener) {
        this.performanceIndicatorListeners.remove(performanceIndicatorListener);
    }

    void unregisterUnifiedLoggingCallbackListener(short s, UnifiedLoggingCallbackListener unifiedLoggingCallbackListener) {
        CowArray cowArray = (CowArray)this.unifiedLoggingCallbackListeners.get(s);
        if (cowArray == null) {
            return;
        }
        cowArray.remove(unifiedLoggingCallbackListener);
    }

    void unregisterUnifiedLoggingScopeListener(ConfigurationChangeListener configurationChangeListener) {
        this.unifiedLoggingScopeListeners.remove(configurationChangeListener);
    }
}

