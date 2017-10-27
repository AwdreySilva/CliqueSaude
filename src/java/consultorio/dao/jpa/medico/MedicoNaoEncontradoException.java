/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.medico;

import org.apache.commons.lang.exception.NestableException;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public class MedicoNaoEncontradoException extends NestableException {
	public MedicoNaoEncontradoException(String msg){
		super(msg);
	}
	public MedicoNaoEncontradoException(Throwable t){
		super(t);
	}
	public MedicoNaoEncontradoException(String msg, Throwable t){
		super(msg, t);
	}
}
