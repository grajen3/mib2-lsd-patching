/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap;

import de.vw.mib.asl.internal.navigation.bap.HsmBapListTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

class HsmBapListTarget$1
extends AbstractHsmState {
    private final /* synthetic */ HsmBapListTarget this$0;

    HsmBapListTarget$1(HsmBapListTarget hsmBapListTarget, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmBapListTarget;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.registerObservers();
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                this.this$0.unregisterObservers();
                break;
            }
            case 3500006: {
                this.this$0.navBookFetcher.configureAdbList();
                break;
            }
            case 1073742278: {
                String string = eventGeneric.getString(0);
                if (this.this$0.bapSpellerHandle != -1) {
                    if (this.this$0.currentSpellerChars.length() != 0) {
                        this.this$0.removeSpellerChars(this.this$0.currentSpellerChars.length());
                    } else {
                        this.this$0.addSpellerChars(string);
                    }
                    this.this$0.currentSpellerChars = string;
                    break;
                }
                this.this$0.sendHMIEvent(70);
                break;
            }
            case 1073742279: {
                this.this$0.numberOfCharactersToRemove = 0;
                this.this$0.numberOfCharactersToAdd = 0;
                this.this$0.currentSpellerChars = "";
                this.this$0.dsiAdbList.startSpeller(2, 20, 0);
                break;
            }
            case 1073742280: {
                this.this$0.numberOfCharactersToRemove = 0;
                this.this$0.numberOfCharactersToAdd = 0;
                this.this$0.currentSpellerChars = "";
                if (this.this$0.bapSpellerHandle != -1) {
                    this.this$0.dsiAdbList.stopSpeller(this.this$0.bapSpellerHandle);
                    this.this$0.bapSpellerHandle = -1;
                    break;
                }
                this.this$0.sendHMIEvent(70);
                break;
            }
            case 1073742277: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                this.this$0.dsiAdbList.getViewWindow(n, 6, 2, n2);
                break;
            }
            case 1073742275: {
                long[] lArray = (long[])eventGeneric.getObject(0);
                int n = eventGeneric.getInt(1);
                switch (n) {
                    case 0: {
                        if (lArray.length <= 0) break block0;
                        this.this$0.numberOfLastDestRequests = lArray.length;
                        this.this$0.lastDestColls = null;
                        for (int i2 = 0; i2 < this.this$0.numberOfLastDestRequests; ++i2) {
                            this.this$0.dsiNavigation.dmLastDestinationsGet(lArray[i2]);
                        }
                        break block0;
                    }
                    default: {
                        this.this$0.numberOfLastDestRequests = 0;
                        this.this$0.lastDestColls = null;
                        this.this$0.dsiAdbEdit.getEntries(lArray, 14, 0);
                        break;
                    }
                }
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

