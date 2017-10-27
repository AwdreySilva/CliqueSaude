/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.cliente;

import org.apache.commons.lang.exception.NestableException;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public class ClienteNaoEncontradoException extends NestableException {
	public ClienteNaoEncontradoException(String msg){
		super(msg);
	}
	public ClienteNaoEncontradoException(Throwable t){
		super(t);
	}
	public ClienteNaoEncontradoException(String msg, Throwable t){
		super(msg, t);
	}
}

