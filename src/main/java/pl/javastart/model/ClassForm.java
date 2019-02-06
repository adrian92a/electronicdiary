package pl.javastart.model;

public class ClassForm {
	
	
	  private String fullName;
	    private Integer lessonId;
	 
	    public ClassForm() {
			super();
		}

		public ClassForm(String fullName, Integer lessonId) {
			super();
			this.fullName = fullName;
			this.lessonId = lessonId;
		}

		public String getFullName() {
	        return fullName;
	    }
	 
	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }
	 
	    public Integer getCountryId() {
	        return lessonId;
	    }
	 
	    public void setCountryId(Integer lessonId) {
	        this.lessonId = lessonId;
	    }
}
