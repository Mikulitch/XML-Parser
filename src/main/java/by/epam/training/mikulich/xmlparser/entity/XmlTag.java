package by.epam.training.mikulich.xmlparser.entity;
public enum XmlTag {
    GEMS("gems"),
    ID("id"),
    NAME("name"),
    GEM("gem"),
    PRECIOUSNESS("preciousness"),
    ORIGIN("origin"),
    VISUALPARAMETRS("visualParameters"),
    COLOR("color"),
    TRANSPARENCY("transparency"),
    FACETS("facets"),
    VALUE("value");
   

    private String value;
    XmlTag(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
