package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * Classe responsável por executar todos as classes de teste de uma vez
 */
@RunWith(Suite.class)
@SuiteClasses({ CriterioRendaFamiliarTeste.class, CriterioNumeroDependentesTeste.class, ListarFamiliasTeste.class })
public class TodosOsTestes {

}
