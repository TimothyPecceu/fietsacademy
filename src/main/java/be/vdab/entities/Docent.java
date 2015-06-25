package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import be.vdab.enums.Geslacht;

@Entity
@Table(name="docenten")
public class Docent implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String voornaam;
	private String familienaam;
	private BigDecimal wedde;
	private long rijksRegisterNr;
	@Enumerated(EnumType.STRING)
	private Geslacht geslacht;
	
	public Docent(String voornaam, String familienaam, BigDecimal wedde, Geslacht geslacht, long rijksRegisterNr){
		setVoornaam(voornaam);
		setFamilienaam(familienaam);
		setWedde(wedde);
		setGeslacht(geslacht);
		setRijksRegisterNr(rijksRegisterNr);
	}
	
	protected Docent(){}
	
	public static boolean isVoornaamValid(String voornaam){
		return voornaam != null && ! voornaam.isEmpty();
	}
	
	public static boolean isFamilienaamValid(String familienaam){
		return familienaam != null && ! familienaam.isEmpty();
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	public void setWedde(BigDecimal wedde) {
		this.wedde = wedde;
	}

	public void setRijksRegisterNr(long rijksRegisterNr) {
		this.rijksRegisterNr = rijksRegisterNr;
	}

	public void setGeslacht(Geslacht geslacht) {
		this.geslacht = geslacht;
	}
	
	public long getId() {
		return id;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public String getFamilienaam() {
		return familienaam;
	}
	public BigDecimal getWedde() {
		return wedde;
	}
	public long getRijksRegisterNr() {
		return rijksRegisterNr;
	}
	
	public Geslacht getGeslacht() {
		return geslacht;
	}
	public String getNaam(){
		return voornaam + ' ' + familienaam;
	}
	
}
