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


NUMBER=(([1-9][0-9]*)|[0-0])
IDENTIFIER=([\$-\$A-Z_-_a-z]([\$-\$0-9A-Z_-_a-z]|[\$-\$A-Z_-_a-z])*)
LETTERORDIGIT=[\$-\$0-9A-Z_-_a-z]
COMMENT=(([/-/][\*-\*](([\*-\*]*[\u0001-\)\+-\.0-\u10FFFF])|[/-/])*[\*-\*]+[/-/])|([/-/][/-/][\u0001-\u0009\u000B-\u000C\u000E-\u10FFFF]*[\u000A-\u000A\u000D-\u000D]))
WHITESPACE=[\u0009-\u000A\u000C-\u000D\u0020-\u0020]

%%

<YYINITIAL> {
{NUMBER} 	{ return IGGYTokenTypes.NUMBER; }
{IDENTIFIER} 	{ return IGGYTokenTypes.IDENTIFIER; }
{LETTERORDIGIT} 	{ return IGGYTokenTypes.LETTERORDIGIT; }
{COMMENT} 	{ return IGGYTokenTypes.COMMENT; }
{WHITESPACE} 	{ return IGGYTokenTypes.WHITESPACE; }
[\{]	{ return IGGYTokenTypes.OPEN_BRACE; }
[\}]	{ return IGGYTokenTypes.CLOSE_BRACE; }
[\=]	{ return IGGYTokenTypes.CHARACTER; }
(&&)	{ return IGGYTokenTypes.CHARACTER; }
(\|\|)	{ return IGGYTokenTypes.CHARACTER; }
[\(]	{ return IGGYTokenTypes.OPEN_PARENTHESIS; }
[\)]	{ return IGGYTokenTypes.CLOSE_PARENTHESIS; }
(\!\=)	{ return IGGYTokenTypes.CHARACTER; }
(\=\=)	{ return IGGYTokenTypes.CHARACTER; }
(<\=)	{ return IGGYTokenTypes.CHARACTER; }
(>\=)	{ return IGGYTokenTypes.CHARACTER; }
[>]	{ return IGGYTokenTypes.CHARACTER; }
[<]	{ return IGGYTokenTypes.CHARACTER; }
[\+]	{ return IGGYTokenTypes.OPERATOR; }
[\-]	{ return IGGYTokenTypes.OPERATOR; }
[/]	{ return IGGYTokenTypes.OPERATOR; }
[\*]	{ return IGGYTokenTypes.CHARACTER; }
[,]	{ return IGGYTokenTypes.CHARACTER; }
[:]	{ return IGGYTokenTypes.CHARACTER; }
[\[]	{ return IGGYTokenTypes.OPEN_BRACKET; }
[\]]	{ return IGGYTokenTypes.CLOSE_BRACKET; }
[\"]	{ return IGGYTokenTypes.CHARACTER; }
[']	{ return IGGYTokenTypes.CHARACTER; }
[^]	 { return IGGYTokenTypes.BAD_CHARACTER; }
}


