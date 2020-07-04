package census.query.dto.util;

public class LanguageObject {
	private String de;
	private String en;
	private String es;
	private String fr;
	private String it;
	private String tr;
	
	
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	public String getEs() {
		return es;
	}
	public void setEs(String es) {
		this.es = es;
	}
	public String getFr() {
		return fr;
	}
	public void setFr(String fr) {
		this.fr = fr;
	}
	public String getIt() {
		return it;
	}
	public void setIt(String it) {
		this.it = it;
	}
	public String getTr() {
		return tr;
	}
	public void setTr(String tr) {
		this.tr = tr;
	}
	@Override
	public String toString() {
		return "Name [de=" + de + ", en=" + en + ", es=" + es + ", fr=" + fr + ", it=" + it + ", tr=" + tr + "]";
	}
	
	
}