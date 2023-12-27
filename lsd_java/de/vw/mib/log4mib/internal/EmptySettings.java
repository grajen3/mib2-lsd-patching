/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.log4mib.Settings;

public class EmptySettings
implements Settings {
    private boolean consoleLoggingEnabled = true;
    private IntIntMap initialSubClassifierMasks = new IntIntOptHashMap();
    private long logHeartbeatFrequency = 0;
    private int logMessageCacheSize = 2000;
    private int logMessagePoolSize = 100;
    private int logMessageQueueSize = 2000;
    private boolean tcpSinkEnabled = true;

    public int getInitialClassifierMask() {
        new UnsupportedOperationException("The method Settings.getInitialClassifierMask() is no longer supported!").printStackTrace();
        return -1;
    }

    @Override
    public IntIntMap getInitialSubClassifierMasks() {
        return this.initialSubClassifierMasks;
    }

    @Override
    public long getLogHeartbeatFrequency() {
        return this.logHeartbeatFrequency;
    }

    @Override
    public int getLogMessageCacheSize() {
        return this.logMessageCacheSize;
    }

    @Override
    public int getLogMessagePoolSize() {
        return this.logMessagePoolSize;
    }

    @Override
    public int getLogMessageQueueSize() {
        return this.logMessageQueueSize;
    }

    @Override
    public boolean isConsoleLoggingEnabled() {
        return this.consoleLoggingEnabled;
    }

    public boolean isFileSinkEnabled() {
        new UnsupportedOperationException("The method Settings.isFileSinkEnabled() is no longer supported!").printStackTrace();
        return false;
    }

    public boolean isSerialSinkEnabled() {
        new UnsupportedOperationException("The method Settings.isSerialSinkEnabled() is no longer supported!").printStackTrace();
        return false;
    }

    @Override
    public boolean isTcpSinkEnabled() {
        return this.tcpSinkEnabled;
    }

    public void setConsoleLoggingEnabled(boolean bl) {
        this.consoleLoggingEnabled = bl;
    }

    public void setFileSinkEnabled(boolean bl) {
        new UnsupportedOperationException("The method EmptySettings.setFileSinkEnabled(boolean) is no longer supported!").printStackTrace();
    }

    public void setInitialClassifierMask(int n) {
        new UnsupportedOperationException("The method EmptySettings.setInitialClassifierMask(int) is no longer supported!").printStackTrace();
    }

    public void setInitialSubClassifierMasks(IntIntMap intIntMap) {
        this.initialSubClassifierMasks = intIntMap;
    }

    public void setLogHeartbeatFrequency(long l) {
        this.logHeartbeatFrequency = l;
    }

    public void setLogMessageCacheSize(int n) {
        this.logMessageCacheSize = n;
    }

    public void setLogMessagePoolSize(int n) {
        this.logMessagePoolSize = n;
    }

    public void setLogMessageQueueSize(int n) {
        this.logMessageQueueSize = n;
    }

    public void setSerialSinkEnabled(boolean bl) {
        new UnsupportedOperationException("The method EmptySettings.setSerialSinkEnabled(boolean) is no longer supported!").printStackTrace();
    }

    public void setTcpSinkEnabled(boolean bl) {
        this.tcpSinkEnabled = bl;
    }
}

