package pl.javastart.model;
import java.util.Arrays;
public enum SubjectType {
	Matematyka,
	Polski;

	private String polishName;

    public String getName() {
		return polishName;
	}

	public void setName(String polishName) {
		this.polishName = polishName;
	}



}
