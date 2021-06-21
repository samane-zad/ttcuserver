package ac.ttcu.common.enumerations;

public enum Majors {
    SOFTWARE("مهندسی نرم افزار"),
    ELECTRONICS("برق و الکترونیک"),
    MECHANICS("مکانیک"),
    ICT("مخابرات"),
    ARCHITECTURE("معماری و نقشه کشی"),
    GRAPHICS("هنر و گرافیک"),
    ACCOUNTING("حسابداری"),
    CLOTHING_DESIGN("طراحی دوخت"),
    PHYSICAL_EDUCATION("طراحی دوخت"),
    IT("فناوری اطلاعات");
    public final String Majors;

   private Majors(String majors) {
        Majors = majors;
    }
}
