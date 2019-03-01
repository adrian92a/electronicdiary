package pl.javastart.Search;

public class SearchLessonList {

    private Integer lessonList;
    private String optionLessonName;

    public SearchLessonList() {

    }

    public SearchLessonList(Integer option, String pupilDTO) {
        this.lessonList = option;
        this.optionLessonName = pupilDTO;
    }

    public Integer getLessonList() {
        return lessonList;
    }

    public void setLessonList(Integer lessonList) {
        this.lessonList = lessonList;
    }

    public String getOptionLessonName() {
        return optionLessonName;
    }

    public void setOptionLessonName(String optionLessonName) {
        this.optionLessonName = optionLessonName;
    }

    public boolean isSelected(Integer pupilId){
        if (pupilId != null) {
            return pupilId.equals(lessonList);
        }
        return false;
    }
}