/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.consulta;

import org.apache.commons.lang.exception.NestableException;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public class ConsultaNaoEncontradoException extends NestableException {
	public ConsultaNaoEncontradoException(String msg){
		super(msg);
	}
	public ConsultaNaoEncontradoException(Throwable t){
		super(t);
	}
	public ConsultaNaoEncontradoException(String msg, Throwable t){
		super(msg, t);
	}
}
