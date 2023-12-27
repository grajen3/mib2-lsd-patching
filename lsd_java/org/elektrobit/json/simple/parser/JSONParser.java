/*
 * Decompiled with CFR 0.152.
 */
package org.elektrobit.json.simple.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.elektrobit.json.simple.JSONArray;
import org.elektrobit.json.simple.JSONObject;
import org.elektrobit.json.simple.parser.ContainerFactory;
import org.elektrobit.json.simple.parser.ContentHandler;
import org.elektrobit.json.simple.parser.ParseException;
import org.elektrobit.json.simple.parser.Yylex;
import org.elektrobit.json.simple.parser.Yytoken;

public class JSONParser {
    public static final int S_INIT;
    public static final int S_IN_FINISHED_VALUE;
    public static final int S_IN_OBJECT;
    public static final int S_IN_ARRAY;
    public static final int S_PASSED_PAIR_KEY;
    public static final int S_IN_PAIR_VALUE;
    public static final int S_END;
    public static final int S_IN_ERROR;
    private LinkedList handlerStatusStack;
    private Yylex lexer = new Yylex((Reader)null);
    private Yytoken token = null;
    private int status = 0;

    private int peekStatus(LinkedList linkedList) {
        if (linkedList.size() == 0) {
            return -1;
        }
        Integer n = (Integer)linkedList.getFirst();
        return n;
    }

    public void reset() {
        this.token = null;
        this.status = 0;
        this.handlerStatusStack = null;
    }

    public void reset(Reader reader) {
        this.lexer.yyreset(reader);
        this.reset();
    }

    public int getPosition() {
        return this.lexer.getPosition();
    }

    public Object parse(String string) {
        return this.parse(string, (ContainerFactory)null);
    }

    public Object parse(String string, ContainerFactory containerFactory) {
        StringReader stringReader = new StringReader(string);
        try {
            return this.parse((Reader)stringReader, containerFactory);
        }
        catch (IOException iOException) {
            throw new ParseException(-1, 2, iOException);
        }
    }

    public Object parse(Reader reader) {
        return this.parse(reader, (ContainerFactory)null);
    }

