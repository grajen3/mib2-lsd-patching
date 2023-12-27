/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public abstract class Command {
    protected static long counter = 0L;
    protected static long startTime = 0L;
    protected long createTime;
    protected ServiceInstanceID dependentInstanceID;
    protected String name;
    protected long serialNo;
    protected short retries;
    protected IClientHandler handler;
    protected boolean dropNow;

    public Command(String string) {
        this.name = string;
        this.serialNo = counter++;
        this.retries = 0;
    }

    public void setCreateTime(long l) {
        this.createTime = l;
        if (startTime == 0L) {
            startTime = l;
        }
    }

    public String toString() {
        long l = this.createTime - startTime;
        return new StringBuffer().append(this.getName()).append(" ").append(this.getArgsString()).append(" ( Cmd #").append(this.serialNo).append(", time +").append(l).append(" ms )").toString();
    }

    public String getName() {
        return this.name;
    }

    public long getSerialNo() {
        return this.serialNo;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public ServiceInstanceID getDependentInstanceID() {
        return this.dependentInstanceID;
    }

    public void setDependentInstanceID(ServiceInstanceID serviceInstanceID) {
        this.dependentInstanceID = serviceInstanceID;
    }

    public IClientHandler getDependentClientHandler() {
        return this.handler;
    }

    public void setDependentClientHandler(IClientHandler iClientHandler) {
        this.handler = iClientHandler;
    }

    public abstract boolean handle(ICommandExecutor iCommandExecutor) {
    }

    public void drop(ICommandExecutor iCommandExecutor, boolean bl) {
    }

    public short getRetryCount() {
        return this.retries;
    }

    public void incRetryCount() {
        this.retries = (short)(this.retries + 1);
    }

    public String getArgsString() {
        return "";
    }

    public void setDropNow(boolean bl) {
        this.dropNow = true;
    }

    public boolean getDropNow() {
        return this.dropNow;
    }
}

