/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASInvocation;
import de.vw.mib.pool.PoorMansPool;

final class HASInvocationImpl
implements HASInvocation {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private int requestId;
    private HASContext context;
    private int actionId;
    private int origActionId;
    private HASContainer argument;
    private HASContainer result;
    private int resultCode;
    private int state;

    private HASInvocationImpl() {
    }

    private static HASInvocationImpl borrow() {
        HASInvocationImpl hASInvocationImpl = (HASInvocationImpl)POOL.borrow();
        if (null == hASInvocationImpl) {
            hASInvocationImpl = new HASInvocationImpl();
        }
        return hASInvocationImpl;
    }

    private static void release(HASInvocationImpl hASInvocationImpl) {
        hASInvocationImpl.argument = null;
        hASInvocationImpl.result = null;
        POOL.release(hASInvocationImpl);
    }

    static HASInvocationImpl create(int n, int n2) {
        HASInvocationImpl hASInvocationImpl = HASInvocationImpl.borrow();
        hASInvocationImpl.requestId = n;
        hASInvocationImpl.actionId = n2;
        hASInvocationImpl.origActionId = n2;
        hASInvocationImpl.resultCode = 0;
        hASInvocationImpl.state = 0;
        return hASInvocationImpl;
    }

    void release() {
        HASInvocationImpl.release(this);
    }

    static HASInvocationImpl copy(HASInvocation hASInvocation) {
        HASInvocationImpl hASInvocationImpl = HASInvocationImpl.borrow();
        hASInvocationImpl.requestId = hASInvocation.getRequestId();
        hASInvocationImpl.context = hASInvocation.getContext();
        hASInvocationImpl.actionId = hASInvocation.getActionId();
        hASInvocationImpl.origActionId = hASInvocation.getOrigActionId();
        hASInvocationImpl.argument = hASInvocation.getArgument();
        hASInvocationImpl.result = hASInvocation.getResult();
        hASInvocationImpl.resultCode = hASInvocation.getResultCode();
        hASInvocationImpl.state = hASInvocation.getState();
        return hASInvocationImpl;
    }

    @Override
    public int getRequestId() {
        return this.requestId;
    }

    @Override
    public HASContext getContext() {
        return this.context;
    }

    @Override
    public void setContext(HASContext hASContext) {
        this.context = hASContext;
    }

    @Override
    public int getActionId() {
        return this.actionId;
    }

    @Override
    public void setActionId(int n) {
        this.actionId = n;
    }

    @Override
    public int getOrigActionId() {
        return this.origActionId;
    }

    @Override
    public HASContainer getArgument() {
        return this.argument;
    }

    @Override
    public void setArgument(HASContainer hASContainer) {
        this.argument = hASContainer;
    }

    @Override
    public HASContainer getResult() {
        return this.result;
    }

    @Override
    public void setResult(HASContainer hASContainer) {
        this.result = hASContainer;
    }

    @Override
    public int getResultCode() {
        return this.resultCode;
    }

    @Override
    public void setResultCode(int n) {
        this.resultCode = n;
    }

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void setState(int n) {
        this.state = n;
    }

    static {
        POOL = new PoorMansPool("HASAction", 10);
    }
}

