
package eng3.fatec.controle.web.command.impl;

import eng3.fatec.controle.web.command.ICommand;
import eng3.fatec.core.IFachada;
import eng3.fatec.core.impl.controle.Fachada;



public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();

}
