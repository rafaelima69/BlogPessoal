package org.generatios.blogpessoal.seguranca;

import org.generatios.blogpessoal.model.Usuario;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	public UserDetailsImpl(Usuario user) {
		this.userName = user.getUsuario();
		this.password = user.getSenha();
		}
	public UserDetailsImpl() {}

}
