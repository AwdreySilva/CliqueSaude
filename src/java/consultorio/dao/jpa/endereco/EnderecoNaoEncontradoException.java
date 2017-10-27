/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.endereco;

import org.apache.commons.lang.exception.NestableException;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public class EnderecoNaoEncontradoException extends NestableException {
	public EnderecoNaoEncontradoException(String msg){
		super(msg);
	}
	public EnderecoNaoEncontradoException(Throwable t){
		super(t);
	}
	public EnderecoNaoEncontradoException(String msg, Throwable t){
		super(msg, t);
	}
}