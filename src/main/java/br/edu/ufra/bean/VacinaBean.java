/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.bean;

import br.edu.ufra.entidade.Animal;
import br.edu.ufra.entidade.Vacina;
import br.edu.ufra.rn.AnimalRN;
import br.edu.ufra.rn.VacinaRN;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fabio
 */
@ManagedBean
@ViewScoped
public class VacinaBean {

    private Animal animal = new Animal();
    private Vacina vacina = new Vacina();

    private final VacinaRN VACINA_RN = new VacinaRN();
    private final AnimalRN ANIMAL_RN = new AnimalRN();

    /**
     * Creates a new instance of VacinaBean
     */
    public VacinaBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        String animalID = currentInstance.getExternalContext().getRequestParameterMap().get("animal");
        if (animalID != null) {
            try {
                int id = Integer.parseInt(animalID);
                animal = ANIMAL_RN.obter(id);
                if (animal == null) {
                    animal = new Animal();
                    FacesMessage fm = new FacesMessage("Aviso", "Não foi recuperar o animal. Código inválido.");
                    fm.setSeverity(FacesMessage.SEVERITY_WARN);
                    currentInstance.addMessage(null, fm);
                }
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage("Erro", "Não foi recuperar o animal");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                currentInstance.addMessage(null, fm);
                animal = new Animal();
            }
        }
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public void adicionar() {
        if (vacina != null) {
            vacina.setAnimal(animal);
            FacesContext currentInstance = FacesContext.getCurrentInstance();
            if (VACINA_RN.salvar(vacina)) {
                FacesMessage fm = new FacesMessage("Sucesso", "Vacina registrada");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                currentInstance.addMessage(null, fm);
                setAnimal(ANIMAL_RN.obter(animal.getId())); //Atualizando o animal
                vacina = new Vacina();
            } else {
                FacesMessage fm = new FacesMessage("Erro", "Não foi possível registrar a vacina");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                currentInstance.addMessage(null, fm);
            }
        }
    }

    public void excluir() {
        if (vacina != null) {
            FacesContext currentInstance = FacesContext.getCurrentInstance();
            if (VACINA_RN.excluir(vacina)) {
                FacesMessage fm = new FacesMessage("Sucesso", "Vacina excluída");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                currentInstance.addMessage(null, fm);
                setAnimal(ANIMAL_RN.obter(animal.getId())); //Atualizando o animal
                vacina = new Vacina();
            } else {
                FacesMessage fm = new FacesMessage("Erro", "Não foi possível excluir a vacina");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                currentInstance.addMessage(null, fm);
            }
        }
    }

}
