/* Generated By:JavaCC: Do not edit this line. VerificadorSintaxe.java */
package Compilador;

public class VerificadorSintaxe implements VerificadorSintaxeConstants {
  public static void main(String [] args)
  {
    try
    {
      String programa = ReadFile.Read("src/codigo.txt");
      new VerificadorSintaxe(new java.io.StringReader(programa)).INICIO();
      System.out.println("\u005cn\u005cnA sintaxe esta correta!");
    }
    catch (Throwable e)
    {
      System.out.println("\u005cn\u005cnErro na sintaxe: " + e.getMessage());
    }
  }

/* 
* Gramatica da linguagem - Java
*/
  static final public void INICIO() throws ParseException {
    Programa();
  }

  static final public void Programa() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PACKAGE:
      DeclaracaoPacote();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IMPORT:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      DeclaracaoImport();
    }
    DeclaracaoClasse();
  }

  static final public void DeclaracaoPacote() throws ParseException {
    jj_consume_token(PACKAGE);
    jj_consume_token(IDENTIFICADOR);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PONTO:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      DeclaracaoEstendida();
    }
    jj_consume_token(PONTO_VIRGULA);
  }

  static final public void DeclaracaoImport() throws ParseException {
    jj_consume_token(IMPORT);
    jj_consume_token(IDENTIFICADOR);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PONTO:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      DeclaracaoEstendida();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PONTO_ASTERISCO:
      jj_consume_token(PONTO_ASTERISCO);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(PONTO_VIRGULA);
  }

  static final public void DeclaracaoEstendida() throws ParseException {
    jj_consume_token(PONTO);
    jj_consume_token(IDENTIFICADOR);
  }

  static final public void DeclaracaoClasse() throws ParseException {
    Modificador();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FINAL:
      jj_consume_token(FINAL);
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    jj_consume_token(CLASS);
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(AC);
    CorpoClasse();
    jj_consume_token(FC);
  }

  static final public void CorpoClasse() throws ParseException {
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case FLOAT:
      case STRING:
      case CHAR:
      case BOOLEAN:
      case VOID:
      case STATIC:
      case PUBLIC:
      case PROTECTED:
      case PRIVATE:
      case FINAL:
      case IDENTIFICADOR:
      case 74:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case FLOAT:
      case STRING:
      case CHAR:
      case BOOLEAN:
      case VOID:
      case STATIC:
      case PUBLIC:
      case PROTECTED:
      case PRIVATE:
      case FINAL:
      case IDENTIFICADOR:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PUBLIC:
        case PROTECTED:
        case PRIVATE:
          Modificador();
          break;
        default:
          jj_la1[7] = jj_gen;
          ;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INT:
        case FLOAT:
        case STRING:
        case CHAR:
        case BOOLEAN:
        case VOID:
        case STATIC:
        case FINAL:
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case STATIC:
            jj_consume_token(STATIC);
            break;
          default:
            jj_la1[8] = jj_gen;
            ;
          }
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case FINAL:
            jj_consume_token(FINAL);
            break;
          default:
            jj_la1[9] = jj_gen;
            ;
          }
          TiposDados();
          jj_consume_token(IDENTIFICADOR);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case VIRGULA:
          case PONTO_VIRGULA:
          case ATRIBUICAO:
            DeclaracaoVariavel();
            break;
          case AP:
            DeclaracaoMetodo();
            break;
          default:
            jj_la1[10] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          break;
        case IDENTIFICADOR:
          DeclaracaoConstrutor();
          break;
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      case 74:
        Main();
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Main() throws ParseException {
    jj_consume_token(74);
    jj_consume_token(AP);
    jj_consume_token(STRING);
    jj_consume_token(AB);
    jj_consume_token(FB);
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(FP);
    DeclaracaoBloco();
  }

  static final public void Modificador() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PRIVATE:
      jj_consume_token(PRIVATE);
      break;
    case PROTECTED:
      jj_consume_token(PROTECTED);
      break;
    case PUBLIC:
      jj_consume_token(PUBLIC);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void TiposDados() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    case CHAR:
      jj_consume_token(CHAR);
      break;
    case BOOLEAN:
      jj_consume_token(BOOLEAN);
      break;
    case VOID:
      jj_consume_token(VOID);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void DeclaracaoBloco() throws ParseException {
    jj_consume_token(AC);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WHILE:
      case IF:
      case PRINT:
      case RETURN:
      case INT:
      case FLOAT:
      case STRING:
      case CHAR:
      case BOOLEAN:
      case VOID:
      case AP:
      case NEGACAO:
      case IDENTIFICADOR:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case CHARACTER_LITERAL:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_5;
      }
      DeclaracaoCorpo();
    }
    jj_consume_token(FC);
  }

  static final public void DeclaracaoCorpo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case FLOAT:
    case STRING:
    case CHAR:
    case BOOLEAN:
    case VOID:
      TiposDados();
      jj_consume_token(IDENTIFICADOR);
      DeclaracaoVariavel();
      break;
    case RETURN:
      jj_consume_token(RETURN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NULL:
      case TRUE:
      case FALSE:
      case INT:
      case FLOAT:
      case STRING:
      case CHAR:
      case BOOLEAN:
      case VOID:
      case AP:
      case NEGACAO:
      case IDENTIFICADOR:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case CHARACTER_LITERAL:
        RetornoOpcoes();
        break;
      default:
        jj_la1[16] = jj_gen;
        ;
      }
      jj_consume_token(PONTO_VIRGULA);
      break;
    case IF:
      IfElse();
      break;
    case PRINT:
      Print();
      break;
    case WHILE:
      While();
      break;
    case AP:
    case NEGACAO:
    case IDENTIFICADOR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case CHARACTER_LITERAL:
      Expressao();
      jj_consume_token(PONTO_VIRGULA);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void DeclaracaoMetodo() throws ParseException {
    jj_consume_token(AP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case FLOAT:
    case STRING:
    case CHAR:
    case BOOLEAN:
    case VOID:
      ListaParametros();
      break;
    default:
      jj_la1[18] = jj_gen;
      ;
    }
    jj_consume_token(FP);
    DeclaracaoBloco();
  }

  static final public void DeclaracaoConstrutor() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(AP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case FLOAT:
    case STRING:
    case CHAR:
    case BOOLEAN:
    case VOID:
      ListaParametros();
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    jj_consume_token(FP);
    DeclaracaoBloco();
  }

  static final public void DeclaracaoVariavel() throws ParseException {
    InicializacaoVariavel();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_6;
      }
      jj_consume_token(VIRGULA);
      jj_consume_token(IDENTIFICADOR);
      InicializacaoVariavel();
    }
    jj_consume_token(PONTO_VIRGULA);
  }

  static final public void InicializacaoVariavel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATRIBUICAO:
      jj_consume_token(ATRIBUICAO);
      InicializacaoOpcoes();
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
  }

  static final public void InicializacaoOpcoes() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AP:
    case NEGACAO:
    case IDENTIFICADOR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case CHARACTER_LITERAL:
      Expressao();
      break;
    case NULL:
      jj_consume_token(NULL);
      break;
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void RetornoOpcoes() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NULL:
    case TRUE:
    case FALSE:
    case AP:
    case NEGACAO:
    case IDENTIFICADOR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case CHARACTER_LITERAL:
      InicializacaoOpcoes();
      break;
    case INT:
    case FLOAT:
    case STRING:
    case CHAR:
    case BOOLEAN:
    case VOID:
      TiposDados();
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void IfElse() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(AP);
    Expressao();
    jj_consume_token(FP);
    DeclaracaoBloco();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      DeclaracaoBloco();
      break;
    default:
      jj_la1[24] = jj_gen;
      ;
    }
  }

  static final public void Print() throws ParseException {
    jj_consume_token(PRINT);
    jj_consume_token(AP);
    Expressao();
    jj_consume_token(FP);
    jj_consume_token(PONTO_VIRGULA);
  }

  static final public void While() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(AP);
    Expressao();
    jj_consume_token(FP);
    DeclaracaoBloco();
  }

  static final public void Expressao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NEGACAO:
      jj_consume_token(NEGACAO);
      break;
    default:
      jj_la1[25] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case CHARACTER_LITERAL:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AP:
        case DECREMENTO:
        case INCREMENTO:
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case AP:
            ChamadaMetodo();
            break;
          case INCREMENTO:
            jj_consume_token(INCREMENTO);
            break;
          case DECREMENTO:
            jj_consume_token(DECREMENTO);
            break;
          default:
            jj_la1[26] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          break;
        default:
          jj_la1[27] = jj_gen;
          ;
        }
        break;
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case CHARACTER_LITERAL:
        ExpressaoLiteral();
        break;
      default:
        jj_la1[28] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SOMA:
      case SUBTRACAO:
      case DIVISAO:
      case MUTIPLICACAO:
      case MODULO:
      case SUBTRACAO_PLUS:
      case SOMA_PLUS:
      case MULTIPLICACAO_PLUS:
      case DIVISAO_PLUS:
      case MODULO_PLUS:
      case MENOR:
      case MAIOR:
      case MAIOR_IGUAL:
      case MENOR_IGUAL:
      case AND:
      case OR:
      case ATRIBUICAO:
      case DIFERENCA:
      case IGUALDADE:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ATRIBUICAO:
          Atribuicao();
          break;
        case AND:
        case OR:
          ComparacaoLogica();
          break;
        case MENOR:
        case MAIOR:
        case MAIOR_IGUAL:
        case MENOR_IGUAL:
        case DIFERENCA:
        case IGUALDADE:
          ComparacaoRelacional();
          break;
        case SOMA:
        case SUBTRACAO:
        case DIVISAO:
        case MUTIPLICACAO:
        case MODULO:
        case SUBTRACAO_PLUS:
        case SOMA_PLUS:
        case MULTIPLICACAO_PLUS:
        case DIVISAO_PLUS:
        case MODULO_PLUS:
          ExpressaoNumerica();
          break;
        default:
          jj_la1[29] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[30] = jj_gen;
        ;
      }
      break;
    case AP:
      jj_consume_token(AP);
      Expressao();
      jj_consume_token(FP);
      break;
    default:
      jj_la1[31] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ChamadaMetodo() throws ParseException {
    jj_consume_token(AP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AP:
    case NEGACAO:
    case IDENTIFICADOR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case CHARACTER_LITERAL:
      ListaArgumentos();
      break;
    default:
      jj_la1[32] = jj_gen;
      ;
    }
    jj_consume_token(FP);
  }

  static final public void ListaArgumentos() throws ParseException {
    Expressao();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[33] = jj_gen;
        break label_7;
      }
      jj_consume_token(VIRGULA);
      Expressao();
    }
  }

  static final public void ListaParametros() throws ParseException {
    Parametro();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[34] = jj_gen;
        break label_8;
      }
      jj_consume_token(VIRGULA);
      Parametro();
    }
  }

  static final public void ExpressaoLiteral() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      jj_consume_token(INTEGER_LITERAL);
      break;
    case FLOATING_POINT_LITERAL:
      jj_consume_token(FLOATING_POINT_LITERAL);
      break;
    case CHARACTER_LITERAL:
      jj_consume_token(CHARACTER_LITERAL);
      break;
    case STRING_LITERAL:
      jj_consume_token(STRING_LITERAL);
      break;
    default:
      jj_la1[35] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Atribuicao() throws ParseException {
    jj_consume_token(ATRIBUICAO);
    Expressao();
  }

  static final public void ComparacaoLogica() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AND:
      jj_consume_token(AND);
      break;
    case OR:
      jj_consume_token(OR);
      break;
    default:
      jj_la1[36] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    Expressao();
  }

  static final public void ComparacaoRelacional() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAIOR:
      jj_consume_token(MAIOR);
      break;
    case MENOR:
      jj_consume_token(MENOR);
      break;
    case MAIOR_IGUAL:
      jj_consume_token(MAIOR_IGUAL);
      break;
    case MENOR_IGUAL:
      jj_consume_token(MENOR_IGUAL);
      break;
    case IGUALDADE:
      jj_consume_token(IGUALDADE);
      break;
    case DIFERENCA:
      jj_consume_token(DIFERENCA);
      break;
    default:
      jj_la1[37] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    Expressao();
  }

  static final public void ExpressaoNumerica() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SOMA:
      jj_consume_token(SOMA);
      break;
    case SOMA_PLUS:
      jj_consume_token(SOMA_PLUS);
      break;
    case SUBTRACAO:
      jj_consume_token(SUBTRACAO);
      break;
    case SUBTRACAO_PLUS:
      jj_consume_token(SUBTRACAO_PLUS);
      break;
    case MUTIPLICACAO:
      jj_consume_token(MUTIPLICACAO);
      break;
    case MULTIPLICACAO_PLUS:
      jj_consume_token(MULTIPLICACAO_PLUS);
      break;
    case DIVISAO:
      jj_consume_token(DIVISAO);
      break;
    case DIVISAO_PLUS:
      jj_consume_token(DIVISAO_PLUS);
      break;
    case MODULO:
      jj_consume_token(MODULO);
      break;
    case MODULO_PLUS:
      jj_consume_token(MODULO_PLUS);
      break;
    default:
      jj_la1[38] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    Expressao();
  }

  static final public void Parametro() throws ParseException {
    TiposDados();
    jj_consume_token(IDENTIFICADOR);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public VerificadorSintaxeTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[39];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2000,0x1000,0x0,0x0,0x0,0x0,0xffc00000,0xe0000000,0x10000000,0x0,0x0,0x1fc00000,0xffc00000,0xe0000000,0xfc00000,0xff18000,0xfcc0800,0xff18000,0xfc00000,0xfc00000,0x0,0x0,0xc0800,0xfcc0800,0x20000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x400,0x400,0x200,0x1,0x1,0x0,0x0,0x1,0x100001a0,0x1,0x1,0x0,0x0,0x8000020,0x8000020,0x8000020,0x0,0x0,0x80,0x10000000,0x8000020,0x8000020,0x0,0x8000000,0x60000020,0x60000020,0x0,0x97fff800,0x97fff800,0x20,0x8000020,0x80,0x80,0x0,0x6000000,0x81e00000,0x1ff800,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x402,0x0,0x0,0x0,0x0,0x2,0x402,0x0,0x0,0x352,0x352,0x352,0x0,0x0,0x0,0x0,0x352,0x352,0x0,0x0,0x0,0x0,0x352,0x1,0x1,0x352,0x352,0x0,0x0,0x350,0x0,0x1,0x0,};
   }

  /** Constructor with InputStream. */
  public VerificadorSintaxe(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public VerificadorSintaxe(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new VerificadorSintaxeTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public VerificadorSintaxe(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new VerificadorSintaxeTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public VerificadorSintaxe(VerificadorSintaxeTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(VerificadorSintaxeTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[75];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 39; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 75; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
