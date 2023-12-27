/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.entertainmentmanager;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.MediaSourceContainer;
import generated.de.vw.mib.has.containers.RadioBandContainer;
import generated.de.vw.mib.has.contexts.entertainmentmanager.EntertainmentManagerServices;

public class EntertainmentManagerServicesAdapter
implements EntertainmentManagerServices {
    @Override
    public void actionRequest(int n, int n2, HASContainer hASContainer) {
        switch (n2) {
            case 14: {
                this.activateRadioBand(n, (RadioBandContainer)hASContainer);
                break;
            }
            case 18: {
                this.activateMediaSource(n, (MediaSourceContainer)hASContainer);
                break;
            }
            case 39: {
                this.activateAppConnectAudio(n);
                break;
            }
            default: {
                throw HASException.invalidActionRequest(n2);
            }
        }
    }

    @Override
    public void propertyRequest(int n) {
        switch (n) {
            case 58: {
                this.getEntertainmentContext();
                break;
            }
            default: {
                throw HASException.invalidPropertyRequest(n);
            }
        }
    }

    @Override
    public void activateRadioBand(int n, RadioBandContainer radioBandContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void activateMediaSource(int n, MediaSourceContainer mediaSourceContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void activateAppConnectAudio(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getEntertainmentContext() {
    }
}

