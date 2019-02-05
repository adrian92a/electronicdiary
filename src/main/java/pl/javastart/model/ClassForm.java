package pl.javastart.model;

public class ClassForm {
	
	
	  private String fullName;
	    private Integer classId;
	 
	    public ClassForm() {
			super();
		}

		public ClassForm(String fullName, Integer classId) {
			super();
			this.fullName = fullName;
			this.classId = classId;
		}

		public String getFullName() {
	        return fullName;
	    }
	 
	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }
	 
	    public Integer getCountryId() {
	        return classId;
	    }
	 
	    public void setCountryId(Integer classId) {
	        this.classId = classId;
	    }
}
