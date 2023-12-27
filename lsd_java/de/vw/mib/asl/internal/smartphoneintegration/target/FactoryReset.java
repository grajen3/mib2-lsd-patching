/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.target;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationGlobalProperyAccessor;
import de.vw.mib.asl.internal.smartphoneintegration.target.FactoryReset$1;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;

public class FactoryReset {
    ASLSystemAPI systemAPI = ASLSystemFactory.getSystemApi();
    FactoryResetParticipant frp;
    private HsmTarget target;
    String classname = "SmartPhoneIntegration.FactoryReset";

    public FactoryReset(HsmTarget hsmTarget) {
        this.target = hsmTarget;
        this.frp = new FactoryReset$1(this, hsmTarget);
    }

    public void register() {
        this.systemAPI.getFactoryResetService().addParticipant(this.frp, FactoryResetComponents.APP_CONNECT);
    }

    public HsmTarget getTarget() {
        return this.target;
    }

    SmartPhoneIntegrationGlobalProperyAccessor getGlobal() {
        return SmartPhoneIntegrationGlobalProperyAccessor.getInstance();
    }
}

