/**
 *  日期型的比较： 日期型只能比较 < > >= <= ，不能比较 == 和 != ，因为日期型通常有时分秒，比较容易出问题
 *  函数：
 *  姓名 matches 函数一
 *  函数一： return "AAABBBCCCDDD";
 *  于是执行的时候可以转换成：
 *  def fun1() {return "AAABBBCCCDDD";}
 *  name matches fun1()
 *
 */

grammar CnExpr;

cnExpr
    :   expression EOF
    ;

//表达式
//匹配、包含、起始于
expression
  :  '(' expression ')'                                                                                                     #parens
  |  Identifier                                                                                                             #variable
  |  literal                                                                                                                #constant
  |  expression '(' expressionList? ')'                                                                                     #execFn
  |  expression op=('matches'|'\u5339\u914d') expression                                                                    #matches
  |  expression op=('contains'|'\u5305\u542b') expression                                                                   #contains
  |  expression op=('startsWith'|'\u8d77\u59cb\u4e8e'|'\u5f00\u59cb\u4e8e') expression                                      #startsWith
  |  ('!'|'not') expression                                                                                                 #not
  |  op=('+'|'-') expression                                                                                                #positiveAndNegative
  |  expression op=('*'|'/') expression                                                                                     #mulDiv
  |  expression op=('+'|'-') expression                                                                                     #addSub
  |  expression op=('<='|'>='|'>'|'<') expression                                                                           #greatLess
  |  expression op=('in'|'\u5c5e\u4e8e') (Identifier | literalArray | stringOrIdentifierArray | decimalOrIdentifierArray)   #in
  |  expression op=('=='|'!=') expression                                                                                   #equalUnequal
  |  expression op=('&&'|'\u5e76\u4e14') expression                                                                         #and
  |  expression op=('||'|'\u6216\u8005') expression                                                                         #or
  ;

expressionList
    :   expression (',' expression)*
    ;

stringOrIdentifierArray
  :  '[' stringOrIdentifier (',' stringOrIdentifier)* ']'
  ;

decimalOrIdentifierArray
  :  '[' decimalOrIdentifier (',' decimalOrIdentifier)* ']'
  ;

stringOrIdentifier
  :  Identifier | StringLiteral
  ;

decimalOrIdentifier
  :  Identifier | DecimalLiteral | FloatingPointLiteral
  ;

//定义数组
literalArray
  :  stringArray | decimalArray
  ;

//字符串数组
stringArray
  :  '[' StringLiteral (',' StringLiteral)* ']'
  ;

literal
  :  (StringLiteral | DecimalLiteral | FloatingPointLiteral)
  ;

//数字数组
decimalArray
  :  '[' (DecimalLiteral | FloatingPointLiteral) (',' (DecimalLiteral | FloatingPointLiteral))* ']'
  ;

//------------------------------------Lexer------------------------------------------//
//数字，0或者非0开始的数字
DecimalLiteral
  : ('0' | '1'..'9' '0'..'9'*)
//  : ('+' | '-')? ('0' | '1'..'9' '0'..'9'*)
  ;

//有小数点的数字
FloatingPointLiteral
//  : ('+' | '-')? DecimalLiteral '.' ('0'..'9') +
  : DecimalLiteral '.' ('0'..'9') +
  ;

//字符串
StringLiteral
  :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
  ;

//转码
fragment
EscapeSequence
  :  '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
  ;

//标识符，字母开始
Identifier
    :   Letter (Letter|IDDigit)*
    ;

fragment
Letter
  :  '\u0024' |
     '\u0041'..'\u005a' |
     '\u005f' |
     '\u0061'..'\u007a' |
     '\u00c0'..'\u00d6' |
     '\u00d8'..'\u00f6' |
     '\u00f8'..'\u00ff' |
     '\u0100'..'\u1fff' |
     '\u3040'..'\u318f' |
     '\u3300'..'\u337f' |
     '\u3400'..'\u3d2d' |
     '\u4e00'..'\u9fff' |
     '\uf900'..'\ufaff'
  ;

fragment
IDDigit
  :  '\u0030'..'\u0039' |
     '\u0660'..'\u0669' |
     '\u06f0'..'\u06f9' |
     '\u0966'..'\u096f' |
     '\u09e6'..'\u09ef' |
     '\u0a66'..'\u0a6f' |
     '\u0ae6'..'\u0aef' |
     '\u0b66'..'\u0b6f' |
     '\u0be7'..'\u0bef' |
     '\u0c66'..'\u0c6f' |
     '\u0ce6'..'\u0cef' |
     '\u0d66'..'\u0d6f' |
     '\u0e50'..'\u0e59' |
     '\u0ed0'..'\u0ed9' |
     '\u1040'..'\u1049'
  ;

//空白
WS
  :  [ \t\r\n\u000C]+ -> skip
  ;

//注释
COMMENT
  :  '/*' .*? '*/' -> skip
  ;

//行注释
LINE_COMMENT
  :  '//' ~[\r\n]* -> skip
  ;