package de.leonmeister.chinesevocabtrainer.vocabulary;

public class Vocabulary {

    private Long id;
    private String hanzi;
    private String pinyin;
    private String english;
    private Area area;
    private Category category;

    public Vocabulary(Long id, String hanzi, String pinyin, String english, Area area, Category category) {
        this.id = id;
        this.hanzi = hanzi;
        this.pinyin = pinyin;
        this.english = english;
        this.area = area;
        this.category = category;
    }

    public Vocabulary(String hanzi, String pinyin, String english, Area area, Category category) {
        this.hanzi = hanzi;
        this.pinyin = pinyin;
        this.english = english;
        this.area = area;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String hanzi) {
        this.hanzi = hanzi;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", hanzi='" + hanzi + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", english='" + english + '\'' +
                ", area=" + area +
                ", category=" + category +
                '}';
    }
}
