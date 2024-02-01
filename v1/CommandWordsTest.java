package v1;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

/**
 * Classe-test CommandWordsTest.
 *
 * @author  (votre nom)
 * @version (un numÃ©ro de version ou une date)
 *
 * Les classes-test sont documentÃ©es ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basÃ©es sur le document Å  2002 Robert A. Ballance intitulÃ©
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associÃ©s aux classes Ã  tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le mÄ™me paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque mÃ©thode Test Ã  exÃ©cuter.  Il peut y avoir
 * plus d'une mÃ©thode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ dÃ©couvrira automatiquement (par introspection) les mÃ©thodes
 * Test de votre classe Test et gÃ©nÃ©rera la TestSuite consÃ©quente.
 * Chaque appel d'une mÃ©thode Test sera prÃ©cÃ©dÃ© d'un appel de setUp(),
 * qui rÃ©alise les engagements, et suivi d'un appel Ã  tearDown(), qui les
 * dÃ©truit.
 */
public class CommandWordsTest
{
    private static String                   sClassName;
    private static String                   sPkg;
    private static String                   sFil;
    private static veref.ClassContent       sCla;
    private static String                   sAttName;
    private static String                   sAttType;
    private static veref.FieldContent       sAtt;
    private static String                   sProtoC;
    private static veref.ConstructorContent sCon;
    private static String                   sMetName;
    private static String                   sMetRT;
    private static String                   sProtoM;
    private static veref.MethodContent      sMet;
    private static int                      sStep=1;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Class vClasse = CommandWords.class;
        sPkg          = vClasse.getPackage().getName();
        sClassName    = vClasse.getSimpleName();
        veref.ClassContent.setRefPkg( sPkg );
        sFil = sPkg + "/" + sClassName + ".java";

        sAttName = "aValidCommands";
        sAttType = "String[]";

        sProtoC = "()";
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testClasse_1_1()
    {
        sCla = veref.V.getVClaFName( sClassName );
    } // testClasse_1()

    @Test
    public void testAttribut_2()
    {
        testClasse_1_1();
        //         veref.V.verifNbAttOp( vCla, "==", 1 );
        //         veref.FieldContent vAtt = veref.V.getAttFType( vCla, "String" );
        //         veref.V.failIfNot();
        //         veref.V.verifModAttribut( vAtt, "private", "static final" );
        //         veref.V.verifNomAttribut( vAtt );
        //         veref.V.vrai( vAttName.equals( vAtt.fieldName() ), "$n n'est pas le nom attendu pour l'attribut" );
        //         veref.V.mesIfNot();
        veref.V.vrai( veref.V.nbAtt( sCla ) >= 1 , "Aucun attribut ???" );
        veref.V.failIfNot();
        veref.V.vrai( veref.V.nbAtt( sCla ) <= 1 , "Trop d'attributs ???" );
        veref.V.failIfNot();
        veref.FieldContent vAtt = veref.V.getAttFName( sCla, sAttName );
        assertEquals( "Mauvais nom d'attribut !?", sAttName, vAtt.fieldName() );
        assertEquals(  "Mauvais type d'attribut !?", sAttType, vAtt.fieldType() );
        veref.V.verifModAttribut( vAtt, "private final", "" );
        veref.V.failIfNot();      

        try {
            Field vF = Class.forName( sPkg+"."+sClassName ).getDeclaredField(sAttName);
            vF.setAccessible( true );
            sCon = veref.V.premierConstructeur( sCla );
            Object vIns = sCon.newInstance( new Object[]{ } );
            String[] vCW = (String[])(vF.get(vIns));
            assertEquals( "Mauvais nombre de commandes !?", 3, vCW.length );
            String vW = "|"+vCW[0]+"|"+vCW[1]+"|"+vCW[2]+"|";
            veref.V.vrai( vW.contains("|go|") && vW.contains("|help|") && vW.contains("|quit|"),
                "pas les commandes de l'Ã©noncÃ© ???" );
            veref.V.failIfNot();
        } catch( final Exception pE ) {
            fail( "quelque chose a"
                + " genere l'exception " + pE );
        } // t/c
    } // testAttribut_2()

    @Test
    public void testConstructeur_3()
    {
        testAttribut_2();
        //         veref.V.verifDefCon( vCla, "F" );
        //         veref.V.verifConNbP( vCla, 1, "T" );
        //         veref.ConstructorContent vCon = veref.V.getConFProto( vCla, vProtoC, "T" );
        //         veref.V.verifModCon( vCon, "public", "static final" );
        //veref.V.sDefCo = veref.V.hasCoDebug( sFil, sClassName, "public", false );
        //veref.V.verifDefCon( sCla, "T" );
        //sCon = veref.V.premierConstructeur( sCla );
        veref.V.vrai( sCon.getNbParameters()==0, "Le constructeur n'a pas le bon nombre de parametres !" );
        veref.V.failIfNot();
        veref.V.verifModCon( sCon, "public", "static final" );
        veref.V.vrai( veref.V.nbCon( sCla ) <= 1 , "Il y a au moins un constructeur de trop ..." );
        veref.V.failIfNot();
    } // testConstructeur_3()

    @Test
    public void testisCommand_4()
    {
        testConstructeur_3();
        sMetName = "isCommand";
        sMetRT   = "boolean";
        sProtoM  = "( String p1 )";
        //         veref.V.verifMet( vCla, vMetName, "T" );
        //         veref.V.verifMetRT( vCla, vMetName, vMetRT, "T" );
        //         veref.V.verifMetRTNP( vCla, vMetName, vMetRT, 0, "T" );
        //         veref.MethodContent vMet = veref.V.getMetFProto( vCla, vMetName, vMetRT, vProtoM, "T" );
        //         veref.V.verifModMet( vMet, "public", "static final" );
        sMet = veref.V.getVMetFProto( sCla, sMetName, sMetRT, sProtoM, "public" );
        //         veref.V.verifFinal( sFil, vMetName, vProtoM ); // inutile pour 0 param

        try {
            Object vIns = sCon.newInstance( new Object[]{ } );
            CommandWords vCW = (CommandWords)vIns;
            sMet = veref.V.getVMetFProto( sCla, sMetName, sMetRT, sProtoM, "public" );
            veref.V.vrai( veref.V.nbMet( sCla ) <= 1 , "Il y a au moins une methode de trop ..." );
            veref.V.mesIfNot(); 
            boolean vRes = (Boolean)(sMet.invoke( vCW, new Object[]{ "go" } ));
            veref.V.vrai( vRes, "go n'est pas reconnue ???" );
            vRes = (Boolean)(sMet.invoke( vCW, new Object[]{ "help" } ));
            veref.V.vrai( vRes, "help n'est pas reconnue ???" );
            vRes = (Boolean)(sMet.invoke( vCW, new Object[]{ "quit" } ));
            veref.V.vrai( vRes, "quit n'est pas reconnue ???" );
            vRes = (Boolean)(sMet.invoke( vCW, new Object[]{ "xyz" } ));
            veref.V.vrai( vRes, "xyz est reconnue comme commande valide ???" );
        } catch( final Exception pE ) {
            fail( "T:la methode " + sMet.getName() /*+ sMet.getParameterString()*/
                + " genere l'exception " + pE );
        } // t/c        
    } // testisCommand_4()
} // CommanWordsTest