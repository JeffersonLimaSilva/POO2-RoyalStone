package br.com.royalstone.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails; // Importe UserDetails
import java.util.Collection;
import java.util.Collections; // Para Collections.singletonList

@Entity
@Table(name = "pessoa") 
public class Pessoa implements UserDetails { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String dataNasc; 
	private String telefone;
	private String email;
	private String senha;
	
	@Embedded
	private Endereco endereco;
	
	private String role; // Ex: "ADMIN", "CLIENTE"

    // --- MÉTODOS GETTERS E SETTERS ---
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

    // --- IMPLEMENTAÇÃO DOS MÉTODOS DE USERDETAILS (ADICIONE ESTES) ---

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Converte a String 'role' para uma coleção de GrantedAuthority
        // O Spring Security espera que os roles tenham o prefixo "ROLE_"
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.role));
    }

    @Override
    public String getPassword() {
        // Retorna a senha armazenada na entidade
        return this.senha;
    }

    @Override
    public String getUsername() {
        // Retorna o email como o nome de usuário para o Spring Security
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Retorna true para indicar que a conta não está expirada
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Retorna true para indicar que a conta não está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Retorna true para indicar que as credenciais (senha) não expiraram
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Retorna true para indicar que o usuário está habilitado
        return true;
    }
}