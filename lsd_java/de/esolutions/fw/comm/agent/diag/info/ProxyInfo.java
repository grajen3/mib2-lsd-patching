/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag.info;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.core.IProxyBackend;
import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import java.lang.reflect.Field;

public class ProxyInfo
extends AbstractInfoBase {
    public final ServiceInstanceID svcID;
    public final short stubID;
    public final int errorCode;
    public final String errorString;
    public final int state;
    public final String stateString;
    public final short replyStubID;
    public final ServiceInstanceID replySvcID;
    public final String replySvcClass;
    public final short peerAgentID;
    public String errorTimeStamp;
    public final int callsTotal;
    public final int callsError;
    private static final int DEFAULT_ERROR_CODE;
    private static final int DEFAULT_STATE;
    private static final int DEFAULT_PEER_AGENT_ID;
    private static final int DEFAULT_STUB_ID;
    private static final int DEFAULT_REPLY_STUB_ID;

    public ProxyInfo(Proxy proxy) {
        super(proxy.getProxyID());
        this.svcID = proxy.getInstanceID();
        this.stubID = proxy.getStubID();
        this.errorCode = proxy.getErrorCode();
        this.errorString = proxy.getErrorString();
        this.errorTimeStamp = super.getTimeStampString();
        this.state = proxy.getState();
        this.stateString = proxy.getStateString();
        this.callsTotal = proxy.getTotalCalls();
        this.callsError = proxy.getErrorCalls();
        this.replyStubID = proxy.getReplyStubID();
        IReplyService iReplyService = proxy.getReplyService();
        if (iReplyService != null) {
            this.replySvcID = iReplyService.getInstanceID();
            this.replySvcClass = super.getClass().getName();
        } else {
            this.replySvcID = null;
            this.replySvcClass = null;
        }
        IProxyBackend iProxyBackend = proxy.getBackend();
        if (iProxyBackend instanceof IClientHandler) {
            IClientHandler iClientHandler = (IClientHandler)iProxyBackend;
            this.peerAgentID = iClientHandler.getPeerAgentID();
        } else {
            this.peerAgentID = (short)-1;
        }
    }

    @Override
    protected Object fieldValueToObject(Field field) {
        if (field == null) {
            return null;
        }
        String string = field.getName();
        if (string.equals("errorCode") && this.errorCode == 0 || string.equals("errorString") && this.errorCode == 0 || string.equals("errorTimeStamp") && this.errorCode == 0 || string.equals("stateString") && this.state == 1 || string.equals("peerAgentID") && this.peerAgentID == -1 || string.equals("stubID") && this.stubID == -1 || string.equals("replyStubID") && this.replyStubID == -1 || string.equals("state") && this.state == 1 || string.equals("state") || string.equals("callsTotal") && this.callsTotal == 0 || string.equals("callsError") && this.callsError == 0) {
            return null;
        }
        return super.fieldValueToObject(field);
    }

    @Override
    public ServiceInstanceID getServiceInstanceID() {
        return this.svcID;
    }
}

