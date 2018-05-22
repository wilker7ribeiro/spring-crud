package com.estudos.java.springbootapp.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2344835723845202045L;

	public ResourceNotFoundException(String mensagem) {
		super(mensagem);
	}
}
