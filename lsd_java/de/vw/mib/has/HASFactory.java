/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASClient;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContainerMarshaller;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASInvocation;
import de.vw.mib.has.HASListRequest;

public interface HASFactory {
    default public void setEngine(HASEngineAPI hASEngineAPI) {
    }

    default public HASContainer createContainer(int n) {
    }

    default public HASContainerMarshaller createContainerMarshaller(int n) {
    }

    default public HASListRequest createListRequest(int n, HASInvocation hASInvocation) {
    }

    default public HASClient[] getClients() {
    }

    default public Object getContainerFactory() {
    }

    default public String getVersion() {
    }
}

