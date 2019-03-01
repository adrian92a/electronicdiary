package pl.javastart.Search;

public class SearchOptionPupils {

    private Integer optionPupil;
    private String optionPupilName;

    public SearchOptionPupils() {

    }

    public SearchOptionPupils(Integer option, String pupilDTO) {
        this.optionPupil = option;
        this.optionPupilName = pupilDTO;
    }

    public Integer getOptionPupil() {
        return optionPupil;
    }

    public void setOptionPupil(Integer optionPupil) {
        this.optionPupil = optionPupil;
    }

    public String getOptionPupilName() {
        return optionPupilName;
    }

    public void setOptionPupilName(String optionPupilName) {
        this.optionPupilName = optionPupilName;
    }

    public boolean isSelected(Integer pupilId){
        if (pupilId != null) {
            return pupilId.equals(optionPupil);
        }
        return false;
    }
}