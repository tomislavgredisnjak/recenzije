package hr.tis.recenzije.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeRateResponseObject {
	
	@JsonProperty("broj_tecajnice")
	private String brojTecajnice;

	@JsonProperty("datum_primjene")
	private String datumPrimjene;

	@JsonProperty("drzava")
	private String drzava;

	@JsonProperty("drzava_iso")
	private String drzavaIso;

	@JsonProperty("kupovni_tecaj")
	private String kupovniTecaj;

	@JsonProperty("prodajni_tecaj")
	private String prodajniTecaj;

	@JsonProperty("sifra_valute")
	private String sifraValute;

	@JsonProperty("srednji_tecaj")
	private String srednjiTecaj;

	@JsonProperty("valuta")
	private String valuta;

	public String getBrojTecajnice() {
		return brojTecajnice;
	}

	public void setBrojTecajnice(String brojTecajnice) {
		this.brojTecajnice = brojTecajnice;
	}

	public String getDatumPrimjene() {
		return datumPrimjene;
	}

	public void setDatumPrimjene(String datumPrimjene) {
		this.datumPrimjene = datumPrimjene;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getDrzavaIso() {
		return drzavaIso;
	}

	public void setDrzavaIso(String drzavaIso) {
		this.drzavaIso = drzavaIso;
	}

	public String getKupovniTecaj() {
		return kupovniTecaj;
	}

	public void setKupovniTecaj(String kupovniTecaj) {
		this.kupovniTecaj = kupovniTecaj;
	}

	public String getProdajniTecaj() {
		return prodajniTecaj;
	}

	public void setProdajniTecaj(String prodajniTecaj) {
		this.prodajniTecaj = prodajniTecaj;
	}

	public String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public String getSrednjiTecaj() {
		return srednjiTecaj;
	}

	public void setSrednjiTecaj(String srednjiTecaj) {
		this.srednjiTecaj = srednjiTecaj;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

}
