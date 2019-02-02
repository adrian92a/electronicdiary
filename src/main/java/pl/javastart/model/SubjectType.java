package pl.javastart.model;
import java.util.Arrays;
public enum SubjectType {
	matematyka,
	polski;

	private String polishName;

    public String getName() {
		return polishName;
	}

	public void setName(String polishName) {
		this.polishName = polishName;
	}



}
