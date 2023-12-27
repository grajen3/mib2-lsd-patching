/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.mqbpq.PqServices;
import de.vw.mib.log4mib.Logger;

public class PqServicesImpl
implements PqServices {
    private final Logger logger;

    public PqServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        this.logger = aSLFrameworkAPI.getASLLogger();
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
}