    public Object parse(Reader reader, ContainerFactory containerFactory) {
        this.reset(reader);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        do {
            this.nextToken();
            block1 : switch (this.status) {
                case 0: {
                    switch (this.token.type) {
                        case 0: {
                            this.status = 1;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(this.token.value);
                            break block1;
                        }
                        case 1: {
                            this.status = 2;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(this.createObjectContainer(containerFactory));
                            break block1;
                        }
                        case 3: {
                            this.status = 3;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(this.createArrayContainer(containerFactory));
                            break block1;
                        }
                    }
                    this.status = -1;
                    break;
                }
                case 1: {
                    if (this.token.type == -1) {
                        return linkedList2.removeFirst();
                    }
                    throw new ParseException(this.getPosition(), 1, this.token);
                }
                case 2: {
                    Object object;
                    switch (this.token.type) {
                        case 5: {
                            break block1;
                        }
                        case 0: {
                            if (this.token.value instanceof String) {
                                object = (String)this.token.value;
                                linkedList2.addFirst(object);
                                this.status = 4;
                                linkedList.addFirst(new Integer(this.status));
                                break block1;
                            }
                            this.status = -1;
                            break block1;
                        }
                        case 2: {
                            if (linkedList2.size() > 1) {
                                linkedList.removeFirst();
                                linkedList2.removeFirst();
                                this.status = this.peekStatus(linkedList);
                                break block1;
                            }
                            this.status = 1;
                            break block1;
                        }
                    }
                    this.status = -1;
                    break;
                }
                case 4: {
                    List list;
                    Map map;
                    Object object;
                    switch (this.token.type) {
                        case 6: {
                            break block1;
                        }
                        case 0: {
                            linkedList.removeFirst();
                            object = (String)linkedList2.removeFirst();
                            map = (Map)linkedList2.getFirst();
                            map.put(object, this.token.value);
                            this.status = this.peekStatus(linkedList);
                            break block1;
                        }
                        case 3: {
                            linkedList.removeFirst();
                            object = (String)linkedList2.removeFirst();
                            map = (Map)linkedList2.getFirst();
                            list = this.createArrayContainer(containerFactory);
                            map.put(object, list);
                            this.status = 3;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(list);
                            break block1;
                        }
                        case 1: {
                            linkedList.removeFirst();
                            object = (String)linkedList2.removeFirst();
                            map = (Map)linkedList2.getFirst();
                            Map map2 = this.createObjectContainer(containerFactory);
                            map.put(object, map2);
                            this.status = 2;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(map2);
                            break block1;
                        }
                    }
                    this.status = -1;
                    break;
                }
                case 3: {
                    List list;
                    Map map;
                    Object object;
                    switch (this.token.type) {
                        case 5: {
                            break block1;
                        }
                        case 0: {
                            object = (List)linkedList2.getFirst();
                            object.add(this.token.value);
                            break block1;
                        }
                        case 4: {
                            if (linkedList2.size() > 1) {
                                linkedList.removeFirst();
                                linkedList2.removeFirst();
                                this.status = this.peekStatus(linkedList);
                                break block1;
                            }
                            this.status = 1;
                            break block1;
                        }
                        case 1: {
                            object = (List)linkedList2.getFirst();
                            map = this.createObjectContainer(containerFactory);
                            object.add(map);
                            this.status = 2;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(map);
                            break block1;
                        }
                        case 3: {
                            object = (List)linkedList2.getFirst();
                            list = this.createArrayContainer(containerFactory);
                            object.add(list);
                            this.status = 3;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(list);
                            break block1;
                        }
                    }
                    this.status = -1;
                    break;
                }
                case -1: {
                    throw new ParseException(this.getPosition(), 1, this.token);
                }
            }
            if (this.status != -1) continue;
            throw new ParseException(this.getPosition(), 1, this.token);
        } while (this.token.type != -1);
        throw new ParseException(this.getPosition(), 1, this.token);
    }

    private void nextToken() {
        this.token = this.lexer.yylex();
        if (this.token == null) {
            this.token = new Yytoken(-1, null);
        }
    }

    private Map createObjectContainer(ContainerFactory containerFactory) {
        if (containerFactory == null) {
            return new JSONObject();
        }
        Map map = containerFactory.createObjectContainer();
        if (map == null) {
            return new JSONObject();
        }
        return map;
    }

    private List createArrayContainer(ContainerFactory containerFactory) {
        if (containerFactory == null) {
            return new JSONArray();
        }
        List list = containerFactory.creatArrayContainer();
        if (list == null) {
            return new JSONArray();
        }
        return list;
    }

    public void parse(String string, ContentHandler contentHandler) {
        this.parse(string, contentHandler, false);
    }

    public void parse(String string, ContentHandler contentHandler, boolean bl) {
        StringReader stringReader = new StringReader(string);
        try {
            this.parse(stringReader, contentHandler, bl);
        }
        catch (IOException iOException) {
            throw new ParseException(-1, 2, iOException);
        }
    }

    public void parse(Reader reader, ContentHandler contentHandler) {
        this.parse(reader, contentHandler, false);
    }

