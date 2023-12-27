/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.core;

import de.vw.mib.asl.framework.api.entertainmentmanager.core.ActivationRequest;
import de.vw.mib.asl.framework.api.entertainmentmanager.core.Deactivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.core.PrefixLogger;

public class SafeActivationRequest
implements ActivationRequest {
    private final PrefixLogger logger;
    private final ActivationRequest activationRequest;

    public SafeActivationRequest(PrefixLogger prefixLogger, ActivationRequest activationRequest) {
        this.logger = prefixLogger;
        this.activationRequest = activationRequest;
    }

    @Override
    public Deactivation granted(Runnable runnable) {
        Deactivation deactivation;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("send grant to ").append(this.activationRequest.toString()).log();
        }
        try {
            deactivation = this.activationRequest.granted(runnable);
        }
        catch (Exception exception) {
            deactivation = null;
            this.logger.error("a context failed on grant! Maybe it calls the callback, maybe we are blocked until timer rescue", exception);
        }
        return deactivation;
    }

    @Override
    public void rejected() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("send reject to ").append(this.activationRequest.toString()).log();
        }
        try {
            this.activationRequest.rejected();
        }
        catch (Exception exception) {
            this.logger.error("a context failed in reject", exception);
        }
    }

    @Override
    public void cancel() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("send cancel to ").append(this.activationRequest.toString()).log();
        }
        try {
            this.activationRequest.cancel();
        }
        catch (Exception exception) {
            this.logger.error("a context failed in cancel", exception);
        }
    }

    @Override
    public int getContext() {
        return this.activationRequest.getContext();
    }
}

