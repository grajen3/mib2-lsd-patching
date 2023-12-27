/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.internal.ProbeSystemServiceImpl;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;

class ProbeSystemServiceImpl$1
extends AbstractSynchronizedObjectPool {
    private final /* synthetic */ ProbeSystemServiceImpl this$0;

    ProbeSystemServiceImpl$1(ProbeSystemServiceImpl probeSystemServiceImpl, int n) {
        this.this$0 = probeSystemServiceImpl;
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        if (this.this$0.logger.isTraceEnabled(4)) {
            this.this$0.logger.trace(4).append("[").append(super.getClass().getName()).append("] ").append("Create new Codec. Currendly created codecs: ").append(this.this$0.codecPool.size()).log();
        }
        AbstractProbeCodec abstractProbeCodec = this.this$0.debugProbeFactory.createCodec(this.this$0);
        return abstractProbeCodec;
    }
}