    public void parse(Reader reader, ContentHandler contentHandler, boolean bl) {
        if (!bl) {
            this.reset(reader);
            this.handlerStatusStack = new LinkedList();
        } else if (this.handlerStatusStack == null) {
            bl = false;
            this.reset(reader);
            this.handlerStatusStack = new LinkedList();
        }
        LinkedList linkedList = this.handlerStatusStack;
        try {
            do {
                block1 : switch (this.status) {
                    case 0: {
                        contentHandler.startJSON();
                        this.nextToken();
                        switch (this.token.type) {
                            case 0: {
                                this.status = 1;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.primitive(this.token.value)) break block1;
                                return;
                            }
                            case 1: {
                                this.status = 2;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startObject()) break block1;
                                return;
                            }
                            case 3: {
                                this.status = 3;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startArray()) break block1;
                                return;
                            }
                        }
                        this.status = -1;
                        break;
                    }
                    case 1: {
                        this.nextToken();
                        if (this.token.type == -1) {
                            contentHandler.endJSON();
                            this.status = 6;
                            return;
                        }
                        this.status = -1;
                        throw new ParseException(this.getPosition(), 1, this.token);
                    }
                    case 2: {
                        this.nextToken();
                        switch (this.token.type) {
                            case 5: {
                                break;
                            }
                            case 0: {
                                if (this.token.value instanceof String) {
                                    String string = (String)this.token.value;
                                    this.status = 4;
                                    linkedList.addFirst(new Integer(this.status));
                                    if (contentHandler.startObjectEntry(string)) break block1;
                                    return;
                                }
                                this.status = -1;
                                break;
                            }
                            case 2: {
                                if (linkedList.size() > 1) {
                                    linkedList.removeFirst();
                                    this.status = this.peekStatus(linkedList);
                                } else {
                                    this.status = 1;
                                }
                                if (contentHandler.endObject()) break;
                                return;
                            }
                            default: {
                                this.status = -1;
                                break;
                            }
                        }
                        break;
                    }
                    case 4: {
                        this.nextToken();
                        switch (this.token.type) {
                            case 6: {
                                break block1;
                            }
                            case 0: {
                                linkedList.removeFirst();
                                this.status = this.peekStatus(linkedList);
                                if (!contentHandler.primitive(this.token.value)) {
                                    return;
                                }
                                if (contentHandler.endObjectEntry()) break block1;
                                return;
                            }
                            case 3: {
                                linkedList.removeFirst();
                                linkedList.addFirst(new Integer(5));
                                this.status = 3;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startArray()) break block1;
                                return;
                            }
                            case 1: {
                                linkedList.removeFirst();
                                linkedList.addFirst(new Integer(5));
                                this.status = 2;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startObject()) break block1;
                                return;
                            }
                        }
                        this.status = -1;
                        break;
                    }
                    case 5: {
                        linkedList.removeFirst();
                        this.status = this.peekStatus(linkedList);
                        if (contentHandler.endObjectEntry()) break;
                        return;
                    }
                    case 3: {
                        this.nextToken();
                        switch (this.token.type) {
                            case 5: {
                                break block1;
                            }
                            case 0: {
                                if (contentHandler.primitive(this.token.value)) break block1;
                                return;
                            }
                            case 4: {
                                if (linkedList.size() > 1) {
                                    linkedList.removeFirst();
                                    this.status = this.peekStatus(linkedList);
                                } else {
                                    this.status = 1;
                                }
                                if (contentHandler.endArray()) break block1;
                                return;
                            }
                            case 1: {
                                this.status = 2;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startObject()) break block1;
                                return;
                            }
                            case 3: {
                                this.status = 3;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startArray()) break block1;
                                return;
                            }
                        }
                        this.status = -1;
                        break;
                    }
                    case 6: {
                        return;
                    }
                    case -1: {
                        throw new ParseException(this.getPosition(), 1, this.token);
                    }
                }
                if (this.status != -1) continue;
                throw new ParseException(this.getPosition(), 1, this.token);
            } while (this.token.type != -1);
        }
        catch (IOException iOException) {
            this.status = -1;
            throw iOException;
        }
        catch (ParseException parseException) {
            this.status = -1;
            throw parseException;
        }
        catch (RuntimeException runtimeException) {
            this.status = -1;
            throw runtimeException;
        }
        catch (Error error) {
            this.status = -1;
            throw error;
        }
        this.status = -1;
        throw new ParseException(this.getPosition(), 1, this.token);
    }
}

