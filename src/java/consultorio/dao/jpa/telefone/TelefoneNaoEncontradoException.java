/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.telefone;

import org.apache.commons.lang.exception.NestableException;

/**
 *
 * @author Jessica Silveira/ Jpyce Miyazato/ Felipe Figoli
 */
public class TelefoneNaoEncontradoException extends NestableException {
	public TelefoneNaoEncontradoException(String msg){
		super(msg);
	}
	public TelefoneNaoEncontradoException(Throwable t){
		super(t);
	}
	public TelefoneNaoEncontradoException(String msg, Throwable t){
		super(msg, t);
	}
}