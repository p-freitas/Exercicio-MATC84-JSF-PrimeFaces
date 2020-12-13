package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Bebida;
import service.BebidaService;

@ManagedBean(name = "cadastrarBebida")
@SessionScoped
public class CadastrarBebidaBean {
	
	private Bebida bebida;
	private FacesMessage mensagem = null;
	private FacesContext context = null;
	
	public void init() {
			this.bebida = new Bebida();
			if (mensagem != null) {
				context = FacesContext.getCurrentInstance();
				context.addMessage("messages", mensagem);
			}
	}

	public String salvar() {
		String str = "consultarBebidas";

        try {
            BebidaService.salvarBebida(this.bebida);
            System.out.println(this.bebida.toString());
            this.mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! ", "Bebida salva!.");
            this.LimparBebida();
        } catch (Exception ex) {
            this.mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", ex.getMessage() + "\nContact admin.");
            str = "cadastrarBebida";
        } finally {
            FacesContext.getCurrentInstance().addMessage("mensagens", this.mensagem);
            this.mensagem = null;
            this.context = null;
        }

        return str;
	}
	
	public void LimparBebida() {
        this.bebida.setDescricao("");
        this.bebida.setMarca("");
        this.bebida.setValorUnitario(0.0);
        this.bebida.setLote(null);
        this.bebida.setQtdEstoque(null);
        this.bebida.setId(null);
    }

	public Bebida getBebida() {
		return this.bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
}
