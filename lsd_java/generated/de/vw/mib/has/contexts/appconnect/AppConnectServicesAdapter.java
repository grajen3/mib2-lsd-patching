/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.appconnect;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.contexts.appconnect.AppConnectServices;

public class AppConnectServicesAdapter
implements AppConnectServices {
    @Override
    public void actionRequest(int n, int n2, HASContainer hASContainer) {
        switch (n2) {
            default: 
        }
        throw HASException.invalidActionRequest(n2);
    }

    @Override
    public void propertyRequest(int n) {
        switch (n) {
            case 57: {
                this.getAppConnectDevice();
                break;
            }
            default: {
                throw HASException.invalidPropertyRequest(n);
            }
        }
    }

    @Override
    public void getAppConnectDevice() {
    }
}

