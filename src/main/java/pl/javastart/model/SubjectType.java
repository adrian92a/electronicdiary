package pl.javastart.model;

public enum SubjectType {
	matematyka,
	polski,
	historia,
	angielski,
	fizyka,
	muzyka,
	geografia;

	private String polishName;

    public String getName() {
		return polishName;
	}

	public void setName(String polishName) {
		this.polishName = polishName;
	}



}
