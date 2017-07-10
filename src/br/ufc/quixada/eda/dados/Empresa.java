package br.ufc.quixada.eda.dados;


public class Empresa implements Comparable<Empresa>{
	
	private String nome;
	private String cnpj;
	private String inscricao_est;
	private String data_de_abertura;
	private String site;
	private String email;
	private String cep;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String celular;
	private String chave;
	
	public Empresa(String nome, String cnpj, String inscricao_est, String data_de_abertura, String site, String email, String cep, String rua, String numero, String bairro, String cidade, String estado, String telefone, String celular){
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricao_est = inscricao_est;
		this.data_de_abertura = data_de_abertura;
		this.site= site;
		this.email = email;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.celular = celular;
		this.chave = getEmail();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricao_est() {
		return inscricao_est;
	}
	public void setInscricao_est(String inscricao_est) {
		this.inscricao_est = inscricao_est;
	}
	public String getData_de_abertura() {
		return data_de_abertura;
	}
	public void setData_de_abertura(String data_de_abertura) {
		this.data_de_abertura = data_de_abertura;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	@Override
	public int compareTo(Empresa o) {
		int cmp = chave.compareTo(o.getChave());
		if(cmp > 0) return 1;
		else if(cmp < 0) return -1;
		return 0;
	}
}
