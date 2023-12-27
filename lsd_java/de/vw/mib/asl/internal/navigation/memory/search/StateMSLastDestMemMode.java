/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.search;

import de.vw.mib.asl.internal.navigation.memory.search.AbstractMSState;
import de.vw.mib.asl.internal.navigation.memory.search.HsmTargetMemorySearch;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.dsi.ifc.navigation.LDListElement;

public final class StateMSLastDestMemMode
extends AbstractMSState {
    public StateMSLastDestMemMode(HsmTargetMemorySearch hsmTargetMemorySearch, String string, HsmState hsmState) {
        super(hsmTargetMemorySearch, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.updateLastDestSearchSpellerStatus();
                break;
            }
            case 1073742457: {
                this.handleSpellerSetChar(eventGeneric);
                break;
            }
            case 1073742456: {
                this.handleSpellerDeleteChar();
                break;
            }
            case 1073742458: {
                this.handleSpellerSetString(eventGeneric);
                break;
            }
            case 1073742443: {
                this.handleInitSearchSpeller(eventGeneric);
                break;
            }
            case 100100: {
                this.handleStopSearchSpeller();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleInitSearchSpeller(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleInitSearchSpeller()");
        }
        this.target.transStateInitAndForwardEvent(eventGeneric);
    }

    private void handleSpellerSetChar(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerSetChar()");
        }
        String string = null;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (this.getDataPool().isHwrEnabled()) {
            string = eventGeneric.getString(0);
            n = eventGeneric.getInt(1);
            n2 = eventGeneric.getInt(2);
            n3 = eventGeneric.getInt(3);
        } else {
            string = eventGeneric.getString(0);
            n = this.getDataPool().getSpellerData().getEnteredText().length();
            if (string != null) {
                n += string.length();
            }
        }
        if (string == null) {
            string = "";
        }
        this.updateDataPoolOnSpellerSetChar(new StringBuffer().append(this.getDataPool().getSpellerData().getEnteredText()).append(string).toString(), n, n2, n3);
        this.updateLastDestSearchSpellerStatus();
    }

    private void handleSpellerDeleteChar() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerDeleteChar()");
        }
        if (this.getDataPool().getSpellerData().getEnteredText().length() > 0) {
            this.getDataPool().getSpellerData().setAvailableCharacters("");
            this.prepareSpellerDeleteChar();
            this.updateLastDestSearchSpellerStatus();
        }
    }

    private void handleSpellerSetString(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerSetString()");
        }
        this.prepareSpellerSetString(eventGeneric);
        this.updateLastDestSearchSpellerStatus();
    }

    private void updateLastDestSearchSpellerStatus() {
        LDListElement[] lDListElementArray = (LDListElement[])ListManager.getGenericASLList(908).getDSIObjects();
        if (lDListElementArray != null) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            String string = this.getDataPool().getSpellerData().getEnteredText();
            for (int i2 = 0; i2 < lDListElementArray.length; ++i2) {
                int n = lDListElementArray[i2].title.toLowerCase().indexOf(string.toLowerCase());
                if (n < 0) continue;
                arrayList.add(lDListElementArray[i2]);
                if (string.length() == 0) {
                    for (int i3 = 0; i3 < lDListElementArray[i2].title.length(); ++i3) {
                        String string2 = lDListElementArray[i2].title.substring(i3, i3 + 1).toLowerCase();
                        hashSet.add(string2);
                    }
                    continue;
                }
                while (n >= 0 && n < lDListElementArray[i2].title.length()) {
                    if (n + string.length() < lDListElementArray[i2].title.length()) {
                        String string3 = lDListElementArray[i2].title.substring(n + string.length(), n + string.length() + 1).toLowerCase();
                        hashSet.add(string3);
                    }
                    n = lDListElementArray[i2].title.toLowerCase().indexOf(string.toLowerCase(), n + 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer(hashSet.size());
            Iterator iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                stringBuffer.append((String)iterator.next());
            }
            this.getDataPool().getSpellerData().setAvailableCharacters(stringBuffer.toString().toLowerCase());
            this.getDataPool().requestStoreSpellerData();
            this.updateLastDestSearchResultList((LDListElement[])arrayList.toArray(new LDListElement[0]));
        }
        this.getDataPool().storeSpellerData();
    }

    private void updateLastDestSearchResultList(LDListElement[] lDListElementArray) {
        this.getDataPool().updateListItems(lDListElementArray, lDListElementArray.length);
        this.getDataPool().updateSpellerReady(true);
        this.switchToResultListIfRequired(this.getDataPool().getSpellerData().getEnteredText(), lDListElementArray.length);
    }
}

