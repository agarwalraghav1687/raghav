package kawa.lib.kawa;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

/* compiled from: regex.scm */
public class regex extends ModuleBody {
    public static final regex $instance = new regex();
    static final SimpleSymbol Lit0 = ((SimpleSymbol) new SimpleSymbol("loop").readResolve());
    static final SimpleSymbol Lit1 = ((SimpleSymbol) new SimpleSymbol("regex-quote").readResolve());
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("regex-match?").readResolve());
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("regex-match").readResolve());
    static final SimpleSymbol Lit4 = ((SimpleSymbol) new SimpleSymbol("regex-match-positions").readResolve());
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("regex-split").readResolve());
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("regex-replace").readResolve());
    static final SimpleSymbol Lit7 = ((SimpleSymbol) new SimpleSymbol("regex-replace*").readResolve());
    public static final ModuleMethod regex$Mnmatch;
    public static final ModuleMethod regex$Mnmatch$Mnpositions;
    public static final ModuleMethod regex$Mnmatch$Qu;
    public static final ModuleMethod regex$Mnquote;
    public static final ModuleMethod regex$Mnreplace;
    public static final ModuleMethod regex$Mnreplace$St;
    public static final ModuleMethod regex$Mnsplit;

    /* compiled from: regex.scm */
    public class frame extends ModuleBody {
        Object loop = new ModuleMethod(this, 1, regex.Lit0, 0);
        Matcher matcher;
        Object repl;
        StringBuffer sbuf;

        public Object apply0(ModuleMethod moduleMethod) {
            return moduleMethod.selector == 1 ? lambda1loop() : super.apply0(moduleMethod);
        }

        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            if (moduleMethod.selector != 1) {
                return super.match0(moduleMethod, callContext);
            }
            callContext.proc = moduleMethod;
            callContext.pc = 0;
            return 0;
        }

        public String lambda1loop() {
            if (this.matcher.find()) {
                Matcher matcher2 = this.matcher;
                StringBuffer stringBuffer = this.sbuf;
                Object apply2 = Scheme.applyToArgs.apply2(this.repl, this.matcher.group());
                matcher2.appendReplacement(stringBuffer, Matcher.quoteReplacement(apply2 == null ? null : apply2.toString()));
            }
            this.matcher.appendTail(this.sbuf);
            return this.sbuf.toString();
        }
    }

    static {
        regex regex = $instance;
        regex$Mnquote = new ModuleMethod(regex, 2, Lit1, 4097);
        regex$Mnmatch$Qu = new ModuleMethod(regex, 3, Lit2, 16386);
        regex$Mnmatch = new ModuleMethod(regex, 6, Lit3, 16386);
        regex$Mnmatch$Mnpositions = new ModuleMethod(regex, 9, Lit4, 16386);
        regex$Mnsplit = new ModuleMethod(regex, 12, Lit5, 8194);
        regex$Mnreplace = new ModuleMethod(regex, 13, Lit6, 12291);
        regex$Mnreplace$St = new ModuleMethod(regex, 14, Lit7, 12291);
        $instance.run();
    }

    public regex() {
        ModuleInfo.register(this);
    }

    public static boolean isRegexMatch(Object obj, CharSequence charSequence) {
        return isRegexMatch(obj, charSequence, 0);
    }

    public static boolean isRegexMatch(Object obj, CharSequence charSequence, int i) {
        return isRegexMatch(obj, charSequence, i, charSequence.length());
    }

    public static Object regexMatch(Object obj, CharSequence charSequence) {
        return regexMatch(obj, charSequence, 0);
    }

    public static Object regexMatch(Object obj, CharSequence charSequence, int i) {
        return regexMatch(obj, charSequence, i, charSequence.length());
    }

    public static Object regexMatchPositions(Object obj, CharSequence charSequence) {
        return regexMatchPositions(obj, charSequence, 0);
    }

    public static Object regexMatchPositions(Object obj, CharSequence charSequence, int i) {
        return regexMatchPositions(obj, charSequence, i, charSequence.length());
    }

    public final void run(CallContext $ctx) {
        Consumer consumer = $ctx.consumer;
    }

    public static String regexQuote(CharSequence str) {
        return Pattern.quote(str == null ? null : str.toString());
    }

    public Object apply1(ModuleMethod moduleMethod, Object obj) {
        if (moduleMethod.selector != 2) {
            return super.apply1(moduleMethod, obj);
        }
        try {
            return regexQuote((CharSequence) obj);
        } catch (ClassCastException e) {
            throw new WrongType(e, "regex-quote", 1, obj);
        }
    }

    public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
        if (moduleMethod.selector != 2) {
            return super.match1(moduleMethod, obj, callContext);
        }
        if (!(obj instanceof CharSequence)) {
            return -786431;
        }
        callContext.value1 = obj;
        callContext.proc = moduleMethod;
        callContext.pc = 1;
        return 0;
    }

    public static boolean isRegexMatch(Object re, CharSequence str, int start, int end) {
        Pattern rex;
        if (re instanceof Pattern) {
            try {
                rex = (Pattern) re;
            } catch (ClassCastException e) {
                throw new WrongType(e, "rex", -2, re);
            }
        } else {
            rex = Pattern.compile(re.toString());
        }
        Matcher matcher = rex.matcher(str);
        matcher.region(start, end);
        return matcher.find();
    }

    public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 6:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 9:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 12:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            default:
                return super.match2(moduleMethod, obj, obj2, callContext);
        }
    }

    public int match3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 6:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 9:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 13:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 14:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            default:
                return super.match3(moduleMethod, obj, obj2, obj3, callContext);
        }
    }

    public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 6:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 9:
                callContext.value1 = obj;
                if (!(obj2 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            default:
                return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
        }
    }

    public static Object regexMatch(Object re, CharSequence str, int start, int end) {
        Pattern rex;
        Object subSequence;
        if (re instanceof Pattern) {
            try {
                rex = (Pattern) re;
            } catch (ClassCastException e) {
                throw new WrongType(e, "rex", -2, re);
            }
        } else {
            rex = Pattern.compile(re.toString());
        }
        Matcher matcher = rex.matcher(str);
        matcher.region(start, end);
        if (!matcher.find()) {
            return Boolean.FALSE;
        }
        int igroup = matcher.groupCount();
        LList lList = LList.Empty;
        while (igroup >= 0) {
            int start2 = matcher.start(igroup);
            if (start2 < 0) {
                subSequence = Boolean.FALSE;
            } else {
                subSequence = str.subSequence(start2, matcher.end(igroup));
            }
            igroup--;
            lList = lists.cons(subSequence, lList);
        }
        return lList;
    }

    public static Object regexMatchPositions(Object re, CharSequence str, int start, int end) {
        Pattern rex;
        Object cons;
        if (re instanceof Pattern) {
            try {
                rex = (Pattern) re;
            } catch (ClassCastException e) {
                throw new WrongType(e, "rex", -2, re);
            }
        } else {
            rex = Pattern.compile(re.toString());
        }
        Matcher matcher = rex.matcher(str);
        matcher.region(start, end);
        if (!matcher.find()) {
            return Boolean.FALSE;
        }
        int igroup = matcher.groupCount();
        LList lList = LList.Empty;
        while (igroup >= 0) {
            int start2 = matcher.start(igroup);
            if (start2 < 0) {
                cons = Boolean.FALSE;
            } else {
                cons = lists.cons(Integer.valueOf(start2), Integer.valueOf(matcher.end(igroup)));
            }
            igroup--;
            lList = lists.cons(cons, lList);
        }
        return lList;
    }

    public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
        switch (moduleMethod.selector) {
            case 3:
                try {
                    try {
                        try {
                            return isRegexMatch(obj, (CharSequence) obj2, ((Number) obj3).intValue(), ((Number) obj4).intValue()) ? Boolean.TRUE : Boolean.FALSE;
                        } catch (ClassCastException e) {
                            throw new WrongType(e, "regex-match?", 4, obj4);
                        }
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "regex-match?", 3, obj3);
                    }
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "regex-match?", 2, obj2);
                }
            case 6:
                try {
                    try {
                        try {
                            return regexMatch(obj, (CharSequence) obj2, ((Number) obj3).intValue(), ((Number) obj4).intValue());
                        } catch (ClassCastException e4) {
                            throw new WrongType(e4, "regex-match", 4, obj4);
                        }
                    } catch (ClassCastException e5) {
                        throw new WrongType(e5, "regex-match", 3, obj3);
                    }
                } catch (ClassCastException e6) {
                    throw new WrongType(e6, "regex-match", 2, obj2);
                }
            case 9:
                try {
                    try {
                        try {
                            return regexMatchPositions(obj, (CharSequence) obj2, ((Number) obj3).intValue(), ((Number) obj4).intValue());
                        } catch (ClassCastException e7) {
                            throw new WrongType(e7, "regex-match-positions", 4, obj4);
                        }
                    } catch (ClassCastException e8) {
                        throw new WrongType(e8, "regex-match-positions", 3, obj3);
                    }
                } catch (ClassCastException e9) {
                    throw new WrongType(e9, "regex-match-positions", 2, obj2);
                }
            default:
                return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
        }
    }

    public static LList regexSplit(Object re, CharSequence str) {
        Pattern rex;
        if (re instanceof Pattern) {
            try {
                rex = (Pattern) re;
            } catch (ClassCastException e) {
                throw new WrongType(e, "rex", -2, re);
            }
        } else {
            rex = Pattern.compile(re.toString());
        }
        return LList.makeList(rex.split(str, -1), 0);
    }

    public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
        switch (moduleMethod.selector) {
            case 3:
                try {
                    return isRegexMatch(obj, (CharSequence) obj2) ? Boolean.TRUE : Boolean.FALSE;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "regex-match?", 2, obj2);
                }
            case 6:
                try {
                    return regexMatch(obj, (CharSequence) obj2);
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "regex-match", 2, obj2);
                }
            case 9:
                try {
                    return regexMatchPositions(obj, (CharSequence) obj2);
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "regex-match-positions", 2, obj2);
                }
            case 12:
                try {
                    return regexSplit(obj, (CharSequence) obj2);
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "regex-split", 2, obj2);
                }
            default:
                return super.apply2(moduleMethod, obj, obj2);
        }
    }

    public static CharSequence regexReplace(Object re, CharSequence str, Object repl) {
        Pattern rex;
        String str2 = null;
        if (re instanceof Pattern) {
            try {
                rex = (Pattern) re;
            } catch (ClassCastException e) {
                throw new WrongType(e, "rex", -2, re);
            }
        } else {
            rex = Pattern.compile(re.toString());
        }
        Matcher matcher = rex.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        StringBuffer sbuf = new StringBuffer();
        if (misc.isProcedure(repl)) {
            Object apply2 = Scheme.applyToArgs.apply2(repl, matcher.group());
            if (apply2 != null) {
                str2 = apply2.toString();
            }
            str2 = Matcher.quoteReplacement(str2);
        } else if (repl != null) {
            str2 = repl.toString();
        }
        matcher.appendReplacement(sbuf, str2);
        matcher.appendTail(sbuf);
        return sbuf.toString();
    }

    public static CharSequence regexReplace$St(Object re, CharSequence str, Object repl) {
        Pattern rex;
        frame frame2 = new frame();
        frame2.repl = repl;
        if (re instanceof Pattern) {
            try {
                rex = (Pattern) re;
            } catch (ClassCastException e) {
                throw new WrongType(e, "rex", -2, re);
            }
        } else {
            rex = Pattern.compile(re.toString());
        }
        frame2.matcher = rex.matcher(str);
        frame2.sbuf = new StringBuffer();
        if (misc.isProcedure(frame2.repl)) {
            frame2.loop = frame2.loop;
            return frame2.lambda1loop();
        }
        Matcher matcher = frame2.matcher;
        Object obj = frame2.repl;
        return matcher.replaceAll(obj == null ? null : obj.toString());
    }

    public Object apply3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3) {
        switch (moduleMethod.selector) {
            case 3:
                try {
                    try {
                        return isRegexMatch(obj, (CharSequence) obj2, ((Number) obj3).intValue()) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "regex-match?", 3, obj3);
                    }
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "regex-match?", 2, obj2);
                }
            case 6:
                try {
                    try {
                        return regexMatch(obj, (CharSequence) obj2, ((Number) obj3).intValue());
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "regex-match", 3, obj3);
                    }
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "regex-match", 2, obj2);
                }
            case 9:
                try {
                    try {
                        return regexMatchPositions(obj, (CharSequence) obj2, ((Number) obj3).intValue());
                    } catch (ClassCastException e5) {
                        throw new WrongType(e5, "regex-match-positions", 3, obj3);
                    }
                } catch (ClassCastException e6) {
                    throw new WrongType(e6, "regex-match-positions", 2, obj2);
                }
            case 13:
                try {
                    return regexReplace(obj, (CharSequence) obj2, obj3);
                } catch (ClassCastException e7) {
                    throw new WrongType(e7, "regex-replace", 2, obj2);
                }
            case 14:
                try {
                    return regexReplace$St(obj, (CharSequence) obj2, obj3);
                } catch (ClassCastException e8) {
                    throw new WrongType(e8, "regex-replace*", 2, obj2);
                }
            default:
                return super.apply3(moduleMethod, obj, obj2, obj3);
        }
    }
}
