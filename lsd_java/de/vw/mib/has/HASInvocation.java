/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContext;

public interface HASInvocation {
    public static final int STATE_EXECUTE_ACTION;
    public static final int STATE_SEND_RESULT;
    public static final int STATE_DROP;

    default public int getRequestId() {
    }

    default public HASContext getContext() {
    }

    default public void setContext(HASContext hASContext) {
    }

    default public int getActionId() {
    }

    default public void setActionId(int n) {
    }

    default public int getOrigActionId() {
    }

    default public HASContainer getArgument() {
    }

    default public void setArgument(HASContainer hASContainer) {
    }

    default public HASContainer getResult() {
    }

    default public void setResult(HASContainer hASContainer) {
    }

    default public int getResultCode() {
    }

    default public void setResultCode(int n) {
    }

    default public int getState() {
    }

    default public void setState(int n) {
    }
}

