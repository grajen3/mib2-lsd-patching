/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.sound;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.BalanceFaderContainer;
import generated.de.vw.mib.has.contexts.sound.SoundServices;

public class SoundServicesAdapter
implements SoundServices {
    @Override
    public void actionRequest(int n, int n2, HASContainer hASContainer) {
        switch (n2) {
            case 10: {
                this.increaseVolume(n);
                break;
            }
            case 11: {
                this.decreaseVolume(n);
                break;
            }
            case 12: {
                this.muteEntertainment(n);
                break;
            }
            case 13: {
                this.unmuteEntertainment(n);
                break;
            }
            case 34: {
                this.setBalanceFader(n, (BalanceFaderContainer)hASContainer);
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
            case 25: {
                this.getSoundVolume();
                break;
            }
            case 26: {
                this.getSoundVolumeRanges();
                break;
            }
            case 45: {
                this.getBalanceFader();
                break;
            }
            case 46: {
                this.getBalanceFaderRanges();
                break;
            }
            default: {
                throw HASException.invalidPropertyRequest(n);
            }
        }
    }

    @Override
    public void increaseVolume(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void decreaseVolume(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void muteEntertainment(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unmuteEntertainment(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setBalanceFader(int n, BalanceFaderContainer balanceFaderContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getSoundVolume() {
    }

    @Override
    public void getSoundVolumeRanges() {
    }

    @Override
    public void getBalanceFader() {
    }

    @Override
    public void getBalanceFaderRanges() {
    }
}

