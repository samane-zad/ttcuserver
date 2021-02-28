package ac.ttcu.common;

public enum Universities {
    SHARIATY_TECHNICAL_COLLEGE("دانشکده دخترانه شریعتی"),
    VALIASR_TECHNICAL_COLLEGE("دانشکده دخترانه ولیعصر(عج)"),
    ENGHELAB_TECHNICAL_COLLEGE("دانشکده پسرانه انقلاب اسلامی"),
    SHAMSIPOUR_TECHNICAL_COLLEGE("دانشکده پسران شمسی پور");

   public final String Universities;

    private Universities(String universities) {
        Universities = universities;
    }
}
