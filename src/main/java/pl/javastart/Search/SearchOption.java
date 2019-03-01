package pl.javastart.Search;

public class SearchOption {

    private Integer option;
    private String optionName;

    public SearchOption() {

    }
    public SearchOption(Integer option, String optionName) {
        this.option = option;
        this.optionName = optionName;
    }
    public Integer getOption() {
        return option;
    }
    public String getOptionName() {
        return optionName;
    }
    public void setOption(Integer option) {
        this.option = option;
    }
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public boolean isSelected(Integer pupilId){
        if (pupilId != null) {
            return pupilId.equals(option);
        }
        return false;
    }
}