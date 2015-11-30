package iggy.gen.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import iggy.gen.psi.IGGYTokenTypes;

%%

%public
%class _IGGYLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{
  return;
%eof}


CHAR=(['-'](([\\-\\][\"-\"'-'\\-\\f-fn-nr-rt-t])|[\u0001-\!#-&\(-\[\]-\u10FFFF])*['-'])
STRING=([\"-\"](([\\-\\][\"-\"'-'\\-\\f-fn-nr-rt-t])|[\u0001-\!#-&\(-\[\]-\u10FFFF])*[\"-\"])
NUMBER=(([1-9][0-9]*)|[0-0])
RANGECHAR=(([\\-\\][\u0020-\u0020\--\-\[-\]f-fn-nr-rt-t])|[\u0001-\u001F\!-,\.-Z\^-\u10FFFF])
COMMENT=(([/-/][\*-\*](([\*-\*]*[\u0001-\)\+-\.0-\u10FFFF])|[/-/])*[\*-\*]+[/-/])|([/-/][/-/][\u0001-\u0009\u000B-\u000C\u000E-\u10FFFF]*[\u000A-\u000A\u000D-\u000D]))
WHITESPACES=[\u0009-\u000A\u000C-\u000D\u0020-\u0020]+
LETTERORDIGITS=([\$-\$A-Z_-_a-z]([\$-\$0-9A-Z_-_a-z]|[\$-\$A-Z_-_a-z])*)

%%

<YYINITIAL> {
(regex)	{ return IGGYTokenTypes.KEYWORD; }
(offside)	{ return IGGYTokenTypes.KEYWORD; }
(align)	{ return IGGYTokenTypes.KEYWORD; }
(ignore)	{ return IGGYTokenTypes.KEYWORD; }
(left)	{ return IGGYTokenTypes.KEYWORD; }
(non\-assoc)	{ return IGGYTokenTypes.KEYWORD; }
(right)	{ return IGGYTokenTypes.KEYWORD; }
(var)	{ return IGGYTokenTypes.KEYWORD; }
{CHAR} 	{ return IGGYTokenTypes.CHAR; }
{STRING} 	{ return IGGYTokenTypes.STRING; }
{NUMBER} 	{ return IGGYTokenTypes.NUMBER; }
{RANGECHAR} 	{ return IGGYTokenTypes.RANGECHAR; }
{COMMENT} 	{ return IGGYTokenTypes.COMMENT; }
{WHITESPACES} 	{ return IGGYTokenTypes.WHITESPACES; }
{LETTERORDIGITS} 	{ return IGGYTokenTypes.LETTERORDIGITS; }
(offside)	{ return IGGYTokenTypes.TERMINAL; }
(var)	{ return IGGYTokenTypes.TERMINAL; }
(align)	{ return IGGYTokenTypes.TERMINAL; }
(right)	{ return IGGYTokenTypes.TERMINAL; }
(ignore)	{ return IGGYTokenTypes.TERMINAL; }
(non\-assoc)	{ return IGGYTokenTypes.TERMINAL; }
(regex)	{ return IGGYTokenTypes.TERMINAL; }
(left)	{ return IGGYTokenTypes.TERMINAL; }
[\*]	{ return IGGYTokenTypes.TERMINAL; }
[\(]	{ return IGGYTokenTypes.OPEN_PARENTHESIS; }
[\)]	{ return IGGYTokenTypes.CLOSE_PARENTHESIS; }
[\?]	{ return IGGYTokenTypes.TERMINAL; }
[\+]	{ return IGGYTokenTypes.OPERATOR; }
[\|]	{ return IGGYTokenTypes.OPERATOR; }
(\.r)	{ return IGGYTokenTypes.TERMINAL; }
(\.yield)	{ return IGGYTokenTypes.TERMINAL; }
(\.l)	{ return IGGYTokenTypes.TERMINAL; }
(&&)	{ return IGGYTokenTypes.TERMINAL; }
(\|\|)	{ return IGGYTokenTypes.TERMINAL; }
(\!\=)	{ return IGGYTokenTypes.TERMINAL; }
(\=\=)	{ return IGGYTokenTypes.TERMINAL; }
(<\=)	{ return IGGYTokenTypes.TERMINAL; }
(>\=)	{ return IGGYTokenTypes.TERMINAL; }
[>]	{ return IGGYTokenTypes.TERMINAL; }
[<]	{ return IGGYTokenTypes.TERMINAL; }
[\-]	{ return IGGYTokenTypes.OPERATOR; }
[/]	{ return IGGYTokenTypes.OPERATOR; }
[\!]	{ return IGGYTokenTypes.TERMINAL; }
[\{]	{ return IGGYTokenTypes.OPEN_BRACE; }
[\}]	{ return IGGYTokenTypes.CLOSE_BRACE; }
[\\]	{ return IGGYTokenTypes.TERMINAL; }
(\!>>)	{ return IGGYTokenTypes.TERMINAL; }
(>>)	{ return IGGYTokenTypes.TERMINAL; }
[\[]	{ return IGGYTokenTypes.OPEN_BRACKET; }
[,]	{ return IGGYTokenTypes.TERMINAL; }
[\]]	{ return IGGYTokenTypes.CLOSE_BRACKET; }
(<<)	{ return IGGYTokenTypes.TERMINAL; }
[:]	{ return IGGYTokenTypes.TERMINAL; }
(\!<<)	{ return IGGYTokenTypes.TERMINAL; }
[\=]	{ return IGGYTokenTypes.TERMINAL; }
(::\=)	{ return IGGYTokenTypes.TERMINAL; }
(@NoLayout)	{ return IGGYTokenTypes.TERMINAL; }
(@Layout)	{ return IGGYTokenTypes.TERMINAL; }
(\[\^)	{ return IGGYTokenTypes.TERMINAL; }
[^]	 { return IGGYTokenTypes.BAD_CHARACTER; }
}


